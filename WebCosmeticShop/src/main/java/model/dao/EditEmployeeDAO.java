package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.User;

public class EditEmployeeDAO extends BaseDAO {

	public User getEmployee(String employeeID) {
		User employee = new User();

		Connection connection = getConnection();
		String sql = "SELECT * FROM User1 WHERE UserID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, employeeID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				employee.setUserID(rs.getString("UserID"));
				employee.setFullName(rs.getString("FullName"));
				employee.setAddress(rs.getString("Address"));
				employee.setEmail(rs.getString("Email"));
				employee.setPhone(rs.getString("Phone"));
				employee.setPassword(rs.getString("Password"));
				employee.setImage(rs.getString("Image"));
				
			}
			System.out.println("Lấy EmployeeInfor  thành công");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}
		return employee;
	}

	public String editEmployee(String employeeID, String fullName, String address,
			String phone,String password, String img) {
		Connection connection = getConnection();

	    String sql = "UPDATE User1 SET FullName = ?, Password = ?,Address=?, Phone=?,Image = ?  WHERE UserID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, fullName);
	            pstmt.setString(2, password);
	            pstmt.setString(3, address);
	            pstmt.setString(4, phone);
	            pstmt.setString(5, img);
	            pstmt.setString(6, employeeID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong User: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String deleteEmployee(String id) {
		Connection connection = getConnection();

	    String sql = "UPDATE User1 SET isDelete = 'false' WHERE userID =?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong User: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String enableUser(String id, String en) {
		Connection connection = getConnection();

	    String sql = "UPDATE User1 SET Enable = ? WHERE userID =?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, en);
	            pstmt.setString(2, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong User: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String enableCustomer(String id, String en) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET Enable = ? WHERE customerID =?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, en);
	            pstmt.setString(2, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Customer2: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String deleteCustomer(String id) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET isDelete = 'false' WHERE customerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong User: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String checkCus(String id) {
		String returnedList = new String();

		Connection connection = getConnection();
		
		String sql ="Select * from Order1  where (CustomerID= ? and Status = 'giao') or  (CustomerID= ?  and Status = 'giao')";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();



			while (rs.next()) {
				returnedList = rs.getString("CustomerID");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}
	


}
