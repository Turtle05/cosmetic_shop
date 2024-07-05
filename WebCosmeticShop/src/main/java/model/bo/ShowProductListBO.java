package model.bo;

import java.util.ArrayList;

import model.dao.ShowProductListDAO;
import model.dto.ProductDTO;

public class ShowProductListBO {
	ShowProductListDAO showProductListDAO = new ShowProductListDAO();
	public ArrayList<ProductDTO> getProductList() {
		return showProductListDAO.getProductList();
	}
	
	
	public int getTotalPageNumber() {
		return showProductListDAO.getTotalPageNumber();
	}


	public ArrayList<ProductDTO> getProductList(int pageNumber) {
		return showProductListDAO.getProductList(pageNumber);
	}

}
