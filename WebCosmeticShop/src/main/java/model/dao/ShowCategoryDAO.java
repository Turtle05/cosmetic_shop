package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Category;


public class ShowCategoryDAO extends BaseDAO {

	public ArrayList<Category> getCategory() {
		ArrayList<Category> returnedList = new ArrayList<Category>();

		Connection connection = getConnection();
		String sql = "SELECT CategoryID, CategoryName, CategoryGroup1.CategoryGroupName FROM Category1 INNER JOIN CategoryGroup1 ON Category1.CategoryGroupID = CategoryGroup1.CategoryGroupID WHERE Category1.isDelete = 'true'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Category item = null;

			while (rs.next()) {
				item = new Category();
				item.setCategoryID(rs.getString("CategoryID"));
				item.setCategoryName(rs.getString("CategoryName"));
				item.setCategoryGroupName(rs.getString("CategoryGroupName"));

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public List<Category> getCategoriesByGroup(String categoryGroupID)  {
		ArrayList<Category> categories = new ArrayList<Category>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM category1 WHERE categoryGroupID = ? AND isDelete='true' ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, categoryGroupID);
			rs = pstmt.executeQuery();

			Category item = null;

			while (rs.next()) {
				item = new Category();
				item.setCategoryID(rs.getString("categoryID"));
				item.setCategoryName(rs.getString("categoryName"));

				categories.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return categories;
	}

}

