package Presentation;
import org.mindrot.jbcrypt.BCrypt;
import DAO.IStudentDao;
import DAO.impl.StudentDaoImpl;
import Model.Student;
import Business.IStudentService;
import Business.Impl.StudentServiceImpl;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentView {
    public static Student userLogin = null;
    private static final IStudentService studentService = new StudentServiceImpl();
    public static void showMenuLogin(Scanner sc){
        // Nập thông tin
        System.out.println("Nhap email : ");
        String email = sc.nextLine();
        System.out.println("Nhap pass : ");
        String pass = sc.nextLine();

        Student s = studentService.login(email,pass);
        if (s!=null){
            System.out.println("Đăng nhập thành công");
            userLogin  = s;
            // chuyển sang menu của sinh viên
            sc.nextLine();
        }else {
            System.err.println("Thông tin đăng nhập ko đúng , vui long thử lai");
            showMenuLogin(sc);
        }
    }
    public static void showMenuRegister(Scanner sc){

        System.out.println("Nhập tên sinh viên");
        String name = sc.nextLine();

        System.out.println("Nhập ngày sinh (yyyy-MM-dd)");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        // ===== KIỂM TRA EMAIL TRÙNG =====
        String email;

        while(true){
            System.out.println("Nhập email:");
            email = sc.nextLine();

            Student check = studentService.findStudentByEmail(email);

            if(check != null){
                System.out.println("Email đã tồn tại! Vui lòng nhập email khác.");
            }else{
                break;
            }
        }

        System.out.println("Chọn giới tính (true - nam / false - nữ)");
        boolean sex = Boolean.parseBoolean(sc.nextLine());

        System.out.println("Nhập Phone");
        String phone = sc.nextLine();

        System.out.println("Nhập pass");
        String pass = sc.nextLine();

        Student s = new Student(name,dob,email,sex,phone,pass);

        boolean result = studentService.register(s);

        if(result){
            System.out.println("Đăng ký thành công!");
            showMenuLogin(sc);
        }
    }
}