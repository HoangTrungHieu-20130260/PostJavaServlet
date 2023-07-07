<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <nav class="navbar navbar-default navbar-fixed-top" style="position: fixed;">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header ">
        <a class="navbar-brand" href="index.jsp">Trang chủ</a>
        <c:set var="user" value="${sessionScope.user}"></c:set>
        <c:choose>
          <c:when test="${user.getRoles() == 0}">
            <a class="navbar-brand" href="admin.jsp">Admin</a>
            <a class="navbar-brand" href="post.jsp">Trang người dùng</a>
            <a class="navbar-brand" href="logoutController">Đăng Xuất</a>
          </c:when>
          <c:when test="${user.getRoles() == 1}">
            <a class="navbar-brand" href="post.jsp">Trang người dùng</a>
            <a class="navbar-brand" href="logoutController">Đăng Xuất</a>
          </c:when>
          <c:otherwise>
            <a class="navbar-brand" href="login.jsp">Đăng Nhập</a>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </nav>
</div>
</body>
</html>
