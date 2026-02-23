package BTVN01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MovieManager<Movie> manager = new MovieManager<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addMovie();
                case 2 -> deleteMovie();
                case 3 -> updateMovie();
                case 4 -> manager.displayMovies();
                case 5 -> searchMovie();
                case 6 -> filterMovie();
                case 7 -> System.out.println("Đã thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 7);
    }

    static void showMenu() {
        System.out.println("\nChọn chức năng:");
        System.out.println("1. Thêm phim");
        System.out.println("2. Xóa phim");
        System.out.println("3. Sửa phim");
        System.out.println("4. Hiển thị phim");
        System.out.println("5. Tìm kiếm phim theo tên");
        System.out.println("6. Lọc phim theo rating");
        System.out.println("7. Thoát");
    }

    static void addMovie() {
        try {
            System.out.print("Nhập ID phim: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập tiêu đề phim: ");
            String title = scanner.nextLine();

            System.out.print("Nhập đạo diễn: ");
            String director = scanner.nextLine();

            System.out.print("Nhập ngày phát hành (dd-MM-yyyy): ");
            LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.print("Nhập rating: ");
            double rating = Double.parseDouble(scanner.nextLine());

            manager.addMovie(new Movie(id, title, director, date, rating));
            System.out.println("Phim đã được thêm thành công.");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID hoặc rating phải là số.");
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Sai định dạng ngày.");
        }
    }

    static void deleteMovie() {
        System.out.print("Nhập ID phim cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (manager.removeMovie(id)) {
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim muốn xóa !");
        }
    }

    static void updateMovie() {
        System.out.print("Nhập ID phim muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Movie movie = manager.findById(id);

        if (movie == null) {
            System.out.println("Không tìm thấy phim với id = " + id);
            return;
        }

        try {
            System.out.print("Nhập tiêu đề phim: ");
            movie.setTitle(scanner.nextLine());

            System.out.print("Nhập đạo diễn: ");
            movie.setDirector(scanner.nextLine());

            System.out.print("Nhập ngày phát hành (dd-MM-yyyy): ");
            movie.setReleaseDate(LocalDate.parse(scanner.nextLine(), formatter));

            System.out.print("Nhập rating: ");
            movie.setRating(Double.parseDouble(scanner.nextLine()));

            System.out.println("Cập nhật phim thành công !");
        } catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ!");
        }
    }

    static void searchMovie() {
        System.out.print("Nhập tên phim để tìm kiếm: ");
        manager.searchByTitle(scanner.nextLine());
    }

    static void filterMovie() {
        System.out.print("Nhập rating tối thiểu để lọc: ");
        double rating = Double.parseDouble(scanner.nextLine());
        manager.filterByRating(rating);
    }
}
