package dao;
import model.Student;
import java.util.List;
public interface IStudentDao {
    void saveStudent(Student student);
    Student findStudentByEmail(String email);
    // ===== ADMIN =====

    List<Student> findAll();      // hiển thị danh sách

    Student findById(int id);     // tìm theo id

    void updateStudent(Student student); // chỉnh sửa

    void deleteStudent(int id);   // xóa

    List<Student> search(String keyword); // tìm kiếm

    List<Student> sortByName();   // sắp xếp theo tên

    List<Student> sortById();

    boolean changePassword(int studentId, String newPass);

    Student findStudentByPhone(String phone);
}