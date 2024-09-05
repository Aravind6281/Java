package getConnect;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class UserOperations {

	    public static String getUserType(String userID) {
	        String userType = null;
	        try (Connection conn = DatabaseHelper.getConnection()) {
	            String sql = "SELECT USERTYPE FROM data WHERE UserID = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, userID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                userType = rs.getString("UserType");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userType;
	    }

	    public static void main(String[] args) {
	        String userType = getUserType("AB1001");
	        System.out.println("User Type: " + userType);
	    }

}
