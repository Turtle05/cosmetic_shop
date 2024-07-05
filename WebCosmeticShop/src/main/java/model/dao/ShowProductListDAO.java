package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.ProductDTO;

public class ShowProductListDAO extends BaseDAO {
	final float ROWINPAGE = (float) 5.0;
	final int ROWINPAGEINT =  5;

	public ArrayList<ProductDTO> getProductList() {
		ArrayList<ProductDTO> returnedList = new ArrayList<ProductDTO>();

		Connection connection = getConnection();
//		String sql = "SELECT \r\n"
//				+ "    pg.ProductGroupID PGID, pg.ProductGroupName PGNAME,   b.BrandName BRNAME, c.CategoryName CATNAME, p.Image IMG\r\n"
//				+ "FROM \r\n"
//				+ "    productgroup1 pg\r\n"
//				+ "LEFT JOIN \r\n"
//				+ "    (SELECT \r\n"
//				+ "         p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size\r\n"
//				+ "     FROM \r\n"
//				+ "         product1 p1\r\n"
//				+ "     JOIN \r\n"
//				+ "         (SELECT \r\n"
//				+ "              ProductGroupID, MAX(Size) AS MaxSize\r\n"
//				+ "          FROM \r\n"
//				+ "              product1\r\n"
//				+ "          GROUP BY \r\n"
//				+ "              ProductGroupID) p2\r\n"
//				+ "     ON \r\n"
//				+ "         p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p\r\n"
//				+ "ON \r\n"
//				+ "    pg.ProductGroupID = p.ProductGroupID\r\n"
//				+ "LEFT JOIN \r\n"
//				+ "    brand1 b\r\n"
//				+ "ON \r\n"
//				+ "    pg.BrandID = b.BrandID\r\n"
//				+ "LEFT JOIN \r\n"
//				+ "    category1 c\r\n"
//				+ "ON \r\n"
//				+ "    pg.CategoryID = c.CategoryID;\r\n"
//				+ "";
		
		String sql ="SELECT pg.ProductGroupID AS PGID, pg.ProductGroupName AS PGNAME,p.Price Price, b.BrandName AS BRNAME, c.CategoryName AS CATNAME, p.Image AS IMG \r\n"
				+ "                     FROM productgroup1 pg \r\n"
				+ "                     LEFT JOIN (SELECT p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size FROM product1 p1 \r\n"
				+ "                     JOIN (SELECT ProductGroupID, MAX(Size) AS MaxSize FROM product1 GROUP BY ProductGroupID) p2 \r\n"
				+ "                     ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p\r\n"
				+ "                     ON pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "                     LEFT JOIN brand1 b ON pg.BrandID = b.BrandID \r\n"
				+ "                     LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID WHERE pg.isDelete ='true'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ProductDTO item = null;

			while (rs.next()) {
				item = new ProductDTO();
				item.setProductGroupID(rs.getString("PGID"));
				item.setProductGroupName(rs.getString("PGNAME"));
				item.setCategoryName(rs.getString("CATNAME"));
				item.setBrandName(rs.getString("BRNAME"));
				item.setImage(rs.getString("IMG"));

				returnedList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public int getTotalPageNumber() {
		Connection connection = getConnection();

		String sql = "SELECT count(ProductGroupID) as tongsodong FROM ProductGroup1 WHERE isDelete='true'";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		int totalPageNumber = 0;

		try {

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				totalPageNumber = rs.getInt("tongsodong");

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}

		return (int) Math.ceil(totalPageNumber / ROWINPAGE);
	}
	
	
	
	
	
	

	public ArrayList<ProductDTO> getProductList(int pageNumber) {
		ArrayList<ProductDTO> tempList = new ArrayList<ProductDTO>();

		ArrayList<ProductDTO> returnedList = new ArrayList<ProductDTO>();

		int itemNumber = 0;

		Connection connection = getConnection();

		String sql = "SELECT \r\n"
				+ "    pg.ProductGroupID PGID, pg.ProductGroupName PGNAME,   b.BrandName BRNAME, c.CategoryName CATNAME, p.Image IMG\r\n"
				+ "FROM \r\n"
				+ "    productgroup1 pg\r\n"
				+ "LEFT JOIN \r\n"
				+ "    (SELECT \r\n"
				+ "         p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size\r\n"
				+ "     FROM \r\n"
				+ "         product1 p1\r\n"
				+ "     JOIN \r\n"
				+ "         (SELECT \r\n"
				+ "              ProductGroupID, MAX(Size) AS MaxSize\r\n"
				+ "          FROM \r\n"
				+ "              product1\r\n"
				+ "          GROUP BY \r\n"
				+ "              ProductGroupID) p2\r\n"
				+ "     ON \r\n"
				+ "         p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p\r\n"
				+ "ON \r\n"
				+ "    pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "LEFT JOIN \r\n"
				+ "    brand1 b\r\n"
				+ "ON \r\n"
				+ "    pg.BrandID = b.BrandID\r\n"
				+ "LEFT JOIN \r\n"
				+ "    category1 c\r\n"
				+ "ON \r\n"
				+ "    pg.CategoryID = c.CategoryID WHERE pg.isDelete ='true';\r\n"
				+ "";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ProductDTO item = null;

			while (rs.next() && itemNumber < pageNumber * ROWINPAGEINT) {
				itemNumber++;

				item = new ProductDTO();

				item.setProductGroupID(rs.getString("PGID"));
				item.setProductGroupName(rs.getString("PGNAME"));
				item.setCategoryName(rs.getString("CATNAME"));
				item.setBrandName(rs.getString("BRNAME"));
				item.setImage(rs.getString("IMG"));

				tempList.add(item);

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}

		// Ở đây đang giả định là mỗi trang sẽ có 20 dòng.
		// Tính toán số trang:

		int pageQuantity = (int) Math.ceil(tempList.size() / ROWINPAGE);

		if (pageNumber > pageQuantity || pageNumber <= 0) {

			return returnedList; // Trả về danh sách rỗng, vì pageNumber không hợp lệ

		} else {

			for (int i = (pageNumber - 1) * ROWINPAGEINT; (i < pageNumber * ROWINPAGEINT) && (i < tempList.size()); i++) {

				returnedList.add(tempList.get(i));

			}

		}

		return returnedList;
	}

}
