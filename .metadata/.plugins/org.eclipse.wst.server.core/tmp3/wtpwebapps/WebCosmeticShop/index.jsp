<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Upload" enctype="multipart/form-data" >
    Select file to upload: <input type="file" name="file" size="60" /><br /><br /> 
    <input type="submit" value="Upload" />
  </form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .modal-dialog-centered {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: calc(100% - 1rem);
        }
        .modal-content {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            max-width: 500px; /* Đặt chiều rộng tối đa cho modal */
        }
        .modal-body {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>

<!-- Profile section -->
<div class="container">
    <div class="card">
        <div class="card-body text-center">
            <img src="profile.jpg" id="profileImage" alt="Profile Image" class="rounded-circle" width="150">
            <p class="mt-3">Hãy cá nhân hóa tài khoản của bạn bằng một bức ảnh.</p>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#uploadModal">Thay đổi ảnh</button>
        </div>
        <div class="card-footer text-center">
            <span>Họ và tên: Nguyễn Trí Hậu</span>
            <a href="#" class="ml-3">Chỉnh sửa tên</a>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="uploadModal" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="uploadModalLabel">Upload Ảnh Hồ Sơ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="UploadServlet" method="post" enctype="multipart/form-data" class="w-100">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="profileImage">Chọn ảnh mới</label>
                        <input type="file" class="form-control-file" id="profileImage" name="profileImage" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
