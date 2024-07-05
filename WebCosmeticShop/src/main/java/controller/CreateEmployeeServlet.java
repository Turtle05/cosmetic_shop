package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.S3Util;
import model.bo.CreateCustomerBO;
import model.bo.CreateEmployeeBO;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1MB
	    maxFileSize = 1024 * 1024 * 10,  // 10MB
	    maxRequestSize = 1024 * 1024 * 10 * 11
	)


public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateEmployeeServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {
		final String BUCKET = "trihau.profile.image";
		Part part = request.getPart("file");
		
		String filename = S3Util.getFileName(part);
		System.out.println("filename : "+ filename);
		
		String message = "";
		if(filename != null && !filename.isEmpty()) {
			try {
				S3Util.uploadFile(BUCKET, filename, part.getInputStream());
				message = "Successfull";
			} catch (Exception ex) {
				ex.printStackTrace();
				message = "Error!";
			}
		}
		

		String fullName = request.getParameter("fullName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String image = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/" + filename;
		

		CreateEmployeeBO  createEmployeeBO = new CreateEmployeeBO();
		String returnedMessage = createEmployeeBO.createEmployee(fullName,address, phone, email, password, confirmpassword, image);
		
		System.out.println("fullName : " + fullName);
		 RequestDispatcher rd = null;

         if ("No Error".equals(returnedMessage)) {
        	 // Thêm mới thành công

                 rd = request.getRequestDispatcher("ShowEmployeeListServlet?message1=5");// Thông báo tạo mới thành công        

         } else if ("Duplicate ID Error".equals(returnedMessage)) {
        	  // Lỗi trùng mã danh mục

                 rd = request.getRequestDispatcher("addEmployee.jsp?message=1"); // Lỗi trùng khóa

         } else if ("Required Fields Error".equals(returnedMessage)) {

             // Lỗi thiếu thông tin các field bắt buộc nhập

             rd = request.getRequestDispatcher("addEmployee.jsp?message=2");
       
         }  else if ("Double Username Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("addEmployee.jsp?message=3");
             
         }  else if ("Pass Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("addEmployee.jsp?message=4");
             
         }  else if ("Password Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("addEmployee.jsp?message=6");
             
         }  else if ("Phone Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("addEmployee.jsp?message=7");
         }  else if ("Email Error".equals(returnedMessage)) {

             // Lỗi trùng username

             rd = request.getRequestDispatcher("addEmployee.jsp?message=8");
       
         }else {
        	// Lỗi không xác định
                 rd = request.getRequestDispatcher("addEmployee.jsp?message=0"); // Lỗi không xác định

         }
//		 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
         rd.forward(request, response);
         
		}
	
	
	
//	}

}
