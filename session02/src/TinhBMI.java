import java.util.Scanner;

public class TinhBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cân nặng");
        double a = Double.parseDouble(input.nextLine());
        System.out.println("Chiều cao:");
        double b = Double.parseDouble(input.nextLine());
        double c = a/(b*b);
        if(c<16){
            System.out.println("Gay cap do 3");
        }
        else if(c<=16.9 ){
            System.out.println("Gay cap do 2");
        }
        else if(c<=18.4 ){
            System.out.println("Gay cap do 1");
        }
        else if(c<24.9 ){
            System.out.println("Binh thuong");
        }
        else if(c<=29.9 ){
            System.out.println("Tien beo phi");
        }
        else if(c<34.9 ){
            System.out.println("Beo phi cap I");
        }
        else if(c<=39.9 ){
            System.out.println("Beo phi cap II");
        }
        else {
            System.out.println("Beo phi cap III");
        }
    }
}
