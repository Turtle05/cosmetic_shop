package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.ProductDTO;

import common.ValidateCommon;

public class SearchProductDAO extends BaseDAO {
	final float ROWINPAGE = (float) 5.0;
	final String ROWINPAGE_STRING =  "5";
	
	public int getTotalPageNumber(String searchText) {

		Connection connection = getConnection();

		String sql = "WITH product_info AS (\r\n"
				+ "SELECT   pg.ProductGroupID AS PGID,   pg.ProductGroupName AS PGNAME,   p.Price AS Price,    b.BrandName AS BRNAME,    c.CategoryName AS CATNAME,    p.Image AS IMG   FROM productgroup1 pg \r\n"
				+ "    LEFT JOIN (  SELECT    p1.ProductID,     p1.ProductGroupID,    p1.Price,     p1.Image,   p1.Size  FROM product1 p1 \r\n"
				+ "        JOIN (   SELECT     ProductGroupID,    MAX(Size) AS MaxSize    FROM product1    GROUP BY ProductGroupID   ) p2 ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize  ) p ON pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "    LEFT JOIN brand1 b ON pg.BrandID = b.BrandID \r\n"
				+ "    LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID)\r\n"
				+ "SELECT COUNT(PGID) as tongsodong\r\n"
				+ "FROM product_info\r\n"
				+ "WHERE PGID LIKE ? OR PGNAME LIKE ? OR BRNAME LIKE ? OR CATNAME LIKE ?";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		int totalPageNumber = 0;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, "%" + searchText + "%");

			pstmt.setString(2, "%" + searchText + "%");

			pstmt.setString(3, "%" + searchText + "%");

			pstmt.setString(4, "%" + searchText + "%");


			rs = pstmt.executeQuery();

			if (rs.next()) {

				totalPageNumber = rs.getInt("tongsodong");

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			closeConnection(connection, pstmt, rs);

		}

		return (int) Math.ceil(totalPageNumber / ROWINPAGE);

	}
	
	
	
	
	
	
	
	public ArrayList<ProductDTO> getProductList(String searchText, int pageNumber) {

		ArrayList<ProductDTO> returnedList = new ArrayList<ProductDTO>();

		Connection connection = getConnection();

		String sql = "WITH product_info AS (\r\n"
				+ "    SELECT \r\n"
				+ "        pg.ProductGroupID AS PGID, \r\n"
				+ "        pg.ProductGroupName AS PGNAME, \r\n"
				+ "        p.ProductID, \r\n"
				+ "        p.Price, \r\n"
				+ "        b.BrandName AS BRNAME, \r\n"
				+ "        c.CategoryName AS CATNAME, \r\n"
				+ "        p.Image AS IMG\r\n"
				+ "    FROM productgroup1 pg\r\n"
				+ "    LEFT JOIN (\r\n"
				+ "        SELECT \r\n"
				+ "            p1.ProductID, \r\n"
				+ "            p1.ProductGroupID, \r\n"
				+ "            p1.Price, \r\n"
				+ "            p1.Image, \r\n"
				+ "            p1.Size\r\n"
				+ "        FROM product1 p1\r\n"
				+ "        JOIN (\r\n"
				+ "            SELECT \r\n"
				+ "                ProductGroupID, \r\n"
				+ "                MAX(Size) AS MaxSize \r\n"
				+ "            FROM product1 \r\n"
				+ "            GROUP BY ProductGroupID\r\n"
				+ "        ) p2 \r\n"
				+ "        ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize\r\n"
				+ "    ) p \r\n"
				+ "    ON pg.ProductGroupID = p.ProductGroupID\r\n"
				+ "    LEFT JOIN brand1 b \r\n"
				+ "    ON pg.BrandID = b.BrandID\r\n"
				+ "    LEFT JOIN category1 c \r\n"
				+ "    ON pg.CategoryID = c.CategoryID\r\n"
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    tempTable.* \r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY PGID) AS RowNum, \r\n"
				+ "        PGID, \r\n"
				+ "        PGNAME, \r\n"
				+ "        ProductID, \r\n"
				+ "        Price, \r\n"
				+ "        BRNAME, \r\n"
				+ "        CATNAME, \r\n"
				+ "        IMG\r\n"
				+ "    FROM \r\n"
				+ "        product_info \r\n"
				+ "    WHERE \r\n"
				+ "        PGID LIKE ? OR PGNAME LIKE ? OR BRNAME LIKE ? OR CATNAME LIKE ?\r\n"
				+ ") AS tempTable\r\n"
				+ "WHERE \r\n"
				+ "    RowNum > (? * (? - 1)) AND RowNum <= (? * (? - 1)) + ?\r\n"
				+ "ORDER BY \r\n"
				+ "    PGID; \r\n"

				+ "";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, "%" + searchText + "%");

			pstmt.setString(2, "%" + searchText + "%");

			pstmt.setString(3, "%" + searchText + "%");

			pstmt.setString(4, "%" + searchText + "%");

			pstmt.setString(5, ROWINPAGE_STRING);

			pstmt.setString(6, String.valueOf(pageNumber));

			pstmt.setString(7, ROWINPAGE_STRING);

			pstmt.setString(8, String.valueOf(pageNumber));

			pstmt.setString(9, ROWINPAGE_STRING);

			rs = pstmt.executeQuery();

			ProductDTO item = null;

			while (rs.next()) {

				item = new ProductDTO();

				item.setProductGroupID(rs.getString("PGID"));
                item.setProductGroupName(rs.getString("PGNAME"));
                item.setCategoryName(rs.getString("CATNAME"));
                item.setBrandName(rs.getString("BRNAME"));
                item.setImage(rs.getString("IMG"));
                item.setPrice(rs.getFloat("Price"));
                item.setProductID(rs.getString("ProductID"));

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
