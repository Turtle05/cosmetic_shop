package model.bo;

import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateBrandDAO;

public class CreateBrandBO {
	CreateBrandDAO createBrandDAO = new CreateBrandDAO();

	public String insertBrand(String brandName, String nation, String img) {
		String returnedString = null;

		String tempValidate = ValidateCommon.checkRequiredFieldsTest(brandName, nation);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			String lastestBrandID = createBrandDAO.getLastestBrandID();
			System.out.println("mã thương hiệu =" + lastestBrandID);

			if (lastestBrandID == null) {
				lastestBrandID = "TH001";
			} else {
				long orderNumber = Long.valueOf(lastestBrandID.substring(2, 5));
				++orderNumber;
				lastestBrandID = "TH" + StringCommon.convertNumberToString(orderNumber, 3);
			}

			String returnedMessage = createBrandDAO.insertCatGroup(lastestBrandID, brandName, nation, img );

			System.out.println("Lần " + i + " --- lastestMaTh --- " + lastestBrandID + " --- returnedMessage --- "
					+ returnedMessage);

			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				returnedString = "No Error";
				break;

			}

		}
		return returnedString;
	}

}
