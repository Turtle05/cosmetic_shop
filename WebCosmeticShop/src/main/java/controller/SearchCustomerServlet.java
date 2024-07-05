package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Customer;
import model.bo.SearchCustomerBO;
import model.bo.SearchProductBO;
import model.dto.ProductDTO;



public class SearchCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCustomerServlet() {
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

		String searchText = request.getParameter("searchText");
		
		 if (searchText == null) {

             searchText = (String)session.getAttribute("searchCustomerText");

     }

		SearchCustomerBO searchCustomerBO = new SearchCustomerBO();

		System.out.println("searchText=" + searchText);

		String page = request.getParameter("page");

		int pageNumber = 1; // Mặc định là trang 1, trang đầu tiên

		if (page != null && !"".equals(page)) {

			pageNumber = Integer.valueOf(page);

		}

//		ArrayList<ProductDTO> productList = searchProductBO.getProductList(searchText, pageNumber);
		ArrayList<Customer> customerList = searchCustomerBO.getCustomerList(searchText);

//		int totalPageNumber = searchCustomerBO.getTotalPageNumber(searchText);

		request.setAttribute("customerList", customerList);

		request.setAttribute("currentPageNumer", pageNumber);
//
//		request.setAttribute("totalPageNumber", totalPageNumber);
		
		
		session.setAttribute("searchCustomerText", searchText);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");

		rd.forward(request, response);

	}
}
