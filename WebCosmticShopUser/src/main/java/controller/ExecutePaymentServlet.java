package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

import common.PaymentServices;
import model.bo.AddToCartBO;
import model.bo.CreateOrderBO;
import model.bo.ShowReceiptBO;
import model.dto.OrderDTO;
import model.dto.OrderDetailDTO;
 
@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ExecutePaymentServlet() {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
		
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        String orderID = request.getParameter("orderID");
        System.out.println("orderID " + orderID);
        
 
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
             
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
             
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);     
            
            CreateOrderBO  createOrderBO = new CreateOrderBO();
            createOrderBO.updateOrder(orderID, customerID);
            
            
            
         
            
           ShowReceiptBO showReceiptBO = new ShowReceiptBO();
            OrderDTO order = showReceiptBO.getOrrder(orderID);
            request.setAttribute("order", order);
            
            ArrayList<OrderDetailDTO> orderDetail = showReceiptBO.getOrderDetail(orderID);
           request.setAttribute("orderDetail", orderDetail);
            request.getRequestDispatcher("receipt.jsp").forward(request, response);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
 
}