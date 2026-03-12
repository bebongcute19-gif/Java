package Business;

import Model.Enrollment;

import java.util.List;

public interface IEnrollmentService {

    boolean registerCourse(int studentId, int courseId);

    List<Enrollment> findByStudentId(int studentId);

    List<Enrollment> getEnrollmentsByStudent(int studentId);

    boolean cancelEnrollment(int studentId, int courseId);

    List<Enrollment> sortByName(int studentId, boolean asc);

    List<Enrollment> sortByDate(int studentId, boolean asc);

    List<Enrollment> sortCourses(int studentId, int type);
    //quản lý đăng ký khóa học
    List<Enrollment> findAll();

    List<Enrollment> findByCourse(int courseId);

    boolean approve(int enrollmentId,int adminId);

    boolean delete(int enrollmentId);

    List<Enrollment> findWaitingEnrollments();

    boolean reject(int enrollmentId);

}