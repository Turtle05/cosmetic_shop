package model.bo;

import java.util.ArrayList;

import model.bean.Brand;
import model.dao.ShowBrandListDAO;

public class ShowBrandListBO {
	ShowBrandListDAO showBrandListDAO = new ShowBrandListDAO();

	public ArrayList<Brand> getBrandList() {
		return showBrandListDAO.getBrandList();
	}

}
