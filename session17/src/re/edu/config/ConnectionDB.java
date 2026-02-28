package re.edu.config;

import org.postgresql.Driver;

import java.sql.*;


public class ConnectionDB {
    //đóng và mở kết nối
    private static final String Driver= "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String User = "postgres";
    private static final String Password = "123";
    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            return DriverManager.getConnection(URL,User,Password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println("Conn : "+conn);
        System.out.println("status :"+conn.isClosed());
//        String sql= """
//                create table MyFriend2(
//                    id serial primary key,
//                    name varchar(50) not null,
//                    birthday date,
//                    sex bit
//                )
//                """;
//        Statement stm = conn.createStatement();
//    String sql = "Insert into MyFriend2(name, birthday, sex) values (?,?,?)";
    String name = "Nguyễn Văn A";
    Date date = new Date(new java.util.Date().getTime());
    boolean sex = true;
        String proc ="call insert_myfriend2(?,?,?)";
        try {
//            boolean status = stm.execute(sql);
//            System.out.println("status sql : "+status);
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            //truyền thaM số nếu có
//            pstmt.setString(1, name);
//            pstmt.setDate(2, date);
//            pstmt.setBoolean(3, sex);
//            int count  = pstmt.executeUpdate();
//            System.out.println("Bạn vừa thêm "+count+"vào bản ghi");
            CallableStatement call = conn.prepareCall(proc);
            call.setString(1,name);
            call.setDate(2,date);
            call.setBoolean(3,sex);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        String sql1= """

                """;

        closeConnection(conn);
        System.out.println("status : "+conn.isClosed());
        //flow chung cho tất cẩ các thao tác
        //B1 mở kết nối
        /*b2 tạo 1` dối tượng Statement để tạo sql
        B3 thực hiện statement
        B4 Xử lí kết quả trả về nếu có
        B5 đóng kết nối
        * */
    }
}
