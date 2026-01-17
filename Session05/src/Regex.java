import java.util.Scanner;

public class Regex {
    public static final String REGEX_EMAIL = "";
    /*Bài tập 2
    * Kiểm tra 1 chuỗi người dùng nhập vào có thỏa mãn 1 trong các điều kiện
    * Không để trống (chỉ chứa khoảng trắng)
    * không chưa kí tự đặc biệt
    * không chưa kí tự số
    * chỉ chứa toàn kú tự số
    * chỉ chứa toàn kú tự chữ cái (không phải số , ko phải kí tự đặc biệt       )
    * Bài tập 3
    * viết logic nhập vào 1 chuỗi input
    * nếu chuỗi để trống hoặc chuỗi có ít hơn 6 kí tự thì in ra lỗi tương ứng và bắt nhập laại
    * nếu nhập đúng thì in ra màn hình kết quả
    * */
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        // Không để trống (chỉ chứa khoảng trắng)
        if (input.trim().isEmpty()) {
            System.out.println("Chuỗi bị trống!");
        }

        // Không chứa ký tự đặc biệt
        if (input.matches(".*[^a-zA-Z0-9 ].*")) {
            System.out.println("Chuỗi chứa ký tự đặc biệt!");
        }

        // Không chứa ký tự số
        if (input.matches(".*\\d.*")) {
            System.out.println("Chuỗi chứa ký tự số!");
        }

        // Chỉ chứa toàn ký tự số
        if (input.matches("\\d+")) {
            System.out.println("Chuỗi chỉ chứa toàn số!");
        }

        // Chỉ chứa toàn ký tự chữ cái
        if (input.matches("[a-zA-Z ]+")) {
            System.out.println("Chuỗi chỉ chứa chữ cái!");
        }

        sc.close();
    }
}
