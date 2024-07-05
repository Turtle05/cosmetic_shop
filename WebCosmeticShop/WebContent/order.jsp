<%@page import="common.StringCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="model.dto.OrderDTO"%>
 <head>
<title>Đơn hàng</title>
<style>
.hang:hover {
	cursor: pointer;
}


</style>
</head>

<%@page import="model.dto.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
    
    


<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

<%ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>)request.getAttribute("orderList"); %>
  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý đơn hàng</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Đơn hàng</li>
        </ol>
      <!--   <form action="ShowCreateOrderServlet">
         <button type="submit" class="btn btn-primary">Tạo mới</button>
         </form> -->
      </nav>
      
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <br>
                
              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                 	<th>STT</th>
                    <th>Mã đơn hàng</th>
                    <th>Khách hàng</th>
<!--                     <th>Nhân viên</th> -->
                    <th>Tổng tiền</th>
                    <th>Trạng thái</th>
                    <th></th>
                    
                  </tr>
                </thead>
               <tbody>
				        <% int i = 1; %>
				        <% for (OrderDTO o : orderList) { %>
				        <tr class="hang"onclick="location.href='ShowOrderDetail?orderID=<%=o.getOrderID()%>';">
				            <td><%= i++ %></td>
				            <td><%=o.getOrderID()%></td>
				            <td><%=o.getCustomerName()%></td>
<%-- 				            <td><%=o.getEmployeeName()%></td> --%>
				            <td><%=StringCommon.formatCurrency(o.getGrandTotal())%></td>
				            <td>
				            <%if("cho".equals(o.getStatus())){%>
				            <span class="order-status-cho">Chờ xác nhận</span>
				            <%}%>
				            <%if("giao".equals(o.getStatus())){%>
				            <span class="order-status-giao">Đang giao</span>
				            <%}%>
				            <%if("xong".equals(o.getStatus())){%>
				            <span class="order-status-xong">Hoàn thành</span>
				            <%}%>
				            <td>
				                 <input class="btn btn-primary btn-sm"
																	type="button"
																	onclick="location.href='ShowEditProductServlet?orderID=<%=o.getOrderID()%>';"
																	value="Xem" /> 
				       
				               
				                      
				 
				            </td>
				        </tr>
        <% } %>
    </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
<!--   <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span>Trihau02</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
     
      Designed by <a href="#">Trihau02</a>
    </div>
  </footer>End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <script src="assets/js/main.js"></script>
