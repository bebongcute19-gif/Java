package BTVN04;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static OrderManager manager = new OrderManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    updateOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    manager.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void showMenu() {
        System.out.println("************** MENU QUẢN LÝ ĐƠN HÀNG **************");
        System.out.println("1. Thêm đơn hàng");
        System.out.println("2. Sửa đơn hàng");
        System.out.println("3. Xóa đơn hàng");
        System.out.println("4. Hiển thị danh sách đơn hàng");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    static void addOrder() {
        String code = inputNotEmpty("Nhập mã đơn hàng: ");
        String name = inputNotEmpty("Nhập tên khách hàng: ");
        manager.add(new Order(code, name));
    }

    static void updateOrder() {
        manager.display();
        System.out.print("Nhập id đơn hàng cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng.");
            return;
        }

        String newCode = inputNotEmpty("Nhập mã đơn hàng mới: ");
        String newName = inputNotEmpty("Nhập tên khách hàng mới: ");
        manager.update(index, new Order(newCode, newName));
    }

    static void deleteOrder() {
        manager.display();
        System.out.print("Nhập id đơn hàng cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy đơn hàng.");
            return;
        }

        manager.delete(index);
    }

    static String inputNotEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Vui lòng không để trống !");
        }
    }
}