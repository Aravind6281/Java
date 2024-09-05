package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addUser1 {
	public static String addUser_1(UserBean bean){
		String result=null;
		try(Connection conn=DatabaseHelper.getConnection()){
			String sql="insert into data(UserId,Password,Name,IncorrectAttenpts,LockStatus,UserType) vlaues(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,bean.getId());
			ps.setString(2, bean.getPassword());
			ps.setString(3, bean.getName());
			ps.setInt(4, bean.getIncorrectAttempts());
			ps.setInt(5, bean.getLockStatus());
			ps.setString(6, bean.getUserType());
		}catch(SQLException e) {
			e.printStackTrace();
			result="Failed";
		}
		return result;
	}
	public static void main(String args[]) {
		UserBean newUser = new UserBean();
	    newUser.setId("MK1004");
	    newUser.setPassword("MK1004");
	    newUser.setName("Mohan");
	    newUser.setIncorrectAttempts(0);
	    newUser.setLockStatus(0);
	    newUser.setUserType("Employee");

	    String result = addUser_1(newUser);
	    System.out.println(result);		
	}
}
