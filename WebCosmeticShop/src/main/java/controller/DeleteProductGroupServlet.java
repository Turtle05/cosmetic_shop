package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.S3Util;
import model.bo.EditProductBO;


public class DeleteProductGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteProductGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
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

		

       
		
    	
        
		
		String productGroupID = request.getParameter("productGroupID");
	
		
		
		System.out.println("productGroupID: " + productGroupID);
	 
	    
	    
	   
		
		
		
		EditProductBO  editProductBO = new EditProductBO();
		String returnedMessage = editProductBO.deleteProductGroup(productGroupID);
		
	
		
		
			System.out.println("returnedMessage : " + returnedMessage);
			
			RequestDispatcher rd = null;
//			request.getRequestDispatcher("ShowCreateProductServlet");
	
	
	
	if ("No Error".equals(returnedMessage)) {
    	 // Thêm mới thành công

             rd = request.getRequestDispatcher("ShowProductListServlet?message1=12");// Thông báo tạo mới thành công        

//     } else if ("Duplicate ID Error".equals(returnedMessage)) {
//    	  // Lỗi trùng mã danh mục
//
//             rd = request.getRequestDispatcher("ShowProductListServlet?message=13"); // Lỗi trùng khóa

   
     }else {
    	// Lỗi không xác định
             rd = request.getRequestDispatcher("ShowProductListServlet?message1=0"); // Lỗi không xác định

     }

     rd.forward(request, response);


			

	}
	

}
