package business.impl;

import business.IEnrollmentService;
import dao.IEnrollmentDao;
import dao.impl.EnrollmentDaoImpl;
import model.Enrollment;

import java.util.List;

public class EnrollmentServiceImpl implements IEnrollmentService {

    private static final IEnrollmentDao enrollmentDao = new EnrollmentDaoImpl();

    @Override
    public boolean registerCourse(int studentId, int courseId) {

        List<Enrollment> list = enrollmentDao.findAll();

        // check trùng
        for (Enrollment e : list) {
            if (e.getStudentId() == studentId &&
                    e.getCourseId() != null &&
                    e.getCourseId().equals(courseId)) {
                return false;
            }
        }

        // tạo mới
        Enrollment e = new Enrollment();
        e.setStudentId(studentId);
        e.setCourseId(courseId); // có thể null nếu admin thêm thủ công

        enrollmentDao.save(e);

        return true;
    }

    @Override
    public List<Enrollment> findByStudentId(int studentId) {
        return enrollmentDao.findByStudentId(studentId);
    }


    @Override
    public boolean cancelEnrollment(int studentId, int courseId) {
        return enrollmentDao.cancelEnrollment(studentId, courseId);
    }

    @Override
    public List<Enrollment> sortByName(int studentId, boolean asc) {
        return enrollmentDao.sortByName(studentId, asc);
    }

    @Override
    public List<Enrollment> sortCourses(int studentId, int type) {
        return enrollmentDao.sortCourses(studentId,type);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    @Override
    public List<Enrollment> findByCourse(int courseId) {
        return enrollmentDao.findByCourse(courseId);
    }

    @Override
    public boolean approve(int enrollmentId, int adminId) {
        return enrollmentDao.approve(enrollmentId,adminId);
    }

    @Override
    public boolean delete(int enrollmentId) {
        return enrollmentDao.delete(enrollmentId);
    }

    @Override
    public List<Enrollment> findWaitingEnrollments() {
        return enrollmentDao.findWaitingEnrollments();
    }

    @Override
    public boolean reject(int enrollmentId) {
        return enrollmentDao.reject(enrollmentId);
    }

    @Override
    public boolean add(int studentId, int courseId) {
        return enrollmentDao.add(studentId, courseId);
    }

    @Override
    public boolean existsByCourseId(int courseId) {
        List<Enrollment> list = enrollmentDao.findAll();

        for (Enrollment e : list) {
            if (e.getCourseId() != null && e.getCourseId().equals(courseId)) {
                return true;
            }
        }

        return false;
    }
}