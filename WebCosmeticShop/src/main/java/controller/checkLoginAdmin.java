package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Employee;
import model.bo.CheckLoginBO;
import model.bo.ShowProfileBO;


public class checkLoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public checkLoginAdmin() {
        super();  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("XIN CHÀO");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		RequestDispatcher rd = null;
		final int INVALID_ACCOUNT = 0;
		final int ADMIN_ACCOUNT = 1;
		final int EMPLOYEE_ACCOUNT =2;
		
		String accountInfor = null;
		String role = null;
		HttpSession session = request.getSession();
		
		String imageSession = null;
		String fullnameSession = null;
		
		if(checkLoginBO.getAccountRole(userName, password) == INVALID_ACCOUNT) {
			rd = request.getRequestDispatcher("loginAdmin.jsp?error=2");
		} else if(checkLoginBO.getAccountRole(userName, password) == ADMIN_ACCOUNT){
			accountInfor = userName + "(Admin)";
			role = "admin";
			session.setAttribute("accountInfor", accountInfor);	
			session.setAttribute("role", role);	
			session.setAttribute("username", userName);	
			session.setAttribute("password", password);
			ShowProfileBO showProfileBO = new ShowProfileBO();
			
			Employee Profile = showProfileBO.getProfile(userName);
		
				imageSession = Profile.getImage();
				fullnameSession = Profile.getFullName();
		
			
			session.setAttribute("image", imageSession);
			session.setAttribute("fullname", fullnameSession);
			rd = request.getRequestDispatcher("ShowDashBoardServlet");
		} else if(checkLoginBO.getAccountRole(userName, password) == EMPLOYEE_ACCOUNT) 
		{
			accountInfor = userName + "(Admin)";
			role = "user";
			session.setAttribute("role", role);	
			session.setAttribute("accountInfor", accountInfor);	
			session.setAttribute("username", userName);	
			session.setAttribute("password", password);
			ShowProfileBO showProfileBO = new ShowProfileBO();
			
			Employee Profile = showProfileBO.getProfile(userName);
		
				imageSession = Profile.getImage();
				fullnameSession = Profile.getFullName();
		
			
			session.setAttribute("image", imageSession);
			session.setAttribute("fullname", fullnameSession);
			rd = request.getRequestDispatcher("ShowDashBoardServlet");
		} 
		else{
			//checkLoginBO.getAccountRole(userName, password) == EMPLOYEE_ACCOUNT
			accountInfor = userName + "(User)";
			session.setAttribute("accountInfor", accountInfor);	
			session.setAttribute("username", userName);	
			session.setAttribute("password", password);	
			
			ShowProfileBO showProfileBO = new ShowProfileBO();
			
			Employee Profile = showProfileBO.getProfile(userName);
		
				imageSession = Profile.getImage();
				fullnameSession = Profile.getFullName();
		
			
			session.setAttribute("image", imageSession);
			session.setAttribute("fullname", fullnameSession);
			rd = request.getRequestDispatcher("errorPage.jsp");
		} 
		
		
		rd.forward(request, response);
	}

}
