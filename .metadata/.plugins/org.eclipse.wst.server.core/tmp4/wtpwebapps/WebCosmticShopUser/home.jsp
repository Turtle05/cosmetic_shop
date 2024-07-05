<%@page import="org.w3c.dom.css.CSSImportRule"%>
<%@ page import="common.StringCommon"%>
<%@page import="model.bean.CategoryGroup"%>
<%@page import="model.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>

<%
    ArrayList<ProductDTO> productNewestList = (ArrayList<ProductDTO>) request.getAttribute("productNewestList");
    if (productNewestList != null) {
        for (ProductDTO pro : productNewestList) {
            // Code to display product information
        }
    } else {
        out.println("Không có sản phẩm!");
    }
%>

<% ArrayList<ProductDTO> productSalestList = (ArrayList<ProductDTO>) request.getAttribute("productSalestList"); %>


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


    <div class="container">

        <div class="slideshow">
            <div class="slide fade">
                <img src="slide.jpg" alt="Image 1">
            </div>
            <div class="slide fade">
                <img src="slide2.jpg" alt="Image 2">
            </div>
            <div class="slide fade">
                <img src="slide3.jpg" alt="Image 3">
            </div>
            <!-- Add more slides as needed -->
        </div>
    </div>




    <div class="product-container">
        <h2 class="product-title">SẢN PHẨM MỚI</h2>
        <%for(ProductDTO p : productNewestList){ %>
         <div class="product-card">
            
                 <a type="button" onclick="location.href='ShowProductDetailServlet?productGroupID=<%=p.getProductGroupID()%>&productID=<%=p.getProductID()%>';">
   					 <img src="<%=p.getImage()%>" alt="Product 1"></a>
                
                <div class="product-info">
                    <p class="price"><%=StringCommon.formatCurrency(p.getPrice())%></p>
                    <p class="brand"><%=p.getBrandName()%></p>
                    <p class="description"><%=p.getProductGroupName()%></p>
                    <button type="button" onclick="addToCart('<%=p.getProductGroupID()%>', '<%=p.getProductID()%>');" class="add-to-cart">Thêm vào giỏ</button>
                </div>
            </div>
        <%} %>
        
    </div>



    <div class="product-container">
        <h2 class="product-title">SẢN PHẨM BÁN CHẠY</h2>
         <%for(ProductDTO ps : productSalestList){ %>
        <div class="product-card">
            <a href="ShowProductDetailServlet?productGroupID=<%=ps.getProductGroupID()%>&productID=<%=ps.getProductID()%>"><img src="<%=ps.getImage() %>" alt="Product"></a>
            <div class="product-info">
            
            
                <p class="price"><%=StringCommon.formatCurrency(ps.getPrice() )%></p>
                <p class="brand"><a href="#"><%=ps.getBrandName()%></a></p>
                <p class="description"><%=ps.getProductGroupName()%></p>
                <button type="button" onclick="addToCart('<%=ps.getProductGroupID()%>', '<%=ps.getProductID()%>');" class="add-to-cart">Thêm vào giỏ</button>
            </div>
        </div>
        <%} %>
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
  <script src="script.js"></script>
     <script>
     
     
    function addToCart(productGroupID, productID) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "AddToCart", true);
         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        xhr.onreadystatechange = function () {
            console.log("readyState: " + xhr.readyState + ", status: " + xhr.status); // Kiểm tra trạng thái
            if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	            	console.log('responseText:', xhr.responseText);
	                if (xhr.responseText === 'success') {
	                    alert('Sản phẩm đã được thêm vào giỏ hàng.');
	                } else {
	                    alert('Có lỗi xảy ra. Vui lòng thử lại.');
	                }
	            } else {
	                alert('Có lỗi xảy ra. Vui lòng thử lại.');
	            }
	        }
        };

        xhr.send("proGroupID=" + encodeURIComponent(productGroupID) + "&proID=" + encodeURIComponent(productID));
    }

</script>















  
</body>

</html>