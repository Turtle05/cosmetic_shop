package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Brand;

public class ShowBrandListDAO extends BaseDAO {

	public ArrayList<Brand> getBrandList() {
		ArrayList<Brand> returnedList = new ArrayList<Brand>();

		Connection connection = getConnection();
		String sql = "SELECT BrandID, BrandName, Nation, Image FROM BRAND1 WHERE isDelete ='true'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Brand item = null;

			while (rs.next()) {
				item = new Brand();
				item.setBrandID(rs.getString("BrandID"));
				item.setBrandName(rs.getString("BrandName"));
				item.setNation(rs.getString("Nation"));
				item.setImage(rs.getString("Image"));

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
