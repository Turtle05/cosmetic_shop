package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Customer;

public class SearchCustomerDAO extends BaseDAO {

	public ArrayList<Customer> getProductList(String searchText) {
		ArrayList<Customer> returnedList = new ArrayList<Customer>();

		Connection connection = getConnection();


		String sql = "SELECT * FROM Customer2 WHERE isDelete='true' AND (fullname LIKE ? OR Phone LIKE ? OR Address LIKE ? OR CustomerID LIKE ?)";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, "%" + searchText + "%");

			pstmt.setString(2, "%" + searchText + "%");

			pstmt.setString(3, "%" + searchText + "%");

			pstmt.setString(4, "%" + searchText + "%");


			rs = pstmt.executeQuery();

			Customer item = null;

			while (rs.next()) {

				item = new Customer();

				item = new Customer();
				item.setCustomerID(rs.getString("CustomerID"));
				item.setFullname(rs.getString("Fullname"));
				item.setEmail(rs.getString("Email"));
				item.setPhone(rs.getString("Phone"));
				item.setAddress(rs.getString("Address"));
				item.setEnable(rs.getString("Enable"));

				returnedList.add(item);

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}

		return returnedList;
	}

}
