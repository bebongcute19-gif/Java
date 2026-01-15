import java.util.Scanner;

public class TongHop {
    //cho menu chức năng sau cho 1 mang so nguyen:
    //1. Nhập số lượng phần tử cần khởi tạo
    //2. Tìm và in ra giá trị lớn nhất và nhỏ nhất
    //3. tìm giá trị lớn thứ 2
    //4. Tìm các số chính phương
    //5. Tính tổng lũy thừa bậc 3 của các số trong mảng
    //6. Thoát
    //Lưu ý: phải chọn chức năng 1 trước mới thực hiện được 2 3 4 5
    // hiển thị danh sách tên sinh viên
    // thêm mới tên sinh viên
    // cập nhật thông tin
    // xóa sinh viên theo vị trí

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = null;
        int n = 0;
        boolean daNhapMang = false;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập số lượng phần tử và khởi tạo mảng");
            System.out.println("2. Tìm giá trị lớn nhất và nhỏ nhất");
            System.out.println("3. Tìm giá trị lớn thứ 2");
            System.out.println("4. Tìm các số chính phương");
            System.out.println("5. Tính tổng lũy thừa bậc 3");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Nhập số phần tử:");
                    n = sc.nextInt();
                    arr = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhập phần tử %d:", i);
                        arr[i] = sc.nextInt();
                    }
                    daNhapMang = true;
                    break;
                }
                case 2: {
                    if (!daNhapMang) {
                        System.out.println("Hãy chọn chức năng 1 trước!");
                        break;
                    }
                    int max = arr[0];
                    int min = arr[0];
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                        if (arr[i] < min) {
                            min = arr[i];
                        }

                    }
                    System.out.println("So lon nhat la:" + max);
                    System.out.println("So nho nhat la:" + min);
                    break;
                }
                case 3: {
                    if (!daNhapMang) {
                        System.out.println("Hãy chọn chức năng 1 trước!");
                        break;
                    }
                    int max1 = Integer.MIN_VALUE;
                    int max2 = Integer.MIN_VALUE;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > max1) {
                            max2 = max1;
                            max1 = arr[i];
                        }
                        else if ((arr[i] > max2)&&(arr[i] < max1)) {
                            max2 = arr[i];
                        }
                    }
                    if (max2 == Integer.MIN_VALUE) {
                        System.out.println("Khong co gia tri lon thu 2");
                    }
                    else {
                        System.out.println("Gia tri lon thu 2 la:"+max2);
                    }
                    break;
                }
                case 4: {
                    if (!daNhapMang) {
                        System.out.println("Hãy chọn chức năng 1 trước!");
                        break;
                    }
                    boolean fond = false;
                    System.out.println("Cac so chinh phuong trong mang la:");
                    for (int i = 0; i < n; i++) {
                        int sqrt = (int) Math.sqrt(arr[i]);
                        if (sqrt*sqrt == arr[i]) {
                            System.out.println(arr[i]+" ");
                            fond = true;

                        }
                    }
                    if (!fond) {
                        System.out.println("Khong co chinh phuong trong mang");
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    if (!daNhapMang) {
                        System.out.println("Hãy chọn chức năng 1 trước!");
                        break;
                    }
                    long sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += arr[i]*arr[i]*arr[i];
                    }
                    System.out.println("Tong luy thua bac 3 cua cac so trong mang la:"+sum);
                    break;
                }
                case 6: {
                    System.out.println("Thoat chuong trinh");
                    sc.close();
                    return;
                }
                default:{
                    System.out.println("Lua chon ko hop le");
                }


            }

        }
    }
}
