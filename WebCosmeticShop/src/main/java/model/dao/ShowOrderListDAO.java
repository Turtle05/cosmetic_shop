package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class ShowOrderListDAO extends BaseDAO {

	public ArrayList<OrderDTO> getOrderList() {
		ArrayList<OrderDTO> returnedList = new ArrayList<OrderDTO>();

		Connection connection = getConnection();
		String sql = "SELECT OrderID, Order1.CustomerID CustomerID, EmployeeID, GrandTotal, Customer2.FullName fullname,  Status  FROM Order1\r\n"
				+ "INNER JOIN Customer2 ON Customer2.CustomerID = Order1.CustomerID \r\n"
				+ "WHERE Status = 'xong' OR Status = 'giao' OR Status = 'cho'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			OrderDTO item = null;

			while (rs.next()) {
				item = new OrderDTO();
				item.setOrderID(rs.getString("OrderID"));
				item.setCustomerID(rs.getString("CustomerID"));
				/* item.setEmployeeName(rs.getString("EmployeeID")); */
				item.setGrandTotal(rs.getDouble("GrandTotal"));
				item.setStatus(rs.getString("Status"));
				item.setCustomerName(rs.getString("fullname"));
				
				

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public OrderDTO getInfor(String orderID) {
		OrderDTO returned = new OrderDTO();

		Connection connection = getConnection();
		String sql = "SELECT  o.OrderDate OrderDate, o.ShippedDate ShippedDate, o.OrderID OrderID, o.CustomerID cusID, o.GrandTotal GrandTotal, o.Payments Payment,o.Status Status, o.OrderPhone Phone, o.ShipAddress Address, c.FullName fullname From  Order1  o\r\n"
				+ "					INNER JOIN Customer2 c ON o.CustomerID = c.CustomerID WHERE o.OrderID = ? ";
//		String sql = "SELECT * FROM Order1 WHERE customerID = ? AND Status = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, orderID);
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
				item.setStatus(rs.getString("Status"));
				item.setOrderDate(rs.getString("OrderDate"));
				item.setShippedDate(rs.getString("ShippedDate"));
				
//				item.setEmail(rs.getString("address"));
//				item.setOrderDate(rs.getString("OrderDate"));
				
				returned = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	public ArrayList<OrderDetailDTO> getOrderDetail(String orderID) {
		ArrayList<OrderDetailDTO> returnedList = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT  o.Quantity Quantity, o.ProductID ProductID,o.OrderID OrderID, p.Size Size, o.UnitPrice Price, pg.ProductGroupName PGNAME FROM OrderDetail o\r\n"
        		+ "INNER JOIN  Product1 p ON o.ProductID = p.ProductID\r\n"
        		+ "INNER JOIN ProductGroup1 pg ON p.ProductGroupID = pg.ProductGroupID\r\n"
        		+ "WHERE o.OrderID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, orderID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	OrderDetailDTO item = new OrderDetailDTO();
                item.setQuantity(rs.getInt("Quantity"));
                item.setProductID(rs.getString("ProductID"));
                item.setSize(rs.getString("Size"));
                item.setProductName(rs.getString("PGNAME"));
                item.setPrice(rs.getDouble("Price"));
                item.setOrderID(rs.getString("OrderID"));
                

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
