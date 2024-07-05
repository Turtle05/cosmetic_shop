package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCartDAO extends BaseDAO {

	public String deleteCart(String customerID, String productID) {
		Connection connection = getConnection();

	    String sql = "DELETE Cart2 WHERE CustomerID = ? AND ProductID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, customerID);
	            pstmt.setString(2, productID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã delete số record trong Cart: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}
	
	public String deleteCart(String customerID) {
		Connection connection = getConnection();

	    String sql = "DELETE Cart2 WHERE CustomerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, customerID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã delete số record trong Cart: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}
	
	

}
