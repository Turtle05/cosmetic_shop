<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Thanh Toán</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<style>
    .body-infor {
        width: 85%;
        flex-direction: row;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap;
        width: 85%;
        max-width: 1200px;
        padding: 20px;
        margin-top: 15px;
        align-items: center;
    }

    .container-infor {
        display: flex;
        flex-direction: row;
        background-color: #fff;
        flex-wrap: wrap;
        width: 100%;
        max-width: 1200px;
        gap: 10px;
    }

    .infor-form {
        width: 30%;
        padding: 0 20px 20px 20px;
        flex: 1 1 30%;
        box-sizing: border-box;
        min-width: 300px;


    }


    .infor-form input {
        min-width: 120px;
    }




    .order-summary {
        padding: 20px;
        width: 65%;
        flex: 1 1 65%;
        padding: 20px;
        box-sizing: border-box;
        border: #ccc solid 1px;
        border-radius: 5px;
    }

    .container-infor h2 {
        font-size: 24px;
        margin-bottom: 20px;
        margin-top: 0;
        color: #333;
        text-align: center;
    }



    .container-infor h3 {
        font-size: 20px;
        margin-top: 20px;
        margin-bottom: 10px;
        color: #333;
    }




    .container-infor label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
        margin-left: 20px;
    }

    .container-infor input[type="text"],
    .container-infor input[type="email"] {
        width: 90%;
        padding: 10px;
        margin-left: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }







    .infor-btn {
        background-color: #333;
        padding: 12px 24px;
        margin: 20px;
        color: #fff;
        border-radius: 5px;
        border: none;
        font-size: 16px;
        text-decoration: none
    }

    .infor-btn:hover {
        background-color: #000;


    }

    .sidebar-infor {
        float: left;
        width: 100%;
        background-color: #f1f1f1;
        border-radius: 5px;
    }

    .sidebar-infor-a {
        display: block;
        color: black;
        text-decoration: none;
        padding: 20px;
        font-size: 20px;
    }

    .sidebar-infor-a:hover {
        background-color: #ddd;
    }

    .sidebar-infor-a-active {

        background-color: #ccc;
    }

    .central,
    .button-central {
        text-align: center;
    }

    .form-group-password {
        margin: 0 30px 0 30px;
    }

    .form-group-password label {
        display: block;
        margin-bottom: 5px;
    }

    .form-group-password input {
        width: 100%;
        padding: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
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

.toggle-password,
.toggle-password2,
    .toggle-password3 {
        position: absolute;
        right: 10px; /* Đặt biểu tượng bên phải */
        cursor: pointer;
        margin-bottom: 5px;
    }
</style>
<% String pass = request.getParameter("pass") != null ? request.getParameter("pass") : ""; %>           	   
<% String newpassword = request.getParameter("newpassword") != null ? request.getParameter("newpassword") : "";%>
<% String confilmPass = request.getParameter("confilmPass") != null ? request.getParameter("confilmPass") : "";%>
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
	                    <a href="ShowInforServlet"><i class="fa-regular fa-user"></i>Thông tin tài khoản</a>
	                    <a href="ShowOrderServlet"><i class="fa-solid fa-list-check"></i>Quản lý đơn hàng</a>
	                    <a href="LogoutServlet"><i class="fa-solid fa-arrow-right-from-bracket"></i>Đăng xuất</a>
	                </div>
            	</div>
                <%} %>
            </div>

    </header>

    <div class="body-infor">
        <div class="central">
            <h2>THÔNG TIN TÀI KHOẢN</h2>
        </div>


        <div class="container-infor">

            <div class="infor-form">

                <div class="sidebar-infor">
                    <a href="ShowInforServlet" class="sidebar-infor-a " href="#">Thông tin tài khoản</a>
                    <a href="ShowOrderServlet" class="sidebar-infor-a">Quản lý đơn hàng</a>
 <!--                    <a class="sidebar-infor-a">Địa chỉ thanh toán và giao hàng</a> -->
                    <a  href="changePassword.jsp" class="sidebar-infor-a sidebar-infor-a-active">Thay đổi mật khẩu</a>
                    <a href="LogoutServlet" class="sidebar-infor-a"><i class="fa-solid fa-arrow-right-from-bracket"></i> Đăng xuất</a>
                    
                </div>

            </div>
            <form class="order-summary" action="ChangePasswordServlet" method="post">
                <h2>Thay Đổi Mật Khẩu</h2>
                <% String error = request.getParameter("message"); %>
                    <%if("1".equals(error)){%> <div class="central"><p style="color: green; font-size: 18px"> Đổi mật khẩu thành công! </p></div><%} %>
                     <%if("2".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Thông tin trống. Cập nhật không thành công </p></div><%} %>
                     <%if("3".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Không trùng mật khẩu cũ </p></div><%} %>
                     <%if("4".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Mật khẩu phải có 8 kí tự, ít nhất 1 chữ in hoa và 1 số </p></div><%} %>
                     <%if("5".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Xác nhật mật khẩu sai </p></div><%} %>
                     <%if("6".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Lỗi ở server! </p></div><%} %>
                <div class="form-group-password">
                    <label for="oldPassword">Mật khẩu cũ *</label>
                    <div class="password-wrapper">
                    <input type="password" name="pass" value="<%=pass%>" id="password">
                    <span class="toggle-password" onclick="togglePasswordVisibility()">👁️</span>
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group-password">
                    <label for="phone">Mật khẩu mới *</label>
                    <div class="password-wrapper">
                    <input type="password" id="password2" name="newpassword" value="<%=newpassword%>">
                    <span class="toggle-password2" onclick="togglePasswordVisibility2()">👁️</span>
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group-password">
                    <label for="email">Xác nhận mật khẩu *</label>
                    <div class="password-wrapper">
                    <input type="password" id="password3" name="confilmPass" value="<%=confilmPass%>">
                    <span class="toggle-password3" onclick="togglePasswordVisibility3()">👁️</span>
                    </div>
                </div>
                <div class="button-central">
                    <button type="submit" class="infor-btn">Lưu thay đổi</button>
                </div>

            </form>
        </div>
    </div>
    
    
       <footer>
        <div class="footer-container">
            <div class="footer-section">
                <h3>Về chúng tôi</h3>
                <p>COSMETIC SHOP chuyên cung cấp các sản phẩm chăm sóc da uy tín và chất lượng.</p>
            </div>
            <div class="footer-section">
                <h3>Liên hệ</h3>
                <p>Email: 123@example.com</p>
                <p>Điện thoại: 0123-456-789</p>
            </div>
            <div class="footer-section">
                <h3>Kết nối với chúng tôi</h3>
                <p>
                    <a href="#"><i class="fa-brands fa-facebook"></i></a>
                    <a href="#"><i class="fa-brands fa-twitter"></i></a>
                    <a href="#"><i class="fa-brands fa-instagram"></i></a>
                </p>
            </div>
        </div>
    </footer>
    
    
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
</body>



</html>