import java.util.Scanner;

public class BTVN04 {
    public static void main(String[] args) {
        System.out.println("Nhập chiều dài:");
        Scanner input = new Scanner(System.in);
        float height= Float.parseFloat(input.nextLine());
        System.out.println("Nhập chiều rộng:");
        float width= Float.parseFloat(input.nextLine());
        float area = height*width;
        float perimeter = 2*(height+width);
        System.out.println("---Kết quả---");
        System.out.printf("Diện tích hình chữ nhật: %.2f%n \n", area);
        System.out.printf("Chu vi hình chữ nhật: %.2f%n",perimeter);
    }
}
