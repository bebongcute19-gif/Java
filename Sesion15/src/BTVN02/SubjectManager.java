package BTVN02;
import java.util.ArrayList;
import java.util.Optional;
public class SubjectManager<T extends Subject> {
    private ArrayList<T> subjects = new ArrayList<>();

    public void add(T subject) {
        subjects.add(subject);
    }

    public void display() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học trống.");
            return;
        }
        subjects.forEach(System.out::println);
    }

    public void removeByCode(String code) {
        boolean removed = subjects.removeIf(s -> s.getCode().equalsIgnoreCase(code));
        if (!removed) {
            System.out.println("Không tìm thấy môn học có code: " + code);
        } else {
            System.out.println("Xóa môn học thành công.");
        }
    }

    public void searchByName(String name) {
        Optional<T> result = subjects.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();

        result.ifPresentOrElse(
                s -> System.out.println("Môn học tìm thấy: " + s),
                () -> System.out.println("Không có môn học phù hợp")
        );
    }

    public void filterByCredits() {
        subjects.stream()
                .filter(s -> s.getCredits() > 3)
                .forEach(System.out::println);
    }
}
