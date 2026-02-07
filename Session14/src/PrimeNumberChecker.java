import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên: ");
            int n = scanner.nextInt();

            // Kiểm tra số không hợp lệ
            if (n <= 0) {
                throw new IllegalArgumentException("Số nhập vào không hợp lệ để kiểm tra số nguyên tố.");
            }

            // Kiểm tra số nguyên tố
            if (isPrime(n)) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
