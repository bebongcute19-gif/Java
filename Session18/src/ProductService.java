import java.sql.*;
import java.util.Scanner;

public class ProductService {

    // 1. Tạo bảng Product khi chạy chương trình
    public static void initDatabase() {
        String sql = """
                CREATE TABLE IF NOT EXISTS Product (
                    product_id SERIAL PRIMARY KEY,
                    product_name VARCHAR(100) NOT NULL UNIQUE,
                    product_price FLOAT CHECK (product_price > 0),
                    product_title VARCHAR(200) NOT NULL,
                    product_created DATE NOT NULL,
                    product_catalog VARCHAR(100) NOT NULL,
                    product_status BOOLEAN DEFAULT TRUE
                );
                """;

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✔ Bảng Product đã sẵn sàng");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Hiển thị danh sách sản phẩm
    public static void showAll() {
        String sql = "SELECT * FROM Product";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getFloat("product_price") + " | " +
                                rs.getString("product_catalog")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Thêm mới sản phẩm
    public static void insert() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        float price = sc.nextFloat();
        if (price <= 0) {
            System.out.println("❌ Giá phải > 0");
            return;
        }
        sc.nextLine();

        System.out.print("Tiêu đề: ");
        String title = sc.nextLine();

        System.out.print("Danh mục: ");
        String catalog = sc.nextLine();

        String sql = """
                INSERT INTO Product
                (product_name, product_price, product_title,
                 product_created, product_catalog)
                VALUES (?, ?, ?, CURRENT_DATE, ?)
                """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, title);
            ps.setString(4, catalog);

            ps.executeUpdate();
            System.out.println("✔ Thêm sản phẩm thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }public static void update() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        int id = sc.nextInt();

        System.out.print("Giá mới: ");
        float price = sc.nextFloat();
        if (price <= 0) {
            System.out.println("❌ Giá phải > 0");
            return;
        }
        sc.nextLine();

        System.out.print("Tiêu đề mới: ");
        String title = sc.nextLine();

        System.out.print("Danh mục mới: ");
        String catalog = sc.nextLine();

        System.out.print("Trạng thái (true/false): ");
        boolean status = sc.nextBoolean();

        String sql = """
            UPDATE Product
            SET product_price = ?, product_title = ?,
                product_catalog = ?, product_status = ?
            WHERE product_id = ?
            """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setFloat(1, price);
            ps.setString(2, title);
            ps.setString(3, catalog);
            ps.setBoolean(4, status);
            ps.setInt(5, id);

            int row = ps.executeUpdate();
            if (row > 0)
                System.out.println("✔ Cập nhật thành công");
            else
                System.out.println("❌ Không tìm thấy sản phẩm");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 4. Xóa sản phẩm
    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM Product WHERE product_id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✔ Đã xóa sản phẩm");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = sc.nextLine();

        String sql = "SELECT * FROM Product WHERE product_name ILIKE ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getFloat("product_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5. Thống kê sản phẩm theo danh mục
    public static void statistic() {
        String sql = """
                SELECT product_catalog, COUNT(*) total
                FROM Product
                GROUP BY product_catalog
                """;

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("product_catalog") +
                                " : " + rs.getInt("total")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sortByPrice() {
        String sql = "SELECT * FROM Product ORDER BY product_price ASC";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getFloat("product_price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}