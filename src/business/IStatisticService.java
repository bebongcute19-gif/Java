package business;

import model.CourseStat;
import java.util.List;

public interface IStatisticService {
    int countStudents();
    int countCourses();
    List<CourseStat> countStudentByCourse();
    List<CourseStat> top5Courses();
    List<CourseStat> coursesMoreThan10();
}