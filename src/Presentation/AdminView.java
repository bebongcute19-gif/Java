package Presentation;

import Model.Admin;
import Business.IAdminService;
import Business.Impl.AdminServiceImpl;
import Business.ICourseService;
import Business.Impl.CourseServiceImpl;
import java.util.Scanner;
import Model.Course;
import java.util.List;
import Business.IStudentService;
import Business.Impl.StudentServiceImpl;
import Model.Student;
import java.time.LocalDate;
import Model.Enrollment;
import Business.IEnrollmentService;
import Business.Impl.EnrollmentServiceImpl;
public class AdminView {

    public static Admin adminLogin = null;
    private static final IAdminService adminService = new AdminServiceImpl();
    private static final ICourseService courseService = new CourseServiceImpl();
    private static final IStudentService studentService = new StudentServiceImpl();
    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

    public static void showMenuLogin(Scanner sc){

        String username;
        String pass;

        // nhập username
        while (true){
            System.out.println("Nhập username: ");
            username = sc.nextLine();

            if(username.trim().isEmpty()){
                System.err.println("Username không được để trống!");
            }else{
                break;
            }
        }

        // nhập password
        while (true){
            System.out.println("Nhập password: ");
            pass = sc.nextLine();

            if(pass.trim().isEmpty()){
                System.err.println("Password không được để trống!");
            }else{
                break;
            }
        }

        Admin admin = adminService.login(username, pass);

        if(admin != null){
            System.out.println("Đăng nhập admin thành công");
            adminLogin = admin;

            showMenuAdmin(sc);
        }else{
            System.err.println("Thông tin đăng nhập không đúng, vui lòng thử lại");
            showMenuLogin(sc);
        }
    }
    public static void showMenuAdmin(Scanner sc) {

        while (true) {
            System.out.println("======== MENU ADMIN ========");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý học viên");
            System.out.println("3. Quản lý đăng ký học");
            System.out.println("4. Thống kê học viên theo khóa học");
            System.out.println("5. Đăng xuất");
            System.out.println("============================");

            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Chức năng quản lý khóa học");
                    menuCourse(sc);
                    break;

                case 2:
                    System.out.println("Chức năng quản lý học viên");
                    menuStudent(sc);
                    break;

                case 3:
                    System.out.println("Chức năng quản lý đăng ký học");
                    menuEnrollment(sc);
                    break;

                case 4:
                    System.out.println("Thống kê học viên theo khóa học");
                    break;

                case 5:
                    System.out.println("Đăng xuất...");
                    adminLogin = null;
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    public static void menuCourse(Scanner sc){

        while(true){
            System.out.println("===== QUẢN LÝ KHÓA HỌC =====");
            System.out.println("1. Hiển thị danh sách khóa học");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Chỉnh sửa khóa học");
            System.out.println("4. Xóa khóa học");
            System.out.println("5. Tìm kiếm khóa học");
            System.out.println("6. Sắp xếp khóa học");
            System.out.println("0. Quay lại");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    findAll();
                    break;
                case 2:
                    addCourse(sc);
                    break;
                case 3:
                    updateCourse(sc);
                    break;
                case 4:
                    deleteCourse(sc);
                    break;
                case 5:
                    searchCourse(sc);
                    break;
                case 6:
                    sortCourse(sc);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
    public static void findAll(){

        List<Course> list = courseService.findAll();

        if(list.isEmpty()){
            System.out.println("Danh sách khóa học trống!");
            return;
        }
        System.out.println("ID | NAME | DURATION | INSTRUCTOR");
        System.out.println("-----------------------------------");

        for(Course c : list){
            System.out.printf("%d | %s | %d | %s\n",
                    c.getId(),
                    c.getName(),
                    c.getDuration(),
                    c.getInstructor());
        }

    }
    public static void addCourse(Scanner sc){

        System.out.println("Nhập tên khóa học:");
        String name = sc.nextLine();

        System.out.println("Nhập thời lượng:");
        int duration = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập giảng viên:");
        String instructor = sc.nextLine();

        Course course = new Course(name,duration,instructor);

        courseService.saveCourse(course);

        System.out.println("Thêm khóa học thành công!");
    }
    public static void updateCourse(Scanner sc){

        System.out.println("Nhập ID khóa học cần sửa:");
        int id = Integer.parseInt(sc.nextLine());

        Course course = courseService.findById(id);

        if(course == null){
            System.out.println("Không tìm thấy khóa học!");
            return;
        }

        System.out.println("Nhập tên mới:");
        course.setName(sc.nextLine());

        System.out.println("Nhập thời lượng mới:");
        course.setDuration(Integer.parseInt(sc.nextLine()));

        System.out.println("Nhập giảng viên mới:");
        course.setInstructor(sc.nextLine());

        courseService.updateCourse(course);

        System.out.println("Cập nhật thành công!");
    }
    public static void deleteCourse(Scanner sc){

        System.out.println("Nhập ID khóa học cần xóa:");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Bạn có chắc muốn xóa? (y/n)");
        String confirm = sc.nextLine();

        if(confirm.equalsIgnoreCase("y")){
            courseService.deleteCourse(id);
            System.out.println("Xóa khóa học thành công!");
        }else{
            System.out.println("Đã hủy xóa");
        }

    }
    public static void searchCourse(Scanner sc){

        System.out.println("Nhập tên khóa học cần tìm:");
        String keyword = sc.nextLine();

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
    public static void sortCourse(Scanner sc){

        System.out.println("1. Sắp xếp theo ID");
        System.out.println("2. Sắp xếp theo tên");

        int choice = Integer.parseInt(sc.nextLine());

        List<Course> list;

        if(choice == 1){
            list = courseService.sortById();
        }else{
            list = courseService.sortByName();
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
   // quản lý học sinh
    public static void menuStudent(Scanner sc){

        while(true){

            System.out.println("===== QUẢN LÝ HỌC VIÊN =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa học viên");
            System.out.println("4. Xóa học viên");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Quay lại");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){

                case 1:
                    findAllStudent();
                    break;

                case 2:
                    addStudent(sc);
                    break;

                case 3:
                    updateStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    searchStudent(sc);
                    break;

                case 6:
                    sortStudent(sc);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
    public static void findAllStudent(){

        List<Student> list = studentService.findAll();

        if(list.isEmpty()){
            System.out.println("Danh sách học viên trống!");
            return;
        }

        System.out.println("ID | NAME | DOB | EMAIL | PHONE | SEX");

        for(Student s : list){
            System.out.println(
                    s.getId()+" | "+
                            s.getName()+" | "+
                            s.getDob()+" | "+
                            s.getEmail()+" | "+
                            s.getPhone()+" | "+
                            (s.getSex() ? "Nam" : "Nữ")
            );
        }
    }
    public static void addStudent(Scanner sc){


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


        System.out.println("Thêm học viên thành công!");
    }
    public static void updateStudent(Scanner sc){

        System.out.println("Nhập ID học viên cần sửa:");
        int id = Integer.parseInt(sc.nextLine());

        Student student = studentService.findById(id);

        if(student == null){
            System.out.println("Không tìm thấy học viên!");
            return;
        }

        System.out.println("Nhập tên mới:");
        student.setName(sc.nextLine());

        System.out.println("Nhập ngày sinh mới (yyyy-mm-dd):");
        student.setDob(LocalDate.parse(sc.nextLine()));

        System.out.println("Nhập email mới:");
        student.setEmail(sc.nextLine());

        System.out.println("Nhập phone mới:");
        student.setPhone(sc.nextLine());

        System.out.println("Nhập giới tính mới (true/false):");
        student.setSex(Boolean.parseBoolean(sc.nextLine()));

        studentService.updateStudent(student);

        System.out.println("Cập nhật thành công!");
    }
    public static void deleteStudent(Scanner sc){

        System.out.println("Nhập ID học viên cần xóa:");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Bạn có chắc muốn xóa? (y/n)");
        String confirm = sc.nextLine();

        if(confirm.equalsIgnoreCase("y")){
            studentService.deleteStudent(id);
            System.out.println("Xóa thành công!");
        }else{
            System.out.println("Đã hủy xóa");
        }
    }
    public static void searchStudent(Scanner sc){

        System.out.println("Nhập tên hoặc email cần tìm:");
        String keyword = sc.nextLine();

        List<Student> list = studentService.search(keyword);

        if(list.isEmpty()){
            System.out.println("Không tìm thấy học viên!");
            return;
        }

        for(Student s : list){
            System.out.println(
                    s.getId()+" | "+
                            s.getName()+" | "+
                            s.getDob()+" | "+
                            s.getEmail()+" | "+
                            s.getPhone()+" | "+
                            (s.getSex() ? "Nam" : "Nữ")
            );
        }
    }

    public static void sortStudent(Scanner sc){

        System.out.println("1. Sắp xếp theo ID");
        System.out.println("2. Sắp xếp theo tên");

        int choice = Integer.parseInt(sc.nextLine());

        List<Student> list;

        if(choice == 1){
            list = studentService.sortById();
        }else{
            list = studentService.sortByName();
        }

        for(Student s : list){
            System.out.println(
                    s.getId()+" | "+
                            s.getName()+" | "+
                            s.getDob()+" | "+
                            s.getEmail()+" | "+
                            s.getPhone()
            );
        }
    }
    public static void menuEnrollment(Scanner sc){

        while(true){

            System.out.println("===== QUẢN LÝ ĐĂNG KÝ KHÓA HỌC =====");
            System.out.println("1. Danh sách đăng ký");
            System.out.println("2. Danh sách theo khóa học");
            System.out.println("3. Duyệt đăng ký");
            System.out.println("4. Xóa sinh viên khỏi khóa học");
            System.out.println("0. Quay lại");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){

                case 1:
                    showAllEnrollment();
                    break;

                case 2:
                    findByCourse(sc);
                    break;

                case 3:
                    approveEnrollment(sc);
                    break;

                case 4:
                    deleteEnrollment(sc);
                    break;

                case 0:
                    return;
            }
        }
    }
    public static void showAllEnrollment(){

        List<Enrollment> list = enrollmentService.findAll();

        for(Enrollment e : list){

            System.out.println(
                    e.getId()+" | "+
                            e.getStudentName()+" | "+
                            e.getCourseName()+" | "+
                            e.getStatus()+" | "+
                            e.getRegisteredAt()
            );
        }
    }
    public static void findByCourse(Scanner sc){

        System.out.print("Nhập ID khóa học: ");
        int id = Integer.parseInt(sc.nextLine());

        List<Enrollment> list = enrollmentService.findByCourse(id);

        list.forEach(e ->
                System.out.println(
                        e.getStudentName()+" | "+
                                e.getCourseName()+" | "+
                                e.getStatus()
                )
        );
    }
    public static void approveEnrollment(Scanner sc){

        List<Enrollment> list = enrollmentService.findWaitingEnrollments();

        if(list.isEmpty()){
            System.out.println("Không có đăng ký nào cần duyệt");
            return;
        }

        System.out.println("===== DANH SÁCH CHỜ DUYỆT =====");
        System.out.println("ID | STUDENT | COURSE | DATE");

        for(Enrollment e : list){
            System.out.println(
                    e.getId()+" | "+
                            e.getStudentName()+" | "+
                            e.getCourseName()+" | "+
                            e.getRegisteredAt()
            );
        }

        System.out.print("Nhập ID đăng ký: ");
        int id = Integer.parseInt(sc.nextLine());

        // tìm enrollment theo id
        Enrollment enrollment = list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if(enrollment == null){
            System.out.println("Không tìm thấy đăng ký");
            return;
        }

        // hiển thị chi tiết
        System.out.println("===== THÔNG TIN ĐĂNG KÝ =====");
        System.out.println("Student : " + enrollment.getStudentName());
        System.out.println("Course  : " + enrollment.getCourseName());
        System.out.println("Date    : " + enrollment.getRegisteredAt());

        // chọn hành động
        System.out.println("1. Duyệt");
        System.out.println("2. Từ chối");
        System.out.println("0. Hủy");

        int choice = Integer.parseInt(sc.nextLine());

        switch(choice){

            case 1:
                if(enrollmentService.approve(id, adminLogin.getId())){
                    System.out.println("Duyệt thành công");
                }else{
                    System.out.println("Duyệt thất bại");
                }
                break;

            case 2:
                if(enrollmentService.reject(id)){
                    System.out.println("Đã từ chối đăng ký");
                }else{
                    System.out.println("Từ chối thất bại");
                }
                break;

            case 0:
                System.out.println("Đã hủy thao tác");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
    }
    public static void deleteEnrollment(Scanner sc){
        System.out.println("---Xóa sinh viên khỏi khóa học---");
        System.out.print("Nhập ID đăng ký: ");
        int id = Integer.parseInt(sc.nextLine());

        if(enrollmentService.delete(id)){
            System.out.println("Xóa thành công");
        }else{
            System.out.println("Xóa thất bại");
        }
    }
}