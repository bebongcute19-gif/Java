import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] diem = new double[10];
        double tong = 0;
        for(int i=0;i<diem.length;i++){
            do{
                System.out.print("Nhap diem mon "+(i+1)+": ");
                diem[i] = input.nextDouble();
                if(diem[i]<0||diem[i]>10){
                    System.err.println("Diem phai nam trong khoang tu 0 toi 10");
                }
            }
            while (diem[i]<0||diem[i]>10);
            tong += diem[i];
        }
        double max = diem[0];
        double min = diem[0];
        for(int i=0;i<diem.length;i++){
            if(diem[i]>max){
                max = diem[i];
            }
            if(diem[i]<min){
                min = diem[i];
            }
        }
        double diemTrungBinh = tong / diem.length;
        System.out.println("Diem trung binh: "+diemTrungBinh);
        System.out.println("Diem cao nhat "+max);
        System.out.println("Diem thap nhat "+min);
        input.close();
    }
}
