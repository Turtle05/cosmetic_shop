package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CartDTO;

public class ShowCartDAO extends BaseDAO {

	public ArrayList<CartDTO> getCartList(String customerID) {
		ArrayList<CartDTO> returnedList = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT  c.Quantity Quantity, c.ProductID ProductID, p.Size Size,p.Price Price, p.Quantity SQuantity , p.Image Image, pg.ProductGroupName PGNAME FROM Cart2 c\r\n"
        		+ "        		INNER JOIN  Product1 p ON c.ProductID = p.ProductID\r\n"
        		+ "        		INNER JOIN ProductGroup1 pg ON p.ProductGroupID = pg.ProductGroupID\r\n"
        		+ "        		WHERE c.CustomerID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, customerID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	CartDTO item = new CartDTO();
                item.setQuantity(rs.getInt("Quantity"));
                item.setProductID(rs.getString("ProductID"));
                item.setSize(rs.getString("Size"));
                item.setSQuantity(rs.getInt("SQuantity"));
                item.setImage(rs.getString("Image"));
                item.setProductGroupName(rs.getString("PGNAME"));
                item.setPrice(rs.getDouble("Price"));
                

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
