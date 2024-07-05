package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Category;
import model.dto.ProductDTO;


public class EditCategoryDAO extends BaseDAO {

	public Category getCat(String catID) {
		Category cat = new Category();

		Connection connection = getConnection();
		String sql = "SELECT CategoryID, CategoryName, Category1.CategoryGroupID, CategoryGroup1.CategoryGroupName FROM Category1 INNER JOIN CategoryGroup1 ON Category1.CategoryGroupID = CategoryGroup1.CategoryGroupID WHERE CategoryID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, catID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cat.setCategoryID(rs.getString("CategoryID"));
				cat.setCategoryName(rs.getString("CategoryName"));
				cat.setCategoryGroupID(rs.getString("CategoryGroupID"));
				cat.setCategoryGroupName(rs.getString("CategoryGroupName"));
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}
		return cat;

	}

	public String editCategory(String categoryID, String catName, String catGroupID) {
		Connection connection = getConnection();

	    String sql = "UPDATE Category1 SET CategoryName = ?, CategoryGroupID = ?  WHERE CategoryID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, catName);
	            pstmt.setString(2, catGroupID);
	            pstmt.setString(3, categoryID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String deleteCategory(String id) {
		Connection connection = getConnection();

	    String sql = "UPDATE Category1 SET isDelete = 'false' WHERE categoryID =?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Category: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String checkCat(String id) {
		String returnedList = new String();

		Connection connection = getConnection();
		
		String sql ="Select ProductGroupID  from ProductGroup1 where categoryID = ? and isDelete='true'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();



			while (rs.next()) {
				returnedList = rs.getString("ProductGroupID");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

}
