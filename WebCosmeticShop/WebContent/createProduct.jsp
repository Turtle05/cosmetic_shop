<%@page import="model.bean.Category"%>
<%@page import="model.bean.CategoryGroup"%>
<%@page import="model.bean.Brand"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.awt.Image"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ include file="header.jsp" %>



<%ArrayList<CategoryGroup> catGroup = (ArrayList<CategoryGroup>)request.getAttribute("catGroup"); %>
<%-- <%ArrayList<Category> cat = (ArrayList<Category>)request.getAttribute("cat"); %> --%>
<%ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brandList"); %>
<% String error1 = request.getParameter("message"); %>
                              	    <% if ("1".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("2".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("3".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("4".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("0".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    <% if ("6".equals(error1)) { %><div id="thongbao" class="custom-alert-red hidden"></div><% } %>
                              	    

  <main id="main" class="main">

<section class="section">
      <div class="row">
        <div class="col-lg-10">



          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Thêm sản phẩm</h5>

              <!-- Multi Columns Form -->
              <form class="row g-3" action="CreateProductServlet" method="post" enctype="multipart/form-data">
                <div class="col-md-9">
                  <label for="inputName5" class="form-label">Tên sản phẩm</label>
                  <input type="text" class="form-control" id="inputName5" name="nameProduct">
                </div>
                
                  <div class="col-md-3">
                  <label for="inputBrand" class="form-label">Thương hiệu</label>
                  <select id="inputBrand" class="form-select" name="brand">
                    <option value ='' selected>---Chọn---</option>
                    <%for(Brand b : brandList){ %>
                    <option value ='<%=b.getBrandID()%>'><%=b.getBrandName()%></option>
                    <%} %>
                  </select>
                </div>
                
                
				<div class="col-md-6">
					<label for="categoryGroupSelect" class="form-label">Nhóm danh mục</label>
					<select id="categoryGroupSelect" class="form-select" name="catGroup">
				    <option selected>---Chọn---</option>
				    <%for(CategoryGroup cg : catGroup){ %>
				<option value='<%=cg.getCategoryGroupID() %>'><%=cg.getCategoryGroupName() %></option>
				<%} %>
				    </select><br>
				</div>
				
				<div class="col-md-6">
				    <label for="categorySelect" class="form-label">Danh mục</label>
				    <select id="categorySelect" class="form-select" name="cat">
				        <option selected>---Chọn---</option>
				        <!-- Options sẽ được cập nhật bởi AJAX -->
				    </select>
				</div>
			
              
                
                <div id="divAttribute" class="row" >
	                <div id="productAttribute0"  class="row">
		                 <div class="col-md-3">
		                  <label for="inputDungtich" class="form-label">Dung tích</label>
		                  <input type="text" class="form-control" name="size">
		                </div>
		                
		                 <div class="col-md-3">
		                  <label for="inputPrice" class="form-label">Giá</label>
		                  <input type="text" class="form-control" name='price'>
		                </div>
						<div class="col-md-3">
						  <label for="inputQuantity" class="form-label">Số lượng</label>
						  <input type="text" class="form-control" name="quantity">
						</div>
							<div class="col-md-2">
							        <label for="inputImage" class="form-label">Ảnh</label><br>
							        <img id="myimage" src="" alt="Image" width='100' height='100' align="middle" border='1px' /><br>
							        <label class="upload-label" class="d-flex justify-content-center align-items-center">
							          <input type="file" class="inputImage" id="inputImage" accept="image/jpeg, image/png" name="file" size="60"/>
							          <a><i style="color: blue" class="bi bi-upload"></i></a>
							</label>
							
							<label class="remove-label" class="d-flex justify-content-center align-items-center">
							  <a style="color: red" class="removeImage" href="#"><i class="bi bi-trash"></i></a>
							  </label>
							</div>	                 	               
                	</div>
                </div>
              <div >
                	<div class="col-md-2" >
	 						 <button  class="btn btn-primary" type="button" onclick="addAttribute()">Thêm</button>  
	 				  	</div>
                </div>
                
                
                  <div class="col-12">
                  	<label for="inputAddress5" class="form-label">Mô tả</label>
                    <textarea class="form-control" style="height: 100px" name='des'></textarea>
			    </div>
               
              
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Lưu</button>
                  <button type="reset" class="btn btn-secondary">Hủy</button>
                </div>
              </form><!-- End Multi Columns Form -->

            </div>
          </div>

        </div>

      

          

        </div>
      </div>
    </section>

  </main><!-- End #main -->



 

</body>
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
    <% if ("0".equals(error1)) { %>showAlertMessage('Lỗi ko xác định!');<% } %>
    <% if ("1".equals(error1)) { %>showAlertMessage('Lỗi trùng khóa');<% } %>
    <% if ("2".equals(error1)) { %>showAlertMessage('Thiếu thông tin!');<% } %>
    <% if ("3".equals(error1)) { %>showAlertMessage('Thiếu thông tin sản phẩm');<% } %>
    <% if ("4".equals(error1)) { %>showAlertMessage('Giá sản phẩm không hợp lệ');<% } %>
    <% if ("6".equals(error1)) { %>showAlertMessage('Số lượng sản phẩm không hợp lệ');<% } %>
    
    
 
});
</script>
  <script>
  	

  /* 	function addAttribute(){
  	    allDivDetails = $("[id^='productAttribute']");
  	    divDetailsCount = allDivDetails.length;
  	    console.log("divDetailsCount: " + divDetailsCount);

  	    htmlDetailSection = `
  	        <div id="productAttribute${divDetailsCount}" class="row">
  	            <div class="col-md-4">
  	                <label for="inputDungtich" class="form-label">Dung tích</label>
  	                <input type="text" class="form-control" name="dungtich">
  	            </div>
  	            <div class="col-md-4">
  	                <label for="inputPrice" class="form-label">Giá</label>
  	                <input type="text" class="form-control" name="price">
  	            </div>
  	            <div class="col-sm-1">
  	          <br>
  	                <a  class="btn btn-danger" 
  	                   href="javascript:removeDetailSectionById('productAttribute${divDetailsCount}')" 
  	                   title="Xóa thuộc tính này">Xóa</a>
  	            </div>
  	        </div>
  	    `;

  	    $("#divAttribute").append(htmlDetailSection);
  	}

 
  	
  	
  	function removeDetailSectionById(id) {
  		$("#" + id).remove();
  	} */
  </script>
  
  
  
  <!-- <script >
  function addAttribute(){
	    allDivDetails = $("[id^='productAttribute']");
	    divDetailsCount = allDivDetails.length;
	    console.log("divDetailsCount: " + divDetailsCount);

	    htmlDetailSection = `
	        <div id="productAttribute${divDetailsCount}" class="row">
	            <div class="col-md-4">
	                <label for="inputDungtich" class="form-label">Dung tích</label>
	                <input type="text" class="form-control" name="dungtich">
	            </div>
	            <div class="col-md-4">
	                <label for="inputPrice" class="form-label">Giá</label>
	                <input type="text" class="form-control" name="price">
	            </div>
	            
	            
	            
	            <div class="col-md-3">  
            	<label for="inputPrice" class="form-label">Ảnh</label><br>
			
				<img id="myimage" src="" alt="Image" width='100' height='100' align="middle" border='1px' /><br>
				<label for="inputImage" class="upload-label" class="d-flex justify-content-center align-items-center">
                        <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file"  size="60"/>
                        <input name ="imgOrigin" id="modalLink" type ="hidden"/>
                        <a><i style="color: blue" class="bi bi-upload"></i></a>
           		 </label>
            	<label class="remove-label" class="d-flex justify-content-center align-items-center">
                        <a style="color: red" id="removeImage" href="#" ><i class="bi bi-trash"></i></a>
            	</label>
            
       		 </div>
	            
	            
	            <div class="col-sm-1">
	          <br>
	                <a  class="btn btn-danger" 
	                   href="javascript:removeDetailSectionById('productAttribute${divDetailsCount}')" 
	                   title="Xóa thuộc tính này">Xóa</a>
	            </div>
	        </div>
	    `;

	    $("#divAttribute").append(htmlDetailSection);
	}


	
	
	function removeDetailSectionById(id) {
		$("#" + id).remove();
	}
  </script>
  
  
  
  <script>
    
    $(document).ready(function() {
        $("#inputImage").change(function() {
            showImage(this);
        });
        
        $("#removeImage").click(function() {
            resetImage();
        });
    });

    function showImage(fileInput) {
        const file = fileInput.files[0];
        const reader = new FileReader();
        reader.onload = function(e) {
            $("#myimage").attr("src", e.target.result);
        };
        reader.readAsDataURL(file);
    }

    function resetImage() {
        // Sử dụng đường dẫn mặc định hoặc thực hiện các hành động cần thiết để reset ảnh
        $("#myimage").attr("src", "");
        // Xóa giá trị của input file
        $("#inputImage").val('');
    }

	</script>   -->
	
	
	
	<script>
  function addAttribute() {
    const allDivDetails = $("[id^='productAttribute']");
    const divDetailsCount = allDivDetails.length;
    console.log("divDetailsCount: " + divDetailsCount);

    const htmlDetailSection = `
      <div id="productAttribute${divDetailsCount}" class="row">
        <div class="col-md-3">
          <label for="inputDungtich" class="form-label">Dung tích</label>
          <input type="text" class="form-control" name="size">
        </div>
        
        <div class="col-md-3">
          <label for="inputPrice" class="form-label">Giá</label>
          <input type="text" class="form-control" name="price">
        </div>
        
        <div class="col-md-3">
          <label for="inputQuantity" class="form-label">Số lượng</label>
          <input type="text" class="form-control" name="quantity">
        </div>
        
        
        <div class="col-md-2">
          <label for="inputImage${divDetailsCount}" class="form-label">Ảnh</label><br>
          <img id="myimage${divDetailsCount}" src="" alt="Image" width='100' height='100' align="middle" border='1px' /><br>
          <label class="upload-label class="d-flex justify-content-center align-items-center">
            <input type="file" class="inputImage" id="inputImage${divDetailsCount}" accept="image/jpeg, image/png" name="file" size="60"/>
            <a><i style="color: blue" class="bi bi-upload"></i></a>
          </label>
          <label class="remove-label" class="d-flex justify-content-center align-items-center">
            <a style="color: red" class="removeImage" href="#"><i class="bi bi-trash"></i></a>
          </label>
        </div>
        <div class="col-md-1">
          <br>
          <a class="btn btn-danger" href="javascript:removeDetailSectionById('productAttribute${divDetailsCount}')" title="Xóa thuộc tính này">Xóa</a>
        </div>
      </div>
    `;

    $("#divAttribute").append(htmlDetailSection);
  }

  function removeDetailSectionById(id) {
    $("#" + id).remove();
  }
</script>

<script>
  $(document).ready(function() {
    // Event delegation for showing the image
    $("#divAttribute").on("change", ".inputImage", function() {
      showImage(this);
    });

    // Event delegation for removing the image
    $("#divAttribute").on("click", ".removeImage", function(e) {
      e.preventDefault();
      resetImage(this);
    });
  });

  function showImage(fileInput) {
    const file = fileInput.files[0];
    const reader = new FileReader();
    reader.onload = function(e) {
      $(fileInput).closest('.row').find("img").attr("src", e.target.result);
    };
    reader.readAsDataURL(file);
  }

  function resetImage(button) {
    const row = $(button).closest('.row');
    // Reset the image source
    row.find("img").attr("src", "");
    // Clear the file input value
    row.find(".inputImage").val('');
  }
</script>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    $('#categoryGroupSelect').change(function() {
        var selectedCategoryGroupID = $(this).val();
        if (selectedCategoryGroupID !== '---Chọn---') {
            $.ajax({
                url: 'GetCategoriesByGroupServlet', 
                type: 'GET',
                data: { categoryGroupID: selectedCategoryGroupID },
                success: function(response) {
                    console.log('Server response:', response); // in ra phản hồi từ server
                    try {
                        
                        var categories = response;
                        $('#categorySelect').empty();
                        $('#categorySelect').append('<option selected>---Chọn---</option>');
                        $.each(categories, function(index, category) {
                            $('#categorySelect').append(
                                $('<option>', {
                                    value: category.CategoryID.trim(), // loại bỏ khoảng trắng thừa
                                    text: category.CategoryName
                                })
                            );
                        });
                    } catch (e) {
                        console.error('Error processing response:', e);
                        console.log('Response that caused error:', response); // in ra phản hồi nếu lỗi xảy ra
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log('Error fetching categories:', textStatus, errorThrown);
                    console.log('jqXHR:', jqXHR);
                    console.log('textStatus:', textStatus);
                    console.log('errorThrown:', errorThrown);
                }
            });
        } else {
            $('#categorySelect').empty();
            $('#categorySelect').append('<option selected>---Chọn---</option>');
        }
    });
});


</script>


	
</html>





