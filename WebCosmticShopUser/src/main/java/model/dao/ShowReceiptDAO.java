package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.OrderDTO;

public class ShowReceiptDAO extends BaseDAO {

	public OrderDTO getOrder(String orderID) {
		OrderDTO returned = new OrderDTO();

		Connection connection = getConnection();
		String sql = "SELECT   c.Email Email, o.OrderDate OrderDate, o.OrderID OrderID, o.CustomerID cusID, o.GrandTotal GrandTotal,o.Status Status, o.Payments Payment, o.OrderPhone Phone, o.ShipAddress Address, c.FullName fullname From  Order1  o\r\n"
				+ "INNER JOIN Customer2 c ON o.CustomerID = c.CustomerID WHERE o.OrderID = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, orderID );
			rs = pstmt.executeQuery();

			OrderDTO item = null;

			while (rs.next()) {
				item = new OrderDTO();
				item.setOrderID(rs.getString("OrderID"));
				item.setCustomerID(rs.getString("cusID"));
				item.setCustomerName(rs.getString("fullname"));
				item.setAddress(rs.getString("Address"));
				item.setPhone(rs.getString("Phone"));
				item.setPayment(rs.getString("Payment"));
				item.setGrandTotal(rs.getDouble("GrandTotal"));
				item.setEmail(rs.getString("Email"));
				item.setStatus(rs.getString("Status"));
				item.setOrderDate(rs.getString("OrderDate"));
				
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
