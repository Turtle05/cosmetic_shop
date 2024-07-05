package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CategoryGroup;
import model.dto.ProductDTO;

public class ShowProductListDAO extends BaseDAO {
	final float ROWINPAGE = (float) 8.0;
	final int ROWINPAGEINT =  8;

    public ArrayList<ProductDTO> getProductList(int pageNumber) {
    	
		ArrayList<ProductDTO> tempList = new ArrayList<ProductDTO>();
        ArrayList<ProductDTO> returnedList = new ArrayList<>();
        
        int itemNumber = 0;

        Connection connection = getConnection();
        String sql = "SELECT pg.ProductGroupID AS PGID, pg.ProductGroupName AS PGNAME, p.ProductID ProductID, p.Price Price, b.BrandName AS BRNAME, c.CategoryName AS CATNAME, p.Image AS IMG " +
                     "FROM productgroup1 pg " +
                     "LEFT JOIN (SELECT p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size FROM product1 p1 " +
                     "JOIN (SELECT ProductGroupID, MAX(Size) AS MaxSize FROM product1 GROUP BY ProductGroupID) p2 " +
                     "ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p " +
                     "ON pg.ProductGroupID = p.ProductGroupID " +
                     "LEFT JOIN brand1 b ON pg.BrandID = b.BrandID " +
                     "LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID WHERE pg.isDelete = 'true';";
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
                item.setPrice(rs.getFloat("Price"));
                item.setProductID(rs.getString("ProductID"));
                

                tempList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Log error message or handle exception as needed
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

	public ArrayList<ProductDTO> getNewestProduct() {
		ArrayList<ProductDTO> returnedList = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT TOP 5 pg.ProductGroupID AS PGID, \r\n"
        		+ "            pg.ProductGroupName AS PGNAME, \r\n"
        		+ "            p.Price AS Price, \r\n"
        		+ "            p.ProductID AS ProductID, \r\n"
        		+ "            b.BrandName AS BRNAME, \r\n"
        		+ "            c.CategoryName AS CATNAME, \r\n"
        		+ "            p.Image AS IMG \r\n"
        		+ "FROM productgroup1 pg  \r\n"
        		+ "LEFT JOIN (\r\n"
        		+ "    SELECT p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size \r\n"
        		+ "    FROM product1 p1 \r\n"
        		+ "    JOIN (\r\n"
        		+ "        SELECT ProductGroupID, MAX(Size) AS MaxSize \r\n"
        		+ "        FROM product1 \r\n"
        		+ "        GROUP BY ProductGroupID\r\n"
        		+ "    ) p2 \r\n"
        		+ "    ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize\r\n"
        		+ ") p ON pg.ProductGroupID = p.ProductGroupID\r\n"
        		+ "LEFT JOIN brand1 b ON pg.BrandID = b.BrandID \r\n"
        		+ "LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID\r\n"
        		+ "where pg.isDelete='true'\r\n"
        		+ "ORDER BY pg.ProductGroupID DESC;";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductDTO item = new ProductDTO();
                item.setProductGroupID(rs.getString("PGID"));
                item.setProductID(rs.getString("ProductID"));
                item.setProductGroupName(rs.getString("PGNAME"));
                item.setCategoryName(rs.getString("CATNAME"));
                item.setBrandName(rs.getString("BRNAME"));
                item.setImage(rs.getString("IMG"));
                item.setPrice(rs.getFloat("Price"));
                

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

	public ArrayList<ProductDTO> getSalestProduct() {
		ArrayList<ProductDTO> returnedList = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "WITH SoldQuantityByProductGroup AS (\r\n"
        		+ "    SELECT \r\n"
        		+ "        pg.ProductGroupID,\r\n"
        		+ "        pg.ProductGroupName,\r\n"
        		+ "        SUM(od.Quantity) AS TotalSoldQuantity,\r\n"
        		+ "        p.ProductID,\r\n"
        		+ "        p.Image,\r\n"
        		+ "        p.Size,\r\n"
        		+ "        p.Price,\r\n"
        		+ "		c.CategoryName,\r\n"
        		+ "		b.BrandName,\r\n"
        		+ "        ROW_NUMBER() OVER(PARTITION BY pg.ProductGroupID ORDER BY p.Size DESC) AS RowNum\r\n"
        		+ "    FROM \r\n"
        		+ "        PRODUCTGROUP1 pg\r\n"
        		+ "    INNER JOIN \r\n"
        		+ "        PRODUCT1 p ON pg.ProductGroupID = p.ProductGroupID\r\n"
        		+ "    INNER JOIN \r\n"
        		+ "        ORDERDETAIL od ON p.ProductID = od.ProductID\r\n"
        		+ "    INNER JOIN \r\n"
        		+ "        [ORDER1] ord ON od.OrderID = ord.OrderID\r\n"
        		+ "	INNER JOIN \r\n"
        		+ "	Category1 c ON c.CategoryID = pg.CategoryID\r\n"
        		+ "	INNER JOIN \r\n"
        		+ "	Brand1 b ON b.BrandID = pg.BrandID\r\n"
        		+ "    WHERE \r\n"
        		+ "        pg.isDelete = 'true'\r\n"
        		+ "        AND ord.Status = 'xong'\r\n"
        		+ "    GROUP BY \r\n"
        		+ "        pg.ProductGroupID, \r\n"
        		+ "        pg.ProductGroupName, \r\n"
        		+ "        p.ProductID, \r\n"
        		+ "        p.Image, \r\n"
        		+ "        p.Size,\r\n"
        		+ "        p.Price,\r\n"
        		+ "		b.BrandName,\r\n"
        		+ "		c.CategoryName\r\n"
        		+ ")\r\n"
        		+ "SELECT TOP 5\r\n"
        		+ "    ProductGroupID,\r\n"
        		+ "    ProductGroupName,\r\n"
        		+ "    TotalSoldQuantity,\r\n"
        		+ "    ProductID,\r\n"
        		+ "    Image,\r\n"
        		+ "    Price,\r\n"
        		+ "    Size,\r\n"
        		+ "	BrandName,\r\n"
        		+ "	CategoryName\r\n"
        		+ "FROM \r\n"
        		+ "    SoldQuantityByProductGroup\r\n"
        		+ "WHERE \r\n"
        		+ "    RowNum = 1\r\n"
        		+ "ORDER BY \r\n"
        		+ "    TotalSoldQuantity DESC;\r\n"
        		+ "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductDTO item = new ProductDTO();
                item.setProductGroupID(rs.getString("ProductGroupID"));
                item.setProductID(rs.getString("ProductID"));
                item.setProductGroupName(rs.getString("ProductGroupName"));
                item.setCategoryName(rs.getString("CategoryName"));
                item.setBrandName(rs.getString("BrandName"));
                item.setImage(rs.getString("Image"));
                item.setPrice(rs.getFloat("Price"));
                

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

	public int getTotalPageNumber() {
		Connection connection = getConnection();

		String sql = "SELECT count(ProductGroupID) as tongsodong FROM ProductGroup1";

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

	public int getTotalPageNumberByCatGroup(String catGroupID) {
		Connection connection = getConnection();

		String sql = "SELECT count(ProductGroupID) as tongsodong FROM ProductGroup1\r\n"
				+ "INNER JOIN  Category1 ON ProductGroup1.CategoryID = Category1.CategoryID\r\n"
				+ "INNER JOIN  CategoryGroup1 ON CategoryGroup1.CategoryGroupID = Category1.CategoryGroupID\r\n"
				+ "WHERE Category1.CategoryGroupID = ?";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		int totalPageNumber = 0;

		try {

			pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1, catGroupID);
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

	public ArrayList<ProductDTO> getProductListByGatGroup(String productGroupID, int pageNumber) {
		ArrayList<ProductDTO> tempList = new ArrayList<ProductDTO>();
        ArrayList<ProductDTO> returnedList = new ArrayList<>();
        
        int itemNumber = 0;

        Connection connection = getConnection();
        String sql = "SELECT pg.ProductGroupID AS PGID, pg.ProductGroupName AS PGNAME, p.ProductID ProductID, p.Price Price, b.BrandName AS BRNAME, c.CategoryName AS CATNAME, p.Image AS IMG , cg.CategoryGroupID AS CatGroupID,  cg.CategoryGroupName AS CatGroupName\r\n"
        		+ "                     FROM productgroup1 pg \r\n"
        		+ "                     LEFT JOIN (SELECT p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size FROM product1 p1 \r\n"
        		+ "                     JOIN (SELECT ProductGroupID, MAX(Size) AS MaxSize FROM product1 GROUP BY ProductGroupID) p2 \r\n"
        		+ "                     ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p \r\n"
        		+ "                     ON pg.ProductGroupID = p.ProductGroupID\r\n"
        		+ "                     LEFT JOIN brand1 b ON pg.BrandID = b.BrandID \r\n"
        		+ "                     LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID\r\n"
        		+ "					 LEFT JOIN CategoryGroup1 cg ON cg.CategoryGroupID = c.CategoryGroupID\r\n"
        		+ "				WHERE cg.CategoryGroupID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, productGroupID);
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
                item.setPrice(rs.getFloat("Price"));
                item.setProductID(rs.getString("ProductID"));
                

                tempList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Log error message or handle exception as needed
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

	public int getTotalPageNumberByCat(String catID) {
		Connection connection = getConnection();

		String sql = "SELECT count(ProductGroupID) as tongsodong FROM ProductGroup1 WHERE CategoryID = ?";

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		int totalPageNumber = 0;

		try {

			pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1, catID);
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

	public ArrayList<ProductDTO> getProductByCat(String catID, int pageNumber) {
		ArrayList<ProductDTO> tempList = new ArrayList<ProductDTO>();
        ArrayList<ProductDTO> returnedList = new ArrayList<>();
        
        int itemNumber = 0;

        Connection connection = getConnection();
        String sql = "SELECT pg.ProductGroupID AS PGID, pg.ProductGroupName AS PGNAME, p.ProductID ProductID, p.Price Price, b.BrandName AS BRNAME, c.CategoryName AS CATNAME, p.Image AS IMG , cg.CategoryGroupID AS CatGroupID,  cg.CategoryGroupName AS CatGroupName\r\n"
        		+ "        		                    FROM productgroup1 pg \r\n"
        		+ "        		                     LEFT JOIN (SELECT p1.ProductID, p1.ProductGroupID, p1.Price, p1.Image, p1.Size FROM product1 p1 \r\n"
        		+ "        		                     JOIN (SELECT ProductGroupID, MAX(Size) AS MaxSize FROM product1 GROUP BY ProductGroupID) p2 \r\n"
        		+ "        		                    ON p1.ProductGroupID = p2.ProductGroupID AND p1.Size = p2.MaxSize) p \r\n"
        		+ "        		                     ON pg.ProductGroupID = p.ProductGroupID\r\n"
        		+ "        		                     LEFT JOIN brand1 b ON pg.BrandID = b.BrandID \r\n"
        		+ "        		                     LEFT JOIN category1 c ON pg.CategoryID = c.CategoryID\r\n"
        		+ "        							 LEFT JOIN CategoryGroup1 cg ON cg.CategoryGroupID = c.CategoryGroupID\r\n"
        		+ "        					WHERE c.CategoryID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, catID);
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
                item.setPrice(rs.getFloat("Price"));
                item.setProductID(rs.getString("ProductID"));
                

                tempList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Log error message or handle exception as needed
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
