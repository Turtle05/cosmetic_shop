package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Customer;
import model.bo.ShowCustomerListBO;




public class ShowCustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCustomerListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowCustomerListBO showCustomerListBO = new ShowCustomerListBO();
		
		ArrayList<Customer> customerList = showCustomerListBO.getCustomerList();
		
		request.setAttribute("customerList", customerList);
		
		request.setAttribute("active", "customer");		
		RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
		rd.forward(request, response);
	}

}