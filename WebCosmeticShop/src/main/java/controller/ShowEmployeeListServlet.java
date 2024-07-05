package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.ShowEmployeeListBO;




public class ShowEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowEmployeeListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowEmployeeListBO showEmployeeListBO = new ShowEmployeeListBO();
		
		ArrayList<User> employeeList = showEmployeeListBO.getEmployeeList();
		
		request.setAttribute("employeeList", employeeList);
			
		RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
		rd.forward(request, response);
	}

}
