import java.util.Scanner;

public class BTVN03 {
    public static final String REGEX_PASSWORD =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        if (password.matches(REGEX_PASSWORD)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }

        sc.close();
    }
}
