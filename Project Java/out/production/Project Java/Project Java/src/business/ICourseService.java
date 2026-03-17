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
    void deleteCourse(int id);

    // tìm kiếm theo tên
    List<Course> searchByName(String name);

    // sắp xếp theo id
    List<Course> sortById();

    // sắp xếp theo tên
    List<Course> sortByName();
}