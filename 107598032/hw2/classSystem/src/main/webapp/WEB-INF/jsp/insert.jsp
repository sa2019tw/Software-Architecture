<%--
  Created by IntelliJ IDEA.
  User: Satellite
  Date: 2019/2/25
  Time: 下午 05:07
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
        <div class="panel panel-success">
            <div class="panel-heading"><span class="glyphicon glyphicon-exclamation-sign">　</span>新增課程</div>
            <div class="panel-body">
                <form name="insertForm" action="/Insert" method="POST">
                    <label for="name" class="col-form-label">課程名稱(必填)</label>
                    <input type="text" id="name" name="name" class="form-control" required>
                    <label for="content" class="col-form-label">課程說明</label>
                    <input type="text" id="content" name="content" class="form-control">
                    <label for="member" class="col-form-label">適合對象</label>
                    <input type="text" id="member" name="member" class="form-control">
                    <label for="price" class="col-form-label">定價</label>
                    <input type="text" id="price" name="price" class="form-control">
                    <label for="notice" class="col-form-label">注意事項</label>
                    <input type="text" id="notice" name="notice" class="form-control">
                    <label for="remark" class="col-form-label">備註</label>
                    <input type="text" id="remark" name="remark" class="form-control">
                    <br>
                    <input type="submit" class="btn btn-primary" value="新增">
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
</body>
</html>
