package business.impl;

import business.ICourseService;
import dao.ICourseDao;
import dao.impl.CourseDaoImpl;
import model.Course;

import java.util.List;

public class CourseServiceImpl implements ICourseService {

    private final ICourseDao courseDao = new CourseDaoImpl();

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public boolean saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public boolean deleteCourse(int id) {
        try {
            return courseDao.deleteCourse(id);
        } catch (RuntimeException e) {
            if ("COURSE_HAS_ENROLLMENT".equals(e.getMessage())) return false;
            throw e;
        }
    }

    @Override
    public List<Course> searchByName(String name) {
        return courseDao.searchByName(name);
    }

    @Override
    public List<Course> sortById() {
        return courseDao.sortById();
    }

    @Override
    public List<Course> sortByName() {
        return courseDao.sortByName();
    }

    @Override
    public boolean existsByName(String name) {
        return courseDao.findAll().stream()
                .anyMatch(c -> c.getName().equalsIgnoreCase(name));
    }
}