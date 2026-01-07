import java.util.Scanner;

public class BTVN03 {
    public static void main(String[] args) {
        System.out.println("Nhập tử 1:");
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập mẫu 1:");

        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tử 2:");

        int c = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập mẫu 2:");

        int d = Integer.parseInt(sc.nextLine());
        int sumtu = a * d + b * c;
        int summau = b * d;
        System.out.println("Kết quả:" + sumtu + "/" + summau);
    }
}
