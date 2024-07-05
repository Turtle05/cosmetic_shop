<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.dto.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="common.StringCommon"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="style.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
    
    .body-cart{
    	width: 85%;
        flex-direction: row;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        flex-wrap: wrap;
        width: 85%;
        max-width: 1200px;
        padding: 20px;
       /*  margin-top: 50px; */
        align-items: center; 
        
    }
    
        .cart-container {
            flex-wrap: wrap;
            width: 100%;
            background-color: #fff;
            align-content: center;
/*         	border: black solid 1px;  */
        	display: flex;
       		flex-direction: row;
        	gap: 15px;
    	}

        .cart-product-list {
            flex: 1 1 65%;
      		padding: 0 10px 10px 10px; 
            box-sizing: border-box;
        }

        .cart-bill {
            flex: 1 1 32%;
            padding: 0px 10px 10px 30px; 
            box-sizing: border-box;
            border-left: #ccc solid 1px;

        }

        .bill-table,
        .product-table {
            /* border-collapse: collapse; */
            width: 100%;
            border-collapse: separate;
            text-indent: initial;
            border-spacing: 0px;
        }


        .product-table th,
        .product-table td {

            padding: 5px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 18px;

        }

        .product-table th {
       		 padding: 10px;
            font-weight: bold;
            font-family: Proxima, sans-serif !important;
        }

        .bill-table th {

            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-weight: normal;
            font-family: Proxima, sans-serif;
        }

        .bill-table td {
            padding: 20px;
            text-align: right;
            border-bottom: 1px solid #ddd;
            color: #111;
            font-weight: 700;
            white-space: nowrap;
        }

        .bill-table-1 {
            width: 100%;
            border-collapse: separate;
            text-indent: initial;
            border-spacing: 0px;
        }

        .bill-table-1 th {
            padding: 10px;
            text-align: left;
            border-bottom: 2px solid #ddd;
            font-weight: bolder;
            font-family: Proxima, sans-serif;
            font-size: 18px;
        }



        .td-total {
            font-weight: 700;
        }


        .checkout-button {
            display: grid;
            margin-top: 50px;
            padding: 10px 10px;
            font-size: 20px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .back-button:hover,
        .checkout-button:hover {
            background-color: #0056b3;
        }

        .back-button:active,
        .checkout-button:active {
            background-color: #004085;
        }

        .back-button {
            display: inline-flex;
            margin-top: 50px;
            padding: 10px 10px;
            font-size: 20px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-area {
            margin: 40px;
        }

        @media (max-width: 768px) {

            .cart-product-list,
            .cart-bill {
                flex: 1 1 100%;
            }
        }

        .product-name-td {
            display: flex;
            align-items: center;
        }

        .product-name-td img {
            width: 60px;
            height: 60px;
            margin-right: 7px;
        }

        .product-name-td p {
            font-size: 18px;
            margin: 10px 0 10px  0;
            max-width: 380px;
        }
        
        .fa-trash-can{
        color: red;
        cursor: pointer;
        }
        
        .fa-trash-can:hover{
        color: orange;
        cursor: pointer;
        }
        
        
        
    .counter {
        display: flex;
        align-items: center;
        border: 1px solid #ccc;
        width: 90px;
    }

    .counter a {
        background-color: #fff;	
        width: 30px;
        padding: 4px 7px 4px 7px;
        font-size: 16px;
        cursor: pointer;
        outline: none;
        user-select: none;
    }

    .counter a:hover {
        background-color: #eee;
    }
    
    .counter .decrease{
    border-right: 1px solid #ccc; 
    }
    
    .counter .increase{
    border-left: 1px solid #ccc; 
    }

    .counter input {
        width: 30px;
        text-align: center;
        font-size: 15px;
        border: none;
        background-color: #fff;
        -moz-appearance: textfield;
    }
    
    
    
    .empty-cart{
    height: 300px;
    width: 100%;
    text-align: center;
    border: #ccc solid 1px;
    margin-bottom: 40px;
    border-radius: 5px;
    }
    
     .empty-cart .back-btn{
    margin-top: 50px !important;
    padding: 10px 10px;
    font-size: 20px;
    color: #fff;
    background-color: #111;
    border: none;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border-radius: 3px;
    transition: background-color 0.3s;

    }
    
    
    
    
    input.quantityProduct::-webkit-outer-spin-button,
	input.quantityProduct::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;}
    </style>
</head>

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
            </div>

            <div class="account">
                <a href="#" title="Tài khoản"><i class="fa-solid fa-user"></i></a>
            </div>

        </div>
    </header>

    <div class="sub-header">
        <div class="breadcrumb">
            <a href="#">Trang chủ</a> / <span>Giỏ hàng</span>
        </div>
    </div>






	<div class="body-cart">
	
	
	
		<div class="progress-bar">
            <div class="step active">
                <div class="icon"><i class="fa-solid fa-cart-shopping"></i></div>
                <div class="text">Giỏ hàng</div>
            </div>
            <div class="line"></div>
            <div class="step">
                <div class="icon"><i class="fa-regular fa-credit-card"></i></i></div>
                <div class="text">Thanh toán</div>
            </div>
            <div class="line"></div>
            <div class="step">
                <div class="icon"><i class="fa-regular fa-circle-check"></i></div>
                <div class="text">Hoàn thành</div>
            </div>
        </div>
	        
	    <form class="cart-container" action="ShowCheckoutServlet" method="post">
	
	        <div class="cart-product-list">
	       
	
	   <%--  if (cartList != null) {
	        for (CartDTO c : cartList) {
	            // Code to display product information
	        }
	    } else {%>
	        <a>Không có sản phẩm </a>
	    <%} %> --%>
	   

	 <%ArrayList<CartDTO> cartList = (ArrayList<CartDTO>)request.getAttribute("cartList");%> 	
	
	

	
    <%if (cartList != null && !cartList.isEmpty()) {
        %>
    
	             <table class="product-table">
	        <thead>
	            <tr>
	                <th>Sản phẩm</th>
	                <th>Giá</th>
	                <th>Số lượng</th>
	                <th>Tạm tính</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	            <% for (CartDTO c : cartList) { %>
	                <tr>
	                    <td>
	                        <div class="product-name-td">
	                            <img src="<%=c.getImage() %>" alt="Product Image">
	                            <div>
	                                <p><%=c.getProductGroupName() %> <%=c.getSize() %></p>
	                            </div>
	                        </div>
	                    </td>
	                    <td class="price"><%=StringCommon.convertDoubleToStringWithComma(c.getPrice() )%></td>
	                    <td>
	                    
	                    
	                    
	                        <div class="counter" data-product-id="<%= c.getProductID() %>" data-quantity="<%= c.getQuantity() %>" >
							    <a class="decrease">-</a>
							    <input type="number" min="1" class="quantityProduct" value="<%= c.getQuantity() %>" name="quantity">
							    <input type="hidden" name="proID" value="<%=c.getProductID()%>">
							    <a class="increase">+</a>
							</div>
	                    </td>
	                    <td class="subtotal"><%=StringCommon.convertDoubleToStringWithComma(c.getQuantity() * c.getPrice()) %></td>
	                    <td><a href="DeleteCartServlet?productID=<%=c.getProductID()%>"><i class="fa-regular fa-trash-can"></i></a></td>
	                </tr>
	            <% } %>
	            <!-- Thêm các dòng sản phẩm khác ở đây -->
	        </tbody>
	    </table>
	    
	    
	            
	
	        </div>
	        <div class="cart-bill">
	            <table class="bill-table-1">
	                <thead>
	                    <tr>
	                        <th>Cộng giỏ hàng</th>
	                    </tr>
	                </thead>
	
	            </table>
	            <table class="bill-table">
			        <tbody>
			            <tr>
			                <th>Tổng tiền hàng</th>
			                <td><bdi id="subtotalAmount"></bdi></td>
			            </tr>
			            <tr>
			                <th>Vận chuyển</th>
			                <td><bdi id="shippingCost">Giao hàng miễn phí</bdi></td>
			            </tr>
			            <tr>
			                <th>
			                    <p class="td-total">Tổng thanh toán</p>
			                </th>
			                <td><bdi id="totalAmount"></bdi></td>
			            </tr>
			        </tbody>
			    </table>
	            <div class="btn-area">
	                <button id="checkoutButton" class="checkout-button">
					    Tiến hành thanh toán
					</button>
	            </div>
	        </div>
	    </form>
	     </div>
	    <% } else {%>
	        <div class="empty-cart">
	        <h3>Chưa có sản phẩm nào trong giỏ hàng</h3>
	        <a class="back-btn" href="ShowProductListServlet">Tiếp tục mua sắm</a> 
	        </div>
	   <% } %>
   




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
 /* document.addEventListener('DOMContentLoaded', () => {
	    const counters = document.querySelectorAll('.counter');

	    counters.forEach(counter => {
	        const quantityInput = counter.querySelector('.quantityProduct');
	        const decreaseButton = counter.querySelector('.decrease');
	        const increaseButton = counter.querySelector('.increase');
	        const priceElement = counter.closest('tr').querySelector('.price');
	        const subtotalElement = counter.closest('tr').querySelector('.subtotal');

	        const updateSubtotal = () => {
	            const price = parseFloat(priceElement.textContent.replace(/,/g, ''));
	            const quantity = parseInt(quantityInput.value);
	            const subtotal = price * quantity;
	            subtotalElement.textContent = subtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	        };

	        decreaseButton.addEventListener('click', () => {
	            let currentValue = parseInt(quantityInput.value);
	            if (currentValue > 0) {
	                quantityInput.value = currentValue - 1;
	                updateSubtotal();
	            }
	        });

	        increaseButton.addEventListener('click', () => {
	            let currentValue = parseInt(quantityInput.value);
	            quantityInput.value = currentValue + 1;
	            updateSubtotal();
	        });

	        updateSubtotal();
	    });
	}); */
	
	
/* 	document.addEventListener('DOMContentLoaded', () => {
	    const counters = document.querySelectorAll('.counter');
	    const subtotalElement = document.getElementById('subtotalAmount');
	    const shippingCostElement = document.getElementById('shippingCost');
	    const totalElement = document.getElementById('totalAmount');

	    const shippingCost = 0; // Tiền giao hàng (có thể thay đổi nếu cần)

	    const updateSubtotal = () => {
	        let totalSubtotal = 0;
	        document.querySelectorAll('.product-table tbody tr').forEach(row => {
	            const priceElement = row.querySelector('.price');
	            const quantityInput = row.querySelector('.quantityProduct');
	            const subtotalElement = row.querySelector('.subtotal');
	            

	            const price = parseFloat(priceElement.textContent.replace(/,/g, ''));
	            const quantity = parseInt(quantityInput.value);
	            const subtotal = price * quantity;

	            subtotalElement.textContent = subtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	            totalSubtotal += subtotal;
	        });

	        subtotalElement.textContent = totalSubtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	        const total = totalSubtotal + shippingCost;
	        totalElement.textContent = total.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	    };

	    counters.forEach(counter => {
	        const quantityInput = counter.querySelector('.quantityProduct');
	        const decreaseButton = counter.querySelector('.decrease');
	        const increaseButton = counter.querySelector('.increase');

	        decreaseButton.addEventListener('click', () => {
	            let currentValue = parseInt(quantityInput.value);
	            if (currentValue > 0) {
	                quantityInput.value = currentValue - 1;
	                updateSubtotal();
	            }
	        });

	        increaseButton.addEventListener('click', () => {
	            let currentValue = parseInt(quantityInput.value);
	            quantityInput.value = currentValue + 1;
	            updateSubtotal();
	        });
	    });

	    updateSubtotal(); // Cập nhật tạm tính và tổng ban đầu
	}); */


	
	
	
	
	
	
	
	
	document.addEventListener('DOMContentLoaded', () => {
	    const counters = document.querySelectorAll('.counter');
	    const subtotalElement = document.getElementById('subtotalAmount');
	    const totalElement = document.getElementById('totalAmount');

	    const shippingCost = 0; // Tiền giao hàng (có thể thay đổi nếu cần)

	    const updateSubtotal = () => {
	        let totalSubtotal = 0;
	        document.querySelectorAll('.product-table tbody tr').forEach(row => {
	            const priceElement = row.querySelector('.price');
	            const quantityInput = row.querySelector('.quantityProduct');
	            const subtotalElement = row.querySelector('.subtotal');

	            const price = parseFloat(priceElement.textContent.replace(/,/g, ''));
	            const quantity = parseInt(quantityInput.value);
	            const subtotal = price * quantity;

	            subtotalElement.textContent = subtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	            totalSubtotal += subtotal;
	        });

	        subtotalElement.textContent = totalSubtotal.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	        const total = totalSubtotal + shippingCost;
	        totalElement.textContent = total.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	    };

	    const updateCart = (productID, quantityChange) => {
	    	console.log('productID:', productID);
	    	console.log('quantityChange:', quantityChange);
	    	
	    	const xhr = new XMLHttpRequest();
	        xhr.open('POST', 'AddToCart', true);
	        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	        xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
	        
	        xhr.onload = () => {
	            if (xhr.status === 200) {
	                console.log(xhr.responseText);
	                if (xhr.responseText === 'success') {
	                    console.log('Cart updated successfully.');
	                } else {
	                    console.error('Failed to update cart.');
	                }
	            }
	        };
	       /*  xhr.send(`proID=${productID}&Quantity=${quantityChange}`); */
	        xhr.send("proID=" + encodeURIComponent(productID) + "&Quantity=" + encodeURIComponent(quantityChange));
	    };

	    counters.forEach(counter => {
	        const quantityInput = counter.querySelector('.quantityProduct');
	        const decreaseButton = counter.querySelector('.decrease');
	        const increaseButton = counter.querySelector('.increase');

	        decreaseButton.addEventListener('click', () => {
	            const productID = counter.getAttribute('data-product-id');
	            console.log('productID:', productID); // Kiểm tra productID
	            let currentValue = parseInt(quantityInput.value);
	            if (currentValue > 1) {
	                quantityInput.value = currentValue - 1;
	                updateSubtotal();
	                updateCart(productID, -1);
	            }
	        });

	        increaseButton.addEventListener('click', () => {
	            const productID = counter.getAttribute('data-product-id');
	            console.log('productID:', productID); // Kiểm tra productID
	            let currentValue = parseInt(quantityInput.value);
	            quantityInput.value = currentValue + 1;
	            updateSubtotal();
	            updateCart(productID, 1);
	        });

	    });

	    updateSubtotal(); // Cập nhật tạm tính và tổng ban đầu
	    
	    

	    
	    
	});

    </script>
    
    <!-- <script>
    document.getElementById('checkoutButton').addEventListener('click', function() {
        var form = document.getElementById('checkoutForm');
        form.submit();
    });
	</script> -->
    
    





</body>

</html>