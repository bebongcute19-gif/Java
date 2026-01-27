package BTVN01;

public class Main {
    public static void main(String[] args) {

        // Cách 1: Tạo object bằng constructor có tham số
        Rectangle rect1 = new Rectangle(5.5, 3.2);

        System.out.println("Diện tích: " + rect1.getArea());
        System.out.println("Chu vi: " + rect1.getPerimeter());

        System.out.println("------------------");

        // Cách 2: Tạo object rồi set giá trị (nếu có setter)
        Rectangle rect2 = new Rectangle();
        // giả sử set trực tiếp qua constructor là đủ cho bài này

        rect2 = new Rectangle(10, 4);
        rect2.printInfo();
    }
}
