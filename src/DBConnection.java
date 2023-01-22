import java.sql.*;

public class DBConnection {
    public static void main(String[] args) throws SQLException {


        ResultSet rs=null;
        try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","developer","1234");
             PreparedStatement ps=conn.prepareStatement("SELECT * FROM students")){

            rs= ps.executeQuery();
            while (rs.next()){
                int student_id=rs.getInt("student_id");
                String last_name=rs.getString("last_name");
                String first_name=rs.getString("first_name");
                System.out.println("id: "+student_id+" cognome: "+last_name+" nome: "+first_name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
        }
    }}
