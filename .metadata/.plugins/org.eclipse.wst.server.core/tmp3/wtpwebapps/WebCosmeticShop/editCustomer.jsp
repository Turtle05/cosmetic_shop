<%@page import="model.bean.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

 
  <main id="main" class="main">

<% 
    Customer cus = (Customer)request.getAttribute("cus");
    if (cus == null) {
        cus = new Customer(); // Khởi tạo một đối tượng Customer mới nếu cus là null
    }
%> 

   	   
<% String customerID = request.getParameter(cus.getCustomerID()) != null ? cus.getCustomerID() : request.getParameter("customerID"); %>
<% String customerName = cus.getFullname() != null ? cus.getFullname() : request.getParameter("customerName"); %>
<% String address = cus.getAddress() != null ? cus.getAddress() : request.getParameter("address"); %>           	   
<% String phone = cus.getPhone() != null ? cus.getPhone() : request.getParameter("phone"); %>           	   
<% String email = cus.getEmail() != null ? cus.getEmail() : request.getParameter("email"); %>           	            	             	   
<% String password = cus.getPassword() != null ? cus.getPassword() : request.getParameter("password"); %>      	   



    <div class="pagetitle">
      <h1>Sửa thông tin khách hàng</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowEmployeeListServlet">Khách hàng</a></li>
          <li class="breadcrumb-item active">Sửa thông tin khách hàng</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
					<p class="text-center small" style="color: red;" >
                         <% String error = request.getParameter("message"); %>
            	         <%=("1".equals(error)) ? "Lỗi trùng mã danh mục!" : "" %>
            	         <%=("2".equals(error)) ? "Lỗi chưa nhập đầy đủ thông tin!" : "" %>
            	         <%=("3".equals(error))?"Tên đăng nhập đã được sử dụng, vui lòng nhập tên đăng nhập khác!":"" %>
            	         <%=("4".equals(error))?"Lỗi không xác định":"" %>
					</p>


		<section class="section">
			<div class="row">      
				<div class="col-lg-12">

			

          <div class="card">
            <div class="card-body">
              <br>
           
                   <form enctype="multipart/form-data" action="EditCustomerServlet">
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Mã khách hàng</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="" type="text" class="form-control" id="fullName" value="<%=customerID%>" disabled>
                        <input name="customerID" type="hidden" class="form-control" id="" value="<%=customerID%>">
                      </div>
                    </div>
               
               
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Họ và tên</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="customerName" type="text" class="form-control" id="fullName" value="<%=customerName%>">
                      </div>
                    </div>

                  
                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Địa chỉ</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" id="Address" value="<%=address%>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Số điện thoại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" id="Phone" value =<%=phone%>>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="email" class="form-control" id="Email" value="<%=email%>"  disabled>
                      </div>
                    </div>

                    
                     <div class="row mb-3">
                      <label for="yourPassword" class="col-md-4 col-lg-3 col-form-label">Mật khẩu</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="password" type="password" class="form-control" id="yourPassword" value="<%=password%>">
                      </div>
                    </div>

  			
                
                    <div class="text-center">
                      <!-- <button type="submit" class="btn btn-primary">Sửa</button>
                      <button type="reset" class="btn btn-secondary">Hủy</button> -->
                      <%-- <input class="btn btn-secondary"
													type="button"
													onclick="location.href='ShowEditCustomerServlet?customerID=<%=customerID%>';"
													value="Hủy" /> --%>
                    </div>
                  </form><!-- End Profile Edit Form --> 

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">

                
                </div>

                <div class="tab-pane fade pt-3" id="profile-change-password">


            </div>
          </div>

        </div>

        
			</div>
		</section>

	</main><!-- End #main -->
</body>	  
	  

  <!-- Template Main JS File -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
  <script src="assets/js/main.js"></script>
  

  </html>