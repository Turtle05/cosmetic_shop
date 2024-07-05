package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.CreateOrderBO;
import model.bo.ShowReceiptBO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class ShowReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowReceiptServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
		String orderID = (String) request.getAttribute("orderID");
        System.out.println("orderID " + orderID);
             
            
            CreateOrderBO  createOrderBO = new CreateOrderBO();
            createOrderBO.updateOrder(orderID, customerID);
            
        
           ShowReceiptBO showReceiptBO = new ShowReceiptBO();
            OrderDTO order = showReceiptBO.getOrrder(orderID);
            request.setAttribute("order", order);
            
            ArrayList<OrderDetailDTO> orderDetail = showReceiptBO.getOrderDetail(orderID);
           request.setAttribute("orderDetail", orderDetail);
            request.getRequestDispatcher("receipt.jsp").forward(request, response);
       
    
	}

}
