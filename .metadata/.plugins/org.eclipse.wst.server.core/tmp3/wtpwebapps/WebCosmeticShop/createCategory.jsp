<%@page import="model.bean.Category"%>
<%@page import="model.bean.CategoryGroup"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<title>Thêm danh mục</title>
</head>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>



            
  <main id="main" class="main">
<%ArrayList<CategoryGroup> catGroup = (ArrayList<CategoryGroup>)request.getAttribute("catGroup"); %>
				<% String error = request.getParameter("message"); %>
                    <%=("5".equals(error)) ? "Thêm mới danh mục thành công!" : "" %>
            		<%=("1".equals(error)) ? "Lỗi trùng mã danh mục!" : "" %>
            	   <%=("2".equals(error)) ? "Lỗi chưa nhập đầy đủ tên danh mục, tên nhóm danh mục!" : "" %>
            	   <%=("3".equals(error))?"Đơn giá tham khảo phải là số!":"" %>
            	   <%=("4".equals(error))?"Lỗi không xác định":"" %>
            	   <br>
            	   <% String catName = request.getParameter("catName") != null ? request.getParameter("catName") : ""; %>
            	   <% String catGroupName = request.getParameter("catGroupName") != null ? request.getParameter("catGroupName") : ""; %>
    <div class="pagetitle">
      <h1>Tạo danh mục</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowCategoryListServlet">Danh mục</a></li>
          <li class="breadcrumb-item active">Tạo danh mục</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

			

          <div class="card">
            <div class="card-body">
            <br>

              <!-- Multi Columns Form -->
              <form action="CreateCategoryServlet"class="row g-3">
                <div class="col-md-12">
                  <label for="inputName5" class="form-label">Mã danh mục</label>
                  <input type="text" class="form-control" id="inputName5" disabled>
                </div>
           
                <div class="col-12">
                  <label for="inputAddress5" class="form-label">Tên danh mục</label>
                  <input type="text" class="form-control" id="catName" name="catName" value="<%=catName %>" >
                </div>
                
          <%--       <div class="col-12">
                  <label for="inputAddress5" class="form-label">Tên nhóm danh mục</label>
                  <input type="text" class="form-control" id="catGroupName" name="catGroupID" value="<%=catGroupName %>" >
                </div>  --%>
           <!--    <div class="col-12">
                  <label for="inputState" class="form-label">Tên nhóm danh mục</label>
                  <select id="inputState" class="form-select" name ="catGroupID" >
                    <option selected>----Chọn----</option>
                    <option>CaG001</option>
                    <option>CaG002</option>
                    <option>CaG003</option>
                    <option>Chăm sóc răng miệng</option>
                    <option>Chăm sóc tóc và da đầu</option>
                  </select>
                </div>  --> 
                
                <div class="col-12">
                  <label for="inputState" class="form-label">Tên nhóm danh mục</label>
                  <select id="inputState" class="form-select" name ="catGroupID"  >
                    <option value ='' selected>----Chọn----</option>
                    <%for(CategoryGroup cg : catGroup){ %>
                    <option value ='<%=cg.getCategoryGroupID() %>'><%=cg.getCategoryGroupName() %></option>
                    <%} %>
                  </select>
                </div>   
              
             
                <div class="text-center">
                  <button type="submit"  class="btn btn-primary">Tạo</button>
                  <button type="reset" class="btn btn-secondary">Hủy</button>
                </div>
              </form><!-- End Multi Columns Form -->

            </div>
          </div>

        </div>

        
			</div>
		</section>

	</main><!-- End #main -->
	  			<script>
			function validate(){
				
				var errorMessage = "";
                
				if(document.getElementById("catName").value == ""){
					errorMessage =errorMessage + ' Hãy nhập tên danh mục';
				}
				
				/*
				//cach1
				 if (!(/^\d+$/.test(document.getElementById("donGiaTK").value))) {

                     errorMessage = errorMessage + ' Đơn giá tham khảo phải là một số nguyên';

             	} 
				*/
				//cach2
		/* 		 var dgtkTmp = Number(document.getElementById("donGiaTK").value);                          

				if (Number.isNaN(dgtkTmp) || dgtkTmp < 0) {

                           errorMessage = errorMessage + 'Đơn giá tham khảo phải là một số nguyên';

                   }
 */

				  if (errorMessage != "") {

                      alert(errorMessage);

  	            }
					return errorMessage == "";
			}
			</script>
	  
  


 

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

  