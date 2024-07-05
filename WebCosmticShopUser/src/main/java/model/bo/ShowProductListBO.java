package model.bo;

import java.util.ArrayList;

import model.dao.ShowProductListDAO;
import model.dto.ProductDTO;

public class ShowProductListBO {
	ShowProductListDAO showProductListDAO = new ShowProductListDAO();
	public ArrayList<ProductDTO> getProductList(int pageNumber) {
		return showProductListDAO.getProductList(pageNumber);
	}
	
	ShowProductListDAO showNewestProductDAO = new ShowProductListDAO();
	public ArrayList<ProductDTO> getNewestProduct() {
		return showNewestProductDAO.getNewestProduct();
	}
	
	ShowProductListDAO showSalestProductDAO = new ShowProductListDAO();
	public ArrayList<ProductDTO> getSalestProduct() {
		
		return showSalestProductDAO.getSalestProduct();
	}
	public int getTotalPageNumber() {
		return showProductListDAO.getTotalPageNumber();
	}
	public int getTotalPageNumberByCatGroup(String catGroupID) {
		// TODO Auto-generated method stub
		return showProductListDAO.getTotalPageNumberByCatGroup(catGroupID);
	}
	public ArrayList<ProductDTO> getProductByGatGroup(String productGroupID, int pageNumber) {
		// TODO Auto-generated method stub
		return showSalestProductDAO.getProductListByGatGroup(productGroupID, pageNumber);
	}
	public ArrayList<ProductDTO> getProductByCat(String catID, int pageNumber) {
		// TODO Auto-generated method stub
		return showSalestProductDAO.getProductByCat(catID, pageNumber);
	}
	public int getTotalPageNumberByCat(String catID) {
		// TODO Auto-generated method stub
		return showProductListDAO.getTotalPageNumberByCat(catID);
	}
	


}
