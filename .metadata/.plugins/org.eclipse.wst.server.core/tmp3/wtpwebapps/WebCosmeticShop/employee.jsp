<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <head>
<title>Nhân viên</title>
</head>
<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>

    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">


<html>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%ArrayList<User> employeeList = (ArrayList<User>)request.getAttribute("employeeList"); %>
<%int a = 1; %>
  <main id="main" class="main">
					<% String error1 = request.getParameter("message1"); %>
					<%=("5".equals(error1)) ? "Thêm mới nhân viên thành công!" : "" %>
					<%=("10".equals(error1)) ? "Xóa nhân viên thành công!" : "" %>
					<%=("11".equals(error1)) ? "Thay đổi trạng thái tài khoản nhân viên thành công!" : "" %>
					<% String error = request.getParameter("message"); %>
                    <%=("5".equals(error)) ? "Sửa thông tin nhân viên thành công!" : "" %>
                    
  				<% if ("10".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
          	    <% if ("11".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
          	    <% if ("5".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
 <%--          	    <% if ("5".equals(error)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>  --%>

    <div class="pagetitle">
      <h1>Quản lý nhân viên</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Nhân viên</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body"><br>
						
						<%if("admin".equals((session.getAttribute("role")))) {%>
								<div class="row d-flex align-items-center">
							<div class="col">
								<form action="addEmployee.jsp">
									<button type="submit" class="btn btn-primary">Tạo mới</button>
								</form>
							</div>
							<% } %>
						
						<!-- 	<div class="col d-flex justify-content-end">
								<form method="POST" action="#">
									<div class="input-group" style="padding-right: 120px;">
										<input type="text" name="query" class="form-control"
											placeholder="Tìm kiếm" title="Nhập từ khóa tìm kiếm">
										<button type="submit" class="btn btn-primary" title="Tìm kiếm">
											<i class="bi bi-search"></i>
										</button>
									</div>
								</form>
							</div> -->
						</div><br>
						
						
						
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										
										<!-- <th>Ảnh</th> -->	
										<th>Mã nhân viên</th>	
										<th>Tên nhân viên</th>
										<th>Giới tính</th>
										<th>Địa chỉ</th>
										<%if("admin".equals((session.getAttribute("role")))) {%>
										<th>Tài khoản</th>
										<% } %>
										
										<th></th>
									</tr>
								</thead>
								<tbody>
								<%int i = 1; %>
									<%for(User e : employeeList){ %>
									<tr>
										<td><%=i++ %></td>
						<%-- 				<td><%=e.getImage()%></td> --%>
										<td><%=e.getUserID()%></td>
										<td><%=e.getFullName()%></td>
										<td><%=e.getPhone()%></td>
										<td><%=e.getAddress()%></td>
										
										
										
										<%if("admin".equals((session.getAttribute("role")))) {%>
													<td>
													<%if("true".equals(e.getEnable())) { %>
													<button  onclick="location.href='EnableServlet?userID=<%=e.getUserID()%>&e=false';" class="btn btn-primary btn-sm"><i class="fa-solid fa-lock-open"></i></button>
													<%} else {%>
														<button  onclick="location.href='EnableServlet?userID=<%=e.getUserID()%>&e=true';" class=" btn btn-outline-danger btn-sm"><i class="fa-solid fa-lock"></i></button><%}%>
														</td>
												<% } %>
										
										<td>	
													
													<input class="btn btn-primary btn-sm"
													type="button"
													onclick="location.href='ShowEditEmployeeServlet?userID=<%=e.getUserID()%>';"
													value="Xem" />
											<%if("admin".equals((session.getAttribute("role")))) {%>
												<button  onclick="location.href='DeleteEmployeeServlet?userID=<%=e.getUserID()%>';" class="btn btn-outline-danger btn-sm">Xóa</button>
											<% } %>
											<!-- </form> -->
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
    <% if ("10".equals(error1)) { %>showAlertMessage('Xóa nhân viên thành công!');<% } %>
    <% if ("11".equals(error1)) { %>showAlertMessage('Thay đổi trạng trái tài khoản thành công');<% } %>
    <% if ("5".equals(error1)) { %>showAlertMessage('Thêm mới nhân viên thành công!');<% } %>
    <% if ("5".equals(error)) { %>showAlertMessage('Sửa thông tin nhân viên thành công!');<% } %>
    
    
 
});
</script>

</html>



 