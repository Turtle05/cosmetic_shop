package model.bo;

import common.StringCommon;
import model.dao.AddToCartDAO;

public class AddToCartBO {
	AddToCartDAO addToCartDAO = new AddToCartDAO();

	public String insertCart(String customerID, String productID, String quantity) {

		String returnedString = null;
		int quan = Integer.parseInt(quantity);

		String returnedMessage = addToCartDAO.insertCart(customerID, productID, quan);

		if ("Duplicate ID Error".equals(returnedMessage)) {
			int returnQuantity = addToCartDAO.getQuantityCart(customerID, productID);
			int newQuantity = quan + returnQuantity;
			returnedString = addToCartDAO.updateQuantityCart(customerID, productID, newQuantity);

		} else if ("No Error".equals(returnedMessage)) {
			return "No Error";
		}
		return returnedString;
	}

}
