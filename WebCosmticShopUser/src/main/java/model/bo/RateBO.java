package model.bo;

import common.StringCommon;
import model.dao.RateDAO;

public class RateBO {
	RateDAO  rateDAO = new RateDAO();
	
	public void createRate(String customerID, String productGroupID, String star, String comment) {
	
		
		String returnedString = null;
		String id = null;
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			id = rateDAO.getId();
			System.out.println("mã đơn hàng =" + id);

			if (id == null) {
				id = "NX0001";
			} else {
				long orderNumber = Long.valueOf(id.substring(2, 6));
				++orderNumber;
				id = "NX" + StringCommon.convertNumberToString(orderNumber, 4);
			}

			String returnedMessage = rateDAO.createRate(customerID, productGroupID, star, comment, id);

			System.out.println("Lần " + i + " --- id--- " + id + " --- returnedMessage --- "
					+ returnedMessage);

			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				returnedString = "No Error";
				break;

			}

		}
	}

}
