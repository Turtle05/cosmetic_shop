package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.CreateCategoryBO;
import model.bo.CreateCustomerBO;



public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateCustomerServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {

		

		String customerName = request.getParameter("customerName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		

		CreateCustomerBO  createCustomerBO = new CreateCustomerBO();
		String returnedMessage = createCustomerBO.createCustomer(customerName, address, phone, email, password, confirmpassword);
		
		
		 RequestDispatcher rd = null;

         if ("No Error".equals(returnedMessage)) {
        	 // Thêm mới thành công

                 rd = request.getRequestDispatcher("ShowCustomerListServlet?message1=5");// Thông báo tạo mới thành công        

         } else if ("Duplicate ID Error".equals(returnedMessage)) {
        	  // Lỗi trùng mã danh mục

                 rd = request.getRequestDispatcher("createCustomer.jsp?message=1"); // Lỗi trùng khóa

         } else if ("Required Fields Error".equals(returnedMessage)) {

             // Lỗi thiếu thông tin các field bắt buộc nhập

             rd = request.getRequestDispatcher("createCustomer.jsp?message=2");
       
         }  else if ("Double Username Error".equals(returnedMessage)) {

             // Lỗi thiếu thông tin các field bắt buộc nhập

             rd = request.getRequestDispatcher("createCustomer.jsp?message=3");
         }  else if ("Pass Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("createCustomer.jsp?message=4");
             
         }  else if ("Password Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("createCustomer.jsp?message=6");
             
         }  else if ("Phone Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("createCustomer.jsp?message=7");
         }  else if ("Email Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("createCustomer.jsp?message=8");
       
         }else {
        	// Lỗi không xác định
                 rd = request.getRequestDispatcher("createCustomer.jsp?message=0"); // Lỗi không xác định

         }
//		 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
         rd.forward(request, response);
         
		}
	
	
	
//	}

}
