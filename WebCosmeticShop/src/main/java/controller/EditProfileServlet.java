package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditProfileBO;


public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EditProfileServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		String id = request.getParameter("id");   
		String fullName = request.getParameter("fullName");   
		String address = request.getParameter("address");           	   
		String phone = request.getParameter("phone");          	   
		String email = request.getParameter("email");     
		

		System.out.println("username= " + email );
		


			EditProfileBO editProfileBO = new EditProfileBO();

			String returnedMessage = editProfileBO.editProfile( fullName, address, phone, email);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {
	        	 // Sửa thông tin thành công

	                 rd = request.getRequestDispatcher("ShowProfileServlet?message1=5");// Thông báo tạo mới thành công        


	         } else if ("Required Fields Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("ShowProfileServlet?message1=2");
	         } else if ("Phone Error".equals(returnedMessage)) {
	        	 
	        	 // Lỗi thiếu thông tin các field bắt buộc nhập
	        	 
	        	 rd = request.getRequestDispatcher("ShowProfileServlet?message1=10");
	       
	       
	         }else {
	        	// Lỗi không xác định
	                 rd = request.getRequestDispatcher("ShowProfileServlet?message1=4"); // Lỗi không xác định

	         }

			rd.forward(request, response);

		}
	}


