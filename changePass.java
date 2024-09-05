package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changePass {
	public static String changePassword(String password) {
	    String result = null;
	    try (Connection conn = DatabaseHelper.getConnection()) {
	        String sql = "UPDATE data SET Password = ? WHERE UserType = 'Admin'";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, password);
	        int rowsUpdated = stmt.executeUpdate();
	        result = rowsUpdated > 0 ? "Changed" : "0";
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static void main(String[] args) {
	    String updateResult = changePassword("NewPassword");
	    System.out.println(updateResult);
	}

}
