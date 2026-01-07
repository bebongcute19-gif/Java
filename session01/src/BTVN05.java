import java.util.Scanner;

public class BTVN05 {
    public static void main(String[] args) {
        System.out.println("Nhập chiều cao(m):");
        Scanner sc = new Scanner(System.in);
        float h =sc.nextFloat();
        System.out.println("Nhập cân nặng(kg):");
        float w = sc.nextFloat();
        float bmi = w / (h * h);
        System.out.println("---Kết quả---");
        System.out.printf("Chỉ số BMI:%.2f%n ", bmi );
    }
}
