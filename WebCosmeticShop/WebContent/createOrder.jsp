<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="model.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<head>
<title>Thông tin cá nhân</title>
  <link href="https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logof.jpg" rel="icon">
</head>
<%@page import="model.bean.Employee"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<html>

<style>
.createOrder{
width: 100%;
height: 100%;
background-color: blue;
top: 60px;
gap: 5px;
position: fixed;
display: flex;
}
.searchProduct{
height: 100%;
width: 60%;
background-color: white;
border: black solid 1px;
/* margin: 10px; */
border-radius: 5px;
margin-bottom: 200px;
}
.searchCustomer{
height: 100%;
width: 40%;
background-color: white;
border: red solid 1px;

border-radius: 5px;
}

.search-button{
background-color: blue;
padding: 10px 12px 10px 12px;

color: white;
margin-left: 10px;
border-radius: 5px 5px 5px 5px;
border: none;	
}

.search-button:hover{
background-color: red;
}

.input-search{
display: flex;
margin: 30px 40px 0 40px;
}

.create-btn{
background-color: white;
padding: 5px 12px 5px 12px;
margin-right: 10px;
border-radius: 5px 5px 5px 5px;
border: black solid: 1px;
}

.label-order{
margin	: 10px 30px 0 30px;
display: flex;
border: black solid: 1px;
}

.label-order p{
font-weight: bold;
margin: 0;
}


.value-order{

text-align: right;
}

.label-order-btn{
text-align: center;
padding: 50px 50px 50px 50px;

}
.table-product{
margin: 30px;
}

</style>

<%@ include file="header.jsp" %>

<%ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>)request.getAttribute("productList"); %>

<%
	String searchText = session.getAttribute("searchProductText") != null
			? (String) session.getAttribute("searchProductText"): "";
	 String functionPrefix = "".equals(searchText) ? "ShowCreateOrderServlet" : "SearchProductServlet"; 
	%>

<%
	int currentPageNumer = (Integer) request.getAttribute("currentPageNumer"); // Do server trả về

	int totalPageNumber = (Integer) request.getAttribute("totalPageNumber"); // Do server trả về

	int[] pageNumberList = new int[10]; // Do client tự tính toán

	int pageQuantity = 0; // Do client tự tính toán

	// Tình huống số 1:
	//tổng số trang nhỏ hơn hoặc bằng 10

	if (totalPageNumber <= 10) {

		for (int j = 0; j < totalPageNumber; j++) {

			pageNumberList[j] = j + 1;

			pageQuantity++;

		}

	}

	// Tình huống số 2 nằm trong tình huống số 4 rồi

	// Tình huống số 3:
	// Nếu tổng số trang lớn hơn 10, và currentPageNumer <= 4, thì ta luôn luôn in ra là 1 2 3 4 5 6 7 8 9 10.

	// Tình huống số 3:

	if (totalPageNumber > 10 && currentPageNumer <= 4) {

		for (int j = 0; j < 10; j++) {

			pageNumberList[j] = j + 1;

			pageQuantity++;

		}

	}

	// Tình huống số 4
	if (totalPageNumber > 10 && currentPageNumer >= (totalPageNumber - 5)) {

		for (int j = 10; j >= 1; j--) {

			pageNumberList[j - 1] = totalPageNumber - (10 - j);

			pageQuantity++;

		}

	}

	// Tình huống số 5:

	if (totalPageNumber > 10 && currentPageNumer >= 5 && currentPageNumer <= (totalPageNumber - 5)) {

		for (int j = 0; j < 10; j++) {

			pageNumberList[j] = currentPageNumer - 3 + j;

			pageQuantity++;

		}

	}
	%>






<body>


<div class="createOrder">
    









      <div class="searchProduct">
      <section class="section profile">
      <form method="POST" action="SearchProductServlet">
									<div class="input-search">
										<input type="text"  value="" name="searchText" class="form-control"
											placeholder="Tìm sản phẩm" title="Nhập từ khóa tìm kiếm">
										<button type="submit" class="search-button" title="Tìm kiếm">
											<i class="bi bi-search"></i>
										</button>
									</div>
								</form>
   
      </section>
      <div class="table-product">
      <table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										<th>Mã</th>
									    <th>Ảnh</th>
										<th>Tên sản phẩm</th>
										<th>Tùy chọn</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
       <%int RowInPage = 5; %>
        <%int i = (currentPageNumer - 1) * RowInPage + 1;%>
        <% for (ProductDTO p : productList) { %>
        <tr>
            <td><%= i++ %></td>
            <td><%=p.getProductGroupID() %></td>
            <td><img src='<%=p.getImage()%>' width='60' height='60' align="middle" border='1px'></td>
            <td><%=p.getProductGroupName()%></td>
            <td><%=p.getCategoryName()%></td>
            <td>
          <%--        <input class="btn btn-primary btn-sm"
													type="button"
													onclick="location.href='ShowEditProductServlet?productGroupID=<%=p.getProductGroupID()%>';"
													value="Sửa" /> --%> 
       
                
<!--                <button type="button" class="btn btn-outline-danger btn-sm btn-delete">Xóa</button>  -->
						<button type="submit" class="create-btn" >+</button>
                      
                
            </td>
        </tr>
        <% } %>
    </tbody>
							</table>
							
					<%
	if (currentPageNumer > 1) {
	%>

	<a href='<%=functionPrefix%>?page=1'>Đầu</a>

	<a href='<%=functionPrefix%>?page=<%=currentPageNumer - 1%>'> <<
	</a>

	<%
	}
	for (int k = 0; k < pageQuantity; k++) {

	if (pageNumberList[k] == currentPageNumer) {
	%>

	<a href='<%=functionPrefix%>?page=<%=pageNumberList[k]%>'><b><%=pageNumberList[k]%></b></a>

	<%
	} else {
	%>

	<a href='<%=functionPrefix%>?page=<%=pageNumberList[k]%>'><%=pageNumberList[k]%></a>

	<%
	}

	}
	%>



	<%
	if (currentPageNumer < totalPageNumber) {
	%>

	<a href='<%=functionPrefix%>?page=<%=currentPageNumer + 1%>'> >> </a>

	<a href='<%=functionPrefix%>?page=<%=totalPageNumber%>'>Cuối</a>

	<%
	}
	%>
							
		</div>					
      </div>
      
      <div class="searchCustomer">
      <section class="section profile">
      <form method="POST" action="SearchProductServlet">
									<div class="input-search" >
									<button type="submit" class="create-btn" title="Tạo khách hàng">
											+
										</button>
										<input  type="text"  value="" name="searchText" class="form-control"
											placeholder="Tìm khách hàng" title="Nhập từ khóa tìm kiếm">
										<button type="submit" class="search-button" title="Tìm khách hàng">
											<i class="bi bi-search"></i>
										</button>
										
									</div>
								</form>
								
								<div class="label-order ">
				                    <div class="col-lg-8  "><p>Khách hàng</p></div>
				                    <div class="col-lg-4  value-order" >Nguyễn Văn A</div>
				                </div>
				                
								<div class="form-order">
								<div class="label-order">
				                    <div class="col-lg-6  "><p>Sản phẩm</p></div>
				                    <div class="col-lg-2  ">Đơn giá</div>
				                    <div class="col-lg-2  ">SL</div>
				                </div>
				                
				                	<div class="label-order">
				                    <div class="col-lg-6  ">-Sửa rửa mặt Nerman giúp da khỏe tự nhiên ,ngăn ngừa mụn</div>
				                    <div class="col-lg-2  ">300000</div>
				                    <div class="col-lg-2  ">3</div>
				                    <div class="col-lg-2  value-order">900000</div>
				                </div>

                 				 <div class="label-order">
				                    <div class="col-lg-8  "><p>Tổng tiền hàng</p></div>
				                    <div class="col-lg-4  value-order" >0000000</div>
				                </div>
                  
                   				<div class="label-order">
				                    <div class="col-lg-8  "><p>Giảm giá</p></div>
				                    <div class="col-lg-4  value-order" >000</div>
				                </div>
				                
				                <div class="label-order ">
				                    <div class="col-lg-8  "><p>Khách cần trả</p></div>
				                    <div class="col-lg-4  value-order" >000</div>
				                </div>
				                <div class="label-order-btn">
				                	<button type="submit" class="search-button" title="Tìm khách hàng">
											Thanh toán
										</button>
								</div>
				                </div>
   
      </section>
      </div>
      
      
      
       
        

        <%-- <div class="col-xl-4 ">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Tổng quan</button>
                </li>

             
              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                  
                  <h5 class="card-title">Thông tin cá nhân</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Họ và tên</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getFullName() %></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Giới tính</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getGender() %>  </div>
                  </div>
                  
                   <div class="row">
                    <div class="col-lg-3 col-md-4 label">Ngày sinh</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getBirthday() %>  </div>
                  </div>
                  
   					

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Địa chỉ</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getAddress()%></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Số điện thoại</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getPhone() %></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8"><%=profile.getEmail() %></div>
                  </div>

                </div>
                
                
			



              				  
   

                </div>

                

          

              </div><!-- End Bordered Tabs -->

            </div>
          </div> --%>

        </div>


</body>





<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
  <script src="assets/js/main.js"></script>
<%--  	<script>
    
    $(document).ready(function() {
        $("#inputImage").change(function() {
            showImage(this);
        });
        
        $("#removeImage").click(function() {
            resetImage();
        });
    });

    function showImage(fileInput) {
        const file = fileInput.files[0];
        const reader = new FileReader();
        reader.onload = function(e) {
            $("#myimage").attr("src", e.target.result);
        };
        reader.readAsDataURL(file);
    }

    function resetImage() {
        // Sử dụng đường dẫn mặc định hoặc thực hiện các hành động cần thiết để reset ảnh
        $("#myimage").attr("src", "<%=profile.getImage()%>");
        // Xóa giá trị của input file
        $("#inputImage").val('');
    }

	</script>   --%>


</html>
  

