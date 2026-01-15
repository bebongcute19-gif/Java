import java.util.Arrays;

public class DynamicArray {
    public static void main(String[] args) {
        //mảng trong java là cố định
        //Quản lí mảng: thêm sửa xóa tìm kiếm phần tử trong 1 mảng
        final int max = 1000;
        int [] arr= new int[max];
        for(int i=1;i<6;i++){
            arr[i-1]=i;
        }
        int n=6;
        //thực hiện các thao tác làm việc cơ bản với mảng
        //chen
        add(arr,n,100,2);
        System.out.println(Arrays.toString(arr));
        n++;
        // xoa theo vi tri dich cac phan tu ben phai vi tri xoa sang trai 1 o va giam kich thuoc

    }
    public static void  add(int[] arr, int n, int value,int idx){
        //1,2,3,4,5 chenf 100 tai idx =2
        if (n>=1000){
            System.out.println("Mang da day");
        }
        else {
            //dich cac phan tu ben phai can chen sang phai 1 o
            for (int i=n ; i>idx; i--){
                arr[i]=arr[i-1];

            }
            //
            arr[idx]=value;
        }
    }
}
