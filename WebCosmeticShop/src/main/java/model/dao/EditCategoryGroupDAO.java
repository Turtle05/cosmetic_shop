package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.CategoryGroup;

public class EditCategoryGroupDAO extends BaseDAO {

	public CategoryGroup getCatGroupInfor(String catGroupID) {

		CategoryGroup catGroup = new CategoryGroup();

		Connection connection = getConnection();
		String sql = "SELECT * FROM CategoryGroup WHERE CategoryGroupID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, catGroupID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				catGroup.setCategoryGroupID(rs.getString("CategoryGroupID"));
				catGroup.setCategoryGroupName(rs.getString("CategoryGroupName"));
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}
		return catGroup;

	}

	public String editCategoryGroup(String catGroupID, String catGroupName) {
	    Connection connection = getConnection();

	    String sql = "UPDATE CategoryGroup SET CategoryGroupName = ?  WHERE CategoryGroupID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, catGroupName);
	            pstmt.setString(2, catGroupID);

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
}
