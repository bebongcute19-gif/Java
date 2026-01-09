import java.util.Scanner;

public class BTVN06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số N: ");
        int N = sc.nextInt();

        System.out.println("Các số Armstrong từ 0 đến " + N + ":");

        for (int i = 0; i <= N; i++) {
            int temp = i;
            int sum = 0;

            // Đếm số chữ số
            int digits = String.valueOf(i).length();

            // Tách từng chữ số
            while (temp > 0) {
                int d = temp % 10;
                sum += Math.pow(d, digits);
                temp /= 10;
            }

            // Trường hợp i = 0
            if (i == 0) sum = 0;

            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
}
