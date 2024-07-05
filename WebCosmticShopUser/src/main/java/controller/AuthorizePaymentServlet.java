package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.base.rest.PayPalRESTException;

import common.OrderDetail;
import common.PaymentServices;
import model.bo.CreateOrderBO;

@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorizePaymentServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String city = request.getParameter("district");
		String district = request.getParameter("district ");
		String ward = request.getParameter("ward");
//		String customerID = request.getParameter("customerID");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String[] productID = request.getParameterValues("productID");
		String[] quantity = request.getParameterValues("quantity");
		String[] price = request.getParameterValues("price");
		String subTotal = request.getParameter("subTotal");
		String shipping = request.getParameter("shipping");
		String grandTotal = request.getParameter("grandTotal");
		String method = request.getParameter("method");
		
		
		System.out.println(address + " city " +  city +" " +subTotal + " method : " + method);
		System.out.println("email : " + email);
		System.out.println("lenght : " + productID.length);
		for(int i=0; i < productID.length; i++) {
			System.out.println("productID: " + productID[i] );
		}
		
		CreateOrderBO createOrderBO = new CreateOrderBO();
		createOrderBO.deleteOrder();
		
		
		if("cod".equals(method)) {
			String statusOrder ="cho";
			String statusOrderDetail="1";
			String returned = createOrderBO.insertOrder(customerID,fullname, address, phone, email, productID, quantity, price, subTotal, shipping, grandTotal, method, statusOrder,statusOrderDetail );
			if("Required Fields Error".equals(returned)) {
				String path = "ShowCheckoutServlet?error=1";
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
				return;
			}
			if("Phone Error".equals(returned)) {
				String path = "ShowCheckoutServlet?error=2";
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
				return;
			}
			String orderID = createOrderBO.getOrderIDReturn();
			request.setAttribute("orderID", orderID);
			request.getRequestDispatcher("ShowReceiptServlet").forward(request, response);
		} else {
		String statusOrder ="Chưa thanh toán";
		String statusOrderDetail="0";
		String returned = createOrderBO.insertOrder(customerID,fullname, address, phone, email, productID, quantity, price, subTotal, shipping, grandTotal, method, statusOrder,statusOrderDetail );
		if("Required Fields Error".equals(returned)) {
			String path = "ShowCheckoutServlet?error=1";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			return;
		}
		if("Phone Error".equals(returned)) {
			String path = "ShowCheckoutServlet?error=2";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			return;
		}
		OrderDetail orderDetail = new OrderDetail(grandTotal);

		try {
			PaymentServices paymentServices = new PaymentServices();
			String approvalLink = paymentServices.authorizePayment(orderDetail);

			response.sendRedirect(approvalLink);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	}
	

}
