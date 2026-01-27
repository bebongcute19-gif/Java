package BTVN02;

public class Book {
    // 1. Thuộc tính
    private String title;
    private String author;
    private double price;

    // 2. Constructor không tham số
    public Book() {
    }

    // 3. Constructor có tham số (khuyến khích)
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 4. Phương thức in thông tin sách
    public void printInfo() {
        System.out.println("Tên sách : " + title);
        System.out.println("Tác giả  : " + author);
        System.out.println("Giá tiền : " + price + " VND");
        System.out.println("-------------------------");
    }
}
