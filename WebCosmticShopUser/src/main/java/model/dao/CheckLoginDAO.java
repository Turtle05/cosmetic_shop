package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Product;

public class CheckLoginDAO extends BaseDAO {

	public int getAccountRole(String userName, String password) {
	     Connection connection = getConnection();
         String sql = "SELECT * FROM Customer2 WHERE Email = ? AND Password = ? AND Enable ='true' AND isDelete = 'true' ";
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
                 pstmt = connection.prepareStatement(sql);
                 pstmt.setString(1, userName);
                 pstmt.setString(2, password);
                 rs = pstmt.executeQuery();

                 
					if (rs.next()) {
						return 1; // admin

					}
         }catch (SQLException e) {

                 e.printStackTrace();

         } finally {
                 closeConnection(connection, pstmt, rs);
         }

         return 0; // invalid account
	}

	public String getCustomerID(String email) {
		String returned = null;
		Connection connection = getConnection();
		String sql = "SELECT CustomerID FROM Customer2  WHERE Email = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			

			while (rs.next()) {
				returned = rs.getString("CustomerID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}
}



