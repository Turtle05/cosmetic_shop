package model.bo;

import common.ValidateCommon;
import model.bean.Category;
import model.dao.EditCategoryDAO;
import model.dto.ProductDTO;

public class EditCategoryBO {
	
EditCategoryDAO editCategoryDAO = new EditCategoryDAO();

	public Category getCat(String catID) {
		
		return editCategoryDAO.getCat(catID);
	}
	
	public String editCategory(String categoryID, String catName, String catGroupID) {
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(categoryID, catName, catGroupID);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}

		returnedString = editCategoryDAO.editCategory(categoryID, catName, catGroupID);
		return returnedString;
	}

	public String deleteCategory(String id) {
		String returned = editCategoryDAO.checkCat(id);
		if (returned == null || returned.isEmpty()) {
		    editCategoryDAO.deleteCategory(id);
		} else {
			
		    System.out.println("Category found: " + returned);
		    return "Error";
		}
		return "No Error";

	}

}
