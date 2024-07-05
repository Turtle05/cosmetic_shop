package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CategoryGroup;
import model.bo.DeleteCartBO;
import model.bo.ShowCartBO;
import model.bo.ShowCatListBO;
import model.dto.CartDTO;

public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			String customerID = (String) session.getAttribute("cusID");
			System.out.println("CusID: " + customerID);

			String productID = (String) request.getParameter("productID");

			DeleteCartBO deleteCartBO = new DeleteCartBO();
			RequestDispatcher rd = null;
			String returnedString = deleteCartBO.deleteCart(customerID, productID);
			if ("No Error".equals(returnedString)) {
				rd = request.getRequestDispatcher("ShowCartServlet?error=4");
			} else {
				rd = request.getRequestDispatcher("ShowCartServlet?error=5");
			}

			rd.forward(request, response);

		}
	}
}