<%@page import="model.bean.Brand"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<title>Thương hiệu</title>
</head>

<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>



<%ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brandList"); %>
  <main id="main" class="main">
				
    <div class="pagetitle">
      <h1>Quản lý thương hiệu</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item active">Thương hiệu</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body"><br>
							
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#ModalCreate">Thêm</button>
							 <!--  <button type="submit" class="btn btn-primary btn-sm">Tạo mới</button> -->
<% String error = request.getParameter("message"); %>
<% String error1 = request.getParameter("message1"); %>

          	    <% if ("10".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
          	    <% if ("11".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %> 
          	    <% if ("1".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %> 
          	    <% if ("2".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %> 
          	    <% if ("3".equals(error1)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
          	    <% if ("1".equals(error)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %> 
          	    <% if ("2".equals(error)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %> 
          	    <% if ("3".equals(error)) { %><div id="thongbao" class="custom-alert hidden"></div><% } %> 
          	    
							
<table class="table datatable">
    <thead>
        <tr>
            <th>STT</th>
            <th>Hình ảnh</th>
            <th>Mã thương hiệu</th>
            <th>Tên thương hiệu</th>
            <th>Xuất xứ</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1; %>
        <% for (Brand b : brandList) { %>
        <tr>
            <td><%= i++ %></td>
            <td><img src='<%=b.getImage()%>' width='120' height='60' align="middle" border='1px'></td>
            <td><%=b.getBrandID() %></td>
            <td><%=b.getBrandName() %></td>
            <td><%=b.getNation() %></td>
            <td>
                 <button type="button" class="btn btn-primary btn-sm btn-edit" 
                        data-toggle="modal" 
                        data-target="#ModalEdit" 
                        data-id="<%= b.getBrandID()%>" 
                        data-name="<%= b.getBrandName()%>" 
                        data-nation="<%= b.getNation()%>"
                        data-image="<%=b.getImage()%>"
                >Sửa</button> 
       
                
               <button type="button" class="btn btn-outline-danger btn-sm btn-delete" 
                        data-toggle="modal" 
                        data-target="#ModalDelete" 
                        data-id="<%=b.getBrandID()%>" 
                        data-name="<%=b.getBrandName()%>" 
                        data-nation="<%=b.getNation()%>"
                        data-image="<%=b.getImage()%>"
                >Xóa</button>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>
</div>
</div>
</div>
</div>
</section>
		
		
		
		<!-- Modal  create -->
<div class="modal fade" id="ModalCreate" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="uploadModalLabel">Thêm thương hiệu</h3>
                <!--  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button> -->
            </div>
            <form action="CreateBrandServlet" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                    <label>Ảnh</label>
                            <div class="col-md-8 col-lg-9 profile">
                                <img id="myimage"  src='https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/Cerave.jpg' border='1' class='myImage123'/><br>
                                
                                 <div class="upload-container">
                                    <label for="inputImage" class="upload-label" class="d-flex justify-content-center align-items-center">
                                        <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60" />
                                        <a><i style="color: blue" class="bi bi-upload"></i></a>
                                    </label>
                                    <label class="remove-label"  class="d-flex justify-content-center align-items-center">
                                        <a id="removeImage"><i style="color: red" class="bi bi-trash"></i></a>
                                    </label>
                                </div> 
                            </div>
                            <div>
                            		<br>
                             	 	<label>Tên thương hiệu</label><br> 
                                    <input class="form-control"  type="text" name="brandName" /><br>
                                    <label>Xuất xứ</label><br> 
                                    <input class="form-control"  type="text" name="brandOrigin" />
                             </div>
                    </div>
                </div>
                <div class="modal-footer">
                <br>
                    <button type="submit" class="btn btn-primary btn-sm">Lưu</button>
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Hủy</button>
                </div>
            </form>
        </div>
    </div>
</div>
		
		

		<!-- Modal edit-->
 <div class="modal fade" id="ModalEdit" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="uploadModalLabel">Sửa thông tin thương hiệu</h4>
            </div>
            <form action="EditBrandServlet" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã</label>
                        <input  type="hidden" id="modalBrandID" name="brandID"/>
                        <input class="form-control"  type="text" id="modalBrandIDDisplay" name="brandIDDisplay" disabled/><br>
                        <label>Ảnh</label>
                        <div class="col-md-8 col-lg-9 profile">
                            <img id="modalImage" src='' border='1' class='myImage123'/>
                            <div class="upload-container">
                                <label for="inputImage" class="upload-label" class="d-flex justify-content-center align-items-center">
                                    <input type="file" id="inputImageEdit" accept="image/jpeg, image/png" name="file"  size="60"/>
                                    <input name ="imgOrigin" id="modalLink" type ="hidden"/>
                                    <a><i style="color: blue" class="bi bi-upload"></i></a>
                                </label>
                                <label class="remove-label" class="d-flex justify-content-center align-items-center">
                                    <a style="color: red" id="removeImageEdit" href="#" ><i class="bi bi-trash"></i></a>
                                </label>
                            </div>
                        </div>
                        <div>
                            <br>
                            <label>Tên thương hiệu</label>
                            <input class="form-control"   type="text" id="modalBrandName" name="brandName"/><br>
                            <label>Xuất xứ</label>
                            <input class="form-control"  type="text" id="modalBrandOrigin" name="brandOrigin"/>
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <br>
                    <button type="submit" class="btn btn-primary btn-sm">Lưu</button>
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Hủy</button>
                </div>
            </form>
        </div>
    </div>
</div> 
<!-- End modal edit-->









<!-- Modal delete-->
<div class="modal fade" id="ModalDelete" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="deleteModalLabel">Xác nhận xóa thương hiệu</h4>
            </div>
            <form  id="deleteBrandForm" action="DeleteBrandServlet" method="post" >
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã</label>
                        <input  type="hidden" id="deleteModalBrandID" name="brandID"/>
                        <input class="form-control"  type="text" id="deleteModalBrandIDDisplay" name="brandIDDisplay" disabled/><br>
                        <label>Ảnh</label>
                        <div class="col-md-8 col-lg-9 profile">
                            <img id="deleteModalImage"  border='1' class='myImage123'/>
                        </div>
                        <div>
                            <br>
                            <label>Tên thương hiệu</label>
                            <input class="form-control"   type="text" id="deleteModalBrandName" name="brandNamed"/><br>
                            <label>Xuất xứ</label>
                            <input class="form-control"  type="text" id="deleteModalBrandOrigin" name="brandOrigin"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <br>
                    <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Hủy</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- End modal delete-->

				

	</main><!-- End #main -->
	  

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
 
  
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
    <% if ("10".equals(error1)) { %>showAlertMessage('Xóa thương hiệu thành công!');<% } %>
    <% if ("11".equals(error1)) { %>showAlertMessage('Không thể xóa thương hiệu');<% } %>
    <% if ("1".equals(error1)) { %>showAlertMessage('Lỗi không xác định');<% } %>
    <% if ("2".equals(error1)) { %>showAlertMessage('Lỗi chưa nhập đầy đủ');<% } %>
    <% if ("3".equals(error1)) { %>showAlertMessage('Sửa thương hiệu thành công');<% } %>
    <% if ("1".equals(error)) { %>showAlertMessage('Lỗi không xác định');<% } %>
    <% if ("2".equals(error)) { %>showAlertMessage('Lỗi chưa nhập đầy đủ');<% } %>
    <% if ("3".equals(error)) { %>showAlertMessage('Thêm thương hiệu thành công');<% } %>
    
 
});
</script>
  
  
 <script>
    
    $(document).ready(function() {
        $("#inputImage").change(function() {
            showImage(this, "#myimage");
        });
        
        $("#removeImage").click(function() {
            resetImage("#myimage", "#inputImage");
        });
        
        $("#removeImageEdit").click(function() {
            resetImage("#modalImage", "#inputImageEdit");
        });
        
        $('.btn-edit').click(function() {
            var brandID = $(this).data('id');
            var brandName = $(this).data('name');
            var brandNation = $(this).data('nation');
            var imageUrl = $(this).data('image');
            var link = $(this).data('image');
            
            console.log(imageUrl);
            console.log(link);
            

            $('#modalBrandID').val(brandID);
            $('#modalBrandIDDisplay').val(brandID);  // Hiển thị mã thương hiệu trong trường không thể chỉnh sửa
            $('#modalBrandName').val(brandName);
            $('#modalBrandOrigin').val(brandNation);
            $('#modalLink').val(link);
            $('#modalImage').attr('src', imageUrl);
     
            $('#link').val(link);
            
            $("#inputImageEdit").change(function() {
                showImage(this, "#modalImage");
            });
            
            
        });

        $('.btn-delete').click(function() {
            var brandID = $(this).data('id');
            var brandName = $(this).data('name');
            var brandNation = $(this).data('nation');
            var imageUrl = $(this).data('image');

            $('#deleteModalBrandID').val(brandID);
            $('#deleteModalBrandIDDisplay').val(brandID);  // Hiển thị mã thương hiệu trong trường không thể chỉnh sửa
            $('#deleteModalBrandName').val(brandName);
            $('#deleteModalBrandOrigin').val(brandNation);
            $('#deleteModalImage').attr('src', imageUrl);
        });
    });

    function showImage(fileInput, idImg) {
        const file = fileInput.files[0];
        const reader = new FileReader();
        reader.onload = function(e) {
            $(idImg).attr("src", e.target.result);
        };
        reader.readAsDataURL(file);
    }

    function resetImage(idImage, idInputImage) {
        // Sử dụng đường dẫn mặc định hoặc thực hiện các hành động cần thiết để reset ảnh
        $(idImage).attr("src", "https://s3.ap-southeast-1.amazonaws.com/trihau.profile.image/Cerave.jpg");
        // Xóa giá trị của input file
        $(idInputImage).val('');
    }

    
	</script>  


<script>
   
</script>



