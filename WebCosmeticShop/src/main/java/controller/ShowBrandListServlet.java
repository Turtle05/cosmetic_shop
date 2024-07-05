package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Brand;
import model.bo.ShowBrandListBO;


public class ShowBrandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowBrandListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowBrandListBO showBrandListBO = new ShowBrandListBO();
		
		ArrayList<Brand> brandList = showBrandListBO.getBrandList();
		
		request.setAttribute("brandList", brandList);
		
		request.setAttribute("active", "brand");		
		RequestDispatcher rd = request.getRequestDispatcher("brand.jsp");
		rd.forward(request, response);
	}

}
