package model.bo;

import java.util.ArrayList;

import model.bean.Customer;
import model.dao.ShowCustomerListDAO;

public class ShowCustomerListBO {
	ShowCustomerListDAO showCustomerListDAO = new ShowCustomerListDAO();
	public ArrayList<Customer> getCustomerList() {
		
		return showCustomerListDAO.getCustomerList();
	}
	
}
