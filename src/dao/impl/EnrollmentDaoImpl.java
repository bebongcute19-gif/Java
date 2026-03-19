package dao.impl;

import dao.IEnrollmentDao;
import model.Enrollment;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImpl implements IEnrollmentDao {


    @Override
    public boolean isRegistered(int studentId, int courseId) {

        String sql = """
                SELECT 1 FROM enrollment
                WHERE student_id = ? AND course_id = ?
                """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,studentId);
            ps.setInt(2,courseId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Enrollment> findByStudentId(int studentId) {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
        SELECT e.id, c.name, e.status, e.registered_at
        FROM enrollment e
        JOIN course c ON e.course_id = c.id
        WHERE e.student_id = ?
    """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setCourseName(rs.getString("name"));
                e.setStatus(rs.getString("status"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(int studentId) {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
                SELECT e.id,c.name,e.status,e.registered_at
                FROM enrollment e
                JOIN course c ON e.course_id = c.id
                WHERE e.student_id = ?
                """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setCourseName(rs.getString("name"));
                e.setStatus(rs.getString("status"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean cancelEnrollment(int enrollmentId, int studentId) {

        String sql = """
        DELETE FROM enrollment
        WHERE id = ? AND student_id = ? AND status = 'WAITING'
    """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, enrollmentId);
            ps.setInt(2, studentId);

            return ps.executeUpdate() > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public List<Enrollment> sortByName(int studentId, boolean asc) {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
                SELECT e.id,c.name,e.status,e.registered_at
                FROM enrollment e
                JOIN course c ON e.course_id = c.id
                WHERE e.student_id = ?
                ORDER BY c.name
                """ + (asc ? " ASC" : " DESC");

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setCourseName(rs.getString("name"));
                e.setStatus(rs.getString("status"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Enrollment> sortByDate(int studentId, boolean asc) {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
                SELECT e.id,c.name,e.status,e.registered_at
                FROM enrollment e
                JOIN course c ON e.course_id = c.id
                WHERE e.student_id = ?
                ORDER BY e.registered_at
                """ + (asc ? " ASC" : " DESC");

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setCourseName(rs.getString("name"));
                e.setStatus(rs.getString("status"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public List<Enrollment> sortCourses(int studentId, int type) {

        List<Enrollment> list = new ArrayList<>();

        String sql;

        if(type == 1){
            // sắp xếp theo tên khóa học
            sql = """
              SELECT e.id, c.name, e.status, e.registered_at
              FROM enrollment e
              JOIN course c ON e.course_id = c.id
              WHERE e.student_id = ?
              ORDER BY c.name
              """;
        }else{
            // sắp xếp theo ngày đăng ký
            sql = """
              SELECT e.id, c.name, e.status, e.registered_at
              FROM enrollment e
              JOIN course c ON e.course_id = c.id
              WHERE e.student_id = ?
              ORDER BY e.registered_at
              """;
        }

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setCourseName(rs.getString("name"));
                e.setStatus(rs.getString("status"));
                e.setRegisteredAt(
                        rs.getTimestamp("registered_at").toLocalDateTime()
                );

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public List<Enrollment> findAll() {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
            SELECT e.id, s.name student_name, c.name course_name,
                   e.registered_at, e.status
            FROM enrollment e
            JOIN student s ON e.student_id = s.id
            JOIN course c ON e.course_id = c.id
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setStudentName(rs.getString("student_name"));
                e.setCourseName(rs.getString("course_name"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());
                e.setStatus(rs.getString("status"));

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Enrollment> findByCourse(int courseId) {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
            SELECT e.id, s.name student_name, c.name course_name,
                   e.registered_at, e.status
            FROM enrollment e
            JOIN student s ON e.student_id = s.id
            JOIN course c ON e.course_id = c.id
            WHERE e.course_id = ?
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,courseId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setStudentName(rs.getString("student_name"));
                e.setCourseName(rs.getString("course_name"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());
                e.setStatus(rs.getString("status"));

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean approve(int enrollmentId, int adminId) {

        String sql = """
            UPDATE enrollment
            SET status='APPROVED',
                approved_at = CURRENT_TIMESTAMP,
                approved_by = ?
            WHERE id = ?
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,adminId);
            ps.setInt(2,enrollmentId);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int enrollmentId) {

        String sql = "DELETE FROM enrollment WHERE id=?";

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,enrollmentId);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public List<Enrollment> findWaitingEnrollments() {

        List<Enrollment> list = new ArrayList<>();

        String sql = """
        SELECT e.id, s.name AS student_name, c.name AS course_name,
               e.registered_at, e.status
        FROM enrollment e
        JOIN student s ON e.student_id = s.id
        JOIN course c ON e.course_id = c.id
        WHERE e.status = 'WAITING'
    """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Enrollment e = new Enrollment();

                e.setId(rs.getInt("id"));
                e.setStudentName(rs.getString("student_name"));
                e.setCourseName(rs.getString("course_name"));
                e.setRegisteredAt(rs.getTimestamp("registered_at").toLocalDateTime());
                e.setStatus(rs.getString("status"));

                list.add(e);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    //từ chối đăng ký của sinh viên

    public boolean reject(int enrollmentId){

        String sql = """
        UPDATE enrollment
        SET status = 'REJECTED'
        WHERE id = ?
    """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, enrollmentId);

            return ps.executeUpdate() > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public boolean add(int studentId, int courseId) {

        String sql = "INSERT INTO enrollment(student_id, course_id) VALUES (?, ?)";

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public boolean save(Enrollment e) {

        String sql = """
        INSERT INTO enrollment(student_id, course_id, status)
        VALUES (?, ?, ?)
    """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, e.getStudentId());
            ps.setInt(2, e.getCourseId());
            ps.setString(3, e.getStatus());

            return ps.executeUpdate() > 0;

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

}