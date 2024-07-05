package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditCategoryBO;
import model.bo.EditEmployeeBO;

public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteCategoryServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("categoryID");  
		
		EditCategoryBO deleteCategory = new EditCategoryBO();

		String returnedMessage = deleteCategory.deleteCategory(id);

		RequestDispatcher  rd = null;

		if ("No Error".equals(returnedMessage)) {
        	 // Sửa thông tin thành công
		
		 rd = request.getRequestDispatcher("ShowCategoryListServlet?message1=10");// Thông báo tạo mới thành công        
		

        } else {
        	rd = request.getRequestDispatcher("ShowCategoryListServlet?message1=11");  
        }
		rd.forward(request, response);
	}

}
