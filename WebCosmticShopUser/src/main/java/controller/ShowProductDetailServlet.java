package controller;


import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Product;
import model.bo.ShowProductDetailBO;
import model.dto.ProDTO;
import model.dto.DanhgiaDTO;



public class ShowProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowProductDetailServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		String messageRate = request.getParameter("messageRate");
		System.out.println("messageRate  : " + messageRate);
	
		
		String productID = request.getParameter("productID");
		System.out.println("productID  : " + productID);
		
		String productGroupID = request.getParameter("productGroupID");
		System.out.println("productGroupID  : " + productGroupID);
		
		ShowProductDetailBO showProductDetailBO = new ShowProductDetailBO();
		
		Product productDetail = showProductDetailBO.getProductDetail(productID);
		request.setAttribute("productDetail", productDetail);
		System.out.println("servlet product= " + productDetail.getProductID());
		
		ArrayList<DanhgiaDTO> rate = showProductDetailBO.getRate(productGroupID);
		request.setAttribute("rate", rate);
		
		DanhgiaDTO star = showProductDetailBO.getStar(productGroupID);
		request.setAttribute("star", star);
		
		
		ProDTO productGroup = showProductDetailBO.getProductGroup(productGroupID);
		request.setAttribute("productGroup", productGroup);
		System.out.println("servlet productGroup= " + productGroup.getProductGroupName());
		
		ArrayList<Product> productList = showProductDetailBO.getProductist(productGroupID);
		request.setAttribute("productList", productList);
//		System.out.println("servlet productGroup= " + productGroup.getProductGroupName());
		
		
		
		
			
		RequestDispatcher rd = request.getRequestDispatcher("productDetail.jsp?messageRate=" + messageRate);
		rd.forward(request, response);
	}

}


