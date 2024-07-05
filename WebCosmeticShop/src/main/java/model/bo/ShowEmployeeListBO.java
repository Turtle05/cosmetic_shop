package model.bo;

import java.util.ArrayList;

import model.bean.User;
import model.dao.ShowEmployeeListDAO;

public class ShowEmployeeListBO {
	ShowEmployeeListDAO showEmployeeListDAO = new ShowEmployeeListDAO();
	public ArrayList<User> getEmployeeList() {
		// TODO Auto-generated method stub
		return showEmployeeListDAO.getEmployeeList();
	}

}
