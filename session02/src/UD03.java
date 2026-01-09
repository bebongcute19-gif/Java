import java.util.Scanner;

public class UD03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true){
            System.out.println("Nhap 1 so nguyen");
            n = Integer.parseInt(sc.nextLine());
            if(n>0){
                System.out.println("So nguyen "+n);
                break;
            }
            else{
                System.err.println("loi! vui long nhap lai:");
            }
        }
        sc.close();
    }
}
