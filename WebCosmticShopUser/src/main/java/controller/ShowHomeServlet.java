package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ShowProductListBO;
import model.dto.ProductDTO;

public class ShowHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowHomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {
		    
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			ShowProductListBO showNewestProductBO = new ShowProductListBO();

			ArrayList<ProductDTO> productNewestList = showNewestProductBO.getNewestProduct();
			request.setAttribute("productNewestList", productNewestList);

			ShowProductListBO showSalestProductBO = new ShowProductListBO();

			ArrayList<ProductDTO> productSalestList = showSalestProductBO.getSalestProduct();
			request.setAttribute("productSalestList", productSalestList);

			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);

		}
//	}

}
