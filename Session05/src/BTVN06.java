import java.util.Scanner;
import java.util.Arrays;

public class BTVN06 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String[] students = new String[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n******************** MENU ********************");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm sinh viên có tên bắt đầu bằng chữ cái");
            System.out.println("5. Sắp xếp danh sách theo thứ tự A-Z (theo tên)");
            System.out.println("6. Thoát");
            System.out.println("**********************************************");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Thêm tên sinh viên
                    System.out.print("Nhập tên sinh viên: ");
                    students[count] = sc.nextLine().trim();
                    count++;
                    break;

                case 2:
                    // Hiển thị danh sách
                    if (count == 0) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("Danh sách sinh viên:");
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + students[i]);
                        }
                    }
                    break;

                case 3:
                    // Tìm tên sinh viên chứa từ khóa
                    System.out.print("Nhập từ khóa: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].toLowerCase().contains(keyword)) {
                            System.out.println(students[i]);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên phù hợp!");
                    }
                    break;

                case 4:
                    // Đếm sinh viên có tên bắt đầu bằng chữ cái
                    System.out.print("Nhập chữ cái: ");
                    char ch = sc.nextLine().toLowerCase().charAt(0);
                    int dem = 0;

                    for (int i = 0; i < count; i++) {
                        String[] parts = students[i].trim().split("\\s+");
                        String ten = parts[parts.length - 1].toLowerCase(); // lấy TÊN

                        if (ten.charAt(0) == ch) {
                            dem++;
                        }
                    }

                    System.out.println("Số sinh viên có tên bắt đầu bằng '" + ch + "': " + dem);
                    break;

                case 5:
                    // Sắp xếp theo tên A-Z
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {

                            String ten1 = students[i].trim()
                                    .substring(students[i].lastIndexOf(" ") + 1);
                            String ten2 = students[j].trim()
                                    .substring(students[j].lastIndexOf(" ") + 1);

                            if (ten1.compareToIgnoreCase(ten2) > 0) {
                                String temp = students[i];
                                students[i] = students[j];
                                students[j] = temp;
                            }
                        }
                    }

                    System.out.println("Đã sắp xếp danh sách theo tên A-Z");
                    break;

                case 6:
                    System.out.println("Kết thúc chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);

        sc.close();
    }
}
