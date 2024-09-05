package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getIncorrect {
		public static String getIncorrectAttempts(String userID) {
			String result = null;
			try (Connection conn = DatabaseHelper.getConnection()) {
				String sql = "SELECT INCORRECTAT FROM data WHERE UserID = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, userID);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					int attempts = rs.getInt("IncorrectAttempts");
					if (attempts == 0) {
						result = "No incorrect Attempt";
					} else if (attempts == 1) {
						result = "One Time";
					} else {
						result = "Incorrect Attempt Exceeded";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public static void main(String[] args) {
			String incorrectAttempts = getIncorrectAttempts("AB1001");
			System.out.println("Incorrect Attempts: " + incorrectAttempts);
		}
	

}
