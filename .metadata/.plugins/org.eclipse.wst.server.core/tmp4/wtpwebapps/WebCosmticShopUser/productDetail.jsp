 <%@page import="java.util.ArrayList" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@page import="model.bean.Product" %>
            <%@page import="model.dto.ProDTO" %>
             <%@page import="model.dto.DanhgiaDTO" %>
                <%@page import="common.StringCommon" %>
                <%@page import="common.ValidateCommon" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Page</title>
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <style>
  
  		.stars {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .stars input[type="radio"] {
            display: none;
        }

        .stars label {
            font-size: 30px;
            color: gray;
            cursor: pointer;
            transition: color 0.2s;
        }

        .stars label.active {
            color: gold;
        }


		.stars12 {
               display: inline-block;
            color: #FFD700;
            font-size: 24px;
        }
        .stars123{
        display: inline-block;
            font-size: 24px;
        }

       

  
  
  
     .custom-alert {
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
            opacity: 0;
            transition: opacity 0.5s ease-in-out;
        }

        .custom-alert.show {
            opacity: 1;
        }

        .custom-alert.hidden {
            display: none;
        }
  
  
  
  
  
  
  
    .ratingBig {
      display: flex;
      align-items: center;
      justify-content: left;
      margin-bottom: 10px;
      flex-direction: column;
    }

    .addToCart-productDetail-btn {
      padding: 12px 17px;
      background-color: #4154f1;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 18px;
      cursor: pointer;
      transition: background-color 0.3s;
      margin-top: 30px
    }

    .product-page {
      display: flex;
      flex-wrap: wrap;
      width: 95%;
      padding: 0 20px 20px 20px;
      background-color: #fff;
     /*  border: black solid 1px; */
      border-radius: 8px;
    }

    .productDetail-image {
      flex: 1 1 40%;
      height: auto;
      padding: 15px;
      box-sizing: border-box;
     /*  border: black solid 1px; */
      text-align: center;
    }

    .product-details {
      flex: 1 1 50%;
      height: auto;
      box-sizing: border-box;
/*       border: black solid 1px; */
      margin: 3px;
      padding: 0 20px 20px 20px;
    }

    .product-image {
      width: 100%;
      max-width: 500px;
      display: flex;
      flex-direction: column;
      align-items: center;
      flex: 1;
    }

    .product-image img.main-image {
      width: 100%;
      height: auto;
      border: #333 solid 1px;
    }

    .thumbnail-images {
      display: flex;
      gap: 10px;
      margin-top: 10px;
    }

    .thumbnail-images img.thumbnail {
      width: 100px;
      height: 100px;
      cursor: pointer;
      flex: 1;
      max-width: 100px;
    }


    .product-details h1 {
      font-size: 24px;
      margin-top: 10px;
    }

    .price {
      font-size: 20px;
      color: #e67e22;
      text-align: left;
    }

    .stock {
      margin: 10px 0;
      text-align: left;
    }

    .in-stock {
      color: black;
      font-weight: bold;
    }



    .description {
      margin-bottom: 20px;
      text-align: left;
    }

    .actions button {
      margin-right: 10px;
      padding: 10px 20px;
      background: #e67e22;
      color: white;
      border: none;
      cursor: pointer;
    }


    .size-options {
      margin: 10px 0;
    }

    .sizes {
      display: flex;
      gap: 10px;
      margin-top: 15px;
      margin-bottom: 30px;
    }

    .color {
      width: 20px;
      height: 20px;
      display: inline-block;
      cursor: pointer;
    }

    .black {
      background: black;
    }



    .size {
      padding: 5px 10px;
      border: 1px solid #333;
      cursor: pointer;
      border-radius: 5px;
      margin-bottom: 30px;

    }


    .add-to-cart button:hover {

      background: rgb(24, 24, 154);

    }

    .rating {
      display: flex;
      align-items: center;
      justify-content: left;
      margin-bottom: 10px;
      flex-direction: row;
    }

    .stars1 {
      display: flex;
      margin-right: 5px;
      margin-left: 5px;
      color: #FFD700;
    }

    .star {
      font-size: 24px;
      color: #FFD700;
      margin-right: 2px;
    }

    .empty {
      color: #ddd;
      /* Grey color */
    }

    .sold {
      color: #333;
      padding-top: 7px;
    }

    .price {
      font-size: 24px;
      color: #e67e22;
    }

    .buttons_added {
      opacity: 1;
      display: inline-block;
      display: -ms-inline-flexbox;
      display: inline-flex;
      white-space: nowrap;
      vertical-align: top;
      margin-right: 30px;
    }

    .is-form {
      overflow: hidden;
      position: relative;
      background-color: #f9f9f9;
      /* height: 2.2rem; */
      width: 1.9rem;
      padding: 0;
      text-shadow: 1px 1px 1px #fff;
      border: 1px solid #ddd;
    }

    .is-form:focus,
    .input-text:focus {
      outline: none;
    }

    .is-form.minus {
      border-radius: 4px 0 0 4px;
    }

    .is-form.plus {
      border-radius: 0 4px 4px 0;
    }

    .input-qty {
      background-color: #fff;
      height: 2.2rem;
      text-align: center;
      font-size: 1rem;
      display: inline-block;
      vertical-align: top;
      margin: 0;
      border-top: 1px solid #ddd;
      border-bottom: 1px solid #ddd;
      border-left: 0;
      border-right: 0;
      padding: 0;
    }

    .input-qty::-webkit-outer-spin-button,
    .input-qty::-webkit-inner-spin-button {
      -webkit-appearance: none;
      margin: 0;
    }





    /* body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        } */

    .nav-bar {
      display: flex;
      justify-content: center;
      background-color: #fff;
      padding: 10px 0 10px 0;
      width: 100%;
      border-bottom: 2px solid #ccc;
    }

    .nav-button {
      background-color: #fff;
    border: none;
    color: black;
    padding: 10px 20px;
    margin: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
    border-radius: 5px;
    }

    .nav-button:hover {
      font-weight: bold;
    }
    
    .nav-button:active {
       font-weight: bold;
    }
    .nav-button:after {
       font-weight: bold;
    }



    .section {
      padding: 10px;
      margin: 10px;
      background-color: #fff;
      border-radius: 5px;
      /* box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); */
      width: 90%;
    }

    .product-rating {
      text-align: center;
      margin-bottom: 20px;
    }

    .stars {
      color: #f7d32e;
      font-size: 30px;
    }

    .big-stars {
      color: #f7d32e;
      font-size: 70px;
    }

    .danhgia1 {
      color: black;
      font-size: 25px;
      margin-top: 5px;
      margin-bottom: 0;
    }

    .danhgia2 {
      color: black;
      font-size: 18px;
      margin-top: 5px;
    }



    .rating-bar {
      width: 100%;
      height: 20px;
      background-color: #ddd;
      border-radius: 10px;
      margin-bottom: 10px;
    }

    .review {
      margin-bottom: 20px;
    }

    .username {
      font-weight: bold;
    }

    .comment {
      color: #555;
    }

    .rate-button {
      display: inline-block;
      text-align: center;
      background-color: #007bff;
      color: #fff;
      padding: 10px;
      border-radius: 5px;
      text-decoration: none;
      margin-top: 20px;
    }

    .rate-button:hover {

      background-color: #164271;

    }




    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5);
    }

    /* Modal content */
    .modal-content {
      background-color: #fff;
      margin: 10% auto;
      padding: 30px;
      border-radius: 5px;
      width: 100%;
      max-width: 500px;
      height: 100%;
      max-height: 400px;
    }
    
    .star_wrap{
    display: flex;
    flex-direction: row-reverse;
	}
	    .star_wrap input{
	    appearance: none;
	    }
	    .star_wrap input:before{
	    contenr: "\2065";
	    color: #ccc;
	    font-size: 2rem;
	    cursor: pointer;
	    }
	    
	    .star_wrap input:checked::before,
	    .star_wrap input:checked ~ .star_wrap input:before{
	    color: #ffb800;
	    }
	    
.central{
text-align: center;
margin-top: 30px;}

    /* Close button */
    .close {
      float: right;
      font-size: 30px;
      font-weight: bold;
      cursor: pointer;
      position: relative;
      outline: 0;
      margin-left: 3px;
      min-height: inherit;
      line-height: inherit;

    }
    .sub-header {
    margin-top: 15px;
    }

    /* Title */
    .modal-title {
      font-size: 18px;
      font-weight: bold;
      margin-bottom: 30px;
    }

    /* Text input fields */
    .input-field {
      width: 95%;
      max-width: 95%;
      height: 80px;
      max-height: 30%;
      min-height: 25px;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 20px;
    }
    
    

    @media (max-width: 768px) {

      .product-details,
      .productDetail-image {
        flex: 1 1 100%;
      }
    }
    
    
    
  </style>
</head>
 <% ProDTO productGroup=(ProDTO)request.getAttribute("productGroup");%>
                        <% Product productDetail=(Product)request.getAttribute("productDetail");%>
                            <% ArrayList<Product> productList =(ArrayList<Product>)request.getAttribute("productList");%>
                            <% ArrayList<DanhgiaDTO> rate =(ArrayList<DanhgiaDTO>)request.getAttribute("rate");%>
                            <% DanhgiaDTO star=(DanhgiaDTO)request.getAttribute("star");%>
<body>

  <header>
  <div id="customAlert" class="custom-alert hidden">Sản phẩm đã được thêm vào giỏ hàng.</div>
  <%String error = request.getParameter("messageRate"); %> 
    <% if ("1".equals(error)) { %>
    <div id="thongbao" class="custom-alert hidden">Đánh giá thành công!</div>
	<% } %>
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
      <a href="#">Trang chủ</a> / <span>Chi tiết sản phẩm</span>
    </div>
  </div>




  <div class="container-productDetail">
    <div class="product-page">
      <div class="productDetail-image">
        <div class="product-image">
           <img src="<%=productDetail.getImage()%>" alt=""
               class="main-image">
           <div class="thumbnail-images">
               <%for(Product p: productList){ %>
                   <img src="<%=p.getImage() %>" alt="Thumbnail 1"
                       width="100" height="100">
                   <%} %>
           </div>
       </div>
      </div>
      <div class="product-details">
        <h1><%=productGroup.getProductGroupName()%> <%=productDetail.getSize()%></h1>

        <div class="rating">
          <span class="sold"><%=ValidateCommon.formatStarRate(star.getStarRate(), 1)%> </span>
          <!-- <div class="stars1" id="stars"></div> -->

 		<%for(int i=1; i<=5; i++) {
 			if(i<=star.getStarRate()){ %>
 			<span class="star full">★</span>
 			<%} else{ %>
 			<span class="star empty">★</span>  	 
 			<%} %>
 		<%} %>
       
        
          
          <span class="sold"> | <%=star.getRateNum() %> đánh giá</span>
          
        </div> 
        <p class="price"><%=StringCommon.formatCurrency(productDetail.getPrice())%></p>
        <% if ("1".equals(error)) { %>
        

	<% } %>

          <div class="brand">
               <a href="home.html"><span class="brand">
                       <%=productGroup.getBrandName() %>
                   </span></a>
           </div>
           <p class="description">
               <%=productGroup.getDes() %>
           </p>


        <div class="size-options">
           <label>Dung tích:</label>
           <div class="sizes">
               <%for(Product p: productList){ %>
                   <a type="button"
                       onclick="location.href='ShowProductDetailServlet?productGroupID=<%=p.getProductGroupID()%>&productID=<%=p.getProductID()%>';">
                       <span class="size">
                           <%=p.getSize() %>
                       </span></a>
                   <%} %>
           </div>
       </div>


        <div>
		<form id="addCartForm" class="addCartProductDetail" action="AddToCart" method="post">
    <div class="buttons_added">
        <input class="minus is-form" type="button" value="-">
        <input aria-label="quantity" class="input-qty" max="10" min="1" name="Quantity" type="number" value="1">
        <input type="hidden" name="proID" value="<%=productDetail.getProductID()%>">
        <input class="plus is-form" type="button" value="+">
    </div>
    <div class="addToCartProductDetail">
        <button type="button" id="submitForm" class="addToCart-productDetail-btn">Thêm vào giỏ</button>
    </div>
</form>


        </div>
      </div>
    </div>


    <div class="nav-bar">
      <button class="nav-button active" onclick="showSection('product-info')">THÔNG TIN SẢN PHẨM</button>
      <button class="nav-button" onclick="showSection('reviews')">ĐÁNH GIÁ NHẬN XÉT</button>
    </div>

    <div id="product-info" class="section">
      <h2>Thông tin sản phẩm</h2>
      
    
      <ul>
          <li><b></b>
              <%=productGroup.getDes() %>
          </li>
      </ul>

    </div>

    <div id="reviews" class="section" style="display: none;">
      <h2>Đánh Giá Nhận Xét</h2>
      <h1><%=productGroup.getProductGroupName() %></h1>
      <div class="product-rating">

        <div class="ratingBig">
          <div class=" big-stars"><%=ValidateCommon.formatStarRate(star.getStarRate(), 1) %>★</div>
        </div>
        <p class="danhgia1">Đánh giá trung bình</p>
        <p class="danhgia2">(dựa trên <%=star.getRateNum()%> đánh giá)</p>
	<%
	if (session.getAttribute("accountInfor") != null) {
	%>
        <a href="#" onclick="openModal()" class="rate-button">ĐÁNH GIÁ NGAY</a>
     <%}else{} %>   
      
      </div>
<%-- <%for(DanhgiaDTO r:rate){ %>
      <div class="review">
        <span class="username"><%=r.getFullname() %></span>
        <div>
 		<%for(int i=1; i<=5; i++) {
 			if(i<=r.getStar()){ %>
 			<div class="stars12">★</div>
 			<%} else{ %><div class="stars123">★</div> <%} %>
 		<%} %>
       
        </div>
        <p class="comment"><%=r.getComment() %></p>
      </div>
      <%} %> --%>
      
      <%for(DanhgiaDTO r:rate){ %>
      <div class="review">
        <span class="username"><%=r.getFullname() %></span>
        <div class="stars1">
 		<%for(int i=1; i<=5; i++) {
 			if(i<=r.getStar()){ %>
 			<span class="star full">★</span>
 			<%} else{ %>
 			<span class="star empty">★</span> 
 			<%} %>
 		<%} %>
       
        </div>
        <p class="comment"><%=r.getComment() %></p>
      </div>
      <%} %>

       <!-- <div class="review">
        <span class="username">Trang</span>
        <div class="stars1">★★★★★</div>
        <p class="comment">Mình bị da sưng nặng lông nên dùng 2% BHA lotion hay 10% AHA?</p>
        <p class="date">Trà lời - 19/07/2020</p>
      </div>  -->

      <!-- Thêm các đánh giá khác ở đây -->
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

  <!-- Modal -->
  <div id="myModal" class="modal">
    <form class="modal-content" action="RateServlet" method="post">
      <span class="close" onclick="closeModal()">&times;</span>
      <div class="modal-title"><%=productGroup.getProductGroupName()%>
      </div>
      <textarea class="input-field" placeholder="Bạn cảm thấy thế nào về sản phẩm?" name="comment"></textarea>
        <div>
            <div class="stars">
                <input type="radio" name="rating" value="1" id="star1"><label for="star1" class="star">★</label>
                <input type="radio" name="rating" value="2" id="star2"><label for="star2" class="star">★</label>
                <input type="radio" name="rating" value="3" id="star3"><label for="star3" class="star">★</label>
                <input type="radio" name="rating" value="4" id="star4"><label for="star4" class="star">★</label>
                <input type="radio" name="rating" value="5" id="star5"><label for="star5" class="star">★</label>
            </div>
            <input type="hidden" name="productGroupID" value="<%=productGroup.getProductGroupID()%>"/>
            <input type="hidden" name="productID" value="<%=productDetail.getProductID()%>"/>
        </div>
      
    <br>
    <div class="central">
    <button type="submit" class="rate-button">Gửi đánh giá</button>
    </div>
 <!--      <p>Lưu ý: Đánh giá sẽ được kiểm duyệt theo Chính sách của chúng tôi trước khi xuất bản.</p> -->
  </form>
</div>





  <script>
    $('input.input-qty').each(function () {
      var $this = $(this),
        qty = $this.parent().find('.is-form'),
        min = Number($this.attr('min')),
        max = Number($this.attr('max'))
      if (min == 0) {
        var d = 0
      } else d = min
      $(qty).on('click', function () {
        if ($(this).hasClass('minus')) {
          if (d > min) d += -1
        } else if ($(this).hasClass('plus')) {
          var x = Number($this.val()) + 1
          if (x <= max) d += 1
        }
        $this.attr('value', d).val(d)
      })
    })
  </script>

  <script>
    document.addEventListener("DOMContentLoaded", function () {
      // Assuming this value is provided by the server
      const numberOfStars = 4; // Example value

      const starContainer = document.getElementById("stars");
      const maxStars = 5;

      for (let i = 0; i < numberOfStars; i++) {
        starContainer.innerHTML += '<span class="star full">&#9733;</span>';
      }

      for (let i = numberOfStars; i < maxStars; i++) {
        starContainer.innerHTML += '<span class="star empty">&#9734;</span>';
      }
    });
  </script>



  <script>
    function showSection(sectionId) {
      const sections = document.querySelectorAll('.section');
      sections.forEach(section => {
        section.style.display = 'none';
      });

      const buttons = document.querySelectorAll('.nav-button');
      buttons.forEach(button => {
        button.classList.remove('active');
      });

      document.getElementById(sectionId).style.display = 'block';
      document.querySelector(`button[onclick="showSection('${sectionId}')"]`).classList.add('active');
    }
  </script>



  <script>
    // Open the modal
    function openModal() {
      document.getElementById("myModal").style.display = "block";
    }

    // Close the modal
    function closeModal() {
      document.getElementById("myModal").style.display = "none";
    }


    function rateProduct(starsReview) {
      // You can send the selected rating to the server or perform other actions here
      console.log(`User rated ${stars} stars.`);
    }
  </script>
  
  <script type="text/javascript">
  document.getElementById('submitForm').addEventListener('click', function() {
	    var form = document.getElementById('addCartForm');
	    var formData = new FormData(form);
	    
	    const showCustomAlert = (message) => {
	        const alertElement = document.getElementById('customAlert');
	        alertElement.textContent = message;
	        alertElement.classList.remove('hidden');
	        alertElement.classList.add('show');

	        setTimeout(() => {
	            alertElement.classList.remove('show');
	            setTimeout(() => {
	                alertElement.classList.add('hidden');
	            }, 500); // Thời gian khớp với thời gian của transition
	        }, 1500); // Hiển thị thông báo trong 3 giây
	    };

	    console.log('Quantity:', formData.get('Quantity'));  // Should log the quantity
	    console.log('proID:', formData.get('proID'));        // Should log the product ID

	    var xhr = new XMLHttpRequest();
	    xhr.open('POST', form.action, true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');

	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	            	console.log('xhr.responseText:', xhr.responseText);
	                if (xhr.responseText === 'success') {
	                	showCustomAlert('Sản phẩm đã được thêm vào giỏ hàng.');
	                } else {
	                	showCustomAlert('Có lỗi xảy ra. Vui lòng thử lại.');
	                }
	            } else {
	            	showCustomAlert('Có lỗi xảy ra. Vui lòng thử lại.');
	            }
	        }
	    };

	    xhr.send("proID=" + encodeURIComponent(formData.get('proID')) + "&Quantity=" + encodeURIComponent(formData.get('Quantity')));
	});


  </script>
  
 <script>
    const stars = document.querySelectorAll('.star');
    stars.forEach((star, index) => {
        star.addEventListener('click', () => {
            stars.forEach((s, i) => {
                if (i <= index) {
                    s.classList.add('active');
                } else {
                    s.classList.remove('active');
                }
            });
        });
    });

    function closeModal() {
        document.getElementById('myModal').style.display = 'none';
    }
</script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    const showAlertMessage = (message) => {
        const alertElement = document.getElementById('thongbao');
        alertElement.textContent = message;
        alertElement.classList.remove('hidden');
        alertElement.classList.add('show');

        setTimeout(() => {
            alertElement.classList.remove('show');
            setTimeout(() => {
                alertElement.classList.add('hidden');
            }, 500); // Thời gian khớp với thời gian của transition
        }, 1500); // Hiển thị thông báo trong 1,5 giây
    };

    // Sử dụng hàm showAlertMessage khi cần thiết
    // Ví dụ: khi thông báo thành công
    showAlertMessage('Đánh giá thành công!');
});
</script>





</body>

</html>