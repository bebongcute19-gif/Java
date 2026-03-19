package dao;

import model.Course;
import java.util.List;

public interface ICourseDao {

    List<Course> findAll();

    boolean saveCourse(Course course);

    Course findById(Integer id);

    void updateCourse(Course course);

    boolean deleteCourse(int id);

    List<Course> searchByName(String name);


    // --- SORT mặc định tăng dần ---
    List<Course> sortById();

    List<Course> sortByName();
}
