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
import model.bo.EditBrandBO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 10 * 11)

public class EditBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBrandServlet() {
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

//		HttpSession session = request.getSession();
//		if (session.getAttribute("accountInfor") == null) {
//			response.sendRedirect("login.jsp?error=1");
//		} else {
		final String BUCKET = "trihau.profile.image";
		Part part = request.getPart("file");

		String filename = getFileName(part);
		System.out.println("filename : " + filename);

		String message = "";
		if(filename != null) {
		try {
			S3Util.uploadFile(BUCKET, filename, part.getInputStream());
			message = "Successfull";
		} catch (Exception ex) {
			ex.printStackTrace();
			message = "Error!";
		}
}
		String brandID = request.getParameter("brandID");
		String brandName = request.getParameter("brandName");
		String nation = request.getParameter("brandOrigin");
		String imgOrigin = request.getParameter("imgOrigin");
		
		String img = null;
		if(filename != null && !filename.isEmpty()) {
			 img = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/" + filename;
			} else {
		     img = imgOrigin;	
			}
		
		
		System.out.println("brandID : " + brandID);
		System.out.println("name : " + brandName + " " + nation + " " + img);

		EditBrandBO editBrandBO = new EditBrandBO();
		String returnedMessage = editBrandBO.editBrand(brandID, brandName, nation, img);

		RequestDispatcher rd = null;

		if ("No Error".equals(returnedMessage)) {
			// Thêm mới thành công

			rd = request.getRequestDispatcher("ShowBrandListServlet?message1=3");// Thông báo tạo mới thành công

		} else if ("Duplicate ID Error".equals(returnedMessage)) {
			// Lỗi trùng mã danh mục

			rd = request.getRequestDispatcher("ShowBrandListServlet?message1=1"); // Lỗi trùng khóa

		} else if ("Required Fields Error".equals(returnedMessage)) {

			// Lỗi thiếu thông tin các field bắt buộc nhập

			rd = request.getRequestDispatcher("ShowBrandListServlet?message1=2");

		} else {
			// Lỗi không xác định
			rd = request.getRequestDispatcher("ShowBrandListServlet?message1=4"); // Lỗi không xác định

		}
//		 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
		rd.forward(request, response);

	}

//	}

	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		int beginIndex = contentDisposition.indexOf("filename") + 10;
		int endIndex = contentDisposition.length() - 1;

		return contentDisposition.substring(beginIndex, endIndex);
	}

}