package model.bo;

import java.util.ArrayList;

import model.dao.ShowCartDAO;
import model.dto.CartDTO;

public class ShowCartBO {
	ShowCartDAO  showCartDAO = new ShowCartDAO();
	public ArrayList<CartDTO> getCartList(String customerID) {
		
		return showCartDAO.getCartList(customerID);
	}

}
