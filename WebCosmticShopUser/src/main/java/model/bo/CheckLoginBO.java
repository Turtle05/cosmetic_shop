package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public int getAccountRole(String userName, String password) {
		return checkLoginDAO.getAccountRole(userName, password);
	}

	public String getCustomerID(String email) {
		return checkLoginDAO.getCustomerID(email);
	}

}
