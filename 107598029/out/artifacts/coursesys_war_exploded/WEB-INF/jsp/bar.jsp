<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="#">
        <span class="h3 mx-1">課程系統</span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/list" role="button">列出所有課程</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/creat" role="button">新增課程</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="find">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="cname">
            <input type="submit" class="btn btn-outline-success my-2 my-sm-0" role="button"></input>
        </form>
    </div>

</nav>
</body>
</html>
