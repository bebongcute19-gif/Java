package dao.impl;

import dao.ICourseDao;
import model.Course;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class CourseDaoImpl implements ICourseDao {

    @Override
    public List<Course> findAll() {
        return getCoursesBySQL("SELECT * FROM course");
    }

    @Override
    public boolean saveCourse(Course course) {
        String sql = "INSERT INTO course(name,duration,instructor) VALUES(?,?,?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, course.getName());
            pre.setInt(2, course.getDuration());
            pre.setString(3, course.getInstructor());
            return pre.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Course findById(Integer id) {
        String sql = "SELECT * FROM course WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));
                return c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET name=?, duration=?, instructor=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, course.getName());
            pre.setInt(2, course.getDuration());
            pre.setString(3, course.getInstructor());
            pre.setInt(4, course.getId());
            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM course WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (PSQLException e) {
            if ("23503".equals(e.getSQLState()) || "23001".equals(e.getSQLState())) {
                throw new RuntimeException("COURSE_HAS_ENROLLMENT");
            }
            throw new RuntimeException("DB_ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SYSTEM_ERROR");
        }
    }

    @Override
    public List<Course> searchByName(String name) {
        String sql = "SELECT * FROM course WHERE name ILIKE ?";
        List<Course> list = new ArrayList<>();
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, "%" + name + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- SORT mặc định tăng dần ---
    @Override
    public List<Course> sortById() {
        return getCoursesBySQL("SELECT * FROM course ORDER BY id ASC");
    }

    @Override
    public List<Course> sortByName() {
        return getCoursesBySQL("SELECT * FROM course ORDER BY name ASC");
    }

    // helper lấy list từ SQL
    private List<Course> getCoursesBySQL(String sql) {
        List<Course> list = new ArrayList<>();
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}