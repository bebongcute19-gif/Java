import java.util.InputMismatchException;
import java.util.Scanner;

public class demo1 {
    // Hàm static chia 2 số
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số a: ");
            double a = scanner.nextDouble();

            System.out.print("Nhập số b: ");
            double b = scanner.nextDouble();

            double result = divide(a, b);
            System.out.println("Kết quả a / b = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập đúng số thực!");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
