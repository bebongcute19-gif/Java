package BTVN06;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    printProducts();
                    break;
                case 3:
                    findByPriceRange();
                    break;
                case 4:
                    statisticProduct();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // Menu
    static void showMenu() {
        System.out.println("===== MENU SẢN PHẨM =====");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. In danh sách sản phẩm");
        System.out.println("3. Tìm sản phẩm theo khoảng giá");
        System.out.println("4. Thống kê số sản phẩm đã tạo");
        System.out.println("0. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    // Thêm sản phẩm
    static void addProduct() {
        Product p = new Product();
        p.input();
        products.add(p);
        System.out.println("✔ Thêm sản phẩm thành công!");
    }

    // In danh sách
    static void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Product p : products) {
            p.print();
        }
    }

    // Tìm theo khoảng giá
    static void findByPriceRange() {
        System.out.print("Nhập giá min: ");
        double min = sc.nextDouble();
        System.out.print("Nhập giá max: ");
        double max = sc.nextDouble();

        boolean found = false;
        for (Product p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                p.print();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sản phẩm trong khoảng giá này!");
        }
    }

    // Thống kê
    static void statisticProduct() {
        System.out.println("Tổng số sản phẩm đã tạo: " + products.size());
    }
}
