<%@page import="model.bean.CategoryGroup"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<title>Nhóm danh mục</title>
</head>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%ArrayList<CategoryGroup> catGroupList = (ArrayList<CategoryGroup>)request.getAttribute("catGroupList"); %>
  <main id="main" class="main">
					<% String error = request.getParameter("message"); %>
                    <%=("3".equals(error)) ? "Sửa nhóm danh mục thành công!" : "" %>
            	    <%=("2".equals(error)) ? "Lỗi chưa nhập đầy đủ tên nhóm danh mục!" : "" %>
            	    <%=("1".equals(error))?"Lỗi không xác định":"" %>
    <div class="pagetitle">
      <h1>Quản lý nhóm danh mục</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="ShowDashBoardServlet"> Danh mục</a></li>
          <li class="breadcrumb-item active"><a href="ShowDashBoardServlet"> Nhóm danh mục</a></li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body"><br>
							<!-- <form action = "createCategoryGroup.jsp">
							  <button type="submit" class="btn btn-primary">Tạo mới</button>
							</form> -->
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#ModalCreate">Thêm</button>
						
						
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th>STT</th>
										<th>Mã nhóm </th>
										<th>Tên nhóm danh mục</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								<%int i = 1; %>
									<%for(CategoryGroup c : catGroupList){ %>
									<tr>
										<td><%=i++ %></td>
										<td><%=c.getCategoryGroupID()%></td>
										<td><%=c.getCategoryGroupName() %></td>
										<td>
											<button type="button" class="btn btn-primary btn-sm btn-edit" 
                        data-toggle="modal" 
                        data-target="#ModalEdit" 
                        data-id="<%= c.getCategoryGroupID()%>" 
                        data-name="<%= c.getCategoryGroupName()%>" 
                       
                >Sửa</button> 
				<button type="button" class="btn btn-outline-danger btn-sm btn-delete" 
                        data-toggle="modal" 
                        data-target="#ModalDelete" 
                        data-id="<%= c.getCategoryGroupID()%>" 
                        data-name="<%= c.getCategoryGroupName()%>"
                >Xóa</button>
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
	  
	  
	  <!-- Modal  create -->
<div class="modal fade" id="ModalCreate" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="uploadModalLabel">Thêm nhóm danh mục</h3>
                <!--  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button> -->
            </div>
            <form action="CreateCategoryGroupServlet">
                <div class="modal-body">
                    <div class="form-group">
                    
                            <div>
                             	 	<label>Tên nhóm danh mục</label><br> 
                                    <input class="form-control"  type="text" name="catGroupName" /><br>
                             <!--        <label>Mô tả</label><br> 
                                    <input class="form-control"  type="text" name="des" /> -->
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

<!-- End modal create -->
	  
	  
	  
	  
	  
	  <!-- Modal edit -->
	  <div class="modal fade" id="ModalEdit" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="uploadModalLabel">Sửa nhóm danh mục</h4>
            </div>
            <form action="EditCategoryGroupServlet" >
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã</label>
                        <input  type="hidden" id="modalBrandID" name="catGID"/>
                        <input class="form-control"  type="text" id="modalBrandIDDisplay" name="catGID"  disabled/><br>
                         <label>Tên nhóm danh mục</label>
                         <input class="form-control"   type="text" id="modalBrandName" name="catGName"/><br>
                   
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
                <h5 class="modal-title" id="deleteModalLabel">Xác nhận xóa nhóm danh mục</h5>
            </div>
            <form  id="deleteBrandForm" action="DeleteCatGroupServlet" method="post" >
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã</label>
                        <input  type="hidden" id="deleteModalBrandID" name="catGoupID"/>
                        <input class="form-control"  type="text" id="deleteModalBrandIDDisplay" name="catGroupIDDisplay" disabled/><br>
                            <label>Tên nhóm danh mục</label>
                            <input class="form-control"   type="text" id="deleteModalBrandName" name="catGroupNamed"/><br>
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
  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
     $(document).ready(function() {
         $('.btn-edit').click(function() {
            var brandID = $(this).data('id');
            var brandName = $(this).data('name');
            var brandNation = $(this).data('nation');
            var imageUrl = $(this).data('image');
            var link = $(this).data('image');
            

            $('#modalBrandID').val(brandID);
            $('#modalBrandIDDisplay').val(brandID);  // Hiển thị mã thương hiệu trong trường không thể chỉnh sửa
            $('#modalBrandName').val(brandName);
            $('#modalBrandOrigin').val(brandNation);
            $('#modalImage').attr('src', imageUrl);
     
            $('#link').val(link);
            
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
</script>


