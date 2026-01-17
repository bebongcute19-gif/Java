import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Nhập chuỗi: ");
            input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Lỗi: Chuỗi không được để trống!");
            }
            else if (input.length() < 6) {
                System.out.println("Lỗi: Chuỗi phải có ít nhất 6 ký tự!");
            }
            else {
                System.out.println("Chuỗi hợp lệ: " + input);
                break;
            }
        }

        sc.close();
    }
}
