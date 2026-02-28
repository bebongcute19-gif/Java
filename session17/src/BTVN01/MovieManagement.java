package BTVN01;

import java.sql.*;

public class MovieManagement {

    /* ========== TẠO BẢNG & PROCEDURE ========== */
    public void initDatabase() {
        try (Connection conn = ConnectionDB.getConnection();
             Statement stm = conn.createStatement()) {

            // ===== TẠO BẢNG =====
            stm.execute("""
                CREATE TABLE IF NOT EXISTS movies (
                    id SERIAL PRIMARY KEY,
                    title VARCHAR(100) NOT NULL,
                    director VARCHAR(100) NOT NULL,
                    year INT NOT NULL
                )
            """);

            // ===== add_movie =====
            stm.execute("""
                CREATE OR REPLACE PROCEDURE add_movie(
                    p_title VARCHAR,
                    p_director VARCHAR,
                    p_year INT
                )
                LANGUAGE plpgsql
                AS $$
                BEGIN
                    INSERT INTO movies(title, director, year)
                    VALUES (p_title, p_director, p_year);
                END;
                $$;
            """);

            // ===== update_movie =====
            stm.execute("""
                CREATE OR REPLACE PROCEDURE update_movie(
                    p_id INT,
                    p_title VARCHAR,
                    p_director VARCHAR,
                    p_year INT
                )
                LANGUAGE plpgsql
                AS $$
                BEGIN
                    UPDATE movies
                    SET title = p_title,
                        director = p_director,
                        year = p_year
                    WHERE id = p_id;
                END;
                $$;
            """);

            // ===== delete_movie =====
            stm.execute("""
                CREATE OR REPLACE PROCEDURE delete_movie(p_id INT)
                LANGUAGE plpgsql
                AS $$
                BEGIN
                    DELETE FROM movies WHERE id = p_id;
                END;
                $$;
            """);

            System.out.println("✅ Khởi tạo CSDL PostgreSQL thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== THÊM PHIM ========== */
    public void addMovie(String title, String director, int year) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL add_movie(?,?,?)")) {

            cs.setString(1, title);
            cs.setString(2, director);
            cs.setInt(3, year);
            cs.execute();

            System.out.println("✅ Thêm phim thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== LIỆT KÊ PHIM (SELECT TRỰC TIẾP) ========== */
    public void listMovies() {
        String sql = "SELECT * FROM movies ORDER BY id";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | Title | Director | Year");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("director") + " | " +
                                rs.getInt("year")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== SỬA PHIM ========== */
    public void updateMovie(int id, String title, String director, int year) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL update_movie(?,?,?,?)")) {

            cs.setInt(1, id);
            cs.setString(2, title);
            cs.setString(3, director);
            cs.setInt(4, year);
            cs.execute();

            System.out.println("✅ Cập nhật phim thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== XÓA PHIM ========== */
    public void deleteMovie(int id) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL delete_movie(?)")) {

            cs.setInt(1, id);
            cs.execute();

            System.out.println("✅ Xóa phim thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}