
import java.util.Scanner;

public class BTVN01 {
    public static void main(String[] args) {
        System.out.println("nhập bán kính: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Bán kinh:"+n);

        final double r = 3.14;
        double s = n*n*r;
        System.out.println("Diện tích: "+ s);

    }
}
