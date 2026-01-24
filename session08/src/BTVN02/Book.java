package BTVN02;

public class Book {

    // Thuộc tính
    String title;
    String author;
    double price;

    // Constructor sử dụng this
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Hàm main
    public static void main(String[] args) {
        // Tạo đối tượng Book
        Book book1 = new Book("Clean Code", "Robert C. Martin", 29.99);

        // In thông tin sách
        System.out.println(
                "Title: " + book1.title +
                        ", Author: " + book1.author +
                        ", Price: " + book1.price
        );
    }
}
