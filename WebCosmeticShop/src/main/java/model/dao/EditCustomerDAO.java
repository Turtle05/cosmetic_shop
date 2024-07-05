package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Customer;

public class EditCustomerDAO extends BaseDAO {

	public Customer getCustomer(String customerID) {
		Customer customer = new Customer();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Customer2 WHERE CustomerID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setFullname(rs.getString("FullName"));
				customer.setAddress(rs.getString("Address"));
				customer.setEmail(rs.getString("Email"));
				customer.setPhone(rs.getString("Phone"));
				customer.setPassword(rs.getString("Password"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}
		return customer;

	}

	public String editCustomer(String customerID, String customerName, String gender, String birthday, String address,
			String phone, String email, String username, String password) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET FullName = ?, Username = ?, Password = ?, Gender=?, Birthday=?, Address=?, Phone=?, Email=?   WHERE CustomerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, customerName);
	            pstmt.setString(2, username);
	            pstmt.setString(3, password);
	            pstmt.setString(4, gender);
	            pstmt.setString(5, birthday);
	            pstmt.setString(6, address);
	            pstmt.setString(7, phone);
	            pstmt.setString(8, email);
	            pstmt.setString(9, customerID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

}
