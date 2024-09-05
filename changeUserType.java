package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changeUserType {
	public static String changeUserTyp(String userId){
		String result=null;
		try(Connection conn=DatabaseHelper.getConnection()){
			String sql="update data set usertype='admin' where userId=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,userId);
			int rowsUpdated=stmt.executeUpdate();
			result=rowsUpdated > 0 ? "Update Success" : "Update Failed";
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String args[]) {
		String updateResult=changeUserTyp("AB1001");
		System.out.print(updateResult);
	}
}
