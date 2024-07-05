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
import model.bo.ShowCartBO;
import model.bo.ShowCatListBO;
import model.bo.ShowProductListBO;
import model.dto.CartDTO;

public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCartServlet() {
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
			System.out.println("CusID: "+ customerID);

//			String fromForm = request.getParameter("formName");

			ShowCartBO showCartBO = new ShowCartBO();

			ArrayList<CartDTO> cartList = showCartBO.getCartList(customerID);
			request.setAttribute("cartList", cartList);

			ShowCatListBO showCatGroupListBO = new ShowCatListBO();
			ArrayList<CategoryGroup> catGroupList = showCatGroupListBO.getCatGroup();
			request.setAttribute("catGroupList", catGroupList);

			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);

		}
	}
}