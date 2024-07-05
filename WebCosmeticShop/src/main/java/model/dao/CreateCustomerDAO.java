package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CreateCustomerDAO extends BaseDAO{


	public String createCustomer(String lastestCatGroupID, String customerName,
			String address, String phone, String email, String password) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Customer2 (CustomerID, FullName, Address, Phone, Email, Password, isDelete, Enable) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestCatGroupID);
			pstmt.setString(2, customerName);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, password);
			pstmt.setString(7, "true");
			pstmt.setString(8, "true");

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);
		} catch (SQLException e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();

			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {

				return "Duplicate ID Error";

			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	public String insertCatGroup(String catGroupID, String catGroupName) {
		Connection connection = getConnection();
		String sql = "INSERT INTO CategoryGroup (CategoryGroupID, CategoryGroupName) VALUES (?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, catGroupID);
			pstmt.setString(2, catGroupName);

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);
		} catch (SQLException e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();

			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {

				return "Duplicate ID Error";

			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	
	public String getLastestCustomerID() {
		String lastestCustomerID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 CustomerID FROM Customer2 ORDER BY CustomerID DESC";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestCustomerID = rs.getString("CustomerID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestCustomerID;
	}

	
}
