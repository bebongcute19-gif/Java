package presentation;

import business.IStudentService;
import business.impl.StudentServiceImpl;
import model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static final IStudentService studentService = new StudentServiceImpl();
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
            System.out.println("=============================");
            System.out.println("Chọn chức năng");

            int choice;
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

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

        System.out.printf("%-5s %-20s %-12s %-25s %-15s %-5s\n",
                "ID","NAME","DOB","EMAIL","PHONE","SEX");

        for(Student s : list){
            System.out.printf("%-5d %-20s %-12s %-25s %-15s %-5s\n",
                    s.getId(),
                    s.getName(),
                    s.getDob(),
                    s.getEmail(),
                    s.getPhone(),
                    (s.getSex() ? "Nam" : "Nữ"));
        }
    }
    public static void addStudent(Scanner sc){
        String name;
        while(true){
            System.out.println("Nhập tên sinh viên:");
            name = sc.nextLine().trim();

            if(!name.isEmpty()){
                break;
            }

            System.out.println("Tên không được để trống!");
        }

        LocalDate dob;

        while(true){
            try{
                System.out.println("Nhập ngày sinh (yyyy-MM-dd): ");
                dob = LocalDate.parse(sc.nextLine());

                if(dob.isAfter(LocalDate.now())){
                    System.out.println("Ngày sinh không được lớn hơn ngày hiện tại!");
                    continue;
                }

                break;

            }catch(Exception e){
                System.out.println("Sai định dạng ngày!");
            }
        }

        // ===== KIỂM TRA EMAIL TRÙNG =====
        String email;

        while(true){
            System.out.println("Nhập email:");
            email = sc.nextLine().trim();

            if(email.isEmpty()){
                System.out.println("Email không được để trống!");
                continue;
            }

            if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
                System.out.println("Email không đúng định dạng!");
                continue;
            }

            Student check = studentService.findStudentByEmail(email);

            if(check != null){
                System.out.println("Email đã tồn tại!");
            }else{
                break;
            }
        }

        boolean sex;

        while(true){
            System.out.println("1. Nam");
            System.out.println("2. Nữ");

            int choose;

            try{
                choose = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Phải nhập số!");
                continue;
            }

            if(choose == 1){
                sex = true;
                break;
            }else if(choose == 2){
                sex = false;
                break;
            }else{
                System.out.println("Chọn lại!");
            }
        }

        String phone;

        while(true){
            System.out.println("Nhập phone:");
            phone = sc.nextLine().trim();

            if(phone.isEmpty()){
                System.out.println("Phone không được để trống!");
                continue;
            }

            if(!phone.matches("^0[0-9]{9}$")){
                System.out.println("Phone phải gồm 10 số và bắt đầu bằng 0!");
                continue;
            }

            Student check = studentService.findStudentByPhone(phone);

            if(check != null){
                System.out.println("Phone đã tồn tại!");
            }else{
                break;
            }
        }

        String pass;

        while(true){
            System.out.println("Nhập password (>=6 ký tự):");
            pass = sc.nextLine().trim();

            if(pass.length() < 6){
                System.out.println("Password phải >= 6 ký tự!");
            }else{
                break;
            }
        }

        Student s = new Student(name,dob,email,sex,phone,pass);

        boolean result = studentService.register(s);

        if(result){
            System.out.println("Thêm học viên thành công!");
            findAllStudent();
        }else{
            System.out.println("Thêm học viên thất bại!");
        }

    }
    public static void updateStudent(Scanner sc){
        findAllStudent();
        System.out.println("Nhập ID học viên cần sửa:");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("ID phải là số!");
            return;
        }

        Student student = studentService.findById(id);

        if(student == null){
            System.out.println("Không tìm thấy học viên!");
            return;
        }
        System.out.println("Thông tin hiện tại:");
        System.out.printf("%-5s %-20s %-12s %-25s %-15s %-5s\n",
                "ID","NAME","DOB","EMAIL","PHONE","SEX");
        System.out.printf("%-5d %-20s %-12s %-25s %-15s %-5s\n",
                student.getId(),
                student.getName(),
                student.getDob(),
                student.getEmail(),
                student.getPhone(),
                (student.getSex() ? "Nam" : "Nữ"));

        System.out.println("Nhập tên mới (Enter để giữ nguyên):");
        String name = sc.nextLine().trim();

        if(!name.isEmpty()){
            student.setName(name);
        }

        while(true) {
            System.out.println("Nhập ngày sinh mới (yyyy-MM-dd) (Enter để giữ nguyên): ");
            String inputDob = sc.nextLine().trim();

            if (inputDob.isEmpty()) {
                break;
            }

            try {
                LocalDate dob = LocalDate.parse(inputDob);

                if(dob.isAfter(LocalDate.now())){
                    System.out.println("Ngày sinh không được lớn hơn ngày hiện tại!");
                    continue;
                }

                student.setDob(dob);
                break;

            } catch (Exception e) {
                System.out.println("Sai định dạng ngày!");
            }
        }
        while(true){
            System.out.println("Nhập email mới (Enter để giữ nguyên):");
            String email = sc.nextLine().trim();

            if(email.isEmpty()){
                break;
            }

            if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
                System.out.println("Email không đúng định dạng!");
                continue;
            }

            Student check = studentService.findStudentByEmail(email);

            if(check != null && check.getId() != id){
                System.out.println("Email đã tồn tại!");
            }else{
                student.setEmail(email);
                break;
            }
        }

        while(true){

            System.out.println("Nhập phone mới (Enter để giữ nguyên):");
            String phone = sc.nextLine().trim();

            if(phone.isEmpty()){
                break;
            }

            if(!phone.matches("^0[0-9]{9}$")){
                System.out.println("Phone phải gồm 10 số và bắt đầu bằng 0!");
                continue;
            }

            Student check = studentService.findStudentByPhone(phone);

            if(check != null && check.getId() != id){
                System.out.println("Phone đã tồn tại!");
            }else{
                student.setPhone(phone);
                break;
            }
        }

        while(true){
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("Enter để giữ nguyên");

            String input = sc.nextLine().trim();

            if(input.isEmpty()){
                break; // giữ nguyên
            }else if(input.equals("1")){
                student.setSex(true);
                break;
            }else if(input.equals("2")){
                student.setSex(false);
                break;
            }else{
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }

        studentService.updateStudent(student);

        System.out.println("Cập nhật thành công!");
        findAllStudent();
    }
    public static void deleteStudent(Scanner sc){

        findAllStudent();

        System.out.println("Nhập ID học viên cần xóa:");
        int id;

        try{
            id = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("ID phải là số!");
            return;
        }

        Student student = studentService.findById(id);

        if(student == null){
            System.out.println("Không tồn tại học viên!");
            return;
        }

        while(true){

            System.out.println("Bạn có chắc muốn xóa?");
            System.out.println("1. Có");
            System.out.println("2. Không");

            int confirm;

            try{
                confirm = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch(confirm){

                case 1:
                    studentService.deleteStudent(id);
                    System.out.println("Xóa thành công!");
                    findAllStudent();
                    break;

                case 2:
                    System.out.println("Đã hủy xóa");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }

            break;
        }
    }
    public static void searchStudent(Scanner sc){

        System.out.println("Nhập tên hoặc email cần tìm:");
        String keyword = sc.nextLine().trim();

        List<Student> list = studentService.search(keyword);

        if(list.isEmpty()){
            System.out.println("Không tìm thấy học viên!");
            return;
        }

        System.out.printf("%-5s %-20s %-12s %-25s %-15s %-5s\n",
                "ID","NAME","DOB","EMAIL","PHONE","SEX");

        for(Student s : list){
            System.out.printf("%-5d %-20s %-12s %-25s %-15s %-5s\n",
                    s.getId(),
                    s.getName(),
                    s.getDob(),
                    s.getEmail(),
                    s.getPhone(),
                    (s.getSex() ? "Nam" : "Nữ"));
        }
    }

    public static void sortStudent(Scanner sc){

        while(true){

            System.out.println("1. Sắp xếp theo ID");
            System.out.println("2. Sắp xếp theo tên");
            System.out.println("3. Quay lại");

            int choice;

            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            List<Student> list;

            switch(choice){

                case 1:
                    list = studentService.sortById();
                    break;

                case 2:
                    list = studentService.sortByName();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }

            if(list.isEmpty()){
                System.out.println("Danh sách trống!");
                return;
            }

            System.out.printf("%-5s %-20s %-12s %-25s %-15s %-5s\n",
                    "ID","NAME","DOB","EMAIL","PHONE","SEX");

            for(Student s : list){
                System.out.printf("%-5d %-20s %-12s %-25s %-15s %-5s\n",
                        s.getId(),
                        s.getName(),
                        s.getDob(),
                        s.getEmail(),
                        s.getPhone(),
                        (s.getSex() ? "Nam" : "Nữ"));
            }

            break;
        }
    }
    //show cho enroll sử dụng
    public static void showAllStudents(){

        List<Student> list = studentService.findAll();

        if(list.isEmpty()){
            System.out.println("Không có học viên!");
            return;
        }

        System.out.printf("%-5s %-20s\n","ID","NAME");

        for(Student s : list){
            System.out.printf("%-5d %-20s\n",
                    s.getId(),
                    s.getName());
        }
    }
}
