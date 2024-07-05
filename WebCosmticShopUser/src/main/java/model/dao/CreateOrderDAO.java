package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import model.dto.CartDTO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class CreateOrderDAO extends BaseDAO {

	public String getLastestOrderID() {
		String lastestOrderID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT TOP 1 OrderID FROM Order1  ORDER BY OrderID DESC ";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lastestOrderID = rs.getString("OrderID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return lastestOrderID;
	}

	public String insertOrder(String customerID, String fullname, String address, String phone, String email,
			String grandTotal, String method, String lastestOrderID, String statusOrder) {
		Connection connection = getConnection();
		String sql = "INSERT INTO Order1 (CustomerID, ShipAddress, OrderPhone, DiscountCode, GrandTotal,Payments, OrderID, Status ) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
			pstmt.setString(2, address);
			pstmt.setString(3, phone);
			pstmt.setString(4, "email");
			pstmt.setString(5, grandTotal);
			pstmt.setString(6, method);
			pstmt.setString(7, lastestOrderID);
			pstmt.setString(8, statusOrder);
			
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào PG: " + x);
		} catch (SQLException e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();

			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {

				return "Duplicate ID Error";

			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	public String insertOrderDetail(String productID, String quantity, String price, String lastestOrderID, String statusOrderDetail) {
		Connection connection = getConnection();
		String sql = "INSERT INTO OrderDetail (ProductID, Quantity, UnitPrice, OrderID, Status ) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productID);
			pstmt.setString(2, quantity);
			pstmt.setString(3, price);
			pstmt.setString(4, lastestOrderID);
			pstmt.setString(5, statusOrderDetail);
		
			

			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record vào PG: " + x);
		} catch (SQLException e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();

			if (errorMessage != null && errorMessage.contains("The duplicate key value is")) {

				return "Duplicate ID Error";

			}
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return "No Error";
	}

	public OrderDTO showReview(String customerID) {
		OrderDTO returned = new OrderDTO();

		Connection connection = getConnection();
		String sql = "SELECT  o.OrderID OrderID, o.CustomerID cusID, o.GrandTotal GrandTotal, o.Payments Payment, o.OrderPhone Phone, o.ShipAddress Address, c.FullName fullname From  Order1  o\r\n"
				+ "INNER JOIN Customer2 c ON o.CustomerID = c.CustomerID WHERE o.CustomerID = ? ";
//		String sql = "SELECT * FROM Order1 WHERE customerID = ? AND Status = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Status = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customerID);
//			pstmt.setString(2, Status);
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
//				item.setEmail(rs.getString("address"));
				
				returned = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	public ArrayList<OrderDetailDTO> getOrderDetail(String OrderID) {
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
            pstmt.setString(1, OrderID);
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

	public String getOrderID(String customerID) {
		String orderID = null;
		Connection connection = getConnection();
		String 	sql = "SELECT *  FROM Order1  WHERE CustomerID = ? AND Status=?";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = connection.prepareStatement(sql);
				   pstmt.setString(1, customerID);
				   pstmt.setString(2, "Chưa thanh toán");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					orderID = rs.getString("OrderID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection, pstmt, rs);
			}
			
			
	
		return orderID;
	}

	public String updateOrder(String orderID) {
		
		Connection connection = getConnection();

	    String sql = "UPDATE Order1 SET Status = ?, OrderDate = ?  WHERE OrderID = ?";

	    PreparedStatement pstmt = null;


	    try {
	    		Timestamp currentTime = Timestamp.from(Instant.now());

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, "cho");
	            pstmt.setTimestamp(2, currentTime);
	            pstmt.setString(3, orderID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Order: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	            return "Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

		return "No Error";
	}

	public void deleteOrder(String customerID) {
		Connection connection = getConnection();

	    String sql = "DELETE Order1 WHERE customerID = ? AND Status = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, customerID);
	            pstmt.setString(2, "Chưa thanh toán");

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã delete số record trong Order: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

		
	}
	
	public void deleteOrder() {
		Connection connection = getConnection();

	    String sql = "DELETE Order1 WHERE Status = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, "Chưa thanh toán");

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã delete số record trong Order: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

		
	}
	public void deleteOrderDetail() {
		Connection connection = getConnection();

	    String sql = "DELETE OrderDetail WHERE  Status = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, "0");

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã delete số record trong OrderDetail: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

		
	}

	public String updateOrderDetail(String orderID) {
		Connection connection = getConnection();

	    String sql = "UPDATE OrderDetail SET Status = ?  WHERE OrderID = ? ";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, "1");
	            pstmt.setString(2, orderID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong OrderDetail: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();
	            return "Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

		return "No Error";
	}

}
