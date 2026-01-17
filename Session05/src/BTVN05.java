import java.util.Scanner;

public class BTVN05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        int choice;

        do {
            System.out.println("\n******************** MENU ********************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự (thường, hoa, số, đặc biệt)");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.println("**********************************************");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Nhập chuỗi
                    System.out.print("Nhập chuỗi: ");
                    input = sc.nextLine();
                    break;

                case 2:
                    // Đếm ký tự
                    int lower = 0, upper = 0, digit = 0, special = 0;

                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);

                        if (Character.isLowerCase(c))
                            lower++;
                        else if (Character.isUpperCase(c))
                            upper++;
                        else if (Character.isDigit(c))
                            digit++;
                        else
                            special++;
                    }

                    System.out.println("Chữ thường: " + lower);
                    System.out.println("Chữ hoa: " + upper);
                    System.out.println("Chữ số: " + digit);
                    System.out.println("Ký tự đặc biệt: " + special);
                    break;

                case 3:
                    // Đảo ngược chuỗi
                    String reversed = new StringBuilder(input).reverse().toString();
                    System.out.println("Chuỗi đảo ngược: " + reversed);
                    break;

                case 4:
                    // Kiểm tra Palindrome
                    String cleaned = input.replaceAll("\\s+", "").toLowerCase();
                    String rev = new StringBuilder(cleaned).reverse().toString();

                    if (cleaned.equals(rev)) {
                        System.out.println("Chuỗi là Palindrome");
                    } else {
                        System.out.println("Chuỗi KHÔNG phải Palindrome");
                    }
                    break;

                case 5:
                    // Chuẩn hóa chuỗi
                    input = input.trim().replaceAll("\\s+", " ");

                    if (!input.isEmpty()) {
                        input = input.substring(0, 1).toUpperCase() + input.substring(1);
                    }

                    System.out.println("Chuỗi sau khi chuẩn hóa: " + input);
                    break;

                case 6:
                    System.out.println("Kết thúc chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);

        sc.close();
    }
}
