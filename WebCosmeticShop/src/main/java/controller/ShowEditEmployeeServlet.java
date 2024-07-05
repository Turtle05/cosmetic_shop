package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.bean.User;
import model.bo.EditEmployeeBO;



public class ShowEditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditEmployeeServlet() {
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
		
		String employeeID = request.getParameter("userID");
//		String employeeID =  request.getParameter("employeeID")== null ?  ((String)request.getAttribute("employeeID")):"";

		System.out.println("employeeID show: "+ employeeID);
		
		EditEmployeeBO editEmployeeBO = new EditEmployeeBO();
		User em = editEmployeeBO.getEmployee(employeeID);
		request.setAttribute("em", em);	
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("editEmployee.jsp");
		rd.forward(request, response);
		}
//	}
}

