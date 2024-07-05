package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateEmployeeDAO extends BaseDAO {

	public String getLastestEmpoyeeID() {
		String lastestUserID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 UserID FROM User1  WHERE Role = ? ORDER BY UserID DESC ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, "user");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestUserID = rs.getString("UserID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestUserID;
	}

	public String createEmployee(String lastestUserID, String fullName, 
			String address, String phone, String email, String password, String image) {
		Connection connection = getConnection();
		String sql = "INSERT INTO User1 (UserID, FullName, Address, Phone, Email, Password,Image, Enable, Role, isDelete) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestUserID);
			pstmt.setString(2, fullName);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, password);
			pstmt.setString(7, image);
			pstmt.setString(8, "true");
			pstmt.setString(9, "user");
			pstmt.setString(10, "true");
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record user1: " + x);
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

}
