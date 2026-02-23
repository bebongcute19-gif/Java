package BTVN02;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SubjectManager<Subject> manager = new SubjectManager<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> manager.display();
                case 2 -> addSubject();
                case 3 -> deleteSubject();
                case 4 -> searchSubject();
                case 5 -> manager.filterByCredits();
                case 6 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    static void showMenu() {
        System.out.println("\n===== QUẢN LÝ MÔN HỌC =====");
        System.out.println("1. Hiển thị danh sách môn học");
        System.out.println("2. Thêm môn học");
        System.out.println("3. Xóa môn học theo code");
        System.out.println("4. Tìm kiếm môn học theo tên");
        System.out.println("5. Lọc môn học có credits > 3");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static void addSubject() {
        try {
            System.out.print("Nhập code: ");
            String code = scanner.nextLine();

            System.out.print("Nhập tên môn học: ");
            String name = scanner.nextLine();

            System.out.print("Nhập số tín chỉ: ");
            int credits = Integer.parseInt(scanner.nextLine());
            if (credits <= 0 || credits > 10) {
                throw new IllegalArgumentException("Số tín chỉ không hợp lệ!");
            }

            System.out.print("Nhập ngày bắt đầu (dd-MM-yyyy): ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);

            manager.add(new Subject(code, name, credits, date));
            System.out.println("Thêm môn học thành công.");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số tín chỉ phải là số.");
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Sai định dạng ngày.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void deleteSubject() {
        System.out.print("Nhập code môn học cần xóa: ");
        manager.removeByCode(scanner.nextLine());
    }

    static void searchSubject() {
        System.out.print("Nhập tên môn học cần tìm: ");
        manager.searchByName(scanner.nextLine());
    }
}
