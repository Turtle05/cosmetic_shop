package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditCustomerBO;


public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {

		String customerID = request.getParameter("customerID"); 
		String customerName = request.getParameter("customerName"); 
		String gender = request.getParameter("gender"); 
		String birthday = request.getParameter("birthday"); 
		String address = request.getParameter("address");           	   
		String phone = request.getParameter("phone");          	   
		String email = request.getParameter("email");            	   
		String username = request.getParameter("username");            	   
		String password = request.getParameter("password");

			System.out.println("customerID= " + customerID );
			System.out.println("customerName= " + customerName );
		



			EditCustomerBO editCustomerBO = new EditCustomerBO();

			String returnedMessage = editCustomerBO.editCustomer(customerID, customerName, gender, birthday, address, phone, email, username, password);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {
	        	 // Thêm mới thành công

	                 rd = request.getRequestDispatcher("ShowCustomerListServlet?message=5");// Thông báo tạo mới thành công        


	         } else if ("Required Fields Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("editCustomer.jsp?message=2");
	       
	         }  else if ("Double Username Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("editCustomer.jsp?message=3");
	       
	         }else {
	        	// Lỗi không xác định
	                 rd = request.getRequestDispatcher("editCustomer.jsp?message=4"); // Lỗi không xác định

	         }

			rd.forward(request, response);

		}

//	}
}
