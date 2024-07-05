package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Order;
import model.bo.ShowOrderListBO;
import model.dto.OrderDTO;




public class ShowOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowOrderListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowOrderListBO showOrderListBO = new ShowOrderListBO();
		
		ArrayList<OrderDTO> orderList = showOrderListBO.getOrderList();
		
		request.setAttribute("orderList", orderList);
		
			
		RequestDispatcher rd = request.getRequestDispatcher("order.jsp");
		rd.forward(request, response);
	}

}
