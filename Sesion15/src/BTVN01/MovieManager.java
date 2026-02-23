package BTVN01;

import java.util.ArrayList;

public class MovieManager<T extends Movie> {
    private ArrayList<T> movies = new ArrayList<>();

    public void addMovie(T movie) {
        movies.add(movie);
    }

    public boolean removeMovie(int id) {
        return movies.removeIf(m -> m.getId() == id);
    }

    public T findById(int id) {
        for (T m : movies) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("Danh sách phim trống.");
            return;
        }
        movies.forEach(System.out::println);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (T m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Phim tìm thấy: " + m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phim");
        }
    }

    public void filterByRating(double minRating) {
        boolean found = false;
        for (T m : movies) {
            if (m.getRating() > minRating) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có phim nào thỏa điều kiện");
        }
    }
}