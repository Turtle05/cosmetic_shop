package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CategoryGroup;


public class ShowCategoryGroupDAO extends BaseDAO {

	public ArrayList<CategoryGroup> getCategoryGroup() {
		ArrayList<CategoryGroup> returnedList = new ArrayList<CategoryGroup>();

		Connection connection = getConnection();
		String sql = "SELECT CategoryGroupID, CategoryGroupName FROM CATEGORYGROUP1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			CategoryGroup item = null;

			while (rs.next()) {
				item = new CategoryGroup();
				item.setCategoryGroupID(rs.getString("CategoryGroupID"));
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

	

}





























