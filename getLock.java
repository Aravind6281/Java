package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getLock {
 public static int getLockStatus() {
	 int count=0;
	 try(Connection conn=DatabaseHelper.getConnection()){
		 String sql="select count(*) from data where lockstatus=0";
		 PreparedStatement stmt=conn.prepareStatement(sql);
		 ResultSet rs=stmt.executeQuery();
		 if(rs.next()) {
			 count=rs.getInt(1);
		 }
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }
	 return count;
 }
 public static void main(String args[]) {
	 int lockStatus=getLockStatus();
	 System.out.println("Total rows with LockStatus 0: "+lockStatus);
 }
}
