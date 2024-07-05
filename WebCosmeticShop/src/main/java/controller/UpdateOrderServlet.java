package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.UpdateOrderBO;

public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateOrderServlet() {
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

		String status = request.getParameter("status"); 
		String orderID = request.getParameter("orderID"); 
		

			System.out.println("status= " + status );
			System.out.println("orderID= " + orderID );
		
			request.setAttribute("orderID", orderID); 



			UpdateOrderBO updateOrderBO = new UpdateOrderBO();

			String returnedMessage = updateOrderBO.updateOrder(status, orderID);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {
	        	 // Thêm mới thành công

	                 rd = request.getRequestDispatcher("ShowOrderDetail?message=1");// Thông báo tạo mới thành công        
	       
	         }else {
	        	// Lỗi không xác định
	                 rd = request.getRequestDispatcher("ShowOrderDetail?message=2"); // Lỗi không xác định

	         }

			rd.forward(request, response);
	}

}
