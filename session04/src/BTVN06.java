import java.util.Scanner;

public class BTVN06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salaries = null;
        int n = 0;
        boolean daNhap = false;
        boolean daSapXepTang = false;

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ LƯƠNG =====");
            System.out.println("1. Nhập dữ liệu lương nhân viên");
            System.out.println("2. Xem danh sách lương");
            System.out.println("3. Sắp xếp lương");
            System.out.println("4. Tìm kiếm lương");
            System.out.println("5. Thống kê lương");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ===== 1. NHẬP DỮ LIỆU =====
                case 1:
                    System.out.print("Nhập số lượng nhân viên: ");
                    n = sc.nextInt();

                    if (n <= 0) {
                        System.out.println("Số lượng nhân viên không hợp lệ!");
                        break;
                    }

                    salaries = new double[n];
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.print("Nhập lương nhân viên " + (i + 1) + ": ");
                            salaries[i] = sc.nextDouble();
                        } while (salaries[i] < 0);
                    }

                    daNhap = true;
                    daSapXepTang = false;
                    break;

                // ===== 2. XEM DANH SÁCH =====
                case 2:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    System.out.println("Danh sách lương:");
                    for (double x : salaries) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                    break;

                // ===== 3. SẮP XẾP =====
                case 3:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    System.out.println("1. Sắp xếp tăng dần");
                    System.out.println("2. Sắp xếp giảm dần");
                    System.out.print("Chọn: ");
                    int opt = sc.nextInt();

                    boolean tangDan = (opt == 1);

                    // Bubble Sort
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if ((tangDan && salaries[j] > salaries[j + 1]) ||
                                    (!tangDan && salaries[j] < salaries[j + 1])) {
                                double temp = salaries[j];
                                salaries[j] = salaries[j + 1];
                                salaries[j + 1] = temp;
                            }
                        }
                    }

                    daSapXepTang = tangDan;

                    System.out.println("Mảng lương sau khi sắp xếp:");
                    for (double x : salaries) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                    break;

                // ===== 4. TÌM KIẾM =====
                case 4:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    System.out.print("Nhập mức lương cần tìm: ");
                    double target = sc.nextDouble();

                    // Linear Search
                    int linearIndex = -1;
                    for (int i = 0; i < n; i++) {
                        if (salaries[i] == target) {
                            linearIndex = i;
                            break;
                        }
                    }

                    if (linearIndex != -1) {
                        System.out.println("Linear Search: tìm thấy tại vị trí " + linearIndex);
                    } else {
                        System.out.println("Linear Search: không tìm thấy");
                    }

                    // Binary Search (chỉ khi sắp xếp tăng)
                    if (daSapXepTang) {
                        int left = 0, right = n - 1;
                        int binaryIndex = -1;

                        while (left <= right) {
                            int mid = (left + right) / 2;

                            if (salaries[mid] == target) {
                                binaryIndex = mid;
                                break;
                            } else if (salaries[mid] < target) {
                                left = mid + 1;
                            } else {
                                right = mid - 1;
                            }
                        }

                        if (binaryIndex != -1) {
                            System.out.println("Binary Search: tìm thấy tại vị trí " + binaryIndex);
                        } else {
                            System.out.println("Binary Search: không tìm thấy");
                        }
                    } else {
                        System.out.println("Mảng chưa sắp xếp tăng dần → không dùng Binary Search");
                    }
                    break;

                // ===== 5. THỐNG KÊ =====
                case 5:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    double sum = 0;
                    double max = salaries[0];
                    double min = salaries[0];

                    for (double x : salaries) {
                        sum += x;
                        if (x > max) max = x;
                        if (x < min) min = x;
                    }

                    double avg = sum / n;
                    int countAboveAvg = 0;
                    for (double x : salaries) {
                        if (x > avg) countAboveAvg++;
                    }

                    System.out.println("Tổng lương: " + sum);
                    System.out.println("Lương trung bình: " + avg);
                    System.out.println("Lương cao nhất: " + max);
                    System.out.println("Lương thấp nhất: " + min);
                    System.out.println("Số nhân viên có lương trên trung bình: " + countAboveAvg);
                    break;

                // ===== 6. THOÁT =====
                case 6:
                    System.out.println("Kết thúc chương trình!");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
