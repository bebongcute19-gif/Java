import java.util.Scanner;

public class DemoSS02 {
    public static void main(String[] args) {
        //If elseif else
        // điều kiện phải là 1 biểu thức trả về kiểu boolean
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Nhập giá trị của a");
        a= Integer.parseInt(sc.nextLine());
        if (a>0){
            System.out.println("A lon hon 0");
        }
        else if (a>-10){
            System.out.println("A lon hon -10 va nho hon 0");
        }
        else{
            System.out.println("A nho hon hoac bang -10");
        }
        // Swith
        // biểu thức xét điều kiện tr về giá trị
        switch (a){
            case 0:{
                System.out.println("A bang 0");
                break;
            }

        }
    }
}
