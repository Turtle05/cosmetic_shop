package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CategoryGroup;
import model.bo.ShowCategoryGroupBO;


public class ShowCategoryGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCategoryGroupServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowCategoryGroupBO showCategoryGroupBO = new ShowCategoryGroupBO();
		
		ArrayList<CategoryGroup> catGroupList = showCategoryGroupBO.getCategoryGroup();
		
		request.setAttribute("catGroupList", catGroupList);
		
		request.setAttribute("active", "categoryGroup");		
		RequestDispatcher rd = request.getRequestDispatcher("categoryGroup.jsp");
		rd.forward(request, response);
	}

}
