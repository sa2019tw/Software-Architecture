<%--
  Created by IntelliJ IDEA.
  User: Satellite
  Date: 2019/4/17
  Time: 下午 07:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>課程系統</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="buttons.jsp"></jsp:include>
    <div class="col-md-15">
        <div class="panel panel-danger">
            <div class="panel-heading"><span class="glyphicon glyphicon-exclamation-sign">　</span>錯誤</div>
            <div class="panel-body">
                <h1>Error</h1>
            </div>
        </div>
    </div>
</div><!-- /container -->
</body>
</html>
