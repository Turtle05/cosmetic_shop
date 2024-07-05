package model.bo;

import common.ValidateCommon;
import model.bean.Employee;
import model.bean.User;
import model.dao.EditEmployeeDAO;

public class EditEmployeeBO {
	EditEmployeeDAO editEmployeeDAO = new EditEmployeeDAO();
	
	public User getEmployee(String employeeID) {
		return editEmployeeDAO.getEmployee(employeeID);
	}
	
	public String editEmployee(String employeeID, String fullName,  String address,
			String phone,String password, String img) {
		
			String returnedString = null;
			String tempValidate = ValidateCommon.checkRequiredFieldsTest(fullName, password,address, phone, password );

			if (!"No Error".equals(tempValidate)) {

				return tempValidate;

			}
			

			returnedString = editEmployeeDAO.editEmployee(employeeID, fullName, address, phone,password, img);
			return returnedString;
	}

	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return editEmployeeDAO.deleteEmployee(id);
	}

	public String enableUser(String id, String e) {
		// TODO Auto-generated method stub
		return editEmployeeDAO.enableUser(id,e);
	}

	public String enableCustomer(String id, String e) {
		// TODO Auto-generated method stub
		return editEmployeeDAO.enableCustomer(id, e);
	}

	public String deleteCustomer(String id) {
		String returned = editEmployeeDAO.checkCus(id);
		if (returned == null || returned.isEmpty()) {
			editEmployeeDAO.deleteCustomer(id);
		} else {
		    return "Error";
		}
		return "No Error";
	}

}
