package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreAll {
	public static ArrayList<UserBean> storeAllRecords() {

	 ArrayList<UserBean> usersList = new ArrayList<>();
	    try (Connection conn = DatabaseHelper.getConnection()) {
	        String sql = "SELECT * FROM data";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            UserBean user = new UserBean();
	            user.setId(rs.getString("UserID"));
	            user.setPassword(rs.getString("Password"));
	            user.setName(rs.getString("Name"));
	            user.setIncorrectAttempts(rs.getInt("INCORRECTAT"));
	            user.setLockStatus(rs.getInt("LockStatus"));
	            user.setUserType(rs.getString("UserType"));
	            usersList.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return usersList;
	}

	public static void main(String[] args) {
	    ArrayList<UserBean> users = storeAllRecords();
	    for (UserBean user : users) {
	        System.out.println("UserID: " + user.getId() + ", Name: " + user.getName());
	    }
	}
}
