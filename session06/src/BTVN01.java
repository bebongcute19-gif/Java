import java.util.Scanner;
import java.util.Arrays;


public class BTVN01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] diem = new double[100];
        int n = 0;
        int choice;

        do {
            System.out.println("\n*********** QUẢN LÝ ĐIỂM SV ***********");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                            diem[i] = sc.nextDouble();
                        } while (diem[i] < 0 || diem[i] > 10);
                    }
                    break;

                case 2:
                    System.out.println("Danh sách điểm:");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ": " + diem[i]);
                    }
                    break;

                case 3:
                    double sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += diem[i];
                    }
                    System.out.println("Điểm trung bình: " + (n > 0 ? sum / n : 0));
                    break;

                case 4:
                    if (n > 0) {
                        double max = diem[0], min = diem[0];
                        for (int i = 1; i < n; i++) {
                            if (diem[i] > max) max = diem[i];
                            if (diem[i] < min) min = diem[i];
                        }
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("Số sinh viên đạt: " + dat);
                    System.out.println("Số sinh viên trượt: " + truot);
                    break;

                case 6:
                    Arrays.sort(diem, 0, n);
                    System.out.println("Đã sắp xếp điểm tăng dần!");
                    break;

                case 7:
                    int gioi = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 8) gioi++;
                    }
                    System.out.println("Số sinh viên giỏi & xuất sắc: " + gioi);
                    break;

                case 8:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 8);

        sc.close();
    }
}
