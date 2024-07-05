package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO extends BaseDAO {

	public int getAccountRole(String userName, String password) {
	     Connection connection = getConnection();
         String sql = "SELECT * FROM User1 WHERE Email = ? AND Password = ? AND isDelete= 'true' AND Enable = 'true'";
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
                 pstmt = connection.prepareStatement(sql);
                 pstmt.setString(1, userName);
                 pstmt.setString(2, password);
                 rs = pstmt.executeQuery();

                 
                 if (rs.next()) {
                         if ("admin".equals(rs.getString("Role"))) {
                                 return 1; // admin
                         } else {
                                 return 2; // employee
                         }
                 } else {
                         return 0;  // invalid account
                 }

         } catch (SQLException e) {

                 e.printStackTrace();

         } finally {
                 closeConnection(connection, pstmt, rs);
         }

         return 0; // invalid account
	}

}

