  <%@page import="model.dto.OrderDTO"%>
  <%@page import="common.StringCommon"%>
    <%@page import="model.dto.OrderDetailDTO"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<style>
.updateOrder{
padding: 10px;
color: white;
background-color: #0d6efd;
border: none;
border-radius: 3px;
margin: 15px;
}


.infor-summary {
        padding: 30px;
        width: 100%;
        padding: 20px;
        box-sizing: border-box;
        border: #ccc solid 1px;
        border-radius: 5px;
    }
.table-order-detail {
        width: 100%;
        box-sizing: border-box;
        margin: 20px 0 20px 0;
    }

    .table-order-detail th {
        text-align: left;
        font-size: 16px;
        padding: 10px;
        font-family: Proxima, sans-serif !important;
        border-bottom: #ccc solid 1px;
    }

    .table-order-detail td {
    	width: 300px;
        text-align: left;
        font-size: 16px;
        padding: 10px;
        font-family: "Open Sans", sans-serif !important;
        align-content: flex-start;
        border-bottom: #ccc solid 1px;
    }

    .central {
        text-align: center !important;
    }
    .bold {
       font-weight: bold !important;
    }
    .end-td {
       text-align: right !important;
    }

    .detail-order-lable p {
        margin: 10px;
        font-size: 17px;
        
    }

    .detail-order-lable h2 {
        margin-bottom: 10px;
    }

    .table-infor-user tr,
    .table-infor-user td {

        font-size: 16px;
        padding: 5px;
        font-family:  "Open Sans", sans-serif;
    }
</style>
<body>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

 
  <main id="main" class="main">

<%
    OrderDTO order = (OrderDTO) request.getAttribute("order");
    if (order != null) {
        
    } else {
        out.println("Không có sản phẩm!");
    }
%>

<%
    ArrayList<OrderDetailDTO> orderDetail = (ArrayList<OrderDetailDTO>) request.getAttribute("orderDetail");%>

      	   



   <!--  <div class="pagetitle">
      <h1>Sửa thông tin khách hàng</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowEmployeeListServlet">Khách hàng</a></li>
          <li class="breadcrumb-item active">Sửa thông tin khách hàng</li>
        </ol>
      </nav>
    </div> --><!-- End Page Title -->
					<p class="text-center small" style="color: green;" >
                         <% String error = request.getParameter("message"); %>
            	         <%=("1".equals(error)) ? "Cập nhật đơn hàng thành công!" : "" %>
            	         <%=("2".equals(error)) ? "Lỗi ở server! Cập nhật không thành công" : "" %>
            	        
					</p>


		<section class="section">
			<div class="row">      
				<div class="col-lg-12">

			

          <div class="card">
            <div class="card-body">
              <br>
           
                    <div class="infor-summary">
                <div class="central detail-order-lable">
                    <h2>Chi Tiết Đơn Hàng</h2>
                    <p>Đơn hàng #<%=order.getOrderID()%> đã đặt vào lúc <%=StringCommon.validateDateTime(order.getOrderDate())%> </p>
                    <%if("cho".equals(order.getStatus())){%>
				            <span class="order-status-cho">Chờ xác nhận</span>
				            <%}%>
				            <%if("giao".equals(order.getStatus())){%>
				            <span class="order-status-giao">Đang giao</span>
				            <%}%>
				            <%if("xong".equals(order.getStatus())){%>
				            <span class="order-status-xong">Hoàn thành</span>
				            <%}%>
                    
                </div>
                <table class="table-infor-user">
                    <tr>
                        <td colspan="2"><b>Thông tin thanh toán:</b></td>
                    </tr>
                    <tr>
                        <td>Tên người mua:</td>
                        <td><%=order.getCustomerName() %></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ:</td>
                        <td><%=order.getAddress() %></td>
                    </tr>
                    <tr>
                        <td>Số điên thoại:</td>
                        <td><%=order.getPhone() %></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>k1@gmail.com</td>
                    </tr>
                    
                </table>







                <div class="table-order-detail">
                    <table>
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th class="end-td">Tạm tính</th>
                        </tr>
                         <%for(OrderDetailDTO o : orderDetail) { %>  

                        <tr>
                            <td>
                                 <%=o.getProductName() %> <%=o.getSize() %>                        
                            </td>
                            <td>
                                 <%=StringCommon.formatCurrency(o.getPrice()) %>                            
                            </td>
                            <td><%=o.getQuantity()%></td>
                            <td class="end-td">
                                <%=StringCommon.formatCurrency(o.getPrice() * o.getQuantity()) %>
                            </td>
                        </tr>
                        <%} %>  



                        <tr>
                            <th>Tổng tạm tính</th>
                            <td></td>
                            <td></td>
                            <td class="end-td"><%=StringCommon.formatCurrency(order.getGrandTotal()) %></td>
                        </tr>
                        <tr>
                            <th>Vận chuyển</th>
                            <td></td>
                            <td></td>
                            <td class="end-td">Giao hàng miễn phí</td>
                        </tr>
                        <tr>
                            <th>Phương thức thanh toán</th>
                            <td></td>
                            <td></td>
                              <%if("paypal".equals(order.getPayment())) { %>
                                    <td class="end-td">Thanh toán qua Paypal</td>
                                    <% } else { %> 
                            <td class="end-td">Thanh toán khi nhận hàng </td>
                         	<%} %>  

                        </tr>
                        <tr>
                            <th class="bold">Tổng thanh toán</th>
                            <td></td>
                            <td></td>
                            <td class="end-td bold"><%=StringCommon.formatCurrency(order.getGrandTotal()) %></td>
                        </tr>
                    </table>

                </div>
                
                <%if(!"xong".equals(order.getStatus())) {%>
                    <form action="UpdateOrderServlet" method="post">
                    <input type="hidden" name="status" value="<%=order.getStatus() %>"/>
                    <input type="hidden" name="orderID" value="<%=order.getOrderID() %>"/>
                    <div class="central">
                    <button class="updateOrder">Cập nhật đơn hàng</button>
                    </div>
                    </form>
                    <%} %>

            </div>

                </div>

        
          </div>

        </div>

        
			</div>
		</section>

	</main><!-- End #main -->
</body>	  
	  

  <!-- Template Main JS File -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
  <script src="assets/js/main.js"></script>
  

  </html>