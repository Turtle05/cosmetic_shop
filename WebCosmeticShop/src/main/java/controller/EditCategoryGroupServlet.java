package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EditCategoryGroupBO;


public class EditCategoryGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCategoryGroupServlet() {
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

			String catGroupID = request.getParameter("catGID");

			String catGroupName = request.getParameter("catGName");

			System.out.println("cat G ID= " + catGroupID );
			System.out.println("cat G name= " + catGroupName );
		



			EditCategoryGroupBO editCategoryGroupBO = new EditCategoryGroupBO();

			String returnedMessage = editCategoryGroupBO.editCategoryGroup(catGroupID, catGroupName);

			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {

				// Chỉnh sửa thành công

				rd = request

						.getRequestDispatcher("ShowCategoryGroupServlet?message=3");

			} else if ("Required Fields Error".equals(returnedMessage)) {

				// Lỗi thiếu thông tin các field bắt buộc nhập

				rd = request.getRequestDispatcher("ShowCategoryGroupServlet?message=2");


			} else {

				// Lỗi không xác định

				rd = request.getRequestDispatcher("ShowCategoryGroupServlet?message=1");

			}

			rd.forward(request, response);

		}

//	}
}
