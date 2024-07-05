package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditEmployeeBO;

public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteCustomerServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("customerID");  
		System.out.println("customerID" + id);
		
		EditEmployeeBO deleteEmployee = new EditEmployeeBO();

		String returnedMessage = deleteEmployee.deleteCustomer(id);

		RequestDispatcher    rd = null;

		if ("No Error".equals(returnedMessage)) {
        	 // Sửa thông tin thành công
		
		 rd = request.getRequestDispatcher("ShowCustomerListServlet?message1=10");       
		

        } else {
        	rd = request.getRequestDispatcher("ShowCustomerListServlet?message1=11");  
        }
		rd.forward(request, response);
	}

}
