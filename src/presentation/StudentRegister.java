package presentation;

import business.IStudentService;
import business.impl.StudentServiceImpl;
import model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentRegister {
    private static final IStudentService studentService = new StudentServiceImpl();

    public static void showMenuRegister(Scanner sc) {

        String name;
        LocalDate dob;
        String email;
        boolean sex;
        String phone;
        String pass;

        // ===== NAME =====
        while (true) {
            System.out.print("Nhập tên sinh viên: ");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
            } else {
                break;
            }
        }

        // ===== DOB =====
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
                dob = LocalDate.parse(sc.nextLine());

                if (dob.isAfter(LocalDate.now())) {
                    System.out.println("Ngày sinh không được lớn hơn ngày hiện tại!");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println("Sai định dạng ngày!");
            }
        }

        // ===== EMAIL =====
        while (true) {
            System.out.print("Nhập email: ");
            email = sc.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Email không được để trống!");
                continue;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Email không đúng định dạng!");
                continue;
            }

            Student check = studentService.findStudentByEmail(email);

            if (check != null) {
                System.out.println("Email đã tồn tại!");
            } else {
                break;
            }
        }

        // ===== SEX =====
        while (true) {

            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.print("Chọn giới tính: ");

            try {
                int choose = Integer.parseInt(sc.nextLine());

                if (choose == 1) {
                    sex = true;
                    break;
                } else if (choose == 2) {
                    sex = false;
                    break;
                } else {
                    System.out.println("Chỉ chọn 1 hoặc 2!");
                }

            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

        // ===== PHONE =====
        while (true) {
            System.out.print("Nhập phone: ");
            phone = sc.nextLine().trim();

            if (phone.isEmpty()) {
                System.out.println("Phone không được để trống!");
                continue;
            }

            if (!phone.matches("^0[0-9]{9}$")) {
                System.out.println("Phone phải gồm 10 số và bắt đầu bằng 0!");
                continue;
            }

            Student check = studentService.findStudentByPhone(phone);

            if (check != null) {
                System.out.println("Phone đã tồn tại!");
            } else {
                break;
            }
        }

        // ===== PASSWORD =====
        while (true) {
            System.out.print("Nhập password (>=6 ký tự): ");
            pass = sc.nextLine().trim();

            if (pass.length() < 6) {
                System.out.println("Password phải >= 6 ký tự!");
            } else {
                break;
            }
        }

        Student s = new Student(name, dob, email, sex, phone, pass);

        boolean result = studentService.register(s);

        if (result) {
            System.out.println("Đăng ký thành công!");
            StudentView.showMenuLogin(sc);
        } else {
            System.out.println("Đăng ký thất bại!");
        }
    }
}
