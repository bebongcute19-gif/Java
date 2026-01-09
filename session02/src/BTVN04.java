import java.util.Scanner;

public class BTVN04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập cạnh thứ nhất :");
        int a = input.nextInt();
        System.out.println("Nhập cạnh thứ Hai :");
        int b = input.nextInt();
        System.out.println("Nhập cạnh thứ Ba :");
        int c = input.nextInt();
        if(a+b<=c||a+c<=b||b+c<=a){
            System.out.println("Ba cạnh không tạo thành tam giác");
        } else if (a==b && c==b) {
            System.out.println("Là tam giác đều");
        } else if ((a==b && a!=c) || (b==c && c!=a)
                ||(c==a && a!=b)) {
            System.out.println("Tam giác cân");
        }
        else if ((a*a == b*b+c*c)
                || (b*b == c*c+a*a)
                || (c*c == b*b+a*a)){
            System.out.println("Tam giác vuông");
        }
        else {
            System.out.println("Tam giác bình thường");
        }
    }
}
