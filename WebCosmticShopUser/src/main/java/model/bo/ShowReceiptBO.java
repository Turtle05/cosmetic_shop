package model.bo;

import java.util.ArrayList;

import model.dao.CreateOrderDAO;
import model.dao.ShowReceiptDAO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class ShowReceiptBO {
	ShowReceiptDAO  showReceiptDAO = new ShowReceiptDAO();
	CreateOrderDAO createOrderDAO = new CreateOrderDAO();
	
	public OrderDTO getOrrder(String orderID) {
	
		return showReceiptDAO.getOrder(orderID);
	}
	public ArrayList<OrderDetailDTO> getOrderDetail(String orderID) {
		return createOrderDAO.getOrderDetail(orderID);
	}
	

}
