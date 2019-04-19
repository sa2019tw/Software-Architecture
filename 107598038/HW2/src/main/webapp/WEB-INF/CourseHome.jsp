<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2019/2/25
  Time: 下午 04:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>課程管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <jsp:include page="head.jsp"></jsp:include>

    <div class="bd-example">
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../image/a.jpg" class="d-block w-100 h-50" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="../image/gg.jpg" class="d-block w-100 h-50" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="../image/b.jpg" class="d-block w-100 h-50" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col">
                    <div style="text-align:right;">
                        <button type="button" class="btn btn-outline-success" onclick="javascript:location.href='addCourse'"> 新增</button>
                    </div>
            </div>
        </div>
    </div>
    <c:forEach var="course" items="${courseAll}">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card mb-3" style="max-width: 100%; height: auto">
                    <div class="row no-gutters">
                        <div class="col-5">
                            <a href="detailedCourse?ID=${course.ID}">
                                <img src="../image/gg.jpg" class="card-img" alt="...">
                            </a>
                        </div>
                        <div class="col-6">
                            <div class="card-body">
                                <h5 class="card-title" style="font-weight:bold;">${course.name}</h5>
                                <p class="card-text">${course.description}</p>
                                <p class="card-text"><small class="text-muted">${course.note}</small></p>
                            </div>
                        </div>

                        <div class="col-1">
                            <div style="text-align:right;">
                                <div class="btn-group" role="group">
                                   <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">編輯</button>
                                   <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                       <a class="dropdown-item" href="deleteCourse?ID=${course.ID}">刪除</a>
                                       <a class="dropdown-item" href="editCourse?ID=${course.ID}">編輯</a>
                                   </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>


</body>
</html>
