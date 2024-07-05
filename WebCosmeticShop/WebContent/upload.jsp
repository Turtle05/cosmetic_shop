<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<center>
    <h1>File Upload</h1>
    <form method="post" action="UploadFileServlet"
        enctype="multipart/form-data">
        Select file to upload: <input type="file" id="inputImage" accept="image/jpeg, image/png" name="file" size="60" /><br />
        <br /> <input type="submit" value="Upload" />
    </form>
    <img id="myimage" src="g"/>
</center>

<script type="text/javascript">
	$(document).ready(function() {
		$("#inputImage").change(function() {
			showImage(this);
		})
	});
	function showImage(fileInput) {
		const file = fileInput.files[0];
		const reader = new FileReader();
		reader.onload = function(e) {
			$("#myimage").attr("src", e.target.result);
		}
		reader.readAsDataURL(file)
	}
</script>
</body>
</html> --%>
<!DOCTYPE html>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<div align="center">
    <h1>Upload File to S3</h1>
    <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <p>Description: <input type="text" name="description" size = "30" required/></p>
        <label for="file">Choose file:</label>
        <input type="file" id="file" name="file"><br><br>
        <p><button type ="submit" >Upload</button>
    </form>
 </div>
</body>
</html>
