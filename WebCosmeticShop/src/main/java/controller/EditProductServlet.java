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
import model.bo.EditProductBO;


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 10,  // 10MB
        maxRequestSize = 1024 * 1024 * 10 * 10 // 100MB
)
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BUCKET = "trihau.profile.image";
	private static final String URL = "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/";
	

	public EditProductServlet() {
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
        
		String[] imgOrigin = (String[])request.getParameterValues("imgOrigin");
		
        String[] img = new String[filenames.length];
        
    	for(int i=0; i<img.length; i++) {
    		if(filenames[i] != null && !filenames[i].isEmpty()) {
    			 img[i] = URL + filenames[i];
    			} else {
    		     img[i] = imgOrigin[i];	
    			}
    		System.out.println("img[" +i + "] : " + img[i]);
    	}
    	
        // In ra danh sách các tên tệp
        System.out.println("Danh sách các tên tệp:");
        for (String name : filenames) {
        	
            System.out.println(name);
        }
		
        RequestDispatcher rd = null;
		
		String productGroupID = request.getParameter("productGroupID");
		String nameProduct = request.getParameter("nameProduct");
		String brand = request.getParameter("brand");
		String cat = request.getParameter("cat");
		String des = request.getParameter("des");
		
		
		System.out.println("productGroupID: " + productGroupID);
	    System.out.println("nameProduct: " + nameProduct);
	    System.out.println("cat: " + cat);
	    System.out.println("des: " + des);
	    
	    
	    String[] productID = (String[])request.getParameterValues("productID");
		String[] size = (String[])request.getParameterValues("size");
		String[] price = (String[])request.getParameterValues("price");
		String[] quantity = (String[])request.getParameterValues("quantity");
		
		if (productID == null || productID.length == 0) {
            System.out.println("chuỗi null:");
            try {
                rd = request.getRequestDispatcher("ShowEditProductServlet?message=11");
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return; // Đảm bảo rằng phần còn lại của mã không được thực thi nếu productID không hợp lệ
        }
		
     

		System.out.println("length: " + productID.length);
		for(int j=0; j<productID.length; j++) {
			System.out.println("productID :  " + productID[j] );
			System.out.println("imgOrigin :  " + imgOrigin[j] );
			System.out.println("Size : "+ size[j] + ", Price: " + price[j] + ",Quantity " + quantity[j]);
		}
		
		
		
		EditProductBO  editProductBO = new EditProductBO();
		String returnedMessage = editProductBO.eidtProduct(productGroupID, nameProduct, brand, cat, des, productID, size, price, quantity, img, imgOrigin);
		
	
		
		
			System.out.println("returnedMessage : " + returnedMessage);
			
			
//			request.getRequestDispatcher("ShowCreateProductServlet");
	
	
	
	if ("No Error".equals(returnedMessage)) {
    	 // Thêm mới thành công

             rd = request.getRequestDispatcher("ShowEditProductServlet?message=5");// Thông báo tạo mới thành công        

     } else if ("Duplicate ID Error".equals(returnedMessage)) {
    	  // Lỗi trùng mã danh mục

             rd = request.getRequestDispatcher("ShowEditProductServlet?message=1"); // Lỗi trùng khóa

     } else if ("Required Fields Error".equals(returnedMessage)) {

         // Lỗi thiếu thông tin các field bắt buộc nhập

         rd = request.getRequestDispatcher("ShowEditProductServlet?message=2");
   
     }  else if ("Product Null".equals(returnedMessage)) {

         // Lỗi thiếu thông tin các field bắt buộc nhập

         rd = request.getRequestDispatcher("ShowEditProductServlet?message=3");
     }  else if ("Price Error".equals(returnedMessage)) {

         // Lỗi trùng username

         rd = request.getRequestDispatcher("ShowEditProductServlet?message=4");
         
     }  else if ("Quantity Error".equals(returnedMessage)) {

         // Lỗi trùng username

         rd = request.getRequestDispatcher("ShowEditProductServlet?message=6");
   
     }else {
    	// Lỗi không xác định
             rd = request.getRequestDispatcher("ShowEditProductServlet?message=0"); // Lỗi không xác định

     }
//	 rd = request.getRequestDispatcher("createCategory.jsp?message=5");
     rd.forward(request, response);

//			RequestDispatcher rd = request.getRequestDispatcher("ShowProductListServlet");
//			
//			rd.forward(request, response);

			

	}

//	}
}
