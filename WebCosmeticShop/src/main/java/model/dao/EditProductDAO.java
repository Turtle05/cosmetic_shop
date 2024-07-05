package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Product;
import model.dto.ProDTO;
import model.dto.ProductDTO;

public class EditProductDAO extends BaseDAO {

	public ProDTO getProductDetail(String productGroupID) {
		ProDTO returnedList = new ProDTO();

		Connection connection = getConnection();
		String sql = "SELECT ProductGroupID, ProductGroupName, pg.CategoryID CatID, pg.BrandID BrandID, BrandName, CategoryName,  Manuals, c.CategoryGroupID CatGroupID, CategoryGroupName, Description FROM ProductGroup1 pg  \r\n"
				+ "INNER JOIN  Brand1 b  ON pg.BrandID = b.BrandID \r\n"
				+ "INNER JOIN  Category1 c  ON c.CategoryID = pg.CategoryID \r\n"
				+ "INNER JOIN CategoryGroup1 cg  ON c.CategoryGroupID = cg.CategoryGroupID \r\n"
				+ "WHERE productGroupID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				returnedList.setProductGroupID(rs.getString("ProductGroupID"));
				returnedList.setProductGroupName(rs.getString("ProductGroupName"));
				returnedList.setCategoryID(rs.getString("CatID"));
				returnedList.setCategoryName(rs.getString("CategoryName"));
				returnedList.setBrandID(rs.getString("BrandID"));
				returnedList.setBrandName(rs.getString("BrandName"));
				returnedList.setCategoryGroupID(rs.getString("CatGroupID"));
				returnedList.setCategoryGroupName(rs.getString("CategoryGroupName"));
				returnedList.setDes(rs.getString("Description"));
				returnedList.setManual(rs.getString("Manuals"));

			}
			System.out.println("Lấy ProductDetail  thành công");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}
		return returnedList;
	}

	public ArrayList<Product> getProduct(String productGroupID) {
		ArrayList<Product> returnedList = new ArrayList<Product>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM Product1 WHERE ProductGroupID = ? AND isDelete='true'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, productGroupID);
			rs = pstmt.executeQuery();

			Product item = null;

			while (rs.next()) {
				item = new Product();
				item.setProductID(rs.getString("ProductID"));
				item.setSize(rs.getString("Size"));
				item.setQuantity(rs.getInt("Quantity"));
				item.setPrice(rs.getDouble("Price"));
				item.setProductGroupID(rs.getString("ProductGroupID"));
				item.setImage(rs.getString("Image"));

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public String editProductGroup(String productGroupID, String nameProduct, String brand, String cat, String des) {
		Connection connection = getConnection();

		String sql = "UPDATE ProductGroup1 SET ProductGroupName = ?, BrandID = ?, CategoryID = ?, Description = ?  WHERE productGroupID = ?";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, nameProduct);
			pstmt.setString(2, brand);
			pstmt.setString(3, cat);
			pstmt.setString(4, des);
			pstmt.setString(5, productGroupID);

			int x = pstmt.executeUpdate();
			System.out.println("Đã update số record trong ProductGroup: " + x);

		} catch (SQLException e) {

			e.printStackTrace();

			return "Duplicate ID Error";

		} finally {
			closeConnection(connection, pstmt, null);
		}

		return "No Error";
	}

//	public ArrayList<Product> getProductList(String productGroupID) throws SQLException {
//		
//		ArrayList<Product> productIDList = new ArrayList<Product>();
//
//		Connection connection = getConnection();
//		String sql = "SELECT ProductID FROM Product1 WHERE ProductGroupID = ?";
//				
//		PreparedStatement pstmt = null;
//		pstmt.setString(1, productGroupID);
//		ResultSet rs = null;
//
//		try {
//			pstmt = connection.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			Product item = null;
//
//			while (rs.next()) {
//				item = new Product();
//				item.setProductID(rs.getString("ProductID"));				
//
//				productIDList.add(item);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConnection(connection, pstmt, rs);
//		}
//		return productIDList;
//	}

	public String editProduct(String productID, String size, String price, String quantity, String image) {
		Connection connection = getConnection();

		String sql = "UPDATE Product1 SET Size = ?, Price = ?, Quantity = ?, Image = ?  WHERE ProductID = ?";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, size);
			pstmt.setString(2, price);
			pstmt.setString(3, quantity);
			pstmt.setString(4, image);
			pstmt.setString(5, productID);

			int x = pstmt.executeUpdate();
			System.out.println("Đã update số record trong Product: " + x);

		} catch (SQLException e) {

			e.printStackTrace();

			return "Duplicate ID Error";

		} finally {
			closeConnection(connection, pstmt, null);
		}

		return "No Error";
	}

	public void deleteProduct(String productID) {
		Connection connection = getConnection();

		String sql = "UPDATE Product1 SET isDelete = 'false' WHERE ProductID = ?";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, productID);

			int x = pstmt.executeUpdate();
			System.out.println("Đã delete số record trong Product: " + x);

		} catch (SQLException e) {

			e.printStackTrace();


		} finally {
			closeConnection(connection, pstmt, null);
		}

		
	}
	
	public void deleteProduct1(String productGroupID) {
		Connection connection = getConnection();

		String sql = "UPDATE Product1 SET isDelete = 'false' WHERE ProductGroupID = ?";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, productGroupID);

			int x = pstmt.executeUpdate();
			System.out.println("Đã delete số record trong Product: " + x);

		} catch (SQLException e) {

			e.printStackTrace();


		} finally {
			closeConnection(connection, pstmt, null);
		}

		
	}

	public String deleteProductGroup(String productGroupID) {
		Connection connection = getConnection();

		String sql = "UPDATE ProductGroup1 SET isDelete = 'false' WHERE ProductGroupID = ?";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, productGroupID);

			int x = pstmt.executeUpdate();
			System.out.println("Đã delete số record trong ProductGroup: " + x);

		} catch (SQLException e) {

			e.printStackTrace();


		} finally {
			closeConnection(connection, pstmt, null);
		}

		return "No Error";
	}

}
