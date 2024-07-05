package model.bo;

import common.ValidateCommon;
import model.dao.EditBrandDAO;

public class EditBrandBO {
	EditBrandDAO  editBrandDAO = new EditBrandDAO();
	public String editBrand(String brandID, String brandName, String nation, String img) {
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(brandName, nation);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}

		returnedString = editBrandDAO.editBrand(brandID, brandName, nation, img);
		return returnedString;
	}
	public String deleteBrand(String id) {
		String returned = editBrandDAO.checkBrand(id);
		if (returned == null || returned.isEmpty()) {
			editBrandDAO.deleteBrand(id);
		} else {
			
		    System.out.println("Brand found: " + returned);
		    return "Error";
		}
		return "No Error";
	}

}
