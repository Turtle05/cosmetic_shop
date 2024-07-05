package model.bo;

import model.dao.DeleteCartDAO;

public class DeleteCartBO {

	DeleteCartDAO deleteCartDAO = new DeleteCartDAO();
	public String deleteCart(String customerID, String productID) {
		return deleteCartDAO.deleteCart(customerID, productID);
	}

}
