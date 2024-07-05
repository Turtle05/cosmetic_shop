<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style type="text/css">
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

    .toggle-password {
        position: absolute;
        right: 10px; /* Đặt biểu tượng bên phải */
        cursor: pointer;
        margin-bottom: 20px;
    }

 
    </style>
</head>

<% String username = request.getParameter("username") != null ? request.getParameter("username") : ""; %>           	   
<% String password = request.getParameter("password") != null ? request.getParameter("password") : ""; %>
<% String error = request.getParameter("error"); %>
<body>


<header>
        <div class="header-left">
            <img src="logo.jpg" alt="Logo" class="logo">
        </div>
        <div class="header-center">
            <nav>
                <ul>
                    <li><a href="ShowHomeServlet">Trang chủ</a></li>
                    <li><a href="ShowProductListServlet">Sản phẩm</a></li>
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
                <a href="ShowCartServlet"><i class="fa-solid fa-cart-shopping"></i></a>
             <!--    <p>Giỏ hàng</p> -->
            </div>

   			<% if (session.getAttribute("accountInfor") == null) {%>		
	           <div class="profile-dropdown account">
	                <a href="login.jsp" title="Đăng nhập"><i class="fa-solid fa-user"></i></a>
	           			<!--      <p>Tài khoản</p> -->
           	   </div>
	           <%} else { %>
           
               <div class="profile-dropdown account">
	                <a href="#" title="Tài khoản"><i class="fa-solid fa-user"></i></a>
	           			<!--<p>Tài khoản</p> -->
	                <div class="profile-dropdown-content">
	                    <a href="#"><i class="fa-regular fa-user"></i>Thông tin tài khoản</a>
	                    <a href="#"><i class="fa-solid fa-list-check"></i>Quản lý đơn hàng</a>
	                    <a href="LogoutServlet"><i class="fa-solid fa-arrow-right-from-bracket"></i>Đăng xuất</a>
	                </div>
            	</div>
                <%} %>
            </div>

    </header>

    <div class="sub-header">
        <div class="breadcrumb">
            <a href="#">Trang chủ</a> / <span>Đăng nhập</span>
        </div>

    </div>



    <div class="login-container">
        <div class="form-container">
            <form class="registration-form" action="CheckLoginServlet" method="post">
                <h2>ĐĂNG NHẬP</h2>
                <%if(error==null){ %>
                <p>Nhập email và mật khẩu để đăng nhập</p>
                <%} else  if("3".equals(error)) { %>
                <p style="color: green;" >
                 <%=("3".equals(error)) ? "Đăng ký thành công, mời điền thông tin để đăng nhập!" : "" %></p>
                <%} else{ %>
                <p style="color: red;" >
                 <%=("1".equals(error)) ? "Bạn đã đăng xuất, mời bạn đăng nhập lại!" : "" %>
           		 <%=("2".equals(error)) ? "Thông tin đăng nhập không đúng !" : "" %> 
             </p> 
             <%} %>
             
          
                
                <!-- <p style="color: red;">Thông tin đăng nhập không đúng!</p> -->

                <label for="email">Email</label>
                <input type="email" id="email" name="username" value="<%=username%>" required>

                <label for="password">Mật khẩu</label>
                <div class="password-wrapper">
                <%-- <input type="password" id="password" name="password"  value="<%=password%>"required> --%>
                <input type="password" id="password" placeholder="" name="password" value="<%=password%>" >
        		<span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
				</div>
                <div class="terms">
                </div>

                <button type="submit">ĐĂNG NHẬP</button>
                <p class="login">Bạn chưa có tài khoản? <a href="register.jsp">Đăng ký</a></p>
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
</body>

</html>