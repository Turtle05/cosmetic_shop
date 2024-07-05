<%@page import="model.bean.Category"%>
<%@page import="model.bean.CategoryGroup"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>



            
  <main id="main" class="main">
<%CategoryGroup catGroup = (CategoryGroup)request.getAttribute("catGroup"); %> 
<%String catGroupID = request.getParameter("catGroupID"); %>
				
            	   <br>

    <div class="pagetitle">
      <h1>Sửa nhóm danh mục</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowCategoryListServlet">Danh mục</a></li>
          <li class="breadcrumb-item"><a href="ShowCategoryListServlet">Nhóm danh mục</a></li>
         
          <li class="breadcrumb-item active">Sửa nhóm danh mục</li>
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
              <form action="EditCategoryGroupServlet"class="row g-3">
              
                
                 <div class="col-md-12">
                  <label for="" class="form-label">Mã nhóm danh mục</label>
                  <input type="text" class="form-control" id="" name='' value="<%=catGroup.getCategoryGroupID()%>" disabled>
                  <input type="hidden" class="form-control" id="catGroupID" name='catGID' value="<%=catGroup.getCategoryGroupID()%>" >
                </div>
           
             
                
            <div class="col-12">
                  <label for="" class="form-label">Tên nhóm danh mục</label>
                  <input type="text" class="form-control" id="catGroupName" name="catGName" value="<%=catGroup.getCategoryGroupName()%>" >
                </div>  

             
                <div class="text-center">
                  <button type="submit"  class="btn btn-primary">Sửa</button>
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

  