import java.util.Scanner;

public class UD04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("-----Menu------");
            System.out.println("1.Tính giai thừa n");
            System.out.println("2.Tính tong của n số đầu tiên");
            System.out.println("3.Tính các ước của 1 số N");
            System.out.println("4.thoát");
            choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1:{
                    System.out.println("Nhap so n");
                    int n = Integer.parseInt(input.nextLine());
                    int fac=1;
                    if(n==0){
                        System.out.println("N khong the bang o");
                    }
                    else {
                        for(int i=1;i<=n;i++){
                            fac*=i;
                        }
                        System.out.println("giai thua cua n la "+ fac);
                    }
                    break;
                }
                case 2:{
                    System.out.println("Nhap so n");
                    int n = Integer.parseInt(input.nextLine());
                    int sum =0;
                    for(int i=1; i<=n; i++){
                        sum +=i;
                    }
                    System.out.println("Tong cua n so dau tien "+ sum);
                    break;
                }
                case 3:{
                    System.out.println("Nhap so n");
                    int  n = Integer.parseInt(input.nextLine());
                    for(int i=1; i<=n; i++){
                        if (n % i == 0) {
                            System.out.println(i + " ");
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("Thoat chuong trinh");
                    break;
                }
                default:{
                    System.out.println("Khong hop le , vui long nhap lai");
                }
            }

        }
        while (choice != 4);
        input.close();
    }
}
