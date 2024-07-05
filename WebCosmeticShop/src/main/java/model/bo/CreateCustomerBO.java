package model.bo;

import java.util.ArrayList;

import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateCustomerDAO;
import model.dao.ShowCustomerListDAO;
import model.bean.Customer;

public class CreateCustomerBO {
	CreateCustomerDAO createCustomerDAO = new CreateCustomerDAO();
	public String createCustomer(String customerName, String address, String phone,
			String email, String password, String confirmpassword) {
		
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(customerName,email, password, address, phone, password, confirmpassword);

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
        
        ShowCustomerListDAO showCustomerListDAO = new ShowCustomerListDAO();
        ArrayList<Customer> listUsername = showCustomerListDAO.getCustomerList();
        for(Customer c: listUsername) {
        	if(email.equals(c.getEmail())) {
        		return "Double Username Error";
        	}	
        	System.out.println("email : "+ c.getEmail());
        }
        
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			String lastestCustomerID = createCustomerDAO.getLastestCustomerID();
			System.out.println("mã danh mục =" + lastestCustomerID);


			if (lastestCustomerID == null) {
				lastestCustomerID = "KH0001";
			} else {
				long orderNumber = Long.valueOf(lastestCustomerID.substring(2, 6));
				 ++orderNumber;
				 lastestCustomerID = "KH" + StringCommon.convertNumberToString(orderNumber, 4);
			}

			String returnedMessage = createCustomerDAO.createCustomer(lastestCustomerID, customerName, address, phone, email, password);

			System.out.println("Lần " + i + " --- lastestMaHH --- " + lastestCustomerID + " --- returnedMessage --- " + returnedMessage);
			
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
