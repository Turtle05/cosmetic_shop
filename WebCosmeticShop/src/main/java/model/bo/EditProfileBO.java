package model.bo;

import common.ValidateCommon;
import model.dao.EditProfileDAO;

public class EditProfileBO {
	EditProfileDAO editProfileDAO = new EditProfileDAO();

	public String editProfile( String fullName,
			String address, String phone, String email) {
		
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(fullName, address, phone, email);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}
		if (!"No Error".equals(ValidateCommon.validatePhoneNumber(phone))) {

			return "Phone Error";

		}
		return editProfileDAO.editProfile( fullName,  address, phone, email);
	}

	public String editProfileImage(String username, String img) {
		
		return editProfileDAO.editProfileImage(username, img);
	}
	
	}

	


