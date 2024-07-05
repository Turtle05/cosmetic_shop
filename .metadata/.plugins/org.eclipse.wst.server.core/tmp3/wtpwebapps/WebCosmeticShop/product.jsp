<%@page import="model.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<head>
<title>Sản phẩm</title>
</head>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

<%ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>)request.getAttribute("productList"); %>

<%
	String searchText = session.getAttribute("searchProductText") != null
			? (String) session.getAttribute("searchProductText"): "";
	 String functionPrefix = "".equals(searchText) ? "ShowProductListServlet" : "SearchProductServlet"; 
	%>
	
	<% String error1 = request.getParameter("message1"); %>
                              	    <% if ("5".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
                              	    <% if ("2".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("12".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>

<%-- <%
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
	%> --%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý sản phẩm</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Sản phẩm</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body"><br>
					
							
							<div class="row d-flex align-items-center">
							<div class="col">
								<form action="ShowCreateProductServlet">
									<button type="submit" class="btn btn-primary">Tạo mới</button>
								</form>
							</div>
							<div class="col d-flex justify-content-end">
								<form method="POST" action="SearchProductServlet">
									<div class="input-group" style="padding-right: 70px;">
										<input type="text"  value="<%=searchText%>" name="searchText" class="form-control"
											placeholder="Tìm kiếm" title="Nhập từ khóa tìm kiếm">
										<button type="submit" class="btn btn-primary" title="Tìm kiếm">
											<i class="bi bi-search"></i>
										</button>
									</div>
								</form>
							</div>
						</div><br>
						
						
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										<th>Mã</th>
									    <th>Ảnh</th>
										<th>Tên sản phẩm</th>
										<th>Danh mục</th>
										<th>Thương hiệu</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
       <%-- <%int RowInPage = 5; %>
        <%int i = (currentPageNumer - 1) * RowInPage + 1;%> --%>
        <%int i = 1; %>
        <% for (ProductDTO p : productList) { %>
        <tr>
            <td><%= i++ %></td>
            <td><%=p.getProductGroupID() %></td>
            <td><img src='<%=p.getImage()%>' width='60' height='60' align="middle" border='1px'></td>
            <td><%=p.getProductGroupName()%></td>
            <td><%=p.getCategoryName()%></td>
            <td><%=p.getBrandName()%></td>
            <td>
                 <input class="btn btn-primary btn-sm"
													type="button"
													onclick="location.href='ShowEditProductServlet?productGroupID=<%=p.getProductGroupID()%>';"
													value="Sửa" /> 
       
               
            </td>
        </tr>
        <% } %>
    </tbody>
							</table>
							<!-- End Table with stripped rows -->
							
							
							
<%-- <%
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
	%> --%>


						</div>
					</div>

				</div>
			</div>
		</section>

	</main><!-- End #main -->

  <!-- ======= Footer ======= -->
 <!--  <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span>Admin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      
      Designed by <a href="https://bootstrapmade.com/">trihau02</a>
    </div>
  </footer>End Footer
 -->
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>


  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  
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
    <% if ("5".equals(error1)) { %>showAlertMessage('Thêm sản phẩm thành công!');<% } %>
    <% if ("1".equals(error1)) { %>showAlertMessage('Lỗi trùng khóa');<% } %>
    <% if ("12".equals(error1)) { %>showAlertMessage('Xóa sản phẩm thành công');<% } %>
    
    
    
 
});
</script>