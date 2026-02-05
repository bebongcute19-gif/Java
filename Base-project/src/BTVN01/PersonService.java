package BTVN01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonService {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Người dùng đã được thêm thành công.");
    }

    public void deleteByEmail(String email) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEmail().equalsIgnoreCase(email)) {
                iterator.remove();
                System.out.println("Người dùng đã được xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng với email này.");
    }

    public void showAll() {
        if (people.isEmpty()) {
            System.out.println("Danh sách người dùng trống.");
            return;
        }
        System.out.println("Danh sách người dùng:");
        for (Person p : people) {
            p.display();
        }
    }
}