import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        //nhập dữ liệu
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số nguyên");
        int number= Integer.parseInt(sc.nextLine());
        System.out.println("number"+number);
        String name = "Nguyen van a";
        //sc.nextLine();
        System.out.println("Nhập tên của bạn: ");
        name = sc.nextLine();
        System.out.println("Name: "+name);
        // xuất
        System.out.println("in chuoi binh thường");
        System.out.printf("hello , tôi tên là %s năm nay tôi %d tuổi", name, number);
        System.out.printf("| %-10s | %-15s | %-8s | %-5s | %-10s |\n","Mã SV","Họ tên","Cân nặng","Tuổi","Giới tính");
        System.out.printf("| %-10s | %-15s | %-8s | %-5s | %-10s |\n","Mã SV","Họ tên","Cân nặng","Tuổi","Giới tính❤️😋");
    }
}
