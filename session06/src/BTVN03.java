import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BTVN03 {

    static ArrayList<String> danhSachBienSo = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n*********** QUẢN LÝ BIỂN SỐ XE ***********");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    themBienSo();
                    break;
                case 2:
                    hienThi();
                    break;
                case 3:
                    timChinhXac();
                    break;
                case 4:
                    timTheoMaTinh();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);
    }

    // 1. Thêm biển số xe
    static void themBienSo() {
        int n;

        while (true) {
            try {
                System.out.print("Nhập số lượng biển số: ");
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số nguyên hợp lệ!");
            }
        }

        String regex = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";

        for (int i = 0; i < n; i++) {
            String bienSo;
            do {
                System.out.print("Nhập biển số thứ " + (i + 1) + ": ");
                bienSo = sc.nextLine().toUpperCase();
            } while (!Pattern.matches(regex, bienSo));

            danhSachBienSo.add(bienSo);
        }
    }

    // 2. Hiển thị danh sách
    static void hienThi() {
        if (danhSachBienSo.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("Danh sách biển số xe:");
        for (String bs : danhSachBienSo) {
            System.out.println(bs);
        }
    }

    // 3. Tìm chính xác
    static void timChinhXac() {
        System.out.print("Nhập biển số cần tìm: ");
        String tim = sc.nextLine().toUpperCase();

        if (danhSachBienSo.contains(tim)) {
            System.out.println("Tìm thấy biển số: " + tim);
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    // 4. Tìm theo mã tỉnh
    static void timTheoMaTinh() {
        System.out.print("Nhập mã tỉnh (VD: 29, 30, 51): ");
        String maTinh = sc.nextLine();

        boolean found = false;
        System.out.println("Các biển số thuộc mã tỉnh " + maTinh + ":");
        for (String bs : danhSachBienSo) {
            if (bs.startsWith(maTinh)) {
                System.out.println(bs);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có biển số nào!");
        }
    }

    // 5. Sắp xếp tăng dần
    static void sapXep() {
        Collections.sort(danhSachBienSo);
        System.out.println("Đã sắp xếp biển số xe tăng dần!");
    }
}
