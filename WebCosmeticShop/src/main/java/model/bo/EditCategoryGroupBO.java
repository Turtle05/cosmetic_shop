package model.bo;

import common.ValidateCommon;
import model.bean.CategoryGroup;
import model.dao.EditCategoryGroupDAO;

public class EditCategoryGroupBO {
	EditCategoryGroupDAO editCategoryGroupDAO =new EditCategoryGroupDAO(); 
	public CategoryGroup getCatGroup(String catGroupID) {
		
		return editCategoryGroupDAO.getCatGroupInfor(catGroupID);
	}
	
	
	public String editCategoryGroup(String catGroupID, String catGroupName) {
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(catGroupID, catGroupName);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}

		returnedString = editCategoryGroupDAO.editCategoryGroup(catGroupID, catGroupName);
		return returnedString;
	}
	

}
