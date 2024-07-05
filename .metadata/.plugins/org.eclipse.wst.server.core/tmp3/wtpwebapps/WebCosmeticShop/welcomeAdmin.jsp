<%@page import="common.StringCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="model.dto.OrderDTO"%>
        <%@page import="model.dto.ProductDTO"%>
        <%@page import="java.util.ArrayList"%>
<head>
<title>Thống kê</title>
</head>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>


  <%String sales = (String)request.getAttribute("sales"); %>
  <%String cus = (String)request.getAttribute("cus"); %>
  <%String total = (String)request.getAttribute("total"); %>
  <%ArrayList<OrderDTO> orderList = (ArrayList<OrderDTO>)request.getAttribute("orderList"); %>
  <%ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>)request.getAttribute("productList"); %>
  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Thống kê</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Thống kê</li>
        </ol>
       
        
       
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="row">

        <!-- Left side columns -->
        <div class="col-lg-12">
          <div class="row">

            <!-- Sales Card -->
            <div class="col-xxl-4 col-md-6">
              <div class="card info-card sales-card">

                <!-- <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày</a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div> -->

                <div class="card-body">
                  <h5 class="card-title">Doanh số <!-- <span>| Ngày</span> --></h5>

                  <div class="d-flex align-items-center">
                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                      <i class="bi bi-cart"></i>
                    </div>
                    <div class="ps-3">
                      <h6><%=sales%></h6>
                      <!-- <span class="text-success small pt-1 fw-bold">12%</span> <span class="text-muted small pt-2 ps-1">increase</span> -->

                    </div>
                  </div>
                </div>

              </div>
            </div><!-- End Sales Card -->

            
            <!-- Customers Card -->
            <div class="col-xxl-4 col-md-6">

              <div class="card info-card customers-card">

               <!--  <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày</a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div> -->

                <div class="card-body">
                  <h5 class="card-title">Khách hàng <!-- <span>| Năm</span> --></h5>

                  <div class="d-flex align-items-center">
                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                      <i class="bi bi-people"></i>
                    </div>
                    <div class="ps-3">
                      <h6><%=cus%></h6>
                      <!-- <span class="text-danger small pt-1 fw-bold">12%</span> <span class="text-muted small pt-2 ps-1">decrease</span> -->

                    </div>
                  </div>

                </div>
              </div>

            </div><!-- End Customers Card -->
            
            
            <!-- Revenue Card -->
            <div class="col-xxl-4 col-xl-12">
              <div class="card info-card revenue-card">

                <!-- <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày</a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div> -->

                <div class="card-body">
                  <h5 class="card-title">Doanh thu <!-- <span>| Tháng</span> --></h5>

                  <div class="d-flex align-items-center">
                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                      <i class="bi bi-currency-dollar"></i>
                    </div>
                    <div class="ps-3">
                    <h6><%=StringCommon.formatCurrency(total)%></h6>
                      <!-- <span class="text-success small pt-1 fw-bold">8%</span> <span class="text-muted small pt-2 ps-1">increase</span>-->
                    </div>
                  </div>
                </div>

              </div>
            </div><!-- End Revenue Card -->
            

            <!-- Reports -->
            <!-- <div class="col-12">
              <div class="card">

                <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày </a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div>

                <div class="card-body">
                  <h5 class="card-title">Báo cáo <span>/Ngày</span></h5>

                  Line Chart
                  <div id="reportsChart"></div>

                  <script>
                    document.addEventListener("DOMContentLoaded", () => {
                      new ApexCharts(document.querySelector("#reportsChart"), {
                        series: [{
                          name: 'Doanh số',
                          data: [31, 40, 28, 51, 42, 82, 56],
                        }, {
                          name: 'Doanh thu',
                          data: [11, 32, 45, 32, 34, 52, 41]
                        }, {
                          name: 'Khách hàng',
                          data: [15, 11, 32, 18, 9, 24, 11]
                        }],
                        chart: {
                          height: 350,
                          type: 'area',
                          toolbar: {
                            show: false
                          },
                        },
                        markers: {
                          size: 4
                        },
                        colors: ['#4154f1', '#2eca6a', '#ff771d'],
                        fill: {
                          type: "gradient",
                          gradient: {
                            shadeIntensity: 1,
                            opacityFrom: 0.3,
                            opacityTo: 0.4,
                            stops: [0, 90, 100]
                          }
                        },
                        dataLabels: {
                          enabled: false
                        },
                        stroke: {
                          curve: 'smooth',
                          width: 2
                        },
                        xaxis: {
                          type: 'datetime',
                          categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
                        },
                        tooltip: {
                          x: {
                            format: 'dd/MM/yy HH:mm'
                          },
                        }
                      }).render();
                    });
                  </script>
                  End Line Chart

                </div>

              </div>
            </div> --><!-- End Reports -->

            <!-- Recent Sales -->
            <div class="col-12">
              <div class="card recent-sales overflow-auto">

                <!-- <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày</a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div> -->

                <div class="card-body">
                  <h5 class="card-title">Đơn hàng cần duyệt<!-- <span>| Ngày</span> --></h5>

                  <table class="table table-borderless datatable">
                    <thead>
                      <tr>
                        <th>STT</th>
                    <th>Mã đơn hàng</th>
                    <th>Khách hàng</th>
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

                </div>

              </div>
            </div><!-- End Recent Sales -->

            <!-- Top Selling -->
            <div class="col-12">
              <div class="card top-selling overflow-auto">

                <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Lọc</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Ngày</a></li>
                    <li><a class="dropdown-item" href="#">Tháng</a></li>
                    <li><a class="dropdown-item" href="#">Năm</a></li>
                  </ul>
                </div>

                <div class="card-body pb-0">
                  <h5 class="card-title">Sản phẩm bán chạy <span>| Ngày</span></h5>

                  <table class="table datatable">
                    <thead>
                      <tr>
                        <th>STT</th>
                        <th>Ảnh</th>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Đã bán</th>
                      </tr>
                    </thead>
                    <tbody>
                    
                       <% int j = 1; %>
				        <% for (ProductDTO p : productList) { %>
				        <tr>
				            <td><%= j++ %></td>
				            <td><img src='<%=p.getImage()%>' width='60' height='60' align="middle" border='1px'></td>
				            <td><%=p.getProductGroupID()%></td>
				            
				            <td><%=p.getProductGroupName()%></td>
				            <td><%=p.getCategoryName()%></td>

				        </tr>
				        <% } %>
                     
                    </tbody>
                  </table>

                </div>

              </div>
            </div><!-- End Top Selling -->

          </div>
        </div><!-- End Left side columns -->

        <!-- Right side columns -->
        <!-- <div class="col-lg-4">

          Recent Activity
          <div class="card">
            <div class="filter">
              <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                <li class="dropdown-header text-start">
                  <h6>Filter</h6>
                </li>

                <li><a class="dropdown-item" href="#">Today</a></li>
                <li><a class="dropdown-item" href="#">This Month</a></li>
                <li><a class="dropdown-item" href="#">This Year</a></li>
              </ul>
            </div>

            <div class="card-body">
              <h5 class="card-title">Recent Activity <span>| Today</span></h5>

              <div class="activity">

                <div class="activity-item d-flex">
                  <div class="activite-label">32 min</div>
                  <i class='bi bi-circle-fill activity-badge text-success align-self-start'></i>
                  <div class="activity-content">
                    Quia quae rerum <a href="#" class="fw-bold text-dark">explicabo officiis</a> beatae
                  </div>
                </div>End activity item

                <div class="activity-item d-flex">
                  <div class="activite-label">56 min</div>
                  <i class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>
                  <div class="activity-content">
                    Voluptatem blanditiis blanditiis eveniet
                  </div>
                </div>End activity item

                <div class="activity-item d-flex">
                  <div class="activite-label">2 hrs</div>
                  <i class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>
                  <div class="activity-content">
                    Voluptates corrupti molestias voluptatem
                  </div>
                </div>End activity item

                <div class="activity-item d-flex">
                  <div class="activite-label">1 day</div>
                  <i class='bi bi-circle-fill activity-badge text-info align-self-start'></i>
                  <div class="activity-content">
                    Tempore autem saepe <a href="#" class="fw-bold text-dark">occaecati voluptatem</a> tempore
                  </div>
                </div>End activity item

                <div class="activity-item d-flex">
                  <div class="activite-label">2 days</div>
                  <i class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>
                  <div class="activity-content">
                    Est sit eum reiciendis exercitationem
                  </div>
                </div>End activity item

                <div class="activity-item d-flex">
                  <div class="activite-label">4 weeks</div>
                  <i class='bi bi-circle-fill activity-badge text-muted align-self-start'></i>
                  <div class="activity-content">
                    Dicta dolorem harum nulla eius. Ut quidem quidem sit quas
                  </div>
                </div>End activity item

              </div>

            </div>
          </div>End Recent Activity

          Budget Report
          <div class="card">
            <div class="filter">
              <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                <li class="dropdown-header text-start">
                  <h6>Filter</h6>
                </li>

                <li><a class="dropdown-item" href="#">Today</a></li>
                <li><a class="dropdown-item" href="#">This Month</a></li>
                <li><a class="dropdown-item" href="#">This Year</a></li>
              </ul>
            </div>

            <div class="card-body pb-0">
              <h5 class="card-title">Budget Report <span>| This Month</span></h5>

              <div id="budgetChart" style="min-height: 400px;" class="echart"></div>

              <script>
                document.addEventListener("DOMContentLoaded", () => {
                  var budgetChart = echarts.init(document.querySelector("#budgetChart")).setOption({
                    legend: {
                      data: ['Allocated Budget', 'Actual Spending']
                    },
                    radar: {
                      // shape: 'circle',
                      indicator: [{
                          name: 'Sales',
                          max: 6500
                        },
                        {
                          name: 'Administration',
                          max: 16000
                        },
                        {
                          name: 'Information Technology',
                          max: 30000
                        },
                        {
                          name: 'Customer Support',
                          max: 38000
                        },
                        {
                          name: 'Development',
                          max: 52000
                        },
                        {
                          name: 'Marketing',
                          max: 25000
                        }
                      ]
                    },
                    series: [{
                      name: 'Budget vs spending',
                      type: 'radar',
                      data: [{
                          value: [4200, 3000, 20000, 35000, 50000, 18000],
                          name: 'Allocated Budget'
                        },
                        {
                          value: [5000, 14000, 28000, 26000, 42000, 21000],
                          name: 'Actual Spending'
                        }
                      ]
                    }]
                  });
                });
              </script>

            </div>
          </div>End Budget Report

          Website Traffic
          <div class="card">
            <div class="filter">
              <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                <li class="dropdown-header text-start">
                  <h6>Filter</h6>
                </li>

                <li><a class="dropdown-item" href="#">Today</a></li>
                <li><a class="dropdown-item" href="#">This Month</a></li>
                <li><a class="dropdown-item" href="#">This Year</a></li>
              </ul>
            </div>

            <div class="card-body pb-0">
              <h5 class="card-title">Website Traffic <span>| Today</span></h5>

              <div id="trafficChart" style="min-height: 400px;" class="echart"></div>

              <script>
                document.addEventListener("DOMContentLoaded", () => {
                  echarts.init(document.querySelector("#trafficChart")).setOption({
                    tooltip: {
                      trigger: 'item'
                    },
                    legend: {
                      top: '5%',
                      left: 'center'
                    },
                    series: [{
                      name: 'Access From',
                      type: 'pie',
                      radius: ['40%', '70%'],
                      avoidLabelOverlap: false,
                      label: {
                        show: false,
                        position: 'center'
                      },
                      emphasis: {
                        label: {
                          show: true,
                          fontSize: '18',
                          fontWeight: 'bold'
                        }
                      },
                      labelLine: {
                        show: false
                      },
                      data: [{
                          value: 1048,
                          name: 'Search Engine'
                        },
                        {
                          value: 735,
                          name: 'Direct'
                        },
                        {
                          value: 580,
                          name: 'Email'
                        },
                        {
                          value: 484,
                          name: 'Union Ads'
                        },
                        {
                          value: 300,
                          name: 'Video Ads'
                        }
                      ]
                    }]
                  });
                });
              </script>

            </div>
          </div>End Website Traffic

          

        </div> -->   <!-- End Right side columns -->

      </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
<!--   <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span>trihau02</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      Designed by <a href="https://bootstrapmade.com/">trihau02</a>
    </div>
  </footer>End Footer -->
 
  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>


