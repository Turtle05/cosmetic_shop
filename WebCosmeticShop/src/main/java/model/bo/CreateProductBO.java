package model.bo;

import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateProductDAO;

public class CreateProductBO {
	CreateProductDAO createProductDAO = new CreateProductDAO();

	public String createProduct(String nameProduct, String catID, String des,String brandID, String[] dungtich, String[] price,String[] quantity, String[] filenames) {

		String returnedString = null;
		String checkProductGroup = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(nameProduct, des);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}

		for (int i = 0; i < dungtich.length; i++) {
			String temp = ValidateCommon.checkRequiredFieldsTest(dungtich[i], price[i], filenames[i], quantity[i]);
			if (!"No Error".equals(temp)) {

				return "Product Null";

			}
		}
		for (int i = 0; i < dungtich.length; i++) {
		if (!"No Error".equals(ValidateCommon.validateIntegerString(price[i]))) {

			return "Price Error";

		}
		}
		
		for (int i = 0; i < dungtich.length; i++) {
			if (!"No Error".equals(ValidateCommon.validateIntegerString(quantity[i]))) {

				return "Quantity Error";

			}
			}
		

//		String lastestProductGroupID = createProductDAO.getLastestProductGroupID();
		String lastestProductGroupID = null;
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			lastestProductGroupID = createProductDAO.getLastestProductGroupID();
			System.out.println("mã danh mục =" + lastestProductGroupID);

			if (lastestProductGroupID == null) {
				lastestProductGroupID = "NS0001";
			} else {
				long orderNumber = Long.valueOf(lastestProductGroupID.substring(2, 6));
				++orderNumber;
				lastestProductGroupID = "NS" + StringCommon.convertNumberToString(orderNumber, 4);
			}

			String returnedMessage = createProductDAO.createProductGroup(lastestProductGroupID, nameProduct, catID, des, brandID);

			System.out.println("Lần " + i + " --- lastestMaNhomSp--- " + lastestProductGroupID
					+ " --- returnedMessage --- " + returnedMessage);

			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				checkProductGroup = "No Error";
				break;

			}

		}
		
		

		if ("No Error".equals(checkProductGroup)) {
			for (int i = 0; i < dungtich.length; i++) {
				for (int j = 1; j <= 10; j++) { // Lặp tối đa 10 lần:

					String lastestProductID = createProductDAO.getLastestProductID();
					System.out.println("mã sản phẩm =" + lastestProductID);

					if (lastestProductID == null) {
						lastestProductID = "SP0001";
					} else {
						long orderNumber = Long.valueOf(lastestProductID.substring(2, 6));
						++orderNumber;
						lastestProductID = "SP" + StringCommon.convertNumberToString(orderNumber, 4);
					}

					String returnedMessage = createProductDAO.createProduct(lastestProductID, dungtich[i],
							price[i], quantity[i] ,filenames[i], lastestProductGroupID);

					System.out.println("Lần " + j + " --- lastestMaSp--- " + lastestProductID
							+ " --- returnedMessage --- " + returnedMessage);

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
		return returnedString;
	}

}
