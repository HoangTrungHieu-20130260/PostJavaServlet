<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Check Code</title>

    <style>
        body {
            padding-top: 20px;
            padding-bottom: 20px;
            background: #fff;
        }
        .container {
            font-size: 16px;
            margin-top: 50px;

        }
        .login {
            background-color: #FFF;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            padding: 20px;
        }
    </style>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container d-flex justify-content-center">
    <div class="login" style="width: 400px;">
        <h1 class="text-center">Nhập mã đăng ký</h1>
        ${notify}
        <form action="checkCodeRegister" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Nhập mã code tại đây</label>
                <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                       placeholder="Code"
                       name="code">
            </div>
            <div class="d-flex justify-content-center mb-4">
                <button type="submit" class="btn btn-primary">Xác Nhận</button>
            </div>
<%--            <div class="d-flex justify-content-center">--%>
<%--                <p>Đã có tài khoản? <a href="login.jsp">Đăng Nhập</a></p>--%>
<%--            </div>--%>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
