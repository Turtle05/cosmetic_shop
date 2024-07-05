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
import model.bo.EditEmployeeBO;



@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 10,  // 10MB
    maxRequestSize = 1024 * 1024 * 10 * 11
)


public class EditEmployeeServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	public EditEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

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
		
		String imgOrigin = request.getParameter("imgOrigin");
		System.out.println("imgnew = "+ filename);
		
		String imageEmployee = null;
		
		if(filename != null && !filename.isEmpty()) {
			imageEmployee = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/" + filename;
		} else {
			imageEmployee = imgOrigin;	
		}
		
		
		String employeeID = request.getParameter("userID"); 
		String fullName = request.getParameter("fullName");  
		String address = request.getParameter("address");           	   
		String phone = request.getParameter("phone");          	         
		String password = request.getParameter("password");
	
		
		
		
	

			System.out.println("employeeID= " + employeeID );
			System.out.println("fullName= " + fullName );
		



			EditEmployeeBO editEmployeeBO = new EditEmployeeBO();

			String returnedMessage = editEmployeeBO.editEmployee(employeeID, fullName, address, phone, password, imageEmployee);

			request.setAttribute("employeeID", employeeID);
			RequestDispatcher rd = null;

			if ("No Error".equals(returnedMessage)) {
	        	 // Sửa thành công

	                 rd = request.getRequestDispatcher("ShowEditEmployeeServlet?message=5");// Thông báo tạo mới thành công        


	         } else if ("Required Fields Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("editEmployee.jsp?message=2");
	       
	         }  else if ("Double Username Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("editEmployee.jsp?message=3");
	       
	         }else {
	        	// Lỗi không xác định
	                 rd = request.getRequestDispatcher("editEmployee.jsp?message=4"); // Lỗi không xác định

	         }

			rd.forward(request, response);

		}

//	}
}
