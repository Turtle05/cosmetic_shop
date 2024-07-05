<%@page import="model.bean.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<head>
<title>Khách hàng</title>
</head>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%ArrayList<Customer> customerList = (ArrayList<Customer>)request.getAttribute("customerList"); %>

<%
	String searchText = session.getAttribute("searchCustomerText") != null
			? (String) session.getAttribute("searchCustomerText"): "";
	 String functionPrefix = "".equals(searchText) ? "ShowCustomerListServlet" : "SearchCustomerServlet"; 
	%>
  <main id="main" class="main">
			
                    
                    <% String error1 = request.getParameter("message1"); %>
                              	    <% if ("5".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
                              	    <% if ("10".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
                              	    <% if ("11".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
    <div class="pagetitle">
      <h1>Quản lý khách hàng</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Khách hàng</li>
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
								<form action="createCustomer.jsp">
									<button type="submit" class="btn btn-primary">Tạo mới</button>
								</form>
							</div>
							<div class="col d-flex justify-content-end">
								<form method="POST" action="SearchCustomerServlet">
									<div class="input-group" style="padding-right: 120px;">
										<input type="text" name="searchText"  value="<%=searchText%>" class="form-control"
											placeholder="Tìm kiếm" title="Nhập từ khóa tìm kiếm">
										<button type="submit" class="btn btn-primary" title="Tìm kiếm">
											<i class="bi bi-search"></i>
										</button>
									</div>
								</form>
							</div>
						</div><br>

							<!-- Table  -->
						
							<table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										<th>Mã KH </th>	
										<th>Tên khách hàng</th>
										<th>Số điện thoại</th>
										<th>Địa chỉ</th>
										<th>Tài khoản</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								<%int i = 1; %>
									<%for(Customer c : customerList){ %>
									<tr>
										<td><%=i++ %></td>
										<td><%=c.getCustomerID()%></td>
										<td><%=c.getFullname()%></td>
										<td><%=c.getPhone()%></td>
										<td><%=c.getAddress()%></td>
										<td>
										
										<%if("true".equals(c.getEnable())) { %><button  onclick="location.href='EnableCustomerServlet?userID=<%=c.getCustomerID()%>&e=false';" class="btn btn-primary btn-sm"><i class="fa-solid fa-lock-open"></i></button>
								
								<%} else {%>
								<button  onclick="location.href='EnableCustomerServlet?userID=<%=c.getCustomerID()%>&e=true';" class=" btn btn-outline-danger btn-sm"><i class="fa-solid fa-lock"></i></button><%}%>
										</td>
									
										<td>	
													<input type="hidden" name="customerID" value="<%=c.getCustomerID()%>"/>
													<input class="btn btn-primary btn-sm"
													type="button"
													onclick="location.href='ShowEditCustomerServlet?customerID=<%=c.getCustomerID()%>';"
													value="Xem" />

												<button  onclick="location.href='DeleteCustomerServlet?customerID=<%=c.getCustomerID()%>';" class="btn btn-outline-danger btn-sm">Xóa</button>
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
    
    <% if ("5".equals(error1)) { %>showAlertMessage('Thêm mới khách hàng thành công!');<% } %>
    <% if ("10".equals(error1)) { %>showAlertMessage('Xóa khách hàng thành công!');<% } %>
    <% if ("11".equals(error1)) { %>showAlertMessage('Không thể xóa khách hàng này!');<% } %>
    
    
    
 
});
</script>


 