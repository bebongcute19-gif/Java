package BTVN02;

import java.sql.*;

public class TaskManagement {

    /* ========== KHỞI TẠO BẢNG & PROCEDURE ========== */
    public void initDatabase() {
        try (Connection conn = ConnectionDB.getConnection();
             Statement stm = conn.createStatement()) {

            // ===== TẠO BẢNG =====
            stm.execute("""
                        CREATE TABLE IF NOT EXISTS tasks123 (
                            id SERIAL PRIMARY KEY,
                            task_name VARCHAR(200) NOT NULL,
                            status VARCHAR(50) NOT NULL
                        )
                    """);

            // ===== add_task =====
            stm.execute("""
                        CREATE OR REPLACE PROCEDURE add_task(
                            p_task_name VARCHAR,
                            p_status VARCHAR
                        )
                        LANGUAGE plpgsql
                        AS $$
                        BEGIN
                            INSERT INTO tasks123(task_name, status)
                            VALUES (p_task_name, p_status);
                        END;
                        $$;
                    """);

            // ===== update_task_status =====
            stm.execute("""
                        CREATE OR REPLACE PROCEDURE update_task_status(
                            p_id INT,
                            p_status VARCHAR
                        )
                        LANGUAGE plpgsql
                        AS $$
                        BEGIN
                            UPDATE tasks123
                            SET status = p_status
                            WHERE id = p_id;
                        END;
                        $$;
                    """);

            // ===== delete_task =====
//            stm.execute("DROP FUNCTION IF EXISTS delete_task(INT)");

// TẠO PROCEDURE MỚI
            stm.execute("""
                        CREATE OR REPLACE PROCEDURE delete_task(p_id INT)
                        LANGUAGE plpgsql
                        AS $$
                        BEGIN
                            DELETE FROM tasks123 WHERE id = p_id;
                        END;
                        $$;
                    """);

            System.out.println("✅ Khởi tạo CSDL ToDo thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== THÊM CÔNG VIỆC ========== */
    public void addTask(String taskName, String status) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL add_task(?,?)")) {

            cs.setString(1, taskName);
            cs.setString(2, status);
            cs.execute();

            System.out.println("✅ Thêm công việc thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== LIỆT KÊ CÔNG VIỆC ========== */
    public void listTasks() {
        String sql = "SELECT * FROM tasks123 ORDER BY id";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | Task Name | Status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== CẬP NHẬT TRẠNG THÁI ========== */
    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL update_task_status(?,?)")) {

            cs.setInt(1, taskId);
            cs.setString(2, status);
            cs.execute();

            System.out.println("✅ Cập nhật trạng thái thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== XÓA CÔNG VIỆC ========== */
    public void deleteTask(int taskId) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL delete_task(?)")) {

            cs.setInt(1, taskId);
            cs.execute();

            System.out.println("✅ Xóa công việc thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== TÌM KIẾM THEO TÊN ========== */
    public void searchTaskByName(String taskName) {
        String sql = "SELECT * FROM tasks123 WHERE task_name ILIKE ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + taskName + "%");
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Task Name | Status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ========== THỐNG KÊ ========== */
    public void taskStatistics() {
        String sql = """
                    SELECT status, COUNT(*) AS total
                    FROM tasks123
                    GROUP BY status
                """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Status | Total");
            while (rs.next()) {
                System.out.println(
                        rs.getString("status") + " | " +
                                rs.getInt("total")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}