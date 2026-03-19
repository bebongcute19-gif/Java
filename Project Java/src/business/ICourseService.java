package business;

import model.Course;
import java.util.List;

public interface ICourseService {

    // hiển thị tất cả khóa học
    List<Course> findAll();

    // thêm khóa học
    boolean saveCourse(Course course);

    // tìm khóa học theo id
    Course findById(int id);

    // cập nhật khóa học
    void updateCourse(Course course);

    // xóa khóa học
    boolean deleteCourse(int id);

    // tìm kiếm theo tên
    List<Course> searchByName(String name);


    // --- SORT theo ID với tăng/giảm ---

    List<Course> sortById();

    List<Course> sortByName();

    //check trùng tên
    boolean existsByName(String name);
}