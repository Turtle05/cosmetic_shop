package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CategoryGroup;
import model.bo.CreateCategoryBO;
import model.bo.ShowCategoryGroupBO;



public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateCategoryServlet() {
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

		
		String catName = request.getParameter("catName");
		String catGroupID = request.getParameter("catGroupID");
		
	
		CreateCategoryBO  createCategoryBO = new CreateCategoryBO();
		String returnedMessage = createCategoryBO.insertCat( catName, catGroupID);
		
		
		 RequestDispatcher rd = null;

         if ("No Error".equals(returnedMessage)) {
        	 // Thêm mới thành công

                 rd = request.getRequestDispatcher("ShowCategoryListServlet?message=5");// Thông báo tạo mới thành công        

         } else if ("Duplicate ID Error".equals(returnedMessage)) {
        	  // Lỗi trùng mã danh mục

                 rd = request.getRequestDispatcher("CreateCategory?message=1"); // Lỗi trùng khóa

         } else if ("Required Fields Error".equals(returnedMessage)) {

             // Lỗi thiếu thông tin các field bắt buộc nhập

             rd = request.getRequestDispatcher("CreateCategory?message=2");
       
         }else {
        	// Lỗi không xác định
                 rd = request.getRequestDispatcher("CreateCategory?message=4"); // Lỗi không xác định

         }
//		 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
         rd.forward(request, response);
         
		}
	
	
	
//	}

}
