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




public class ShowCreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCreateOrderServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowProductListBO ShowProductListBO = new ShowProductListBO();
		
//		ArrayList<ProductDTO> productList = ShowProductListBO.getProductList();
//		
//		request.setAttribute("productList", productList);
		
		
		
		
		
		String message = request.getParameter("message");
		System.out.println("message: " + message);
		
		HttpSession session2 = request.getSession();
		session2.removeAttribute("searchProductText");

		ShowProductListBO showProductListBO = new ShowProductListBO();

		String page = request.getParameter("page");
		System.out.println("page : " + page );
		int pageNumber = 1;
		if (page != null && !"".equals(page)) {
			pageNumber = Integer.valueOf(page);
		}
		System.out.println("pagenumber: " + pageNumber);

		ArrayList<ProductDTO> productList = showProductListBO.getProductList(pageNumber);
		
		int totalPageNumber = showProductListBO.getTotalPageNumber();
        
        request.setAttribute("productList", productList);
        request.setAttribute("currentPageNumer", pageNumber);
        request.setAttribute("totalPageNumber", totalPageNumber);		
		
		

		
		
		
		
		
				
		RequestDispatcher rd = request.getRequestDispatcher("createOrder.jsp");
		rd.forward(request, response);
	}

}
