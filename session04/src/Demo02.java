import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        //tạp random 1 mảng có 100 phần tử
        Random rand = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);
        }
        // in mang
//        for (int i = 0; i < array.length; i++) {
//            if(array[i]%3==0){
//                System.out.println(array[i]);
//            }
//        }
        // Taoj mảng lưu trữ 20 số nguyên tốddầu tiên
        // tìm và lưu 20 số nguyên tố đó vào mảng đã tạo
        int n=0;
        boolean isPrime  = true;
        if (n<2){
            isPrime = false;
        }
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {

        }
    }
}
