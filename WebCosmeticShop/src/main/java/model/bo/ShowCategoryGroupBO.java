package model.bo;

import java.util.ArrayList;

import model.bean.CategoryGroup;
import model.dao.ShowCategoryGroupDAO;

public class ShowCategoryGroupBO {
	ShowCategoryGroupDAO showCategoryGroupDAO = new ShowCategoryGroupDAO();
	public ArrayList<CategoryGroup> getCategoryGroup() {
		return showCategoryGroupDAO.getCategoryGroup();
	}
	
	

}
