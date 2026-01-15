import java.util.Scanner;

public class BTVN02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số hàng của mảng: ");
        int rows = sc.nextInt();
        System.out.println("Nhập số cột của mảng: ");
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử ["+i+"]["+j+"]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        int tongChan =0;
        int tongLe =0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j]%2==0){
                    tongChan+=arr[i][j];
                }
                else{
                    tongLe+=arr[i][j];
                }
            }
        }
        System.out.println("Tổng chẵn là : "+tongChan);
        System.out.println("Tổng lẻ là : "+tongLe);
        sc.close();
    }
}
