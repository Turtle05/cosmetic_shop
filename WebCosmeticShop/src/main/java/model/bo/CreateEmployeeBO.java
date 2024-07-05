package model.bo;

import java.util.ArrayList;

import common.StringCommon;
import common.ValidateCommon;
import model.bean.Customer;
import model.bean.User;
import model.dao.CreateEmployeeDAO;
import model.dao.ShowEmployeeListDAO;

public class CreateEmployeeBO {
	CreateEmployeeDAO createEmployeeDAO = new CreateEmployeeDAO();

	public String createEmployee(String fullName, String address, String phone,
			String email, String password,String confirmpassword, String image) {

		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(fullName, address, phone, email, password, confirmpassword);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}
		
		if (!"No Error".equals(ValidateCommon.validateEmail(email))) {

			return "Email Error";

		}
		
		if (!"No Error".equals(ValidateCommon.validatePhoneNumber(phone))) {

			return "Phone Error";

		}
		if(!password.equals(confirmpassword)) {
			return "Pass Error";
		}
		
		if (!"No Error".equals(ValidateCommon.validatePassword(password))) {

			return "Password Error";

		}
		
		
		
		

		ShowEmployeeListDAO ShowEmployeeListDAO = new ShowEmployeeListDAO();
		ArrayList<User> listUsername = ShowEmployeeListDAO.getEmployeeList();
		for (User e : listUsername) {
			if (email.equals(e.getEmail())) {
				return "Double Username Error";
			}
			System.out.println("name : " + e.getEmail());
		}

		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			String lastestUserID = createEmployeeDAO.getLastestEmpoyeeID();
			System.out.println("mã danh mục =" + lastestUserID);

			
			  if (lastestUserID == null) { 
				  lastestUserID = "Nv0001"; 
			  } else { 
				  long orderNumber = Long.valueOf(lastestUserID.substring(2, 6)); ++orderNumber;
				  lastestUserID = "Nv" + StringCommon.convertNumberToString(orderNumber,4); }
			 

			String returnedMessage = createEmployeeDAO.createEmployee(lastestUserID, fullName,
					address, phone, email, password, image);

			System.out.println("Lần " + i + " --- lastestMaNV--- " + lastestUserID + " --- returnedMessage --- "
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
