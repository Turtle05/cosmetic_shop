package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;

public class ShowEmployeeListDAO extends BaseDAO {

	public ArrayList<User> getEmployeeList() {
		ArrayList<User> returnedList = new ArrayList<User>();
		Connection connection = getConnection();
		String sql = "SELECT UserID, FullName, Email, Phone, Address, Image, Enable  FROM User1 WHERE Role = 'user' AND isDelete='true'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			User item = null;

			while (rs.next()) {
				item = new User();
				item.setUserID(rs.getString("UserID"));
				item.setFullName(rs.getString("FullName"));
				item.setEmail(rs.getString("Email"));
				item.setPhone(rs.getString("Phone"));
				item.setAddress(rs.getString("Address"));
				item.setImage(rs.getString("Image"));
				item.setEnable(rs.getString("Enable"));

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
