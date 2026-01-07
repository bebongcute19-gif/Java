import java.util.Scanner;

public class BTVN06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double v, t;

        // Nhập vận tốc
        while (true) {
            System.out.print("Nhập vận tốc (>= 0): ");
            v = input.nextDouble();
            if (v >= 0) break;
            System.out.println("Vận tốc không được âm!");
        }

        // Nhập thời gian
        while (true) {
            System.out.print("Nhập thời gian (>= 0): ");
            t = input.nextDouble();
            if (t >= 0) break;
            System.out.println("Thời gian không được âm!");
        }

        double s = v * t;
        System.out.printf("Quãng đường đi được: %.2f%n", s);


    }
}