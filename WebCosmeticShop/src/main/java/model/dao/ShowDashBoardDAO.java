package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.OrderDTO;
import model.dto.ProductDTO;


public class ShowDashBoardDAO extends BaseDAO {

	public String getSales() {
		Connection connection = getConnection();
		String sql = "SELECT COUNT(*) AS Sales FROM Order1 WHERE Status = 'xong'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String returned = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();


			while (rs.next()) {
				returned = rs.getString("Sales");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;		
	}

	public String getCustomer() {
		Connection connection = getConnection();
		String sql = "SELECT COUNT(*) AS cus FROM Customer2 WHERE isDelete = 'true'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String returned = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();


			while (rs.next()) {
				returned = rs.getString("cus");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;		
	}

	public String getTotal() {
		Connection connection = getConnection();
		String sql = "SELECT SUM(GrandTotal) AS TotalGrandTotal FROM Order1 WHERE Status = 'xong'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String returned = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();


			while (rs.next()) {
				returned = rs.getString("TotalGrandTotal");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	public ArrayList<OrderDTO> getOrderList() {
		ArrayList<OrderDTO> returnedList = new ArrayList<OrderDTO>();

		Connection connection = getConnection();
		String sql = "SELECT OrderID, Order1.CustomerID CustomerID, EmployeeID, GrandTotal, Customer2.FullName fullname,  Status  FROM Order1\r\n"
				+ "INNER JOIN Customer2 ON Customer2.CustomerID = Order1.CustomerID \r\n"
				+ "WHERE  Status = 'cho'";
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

	public ArrayList<ProductDTO> getProductList() {
		ArrayList<ProductDTO> returnedList = new ArrayList<ProductDTO>();

		Connection connection = getConnection();

		String sql ="WITH SoldQuantityByProductGroup AS (\r\n"
				+ "    SELECT \r\n"
				+ "        pg.ProductGroupID,\r\n"
				+ "        pg.ProductGroupName AS ProductGroupName,\r\n"
				+ "        SUM(od.Quantity) AS TotalSoldQuantity,\r\n"
				+ "        p.ProductID,\r\n"
				+ "        p.Image,\r\n"
				+ "        p.Size,\r\n"
				+ "        ROW_NUMBER() OVER(PARTITION BY pg.ProductGroupID ORDER BY p.Size DESC) AS RowNum\r\n"
				+ "    FROM PRODUCTGROUP1 pg\r\n"
				+ "    INNER JOIN PRODUCT1 p ON pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "    INNER JOIN ORDERDETAIL od ON p.ProductID = od.ProductID\r\n"
				+ "    INNER JOIN [ORDER1] ord ON od.OrderID = ord.OrderID\r\n"
				+ "    WHERE pg.isDelete = 'true'\r\n"
				+ "      AND ord.Status = 'xong'\r\n"
				+ "    GROUP BY pg.ProductGroupID, pg.ProductGroupName, p.ProductID, p.Image, p.Size\r\n"
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    ProductGroupID,\r\n"
				+ "    ProductGroupName,\r\n"
				+ "    TotalSoldQuantity,\r\n"
				+ "    ProductID,\r\n"
				+ "    Image,\r\n"
				+ "    Size\r\n"
				+ "FROM SoldQuantityByProductGroup\r\n"
				+ "WHERE RowNum = 1\r\n"
				+ "ORDER BY TotalSoldQuantity DESC;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ProductDTO item = null;

			while (rs.next()) {
				item = new ProductDTO();
				item.setProductGroupID(rs.getString("ProductGroupID"));
				item.setProductGroupName(rs.getString("ProductGroupName"));
				item.setCategoryName(rs.getString("TotalSoldQuantity"));
				item.setImage(rs.getString("Image"));
//				item.setProductID(rs.getString("ProductID"));

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
