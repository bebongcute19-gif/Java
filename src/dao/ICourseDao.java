package dao;

import model.Course;
import java.util.List;

public interface ICourseDao {

    List<Course> findAll();

    boolean saveCourse(Course course);

    Course findById(Integer id);

    void updateCourse(Course course);

    void deleteCourse(Integer id);

    List<Course> searchByName(String name);

    List<Course> sortById();
}
