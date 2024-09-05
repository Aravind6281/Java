package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getUser {
	public static ArrayList<UserBean> getUsers(String userType){
		ArrayList<UserBean> userList=new ArrayList<>();
		try(Connection conn=DatabaseHelper.getConnection()){
			String sql="select * from data where usertype=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,userType);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserBean user=new UserBean();
				 user.setId(rs.getString("UserID"));
		            user.setPassword(rs.getString("Password"));
		            user.setName(rs.getString("Name"));
		            user.setIncorrectAttempts(rs.getInt("INCORRECTAT"));
		            user.setLockStatus(rs.getInt("LockStatus"));
		            user.setUserType(rs.getString("UserType"));
		            userList.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	public static void main(String []args) {
		ArrayList<UserBean> emp=getUsers("Employee");
		for(UserBean user:emp) {
			System.out.println("UserId:"+user.getId()+",Name: "+user.getName());
		}
	}
}
