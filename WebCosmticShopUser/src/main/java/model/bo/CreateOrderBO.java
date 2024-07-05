package model.bo;

import java.util.ArrayList;

import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateOrderDAO;
import model.dao.DeleteCartDAO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class CreateOrderBO {
	CreateOrderDAO createOrderDAO = new CreateOrderDAO();
	String orderIdReturn = null;

	public String insertOrder(String customerID, String fullname, String address, String phone, String email,
			String[] productID, String[] quantity, String[] price, String subTotal, String shipping, String grandTotal,
			String method, String statusOrder, String statusOrderDetail) {

		String returnedString = null;
		String checkInsertOrder = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(fullname, address, phone);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}
		
		if (!"No Error".equals(ValidateCommon.validatePhoneNumber(phone))) {

			return "Phone Error";

		}
		
		

//		String lastestProductGroupID = createProductDAO.getLastestProductGroupID();
		String lastestOrderID = null;
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			lastestOrderID = createOrderDAO.getLastestOrderID();
			System.out.println("mã đơn hàng =" + lastestOrderID);

			if (lastestOrderID == null) {
				lastestOrderID = "DH0001";
			} else {
				long orderNumber = Long.valueOf(lastestOrderID.substring(2, 6));
				++orderNumber;
				lastestOrderID = "DH" + StringCommon.convertNumberToString(orderNumber, 4);
			}

			String returnedMessage = createOrderDAO.insertOrder(customerID, fullname, address, phone, email, grandTotal,
					method, lastestOrderID, statusOrder);

			System.out.println("Lần " + i + " --- lastestOrderID--- " + lastestOrderID + " --- returnedMessage --- "
					+ returnedMessage);

			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				checkInsertOrder = "No Error";
				break;

			}

		}

		if ("No Error".equals(checkInsertOrder)) {
			for (int i = 0; i < productID.length; i++) {

				String returnedMessage = createOrderDAO.insertOrderDetail(productID[i], quantity[i], price[i],
						lastestOrderID, statusOrderDetail);

				if ("No Error".equals(returnedMessage)) {
					returnedString = "No Error";

				}
			}
			

		}
		
		orderIdReturn = lastestOrderID;
		return returnedString;
	}
	


	public OrderDTO showReview(String customerID) {
		return createOrderDAO.showReview(customerID);

	}

	public ArrayList<OrderDetailDTO> getOrderDetail(String customerID) {
		String OrderID  = createOrderDAO.getOrderID(customerID);
			return createOrderDAO.getOrderDetail(OrderID);
	}

	

	public void updateOrder(String orderID, String customerID) {
		
		String returned =  createOrderDAO.updateOrder(orderID);
		String returnMessage = createOrderDAO.updateOrderDetail(orderID);
		System.out.println("returnMessage updateDetail" + returnMessage);
		if("No Error".equals(returned)) {
			DeleteCartDAO deleteCartDAO = new DeleteCartDAO();
			deleteCartDAO.deleteCart(customerID);
		}
	}

	public void deleteOrder() {
		createOrderDAO.deleteOrderDetail();
		createOrderDAO.deleteOrder();
		
	}



	public String getOrderIDReturn() {
		
		return orderIdReturn;
	}
}
