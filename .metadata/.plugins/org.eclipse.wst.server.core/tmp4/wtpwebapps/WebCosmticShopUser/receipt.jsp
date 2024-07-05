<%@page import="common.StringCommon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="model.dto.OrderDTO"%>
    <%@page import="model.dto.OrderDetailDTO"%>



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
    .finish-order {
        width: 85%;
        flex-direction: row;
        margin: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap;
        width: 85%;
        max-width: 1200px;
        padding: 20px;
        margin-top: 80px;
        align-items: center;
    }

    .container-finish-order {
        display: flex;
        flex-direction: row;
        background-color: #fff;
        flex-wrap: wrap;
        width: 100%;
        max-width: 1200px;
        gap: 10px;
    }


    .checkout-form input {
        min-width: 120px;
    }

    .form-inline {
        display: flex;
        /* Thêm display flex cho inline */
        align-items: center;
        /* Canh chỉnh các thành phần trên cùng một hàng */
    }

    .form-inline label {
        margin-right: 10px;
        /* Để tạo khoảng cách giữa label và input */
    }


    .finish-order-summary1 {
        width: 100%;
        /* padding: 30px; */
        box-sizing: border-box;
       border: #ccc solid 1px; */
       border-radius: 5px;
       margin: 20px 0 20px 0;
    }
    
    .finish-order-summary {
        width: 100%;
        margin: 20px;
        padding: 20px;
        box-sizing: border-box;
       /*  border: black solid 1px; */
    }

    .container-finish-order1 h2 {
        font-size: 24px;
        margin-bottom: 20px;
        margin-top: 0;
        color: #333;
        text-align: center;
    }



    .container-finish-order h3 {
        font-size: 20px;
        margin-top: 20px;
        margin-bottom: 10px;
        color: #333;
    }


    .form-inline {
        display: flex;
        /* Thêm display flex cho inline */
        align-items: center;
        /* Canh chỉnh các thành phần trên cùng một hàng */
        flex-wrap: wrap;
    }

    .form-inline label {
        margin-right: 10px;
        /* Để tạo khoảng cách giữa label và input */
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group-sub {
        margin-bottom: 15px;
        margin-right: 31px;

    }

    .container-finish-order label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
    }

    .container-finish-order input[type="text"],
    .container-finish-order input[type="email"] {
        width: 90%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .container-finish-order input[type="checkbox"],
    .container-finish-order input[type="radio"] {
        margin-right: 10px;
    }

    .container-finish-order select {
        padding: 10px 0 10px 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }


    .finish-order-summary1 table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    .finish-order-summary1 th {
        text-align: left;
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }


    .finish-order-summary1 td {
        text-align: left;
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    .end-td {
        text-align: right !important;
    }

    /* .finish-order-summary th {
        background-color: #f9f9f9;
    } */

    .payment-method {
        margin-top: 20px;
    }

    .payment-method .form-group {
        display: flex;
        align-items: center;
    }



    .progress-bar {
        display: flex;
        /* align-items: center; */
        justify-content: center;
        margin: 40px 40px 40px 40px;

    }

    .progress-bar .step {
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
        color: #999;
        font-size: 18px;
    }

    .progress-bar .step.active .icon {
        color: #000;
    }

    .progress-bar .step .icon {
        font-size: 30px;
        margin-bottom: 5px;
        color: #ccc;
    }

    .progress-bar .line {
        margin-top: 15px;
        width: 100px;
        height: 1px;
        background-color: #ccc;
    }

    .progress-bar .line.active {
        background-color: #000;
    }

    .progress-bar .step.active {
        color: #000;
        font-weight: bold;
    }

    .order-btn {
        background-color: #333;
        padding: 12px 24px;
        margin: 30px;
        color: #fff;
        border-radius: 5px;
        font-size: 19px;
        text-decoration: none
    }

    .order-btn:hover {
        background-color: #000;


    }
    .bold{
    font-weight: bold;
    }
    .central{
    text-align: center;
    }
</style>
<%OrderDTO order = (OrderDTO) request.getAttribute("order");%>

<%ArrayList<OrderDetailDTO> orderDetail = (ArrayList<OrderDetailDTO>) request.getAttribute("orderDetail");%>

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
        <div class="progress-bar">
            <div class="step active">
                <div class="icon"><i class="fa-solid fa-cart-shopping"></i></div>
                <div class="text">Giỏ hàng</div>
            </div>
            <div class="line active"></div>
            <div class="step active">
                <div class="icon"><i class="fa-regular fa-credit-card"></i></i></div>
                <div class="text">Thanh toán</div>
            </div>
            <div class="line active"></div>
            <div class="step active">
                <div class="icon"><i class="fa-regular fa-circle-check"></i></div>
                <div class="text">Hoàn thành</div>
            </div>
        </div>


        <div class="container-finish-order">


            <div class="finish-order-summary">
            <div class="central">
                <h2>ĐẶT HÀNG THÀNH CÔNG</h2>
                <p>Đơn hàng <%=order.getOrderID()%> được đặt vào lúc <%=StringCommon.validateDateTime(order.getOrderDate()) %></p>
                             <%if("cho".equals(order.getStatus())){%>
				            <span class="order-status-cho">Chờ xác nhận</span>
				            <%}%>
				            <%if("giao".equals(order.getStatus())){%>
				            <span class="order-status-giao">Đang giao</span>
				            <%}%>
				            <%if("xong".equals(order.getStatus())){%>
				            <span class="order-status-xong">Hoàn thành</span>
				            <%}%>
             </div>   
                <!--  <h1>Please Review Before Paying</h1> -->
    <div>

    <table>
        <!-- <tr>
            <td colspan="2"><b>Thông tin thanh toán:</b></td>
            <td>
                
                
            </td>
        </tr> -->
        <!-- <tr>
            <td colspan="2"><b>Payer Information:</b></td>
        </tr> -->
        <%-- <tr>
            <td>Người thanh toán:</td>
            <td>${payer.firstName} ${payer.lastName}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${payer.email}</td>
        </tr>
        <tr>
            <td>Tổng thanh toán:</td>
            <td>${transaction.amount.total} USD</td>
            <td>${transaction.amount.total} VND</td>
        </tr>
        <tr>
        </tr>  --%>
        <tr>
        <td colspan="2"><b>Thông tin thanh toán:</b></td>
        </tr>
        <tr>
            <td>Tên người mua:</td>
            <td><%=order.getCustomerName() %></td>
        </tr>
        <tr>
            <td>Địa chỉ:</td>
            <td><%=order.getAddress() %></td>
        </tr>
        <tr>
            <td>Số điên thoại:</td>
            <td><%=order.getPhone() %></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=order.getEmail() %></td>
        </tr>
    </table>
    
    
    
   <!--  <div align="center">
    <h1>Payment Done. Thank you for purchasing our products</h1>
    <br/>
    <h2>Receipt Details:</h2> -->
    <%-- <table>
        <tr>
            <td><b>Merchant:</b></td>
            <td>Company ABC Ltd.</td>
        </tr>
        <tr>
            <td><b>Payer:</b></td>
            <td>${payer.firstName} ${payer.lastName}</td>      
        </tr>
        <tr>
            <td><b>Description:</b></td>
            <td>${transaction.description}</td>
        </tr>
        <tr>
            <td><b>Subtotal:</b></td>
            <td>${transaction.amount.details.subtotal} USD</td>
        </tr>
        <tr>
            <td><b>Shipping:</b></td>
            <td>${transaction.amount.details.shipping} USD</td>
        </tr>
        <tr>
            <td><b>Tax:</b></td>
            <td>${transaction.amount.details.tax} USD</td>
        </tr>
        <tr>
            <td><b>Total:</b></td>
            <td>${transaction.amount.total} USD</td>
        </tr>                    
    </table> --%>
</div>
    
    
    <div class="finish-order-summary1">
                <table>
                    <tr>
                        <th>SẢN PHẨM</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th class="end-td">Tạm tính</th>
                    </tr>
                     <%for(OrderDetailDTO o : orderDetail) { %>
                    <tr>
                        <td><%=o.getProductName() %> <%=o.getSize() %> 
                        </td>
                        <td><%=StringCommon.formatCurrency(o.getPrice()) %></td>
                        <td><%=o.getQuantity()%></td>
                        <td class="end-td"> <%=StringCommon.formatCurrency(o.getPrice() * o.getQuantity()) %></td>
                    </tr>
                    <%} %> 
                    

                    
                    <tr>
                        <th>Tổng tạm tính</th>
                        <td></td>
                        <td></td>
                        <td class="end-td"><%=StringCommon.formatCurrency(order.getGrandTotal())   %></td>
                    </tr>
                    <tr>
                        <th>Vận chuyển</th>
                        <td></td>
                        <td></td>
                        <td class="end-td">Giao hàng miễn phí</td>
                    </tr>
                    <tr>
                        <th>Phương thức thanh toán</th>
                        <td></td>
                        <td></td>
                        <%if("paypal".equals(order.getPayment())) { %>
                        <td class="end-td">Thanh toán qua Paypal</td>
                        <% } else { %>
                        <td class="end-td">Thanh toán khi nhận hàng </td>
                        <%} %>
                       
                    </tr>
                    <tr >
                        <th class="bold">Tổng thanh toán</th>
                        <td></td>
                        <td></td>
                        <td class="end-td bold"><%=StringCommon.formatCurrency(order.getGrandTotal())   %></td>
                    </tr>
                </table>
            </div>
                </div>
              
            </div>
      <a href="ShowHomeServlet">Trang chủ</a>
</body>

</html>





















