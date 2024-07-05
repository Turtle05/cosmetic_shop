package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bo.ChangePasswordBO;



public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ChangePasswordServlet() {
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
		
		String username = (String)session.getAttribute("username");	
		String password = (String)session.getAttribute("password");
		
		String pass = request.getParameter("pass");
		String newpassword = request.getParameter("newpassword");
		String renewpassword = request.getParameter("renewpassword");
		
		ChangePasswordBO changePasswordBO = new ChangePasswordBO();
		String returnedMessage = changePasswordBO.changePassword( username, password, pass, newpassword, renewpassword);
		
		if ("No Error".equals(returnedMessage)) {

			// Chỉnh sửa thành công
			response.sendRedirect("ShowProfileServlet?message=1");

		} else if ("Required Fields Error".equals(returnedMessage)) {

			// Lỗi thiếu thông tin các field bắt buộc nhập
			response.sendRedirect("ShowProfileServlet?message=2");

		} else if ("Pass Error".equals(returnedMessage)) {

			// Lỗi ko đúng mật khẩu cũ
			response.sendRedirect("ShowProfileServlet?message=3");


		} else if ("Renewpassword Error".equals(returnedMessage)){

			// Lỗi mật khẩu xác nhận và mật khẩu mới không trùng khớp
			response.sendRedirect("ShowProfileServlet?message=4");
		} else if ("Password Error".equals(returnedMessage)){
			
			// Lỗi mật khẩu xác nhận và mật khẩu mới không trùng khớp
			response.sendRedirect("ShowProfileServlet?message=6");
		} else {
			//lỗi ko xác định
			response.sendRedirect("ShowProfileServlet?message=5");
		}
		
	}

}








