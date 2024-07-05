<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <head>
<title>Danh mục</title>
</head>
   <!-- Include SweetAlert2 CSS -->
    <link rel="stylesheet" href="sweetalert2.min.css">
     <!-- Include SweetAlert2 JavaScript -->
    <script src="sweetalert2.min.js"></script>
    <script src="sweetalert2.all.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%ArrayList<Category> catList = (ArrayList<Category>)request.getAttribute("catList"); %>
  <main id="main" class="main">
  
<% String error = request.getParameter("message"); %>
<% if ("5".equals(error)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
                       	  
<% String error1 = request.getParameter("message1"); %>
<% if ("10".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
<% if ("11".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
   	
  
    
	
    <div class="pagetitle">
      <h1>Quản lý danh mục</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Danh mục</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
						<br>
						<form action="CreateCategory"><button type="submit" class="btn btn-primary">Tạo mới</button></form>
							
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										<th>Mã danh mục</th>
										<th>Tên danh mục</th>
										<th>Nhóm danh mục</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								<%int i = 1; %>
									<%for(Category c : catList){ %>
									<tr>
										<td><%=i++ %></td>
										<td><%=c.getCategoryID() %></td>
										<td><%=c.getCategoryName() %></td>
										<td><%=c.getCategoryGroupName() %></td>
										<td>
											
												<input class="btn btn-primary btn-sm"
													type="button"
													onclick="location.href='ShowEditCategoryServlet?catID=<%=c.getCategoryID()%>';"
													value="Sửa" />

												<button  onclick="location.href='DeleteCategoryServlet?categoryID=<%=c.getCategoryID()%>';" class="btn btn-outline-danger btn-sm">Xóa</button>
										
										</td>
									</tr>
<%} %>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

						</div>
					</div>

				</div>
			</div>
		</section>

	</main><!-- End #main -->
	  
<script type="text/javascript">
  
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
    
    <% if ("5".equals(error)) { %>showAlertMessage('Thêm mới danh mục thành công!');<% } %>
    <% if ("10".equals(error1)) { %>showAlertMessage('Xóa danh mục thành công!');<% } %>
    <% if ("11".equals(error1)) { %>showAlertMessage('Không thể xóa danh mục này!');<% } %>
    
    
    
 
});
</script>


 

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
 
 

   