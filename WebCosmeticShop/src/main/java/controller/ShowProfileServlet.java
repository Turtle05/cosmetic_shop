package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Employee;
import model.bo.ShowProfileBO;




public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowProfileServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		
		
		ShowProfileBO showProfileBO = new ShowProfileBO();
		
		Employee profile = showProfileBO.getProfile(username );
		
		session.setAttribute("fullname", profile.getFullName());
        session.setAttribute("image", profile.getImage());
		
		request.setAttribute("profile", profile);
		
		request.setAttribute("active", "pro");		
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		rd.forward(request, response);
	}

}
