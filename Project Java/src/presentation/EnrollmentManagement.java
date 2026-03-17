package presentation;

import business.IEnrollmentService;
import business.impl.EnrollmentServiceImpl;
import model.Enrollment;

import java.util.List;
import java.util.Scanner;

public class EnrollmentManagement {

    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

    public static void menuEnrollment(Scanner sc){

        while(true){

            System.out.println("===== QUẢN LÝ ĐĂNG KÝ KHÓA HỌC =====");
            System.out.println("1. Hiển thị học viên theo từng khóa học");
            System.out.println("2. Thêm học viên vào khóa học");
            System.out.println("3. Duyệt học viên đăng ký khóa học");
            System.out.println("4. Xóa học viên khỏi khóa học");
            System.out.println("0. Quay về menu chính");
            System.out.print("Chọn chức năng: ");

            int choice;

            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice){

                case 1:
                    showStudentByCourse(sc);
                    break;

                case 2:
                    addStudentToCourse(sc);
                    break;

                case 3:
                    approveEnrollment(sc);
                    break;

                case 4:
                    deleteEnrollment(sc);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // ===============================
    // Hiển thị học viên theo khóa học
    // ===============================
    public static void showStudentByCourse(Scanner sc){

        System.out.println("===== DANH SÁCH KHÓA HỌC =====");

        CourseManagement.showAllCourse();

        System.out.print("Nhập ID khóa học: ");

        int courseId;

        try{
            courseId = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("ID phải là số!");
            return;
        }

        List<Enrollment> list = enrollmentService.findByCourse(courseId);

        if(list.isEmpty()){
            System.out.println("Không có học viên trong khóa học này!");
            return;
        }

        System.out.printf("%-5s %-20s %-20s\n","ID","STUDENT","COURSE");

        for(Enrollment e : list){
            System.out.printf("%-5d %-20s %-20s\n",
                    e.getId(),
                    e.getStudentName(),
                    e.getCourseName());
        }
    }

    // ===============================
    // Thêm học viên vào khóa học
    // ===============================
    public static void addStudentToCourse(Scanner sc){

        System.out.println("===== DANH SÁCH HỌC VIÊN =====");

        StudentManagement.showAllStudents();

        System.out.print("Nhập ID học viên: ");

        int studentId;

        try{
            studentId = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("ID phải là số!");
            return;
        }

        System.out.println("===== DANH SÁCH KHÓA HỌC =====");

        CourseManagement.showAllCourse();

        System.out.print("Nhập ID khóa học: ");

        int courseId;

        try{
            courseId = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("ID phải là số!");
            return;
        }

        if(enrollmentService.add(studentId, courseId)){
            System.out.println("Thêm học viên vào khóa học thành công!");
        }else{
            System.out.println("Thêm thất bại!");
        }
    }

    // ===============================
    // Duyệt / từ chối đăng ký
    // ===============================
    public static void approveEnrollment(Scanner sc){

        List<Enrollment> list = enrollmentService.findWaitingEnrollments();

        if(list.isEmpty()){
            System.out.println("Không có đăng ký nào cần duyệt!");
            return;
        }

        System.out.println("===== DANH SÁCH CHỜ DUYỆT =====");

        System.out.printf("%-5s %-20s %-20s %-10s\n",
                "ID","STUDENT","COURSE","STATUS");

        for(Enrollment e : list){
            System.out.printf("%-5d %-20s %-20s %-10s\n",
                    e.getId(),
                    e.getStudentName(),
                    e.getCourseName(),
                    e.getStatus());
        }

        int id;

        while(true){

            System.out.print("Nhập ID đăng ký: ");

            try{
                id = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("ID phải là số!");
                continue;
            }

            boolean exists = false;

            for(Enrollment e : list){
                if(e.getId() == id){
                    exists = true;
                    break;
                }
            }

            if(exists){
                break;
            }else{
                System.out.println("ID không nằm trong danh sách chờ duyệt! Vui lòng nhập lại.");
            }
        }
        System.out.println("1. Duyệt đăng ký");
        System.out.println("2. Từ chối đăng ký");
        System.out.println("0. Hủy");
        System.out.print("Chọn: ");

        int choice;

        try{
            choice = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("Vui lòng nhập số!");
            return;
        }

        switch(choice){

            case 1:
                int adminId = 1; // có thể thay bằng adminLogin.getId()

                if(enrollmentService.approve(id, adminId)){
                    System.out.println("Duyệt đăng ký thành công!");
                }else{
                    System.out.println("Duyệt thất bại!");
                }
                break;

            case 2:

                if(enrollmentService.reject(id)){
                    System.out.println("Đã từ chối đăng ký!");
                }else{
                    System.out.println("Từ chối thất bại!");
                }
                break;

            case 0:
                System.out.println("Đã hủy!");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // ===============================
    // Xóa đăng ký
    // ===============================
    public static void deleteEnrollment(Scanner sc){

        System.out.println("===== DANH SÁCH ĐĂNG KÝ =====");

        List<Enrollment> list = enrollmentService.findAll();

        if(list.isEmpty()){
            System.out.println("Không có đăng ký nào!");
            return;
        }

        System.out.printf("%-5s %-20s %-20s %-10s\n",
                "ID","STUDENT","COURSE","STATUS");

        for(Enrollment e : list){
            System.out.printf("%-5d %-20s %-20s %-10s\n",
                    e.getId(),
                    e.getStudentName(),
                    e.getCourseName(),
                    e.getStatus());
        }

        int id;

        while(true){

            System.out.print("Nhập ID đăng ký cần xóa: ");

            try{
                id = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("ID phải là số!");
                continue;
            }

            boolean exists = false;

            for(Enrollment e : list){
                if(e.getId() == id){
                    exists = true;
                    break;
                }
            }

            if(exists){
                break;
            }else{
                System.out.println("ID không tồn tại! Vui lòng nhập lại.");
            }
        }

        // confirm
        while(true){

            System.out.println("Bạn có chắc muốn xóa?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");

            int confirm;

            try{
                confirm = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch(confirm){

                case 1:
                    if(enrollmentService.delete(id)){
                        System.out.println("Xóa thành công!");
                    }else{
                        System.out.println("Xóa thất bại!");
                    }
                    return;

                case 2:
                    System.out.println("Đã hủy xóa.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}