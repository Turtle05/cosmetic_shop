package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.CategoryGroup;
import model.bo.EditCategoryGroupBO;


public class ShowEditCategoryGroupSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditCategoryGroupSerlvet() {
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
		
		String catGroupID =  request.getParameter("catGroupID");
		System.out.println("catG ID show: "+ catGroupID);
		EditCategoryGroupBO editCategoryGroupBO = new EditCategoryGroupBO();
		CategoryGroup catGroup = editCategoryGroupBO.getCatGroup(catGroupID);
		request.setAttribute("catGroup", catGroup);	
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("editCategoryGroup.jsp");
		rd.forward(request, response);
		}
//	}
}
