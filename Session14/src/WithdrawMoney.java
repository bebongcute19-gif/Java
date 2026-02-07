import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawMoney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final long MIN_BALANCE = 50_000;
        long balance = 1_000_000;

        try {
            System.out.println("Số dư hiện tại: " + balance + " đồng");
            System.out.print("Nhập số tiền muốn rút: ");

            long withdrawAmount = scanner.nextLong();

            // Kiểm tra số tiền rút vượt quá số dư
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");
            }

            // Kiểm tra số dư tối thiểu
            if (balance - withdrawAmount < MIN_BALANCE) {
                throw new IllegalArgumentException(
                        "Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            // Rút tiền thành công
            balance -= withdrawAmount;
            System.out.println("Rút tiền thành công!");
            System.out.println("Số tiền đã rút: " + withdrawAmount + " đồng");
            System.out.println("Số dư còn lại: " + balance + " đồng");

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}