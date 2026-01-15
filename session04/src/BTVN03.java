import java.util.Scanner;

public class BTVN03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Nhập số cần tìm: ");
        int x = sc.nextInt();
        // tìm kiếm tuyến tính
        int linearIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                linearIndex = i;
                break;
            }
        }
        // tìm kiếm nhị phân
        int left = 0, right = n - 1;
        int binaryIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                binaryIndex = mid;
                break;
            } else if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: tìm thấy tại vị trí " + linearIndex);
        } else {
            System.out.println("Tìm kiếm tuyến tính: không tìm thấy");
        }

        if (binaryIndex != -1) {
            System.out.println("Tìm kiếm nhị phân: tìm thấy tại vị trí " + binaryIndex);
        } else {
            System.out.println("Tìm kiếm nhị phân: không tìm thấy");
        }

        sc.close();

    }
}
