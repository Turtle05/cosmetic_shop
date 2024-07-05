package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.CategoryGroup;
import model.bo.EditCategoryBO;
import model.bo.ShowCategoryGroupBO;


public class ShowEditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditCategoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		
//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {
		
		String catID =  request.getParameter("catID");
		
		EditCategoryBO editCategoryBO = new EditCategoryBO();
		Category cat = editCategoryBO.getCat(catID);
		
		ShowCategoryGroupBO showCategoryGroupBO = new ShowCategoryGroupBO();
		ArrayList<CategoryGroup>  catGroup = showCategoryGroupBO.getCategoryGroup();
		request.setAttribute("catGroup", catGroup);	
		request.setAttribute("cat", cat);	
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("editCategory.jsp");
		rd.forward(request, response);
		}
//	}
}
