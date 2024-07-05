package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.Category;
import model.bean.CategoryGroup;
import model.dao.ShowCatListDAO;

public class ShowCatListBO {
	ShowCatListDAO showCategoryGroupDAO = new ShowCatListDAO();
	
	public ArrayList<CategoryGroup> getCatGroup() {
		// TODO Auto-generated method stub
		return showCategoryGroupDAO.getCatGroup();
	}

	public List<Category> getCategoriesByGroup(String categoryGroupID) {
		// TODO Auto-generated method stub
		return showCategoryGroupDAO.getCategoriesByGroup(categoryGroupID);
	}

}
