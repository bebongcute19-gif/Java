package BTVN02;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static AttendanceManager manager = new AttendanceManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
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
        System.out.println("************** MENU QUẢN LÝ ĐIỂM DANH **************");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    static void addStudent() {
        System.out.print("Nhập id sinh viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        manager.add(new Student(id, name));
    }

    static void updateStudent() {
        manager.display();
        System.out.print("Nhập id sinh viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        System.out.print("Nhập tên mới sinh viên: ");
        String newName = scanner.nextLine();

        manager.update(index, new Student(id, newName));
    }

    static void deleteStudent() {
        manager.display();
        System.out.print("Nhập id sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        int index = manager.findIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        manager.delete(index);
    }
}