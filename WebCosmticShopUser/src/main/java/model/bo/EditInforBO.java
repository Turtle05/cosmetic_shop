package model.bo;

import common.ValidateCommon;
import model.dao.EditInforDAO;

public class EditInforBO {
	
	EditInforDAO editInforDAO = new EditInforDAO();
	public String editInfor(String customerID, String fullName, String phone, String address) {

		if (!"No Error".equals(ValidateCommon.checkRequiredFieldsTest(fullName, phone, address))) {
			return "Null Error";
		}
		
		String phoneCheck = ValidateCommon.validatePhoneNumber(phone);
		if (!"No Error".equals(phoneCheck)) {

			return "Phone Error";

		}
		
		return editInforDAO.editInfor( customerID,  fullName,  phone,  address);
	}


}
