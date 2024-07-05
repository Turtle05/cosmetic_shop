package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.Brand;

import model.bean.CategoryGroup;
import model.bo.ShowBrandListBO;

import model.bo.ShowCategoryGroupBO;


public class ShowCreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCreateProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  ShowCategoryGroupBO showCategoryGroupBO = new ShowCategoryGroupBO();
		  
		  ArrayList<CategoryGroup> catGroup = showCategoryGroupBO.getCategoryGroup();
		 
		  request.setAttribute("catGroup", catGroup);
		 
		
//		ShowCategoryBO  showCategoryBO = new ShowCategoryBO();
//		ArrayList<Category> cat = showCategoryBO.getCategory();
//		
//		request.setAttribute("cat", cat);
		
		ShowBrandListBO showBrandListBO = new ShowBrandListBO();
		ArrayList<Brand> brandList = showBrandListBO.getBrandList();
		
		request.setAttribute("brandList", brandList);
		
		
			
		RequestDispatcher rd = request.getRequestDispatcher("createProduct.jsp");
		rd.forward(request, response);
	}

}
