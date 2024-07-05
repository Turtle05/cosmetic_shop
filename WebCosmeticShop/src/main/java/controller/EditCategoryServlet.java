package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditCategoryBO;


public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCategoryServlet() {
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

			String categoryID = request.getParameter("categoryID");

			String catName = request.getParameter("catName");
			
			String catGroupID = request.getParameter("catGroupID");

			System.out.println("cat G ID= " + catGroupID );
			System.out.println("cat G name= " + catName );
			System.out.println("cat G name= " + catGroupID );
		



			EditCategoryBO editCategoryBO = new EditCategoryBO();

			String returnedMessage = editCategoryBO.editCategory(categoryID, catName, catGroupID);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {

				// Chỉnh sửa thành công

				 rd = request.getRequestDispatcher("ShowEditCategoryServlet?catID=" + categoryID + "&message1=3");
			} else if ("Required Fields Error".equals(returnedMessage)) {

				// Lỗi thiếu thông tin các field bắt buộc nhập

				rd = request.getRequestDispatcher("ShowEditCategoryServlet?catID=" + categoryID + "&message1=2");


			} else {

				// Lỗi không xác định

				rd = request.getRequestDispatcher("ShowEditCategoryServlet?catID=" + categoryID + "&message1=1");

			}

			rd.forward(request, response);

		}

//	}
}
