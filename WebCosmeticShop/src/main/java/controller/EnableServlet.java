package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditEmployeeBO;


public class EnableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EnableServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("userID"); 
		System.out.println("id " + id);
		String e = request.getParameter("e"); 
		System.out.println("e " + e);

		
		EditEmployeeBO deleteEmployee = new EditEmployeeBO();

		String returnedMessage = deleteEmployee.enableUser(id,e);

		RequestDispatcher    rd = null;

		if ("No Error".equals(returnedMessage)) {
        	 // Sửa thông tin thành công
		
		 rd = request.getRequestDispatcher("ShowEmployeeListServlet?message1=11");// Thông báo tạo mới thành công        
		

        } 
		rd.forward(request, response);
	}

}
