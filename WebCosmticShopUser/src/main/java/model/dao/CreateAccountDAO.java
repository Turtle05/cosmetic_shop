package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Customer;

public class CreateAccountDAO extends BaseDAO {

	

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

//	public String insertAccount(String lastestCustomerID, String username, String password, String fullname) {
//		Connection connection = getConnection();
//		String sql = "INSERT INTO Customer (CustomerID, Username, Password, FullName) VALUES (?,?,?,?)";
//		PreparedStatement pstmt = null;
//
//		try {
//			pstmt = connection.prepareStatement(sql);
//			pstmt.setString(1, lastestCustomerID);
//			pstmt.setString(2, username);
//			pstmt.setString(3, password);
//			pstmt.setString(4, fullname);
//
//			int x = pstmt.executeUpdate();
//			System.out.println("Đã chèn số record vào Customer: " + x);
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//			String errorMessage = e.getMessage();
//
//			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {
//
//				return "Duplicate ID Error";
//
//			}
//		} finally {
//			closeConnection(connection, pstmt, null);
//		}
//		return "No Error";
//	}
	
	
	

	public String insertAccount(String lastestCustomerID, String username, String password, String fullname) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Customer2 (CustomerID, Email, Password, FullName, Enable, isDelete) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestCustomerID);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, fullname);
			pstmt.setString(5, "true");
			pstmt.setString(6, "true");

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào Customer: " + x);
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

	public ArrayList<Customer> getEmailList() {
		ArrayList<Customer> returnedList = new ArrayList<Customer>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Customer2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Customer item = null;

			while (rs.next()) {
				item = new Customer();
				item.setEmail(rs.getString("Email"));
				

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}
	
	
	
	
	
	

}
