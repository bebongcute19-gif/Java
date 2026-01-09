import java.util.Scanner;

public class MENU {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("----Menu----");
        System.out.println("1. Tính tổng của n số tự nhiên đầu tiên");
        System.out.println("2. Tình thương của 2 số tự nhiên ");
        int n = input.nextInt();
        switch(n){
            case 1:{
                System.out.println("Nhap so tu nhien n");
                int a = Integer.parseInt(input.next());
                int b= (a*(a+1))/2;
                System.out.println("tổng của n số tự nhiên đầu tiên "+b);
                break;
            }
            case 2:{
                System.out.println("Nhap so nguyen a");
                int a = Integer.parseInt(input.next());
                System.out.println("nhap so nguyen b");
                int b = Integer.parseInt(input.next());
                if(b==0){
                    System.out.println("Mau khong duoc bang 0");
                }
                else{
                    System.out.println("Thuong cua 2 so nguyen là "+a+"/"+b);
                }
            }
        }
    }
}
