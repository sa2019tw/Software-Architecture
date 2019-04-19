<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <style type="text/css">
        .table th, .table td{
            vertical-align: middle
        }
        .custom-table-width {
            overflow-x: auto;
            padding-right: 0;
            padding-left: 0;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/bar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col custom-table-width">
            <%--<h4>List of course</h4>--%>
            <table class="table table-bordered table-striped">
                <caption>List of course</caption>
                <thead>
                <tr>
                        <th class="text-center" width="20%" scope="col">課程名稱</th>
                        <th class="text-center" width="10%" scope="col">課程說明</th>
                        <th class="text-center" width="10%" scope="col">適合對象</th>
                        <th class="text-center" width="10%" scope="col">定價</th>
                        <th class="text-center" width="15%" scope="col">注意事項</th>
                        <th class="text-center" width="10%" scope="col">備註</th>
                        <th class="text-center" width="25%" scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="course" >
                    <tr>
                        <td>${course.getName()}</td>
                        <td>${course.getDescription()}</td>
                        <td>${course.getLevel()}</td>
                        <td>${course.getPrice()}</td>
                        <td>${course.getPrecautions()}</td>
                        <td>${course.getRemarks()}</td>
                        <td class="text-center">
                            <button class="btn btn-warning" onclick="location.href='update?id=${course.getId()}'" role="button">編輯課程</button>
                            <button class="btn btn-danger sweet" onclick="{if(confirm('确定刪除嗎?')){
                                    location.href='delete?id=${course.getId()}';
                                    return true;
                                    }return false;}" role="button" style="margin-left: 20%">刪除課程</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
</script>

</body>
</html>
