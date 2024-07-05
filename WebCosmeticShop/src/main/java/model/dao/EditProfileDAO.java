package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditProfileDAO extends BaseDAO {

	public String editProfile( String fullName,
			String address, String phone, String email) {
		Connection connection = getConnection();

	    String sql = "UPDATE User1 SET fullName = ?,  Address=?, Phone=?  WHERE email = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, fullName);

	            pstmt.setString(2, address);
	            pstmt.setString(3, phone);
	            pstmt.setString(4, email);
	 

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Employee: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String editProfileImage(String email, String img) {
		Connection connection = getConnection();

	    String sql = "UPDATE User1 SET  Image = ?   WHERE Email = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, img);
	            pstmt.setString(2, email);
	 

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update image trong Employee: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	}


