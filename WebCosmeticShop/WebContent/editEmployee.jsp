<%@page import="java.io.ObjectInputStream.GetField"%>
<%@page import="model.bean.User"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.profile img {
    max-width: 120px;
}</style>

<html>

<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<% 
    User em = (User)request.getAttribute("em");
    if (em == null) {
        em = new User(); // Khởi tạo một đối tượng Customer mới nếu cus là null
    }
%> 
 
            	   
<% String employeeID = em.getUserID() != null ? em.getUserID() : request.getParameter("userID"); %>
<% String fullName = em.getFullName() != null ? em.getFullName() : request.getParameter("fullName"); %>
<% String address = em.getAddress() != null ? em.getAddress() : request.getParameter("address"); %>           	   
<% String phone = em.getPhone() != null ? em.getPhone() : request.getParameter("phone"); %>           	   
<% String email = em.getEmail() != null ? em.getEmail() : request.getParameter("email"); %>           	            	             	            	             	   
<% String password = em.getPassword() != null ? em.getPassword() : request.getParameter("password"); %>  
<% String imageEmployee = em.getImage() != null ? em.getImage() : request.getParameter("imageEmployee"); %>  


  <main id="main" class="main">
<% String error = request.getParameter("message"); %>
                    <%-- <%=("5".equals(error)) ? "Thêm mới danh mục thành công!" : "" %> --%>
            		<%=("1".equals(error)) ? "Lỗi trùng mã danh mục!" : "" %>
            	   <%=("2".equals(error)) ? "Lỗi chưa nhập đầy đủ !" : "" %>
            	   <%=("3".equals(error))?"Tên đăng nhập đã được sử dụng, vui lòng nhập tên đăng nhập khác!":"" %>
            	   <%=("4".equals(error))?"Lỗi không xác định":"" %>
    <div class="pagetitle">
      <h1>Sửa thông tin nhân viên</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowEmployeeListServlet">Nhân viên</a></li>
          <li class="breadcrumb-item active">Sửa thông tin nhân viên</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

			

          <div class="card">
            <div class="card-body">
              <br>

               <!-- Profile Edit Form -->
                  <form enctype="multipart/form-data" action="EditEmployeeServlet" method="post">
               <div class="row mb-3">
    				<label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Ảnh</label>
    					<div class="col-md-8 col-lg-9 profile">
        				<input value='<%=imageEmployee%>'  type ="hidden" name='imgOrigin'/><br>
        				<img id="myimage" src="<%=imageEmployee%>" alt="Image"/><br>
        				<label for="inputImage" class="upload-label">
          				  <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60"   /> <!-- Ẩn input -->
          				  <span class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></span> <!-- Hiển thị nút upload -->
        				</label>
        				<a id="removeImage" href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
    					</div>
					</div>
					
					<div class="row mb-3">
                      <label for="id" class="col-md-4 col-lg-3 col-form-label">Mã nhân viên</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="" type="text" class="form-control" id="" value='<%=employeeID%>' disabled>
                        <input name="userID" type="hidden" class="form-control" id="id" value='<%=employeeID%>' >
                      </div>
                    </div>
                    
                    
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Họ và tên</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="fullName" type="text" class="form-control" id="fullName" value='<%=fullName%>'>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Địa chỉ</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" id="Address" value='<%=address%>' >
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Số điện thoại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" id="Phone"  value='<%=phone%>'>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="email" class="form-control" id="email" value='<%=email%>' disabed>
                      </div>
                    </div>

                    
                     <div class="row mb-3">
                      <label for="Linkedin" class="col-md-4 col-lg-3 col-form-label">Mật khẩu</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="password" type="password" class="form-control" id="" value="<%=password%>">
                      </div>
                    </div>

  			
                
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Sửa</button>
                      <button type="reset" class="btn btn-secondary">Hủy</button>
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
  
  	<script>
    
    $(document).ready(function() {
        $("#inputImage").change(function() {
            showImage(this);
        });
        
        $("#removeImage").click(function() {
            resetImage();
        });
    });

    function showImage(fileInput) {
        const file = fileInput.files[0];
        const reader = new FileReader();
        reader.onload = function(e) {
            $("#myimage").attr("src", e.target.result);
        };
        reader.readAsDataURL(file);
    }

    function resetImage() {
        // Sử dụng đường dẫn mặc định hoặc thực hiện các hành động cần thiết để reset ảnh
        $("#myimage").attr("src", "<%=imageEmployee%>");
        // Xóa giá trị của input file
        $("#inputImage").val('');
    }

	</script>  

  </html>