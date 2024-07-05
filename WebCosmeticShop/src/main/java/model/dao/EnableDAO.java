package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnableDAO extends BaseDAO {

	public void updateEnable(String customerID, String enable) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET  Gender = ?   WHERE customerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, enable);
	            pstmt.setString(2, customerID);
	 

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update image trong Employee: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	}

}
