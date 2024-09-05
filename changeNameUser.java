package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changeNameUser {
	public static String changeName(String id,String name) {
		String result=null;
		try(Connection conn=DatabaseHelper.getConnection()){
			String sql="update data set name=? where userId=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, id);
			int rowsUpdated = stmt.executeUpdate();
	        result = rowsUpdated > 0 ? "Success" : "Failed";
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String args[]) {
		String update=changeName("AB1001","Robo");
		System.out.println(update);
	}
}
