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
    <c:forEach var="userList" items="${userList}">
        <div class="user">
            <div class="row">
                <div class="col-10">
                    <p>${userList.getUsername()}</p>
                    <p>Trạng Thái:
                        <c:if test="${userList.getStatus() eq 'enable'}">
                            <span class="text-success">${userList.getStatus()}</span>
                        </c:if>
                        <c:if test="${userList.getStatus() eq 'disable'}">
                            <span class="text-danger">${userList.getStatus()}</span>
                        </c:if>
                    </p>
                    <p>Chức vụ:
                        <c:if test="${userList.getRoles() eq 1}">
                            Admin
                        </c:if>
                        <c:if test="${userList.getRoles() eq 2}">
                            User
                        </c:if>
                    </p>
                </div>
                <div class="col-2 d-flex justify-content-around align-items-center">
                    <div class="col-2 d-flex justify-content-around align-items-center">
                        <c:choose>
                            <c:when test="${userList.getStatus() eq 'enable'}">
                                <a href="changeStatus?username=${userList.getUsername()}"><i class="fa-solid fa-lock"></i></a>
                                <a href="deleteUserController?id=${userList.getId()}"><i class="fa-solid fa-trash"></i></a>
                            </c:when>
                            <c:otherwise>
                                <a href="changeStatus?username=${userList.getUsername()}"><i class="fa-solid fa-lock-open"></i></a>
                                <a href="deleteUserController?id=${userList.getId()}"><i class="fa-solid fa-trash"></i></a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
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