package getConnect;

//import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class DatabaseHelper {
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user="jdbc";
	private static final String password="jdbc";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
}
