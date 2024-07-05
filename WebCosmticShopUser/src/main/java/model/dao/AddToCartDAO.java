package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CartDTO;

public class AddToCartDAO extends BaseDAO {


	public String insertCart(String customerID, String productID, int quantity) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Cart2 (CustomerID, ProductID, Quantity) VALUES (?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			pstmt.setString(2, productID);
			pstmt.setInt(3, quantity);

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào Cart: " + x);
		} catch (SQLException e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();

			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {

				return "Duplicate ID Error";

			} else {
				return "Error";
			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	public int getQuantityCart(String customerID, String productID) {
		int returnQuantity = 0;

        Connection connection = getConnection();
        String sql = "SELECT  Quantity  FROM Cart2 WHERE CustomerID = ? AND ProductID =? ";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, customerID);
            pstmt.setString(2, productID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	returnQuantity = rs.getInt("Quantity");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, pstmt, rs);
        }
        return returnQuantity;
	}

	public String updateQuantityCart(String cusotmerID, String productID, int newQuantity) {
		Connection connection = getConnection();

	    String sql = "UPDATE Cart2 SET Quantity = ? WHERE CustomerID = ? AND ProductID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setInt(1, newQuantity);
	            pstmt.setString(2, cusotmerID);
	            pstmt.setString(3, productID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Cart: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}




}
