package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CategoryGroup;

public class CreateCategoryDAO extends BaseDAO {

	public String insertCat(String catID, String catName, String catGroupId) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Category1 (CategoryID, CategoryName, CategoryGroupID, isDelete) VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, catID);
			pstmt.setString(2, catName);
			pstmt.setString(3, catGroupId);
			pstmt.setString(4, "true");

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

	public String insertCatGroup(String catGroupID, String catGroupName) {
		Connection connection = getConnection();
		String sql = "INSERT INTO CategoryGroup1 (CategoryGroupID, CategoryGroupName) VALUES (?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, catGroupID);
			pstmt.setString(2, catGroupName);

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
	
	
	public String getLastestCatID() {
		String lastestCatID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 CategoryID FROM Category1 ORDER BY CategoryID DESC";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestCatID = rs.getString("CategoryID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestCatID;
	}
	
	
	public String getLastestCatGroupID() {
		String lastestCatID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 CategoryGroupID FROM CategoryGroup1 ORDER BY CategoryGroupID DESC";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestCatID = rs.getString("CategoryGroupID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
		return lastestCatID;
	}




	
	


} 



	




	

