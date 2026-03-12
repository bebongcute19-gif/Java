package Dao;

import Model.Course;
import java.util.List;

public interface ICourseDao {

    List<Course> findAll();

    void saveCourse(Course course);

    Course findById(Integer id);

    void updateCourse(Course course);

    void deleteCourse(Integer id);

    List<Course> searchByName(String name);

    List<Course> sortById();
}
//public interface ICourseDao {
//
//    // Lấy danh sách tất cả khóa học
//    List<Course> findAll();
//
//    // Tìm khóa học theo id
//    Course findById(int id);
//
//    // Thêm khóa học
//    void saveCourse(Course course);
//
//    // Cập nhật khóa học
//    void updateCourse(Course course);
//
//    // Xóa khóa học
//    void deleteCourse(int id);
//
//    // Tìm kiếm khóa học theo tên (LIKE)
//    List<Course> searchByName(String name);
//
//    // Sắp xếp theo id
//    List<Course> sortById();
//
//    // Sắp xếp theo tên
//    List<Course> sortByName();
//}