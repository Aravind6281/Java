package getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getName {
	public static String[] getNames() {
	    ArrayList<String> namesList = new ArrayList<>();
	    try (Connection conn = DatabaseHelper.getConnection()) {
	        String sql = "SELECT Name FROM data";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            namesList.add(rs.getString("Name"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return namesList.toArray(new String[0]);
	}

	public static void main(String[] args) {
	    String[] names = getNames();
	    for (String name : names) {
	        System.out.println("Name: " + name);
	    }
	}

}
