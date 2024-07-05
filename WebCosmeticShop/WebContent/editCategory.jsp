<%@page import="model.bean.Category"%>
<%@page import="model.bean.CategoryGroup"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>



            
  <main id="main" class="main">
<%Category cat = (Category)request.getAttribute("cat"); %> 
<%ArrayList<CategoryGroup>  catGroup = (ArrayList<CategoryGroup> )request.getAttribute("catGroup"); %>  
<%String catID = request.getParameter("catID"); %>

<% String error1 = request.getParameter("message1"); %>
                              	    <% if ("3".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %>
                              	    <% if ("2".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("1".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>


    <div class="pagetitle">
      <h1>Sửa danh mục</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowCategoryListServlet">Danh mục</a></li>
          <li class="breadcrumb-item active">Sửa danh mục</li>
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
              <form action="EditCategoryServlet"class="row g-3">
                <div class="col-md-12">
                  <label for="inputName5" class="form-label">Mã danh mục</label>
                  <input type="text" class="form-control" id="" value="<%=cat.getCategoryID()%>"  disabled>
                  <input type="hidden" class="form-control" id="catGroupID" name='categoryID' value="<%=cat.getCategoryID()%>" >
                </div>
           
                <div class="col-12">
                  <label for="inputAddress5" class="form-label">Tên danh mục</label>
                  <input type="text" class="form-control" id="catName" name="catName" value="<%=cat.getCategoryName()%>" >
                </div>

                <div class="col-12">
                  <label for="inputState" class="form-label">Tên nhóm danh mục</label>
                  <select id="inputState" class="form-select" name ="catGroupID"  >
                  <%-- <option value ='<%=cat.getCategoryGroupID()%>' selected><%=cat.getCategoryGroupName()%></option> --%>
                  <option value ='<%=cat.getCategoryGroupID()%>' selected><%=cat.getCategoryGroupName() %></option>
             		 <%for(CategoryGroup cg : catGroup){ %>
                    <option value ='<%=cg.getCategoryGroupID() %>'><%=cg.getCategoryGroupName() %></option>
                    <%} %> 
                  </select>
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
    
    <% if ("3".equals(error1)) { %>showAlertMessage('Sửa danh mục thành công!');<% } %>
    <% if ("2".equals(error1)) { %>showAlertMessage('Lỗi thiếu thông tin!');<% } %>
    <% if ("1".equals(error1)) { %>showAlertMessage('Lỗi không xác định!');<% } %>
    
    
    
 
});
</script>
 

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

  