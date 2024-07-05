package model.bo;

import java.util.ArrayList;

import model.bean.Order;
import model.dao.ShowOrderListDAO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class ShowOrderListBO {
	ShowOrderListDAO  showOrderListDAO = new ShowOrderListDAO();
	public ArrayList<OrderDTO> getOrderList() {
		return showOrderListDAO.getOrderList();

	}
	public  OrderDTO getInfor(String orderID) {
		return showOrderListDAO.getInfor(orderID);
	}
	public ArrayList<OrderDetailDTO> getOrderDetail(String orderID) {
		// TODO Auto-generated method stub
		return showOrderListDAO.getOrderDetail(orderID);
	}

}
