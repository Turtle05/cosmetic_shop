<%@page import="model.bean.Category"%>
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

 <% String error1 = request.getParameter("message"); %>
                              	    <% if ("1".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("2".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("3".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("4".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("0".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("6".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("7".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("8".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("9".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
<% String fullName = request.getParameter("fullName") != null ? request.getParameter("fullName") : ""; %>
<% String address = request.getParameter("address") != null ? request.getParameter("address") : ""; %>           	   
<% String phone = request.getParameter("phone") != null ? request.getParameter("phone") : ""; %>           	   
<% String email = request.getParameter("email") != null ? request.getParameter("email") : ""; %>           	          	             	   
<% String password = request.getParameter("password") != null ? request.getParameter("password") : ""; %>
<% String confirmpassword = request.getParameter("password") != null ? request.getParameter("confirmpassword") : ""; %>
  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Thêm nhân viên</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowEmployeeListServlet">Nhân viên</a></li>
          <li class="breadcrumb-item active">Thêm nhân viên</li>
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
                  <form enctype="multipart/form-data" action="CreateEmployeeServlet" method="post">
               <div class="row mb-3">
    				<label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Ảnh</label>
    					<div class="col-md-8 col-lg-9 profile">
        				<img id="myimage" src="" alt="Image"/><br>
        				<label for="inputImage" class="upload-label">
          				  <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60" hidden /> <!-- Ẩn input -->
          				  <span class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></span> <!-- Hiển thị nút upload -->
        				</label>
        				<a id="removeImage" href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a>
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
                        <input name="email" type="email" class="form-control" id="email" value='<%=email%>'>
                      </div>
                    </div>

                    
                     <div class="row mb-3">
                      <label  class="col-md-4 col-lg-3 col-form-label">Mật khẩu</label>
                      <div class="col-md-8 col-lg-9">
                      <div class="password-wrapper">
                        <input name="password" id="password" type="password" class="form-control" value='<%=password%>'>
        				<span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
        				</div>
                      </div>
                    </div>
                    
                    <div class="row mb-3">
                      <label  class="col-md-4 col-lg-3 col-form-label">Xác nhận mật khẩu</label>
                      <div class="col-md-8 col-lg-9">
                       <div class="password-wrapper">
                        <input name="confirmpassword" type="password" class="form-control" id="password2" value='<%=confirmpassword%>'>
                        <span class="toggle-password2" onclick="togglePasswordVisibility2()">👁️</span>
                        </div>
                        </div>
                    </div>

  			
                
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Tạo</button>
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
document.addEventListener('DOMContentLoaded', function() {
    const showAlertMessage = (message) => {
        const alertElement = document.getElementById('thongbao');
        alertElement.textContent = message;
        alertElement.classList.remove('hidden');
        alertElement.classList.add('show');

        setTimeout(() => {
            alertElement.classList.remove('show');
            setTimeout(() => {
                alertElement.classList.add('hidden');
            }, 500); // Thời gian khớp với thời gian của transition
        }, 1500); // Hiển thị thông báo trong 1,5 giây
    };
    <% if ("0".equals(error1)) { %>showAlertMessage('Lỗi ko xác định!');<% } %>
    <% if ("1".equals(error1)) { %>showAlertMessage('Lỗi trùng khóa');<% } %>
    <% if ("2".equals(error1)) { %>showAlertMessage('Thiếu thông tin!');<% } %>
    <% if ("3".equals(error1)) { %>showAlertMessage('Lỗi trùng email!');<% } %>
    <% if ("4".equals(error1)) { %>showAlertMessage('Xác nhận mật khẩu sai!');<% } %>
    <% if ("6".equals(error1)) { %>showAlertMessage('Mật khẩu phải 8 kí tự trở lên, ít nhất 1 ký tự hoa và 1 số');<% } %>
    <% if ("7".equals(error1)) { %>showAlertMessage('Số điện thoại không hợp lệ');<% } %>
    <% if ("8".equals(error1)) { %>showAlertMessage('Email không hợp lệ!');<% } %>
    
    
 
});
</script>
  
  
     <script>
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('password');
            const togglePassword = document.querySelector('.toggle-password');
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            togglePassword.textContent = type === 'password' ? '👁️' : '🙈';
        }
    </script>
     <script>
        function togglePasswordVisibility2() {
            const passwordInput = document.getElementById('password2');
            const togglePassword = document.querySelector('.toggle-password2');
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            togglePassword.textContent = type === 'password' ? '👁️' : '🙈';
        }
    </script>
  
  
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
        $("#myimage").attr("src", "");
        // Xóa giá trị của input file
        $("#inputImage").val('');
    }

	</script>  

  </html>