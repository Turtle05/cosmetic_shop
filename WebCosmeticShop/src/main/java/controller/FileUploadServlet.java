package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import common.S3Util;
import model.bo.EditProfileBO;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 10,  // 10MB
		maxRequestSize = 1024 * 1024 * 10 * 11)

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String BUCKET = "trihau.profile.image";
	final String URL = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/";
    
    public FileUploadServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String description = request.getParameter("description");
	
	System.out.println("description : " + description);
	
	
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
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	String imgOrigin = request.getParameter("imgOrigin");
	String imgNew = filename;
	System.out.println("imgnew = "+ imgNew);
	
	String img = null;
	
	if(filename != null && !filename.isEmpty()) {
	 img = URL + filename;
	} else {
     img = imgOrigin;	
	}
	
	EditProfileBO editProfileBO = new EditProfileBO();

	String returnedMessage = editProfileBO.editProfileImage(username, img);

	RequestDispatcher rd = null;

	if ("No Error".equals(returnedMessage)) {
    	 // Sửa thông tin thành công

             rd = request.getRequestDispatcher("ShowProfileServlet?message1=5");// Thông báo tạo mới thành công        


     } else if ("Required Fields Error".equals(returnedMessage)) {

         // Lỗi thiếu thông tin các field bắt buộc nhập

         rd = request.getRequestDispatcher("ShowProfileServlet?message1=2");
   
   
     }else {
    	// Lỗi không xác định
             rd = request.getRequestDispatcher("ShowProfileServlet?message1=4"); // Lỗi không xác định

     }

	rd.forward(request, response);
	
	
	/*
	 * request.setAttribute("message", message);
	 * request.getRequestDispatcher("result.jsp").forward(request, response);
	 */
	}
	
	
	
	
}
