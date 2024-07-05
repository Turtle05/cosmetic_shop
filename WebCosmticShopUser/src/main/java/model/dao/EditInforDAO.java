package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditInforDAO extends BaseDAO {

	public String editInfor(String customerID, String fullName, String phone, String address) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET FullName = ?, Address = ?, Phone = ? WHERE CustomerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, fullName);
	            pstmt.setString(2, address);
	            pstmt.setString(3, phone);
	            pstmt.setString(4, customerID);
	 

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Customer2: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

}
