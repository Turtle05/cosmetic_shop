package model.bo;

import java.util.ArrayList;

import model.dao.SearchProductDAO;
import model.dto.ProductDTO;

public class SearchProductBO {


	SearchProductDAO searchProductDAO = new SearchProductDAO();
	
	public int getTotalPageNumber(String searchText) {
		
		return searchProductDAO.getTotalPageNumber(searchText);
	}

	public ArrayList<ProductDTO> getProductList(String searchText, int pageNumber) {
		return searchProductDAO.getProductList(searchText, pageNumber);
	}

}
