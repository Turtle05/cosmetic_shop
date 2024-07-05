package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateBrandDAO extends BaseDAO {

	public String insertCatGroup(String lastestBrandID, String brandName, String nation, String img) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Brand1 (BrandID, BrandName, Nation, Image, isDelete) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestBrandID);
			pstmt.setString(2, brandName);
			pstmt.setString(3, nation);
			pstmt.setString(4, img);
			pstmt.setString(5, "true");

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);
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

	public String getLastestBrandID() {
		String lastestBrandID = null;
		Connection connection = getConnection();
		String sql = "SELECT TOP 1 BrandID FROM BRAND1 ORDER BY BrandID DESC";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lastestBrandID = rs.getString("BrandID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return lastestBrandID;
	}

}
