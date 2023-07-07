<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POST</title>
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

        @-ms-viewport {
            width: device-width;
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


        <!-------------------------- end post --------------------------------------------->

        <div class="col-sm-12">
            <div class="card-body">
                <form action="addPost" method="post">
                    <input type="hidden" value="2" name="id_user">
                  <%--  <% LocalDate currentDate = LocalDate.now(); %>
            <input type="hidden" value="<%= currentDate.toString() %>" name="date"> --%>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Tiêu đề</label>
                            <br>
                            <div class="input">
                                <input type="text" name="title" placeholder="Tiêu đề" class="form-control">
                            </div>
                            <br>

                            <textarea name="content" id="content" rows="5" cols="50">
                                  
                                </textarea>
                            <script>
                                CKEDITOR.replace('content');
                               
                            </script>
                            <br>
                            <div class="input">
                                <input type="submit" class="form-control">
                            </div>
                        </div>
                        <div>
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>


</body>

</html>