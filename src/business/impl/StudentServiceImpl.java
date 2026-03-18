package business.impl;

import business.IStudentService;
import org.mindrot.jbcrypt.BCrypt;
import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements IStudentService {

    private static final IStudentDao studentDao = new StudentDaoImpl();

    // ================= REGISTER =================
    @Override
    public boolean register(Student student) {

        Student check = studentDao.findStudentByEmail(student.getEmail());

        if(check != null){
            return false;
        }

        student.setPassword(
                BCrypt.hashpw(student.getPassword(), BCrypt.gensalt(12))
        );

        studentDao.saveStudent(student);
        return true;
    }
        @Override
        public Student findStudentByEmail(String email) {
            return studentDao.findStudentByEmail(email);
        }

    // ================= LOGIN =================
    @Override
    public Student login(String email, String pass) {

        Student s = studentDao.findStudentByEmail(email);

        if (s != null && BCrypt.checkpw(pass, s.getPassword())){
            return s;
        }

        return null;
    }

    // ================= ADMIN =================

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void saveStudent(Student student) {

        student.setPassword(
                BCrypt.hashpw(student.getPassword(), BCrypt.gensalt(12))
        );

        studentDao.saveStudent(student);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> search(String keyword) {
        return studentDao.search(keyword);
    }

    @Override
    public List<Student> sortByName() {
        return studentDao.sortByName();
    }

    @Override
    public List<Student> sortById() {
        return studentDao.sortById();
    }

    @Override
    public boolean changePassword(int studentId, String oldPass, String newPass) {

        // lấy thông tin sinh viên
        Student student = studentDao.findById(studentId);

        if(student == null){
            return false;
        }

        // kiểm tra mật khẩu cũ bằng BCrypt
        if(!BCrypt.checkpw(oldPass, student.getPassword())){
            return false;
        }

        // hash mật khẩu mới
        String hashedPassword = BCrypt.hashpw(newPass, BCrypt.gensalt(12));

        // cập nhật mật khẩu
        return studentDao.changePassword(studentId, hashedPassword);
    }
    @Override
    public Student findStudentByPhone(String phone) {
        return studentDao.findStudentByPhone(phone);
    }
}