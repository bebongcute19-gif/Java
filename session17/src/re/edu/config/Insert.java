//package re.edu.config;
//
//public class Insert {
//    String sql = """
//        insert into Student(name, birthday, sex)
//        values ('Nguyen Van A', '2002-10-20', B'1')
//        """;
//
//    try (Connection conn = ConnectionDB.getConnection();
//    Statement stmt = conn.createStatement()) {
//
//        int rows = stmt.executeUpdate(sql);
//        System.out.println("Inserted rows: " + rows);
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
