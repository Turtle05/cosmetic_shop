package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.EditInforBO;



public class EditInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditInforServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
  
		String fullName = request.getParameter("fullname");  
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email"); 
		String address = request.getParameter("address");           	   
		

		


			EditInforBO editInforBO = new EditInforBO();

			String returnedMessage = editInforBO.editInfor( customerID, fullName,  phone, address);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {

	                 rd = request.getRequestDispatcher("infor.jsp?message=1");// Thông báo tạo mới thành công        


	         } else if ("Null Error".equals(returnedMessage)) {

	             rd = request.getRequestDispatcher("infor.jsp?message=2");
	             
	         } else if ("Phone Error".equals(returnedMessage)) {

	             rd = request.getRequestDispatcher("infor.jsp?message=3");
	       
	       
	         }else {
	                 rd = request.getRequestDispatcher("infor.jsp?message=0"); // Lỗi không xác định

	         }

			rd.forward(request, response);
	}

}
