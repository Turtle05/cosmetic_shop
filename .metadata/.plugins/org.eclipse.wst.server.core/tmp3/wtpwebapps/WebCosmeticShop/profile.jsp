<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<head>
<title>Thông tin cá nhân</title>
  <link href="https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logof.jpg" rel="icon">
</head>
<%@page import="model.bean.Employee"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<html>



<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

    




<%Employee profile = (Employee) request.getAttribute("profile"); %>
<%String fileName = (String)request.getAttribute("fileName");%>
  <main id="main" class="main">
 <% String error = request.getParameter("message"); %>
            		<%=("1".equals(error)) ?"Thay đổi mật khẩu thành công!" : "" %>
            	   <%=("2".equals(error)) ?"Lỗi thiếu thông tin các field bắt buộc nhập!" : "" %>
            	   <%=("3".equals(error))?"Mật khẩu cũ không đúng!":"" %>
            	   <%=("4".equals(error))?"Mật khẩu xác nhận và mật khẩu mới không trùng khớp!":"" %>
            	   <%=("5".equals(error))?"Lỗi không xác định!":"" %>
            	   <%=("6".equals(error))?"Mật khẩu dài ít nhất 8 kí tự, ít nhất 1 chữ hoa và 1 số!":"" %>
            	   
 <% String error1 = request.getParameter("message1"); %>
            		<%=("5".equals(error1)) ?"Thay đổi thông tin thành công!" : "" %>
            	   <%=("2".equals(error1)) ?"Lỗi thiếu thông tin bắt buộc nhập!" : "" %>
            	   <%=("4".equals(error1))?"Lỗi không xác định!":"" %> 
            	   <%=("10".equals(error1))?"Số điện thoại không hợp lệ!":"" %> 
            	    
    <div class="pagetitle">
      <h1>Thông tin cá nhân</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Thông tin cá nhân</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->




    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src='<%=profile.getImage()%>' alt="Profile" class="rounded-circle">
              <h2><%=profile.getFullName() %></h2>
              <%if(("admin".equals(profile.getRole())) || ("admin1".equals(profile.getRole())) ) {%>
              <h3>Admin</h3>
              <%}else { %>
              <h3>Nhân viên</h3>
               <% } %>
              <div class="social-links mt-2">
               <%--  <a href="<%=profile.getFb() %>" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="<%=profile.getFb() %>" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="<%=profile.getFb() %>" class="linkedin"><i class="bi bi-linkedin"></i></a> --%>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Tổng quan</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Chỉnh sửa</button>
                </li>

            

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Đổi mật khẩu</button>
                </li>

              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                  
                  <h5 class="card-title">Thông tin cá nhân</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Họ và tên</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getFullName() %></div>
                  </div>
   					

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Địa chỉ</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getAddress()%></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Số điện thoại</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getPhone() %></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getEmail() %></div>
                  </div>

                </div>
                
                
				<!-- Start edit div -->
                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                    <!-- Profile Edit Form -->
          
            
               
				<%-- <div class="row mb-3">
    				<label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Ảnh</label>
    					<div class="col-md-8 col-lg-9 profile">
       						 <img id="myimage" src='<%=profile.getImage()%>' alt="Image"/><br>
       					 <label for="inputImage" class="upload-label">
            			<input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60"  /> <!-- Ẩn input -->
            			<span class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></span> <!-- Hiển thị nút upload -->
        			</label>
        				<a id="removeImage" href="#" class="btn btn-danger btn-sm" title="Remove my profile image" ><i class="bi bi-trash"></i></a>
        			
   					 </div>
				</div> --%>
				
				<div class="row mb-3">
    				<label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Ảnh</label>
    					<div class="col-md-8 col-lg-9 profile">
       						 <img src='<%=profile.getImage()%>' alt="Image"/><br>
       					 
        			<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#uploadModal">Thay đổi ảnh</button>
   					 </div>
				</div>


<!-- Modal -->
<div class="modal fade" id="uploadModal" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="uploadModalLabel">Thay đổi ảnh đại diện</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                      
                            <div class="col-md-8 col-lg-9 profile">
                                <img id="myimage"  src='<%=profile.getImage()%>'  class='myImage123'/><br>
                                <input type = "hidden" name ="imgOrigin" value='<%=profile.getImage()%>'/>
                                <div class="upload-container">
                                    <label for="inputImage" class="upload-label" class="d-flex justify-content-center align-items-center">
                                        <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60" /> <!-- Ẩn input -->
                                        <span class="btn btn-primary btn-sm" title="Upload new profile image"><i class="bi bi-upload"></i></span> <!-- Hiển thị nút upload -->
                                    </label>
                                    <label class="remove-label"  class="d-flex justify-content-center align-items-center">
                                        <a id="removeImage" href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="bi bi-trash"></i></a> <!-- Move remove button here -->
                                    </label>
                                </div>
                            </div>
                        
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary btn-sm">Lưu</button>
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Hủy</button>
                </div>
            </form>
        </div>
    </div>
</div>
              				  
   <form action="EditProfileServlet" enctype="multipart/form-data" >
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Họ và tên</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="fullName" type="text" class="form-control" id="fullName" value="<%=profile.getFullName() %>">
                        <input name="id" type="hidden" value="<%=profile.getEmployeeID()%>">
                        <input name="username" type="hidden"  value="<%=profile.getUsername()%>">
                      </div>
                    </div>

                
    		
    
                    <div class="row mb-3">
                      <label for="Address" class="col-md-4 col-lg-3 col-form-label">Địa chỉ</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" id="Address" value="<%=profile.getAddress() %>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Số điện thoại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" id="Phone" value="<%=profile.getPhone() %>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="email" class="form-control" id="Email" value="<%=profile.getEmail() %>">
                      </div>
                    </div>

            
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Lưu</button>
                      <button type="reset" class="btn btn-secondary">Hủy</button>
                    </div>
                    
                   </form> 
                 <!-- End Profile Edit Form -->

                </div>

                <div class="tab-pane fade pt-3" id="profile-settings">

                
                </div>

                <div class="tab-pane fade pt-3" id="profile-change-password">
                  <!-- Change Password Form -->
                  <form action = "ChangePasswordServlet" method ="post">

                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Mật khẩu cũ</label>
                      <div class="col-md-8 col-lg-9">
                      <div class="password-wrapper">
                        <input name="pass" type="password" class="form-control" id="password">
                        <span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">Mật khẩu mới</label>
                      <div class="col-md-8 col-lg-9">
                      <div class="password-wrapper">
                        <input name="newpassword" type="password" class="form-control" id="password2">
                        <span class="toggle-password2" onclick="togglePasswordVisibility2()">👁️</span>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Xác nhận mật khẩu</label>
                      <div class="col-md-8 col-lg-9">
                      <div class="password-wrapper">
                        <input name="renewpassword" type="password" class="form-control" id="password3">
                        <span class="toggle-password3" onclick="togglePasswordVisibility3()">👁️</span>
                        </div>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Đổi mật khẩu</button>
                    </div>
                  </form><!-- End Change Password Form -->

                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>


  </main><!-- End #main -->
</body>





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
        $("#myimage").attr("src", "<%=profile.getImage()%>");
        // Xóa giá trị của input file
        $("#inputImage").val('');
    }

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
        function togglePasswordVisibility3() {
            const passwordInput = document.getElementById('password3');
            const togglePassword = document.querySelector('.toggle-password3');
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            togglePassword.textContent = type === 'password' ? '👁️' : '🙈';
        }
    </script>
</html>
  

