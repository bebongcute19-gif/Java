import java.util.Scanner;

public class BTVN02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        int count = 0;
        double sum = 0;
        double max = -1;
        double min = 11;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    while (true) {
                        System.out.print("Nhập điểm (-1 để kết thúc): ");
                        double diem = input.nextDouble();

                        if (diem == -1) {
                            break;
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println("⚠ Điểm không hợp lệ! Nhập lại.");
                            continue;
                        }

                        // Xếp loại
                        if (diem < 5) {
                            System.out.println("Xếp loại: Yếu");
                        } else if (diem < 7) {
                            System.out.println("Xếp loại: Trung Bình");
                        } else if (diem < 8) {
                            System.out.println("Xếp loại: Khá");
                        } else if (diem < 9) {
                            System.out.println("Xếp loại: Giỏi");
                        } else {
                            System.out.println("Xếp loại: Xuất sắc");
                        }

                        // Thống kê
                        count++;
                        sum += diem;
                        if (diem > max) max = diem;
                        if (diem < min) min = diem;
                    }
                    break;
                }

                case 2: {
                    if (count == 0) {
                        System.out.println("⚠ Chưa có dữ liệu");
                    } else {
                        System.out.println("\n===== THỐNG KÊ =====");
                        System.out.println("Số học viên: " + count);
                        System.out.printf("Điểm trung bình: %.2f%n", sum / count);
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }
                    break;
                }

                case 3: {
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                }

                default:
                    System.out.println("⚠ Chức năng không hợp lệ!");
            }

        } while (true);
    }
}
