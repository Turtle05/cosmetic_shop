<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Đăng nhập</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logof.jpg" rel="icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">


</head>

<body>
					<% String error = request.getParameter("error"); %>
<!-- 	<div class="row">
		<div class="col-lg-3">
			<div class="alert alert-info alert-dismissible fade show" role="alert">
				A simple info alert—check it out!
				<button
					type="button"
					class="btn-close"
					data-bs-dismiss="alert"
					aria-label="Close"
				></button>
			</div>
		</div>
	</div> -->

	<main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="loginAdmin.jsp" class="logoAdmin d-flex align-items-center w-auto">
                  <img class="logo-admin" src="https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logo.jpg" alt=""> 
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">ĐĂNG NHẬP</h5>
                    		<p class="text-center small" style="color: red;" >
                   				 <%=("1".equals(error)) ? "Bạn đã đăng xuất, mời bạn đăng nhập lại!" : "" %>
								<%=("2".equals(error)) ? "Thông tin đăng nhập không đúng!" : "" %>
							</p>
                  </div>
                  
                 <% String userName = request.getParameter("userName") != null ? request.getParameter("userName") : ""; %>
				<% String password = request.getParameter("userName") != null ? request.getParameter("password") : ""; %>  

                  <form  action="checkLoginAdminServlet" class="row g-3 needs-validation"  method ="post">
                    <div class="col-12">
                      <label for="yourName" class="form-label">Tên đăng nhập</label>
                      <input type="text" name="userName" class="form-control" id="yourName"  value="<%=userName%>"required>
                      <div class="invalid-feedback">Nhập tên đăng nhập!</div>
                    </div>

                  

                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Mật khẩu</label>
                       <div class="password-wrapper">
                      <input type="password" name="password" class="form-control" id="password" value="<%=password%>" required>
                      <span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
                      </div>
                      <div class="invalid-feedback">Nhập mật khẩu!</div>
                    </div>
                    	<div>
                    	</div>
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Đăng nhập</button>
                    </div>
                    <div class="col-12">
                      <p class="small mb-0"></p>
                    </div>
                  </form>

                </div>
              </div>
            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- <!-- Vendor JS Files -->
  <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/chart.js/chart.umd.js"></script>
  <script src="assets/vendor/echarts/echarts.min.js"></script>
  <script src="assets/vendor/quill/quill.js"></script>
  <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script> 

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
<script>
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('password');
            const togglePassword = document.querySelector('.toggle-password');
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            togglePassword.textContent = type === 'password' ? '👁️' : '🙈';
        }
    </script>
</body>

</html>
