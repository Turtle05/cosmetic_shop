<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.bean.CategoryGroup"%>
<%@page import="model.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="common.StringCommon"%>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phẩm</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>
    
    .pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 10px 0;
    white-space: nowrap;
    margin-bottom: 15px;
	}

	.pagination a {
	    color: black;
	    padding: 8px 16px;
	    text-decoration: none;
	    transition: background-color 0.3s;
	    margin: 0 4px;
	    border: 1px solid #ddd;
	    border-radius: 4px;
	    display: inline-block; /* Ensure inline-block display to stay in a line */
	}
	
	.pagination a:hover {
	    background-color: #ddd;
	}
	
	.pagination a.active {
	    background-color: #4CAF50;
	    color: white;
	    border: 1px solid #4CAF50;
	}
	
	.pagination a:first-child,
	.pagination a:last-child {
	    font-weight: bold;
	}
	
	.pagination a.disabled {
	    color: #ccc;
	    pointer-events: none;
	    cursor: not-allowed;
	}
	    
    
    .product-container{
   	 margin: 0 auto;
     display: grid;
     grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
     gap: 25px;
     box-sizing: border-box;
     width: 100%;
     background-color: white;
     box-shadow: none;
     padding: 40px 30px 30px 30px;


    }
    
    .main-body{
	width: 100%;
	background-color: white;
     display: ;
     flex-direction: column;
     align-items: center;
     text-align: center;

	}
        .category {
            margin-bottom: 10px;
        }

        .subcategory {
            display: none;
            margin-left: 20px;
        }

        

       

        .brand-list {
            max-height: 200px;
            overflow-y: auto;
        }

        .category-header {
            display: flex;
            align-items: center;
        }

        .category-name {
            margin-right: auto;
        }

        .category-name a {
            margin-right: 5px;
            font-size: 18px;
            font-weight: bold;
            text-decoration: none;
            color: black;
        }

        .category-name-sub a {

            font-size: 16px;
            font-weight: bold;
            text-decoration: none;
            color: #333;
        }

        .category-name a:hover,
        .category-name-sub a:hover {
            color: blue;
        }


       

      .expand::after {
            content: '+';
        }
        .collapse::after {
            content: '-';
        }
        .subcategory {
            display: none;
        }
        .category-name-sub {
            padding-left: 20px;
        }

        
        
     
        
    </style>

</head>

<%
    ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>) request.getAttribute("productList");
    if (productList != null) {
        for (ProductDTO product : productList) {
            // Code to display product information
        }
    } else {
        out.println("Không có sản phẩm!");
    }
%>

<%
    ArrayList<CategoryGroup> catGroupList = (ArrayList<CategoryGroup>) request.getAttribute("catGroupList");
if (catGroupList != null) {
    for (CategoryGroup pg : catGroupList) {
        // Code to display product information
    }
} else {
    out.println("Không có sản phẩm!");
}
%>

<%
	String searchText = session.getAttribute("searchProductText") != null
			? (String) session.getAttribute("searchProductText"): "";
	 String functionPrefix = "".equals(searchText) ? "ShowProductListServlet" : "SearchProductServlet"; 
	%>

<%
	int currentPageNumer = (Integer) request.getAttribute("currentPageNumer"); // Do server trả về

	int totalPageNumber = (Integer) request.getAttribute("totalPageNumber"); // Do server trả về

	int[] pageNumberList = new int[10]; // Do client tự tính toán

	int pageQuantity = 0; // Do client tự tính toán

	// Tình huống số 1:
	//tổng số trang nhỏ hơn hoặc bằng 10

	if (totalPageNumber <= 10) {

		for (int j = 0; j < totalPageNumber; j++) {

			pageNumberList[j] = j + 1;

			pageQuantity++;

		}

	}

	// Tình huống số 2 nằm trong tình huống số 4 rồi

	// Tình huống số 3:
	// Nếu tổng số trang lớn hơn 10, và currentPageNumer <= 4, thì ta luôn luôn in ra là 1 2 3 4 5 6 7 8 9 10.

	// Tình huống số 3:

	if (totalPageNumber > 10 && currentPageNumer <= 4) {

		for (int j = 0; j < 10; j++) {

			pageNumberList[j] = j + 1;

			pageQuantity++;

		}

	}

	// Tình huống số 4
	if (totalPageNumber > 10 && currentPageNumer >= (totalPageNumber - 5)) {

		for (int j = 10; j >= 1; j--) {

			pageNumberList[j - 1] = totalPageNumber - (10 - j);

			pageQuantity++;

		}

	}

	// Tình huống số 5:

	if (totalPageNumber > 10 && currentPageNumer >= 5 && currentPageNumer <= (totalPageNumber - 5)) {

		for (int j = 0; j < 10; j++) {

			pageNumberList[j] = currentPageNumer - 3 + j;

			pageQuantity++;

		}

	}
	%>
<body>
    <header>
        <div class="header-left">
            <img src="logo.jpg" alt="Logo" class="logo">
        </div>
        <div class="header-center">
            <nav>
                <ul>
                    <li><a href="ShowHomeServlet">Trang chủ</a></li>
                    <li><a href="ShowProductListServlet">Sản phẩm</a></li>
                    <li><a href="#">Thương hiệu</a></li>
                </ul>
            </nav>
            <div class="search-bar">
                <input type="text" class="search-input" placeholder="Tìm kiếm...">

                <button><i class="fa-solid fa-magnifying-glass"></i></button>
            </div>
        </div>
        <div class="header-right">

            <div class="cart">
                <a href="ShowCartServlet"><i class="fa-solid fa-cart-shopping"></i></a>
             <!--    <p>Giỏ hàng</p> -->
            </div>

   			<% if (session.getAttribute("accountInfor") == null) {%>		
	           <div class="profile-dropdown account">
	                <a href="login.jsp" title="Đăng nhập"><i class="fa-solid fa-user"></i></a>
	           			<!--      <p>Tài khoản</p> -->
           	   </div>
	           <%} else { %>
           
               <div class="profile-dropdown account">
	                <a href="#" title="Tài khoản"><i class="fa-solid fa-user"></i></a>
	           			<!--<p>Tài khoản</p> -->
	                <div class="profile-dropdown-content">
	                    <a href="ShowInforServlet"><i class="fa-regular fa-user"></i>Thông tin tài khoản</a>
	                    <a href="ShowOrderServlet"><i class="fa-solid fa-list-check"></i>Quản lý đơn hàng</a>
	                    <a href="LogoutServlet"><i class="fa-solid fa-arrow-right-from-bracket"></i>Đăng xuất</a>
	                </div>
            	</div>
                <%} %>
            </div>

    </header>


    <div class="sub-header">
        <div class="breadcrumb">
            <a href="#">Trang chủ</a> / <span>Sản phẩm</span>
        </div>
        <div class="filter">
            <select>
                <option value="newest">Mới nhất</option>
                <option value="oldest">Cũ nhất</option>
                <option value="price-asc">Giá tăng dần</option>
                <option value="price-desc">Giá giảm dần</option>
            </select>
        </div>
    </div>




    <div class="main-container">
        <aside class="sidebar">
            <div>
                <h2>Danh mục</h2>
                
                
                
             <%--   <%for(CategoryGroup cg : catGroupList) {%> 
            <div class="category">
        <div class="category-name">
            <a href="ShowProductByCatGroup?catGroupID=<%=cg.getCategoryGroupID()%>"><%=cg.getCategoryGroupName()%></a>
        </div>
        <div class="expand" onclick="toggleSubcategory(this, '<%=cg.getCategoryGroupID()%>')"></div>
        <div class="subcategory"></div>
    </div>
    
        <% } %>     --%>    
        
          <%for(CategoryGroup cg : catGroupList) {%> 
            <div class="category">
        <div class="category-name">
            <a href="ShowProductByCatGroup?catGroupID=<%=cg.getCategoryGroupID()%>"><%=cg.getCategoryGroupName()%></a>
        </div>
        <div class="expand" onclick="toggleSubcategory(this, '<%=cg.getCategoryGroupID()%>')"></div>
        <div class="subcategory"></div>
    </div>
    
        <% } %>    
                
                
               
                
            </div>


            <div>
                <h2>Thương hiệu</h2>
                <div class="category">
                    <div class="brand-list">
                        <div><input type="checkbox"> CeraVe</div>
                        <div><input type="checkbox"> Nerman</div>
                        <div><input type="checkbox"> Cetaphil</div>
                        <div><input type="checkbox"> Hazeline</div>
                        <div><input type="checkbox"> Listerine</div>
                    </div>
                </div>
            </div>

        </aside>
		<div class="main-body">
        <div class="product-container">
        <% String message = request.getParameter("message"); %>
        <%=("1".equals(message)) ? "thành công!" : "" %>
          <%=("".equals(message)) ? "không thành công!" : "" %> 
        <% for (ProductDTO p : productList) { %>
        
            <div class="product-card">
            <a href="ShowProductDetailServlet?productGroupID=<%=p.getProductGroupID()%>&productID=<%=p.getProductID()%>"><img src="<%=p.getImage() %>" alt="Product"></a>
            <div class="product-info">
            
            
                <p class="price"><%=StringCommon.formatCurrency(p.getPrice())%> </p>
                <p class="brand"><a href="#"><%=p.getBrandName()%></a></p>
                <p class="description"><%=p.getProductGroupName()%></p>
                <button type="button" onclick="addToCart('<%=p.getProductGroupID()%>', '<%=p.getProductID()%>');" class="add-to-cart">Thêm vào giỏ</button>
            </div>
        </div>
        
         <% } %>
            
          
        </div>
        
		 <div class="pagination" >
		                <%
			if (currentPageNumer > 1) {
			%>
		
			<a href='<%=functionPrefix%>?page=1'>Đầu</a>
		
			<a href='<%=functionPrefix%>?page=<%=currentPageNumer - 1%>'> &laquo;
			</a>
		
			<%
			}
			for (int k = 0; k < pageQuantity; k++) {
		
			if (pageNumberList[k] == currentPageNumer) {
			%>
		
			<a href='<%=functionPrefix%>?page=<%=pageNumberList[k]%>'><b><%=pageNumberList[k]%></b></a>
		
			<%
			} else {
			%>
		
			<a href='<%=functionPrefix%>?page=<%=pageNumberList[k]%>'><%=pageNumberList[k]%></a>
		
			<%
			}
		
			}
			%>
		
		
		
			<%
			if (currentPageNumer < totalPageNumber) {
			%>
		
			<a href='<%=functionPrefix%>?page=<%=currentPageNumer + 1%>'> &raquo
			</a>
		
			<a href='<%=functionPrefix%>?page=<%=totalPageNumber%>'>Cuối</a>
		
			<%
			}
			%>
		</div>  
        
        
        </div>
        
        
  
    </div>
    
   




    <footer>
        <div class="footer-container">
            <div class="footer-section">
                <h3>Về chúng tôi</h3>
                <p>COSMETIC SHOP chuyên cung cấp các sản phẩm chăm sóc da uy tín và chất lượng.</p>
            </div>
            <div class="footer-section">
                <h3>Liên hệ</h3>
                <p>Email: 123@example.com</p>
                <p>Điện thoại: 0123-456-789</p>
            </div>
            <div class="footer-section">
                <h3>Kết nối với chúng tôi</h3>
                <p>
                    <a href="#"><i class="fa-brands fa-facebook"></i></a>
                    <a href="#"><i class="fa-brands fa-twitter"></i></a>
                    <a href="#"><i class="fa-brands fa-instagram"></i></a>
                </p>
            </div>
        </div>
    </footer>




    <script src="script.js"></script>
   <!--  <script>
        function toggleSubcategory(element) {
            var subcategory = element.nextElementSibling;
            if (subcategory.style.display === "none" || subcategory.style.display === "") {
                subcategory.style.display = "block";
                element.classList.remove("expand");
                element.classList.add("collapse");
            } else {
                subcategory.style.display = "none";
                element.classList.remove("collapse");
                element.classList.add("expand");
            }
        }
    </script> -->
    


   <script>
    function addToCart(productGroupID, productID) {
        var xhr = new XMLHttpRequest();
        
        xhr.open("POST", "AddToCart", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  
	    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        xhr.onreadystatechange = function () {
        	if (xhr.responseText === 'not_logged_in') {
        		console.log('responseText:', xhr.responseText);
                alert('Bạn chưa đăng nhập!.');
                window.location.href = "login.jsp"; // Thực hiện chuyển hướng trang
            } else
            {console.log("readyState: " + xhr.readyState + ", status: " + xhr.status); // Kiểm tra trạng thái
            if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	            	console.log('responseText:', xhr.responseText);
	                if (xhr.responseText === 'success') {
	                    alert('Sản phẩm đã được thêm vào giỏ hàng.');
	                } else {
	                    alert('Có lỗi xảy ra. Vui lòng thử lại.');
	                }
	            } else {
	                alert('Có lỗi xảy ra. Vui lòng thử lại.');
	            }
	            }
	        }
        };

        xhr.send("proGroupID=" + encodeURIComponent(productGroupID) + "&proID=" + encodeURIComponent(productID));
    }

</script>

<script>
function toggleSubcategory(element, categoryGroupID) {
    var subcategory = element.nextElementSibling;
    console.log("Toggling subcategory for group:", categoryGroupID);

    if (subcategory.style.display === "none" || subcategory.style.display === "") {
        if (!subcategory.hasChildNodes()) {
            fetchCategories(categoryGroupID, subcategory);
        } else {
            subcategory.style.display = "block";
        }
        element.classList.remove("expand");
        element.classList.add("collapse");
    } else {
        subcategory.style.display = "none";
        element.classList.remove("collapse");
        element.classList.add("expand");
    }
}

function fetchCategories(categoryGroupID, subcategoryElement) {
    console.log("Fetching categories for group:", categoryGroupID);
    fetch('GetCategoriesByGroup?categoryGroupID=' + categoryGroupID)
        .then(response => {
            console.log("Fetch response status:", response.status);
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            console.log("Categories fetched:", data);
            if (data.length === 0) {
                var div = document.createElement("div");
                div.className = "category-name-sub";
                div.innerHTML = '<span>Không có danh mục nào</span>';
                subcategoryElement.appendChild(div);
            } else {
                data.forEach(category => {
                    var div = document.createElement("div");
                    div.className = "category-name-sub";
                    div.innerHTML = '<a href="ShowProductByCat?catID=' + category.CategoryID.trim() + '">' + category.CategoryName.trim() + '</a>';

                    subcategoryElement.appendChild(div);
                });
            }
            subcategoryElement.style.display = "block";
        })
        .catch(error => console.error('Fetch error:', error));
}
    </script>
    
</body>

</html>