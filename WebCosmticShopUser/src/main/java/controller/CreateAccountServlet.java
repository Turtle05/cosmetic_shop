package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.CheckLoginBO;
import model.bo.CreateAccountBO;

public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final int EMPLOYEE_ACCOUNT = 1;

	public CreateAccountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("XIN CHÀO");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String confirmPassword = request.getParameter("confirmPassword");

		CreateAccountBO createAccountBO = new CreateAccountBO();
		String message = createAccountBO.createAccount(username, password, confirmPassword, fullname);

		RequestDispatcher rd = null;
		if ("No Error".equals(message)) {
			rd = request.getRequestDispatcher("login.jsp?error=3");
		} else if ("Duplicate ID Error".equals(message)) {
			rd = request.getRequestDispatcher("register.jsp?error=1");
		} else if ("Email Error".equals(message)) {
			rd = request.getRequestDispatcher("register.jsp?error=2");
		} else if ("Password Error".equals(message)) {
			rd = request.getRequestDispatcher("register.jsp?error=4");
		} else if ("Pass Error".equals(message)) {
			rd = request.getRequestDispatcher("register.jsp?error=5");
		} else if ("Double Email Error".equals(message)) {
			rd = request.getRequestDispatcher("register.jsp?error=6");
		} else {
			rd = request.getRequestDispatcher("register.jsp?error=0");
		}

			rd.forward(request, response);
	}

}
