package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Product;
import model.dto.DanhgiaDTO;
import model.dto.ProDTO;
import model.dto.ProductDTO;

public class ShowProductDetailDAO extends BaseDAO {

	public Product getProductDetail(String productID) {
		Product returned = new Product();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Product1  WHERE ProductID = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productID);
			rs = pstmt.executeQuery();

			Product item = null;

			while (rs.next()) {
				item = new Product();
				item.setProductID(rs.getString("ProductID"));
				item.setProductGroupID(rs.getString("ProductGroupID"));
				item.setPrice(rs.getDouble("Price"));
				item.setQuantity(rs.getInt("Quantity"));
				item.setSize(rs.getString("Size"));
				item.setImage(rs.getString("Image"));

				returned = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	public ProDTO getProductGroup(String productGroupID) {
		ProDTO productGroup = new ProDTO();

		Connection connection = getConnection();
		String sql = "SELECT pg.ProductGroupID PGID, pg.ProductGroupName PGNAME, pg.BrandID BrandID, pg.CategoryID CatID, pg.Description Des, \r\n"
				+ "pg.Manuals Manuals,b.BrandName BrandName, c.CategoryName CatName, cg.CategoryGroupName CatGroupName, cg.CategoryGroupID CatGroupID\r\n"
				+ "FROM ProductGroup1 pg  \r\n" + "INNER JOIN Brand1 b  ON pg.BrandID = b.BrandID \r\n"
				+ "INNER JOIN Category1 c ON pg.CategoryID = c.CategoryID\r\n"
				+ "INNER JOIN CategoryGroup1 cg ON c.CategoryGroupID = cg.CategoryGroupID\r\n"
				+ "WHERE ProductGroupID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			ProDTO item = null;

			while (rs.next()) {
				item = new ProDTO();
				item.setProductGroupID(rs.getString("PGID"));
				item.setProductGroupName(rs.getString("PGNAME"));
				item.setBrandID(rs.getString("BrandID"));
				item.setBrandName(rs.getString("BrandName"));
				item.setCategoryID(rs.getString("CatID"));
				item.setCategoryName(rs.getString("CatName"));
				item.setCategoryGroupID(rs.getString("CatGroupID"));
				item.setCategoryGroupName(rs.getString("CatGroupName"));
				item.setDes(rs.getString("Des"));
				item.setManual(rs.getString("Manuals"));

				productGroup = item;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return productGroup;
	}



	public ArrayList<Product> getProductist(String productGroupID) {
		ArrayList<Product> returnedList = new ArrayList<>();

		Connection connection = getConnection();
		String sql = "SELECT ProductID, p.Size Size, p.Image Image, pg.ProductGroupID ProGroupID\r\n"
				+ "FROM PRODUCTGROUP1 pg\r\n" + "INNER JOIN Product1 p ON pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "WHERE pg.ProductGroupID = ? AND pg.isDelete='true'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product item = new Product();
				item.setProductID(rs.getString("ProductID"));
				item.setSize(rs.getString("Size"));
				item.setImage(rs.getString("Image"));
				item.setProductGroupID(rs.getString("ProGroupID"));

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Log error message or handle exception as needed
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public ArrayList<DanhgiaDTO> getRate(String productGroupID) {
		ArrayList<DanhgiaDTO> returned = new ArrayList<DanhgiaDTO>();

		Connection connection = getConnection();
		String sql = "SELECT d.id id, d.star star, d.comment comment,d.cusomerID customerID, c.FullName fullname FROM PRODUCTGROUP1 p\r\n"
				+ "INNER JOIN Feedback d ON p.ProductGroupID=d.productGroupID\r\n"
				+ "INNER JOIN customer2 c ON d.cusomerID = c.CustomerID\r\n"
				+ "WHERE p.ProductGroupID =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			DanhgiaDTO item = null;

			while (rs.next()) {
				item = new DanhgiaDTO();
				item.setId(productGroupID);
				item.setComment(rs.getString("comment"));
				item.setCustomerID(rs.getString("customerID"));
				item.setStar(rs.getInt("star"));
				item.setFullname(rs.getString("fullname"));

				returned.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returned;
	}

	public DanhgiaDTO getStar(String productGroupID) {
		DanhgiaDTO returned = new DanhgiaDTO();

		Connection connection = getConnection();
		String sql = "SELECT AVG(d.star) AS starAVG,  COUNT(d.star) AS rateNum FROM  Feedback d WHERE   d.star IS NOT NULL  AND d.productGroupID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			DanhgiaDTO item = null;

			while (rs.next()) {
				item = new DanhgiaDTO();
				item.setStarRate(rs.getFloat("starAVG"));
				item.setRateNum(rs.getInt("rateNum"));
			

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
