package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RateDAO extends BaseDAO {

	public String createRate(String customerID, String productGroupID, String star, String comment, String id) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Feedback (cusomerID, productGroupID, star, comment, id ) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			pstmt.setString(2, productGroupID);
			pstmt.setString(3, star);
			pstmt.setString(4, comment);
			pstmt.setString(5, id);
		
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào danhgia: " + x);
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

	public String getId() {
		String id = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 id FROM Feedback  ORDER BY id DESC ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					id = rs.getString("id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return id;
	}

}
