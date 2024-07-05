package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ShowInforBO;
import model.dto.OrderDTO;

public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowOrderServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");

		ShowInforBO showInforBO = new ShowInforBO();
		ArrayList<OrderDTO> orderList = showInforBO.getOrderList(customerID);

		request.setAttribute("orderList", orderList);
		
		RequestDispatcher rd = request.getRequestDispatcher("order.jsp");
		rd.forward(request, response);
	}

}
