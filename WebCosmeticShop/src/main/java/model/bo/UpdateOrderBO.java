package model.bo;

import model.dao.UpdateOrderDAO;

public class UpdateOrderBO {
	UpdateOrderDAO updateOrderDAO = new UpdateOrderDAO();
	public String updateOrder(String status, String orderID) {
	
		return updateOrderDAO.updateOrderDAO(status, orderID);
	}

}
