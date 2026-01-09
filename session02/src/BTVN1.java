
import java.util.Scanner;

public class BTVN1 {
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương N:");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n<=0){
            System.out.println("SỐ nhập vào không hợp lệ");
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=i;

        }
        System.out.printf("Tổng số nguyên dương từ 1 tới N là :%d",sum);
    }
}
