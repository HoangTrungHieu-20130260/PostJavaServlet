<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
        <div class="col-sm-8">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-12 form-group">
                        <a class="forget-password" href="updatePost.jsp">chỉnh sửa bài viết</a>
                        <a href="#" class="link-admin"> Xóa</a>
                        <br>
                        <label style="font-weight: bold;">Tiltle</label>
                        <h6> nội dung
                            Screen readers will have trouble with your forms if you don't include a label for every
                            input. For these inline forms, you can hide the labels using the .sr-only class. There are
                            further alternative methods of providing a label for assistive technologies, such as the
                            aria-label, aria-labelledby or title attribute. If none of these is present, screen readers
                            may resort to using the placeholder attribute, if present, but note that use of placeholder
                            as a replacement for other labelling methods is not advised.
                            nội dung Screen readers will have trouble with your forms if you don't include a label for
                            every input. For these inline forms, you can hide the labels using the .sr-only class. There
                            are further alternative methods of providing a label for assistive technologies, such as the
                            aria-label, aria-labelledby or title attribute. If none of these is present, screen readers
                            may resort to using the placeholder attribute, if present, but note that use of placeholder
                            as a replacement for other labelling methods is not advised.
                        </h6>
                        <h5 style="font-style:italic"> Tên người dùng</h5>
                        <h5 style="font-style:italic"> 22/12/2023</h5>
                    </div>
                </div>


                <!-- <div class="row">
                    <div class="col-sm-12 form-group">
                        <a class="forget-password" href="#">chỉnh sửa bài viết</a>
                        <a href="#" class="link-admin"> Xóa</a>
                        <br>
                        <label>Tiltle</label>
                        <h4> nội dung
                            Screen readers will have trouble with your forms if you don't include a label for every input. For these inline forms, you can hide the labels using the .sr-only class. There are further alternative methods of providing a label for assistive technologies, such as the aria-label, aria-labelledby or title attribute. If none of these is present, screen readers may resort to using the placeholder attribute, if present, but note that use of placeholder as a replacement for other labelling methods is not advised.
                            nội dung Screen readers will have trouble with your forms if you don't include a label for every input. For these inline forms, you can hide the labels using the .sr-only class. There are further alternative methods of providing a label for assistive technologies, such as the aria-label, aria-labelledby or title attribute. If none of these is present, screen readers may resort to using the placeholder attribute, if present, but note that use of placeholder as a replacement for other labelling methods is not advised.
                        </h4>

                    </div>
                </div> -->
                <div>

                </div>
            </div>

        </div>

        <!-------------------------- end post --------------------------------------------->


    </div>
</div>


</body>

</html>