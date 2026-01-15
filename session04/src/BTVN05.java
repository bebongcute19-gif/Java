import java.util.Scanner;

public class BTVN05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] scores = null;
        int n = 0;
        boolean daNhap = false;
        boolean daSapXep = false;
        boolean tangDan = true;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập dữ liệu sinh viên");
            System.out.println("2. Xem tất cả điểm");
            System.out.println("3. Sắp xếp điểm");
            System.out.println("4. Tìm kiếm điểm");
            System.out.println("5. Thống kê điểm");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ===== 1. NHẬP DỮ LIỆU =====
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    n = sc.nextInt();

                    if (n <= 0) {
                        System.out.println("Số lượng sinh viên không hợp lệ!");
                        break;
                    }

                    scores = new double[n];
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
                            scores[i] = sc.nextDouble();
                        } while (scores[i] < 0 || scores[i] > 10);
                    }

                    daNhap = true;
                    daSapXep = false;
                    break;

                // ===== 2. XEM ĐIỂM =====
                case 2:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    System.out.println("Danh sách điểm:");
                    for (double x : scores) {
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

                    tangDan = (opt == 1);

                    // Bubble Sort
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if ((tangDan && scores[j] > scores[j + 1]) ||
                                    (!tangDan && scores[j] < scores[j + 1])) {
                                double temp = scores[j];
                                scores[j] = scores[j + 1];
                                scores[j + 1] = temp;
                            }
                        }
                    }

                    daSapXep = true;

                    System.out.println("Mảng sau khi sắp xếp:");
                    for (double x : scores) {
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

                    System.out.print("Nhập điểm cần tìm: ");
                    double target = sc.nextDouble();

                    // Linear Search
                    int linearIndex = -1;
                    for (int i = 0; i < n; i++) {
                        if (scores[i] == target) {
                            linearIndex = i;
                            break;
                        }
                    }

                    if (linearIndex != -1) {
                        System.out.println("Linear Search: tìm thấy tại vị trí " + linearIndex);
                    } else {
                        System.out.println("Linear Search: không tìm thấy");
                    }

                    // Binary Search (chỉ khi đã sắp xếp)
                    if (daSapXep) {
                        int left = 0, right = n - 1;
                        int binaryIndex = -1;

                        while (left <= right) {
                            int mid = (left + right) / 2;

                            if (scores[mid] == target) {
                                binaryIndex = mid;
                                break;
                            }

                            if (tangDan) {
                                if (scores[mid] < target) left = mid + 1;
                                else right = mid - 1;
                            } else {
                                if (scores[mid] > target) left = mid + 1;
                                else right = mid - 1;
                            }
                        }

                        if (binaryIndex != -1) {
                            System.out.println("Binary Search: tìm thấy tại vị trí " + binaryIndex);
                        } else {
                            System.out.println("Binary Search: không tìm thấy");
                        }
                    } else {
                        System.out.println("Mảng chưa sắp xếp → không dùng Binary Search");
                    }
                    break;

                // ===== 5. THỐNG KÊ =====
                case 5:
                    if (!daNhap) {
                        System.out.println("Chưa nhập dữ liệu!");
                        break;
                    }

                    double sum = 0;
                    double max = scores[0];
                    double min = scores[0];

                    for (double x : scores) {
                        sum += x;
                        if (x > max) max = x;
                        if (x < min) min = x;
                    }

                    double avg = sum / n;
                    int countAboveAvg = 0;
                    for (double x : scores) {
                        if (x > avg) countAboveAvg++;
                    }

                    System.out.println("Điểm trung bình: " + avg);
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    System.out.println("Số sinh viên trên trung bình: " + countAboveAvg);
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
