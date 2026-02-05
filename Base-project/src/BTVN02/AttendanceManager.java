package BTVN02;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student> {

    private List<Student> students = new ArrayList<>();

    @Override
    public void add(Student item) {
        students.add(item);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void update(int index, Student item) {
        students.get(index).setName(item.getId() == students.get(index).getId()
                ? item.getId() + "" : item.getId() + "");
        students.set(index, item);
        System.out.println("Sinh viên đã được sửa thành công.");
    }

    @Override
    public void delete(int index) {
        students.remove(index);
        System.out.println("Đã xóa thành công sinh viên !");
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}