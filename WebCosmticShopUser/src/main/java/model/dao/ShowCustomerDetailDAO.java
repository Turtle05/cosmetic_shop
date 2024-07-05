package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.CustomerDTO;

public class ShowCustomerDetailDAO extends BaseDAO {

	public CustomerDTO getCusDetail(String customerID) {
		CustomerDTO returned = new CustomerDTO();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Customer2 WHERE customerID = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			rs = pstmt.executeQuery();

			CustomerDTO item = null;

			while (rs.next()) {
				item = new CustomerDTO();
				item.setFullname(rs.getString("FullName"));
				item.setEmail(rs.getString("Email"));
				item.setPhone(rs.getString("Phone"));
				item.setAddress(rs.getString("Address"));
				
				
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
