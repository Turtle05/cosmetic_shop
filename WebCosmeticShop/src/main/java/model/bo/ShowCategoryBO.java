package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.Category;
import model.dao.ShowCategoryDAO;

public class ShowCategoryBO {
ShowCategoryDAO showCategoryDAO = new ShowCategoryDAO();

	public ArrayList<Category> getCategory() {
		
		return showCategoryDAO.getCategory();
	}

	public List<Category> getCategoriesByGroup(String categoryGroupID) {
		// TODO Auto-generated method stub
		return showCategoryDAO.getCategoriesByGroup(categoryGroupID);
	}

}
