import java.util.Scanner;

public class BTVN04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        // Kiểm tra mảng rỗng
        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];

        // Nhập mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Mảng phụ
        int[] even = new int[n];
        int[] odd = new int[n];
        int evenCount = 0;
        int oddCount = 0;

        // Phân loại chẵn – lẻ (giữ nguyên thứ tự)
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even[evenCount++] = arr[i];
            } else {
                odd[oddCount++] = arr[i];
            }
        }

        // Ghép lại vào mảng ban đầu
        int index = 0;
        for (int i = 0; i < evenCount; i++) {
            arr[index++] = even[i];
        }
        for (int i = 0; i < oddCount; i++) {
            arr[index++] = odd[i];
        }

        // In kết quả
        System.out.println("Mảng sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
