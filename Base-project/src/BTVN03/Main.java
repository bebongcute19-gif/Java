package BTVN03;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static InvoiceManager manager = new InvoiceManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addInvoice();
                    break;
                case 2:
                    updateInvoice();
                    break;
                case 3:
                    deleteInvoice();
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
        System.out.println("************** MENU QUẢN LÝ HÓA ĐƠN **************");
        System.out.println("1. Thêm hóa đơn");
        System.out.println("2. Sửa hóa đơn");
        System.out.println("3. Xóa hóa đơn");
        System.out.println("4. Hiển thị danh sách hóa đơn");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    static void addInvoice() {
        String code = inputNotEmpty("Nhập mã hóa đơn: ");
        double amount = inputAmount("Nhập số tiền: ");
        manager.add(new Invoice(code, amount));
    }

    static void updateInvoice() {
        manager.display();
        System.out.print("Nhập id hóa đơn cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn có id = " + id);
            return;
        }

        String newCode = inputNotEmpty("Nhập mã hóa đơn mới: ");
        double newAmount = inputAmount("Nhập số tiền mới: ");
        manager.update(index, new Invoice(newCode, newAmount));
    }

    static void deleteInvoice() {
        manager.display();
        System.out.print("Nhập id hóa đơn cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
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

    static double inputAmount(String message) {
        while (true) {
            System.out.print(message);
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount >= 0) {
                return amount;
            }
            System.out.println("Vui lòng nhập số thực >= 0 !");
        }
    }
}