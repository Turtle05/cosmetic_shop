package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordDAO extends BaseDAO{

	public String getPass(String customerID) {
		String returned = null;
		Connection connection = getConnection();
		String 	sql = "SELECT Password  FROM Customer2  WHERE CustomerID = ? ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				   pstmt.setString(1, customerID);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					returned = rs.getString("Password");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return returned;
	}

	public String changePassword(String customerID, String newpassword) {
		Connection connection = getConnection();

	    String sql = "UPDATE Customer2 SET Password = ? WHERE CustomerID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, newpassword);
	            pstmt.setString(2, customerID);

	            int x = pstmt.executeUpdate();

	            System.out.println("Đã update password: " + x);


	    } catch (SQLException e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	    } finally {

	            closeConnection(connection, pstmt, null);

	    }


	    return "No Error";
	}

}
