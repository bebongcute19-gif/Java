package BTVN04;

public class Book {

    // Thuộc tính (public theo sơ đồ UML)
    public String title;
    public String author;
    public double price;

    // Phương thức
    public void printInfo() {
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Giá: " + price);
    }
}
