package BTVN03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();
    static Map<String, Order> orderMap = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> deleteProduct();
                    case 3 -> productManager.displayProducts();
                    case 4 -> createOrder();
                    case 5 -> addProductToOrder();
                    case 6 -> showOrder();
                    case 0 -> System.out.println("Thoát chương trình.");
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("\n=========== MENU ===========");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Hiển thị sản phẩm");
        System.out.println("4. Tạo đơn hàng");
        System.out.println("5. Thêm sản phẩm vào đơn hàng");
        System.out.println("6. Hiển thị đơn hàng");
        System.out.println("0. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    static void addProduct() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        productManager.addProduct(new Product(id, name, price));
    }

    static void deleteProduct() {
        System.out.print("Nhập id sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.removeProduct(id);
    }

    static void createOrder() {
        System.out.print("Nhập mã đơn hàng: ");
        String orderId = scanner.nextLine();
        orderMap.put(orderId, new Order(orderMap.size() + 1));
        System.out.println("Tạo đơn hàng thành công.");
    }

    static void addProductToOrder() {
        System.out.print("Nhập mã đơn hàng: ");
        String orderId = scanner.nextLine();
        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new RuntimeException("Đơn hàng không tồn tại");
        }

        System.out.print("Nhập id sản phẩm: ");
        int productId = Integer.parseInt(scanner.nextLine());
        Product product = productManager.findById(productId);

        order.addProduct(product);
    }

    static void showOrder() {
        System.out.print("Nhập mã đơn hàng: ");
        String orderId = scanner.nextLine();
        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new RuntimeException("Đơn hàng không tồn tại");
        }
        System.out.println(order);
    }
}
