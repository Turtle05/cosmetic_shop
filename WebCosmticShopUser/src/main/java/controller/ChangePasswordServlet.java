package controller;

import java.io.IOException;
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
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		String customerID = (String)session.getAttribute("cusID");	
		
		String pass = request.getParameter("pass");
		String newpassword = request.getParameter("newpassword");
		String renewpassword = request.getParameter("confilmPass");
		
		ChangePasswordBO changePasswordBO = new ChangePasswordBO();
		String returnedMessage = changePasswordBO.changePassword( customerID, pass, newpassword, renewpassword);
		
		if ("No Error".equals(returnedMessage)) {

			// Chỉnh sửa thành công
			response.sendRedirect("changePassword.jsp?message=1");

		} else if ("Required Fields Error".equals(returnedMessage)) {

			// Lỗi thiếu thông tin các field bắt buộc nhập
			response.sendRedirect("changePassword.jsp?message=2");

		} 
		else if ("None".equals(returnedMessage)) {

		// Không trùng mật khẩu cũ
		response.sendRedirect("changePassword.jsp?message=3");

		}		
		else if ("Password Error".equals(returnedMessage)) {

			// lỗi validate
			response.sendRedirect("changePassword.jsp?message=4");


		} else if ("Renewpassword Error".equals(returnedMessage)){

			// Lỗi mật khẩu xác nhận và mật khẩu mới không trùng khớp
			response.sendRedirect("changePassword.jsp?message=5");
		} else {
			//lỗi ko xác định
			response.sendRedirect("changePassword.jsp?message=6");
		}
		
	}

}
