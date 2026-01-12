import java.util.Scanner;

public class BTVN03{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        int count = 0;
        double sumSalary = 0;
        double maxSalary = -1;
        double minSalary = 500000000;
        double totalBonus = 0;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = input.nextInt();

            switch (choice) {

                // ===== CHỨC NĂNG 1 =====
                case 1: {
                    while (true) {
                        System.out.print("Nhập lương (-1 để kết thúc): ");
                        double salary = input.nextDouble();

                        if (salary == -1) {
                            break;
                        }

                        if (salary < 0 || salary > 500000000) {
                            System.out.println("⚠ Lương không hợp lệ! Nhập lại.");
                            continue;
                        }

                        // Phân loại thu nhập
                        if (salary < 5000000) {
                            System.out.println("Thu nhập thấp");
                        } else if (salary <= 15000000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (salary <= 50000000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }

                        // Thống kê
                        count++;
                        sumSalary += salary;
                        if (salary > maxSalary) maxSalary = salary;
                        if (salary < minSalary) minSalary = salary;

                        // Tính thưởng
                        double bonusRate;
                        if (salary < 5000000) {
                            bonusRate = 0.05;
                        } else if (salary <= 15000000) {
                            bonusRate = 0.10;
                        } else if (salary <= 50000000) {
                            bonusRate = 0.15;
                        } else if (salary <= 100000000) {
                            bonusRate = 0.20;
                        } else {
                            bonusRate = 0.25;
                        }

                        totalBonus += salary * bonusRate;
                    }
                    break;
                }

                // ===== CHỨC NĂNG 2 =====
                case 2: {
                    if (count == 0) {
                        System.out.println("⚠ Chưa có dữ liệu");
                    } else {
                        System.out.println("\n===== THỐNG KÊ =====");
                        System.out.println("Số nhân viên: " + count);
                        System.out.printf("Lương trung bình: %.2f%n", sumSalary / count);
                        System.out.println("Lương cao nhất: " + maxSalary);
                        System.out.println("Lương thấp nhất: " + minSalary);
                        System.out.println("Tổng tiền lương: " + sumSalary );
                    }
                    break;
                }

                // ===== CHỨC NĂNG 3 =====
                case 3: {
                    if (count == 0) {
                        System.out.println("⚠ Chưa có dữ liệu để tính thưởng");
                    } else {
                        System.out.printf("Tổng tiền thưởng cho nhân viên: %.2f%n", totalBonus);
                    }
                    break;
                }

                // ===== CHỨC NĂNG 4 =====
                case 4: {
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                }

                default:
                    System.out.println("⚠ Chức năng không hợp lệ!");
            }

        } while (true);
    }
}
