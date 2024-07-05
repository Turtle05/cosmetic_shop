<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<style>
  .password-container .toggle-password {
            .password-container .toggle-password {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }
        }
        
  .password-wrapper {
        display: flex;
        align-items: center;
        position: relative;
       
    }

    .password-wrapper input[type="password"],
    .password-wrapper input[type="text"] {
        padding-right: 30px; /* Đảm bảo chỗ trống cho biểu tượng */
    }
	.toggle-password2,
    .toggle-password {
        position: absolute;
        right: 10px; /* Đặt biểu tượng bên phải */
        cursor: pointer;
        margin-bottom: 20px;
    }
    .thongbao{
    color: red !important;
    font-size: 14px;
    margin: 0;
    }
    
</style>

<% String error = request.getParameter("error"); %>
<body>


    <header>
        <div class="header-left">
            <img src="logo.jpg" alt="Logo" class="logo">
        </div>
        <div class="header-center">
            <nav>
                <ul>
                    <li><a href="home.html">Trang chủ</a></li>
                    <li><a href="product.html">Sản phẩm</a></li>
                    <li><a href="#">Thương hiệu</a></li>
                </ul>
            </nav>
            <div class="search-bar">
                <input type="text" class="search-input" placeholder="Tìm kiếm...">

                <button><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </div>
        <div class="header-right">

            <div class="cart">
                <a href="#"><i class="fa-solid fa-cart-shopping"></i></a>
            </div>

            <div class="account">
                <a href="#" title="Tài khoản"><i class="fa-solid fa-user"></i></a>
            </div>

        </div>
    </header>
<% String fullname = request.getParameter("fullname") != null ? request.getParameter("fullname") : ""; %>           	   
<% String username = request.getParameter("username") != null ? request.getParameter("username") : ""; %>           	   
<% String password = request.getParameter("password") != null ? request.getParameter("password") : ""; %>
<% String confirmPassword = request.getParameter("confirmPassword") != null ? request.getParameter("confirmPassword") : ""; %>
    <div class="sub-header">
        <div class="breadcrumb">
            <a href="#">Trang chủ</a> / <span>Đăng ký</span>
        </div>

    </div>


    <div class="register-container">
        <div class="form-container">
            <form class="registration-form" action="CreateAccountServlet" method="post">
                <h2>ĐĂNG KÝ</h2>
                
                <%if("1".equals(error)){ %>
               <div class="p-register"><p style="color: red;">Đăng ký thất bại, lỗi ở server!</p></div>
                 <%} else if("0".equals(error)) { %>
                <div class="p-register"><p style="color: red;">Đăng ký thất bại, lỗi ở server!</p></div>
                <%} else { %>
                 <div class="p-register"><p>Nhập thông tin cá nhân để tạo tài khoản</p></div>
                <%}%>
                
                <label for="name">Họ và tên</label>
                <input type="text" id="name" name="fullname" value="<%=fullname%>" required>

                <label for="email">Email</label>
                <input type="email" id="email" name="username"  value="<%=username %>" required>
                <%if("2".equals(error)) { %>
                <p class="thongbao">Email không hợp lệ!</p><%} %>
                <%if("6".equals(error)) { %>
              <p class="thongbao" >Email đã tồn tại!</p><%} %>


                <label for="password">Mật khẩu</label>
                <div class="password-wrapper">
                <input type="password" id="password" name="password"  value="<%=password%>" required>
                <span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
                 
                </div>
                <%if("4".equals(error)) { %>
               <p class="thongbao">Mật khẩu từ 8 kí tự, ít nhất 1 chữ hoa và 1 số!</p><%} %>
               
                
                <label for="password">Xác nhận mật khẩu</label>
                <div class="password-wrapper">
                <input type="password" id="password2" name="confirmPassword" value="<%=confirmPassword %>" required>
                      <span class="toggle-password2" onclick="togglePasswordVisibility2()">👁️</span>
                </div>
                <%if("5".equals(error)) { %>
                <p class="thongbao">Xác nhận mật khẩu sai!</p><%} %>
                <br>


                <button type="submit">ĐĂNG KÝ</button>
                <p class="login">Bạn đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
            </form>
        </div>
    </div>
    
    
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
</body>

</html>