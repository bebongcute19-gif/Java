
import Presentation.AdminView;
import Presentation.StudentView;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("""
                    ------------------------MENU--------------------------
                    1. Đăng ký sinh viên
                    2. Đăng nhập sinh viên
                    3. Đăng nhập với quyền admin
                    4. Thoát
                    """);
            System.out.println("Nhap lua chon : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    StudentView.showMenuRegister(sc);
                    break;
                case 2:
                    StudentView.showMenuLogin(sc);
                    break;
                case 3:
                    AdminView.showMenuLogin(sc);
                    break;
                case 4:
                    System.out.println("Thoat chuong trình");
                    sc.close();
                    return;
                default:

            }
        }
    }
}