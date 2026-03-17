package dao;

import model.CourseStat;
import java.util.List;

public interface IStatisticDao {
    int countStudents();
    int countCourses();
    List<CourseStat> countStudentByCourse();
    List<CourseStat> top5Courses();
    List<CourseStat> coursesMoreThan10();
}