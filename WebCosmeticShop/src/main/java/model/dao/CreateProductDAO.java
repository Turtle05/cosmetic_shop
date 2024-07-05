package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateProductDAO extends BaseDAO {

	

	public String getLastestProductGroupID() {
		String lastestProductGroupID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 ProductGroupID FROM ProductGroup1  ORDER BY ProductGroupID DESC ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestProductGroupID = rs.getString("ProductGroupID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestProductGroupID;
	}

	public String createProductGroup(String ProductGroupID, String nameProduct,  String cat, String des, String brandID) {
		Connection connection = getConnection();
		String sql = "INSERT INTO ProductGroup1 (ProductGroupID, ProductGroupName, CategoryID, Description, BrandID, isDelete ) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ProductGroupID);
			pstmt.setString(2, nameProduct);
			pstmt.setString(3, cat);
			pstmt.setString(4, des);
			pstmt.setString(5, brandID);
			pstmt.setString(6, "true");
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào PG: " + x);
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

	public String getLastestProductID() {
		String lastestProductID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 ProductID FROM Product1  ORDER BY ProductID DESC ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestProductID = rs.getString("ProductID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestProductID;
	}

	public String createProduct(String lastestProductID, String dungtich, String price, String quantity, String filename,  String lastestProductGroupID) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Product1 (ProductID, Size, Price, Quantity,  Image, ProductGroupID, isDelete ) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, lastestProductID);
			pstmt.setString(2, dungtich);
			pstmt.setString(3, price);
			pstmt.setDouble(4, Integer.valueOf(quantity));
			pstmt.setString(5, filename);
			pstmt.setString(6, lastestProductGroupID);
			pstmt.setString(7, "true");
		
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào PG: " + x);
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

}
