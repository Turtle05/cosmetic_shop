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
import model.bo.ShowCatListBO;
import model.bo.ShowProductListBO;
import model.dto.ProductDTO;

public class ShowProductByCat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowProductByCat() {
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
			
			HttpSession session2 = request.getSession();
			session2.removeAttribute("searchProductText");
			

			ShowProductListBO showProductListBO = new ShowProductListBO();
			
			String page = request.getParameter("page");
			String catID = request.getParameter("catID");
			
			System.out.println("catID" + catID);
			
			
			request.setAttribute("catID", catID);
			/* System.out.println("cgID : " + cgID); */
			
			System.out.println("page : " + page );
			int pageNumber = 1;
			if (page != null && !"".equals(page)) {
				pageNumber = Integer.valueOf(page);
			}
			
			System.out.println("pagenumber: " + pageNumber);

			ArrayList<ProductDTO> productList = showProductListBO.getProductByCat(catID,pageNumber);
			int totalPageNumber = showProductListBO.getTotalPageNumberByCat(catID);
			
			request.setAttribute("productList", productList);

			ShowCatListBO showCatGroupListBO = new ShowCatListBO();
			ArrayList<CategoryGroup> catGroupList = showCatGroupListBO.getCatGroup();
			request.setAttribute("catGroupList", catGroupList);
			
			request.setAttribute("currentPageNumer", pageNumber);
		    request.setAttribute("totalPageNumber", totalPageNumber);
			

			RequestDispatcher rd = request.getRequestDispatcher("productByCat.jsp");
			rd.forward(request, response);

		}
//	}
}
