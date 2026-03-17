package business.impl;

import business.IStatisticService;
import dao.IStatisticDao;
import dao.impl.StatisticDaoImpl;
import model.CourseStat;

import java.util.List;

public class StatisticServiceImpl implements IStatisticService {

    private final IStatisticDao dao = new StatisticDaoImpl();

    @Override
    public int countStudents() {
        return dao.countStudents();
    }

    @Override
    public int countCourses() {
        return dao.countCourses();
    }

    @Override
    public List<CourseStat> countStudentByCourse() {
        return dao.countStudentByCourse();
    }

    @Override
    public List<CourseStat> top5Courses() {
        return dao.top5Courses();
    }

    @Override
    public List<CourseStat> coursesMoreThan10() {
        return dao.coursesMoreThan10();
    }
}