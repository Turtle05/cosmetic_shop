package model.bo;

import model.dao.EnableDAO;

public class EnableBO {
	EnableDAO  enableDAO = new EnableDAO();
	public void updateEnable(String customerID, String enable) {
		enableDAO.updateEnable(customerID, enable);
		
	}

}
