package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditBrandDAO extends BaseDAO {

	public String editBrand(String brandID, String brandName, String nation, String img) {
		Connection connection = getConnection();

	    String sql = "UPDATE Brand1 SET BrandName = ?, Nation = ?, Image = ?  WHERE BrandID = ?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, brandName);
	            pstmt.setString(2, nation);
	            pstmt.setString(3, img);
	            pstmt.setString(4, brandID);

	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Brand: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
	}

	public String checkBrand(String id) {
		String returnedList = new String();

		Connection connection = getConnection();
		
		String sql ="Select ProductGroupID  from ProductGroup1 where brandID = ? and isDelete='true'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();



			while (rs.next()) {
				returnedList = rs.getString("ProductGroupID");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}
		return returnedList;
	}

	public String deleteBrand(String id) {
		Connection connection = getConnection();

	    String sql = "UPDATE Brand1 SET isDelete = 'false' WHERE brandID =?";

	    PreparedStatement pstmt = null;


	    try {

	            pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, id);


	            int x = pstmt.executeUpdate();
	            System.out.println("Đã update số record trong Brand: " + x);

	    } catch (SQLException e) {

	            e.printStackTrace();

	            return "Duplicate ID Error";

	    } finally {
	            closeConnection(connection, pstmt, null);
	    }

	    return "No Error";
		
	}

}
