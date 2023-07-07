<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>UPDATE POST</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<style>
body {
	padding-top: 20px;
	padding-bottom: 20px;
	background: #fff;
}

@media ( min-width : 768px) {
	.container {
		max-width: 1000px;
	}
}

@
-ms-viewport {
	width: device-width;
}

.col-md-12 {
	background-color: #FFF;
	border-radius: 5px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	padding: 20px;
}

.col-md-6 {
	background-color: #FFF;
	border-radius: 5px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	padding: 20px;
}

.container {
	font-size: 16px;
	margin-top: 50px;
}

.link-admin {
	margin-left: 240px;
}
</style>
</head>

<body>
	<!-------------------------- start header --------------------------------------------->
	<c:import url="header.jsp"></c:import>
	<!-------------------------- end header --------------------------------------------->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card-body">
					<form action="updatePost" method="post">
						<input type="hidden" value="2" name="id_user">
						<input type="hidden" value="${post.idPost }" name="id_post">
						<div class="row">
							<div class="col-sm-12 form-group">
								<label>Tiêu đề</label>
								<div class="input">
									<input type="text" name="title" value="${post.title}"
										placeholder="Tiêu đề" class="form-control">
								</div>
							</div>
							<div class="col-sm-12 form-group">
								
								<textarea name="content" id="content" rows="5" cols="50"> ${post.content}</textarea>
								<br>
	<script>
    CKEDITOR.replace('content');
  
</script>
<script type="text/javascript">
document.getElementById('content').value ='${post.content}'
</script>


								<div class="input">
									<input type="submit" class="form-control">
								</div>
							</div>
							<div></div>
						</div>
					</form>
				</div>
			</div>


		</div>

	</div>


</body>

</html>