import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Tạo bảng ngay khi chạy chương trình
        ProductService.initDatabase();

        int choice;
        do {
            System.out.println("\n******** PRODUCT MANAGEMENT ********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Thống kê số lượng theo danh mục");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> ProductService.showAll();
                case 2 -> ProductService.insert();
                case 3 -> ProductService.update();
                case 4 -> ProductService.delete();
                case 5 -> ProductService.search();
                case 6 -> ProductService.sortByPrice();
                case 7 -> ProductService.statistic();
                case 8 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("❌ Lựa chọn không hợp lệ");
            }
        } while (choice != 8);
    }
}