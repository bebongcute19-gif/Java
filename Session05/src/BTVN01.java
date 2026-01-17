import java.util.Scanner;

public class BTVN01 {
    public static final String REGEX_EMAIL =
            "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập email: ");
        String email = sc.nextLine().trim();


        if (email.matches(REGEX_EMAIL)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
        sc.close();
    }

}
