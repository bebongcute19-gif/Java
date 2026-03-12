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
