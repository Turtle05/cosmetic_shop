package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.RateBO;

public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String customerID = (String) session.getAttribute("cusID");

		
		
  
		String productGroupID = request.getParameter("productGroupID");  
		String productID = request.getParameter("productID");  
		String star = request.getParameter("rating"); 
		String comment = request.getParameter("comment");
		
		System.out.println("ProductGroupID :" + productGroupID );
		System.out.println("star :" + star );
		System.out.println("comment :" + comment );
		
		
		RateBO rateBO = new RateBO();
		rateBO.createRate(customerID,productGroupID, star, comment);
		
		String redirectURL = "ShowProductDetailServlet?productID=" + productID + "&ProductGroupID=" + productGroupID + "&messageRate=" + "1" ;
		RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
		rd.forward(request, response);
	}

}
