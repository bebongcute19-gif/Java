package BTVN02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 45000));
        books.add(new Book("Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 88000));
        books.add(new Book("Nhà Giả Kim", "Paulo Coelho", 72000));

        for (Book book : books) {
            book.printInfo();
        }
    }
}
