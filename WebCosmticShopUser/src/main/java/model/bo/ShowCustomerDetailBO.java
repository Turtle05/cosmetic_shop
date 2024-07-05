package model.bo;

import model.dao.ShowCustomerDetailDAO;
import model.dto.CustomerDTO;

public class ShowCustomerDetailBO {
	ShowCustomerDetailDAO showCustomerDetailDAO = new ShowCustomerDetailDAO();
	public CustomerDTO getCusDetail(String customerID) {
		// TODO Auto-generated method stub
		return showCustomerDetailDAO.getCusDetail(customerID);
	}

}
