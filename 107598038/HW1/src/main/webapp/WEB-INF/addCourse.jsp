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
    <title>新增課程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <jsp:include page="head.jsp"></jsp:include>
    <br/>

    <form action="addCourse" method="post">
        <div class="container">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="CourseName">課程名稱</label>
                    <input type="text" class="form-control" id="CourseName" name="CourseName" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="suitable">適合對象</label>
                    <input type=test class="form-control" id="suitable" name="suitable">
                </div>
            </div>
            <div class="form-group">
                <label for="description">課程說明</label>
                <textarea rows="4" cols="50" class="form-control" id="description" name="description"></textarea>
            </div>
            <div class="form-group">
                <label for="remark">備註</label>
                <textarea rows="4" cols="50" class="form-control" id="remark" name="remark"></textarea>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="note">注意事項</label>
                    <input type="text" class="form-control" id="note" name="note">
                </div>
                <div class="form-group col-md-2">
                    <label for="price">定價</label>
                    <input type="number" class="form-control" id="price" name="price"  min="0" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">確認</button>
        </div>
    </form>
</body>
</html>
