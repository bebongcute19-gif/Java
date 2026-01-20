import java.util.Scanner;
import java.util.regex.Pattern;

public class BTVN02 {

    static String hoTen = "";
    static String email = "";
    static String soDienThoai = "";
    static String matKhau = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n*********** QUẢN LÝ NGƯỜI DÙNG ***********");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    nhapThongTin();
                    break;
                case 2:
                    chuanHoaHoTen();
                    break;
                case 3:
                    kiemTraEmail();
                    break;
                case 4:
                    kiemTraSoDienThoai();
                    break;
                case 5:
                    kiemTraMatKhau();
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // 1. Nhập thông tin
    static void nhapThongTin() {
        System.out.print("Nhập họ và tên: ");
        hoTen = sc.nextLine();

        System.out.print("Nhập email: ");
        email = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        soDienThoai = sc.nextLine();

        System.out.print("Nhập mật khẩu: ");
        matKhau = sc.nextLine();
    }

    // 2. Chuẩn hóa họ tên
    static void chuanHoaHoTen() {
        String[] words = hoTen.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1))
                    .append(" ");
        }

        hoTen = sb.toString().trim();
        System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
    }

    // 3. Kiểm tra email
    static void kiemTraEmail() {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (Pattern.matches(regex, email)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }

    // 4. Kiểm tra số điện thoại VN
    static void kiemTraSoDienThoai() {
        String regex = "^0\\d{9}$";
        if (Pattern.matches(regex, soDienThoai)) {
            System.out.println("Số điện thoại hợp lệ");
        } else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }

    // 5. Kiểm tra mật khẩu
    static void kiemTraMatKhau() {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        if (Pattern.matches(regex, matKhau)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }
    }
}
