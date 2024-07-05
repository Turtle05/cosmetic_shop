package model.bo;

import java.util.ArrayList;

import model.dto.OrderDetailDTO;
import model.bean.Customer;
import model.dao.ShowInforDAO;
import model.dto.OrderDTO;

public class ShowInforBO {
	ShowInforDAO showInforDAO = new ShowInforDAO();
	public Customer getInfor(String customer) {
		return showInforDAO.getInfor(customer);
	}
	public ArrayList<OrderDTO> getOrderList(String customerID) {
		
			return showInforDAO.getOrderList(customerID);
	}
	public OrderDTO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return showInforDAO.getOrder(orderID);
	}
	public ArrayList<OrderDetailDTO>  getOrderDetail(String orderID) {
		return showInforDAO.getOrderDetail(orderID);
	}
}
	
