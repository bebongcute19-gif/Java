package dao.impl;

import dao.ICourseDao;
import model.Course;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao {

    @Override
    public List<Course> findAll() {
        String sql = "SELECT * FROM course";
        List<Course> list = new ArrayList<>();

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();
        ){

            while(rs.next()){
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));

                list.add(c);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean saveCourse(Course course) {

        String sql = "INSERT INTO course(name,duration,instructor) VALUES(?,?,?)";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){

            pre.setString(1, course.getName());
            pre.setInt(2, course.getDuration());
            pre.setString(3, course.getInstructor());

            int rows = pre.executeUpdate();

            return rows > 0; // insert thành công

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Course findById(Integer id) {

        String sql = "SELECT * FROM course WHERE id=?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){

            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();

            if(rs.next()){
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));

                return c;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateCourse(Course course) {

        String sql = "UPDATE course SET name=?, duration=?, instructor=? WHERE id=?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){

            pre.setString(1,course.getName());
            pre.setInt(2,course.getDuration());
            pre.setString(3,course.getInstructor());
            pre.setInt(4,course.getId());

            pre.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Integer id) {

        String sql = "DELETE FROM course WHERE id=?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){

            pre.setInt(1,id);
            pre.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> searchByName(String name) {

        String sql = "SELECT * FROM course WHERE name ILIKE ?";
        List<Course> list = new ArrayList<>();

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){

            pre.setString(1,"%"+name+"%");
            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));

                list.add(c);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Course> sortById() {

        String sql = "SELECT * FROM course ORDER BY id";
        List<Course> list = new ArrayList<>();

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();
        ){

            while(rs.next()){
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDuration(rs.getInt("duration"));
                c.setInstructor(rs.getString("instructor"));

                list.add(c);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}