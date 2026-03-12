package Presentation;
import Model.Student;
import Business.IStudentService;
import Business.Impl.StudentServiceImpl;
import java.time.LocalDate;
import java.util.Scanner;
import Business.IEnrollmentService;
import Business.Impl.EnrollmentServiceImpl;
import Business.ICourseService;
import Business.Impl.CourseServiceImpl;
import Model.Course;

import java.util.List;
import Model.Enrollment;

public class StudentView {
    public static Student userLogin = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentService studentService = new StudentServiceImpl();
    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
    private static final ICourseService courseService = new CourseServiceImpl();
    public static void showMenuLogin(Scanner sc){
        // Nập thông tin
        System.out.println("---Đăng nhập---");
        System.out.println("Nhap email : ");
        String email = sc.nextLine();
        System.out.println("Nhap pass : ");
        String pass = sc.nextLine();

        Student s = studentService.login(email,pass);
        if (s!=null){
            System.out.println("Đăng nhập thành công");
            userLogin  = s;

            studentMenu(s);   // mở menu sinh viên
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
    public static void studentMenu(Student student){

        while(true){

            System.out.println("========= MENU HỌC VIÊN =========");
            System.out.println("1. Xem danh sách khóa học");
            System.out.println("2. Tìm kiếm khóa học");
            System.out.println("3. Đăng ký khóa học");
            System.out.println("4. Xem khóa học đã đăng ký");
            System.out.println("5. Sắp xếp khóa học đã đăng ký");
            System.out.println("6. Hủy đăng ký");
            System.out.println("7. Đổi mật khẩu");
            System.out.println("0. Đăng xuất");

            int choice;

            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice){

                case 1:
                    showAllCourse();
                    break;

                case 2:
                    searchCourse();
                    break;

                case 3:
                    System.out.print("Nhập ID khóa học: ");
                    int courseId = Integer.parseInt(scanner.nextLine());

                    boolean rs = enrollmentService.registerCourse(student.getId(),courseId);

                    if(rs){
                        System.out.println("Đăng ký thành công");
                    }else{
                        System.out.println("Bạn đã đăng ký khóa học này");
                    }
                    break;

                case 4:
                    showRegisteredCourses(student);
                    break;

                case 5:
                    sortRegisteredCourses(student);
                    break;

                case 6:
                    cancelEnrollment(student);
                    break;

                case 7:
                    changePassword(student);
                    break;

                case 0:
                    return;
            }
        }
    }
    public static void showAllCourse(){

        List<Course> list = courseService.findAll();

        if(list.isEmpty()){
            System.out.println("Không có khóa học nào!");
            return;
        }

        System.out.println("ID | NAME | DURATION | INSTRUCTOR");

        for(Course c : list){
            System.out.println(
                    c.getId()+" | "+
                            c.getName()+" | "+
                            c.getDuration()+" | "+
                            c.getInstructor()
            );
        }
    }

    public static void searchCourse(){

        System.out.print("Nhập tên khóa học: ");
        String keyword = scanner.nextLine();

        List<Course> list = courseService.searchByName(keyword);

        if(list.isEmpty()){
            System.out.println("Không tìm thấy khóa học!");
            return;
        }

        for(Course c : list){
            System.out.println(
                    c.getId()+" | "+
                            c.getName()+" | "+
                            c.getDuration()+" | "+
                            c.getInstructor()
            );
        }
    }

    public static void showRegisteredCourses(Student student){

        List<Enrollment> list = enrollmentService.findByStudentId(student.getId());

        if(list.isEmpty()){
            System.out.println("Bạn chưa đăng ký khóa học nào");
            return;
        }

        list.forEach(e ->
                System.out.println(
                        e.getId()+" | "+
                                e.getCourseName()+" | "+
                                e.getStatus()+" | "+
                                e.getRegisteredAt()
                )
        );
    }
    public static void cancelEnrollment(Student student){

        System.out.print("Nhập ID đăng ký cần hủy: ");

        int id;

        try{
            id = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            System.out.println("ID không hợp lệ");
            return;
        }

        if(enrollmentService.cancelEnrollment(id,student.getId())){
            System.out.println("Hủy thành công");
        }else{
            System.out.println("Không thể hủy (đã được duyệt)");
        }
    }
    public static void sortRegisteredCourses(Student student){

        System.out.println("1. Theo tên");
        System.out.println("2. Theo ngày đăng ký");

        int type = Integer.parseInt(scanner.nextLine());

        List<Enrollment> list = enrollmentService.sortCourses(student.getId(),type);

        list.forEach(e ->
                System.out.println(
                        e.getCourseName()+" | "+
                                e.getRegisteredAt()
                )
        );
    }
    public static void changePassword(Student student){

        System.out.print("Nhập mật khẩu cũ: ");
        String oldPass = scanner.nextLine();

        System.out.print("Nhập mật khẩu mới: ");
        String newPass = scanner.nextLine();

        boolean result = studentService.changePassword(student.getId(),oldPass,newPass);

        if(result){
            System.out.println("Đổi mật khẩu thành công");
        }else{
            System.out.println("Mật khẩu cũ không đúng");
        }
    }

}