<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.dto.CartDTO"%>
<%@page import="model.dto.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="common.StringCommon"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang Thanh Toán</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<style>
.body-checkout {
    width: 85%;
    flex-direction: row;
    margin: 0px; 
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    flex-wrap: wrap;
    width: 85%;
    max-width: 1200px;
    padding: 20px;
    margin-top: 0; 
    align-items: center;
}
.left{
text-align: left !important;
}
</style>
<%
ArrayList<CartDTO> cartList = (ArrayList<CartDTO>) request.getAttribute("cartList");
%>
<%
CustomerDTO cusDetail = (CustomerDTO) request.getAttribute("cusDetail");
%>

<% String fullname = cusDetail.getFullname() != null ? cusDetail.getFullname() : request.getParameter("fullname"); %>
<% String phone = cusDetail.getPhone() != null ? cusDetail.getPhone() : request.getParameter("phone"); %>
<% String address = cusDetail.getAddress() != null ? cusDetail.getAddress() : request.getParameter("address"); %>
<% String email = cusDetail.getEmail() != null ? cusDetail.getEmail() : request.getParameter("email"); %>
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

				<button>
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</div>
		<div class="header-right">

			<div class="cart">
				<a href="ShowCartServlet"><i class="fa-solid fa-cart-shopping"></i></a>
				<!--    <p>Giỏ hàng</p> -->
			</div>






			<%
			if (session.getAttribute("accountInfor") == null) {
			%>
			<div class="profile-dropdown account">
				<a href="login.jsp" title="Đăng nhập"><i
					class="fa-solid fa-user"></i></a>
				<!--      <p>Tài khoản</p> -->
			</div>
			<%
			} else {
			%>

			<div class="profile-dropdown account">
				<a href="#" title="Tài khoản"><i class="fa-solid fa-user"></i></a>
				<!--<p>Tài khoản</p> -->
				<div class="profile-dropdown-content">
					<a href="#"><i class="fa-regular fa-user"></i>Thông tin tài
						khoản</a> <a href="#"><i class="fa-solid fa-list-check"></i>Quản
						lý đơn hàng</a> <a href="LogoutServlet"><i
						class="fa-solid fa-arrow-right-from-bracket"></i>Đăng xuất</a>
				</div>
			</div>
			<%
			}
			%>
		</div>

	</header>

	<div class="sub-header">
		<div class="breadcrumb">
			<a href="#">Trang chủ</a> / <span>Thanh toán</span>
		</div>
	</div>



	<div class="body-checkout">
		<div class="progress-bar">
			<div class="step active">
				<div class="icon">
					<i class="fa-solid fa-cart-shopping"></i>
				</div>
				<div class="text">Giỏ hàng</div>
			</div>
			<div class="line active"></div>
			<div class="step active">
				<div class="icon">
					<i class="fa-regular fa-credit-card"></i></i>
				</div>
				<div class="text">Thanh toán</div>
			</div>
			<div class="line"></div>
			<div class="step">
				<div class="icon">
					<i class="fa-regular fa-circle-check"></i>
				</div>
				<div class="text">Hoàn thành</div>
			</div>
		</div>


		<form class="container-checkout" action="AuthorizePaymentServlet" method="post">

			<div class="checkout-form">

				<h2>THÔNG TIN THANH TOÁN</h2>
				<% String error = request.getParameter("error"); %>
				 <%if("1".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Lỗi thiếu thông tin! </p></div><%} %>
				 <%if("2".equals(error)){%> <div class="central"><p style="color: red; font-size: 18px"> Số điện thoại không hợp lệ! </p></div><%} %>
				<div class="form-group">
					<label for="lastName">Họ và tên<span>*</span></label> <input
						type="text" id="lastName" name="fullname"
						value="<%=fullname%>" required>
				</div>
				<!-- <div class="form-inline">
					<div class="form-group-sub">
						<label for="city">Tỉnh, thành <span>*</span></label> <select
							id="city" name="province" required>
							<option value="">Chọn tỉnh thành</option>
							Thêm các tỉnh thành khác ở đây
						</select>
					</div>
					<div class="form-group-sub">
						<label for="district">Quận, huyện<span>*</span></label> <select
							id="district" name="district" required>
							<option value="">Chọn quận huyện</option>
							Thêm các tỉnh thành khác ở đây
						</select>
					</div>
					<div class="form-group-sub">
						<label for="ward">Phường, xã<span>*</span></label> <select
							id="ward" name="ward" required>
							<option value="">Chọn phường xã</option>
							Thêm các tỉnh thành khác ở đây
						</select>
					</div>
				</div> -->
					<div class="form-group">
					<label for="phone">Số điện thoại <span>*</span></label> <input
						type="text" id="phone" name="phone"
						<%-- value="<%=phone%>" --%>  <%if(phone==null){ %>value="" <%}else{ %>value="<%=phone%>" <%} %> required>
				</div>
				<div class="form-group">
					<label for="email">Địa chỉ email <span>*</span></label> <input
						type="email" id="email" name="email1"
						value="<%=email%>" disabled>
						<input type="hidden" name ="email"  value="<%=email%>" >
				</div>
				<div class="form-group">
					<label for="address">Địa chỉ<span>*</span></label> <input
						type="text" id="address" name="address"
						 <%if(address==null){ %>value="" <%}else{ %>value="<%=address%>" <%} %> required>
				</div>
			


			</div>
			<div class="order-summary">
				<h2>ĐƠN HÀNG CỦA BẠN</h2>
				<table id="order-summary-table">
					<tr>
						<th>SẢN PHẨM</th>
						<th>TẠM TÍNH</th>
					</tr>
					<%
					for (CartDTO c : cartList) {
					%>
					<tr>
						<td class="left"><%=c.getProductGroupName()%> <%=c.getSize()%> x <span
							class="quantity"><%=c.getQuantity()%></span></td>
						<td><span class="price" data-price="<%=c.getPrice()%>"></span>
						<input type="hidden" name="productID" value="<%=c.getProductID()%>"></td>
						<input type="hidden" name="quantity" value="<%=c.getQuantity()%>">
						<input type="hidden" name="price" value="<%=c.getPrice()%>">
					</tr>
					<%
					}
					%>
					<tr>
						<th>Tổng tạm tính</th>
						<td><span id="subtotal"></span></td>
						<input type="hidden" name="subTotal" id="hiddenSubtotal">
					</tr>
					<tr>
						<th>Vận chuyển
						</th>
						<td>Giao hàng miễn phí</td>
						<input type="hidden" name="shipping" value="0">
					</tr>
					<tr>
						<th>Tổng thanh toán</th>
						<td><span id="grandtotal"></span></td>
						<input type="hidden" name="grandTotal" id="hiddenGrandtotal">
					</tr>
				</table>
				<div class="payment-method">
					<h3>Phương thức thanh toán</h3>
					<div class="form-group">
						<input type="radio" id="cod" name="method" value="cod" checked>
						<label for="cod">Thanh toán khi nhận hàng</label>
					</div>
					<div class="form-group">
						<input type="radio" id="paypal" name="method" value="paypal">
						<label for="paypal">Thanh toán qua Paypal</label>
					</div>
				</div>

				<!-- <a href="#" class="order-btn">Đặt hàng</a> -->
				<input type="hidden" name="grandTotal" value="777">
				<button type="submit" class="order-btn">Đặt hàng</button>

			</div>
		</form>
	</div>

	<footer>
		<div class="footer-container">
			<div class="footer-section">
				<h3>Về chúng tôi</h3>
				<p>COSMETIC SHOP chuyên cung cấp các sản phẩm chăm sóc da uy tín
					và chất lượng.</p>
			</div>
			<div class="footer-section">
				<h3>Liên hệ</h3>
				<p>Email: 123@example.com</p>
				<p>Điện thoại: 0123-456-789</p>
			</div>
			<div class="footer-section">
				<h3>Kết nối với chúng tôi</h3>
				<p>
					<a href="#"><i class="fa-brands fa-facebook"></i></a> <a href="#"><i
						class="fa-brands fa-twitter"></i></a> <a href="#"><i
						class="fa-brands fa-instagram"></i></a>
				</p>
			</div>
		</div>
	</footer>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
	<script>
		var citis = document.getElementById("city");
		var districts = document.getElementById("district");
		var wards = document.getElementById("ward");
		var Parameter = {
		  url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json", 
		  method: "GET", 
		  responseType: "application/json", 
		};
		var promise = axios(Parameter);
		promise.then(function (result) {
		  renderCity(result.data);
		});
		
		function renderCity(data) {
		  for (const x of data) {
		    citis.options[citis.options.length] = new Option(x.Name, x.Id);
		  }
		  citis.onchange = function () {
		    district.length = 1;
		    ward.length = 1;
		    if(this.value != ""){
		      const result = data.filter(n => n.Id === this.value);
		
		      for (const k of result[0].Districts) {
		        district.options[district.options.length] = new Option(k.Name, k.Id);
		      }
		    }
		  };
		  district.onchange = function () {
		    ward.length = 1;
		    const dataCity = data.filter((n) => n.Id === citis.value);
		    if (this.value != "") {
		      const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;
		
		      for (const w of dataWards) {
		        wards.options[wards.options.length] = new Option(w.Name, w.Id);
		      }
		    }
		  };
		}





		document.addEventListener('DOMContentLoaded', function() {
		    const prices = document.querySelectorAll('.price');
		    const quantities = document.querySelectorAll('.quantity');
		    const subtotalElem = document.getElementById('subtotal');
		    const grandtotalElem = document.getElementById('grandtotal');
		    const hiddenSubtotal = document.getElementById('hiddenSubtotal');
		    const hiddenGrandtotal = document.getElementById('hiddenGrandtotal');
		    const shippingCost = 0;
		    const discount = 0;

		    let subtotal = 0;

		    prices.forEach((priceElem, index) => {
		        const price = parseFloat(priceElem.getAttribute('data-price'));
		        const quantity = parseInt(quantities[index].innerText);
		        const totalPrice = price * quantity;

		        priceElem.innerText = totalPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
		        subtotal += totalPrice;
		    });

		    subtotalElem.innerText = subtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
		    const grandtotal = subtotal + shippingCost - discount;
		    grandtotalElem.innerText = grandtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });

		    hiddenSubtotal.value = subtotal;
		    hiddenGrandtotal.value = grandtotal;
		});





	</script>



</body>

</html>