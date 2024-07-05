package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ShowOrderListBO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;

public class ShowOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowOrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
		String orderID = request.getParameter("orderID");
		System.out.println("orderID : " + orderID);

		ShowOrderListBO showOrderDetailBO = new ShowOrderListBO();
		OrderDTO order = showOrderDetailBO.getInfor(orderID);
		request.setAttribute("order", order);
		
		ArrayList<OrderDetailDTO>  orderDetail = showOrderDetailBO.getOrderDetail(orderID);
		request.setAttribute("orderDetail", orderDetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("orderDetail.jsp");
		rd.forward(request, response);
	}

}
