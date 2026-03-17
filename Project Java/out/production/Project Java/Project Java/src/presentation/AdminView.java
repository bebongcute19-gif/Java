package presentation;

import model.Admin;
import business.IAdminService;
import business.impl.AdminServiceImpl;
import java.util.Scanner;

public class AdminView {

    public static Admin adminLogin = null;
    private static final IAdminService adminService = new AdminServiceImpl();

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
            System.out.println("0. Đăng xuất");
            System.out.println("============================");

            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Chức năng quản lý khóa học");
                    CourseManagement.menuCourse(sc);
                    break;

                case 2:
                    System.out.println("Chức năng quản lý học viên");
                    StudentManagement.menuStudent(sc);
                    break;

                case 3:
                    System.out.println("Chức năng quản lý đăng ký học");
                    EnrollmentManagement.menuEnrollment(sc);
                    break;

                case 4:
                    System.out.println("Thống kê học viên theo khóa học");
                    StatisticManagement.menuStatistic(sc);
                    break;

                case 0:
                    System.out.println("Đăng xuất...");
                    adminLogin = null;
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}