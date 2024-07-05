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

import model.bo.CheckLoginBO;



public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final int EMPLOYEE_ACCOUNT =1;
       
   
    public CheckLoginServlet() {
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
		
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		RequestDispatcher rd = null;
		
		
		String accountInfor = null;
		HttpSession session = request.getSession();
		
		
		
	 if (checkLoginBO.getAccountRole(email, password) == EMPLOYEE_ACCOUNT) {
			accountInfor = email;
			session.setAttribute("accountInfor", accountInfor);	
//			session.setAttribute("username", email);
			
			String cusID = checkLoginBO.getCustomerID(email);
			System.out.println("Cus: " + cusID);
			session.setAttribute("cusID", cusID);
			
			rd = request.getRequestDispatcher("ShowHomeServlet");
		} else {
			rd = request.getRequestDispatcher("login.jsp?error=2");
		}
		
		
		rd.forward(request, response);
	}

}
