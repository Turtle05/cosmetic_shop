package model.bo;

import java.util.ArrayList;

import common.StringCommon;
import common.ValidateCommon;
import model.bean.Product;
import model.dao.CreateProductDAO;
import model.dao.EditProductDAO;
import model.dto.ProDTO;

public class EditProductBO {

	EditProductDAO editProductDAO = new EditProductDAO();

	public ProDTO getProductDetail(String productGroupID) {

		return editProductDAO.getProductDetail(productGroupID);
	}

	public ArrayList<Product> getProduct(String productGroupID) {

		return editProductDAO.getProduct(productGroupID);
	}

	public String eidtProduct(String productGroupID, String nameProduct, String brand, String cat, String des, String[] productID, String[] size, String[] price, String[] quantity, String[] img,
			String[] imgOrigin) {
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(nameProduct, des, brand, cat);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}

		for (int i = 0; i < size.length; i++) {
			String temp = ValidateCommon.checkRequiredFieldsTest(size[i], price[i], img[i], quantity[i]);
			if (!"No Error".equals(temp)) {

				return "Product Null";

			}
		}
		for (int i = 0; i < size.length; i++) {
		if (!"No Error".equals(ValidateCommon.validateIntegerString(price[i]))) {

			return "Price Error";

		}
		}
		
		for (int i = 0; i < size.length; i++) {
			if (!"No Error".equals(ValidateCommon.validateIntegerString(quantity[i]))) {

				return "Quantity Error";

			}
			}
		
		ArrayList<Product> productIDList = editProductDAO.getProduct(productGroupID);

		for (Product p : productIDList) {
			boolean isExist = false;
			for (int j = 0; j < productID.length; j++) {
				if (p.getProductID().equals(productID[j])) {
				
					isExist = true;
				}
			}
			if(isExist==false) {
				System.out.println("Xóa : " + p.getProductID());
				editProductDAO.deleteProduct(p.getProductID());
				
			}
		}

		String returnString1 = editProductDAO.editProductGroup(productGroupID, nameProduct, brand, cat, des);

		for (int i = 0; i < productID.length; i++) {
			if (productID[i] != null && !productID[i].isEmpty()) {
				String returnString2 = editProductDAO.editProduct(productID[i], size[i], price[i], quantity[i], img[i]);
			} else {
				CreateProductDAO createProductDAO = new CreateProductDAO();
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

					String returnedMessage = createProductDAO.createProduct(lastestProductID, size[i], price[i],
							quantity[i], img[i], productGroupID);

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

//		ArrayList<Product> productIDList = editProductDAO.getProduct(productGroupID);
//
//		for (Product p : productIDList) {
//			boolean isExist = false;
//			for (int j = 0; j < productID.length; j++) {
//				if (p.getProductID().equals(productID[j])) {
//				
//					isExist = true;
//				}
//			}
//			if(isExist==false) {
//				System.out.println("Xóa : " + p.getProductID());
//				editProductDAO.deleteProduct(p.getProductID());
//				
//			}
//		}

		return "No Error";
	}

	public String deleteProductGroup(String productGroupID) {
		
		 editProductDAO.deleteProduct1(productGroupID);
		 String returned = editProductDAO.deleteProductGroup(productGroupID);
		 
		 return returned;
	}

}
