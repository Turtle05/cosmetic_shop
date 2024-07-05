package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ShowDashBoardBO;
import model.dto.OrderDTO;
import model.dto.ProductDTO;




public class ShowDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowDashBoardServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ShowCategoryBO showCategoryBO = new ShowCategoryBO();
//		
//		ArrayList<Category> brandList = showCategoryBO.getCategory();
//		
//		request.setAttribute("brandList", brandList);
		ShowDashBoardBO showDashBoardBO = new ShowDashBoardBO();
		String sales = showDashBoardBO.getSales();
		String cus = showDashBoardBO.getCustomer();
		String total = showDashBoardBO.getTotal();
		ArrayList<OrderDTO> orderList = showDashBoardBO.getOrderList();
		ArrayList<ProductDTO> productList = showDashBoardBO.getProductList();
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("productList", productList);
		
		request.setAttribute("sales", sales);	
		request.setAttribute("cus", cus);	
		request.setAttribute("total", total);	
		
		RequestDispatcher rd = request.getRequestDispatcher("welcomeAdmin.jsp");
		rd.forward(request, response);
	}

}
