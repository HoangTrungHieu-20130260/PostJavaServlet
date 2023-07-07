<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ page import="model.PostModel" %>
<%@ page import="service.impls.PostService" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <style>
        body {
            padding-top: 20px;
            padding-bottom: 20px;
            background: #fff;
        }

        @media (min-width: 768px) {
            .container {
                max-width: 1000px;
            }
        }



        .col-sm-12 {
            background-color: #FFF;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
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
<!-------------------------- start post --------------------------------------------->
<div class="container">
    <div class="row">
        <div class="col-sm-8">
            <div class="card-body">
                <div class="row">
               
           <%   PostService ps = new PostService(); 
                List<PostModel> posts = ps.getPost();
                for (PostModel pm : posts)
                  {%>
                  <div class="col-sm-12 form-group">
                            <a class="forget-password" href="updatePost.jsp">Chỉnh sửa bài viết</a>
                            <a href="#" class="link-admin">Xóa</a>
                            <br>
                            <label style="font-weight: bold;"><%=pm.getTitle() %> </label>
                            <h6></h6>
                            <h5 style="font-style: italic;"><%=pm.getContent() %></h5>
                            <h5 style="font-style: italic;"><%=pm.getDate()%></h5>
                            <h5 style="font-style: italic;"><%=pm.getUserName() %></h5>
                        </div>
                  <%} %>
           <%--      <c:forEach var="post" items="${postList}">
                        <div class="col-sm-12 form-group">
                            <a class="forget-password" href="updatePost.jsp">Chỉnh sửa bài viết</a>
                            <a href="#" class="link-admin">Xóa</a>
                            <br>
                            <label style="font-weight: bold;">${post.title} </label>
                            <h6></h6>
                            <h5 style="font-style: italic;">${post.id_user}</h5>
                            <h5 style="font-style: italic;">${post.date}</h5>
                        </div>
              </c:forEach> --%>


                </div>
                <div>

                </div>
            </div>

        </div>

        <!-------------------------- end post --------------------------------------------->
    </div>
</div>


</body>

</html>