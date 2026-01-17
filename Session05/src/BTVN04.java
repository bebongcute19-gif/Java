import java.util.Random;
import java.util.Scanner;

public class BTVN04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Nhập n (1 ≤ n ≤ 1000): ");
        int n = sc.nextInt();

        // Tập ký tự cho phép
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";

        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên:");
        System.out.println(result.toString());
    }
}
