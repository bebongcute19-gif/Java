import java.util.Scanner;

public class BTVN02 {
    public static void main(String[] args) {
        System.out.println("Nhập tháng:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch(n){
            case 1:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 2:
                System.out.println("có 28 hoặc 29 ngày");
                break;
            case 3:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 4:
                System.out.println("Có 30 ngày trong tháng");
                break;
            case 5:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 6:
                System.out.println("Có 30 ngày trong tháng");
                break;
            case 7:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 8:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 9:
                System.out.println("Có 30 ngày trong tháng");
                break;
            case 10:
                System.out.println("Có 31 ngày trong tháng");
                break;
            case 11:
                System.out.println("Có 30 ngày trong tháng");
                break;
            case 12:
                System.out.println("Có 31 ngày trong tháng");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
        }
    }
}
