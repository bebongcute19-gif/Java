package Business.Impl;

import Business.ICourseService;
import Dao.ICourseDao;
import Dao.impl.CourseDaoImpl;
import Model.Course;

import java.util.Comparator;
import java.util.List;

public class CourseServiceImpl implements ICourseService {

    private final ICourseDao courseDao = new CourseDaoImpl();

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
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
    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
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

        List<Course> list = courseDao.findAll();

        list.sort(Comparator.comparing(Course::getName));

        return list;
    }
}