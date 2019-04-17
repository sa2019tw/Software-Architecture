<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/bar.jsp" %>
<div class="container">
    <form action="/update" method="post">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="coursename">課程名稱</label>
                <input type="text" class="form-control" id="coursename" name="coursename" placeholder="Course Name" value="${course.getName()}" required>
            </div>
            <div class="form-group col-md-4">
                <label for="level">適合對象</label>
                <select id="level" name="level" class="form-control">
                    <option selected value="大一">大一</option>
                    <option value="大二">大二</option>
                    <option value="大三">大三</option>
                    <option value="大四">大四</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="courseprice">定價</label>
                <input type="number" class="form-control" name="courseprice" id="courseprice" placeholder="Price" value="${course.getPrice()}">
            </div>

            <div class="form-group col-md-6">
                <label for="coursedescription">課程說明</label>
                <input type="text" class="form-control" name="coursedescription" id="coursedescription" placeholder="Description" value="${course.getDescription()}">
            </div>
            <div class="form-group col-md-6">
                <label for="precautions">注意事項</label>
                <input type="text" class="form-control" name="precautions" id="precautions" placeholder="Precautions" value="${course.getPrecautions()}">
            </div>
            <div class="form-group col-md-12">
                <label for="remarks">備註</label>
                <input type="text" class="form-control" name="remarks" id="remarks" placeholder="Remarks" value="${course.getRemarks()}">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">送出</button>
    </form>
</div>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous">
</script>
</body>
</html>
