package business;
import model.Student;
import java.util.List;

public interface IStudentService {
    boolean register(Student student);
    Student findStudentByEmail(String email);
    Student login(String email, String pass);
    //admin
    List<Student> findAll();

    Student findById(int id);

    void updateStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> search(String keyword);

    List<Student> sortById(String order);


    List<Student> sortByName(String order);

    boolean changePassword(int studentId, String oldPass, String newPass);

    Student findStudentByPhone(String phone);
}