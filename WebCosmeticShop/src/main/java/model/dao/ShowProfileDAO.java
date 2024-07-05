package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Employee;

public class ShowProfileDAO extends BaseDAO {

	public Employee getProfile(String username) {
		Employee returned = new Employee();

		Connection connection = getConnection();
		String sql = "SELECT * FROM User1 WHERE Email = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			Employee item = null;

			while (rs.next()) {
				item = new Employee();
				item.setUsername(rs.getString("Email"));
				item.setPassword(rs.getString("password"));
				item.setRole(rs.getString("role"));
				item.setFullName(rs.getString("fullname"));
				item.setEmail(rs.getString("email"));
				item.setAddress(rs.getString("address"));
				item.setPhone(rs.getString("phone"));
				item.setImage(rs.getString("image"));
				returned = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}


}
