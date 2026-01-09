import java.util.Scanner;

public class BTVN03 {
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên N:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<0){
            n=-n;
        }
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        System.out.println("Tổng các chữ số của N là: "+sum );
    }
}
