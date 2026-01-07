public class Varriable {
    public static void main(String[] args) {
        // cú pháp khai báo và khởi tạo
        // datatype +name = value
        int number=10;
        float point=10.5f;
        double mark=10.5;
        System.out.println("gia trị của number= "+ number);
        //hằng số
        final byte number3=10;
        //phép gán; thay đổi giá trị biên
        point = 10.5f;
        final short number4=10;
        final int number5=10;
        mark = number ;// ép kiểu ngầm định từ dữ liệu nhỏ sang lớn
        number =(int) mark ; // tràn dữ liệu -> ép kiểu tường minh
        // toán tử gán
        point -=1.5 ;// point = point -1.5
        // toans tử so sánh
        //toán tử logic
        boolean result = true || false ||2>3||false; // result = true
        boolean rs = 2>3 && 3>4 && 4>5;
        boolean not = !true;// false
        // toán tử tăng giảm: tiền tố là sau khi tăng hoặc giảm và hậu tố là trước khi tăng hoặc giảm
        int a = 10;
        a--;// a=9
        System.out.println("a--="+(a--));

}
}
