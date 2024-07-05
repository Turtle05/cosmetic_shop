package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

import common.PaymentServices;
import model.bo.CreateOrderBO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;
 
@WebServlet("/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ReviewPaymentServlet() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
         
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.getPaymentDetails(paymentId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
//            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
            
            CreateOrderBO createOrderBO = new CreateOrderBO();
            OrderDTO order = createOrderBO.showReview(customerID);
            request.setAttribute("order", order);
            
            ArrayList<OrderDetailDTO>  orderDetail = createOrderBO.getOrderDetail(customerID);
            request.setAttribute("orderDetail", orderDetail);
            
             
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);
//            request.setAttribute("shippingAddress", shippingAddress);
             
            String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;
             
            request.getRequestDispatcher(url).forward(request, response);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }      
    }
 
}