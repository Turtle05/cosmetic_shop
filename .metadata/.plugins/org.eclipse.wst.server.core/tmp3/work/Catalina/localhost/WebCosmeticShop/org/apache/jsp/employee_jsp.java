/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2024-06-26 20:03:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.bean.User;
import java.util.ArrayList;
import java.awt.Image;

public final class employee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/sidebar.jsp", Long.valueOf(1718760777936L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1719328545819L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.bean.User");
    _jspx_imports_classes.add("java.awt.Image");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write(" <head>\r\n");
      out.write("<title>Nhân viên</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <!DOCTYPE html>\r\n");
      out.write(" \r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    <head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logof.jpg\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor CSS Files -->\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/quill/quill.snow.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/quill/quill.bubble.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/simple-datatables/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main CSS File -->\r\n");
      out.write("  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("    \r\n");
      out.write("<body> \r\n");
      out.write("\r\n");

    HttpSession session = request.getSession();
    String fullname = "Guest"; // Giá trị mặc định
    String image = "default.png"; // Giá trị mặc định

    if (session != null) {
        if (session.getAttribute("fullname") != null) {
            fullname = (String) session.getAttribute("fullname");
        }
        if (session.getAttribute("image") != null) {
            image = (String) session.getAttribute("image");
        }
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ======= Header ======= -->\r\n");
      out.write("  <header id=\"header\" class=\"header fixed-top d-flex align-items-center\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"d-flex align-items-center justify-content-between\">\r\n");
      out.write("      <a href=\"ShowDashBoardServlet\" class=\"logo d-flex align-items-center\">\r\n");
      out.write("         <img src=\"https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/logo.jpg\" alt=\"\"> \r\n");
      out.write("        \r\n");
      out.write("      </a>\r\n");
      out.write("      <!-- <i class=\"bi bi-list toggle-sidebar-btn\"></i> -->\r\n");
      out.write("    </div><!-- End Logo -->\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <!-- <div class=\"search-bar\">\r\n");
      out.write("      <form class=\"search-form d-flex align-items-center\" method=\"POST\" action=\"#\">\r\n");
      out.write("        <input type=\"text\" name=\"query\" placeholder=\"Search\" title=\"Enter search keyword\">\r\n");
      out.write("        <button type=\"submit\" title=\"Search\"><i class=\"bi bi-search\"></i></button>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div> --><!-- End Search Bar -->\r\n");
      out.write("\r\n");
      out.write("    <nav class=\"header-nav ms-auto\">\r\n");
      out.write("      <ul class=\"d-flex align-items-center\">\r\n");
      out.write("\r\n");
      out.write("        <!-- <li class=\"nav-item d-block d-lg-none\">\r\n");
      out.write("          <a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">\r\n");
      out.write("            <i class=\"bi bi-search\"></i>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li> --><!-- End Search Icon-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <li class=\"nav-item dropdown pe-3\">\r\n");
      out.write("\r\n");
      out.write("          <a class=\"nav-link nav-profile d-flex align-items-center pe-0\" href=\"#\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("              <img src='");
      out.print(image);
      out.write("' alt=\"Profile\" class=\"rounded-circle\">\r\n");
      out.write("            <span class=\"d-none d-md-block dropdown-toggle ps-2\">");
      out.print(fullname);
      out.write("</span>\r\n");
      out.write("          </a><!-- End Profile Iamge Icon -->\r\n");
      out.write("\r\n");
      out.write("         ");
      out.write("\r\n");
      out.write("        </li><!-- End Profile Nav -->\r\n");
      out.write("\r\n");
      out.write("      </ul>\r\n");
      out.write("    </nav><!-- End Icons Navigation -->\r\n");
      out.write("\r\n");
      out.write("  </header><!-- End Header -->\r\n");
      out.write("  \r\n");
      out.write("<!--   <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a> -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor JS Files -->\r\n");
      out.write(" <script src=\"assets/vendor/apexcharts/apexcharts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/chart.js/chart.umd.js\"></script> \r\n");
      out.write("  <script src=\"assets/vendor/echarts/echarts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/quill/quill.js\"></script> \r\n");
      out.write("  <script src=\"assets/vendor/simple-datatables/simple-datatables.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/tinymce/tinymce.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/php-email-form/validate.js\"></script>\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("  <!-- Bootstrap JS and dependencies -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main JS File -->\r\n");
      out.write("  <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  </body>\r\n");
      out.write("  </html> ");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <!-- Vendor JS Files -->\r\n");
      out.write("\r\n");
      out.write("  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ======= Sidebar ======= -->\r\n");
      out.write("  <aside id=\"sidebar\" class=\"sidebar\">\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"sidebar-nav\" id=\"sidebar-nav\">\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" <li class=\"nav-heading\">Cửa hàng</li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed' href=\"ShowDashBoardServlet\">\r\n");
      out.write("          <i class=\"bi bi-grid\"></i>\r\n");
      out.write("          <span>Thống kê</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- End Dashboard Nav -->\r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("         <!-- <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"ShowCategoryListServlet\">\r\n");
      out.write("          <i class=\"bi bi-journal-text\"></i><span>Danh mục</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("        <ul id=\"forms-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("          <li>\r\n");
      out.write("            <a   href=\"ShowCategoryListServlet\" >\r\n");
      out.write("              <i  class=\"bi bi-circle\"></i><span>Quản lý danh mục</span>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li>\r\n");
      out.write("            <a href=\"ShowCategoryGroupServlet\">\r\n");
      out.write("              <i class=\"bi bi-circle\"></i><span>Quản lý nhóm danh mục</span>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("        \r\n");
      out.write("         \r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>     -->  <!-- End Danh mục Nav -->\r\n");
      out.write("       <!-- <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed' href=\"ShowCategoryGroupServlet\">\r\n");
      out.write("          <i class=\"bi bi-menu-button-wide\"></i>\r\n");
      out.write("          <span>Nhóm danh mục</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li> --><!-- Sản phẩm Nav -->\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("       <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed' href=\"ShowCategoryListServlet\">\r\n");
      out.write("          <i class=\"bi bi-menu-button-wide\"></i>\r\n");
      out.write("          <span>Danh mục</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- Sản phẩm Nav -->\r\n");
      out.write("      \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("         <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed' href=\"ShowProductListServlet\">\r\n");
      out.write("          <i class=\"bi bi-menu-button-wide\"></i>\r\n");
      out.write("          <span>Sản phẩm</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- Sản phẩm Nav -->\r\n");
      out.write("      \r\n");
      out.write("     \r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed'  href=\"ShowCustomerListServlet\">\r\n");
      out.write("          <i class=\"bi bi-person\"></i>\r\n");
      out.write("          <span>Khách hàng</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- Khách hàng Nav -->\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed'  href=\"ShowOrderListServlet\">\r\n");
      out.write("          <i class=\"bi bi-layout-text-window-reverse\"></i>\r\n");
      out.write("          <span>Đơn hàng</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- Đơn hàng Nav -->\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed'  href=\"ShowEmployeeListServlet\">\r\n");
      out.write("          <i class=\"bi bi-person\"></i>\r\n");
      out.write("          <span>Nhân viên</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- Nhân viên Nav -->\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("       <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed'  href=\"ShowBrandListServlet\">\r\n");
      out.write("          <i class=\"bi bi-gem\"></i>\r\n");
      out.write("          <span>Thương hiệu</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      <li class=\"nav-heading\">Cá nhân</li>\r\n");
      out.write("\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class='nav-link collapsed' href=\"ShowProfileServlet\">\r\n");
      out.write("          <i class=\"bi bi-person\"></i>\r\n");
      out.write("          <span>Thông tin cá nhân</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- End Profile Page Nav -->\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!--    <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"addEmployee.jsp\">\r\n");
      out.write("          <i class=\"bi bi-card-list\"></i>\r\n");
      out.write("          <span>Đăng ký tài khoản</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li>End Register Page Nav -->\r\n");
      out.write("\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"LogoutServlet\">\r\n");
      out.write("          <i class=\"bi bi-box-arrow-in-right\"></i>\r\n");
      out.write("          <span>Đăng xuất</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li><!-- End Login Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("  </aside><!-- End Sidebar-->\r\n");
      out.write("  \r\n");
      out.write("     <!-- Vendor JS Files -->\r\n");
      out.write("  <!-- <script src=\"assets/vendor/apexcharts/apexcharts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/chart.js/chart.umd.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/echarts/echarts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/quill/quill.js\"></script> \r\n");
      out.write(" <script src=\"assets/vendor/simple-datatables/simple-datatables.js\"></script>\r\n");
      out.write(" <script src=\"assets/vendor/tinymce/tinymce.min.js\"></script> \r\n");
      out.write("   -->\r\n");
      out.write("  <!-- Bootstrap JS and dependencies -->\r\n");
      out.write("<!-- <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>  -->\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main JS File -->\r\n");
      out.write(" <script src=\"assets/js/main.js\"></script>  ");
      out.write('\r');
      out.write('\n');
ArrayList<User> employeeList = (ArrayList<User>)request.getAttribute("employeeList"); 
      out.write('\r');
      out.write('\n');
int a = 1; 
      out.write("\r\n");
      out.write("  <main id=\"main\" class=\"main\">\r\n");
      out.write("					");
 String error1 = request.getParameter("message1"); 
      out.write("\r\n");
      out.write("					");
      out.print(("5".equals(error1)) ? "Thêm mới nhân viên thành công!" : "" );
      out.write("\r\n");
      out.write("					");
      out.print(("10".equals(error1)) ? "Xóa nhân viên thành công!" : "" );
      out.write("\r\n");
      out.write("					");
      out.print(("11".equals(error1)) ? "Thay đổi trạng thái tài khoản nhân viên thành công!" : "" );
      out.write("\r\n");
      out.write("					");
 String error = request.getParameter("message"); 
      out.write("\r\n");
      out.write("                    ");
      out.print(("5".equals(error)) ? "Sửa thông tin nhân viên thành công!" : "" );
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("  				");
 if ("10".equals(error1)) { 
      out.write("<div id=\"thongbao\" class=\"custom-alert hidden\"></div>");
 } 
      out.write(" \r\n");
      out.write("          	    ");
 if ("11".equals(error1)) { 
      out.write("<div id=\"thongbao\" class=\"custom-alert hidden\"></div>");
 } 
      out.write(" \r\n");
      out.write("          	    ");
 if ("5".equals(error1)) { 
      out.write("<div id=\"thongbao\" class=\"custom-alert hidden\"></div>");
 } 
      out.write(" \r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"pagetitle\">\r\n");
      out.write("      <h1>Quản lý nhân viên</h1>\r\n");
      out.write("      <nav>\r\n");
      out.write("        <ol class=\"breadcrumb\">\r\n");
      out.write("          <li class=\"breadcrumb-item\"><a href=\"ShowDashBoardServlet\">Trang chủ</a></li>\r\n");
      out.write("          <li class=\"breadcrumb-item active\">Nhân viên</li>\r\n");
      out.write("        </ol>\r\n");
      out.write("      </nav>\r\n");
      out.write("    </div><!-- End Page Title -->\r\n");
      out.write("\r\n");
      out.write("		<section class=\"section\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-lg-12\">\r\n");
      out.write("\r\n");
      out.write("					<div class=\"card\">\r\n");
      out.write("						<div class=\"card-body\"><br>\r\n");
      out.write("						\r\n");
      out.write("						");
if("admin".equals((session.getAttribute("role")))) {
      out.write("\r\n");
      out.write("								<div class=\"row d-flex align-items-center\">\r\n");
      out.write("							<div class=\"col\">\r\n");
      out.write("								<form action=\"addEmployee.jsp\">\r\n");
      out.write("									<button type=\"submit\" class=\"btn btn-primary\">Tạo mới</button>\r\n");
      out.write("								</form>\r\n");
      out.write("							</div>\r\n");
      out.write("							");
 } 
      out.write("\r\n");
      out.write("						\r\n");
      out.write("						<!-- 	<div class=\"col d-flex justify-content-end\">\r\n");
      out.write("								<form method=\"POST\" action=\"#\">\r\n");
      out.write("									<div class=\"input-group\" style=\"padding-right: 120px;\">\r\n");
      out.write("										<input type=\"text\" name=\"query\" class=\"form-control\"\r\n");
      out.write("											placeholder=\"Tìm kiếm\" title=\"Nhập từ khóa tìm kiếm\">\r\n");
      out.write("										<button type=\"submit\" class=\"btn btn-primary\" title=\"Tìm kiếm\">\r\n");
      out.write("											<i class=\"bi bi-search\"></i>\r\n");
      out.write("										</button>\r\n");
      out.write("									</div>\r\n");
      out.write("								</form>\r\n");
      out.write("							</div> -->\r\n");
      out.write("						</div><br>\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("							<!-- Table with stripped rows -->\r\n");
      out.write("							<table class=\"table datatable\">\r\n");
      out.write("								<thead>\r\n");
      out.write("									<tr>\r\n");
      out.write("										<th>STT</th>\r\n");
      out.write("										\r\n");
      out.write("										<!-- <th>Ảnh</th> -->	\r\n");
      out.write("										<th>Mã nhân viên</th>	\r\n");
      out.write("										<th>Tên nhân viên</th>\r\n");
      out.write("										<th>Giới tính</th>\r\n");
      out.write("										<th>Địa chỉ</th>\r\n");
      out.write("										");
if("admin".equals((session.getAttribute("role")))) {
      out.write("\r\n");
      out.write("										<th>Tài khoản</th>\r\n");
      out.write("										");
 } 
      out.write("\r\n");
      out.write("										\r\n");
      out.write("										<th></th>\r\n");
      out.write("									</tr>\r\n");
      out.write("								</thead>\r\n");
      out.write("								<tbody>\r\n");
      out.write("								");
int i = 1; 
      out.write("\r\n");
      out.write("									");
for(User e : employeeList){ 
      out.write("\r\n");
      out.write("									<tr>\r\n");
      out.write("										<td>");
      out.print(i++ );
      out.write("</td>\r\n");
      out.write("						");
      out.write("\r\n");
      out.write("										<td>");
      out.print(e.getUserID());
      out.write("</td>\r\n");
      out.write("										<td>");
      out.print(e.getFullName());
      out.write("</td>\r\n");
      out.write("										<td>");
      out.print(e.getPhone());
      out.write("</td>\r\n");
      out.write("										<td>");
      out.print(e.getAddress());
      out.write("</td>\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("										");
if("admin".equals((session.getAttribute("role")))) {
      out.write("\r\n");
      out.write("													<td>\r\n");
      out.write("													");
if("true".equals(e.getEnable())) { 
      out.write("\r\n");
      out.write("													<button  onclick=\"location.href='EnableServlet?userID=");
      out.print(e.getUserID());
      out.write("&e=false';\" class=\"btn btn-primary btn-sm\"><i class=\"fa-solid fa-lock-open\"></i></button>\r\n");
      out.write("													");
} else {
      out.write("\r\n");
      out.write("														<button  onclick=\"location.href='EnableServlet?userID=");
      out.print(e.getUserID());
      out.write("&e=true';\" class=\" btn btn-outline-danger btn-sm\"><i class=\"fa-solid fa-lock\"></i></button>");
}
      out.write("\r\n");
      out.write("														</td>\r\n");
      out.write("												");
 } 
      out.write("\r\n");
      out.write("										\r\n");
      out.write("										<td>	\r\n");
      out.write("													\r\n");
      out.write("													<input class=\"btn btn-primary btn-sm\"\r\n");
      out.write("													type=\"button\"\r\n");
      out.write("													onclick=\"location.href='ShowEditEmployeeServlet?userID=");
      out.print(e.getUserID());
      out.write("';\"\r\n");
      out.write("													value=\"Xem\" />\r\n");
      out.write("											");
if("admin".equals((session.getAttribute("role")))) {
      out.write("\r\n");
      out.write("												<button  onclick=\"location.href='DeleteEmployeeServlet?userID=");
      out.print(e.getUserID());
      out.write("';\" class=\"btn btn-outline-danger btn-sm\">Xóa</button>\r\n");
      out.write("											");
 } 
      out.write("\r\n");
      out.write("											<!-- </form> -->\r\n");
      out.write("										</td>\r\n");
      out.write("									</tr>\r\n");
      out.write("								");
} 
      out.write("\r\n");
      out.write("								</tbody>\r\n");
      out.write("							</table>\r\n");
      out.write("							<!-- End Table with stripped rows -->\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</section>\r\n");
      out.write("\r\n");
      out.write("	</main><!-- End #main -->\r\n");
      out.write("	  \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("document.addEventListener('DOMContentLoaded', function() {\r\n");
      out.write("    const showAlertMessage = (message) => {\r\n");
      out.write("        const alertElement = document.getElementById('thongbao');\r\n");
      out.write("        alertElement.textContent = message;\r\n");
      out.write("        alertElement.classList.remove('hidden');\r\n");
      out.write("        alertElement.classList.add('show');\r\n");
      out.write("\r\n");
      out.write("        setTimeout(() => {\r\n");
      out.write("            alertElement.classList.remove('show');\r\n");
      out.write("            setTimeout(() => {\r\n");
      out.write("                alertElement.classList.add('hidden');\r\n");
      out.write("            }, 500); // Thời gian khớp với thời gian của transition\r\n");
      out.write("        }, 1500); // Hiển thị thông báo trong 1,5 giây\r\n");
      out.write("    };\r\n");
      out.write("    ");
 if ("10".equals(error1)) { 
      out.write("showAlertMessage('Xóa nhân viên thành công!');");
 } 
      out.write("\r\n");
      out.write("    ");
 if ("11".equals(error1)) { 
      out.write("showAlertMessage('Thay đổi trạng trái tài khoản thành công');");
 } 
      out.write("\r\n");
      out.write("    ");
 if ("5".equals(error1)) { 
      out.write("showAlertMessage('Thêm mới nhân viên thành công!');");
 } 
      out.write("\r\n");
      out.write("    ");
 if ("5".equals(error)) { 
      out.write("showAlertMessage('Sửa thông tin nhân viên thành công!');");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
