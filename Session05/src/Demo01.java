import java.util.Scanner;
import java.util.*;
public class Demo01 {
    public static void main(String[] args) {
        /*
        * 1. Hiển thị danh sách tên sinh viên
        * 2. Tìm kiếm sinh viên theo tên
        * 3. sắp xếp sinh viên theo tên (a-z||z-a)
        * 4. Thoát
        *  tạo sẵn 10 sinh viên tùy biến
        *
        * */
        Scanner sc = new Scanner(System.in);

        // Tạo sẵn 10 sinh viên
        ArrayList<String> students = new ArrayList<>();
        students.add("Nguyễn Văn An");
        students.add("Trần Thị Bình");
        students.add("Lê Văn Chi");
        students.add("Phạm Văn Dũng");
        students.add("Hoàng Thị Hà");
        students.add("Nguyễn Khánh");
        students.add("Đỗ Minh");
        students.add("Võ Nam");
        students.add("Bùi Phương");
        students.add("Trần Tuấn");

        int choice;

        do {
            System.out.println("\n---------- MENU ----------");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Tìm kiếm sinh viên theo tên");
            System.out.println("3. Sắp xếp sinh viên theo tên (A-Z | Z-A)");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Hiển thị bảng sinh viên
                    System.out.println("+-----+----------------------+");
                    System.out.println("| STT | Họ và tên             |");
                    System.out.println("+-----+----------------------+");

                    for (int i = 0; i < students.size(); i++) {
                        System.out.printf("| %-3d | %-20s |\n", i + 1, students.get(i));
                    }

                    System.out.println("+-----+----------------------+");
                    break;

                case 2:
                    // Tìm kiếm sinh viên
                    System.out.print("Nhập tên cần tìm: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;

                    System.out.println("+-----+----------------------+");
                    System.out.println("| STT | Họ và tên             |");
                    System.out.println("+-----+----------------------+");

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).toLowerCase().contains(keyword)) {
                            System.out.printf("| %-3d | %-20s |\n", i + 1, students.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("|     | Không tìm thấy       |");
                    }

                    System.out.println("+-----+----------------------+");
                    break;

                case 3:
                    // Sắp xếp
                    System.out.println("1. Sắp xếp theo tên A - Z");
                    System.out.println("2. Sắp xếp theo tên Z - A");
                    System.out.print("Chọn: ");
                    int opt = Integer.parseInt(sc.nextLine());

                    if (opt == 1) {
                        Collections.sort(students, (a, b) -> {
                            String nameA = a.substring(a.lastIndexOf(" ") + 1);
                            String nameB = b.substring(b.lastIndexOf(" ") + 1);
                            return nameA.compareToIgnoreCase(nameB);
                        });
                        System.out.println("Đã sắp xếp theo tên A - Z");
                    }
                    else if (opt == 2) {
                        Collections.sort(students, (a, b) -> {
                            String nameA = a.substring(a.lastIndexOf(" ") + 1);
                            String nameB = b.substring(b.lastIndexOf(" ") + 1);
                            return nameB.compareToIgnoreCase(nameA);
                        });
                        System.out.println("Đã sắp xếp theo tên Z - A");
                    }
                    else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 4);

        sc.close();
    }
}
