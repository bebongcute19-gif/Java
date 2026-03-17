package dao.impl;

import dao.IStatisticDao;
import model.CourseStat;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticDaoImpl implements IStatisticDao {

    @Override
    public int countStudents() {
        String sql = "SELECT COUNT(*) FROM student";
        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            if(rs.next()){
                return rs.getInt(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countCourses() {
        String sql = "SELECT COUNT(*) FROM course";
        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            if(rs.next()){
                return rs.getInt(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CourseStat> countStudentByCourse() {
        List<CourseStat> list = new ArrayList<>();

        String sql = """
            SELECT c.id, c.name, COUNT(e.student_id) AS total
            FROM course c
            LEFT JOIN enrollment e ON c.id = e.course_id
            GROUP BY c.id, c.name
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                list.add(new CourseStat(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("total")
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<CourseStat> top5Courses() {
        List<CourseStat> list = new ArrayList<>();

        String sql = """
            SELECT c.id, c.name, COUNT(e.student_id) AS total
            FROM course c
            JOIN enrollment e ON c.id = e.course_id
            GROUP BY c.id, c.name
            ORDER BY total DESC
            LIMIT 5
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                list.add(new CourseStat(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("total")
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<CourseStat> coursesMoreThan10() {
        List<CourseStat> list = new ArrayList<>();

        String sql = """
            SELECT c.id, c.name, COUNT(e.student_id) AS total
            FROM course c
            JOIN enrollment e ON c.id = e.course_id
            GROUP BY c.id, c.name
            HAVING COUNT(e.student_id) > 10
        """;

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                list.add(new CourseStat(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("total")
                ));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}