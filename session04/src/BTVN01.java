import java.util.Scanner;

public class BTVN01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ "+(i+1)+": ");
            arr[i] = sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
