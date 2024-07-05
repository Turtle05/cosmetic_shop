package model.bo;

import common.ValidateCommon;
import model.dao.ChangePasswordDAO;

public class ChangePasswordBO {
	ChangePasswordDAO changePasswordDAO = new ChangePasswordDAO();
	public String changePassword(String customerID, String pass, String newpassword, String renewpassword) {
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(pass, newpassword, renewpassword);
		String password = changePasswordDAO.getPass(customerID);
		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		} 
		
		else if(!password.equals(pass)) {
			
			return "None";
			
		} else if(!"No Error".equals(ValidateCommon.validatePassword(newpassword))) {
			return "Password Error";
		}
		

		else if (!newpassword.equals(renewpassword)) {

				return "Renewpassword Error";
			}

		


		return changePasswordDAO.changePassword(customerID, newpassword);
	}

}
