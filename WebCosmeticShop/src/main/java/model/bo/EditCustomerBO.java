package model.bo;

import java.util.ArrayList;

import common.ValidateCommon;
import model.bean.Customer;
import model.dao.EditCustomerDAO;
import model.dao.ShowCustomerListDAO;

public class EditCustomerBO {
	EditCustomerDAO  editCustomerDAO = new EditCustomerDAO();
	
	public Customer getCustomer(String customerID) {
		return editCustomerDAO.getCustomer(customerID);
	}
	
	
	public String editCustomer(String customerID, String customerName, String gender, String birthday, String address,
			String phone, String email, String username, String password) {
		String returnedString = null;
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(customerName, gender, username, password);

		if (!"No Error".equals(tempValidate)) {

			return tempValidate;

		}
		
//		ShowCustomerListDAO showCustomerListDAO = new ShowCustomerListDAO();
//        ArrayList<Customer> listUsername = showCustomerListDAO.getCustomerList();
//        for(Customer c: listUsername) {
//        	if(username.equals(c.getUsername())) {
//        		return "Double Username Error";
//        	}	
//        	System.out.println("name : "+ c.getUsername());
//        }

		returnedString = editCustomerDAO.editCustomer(customerID, customerName, gender, birthday, address, phone, email, username, password);
		return returnedString;
	}
	
	}


