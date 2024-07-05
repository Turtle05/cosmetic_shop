package model.bo;

import java.util.ArrayList;

import model.bean.Product;
import model.dao.ShowProductDetailDAO;
import model.dto.DanhgiaDTO;
import model.dto.ProDTO;

public class ShowProductDetailBO {
	ShowProductDetailDAO  showProductDetailDAO = new ShowProductDetailDAO();
	public Product getProductDetail(String productID) {
		return showProductDetailDAO.getProductDetail(productID);
	}
	public ProDTO getProductGroup(String productGroupID) {
		ProDTO returned = showProductDetailDAO.getProductGroup(productGroupID);
		System.out.println("bo :" + returned.getCategoryGroupName());
		return returned;
				
		
	}
	public ArrayList<Product> getProductist(String productGroupID) {
		return showProductDetailDAO.getProductist(productGroupID);
	}
	public ArrayList<DanhgiaDTO> getRate(String productGroupID) {
		
		return showProductDetailDAO.getRate(productGroupID);
	}
	public DanhgiaDTO getStar(String productGroupID) {
		// TODO Auto-generated method stub
		return showProductDetailDAO.getStar(productGroupID);
	}

}
