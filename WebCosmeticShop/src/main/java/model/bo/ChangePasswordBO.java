package model.bo;

import common.ValidateCommon;
import model.dao.ChangePasswordDAO;

public class ChangePasswordBO {
	ChangePasswordDAO changePasswordDAO = new ChangePasswordDAO();

	public String changePassword(String username, String password, String pass, String newpassword,
			String renewpassword) {

		String tempValidate = ValidateCommon.checkRequiredFieldsTest(pass, newpassword, renewpassword);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		} else {

			if (!password.equals(pass)) {
				return "Pass Error";

			}
			
			if (!"No Error".equals(ValidateCommon.validatePassword(newpassword))) {

				return "Password Error";

			}

			if (!newpassword.equals(renewpassword)) {

				return "Renewpassword Error";
			}

		}


		return changePasswordDAO.changePassword(username, newpassword);

	}
}
