<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>Admin</title>

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
        .user {
            display: inline-block;
            width: 60%;
            background-color: #FFF;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            padding: 20px;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container d-flex flex-column align-items-center  mt-5">
    <div class="user">
        <div class="row">
            <div class="col-10">
                <p>Email: 213@gmail.com</p>
                <p>Trạng Thái: <span class="text-success">Bình Thường</span></p>
            </div>
            <div class="col-2 d-flex justify-content-around align-items-center">
                <i class="fa-solid fa-lock"></i>
                <i class="fa-solid fa-trash"></i>
            </div>
        </div>
    </div>
    <div class="user">
        <div class="row">
            <div class="col-10">
                <p>Email: 213@gmail.com</p>
                <p>Trạng Thái: <span class="text-danger">Bị Khóa</span></p>
            </div>
            <div class="col-2 d-flex justify-content-around align-items-center">
                <i class="fa-solid fa-lock-open"></i>
                <i class="fa-solid fa-trash"></i>
            </div>
        </div>
    </div>
</div>
</body>
</html>