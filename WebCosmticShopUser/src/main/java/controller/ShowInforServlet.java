package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Customer;
import model.bo.ShowInforBO;

public class ShowInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowInforServlet() {
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
		
		
		
		ShowInforBO showInforBO = new ShowInforBO();
		
		Customer infor = showInforBO.getInfor(customerID );
		
		
		request.setAttribute("infor", infor);
			
		RequestDispatcher rd = request.getRequestDispatcher("infor.jsp");
		rd.forward(request, response);
	}

}
