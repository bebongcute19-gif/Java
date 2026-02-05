package BTVN01;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonService service = new PersonService();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    deletePerson();
                    break;
                case 3:
                    service.showAll();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("************ MENU QUẢN LÝ NGƯỜI DÙNG ************");
        System.out.println("1. Thêm người dùng");
        System.out.println("2. Xóa người dùng");
        System.out.println("3. Hiển thị danh sách người dùng");
        System.out.println("4. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static void addPerson() {
        String name = inputNotEmpty("Nhập tên người dùng: ");
        String email = inputNotEmpty("Nhập email người dùng: ");
        String phone = inputNotEmpty("Nhập số điện thoại người dùng: ");

        service.addPerson(new Person(name, email, phone));
    }

    private static void deletePerson() {
        String email = inputNotEmpty("Nhập email người dùng để xóa: ");
        service.deleteByEmail(email);
    }

    private static String inputNotEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Vui lòng không để trống!");
        }
    }
}