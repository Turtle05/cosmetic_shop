package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bo.AddToCartBO;

public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self'; style-src 'self' 'https://cdnjs.cloudflare.com';");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object accountInfor = session.getAttribute("accountInfor");
		if (accountInfor == null) {
		    System.out.println("Account information is null, redirecting to login.jsp");
		    response.getWriter().write("not_logged_in");
		    response.sendRedirect("login.jsp");
		    return; // Thêm return để đảm bảo không có hành động nào khác được thực hiện
		} else {
		    System.out.println("Account information: " + accountInfor);
		}

//		HttpSession session = request.getSession();
//		 if (session.getAttribute("accountInfor") == null) {
//	            response.sendRedirect("login.jsp");
//	            return; // Thêm return để đảm bảo không có hành động nào khác được thực hiện
//	        }

			String customerID = (String) session.getAttribute("cusID");
			String productID = (String)request.getParameter("proID");

			String quantity = "1";
			if (request.getParameter("Quantity") != null && !request.getParameter("Quantity").isEmpty()) {
				quantity = request.getParameter("Quantity");
			}
			System.out.println("customerID: " + customerID);
			System.out.println("productID: " + productID);
			System.out.println("quantity: " + quantity);

			

			try {
				AddToCartBO addToCartBO = new AddToCartBO();
				String returnedMessage = addToCartBO.insertCart(customerID, productID, quantity);
				System.out.println("returnedMessage: "+returnedMessage);
				
				// Kiểm tra xem có phải là yêu cầu AJAX không
				if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
				    response.setContentType("text/plain");
				    
				    if ("No Error".equals(returnedMessage)) {
				        response.getWriter().write("success");
				    } else {
				        response.getWriter().write("error");
				    }
				}
//            else {
//                // Dự phòng cho các yêu cầu không phải AJAX
//                if ("No Error".equals(returnedMessage)) {
//                    request.getRequestDispatcher("ShowProductDetailServlet?message=1").forward(request, response);
//                } else {
//                    request.getRequestDispatcher("ShowProductDetailServlet?message=0").forward(request, response);
//                }
//            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}

