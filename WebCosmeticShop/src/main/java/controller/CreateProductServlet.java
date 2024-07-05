package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.S3Util;
import model.bo.CreateProductBO;


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 10,  // 10MB
        maxRequestSize = 1024 * 1024 * 10 * 10 // 100MB
)
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BUCKET = "trihau.profile.image";
	private static final String URL = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/";
	

	public CreateProductServlet() {
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

		ArrayList<String> tempFilenames = new ArrayList<>();
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if (part.getName().startsWith("file")) {
                String filename = S3Util.getFileName(part);
                tempFilenames.add(filename);
                if (filename != null && !filename.isEmpty()) {
                    try {
                        S3Util.uploadFile(BUCKET, filename, part.getInputStream());
                        System.out.println("filename: "+ filename);
                       
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        
                    }
                }
            }
        }
        

        String[] filenames = new String[tempFilenames.size()];
        tempFilenames.toArray(filenames);
        
        String[] img = new String[filenames.length];
    	for(int i=0; i<img.length; i++) {
    		img[i] = URL + filenames[i];
    	}
    	
    	
        // In ra danh sách các tên tệp
        System.out.println("Danh sách các tên tệp:");
        for (String name : filenames) {
            System.out.println(name);
        }
		
		String nameProduct = request.getParameter("nameProduct");
		String catID = request.getParameter("cat");
		String brandID = request.getParameter("brand");
		String des = request.getParameter("des");
		
		/* String manual = request.getParameter("manual"); */
		
		String[] size = (String[])request.getParameterValues("size");
		String[] price = (String[])request.getParameterValues("price");
		String[] quantity = (String[])request.getParameterValues("quantity");
		
		for(int j=0; j<size.length; j++) {
			System.out.println("Size : "+ size[j] + ", Price: " + price[j] + ",Quantity " + quantity[j]);
		}
		
		
		
		CreateProductBO  createProductBO = new CreateProductBO();
		String returnedMessage = createProductBO.createProduct(nameProduct, catID, des,brandID, size, price, quantity, img);
		
		System.out.println("nameProduct : " + nameProduct);
		
		
			System.out.println("returnedMessage : " + returnedMessage);

		
			RequestDispatcher rd = null;
//					request.getRequestDispatcher("ShowCreateProductServlet");
			
			
			
			if ("No Error".equals(returnedMessage)) {
	        	 // Thêm mới thành công

	                 rd = request.getRequestDispatcher("ShowProductListServlet?message1=5");// Thông báo tạo mới thành công        

	         } else if ("Duplicate ID Error".equals(returnedMessage)) {
	        	  // Lỗi trùng mã danh mục

	                 rd = request.getRequestDispatcher("ShowCreateProductServlet?message=1"); // Lỗi trùng khóa

	         } else if ("Required Fields Error".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("ShowCreateProductServlet?message=2");
	       
	         }  else if ("Product Null".equals(returnedMessage)) {

	             // Lỗi thiếu thông tin các field bắt buộc nhập

	             rd = request.getRequestDispatcher("ShowCreateProductServlet?message=3");
	         }  else if ("Price Error".equals(returnedMessage)) {

	             // Lỗi trùng username

	             rd = request.getRequestDispatcher("ShowCreateProductServlet?message=4");
	             
	         }  else if ("Quantity Error".equals(returnedMessage)) {

	             // Lỗi trùng username

	             rd = request.getRequestDispatcher("ShowCreateProductServlet?message=6");
	       
	         }else {
	        	// Lỗi không xác định
	                 rd = request.getRequestDispatcher("ShowCreateProductServlet?message=0"); // Lỗi không xác định

	         }
//			 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
	         rd.forward(request, response);
	         
			}

			

	

//	}
}
