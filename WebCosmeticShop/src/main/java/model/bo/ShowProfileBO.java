package model.bo;



import model.bean.Employee;

import model.dao.ShowProfileDAO;

public class ShowProfileBO {
	ShowProfileDAO showProfileDAO = new ShowProfileDAO();
	public Employee getProfile(String username) {
		
		return showProfileDAO.getProfile(username);
	}

}
