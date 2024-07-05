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
import model.bo.SearchProductBO;
import model.bo.ShowCatListBO;
import model.dto.ProductDTO;



public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProductServlet() {
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

             searchText = (String)session.getAttribute("searchProductText");

     }

		SearchProductBO searchProductBO = new SearchProductBO();

		System.out.println("searchText=" + searchText);

		String page = request.getParameter("page");

		int pageNumber = 1; // Mặc định là trang 1, trang đầu tiên

		if (page != null && !"".equals(page)) {

			pageNumber = Integer.valueOf(page);

		}
		
		ShowCatListBO showCatGroupListBO = new ShowCatListBO();
		ArrayList<CategoryGroup> catGroupList = showCatGroupListBO.getCatGroup();
		request.setAttribute("catGroupList", catGroupList);

		ArrayList<ProductDTO> productList = searchProductBO.getProductList(searchText, pageNumber);

		int totalPageNumber = searchProductBO.getTotalPageNumber(searchText);

		request.setAttribute("productList", productList);

		request.setAttribute("currentPageNumer", pageNumber);

		request.setAttribute("totalPageNumber", totalPageNumber);
		
		
		session.setAttribute("searchProductText", searchText);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");

		rd.forward(request, response);

	}
}
