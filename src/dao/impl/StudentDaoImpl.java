package dao.impl;
import java.util.List;
import java.sql.*;
import dao.IStudentDao;
import model.Student;
import utils.ConnectionDB;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public void saveStudent(Student student) {

        String sql = "INSERT INTO student(name, dob, email, sex, phone, password) VALUES (?,?,?,?,?,?)";

        try (
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ) {

            pre.setString(1, student.getName());
            pre.setDate(2, Date.valueOf(student.getDob()));
            pre.setString(3, student.getEmail());
            pre.setBoolean(4, student.getSex());
            pre.setString(5, student.getPhone());
            pre.setString(6, student.getPassword());

            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findStudentByEmail(String email) {

        String sql = "SELECT * FROM student WHERE email = ?";

        try (
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ) {

            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt(1),                    // id
                        rs.getString(2),                 // name
                        rs.getDate(3).toLocalDate(),    // dob
                        rs.getString(4),                 // email
                        rs.getBoolean(6),                // sex
                        rs.getString(5),                 // phone
                        rs.getString(7),                 // password
                        rs.getDate(8).toLocalDate()     // created_at
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public List<Student> findAll() {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("sex"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate()
                );

                list.add(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public Student findById(int id) {

        String sql = "SELECT * FROM student WHERE id=?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("sex"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate()
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE student SET name=?,dob=?,email=?,phone=?,sex=?,password=? WHERE id=?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setString(1, student.getName());
            ps.setDate(2, Date.valueOf(student.getDob()));
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setBoolean(5, student.getSex());
            ps.setString(6, student.getPassword());
            ps.setInt(7, student.getId());

            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (PSQLException e) {
            //
            if ("23503".equals(e.getSQLState()) || "23001".equals(e.getSQLState())) {
                throw new RuntimeException("STUDENT_HAS_ENROLLMENT");
            }

            throw new RuntimeException("DB_ERROR");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SYSTEM_ERROR");
        }
    }

    @Override
    public List<Student> search(String keyword) {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student WHERE name ILIKE ? OR email ILIKE ?";

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setString(1,"%"+keyword+"%");
            ps.setString(2,"%"+keyword+"%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("sex"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate()
                );

                list.add(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Student> sortById(String order) {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student ORDER BY id " + order;

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("sex"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate()
                );

                list.add(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public List<Student> sortByName(String order) {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student ORDER BY name " + order;

        try(
                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("email"),
                        rs.getBoolean("sex"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate()
                );

                list.add(s);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public boolean changePassword(int studentId, String newPass) {

        String sql = "UPDATE student SET password = ? WHERE id = ?";

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, newPass);
            ps.setInt(2, studentId);

            return ps.executeUpdate() > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Student findStudentByPhone(String phone) {

        String sql = "SELECT * FROM student WHERE phone = ?";

        try(Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, phone);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                return s;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}