package model.bo;

import java.util.ArrayList;

import model.dao.ShowDashBoardDAO;
import model.dto.OrderDTO;
import model.dto.ProductDTO;

public class ShowDashBoardBO {
	ShowDashBoardDAO showDashBoardDAO = new ShowDashBoardDAO();
	public String getSales() {
		return showDashBoardDAO.getSales();
		
	}

	public String getCustomer() {
		return showDashBoardDAO.getCustomer();
		
	}

	public String getTotal() {
		return showDashBoardDAO.getTotal();
	}

	public ArrayList<OrderDTO> getOrderList() {
		// TODO Auto-generated method stub
		return showDashBoardDAO.getOrderList();
	}

	public ArrayList<ProductDTO> getProductList() {
		// TODO Auto-generated method stub
		return showDashBoardDAO.getProductList();
	}

}
