package Business;
import Model.Student;
import java.util.List;

public interface IStudentService {
    boolean register(Student student);
    Student findStudentByEmail(String email);
    Student login(String email, String pass);
    //admin
    List<Student> findAll();

    void saveStudent(Student student);

    Student findById(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> search(String keyword);

    List<Student> sortByName();

    List<Student> sortById();

    boolean changePassword(int studentId, String oldPass, String newPass);
}