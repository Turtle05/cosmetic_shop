package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class UpdateOrderDAO extends BaseDAO {

	public String updateOrderDAO(String status, String orderID) {
		
		
		String st = null;
		if ("cho".equals(status)) {
			st = "giao";
		}
		if ("giao".equals(status)) {
			st = "xong";
		}
		Connection connection = getConnection();

	    String sql = "UPDATE Order1 SET Status = ?, ShippedDate = ? WHERE OrderID = ?";

	    PreparedStatement pstmt = null;


	    try {
	    	Timestamp currentTime = Timestamp.from(Instant.now());

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, st);
	            pstmt.setTimestamp(2, currentTime);
	            pstmt.setString(3, orderID);
	            

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Order: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

}
