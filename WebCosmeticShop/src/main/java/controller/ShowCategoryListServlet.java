package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bo.ShowCategoryBO;


public class ShowCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCategoryListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ShowCategoryBO showCategoryBO = new ShowCategoryBO();
		
		ArrayList<Category> catList = showCategoryBO.getCategory();
		
		request.setAttribute("catList", catList);
		
		request.setAttribute("active", "category");		
		RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
		rd.forward(request, response);
	}

}
