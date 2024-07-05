package model.bo;

import java.util.ArrayList;

import common.StringCommon;
import common.ValidateCommon;
import model.bean.Customer;
import model.dao.CreateAccountDAO;


public class CreateAccountBO {
	CreateAccountDAO createAccountDAO = new CreateAccountDAO();

	public String createAccount(String username, String password,String confirmPassword,  String fullname) {
		String returnedString = null;
		
		String emailCheck = ValidateCommon.validateEmail(username);
		if (!"No Error".equals(emailCheck)) {

			return "Email Error";

		}
		
		if (!"No Error".equals(ValidateCommon.validatePassword(password))) {
			return "Password Error";
		}
		
		if (!password.equals(confirmPassword)) {
			return "Pass Error";
		}
		
		
		CreateAccountDAO createAccountDAO = new CreateAccountDAO();
        ArrayList<Customer> listEmail = createAccountDAO.getEmailList();
        for(Customer c: listEmail) {
        	if(username.equals(c.getEmail())) {
        		return "Double Email Error";
        	}	
        	System.out.println("email : "+ c.getEmail());
        }
		
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:
			
			String lastestCustomerID = createAccountDAO.getLastestCustomerID();
			System.out.println("mã khách hàng =" + lastestCustomerID);

			if (lastestCustomerID == null) {
				lastestCustomerID = "KH0001";
			} else {
				long orderNumber = Long.valueOf(lastestCustomerID.substring(2, 6));
				++orderNumber;
				lastestCustomerID = "KH" + StringCommon.convertNumberToString(orderNumber, 4);
			}

			String returnedMessage = createAccountDAO.insertAccount(lastestCustomerID, username, password, fullname);

			System.out.println("Lần " + i + " --- lastestMaKH --- " + lastestCustomerID + " --- returnedMessage --- "
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
