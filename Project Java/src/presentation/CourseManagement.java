package presentation;

import business.ICourseService;
import business.impl.CourseServiceImpl;
import model.Course;

import java.util.List;
import java.util.Scanner;

public class CourseManagement {

    private static final ICourseService courseService = new CourseServiceImpl();

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
            System.out.println("=============================");
            System.out.println("Chọn chức năng");
            int choice;

            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
                continue;
            }

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

        System.out.printf("%-5s %-25s %-10s %-20s\n",
                "ID","NAME","DURATION","INSTRUCTOR");

        for(Course c : list){
            System.out.printf("%-5d %-25s %-10d %-20s\n",
                    c.getId(),
                    c.getName(),
                    c.getDuration(),
                    c.getInstructor());
        }
    }

    public static void addCourse(Scanner sc){
        System.out.println("-----Thêm khóa học mới-----");
        String name;
        while(true){
            System.out.println("Nhập tên khóa học:");
            name = sc.nextLine();

            if(!name.trim().isEmpty()){
                break;
            }

            System.out.println("Tên không được để trống!");
        }

        int duration;

        while(true){

            try{

                System.out.println("Nhập thời lượng:");
                duration = Integer.parseInt(sc.nextLine());

                if(duration > 0){
                    break;
                }

                System.out.println("Thời lượng phải > 0");

            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
            }
        }

        String instructor;

        while(true){
            System.out.println("Nhập giảng viên:");
            instructor = sc.nextLine();

            if(instructor.trim().isEmpty()){
                System.out.println("Tên giảng viên không được để trống!");
            }else{
                break;
            }
        }

        Course course = new Course(name,duration,instructor);

        boolean result = courseService.saveCourse(course);

        if(result){
            System.out.println("Thêm khóa học thành công!");
        }else{
            System.out.println("Thêm khóa học thất bại!");
        }

        findAll();
    }

    public static void updateCourse(Scanner sc){
        findAll();
        System.out.println("-----Sửa khóa học-----");
        System.out.println("Nhập ID khóa học cần sửa:");

        int id;

        try{
            id = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("Vui lòng nhập số!");
            return;
        }

        Course course = courseService.findById(id);

        if(course == null){
            System.out.println("Không tìm thấy khóa học!");
            return;
        }
        // HIỂN THỊ THÔNG TIN CŨ
        System.out.println("===== THÔNG TIN HIỆN TẠI =====");
        System.out.println("Tên khóa học : " + course.getName());
        System.out.println("Thời lượng   : " + course.getDuration());
        System.out.println("Giảng viên   : " + course.getInstructor());

        // ===== UPDATE NAME =====
        System.out.println("Nhập tên mới (Enter để giữ nguyên):");
        String name = sc.nextLine();

        if(!name.isEmpty()){
            course.setName(name);
        }

        // ===== UPDATE DURATION =====
        while(true){

            System.out.println("Nhập thời lượng mới (Enter để giữ nguyên):");
            String input = sc.nextLine();

            if(input.isEmpty()){
                break;
            }

            try{
                int duration = Integer.parseInt(input);

                if(duration > 0){
                    course.setDuration(duration);
                    break;
                }

                System.out.println("Thời lượng phải > 0");

            }catch(Exception e){
                System.out.println("Vui lòng nhập số!");
            }
        }

        // ===== UPDATE INSTRUCTOR =====
        while(true){

            System.out.println("Nhập giảng viên mới (Enter để giữ nguyên):");
            String instructor = sc.nextLine();

            if(instructor.isEmpty()){
                break;
            }

            if(instructor.trim().isEmpty()){
                System.out.println("Tên giảng viên không hợp lệ!");
                continue;
            }

            course.setInstructor(instructor);
            break;
        }

        courseService.updateCourse(course);

        System.out.println("Cập nhật thành công!");

        findAll();
    }

    public static void deleteCourse(Scanner sc){
        findAll();
        System.out.println("Nhập ID khóa học cần xóa:");

        int id;

        try{
            id = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println("Vui lòng nhập số!");
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
                    courseService.deleteCourse(id);
                    System.out.println("Xóa khóa học thành công!");
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

        findAll();
    }

    public static void searchCourse(Scanner sc){

        System.out.println("Nhập tên khóa học cần tìm:");

        String keyword = sc.nextLine();

        List<Course> list = courseService.searchByName(keyword);

        if(list.isEmpty()){
            System.out.println("Không tìm thấy khóa học!");
            return;
        }

        System.out.printf("%-5s %-25s %-10s %-20s\n",
                "ID","NAME","DURATION","INSTRUCTOR");

        for(Course c : list){
            System.out.printf("%-5d %-25s %-10d %-20s\n",
                    c.getId(),
                    c.getName(),
                    c.getDuration(),
                    c.getInstructor());
        }
    }

    public static void sortCourse(Scanner sc){

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

            List<Course> list;

            switch(choice){

                case 1:
                    list = courseService.sortById();
                    break;

                case 2:
                    list = courseService.sortByName();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }

            System.out.printf("%-5s %-25s %-10s %-20s\n",
                    "ID","NAME","DURATION","INSTRUCTOR");

            for(Course c : list){
                System.out.printf("%-5d %-25s %-10d %-20s\n",
                        c.getId(),
                        c.getName(),
                        c.getDuration(),
                        c.getInstructor());
            }

            break;
        }
    }
    public static void showAllCourse(){

        List<Course> list = courseService.findAll();

        if(list.isEmpty()){
            System.out.println("Không có khóa học!");
            return;
        }

        System.out.printf("%-5s %-25s\n","ID","COURSE NAME");

        for(Course c : list){
            System.out.printf("%-5d %-25s\n",
                    c.getId(),
                    c.getName());
        }
    }
}