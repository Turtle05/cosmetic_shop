package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.bean.Customer;

import model.bo.EditCustomerBO;


public class ShowEditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditCustomerServlet() {
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
		
		String customerID =  request.getParameter("customerID");
		
		System.out.println("customerID show: "+ customerID);
		
		EditCustomerBO editCustomerBO = new EditCustomerBO();
		Customer cus = editCustomerBO.getCustomer(customerID);
		request.setAttribute("cus", cus);	
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("editCustomer.jsp");
		rd.forward(request, response);
		}
//	}
}
