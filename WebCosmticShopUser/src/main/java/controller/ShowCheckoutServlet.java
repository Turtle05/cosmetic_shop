package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ShowCartBO;
import model.bo.ShowCustomerDetailBO;
import model.dto.CartDTO;
import model.dto.CustomerDTO;


public class ShowCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowCheckoutServlet() {
        super();
    }
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");
		System.out.println("CusID: " + customerID);

//		String[] productID = (String[])request.getParameterValues("proID");
//		String[] quantity = (String[])request.getParameterValues("quantity");
//		System.out.println("lenght: "+ productID.length);
//		for(int i=0; i < productID.length; i++)
//		{
//			System.out.println("productID : "+productID[i] + " quantity : " + quantity[i]);
//		}
		
		ShowCartBO showCartBO = new ShowCartBO();
		ArrayList<CartDTO> returnedList = showCartBO.getCartList(customerID);
		request.setAttribute("cartList", returnedList);
		
		ShowCustomerDetailBO  showCustomerDetailBO  = new  ShowCustomerDetailBO();
		
		CustomerDTO cusDetail = showCustomerDetailBO.getCusDetail(customerID);
		request.setAttribute("cusDetail", cusDetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, response);
		
	}

}






