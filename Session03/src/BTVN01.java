import java.util.Scanner;
//Tên khách hàng
//Tên sản phẩm
//Giá sản phẩm
//Số lượng mua
public class BTVN01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập thông tin hóa đơn");
        System.out.print("Tên khách hàng: ");
        String kh = input.nextLine();
        System.out.print("Tên sản phẩm: ");
        String sp = input.nextLine();
        System.out.print("Giá sản phẩm: ");
        double price = input.nextDouble();
        System.out.print("Số lượng sản phầm: ");
        int quantity = input.nextInt();
        System.out.print("Thẻ thành viên(true/false): )");
        boolean flag = input.nextBoolean();
        double tax = price * quantity;

        double giamGia = 0;

        if (flag) {
            giamGia = tax * 0.1;
        }
        double vat = (tax - giamGia)*0.08;
        double thanhToan = tax + vat - giamGia;
        System.out.printf("Khách hàng:%s\n",kh);
        System.out.printf("Sản phẩm:%s\n",sp);
        System.out.printf("Giá sản phẩm:%.2f\n",price);
        System.out.printf("Số lượng sản phẩm:%d\n",quantity);
        System.out.printf("Thẻ thành viên:%s\n",flag);
        System.out.printf("Tổng Tiền thanh toán: %.2f",thanhToan);
    }
}
