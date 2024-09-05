package examp1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ex1 {

    public static void main(String[] args) throws Exception {
         String url="jdbc:oracle:thin:@//localhost:1521/xe";
         String user="Aravind1";
         String password="Aravind1";
         
         Connection connection=null;
         try {
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 connection=DriverManager.getConnection(url,user,password);
        	 System.out.print("Connection successfull");
         }
         catch (ClassNotFoundException e) {
             System.out.println("Connection could not be established.");
             System.out.println("Driver class not found: " + e.getMessage());

         } catch (SQLException e) {
             System.out.println("Connection could not be established.");
             System.out.println("SQL Exception: " + e.getMessage());

         } finally {
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException e) {
                     System.out.println("Failed to close the connection: " + e.getMessage());
                 }
             }
         }
    }
}

                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     

//        // Corrected JDBC URL format
//        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; 
//
//        String uname = "Hello";
//        String pass = "574";
//        String query = "select sname from student1 where ROLLNO=1";
//
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//
//        Connection con = DriverManager.getConnection(url, uname, pass);
//
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(query);
//       
//        if (rs.next()) {
//            String name = rs.getString("sname"); // Ensure this matches the column name in your table
//            System.out.println(name);
//        } else {
//            System.out.println("No data found for id=1");
//        }