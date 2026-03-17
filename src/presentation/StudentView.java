package presentation;
import model.Student;
import business.IStudentService;
import business.impl.StudentServiceImpl;
import java.util.Scanner;
import business.IEnrollmentService;
import business.impl.EnrollmentServiceImpl;
import business.ICourseService;
import business.impl.CourseServiceImpl;
import model.Course;

import java.util.List;
import model.Enrollment;

public class StudentView {
    public static Student userLogin = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentService studentService = new StudentServiceImpl();
    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
    private static final ICourseService courseService = new CourseServiceImpl();
    public static void showMenuLogin(Scanner sc){
        // Nập thông tin
        System.out.println("---Đăng nhập---");
        System.out.println("Nhập email : ");
        String email = sc.nextLine();
        System.out.println("Nhập pass : ");
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
            System.out.println("=============================");
            System.out.println("Chọn chức năng");
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
                    registerCourse(student);
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

        System.out.println("===== DANH SÁCH KHÓA HỌC =====");

        System.out.printf("%-5s %-25s %-10s %-20s\n",
                "ID","COURSE NAME","DURATION","INSTRUCTOR");

        for(Course c : list){
            System.out.printf("%-5d %-25s %-10s %-20s\n",
                    c.getId(),
                    c.getName(),
                    c.getDuration(),
                    c.getInstructor());
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
    private static void registerCourse(Student student){

        showAllCourse(); // hiển thị danh sách khóa học trước

        int courseId;

        while(true){

            System.out.print("Nhập ID khóa học muốn đăng ký: ");

            try{
                courseId = Integer.parseInt(scanner.nextLine());
                break;
            }catch(Exception e){
                System.out.println("ID phải là số!");
            }
        }

        boolean rs = enrollmentService.registerCourse(student.getId(), courseId);

        if(rs){
            System.out.println("Đăng ký thành công (chờ duyệt)");
        }else{
            System.out.println("Bạn đã đăng ký khóa học này!");
        }
    }

    public static void showRegisteredCourses(Student student){

        List<Enrollment> list = enrollmentService.findByStudentId(student.getId());

        if(list.isEmpty()){
            System.out.println("Bạn chưa đăng ký khóa học nào");
            return;
        }

        System.out.printf("%-5s %-25s %-12s %-20s\n",
                "ID","COURSE","STATUS","REGISTER DATE");

        for(Enrollment e : list){
            System.out.printf("%-5d %-25s %-12s %-20s\n",
                    e.getId(),
                    e.getCourseName(),
                    e.getStatus(),
                    e.getRegisteredAt());
        }
    }
    public static void cancelEnrollment(Student student){

        List<Enrollment> list = enrollmentService.findByStudentId(student.getId());

        if(list.isEmpty()){
            System.out.println("Bạn chưa đăng ký khóa học nào!");
            return;
        }

        // lọc các đăng ký WAITING
        List<Enrollment> waitingList = list.stream()
                .filter(e -> "WAITING".equals(e.getStatus()))
                .toList();

        if(waitingList.isEmpty()){
            System.out.println("Không có khóa học nào có thể hủy!");
            return;
        }

        System.out.println("===== DANH SÁCH CÓ THỂ HỦY =====");

        System.out.printf("%-5s %-25s %-12s %-20s\n",
                "ID","COURSE","STATUS","REGISTER DATE");

        for(Enrollment e : waitingList){
            System.out.printf("%-5d %-25s %-12s %-20s\n",
                    e.getId(),
                    e.getCourseName(),
                    e.getStatus(),
                    e.getRegisteredAt());
        }

        int id;

        while(true){

            System.out.print("Nhập ID đăng ký cần hủy: ");

            try{
                id = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("ID phải là số!");
                continue;
            }

            boolean exists = false;

            for(Enrollment e : waitingList){
                if(e.getId() == id){
                    exists = true;
                    break;
                }
            }

            if(exists){
                break;
            }else{
                System.out.println("ID không hợp lệ hoặc không phải WAITING!");
            }
        }

        // confirm
        System.out.println("Bạn có chắc muốn hủy đăng ký?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        System.out.print("Chọn: ");

        int confirm;

        try{
            confirm = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        if(confirm != 1){
            System.out.println("Đã hủy thao tác.");
            return;
        }

        boolean result = enrollmentService.cancelEnrollment(id, student.getId());

        if(result){
            System.out.println("Hủy đăng ký thành công!");
        }else{
            System.out.println("Hủy thất bại! Có thể đăng ký đã được duyệt.");
        }
    }
    public static void sortRegisteredCourses(Student student){

        int type;

        while(true){
            System.out.println("===== SẮP XẾP KHÓA HỌC ĐÃ ĐĂNG KÝ =====");
            System.out.println("1. Theo tên");
            System.out.println("2. Theo ngày đăng ký");
            System.out.print("Chọn: ");

            try{
                type = Integer.parseInt(scanner.nextLine());

                if(type == 1 || type == 2){
                    break; // nhập đúng → thoát vòng lặp
                }else{
                    System.out.println("Chỉ được chọn 1 hoặc 2. Vui lòng nhập lại!");
                }

            }catch(Exception e){
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        List<Enrollment> list = enrollmentService.sortCourses(student.getId(), type);

        if(list == null || list.isEmpty()){
            System.out.println("Bạn chưa đăng ký khóa học nào");
            return;
        }

        System.out.printf("%-25s  %-15s\n", "COURSE NAME", "REGISTER DATE");

        list.forEach(e ->
                System.out.printf("%-25s  %-15s\n",
                        e.getCourseName(),
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