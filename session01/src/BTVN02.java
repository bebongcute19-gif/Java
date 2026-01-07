import java.sql.SQLOutput;
import java.util.Scanner;

//Khai báo 2 biến kiểu số nguyên int và nhập giá trị :
//Khai báo hai số nguyên firstNumber và secondNumber có kiểu int
//Nhập các giá trị bất kỳ cho 2 biến
//Thực hiện các phép toán:
//Tính tổng của firstNumber và secondNumber và gán cho
//Tính hiệu của firstNumber và secondNumber
//Tính tích của firstNumber và secondNumber
//Tính thương của firstNumber chia cho secondNumber
//Tính phần dư khi chia firstNumber cho secondNumber
//In giá trị 2 biến firstNumber, secondNumber và kết quả các phép tính ra màn hình
public class BTVN02 {
    public static void main(String[] args) {
        System.out.println("Nhập firstNumber");
        Scanner sc = new Scanner(System.in);
        int firstNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập secondNumber");

        int secondNumber = Integer.parseInt(sc.nextLine());
        System.out.println("---Kết quả---");
        System.out.println("firstNumber: " + firstNumber);
        System.out.println("secondNumber: " + secondNumber);
        System.out.println("Tổng:"+(firstNumber+secondNumber));
        System.out.println("Hiệu:"+(firstNumber-secondNumber));
        System.out.println("Tích:"+(firstNumber*secondNumber));
        System.out.println("Thương:"+(firstNumber/secondNumber));
        System.out.println("Phần dư"+(firstNumber%secondNumber));

    }
}
