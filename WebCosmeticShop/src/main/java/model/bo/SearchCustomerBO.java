package model.bo;

import java.util.ArrayList;

import model.bean.Customer;
import model.dao.SearchCustomerDAO;

public class SearchCustomerBO {
	SearchCustomerDAO searchCustomerDAO = new SearchCustomerDAO();
	public ArrayList<Customer> getCustomerList(String searchText) {
		return searchCustomerDAO.getProductList(searchText);
	}

}
