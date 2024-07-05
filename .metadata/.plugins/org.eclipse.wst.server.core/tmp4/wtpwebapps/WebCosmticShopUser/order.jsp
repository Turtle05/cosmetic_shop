<%@page import="common.StringCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.dto.OrderDTO"%>
    <%@page import="java.util.ArrayList"%>
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
        /* margin: 20px; */
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap;
        width: 85%;
        max-width: 1200px;
        min-height: 500px;
        padding: 20px;
        margin-top: 10px;
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




    .infor-summary {
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

    .button-central {
        text-align: center;
    }

    .infor-summary .order-table {
        width: 100%;
        border-collapse: collapse;
    }

    .infor-summary .order-table th {
        text-align: left;
        border-bottom: #ccc solid 1px;
        font-size: 18px;
        font-family: Proxima, sans-serif !important;
    }

    .infor-summary .order-table td {
        text-align: left;
        font-size: 16px;
        font-family: Proxima, sans-serif !important;
    }
    .central{
        text-align: center;
    }
    
    .href-a{
    	color: blue;
    	text-decoration:none;
    }
    .href-a:hover{
    	text-decoration:underline;
    }
</style>
<%-- <%ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>)request.getAttribute("orderList");%> --%>
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
           
               <div class="profile-dropdown ">
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
                    <a href="ShowOrderServlet" class="sidebar-infor-a sidebar-infor-a-active">Quản lý đơn hàng</a>
 <!--                    <a class="sidebar-infor-a">Địa chỉ thanh toán và giao hàng</a> -->
                    <a  href="changePassword.jsp" class="sidebar-infor-a">Thay đổi mật khẩu</a>
                    <a href="LogoutServlet" class="sidebar-infor-a"><i class="fa-solid fa-arrow-right-from-bracket"></i> Đăng xuất</a>
                    
                </div>

            </div>
            <div class="infor-summary">
            <h2>Quản Lý Đơn Hàng</h2>
            <% 
ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>) request.getAttribute("orderList");
            if (orderList == null || orderList.isEmpty()) {%>
            <p class="central">Bạn chưa có đơn hàng nào.</p>
        <% } else { %>
                 <table class="order-table">
                    <thead>
                        <tr>
                            <th>Đơn hàng</th>
                            <th>Thời gian</th>
                            <th>Trạng thái</th>
                            <th>Tổng tiền</th>
                            <th>Chi tiết</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(OrderDTO o : orderList) { %>
                        <tr>

                            <td>
                                <div class="product-name-td">
                                    <div>
                                        <p><%=o.getOrderID() %></p>
                                    </div>
                                </div>
                            </td>
                            <td>
                            <%=StringCommon.validateDateTime(o.getOrderDate()) %>
                            </td>
                            <td>
                             <%if("cho".equals(o.getStatus())){%>
				            <span class="order-status-cho">Chờ xác nhận</span>
				            <%}%>
				            <%if("giao".equals(o.getStatus())){%>
				            <span class="order-status-giao">Đang giao</span>
				            <%}%>
				            <%if("xong".equals(o.getStatus())){%>
				            <span class="order-status-xong">Hoàn thành</span>
				            <%}%>
                            </td>
            				<td class="bold"><%=StringCommon.formatCurrency(o.getGrandTotal())%></td>
           					 <td><a class="href-a" href='ShowOrderDetailServlet?orderID=<%=o.getOrderID()%>'>Xem chi tiết</a></td>
            </tr>
            <%} %>

            
            <!-- Thêm các dòng sản phẩm khác ở đây -->
            </tbody>
            </table> 
 <%} %>
        </div>
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
</body>



</html>