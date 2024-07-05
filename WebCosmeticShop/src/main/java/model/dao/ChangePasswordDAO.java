package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChangePasswordDAO extends BaseDAO{

	public String changePassword(String username, String newpassword ) {
		




    Connection connection = getConnection();

    String sql = "UPDATE User1 SET password = ? WHERE email = ?";

    PreparedStatement pstmt = null;


    try {

            pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(2, username);

            pstmt.setString(1, newpassword);

         


            int x = pstmt.executeUpdate();

            System.out.println("Đã update password: " + x);


    } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();


            return "Duplicate ID Error";


    } finally {

            closeConnection(connection, pstmt, null);

    }


    return "No Error";
	}

}
