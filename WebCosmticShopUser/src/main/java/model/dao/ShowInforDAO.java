package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Customer;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;


public class ShowInforDAO extends BaseDAO {

	public Customer getInfor(String customerID) {
		Customer returned = new Customer();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Customer2 WHERE CustomerID = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			rs = pstmt.executeQuery();

			Customer item = null;

			while (rs.next()) {
				item = new Customer();
				item.setCustomerID(rs.getString("CustomerID"));
				item.setFullName(rs.getString("fullName"));
				item.setEmail(rs.getString("Email"));
				item.setPassword(rs.getString("Password"));
				item.setAddress(rs.getString("Address"));
				item.setPhone(rs.getString("Phone"));

				returned = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	
		public ArrayList<OrderDTO> getOrderList(String customerID) {
		    ArrayList<OrderDTO> returnedList = new ArrayList<OrderDTO>();

		    Connection connection = getConnection();
		    String sql = "SELECT * FROM Order1 WHERE CustomerID = ?";
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    try {
		        pstmt = connection.prepareStatement(sql);
		        pstmt.setString(1, customerID);
		        rs = pstmt.executeQuery();

		        OrderDTO item = null;

		     
		        while (rs.next()) {
		            item = new OrderDTO();
		            item.setOrderID(rs.getString("OrderID"));
		            item.setStatus(rs.getString("Status"));
		            item.setGrandTotal(rs.getDouble("GrandTotal"));
		            item.setOrderDate(rs.getString("OrderDate"));

		            returnedList.add(item);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        closeConnection(connection, pstmt, rs);
		    }

		    

		    return returnedList;
		}


		public OrderDTO getOrder(String orderID) {
			OrderDTO returned = new OrderDTO();

			Connection connection = getConnection();
			String sql = "SELECT  o.OrderDate OrderDate, o.OrderID OrderID, o.CustomerID cusID, o.GrandTotal GrandTotal, o.Payments Payment,o.Status Status, o.OrderPhone Phone, o.ShipAddress Address, c.FullName fullname From  Order1  o\r\n"
					+ "					INNER JOIN Customer2 c ON o.CustomerID = c.CustomerID WHERE o.OrderID = ? ";
//			String sql = "SELECT * FROM Order1 WHERE customerID = ? AND Status = ? ";
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
					
//					item.setEmail(rs.getString("address"));
//					item.setOrderDate(rs.getString("OrderDate"));
					
					returned = item;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			return returned;
		}


		public ArrayList<OrderDetailDTO>  getOrderDetail(String orderID) {
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
		
