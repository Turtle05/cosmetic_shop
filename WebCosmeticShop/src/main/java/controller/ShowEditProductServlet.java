package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.Brand;

import model.bean.CategoryGroup;
import model.bo.EditProductBO;
import model.bo.ShowBrandListBO;

import model.bo.ShowCategoryGroupBO;
import model.dto.ProDTO;
import model.bean.Product;


public class ShowEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowEditProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productGroupID = (String)request.getParameter("productGroupID");
		System.out.println("productGroupID : "+ productGroupID);
		
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
		
		
		
		EditProductBO editProductBO = new EditProductBO();
		ProDTO productDetail =  editProductBO.getProductDetail(productGroupID);
		request.setAttribute("productDetail", productDetail);
		
		ArrayList<Product> product = editProductBO.getProduct(productGroupID);
		request.setAttribute("product", product);
		
		
			
		RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
		rd.forward(request, response);
	}

}
