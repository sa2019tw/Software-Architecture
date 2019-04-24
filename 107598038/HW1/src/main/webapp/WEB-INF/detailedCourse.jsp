<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2019/3/5
  Time: 下午 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>課程資訊</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        .container {
            margin-right: auto;
            margin-left: auto;
            padding-right: 150px;
            padding-left: 150px;
            width: 100%;
            max-width: 1920px;
        }
    </style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <jsp:include page="head.jsp" flush="true"></jsp:include>
    <br/>

    <div class="container">
        <div class="row">
            <div class="col-5">
                <img src="../image/gg.jpg" class="img-fluid" alt="Responsive image">
            </div>
            <div class="col-6">
                <h1>${course.name}</h1>
                <h5>${course.description}</h5>
            </div>
            <div class="col-5">
                <table class="table table-sm">
                    <tbody>
                    <tr>
                        <th scope="row">適合對象</th>
                        <td>${course.suitable}</td>
                    </tr>
                    <tr>
                        <th scope="row">注意事項</th>
                        <td>${course.note}</td>
                    </tr>
                    <tr>
                        <th scope="row">備註</th>
                        <td>${course.remark}</td>
                    </tr>
                    <tr>
                        <th scope="row">目前報名人數</th>
                        <td>${course.numberOfPeople}</td>
                    </tr>
                    <tr>
                        <th scope="row">定價</th>
                        <td>${course.price}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
