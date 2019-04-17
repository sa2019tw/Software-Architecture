<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2019/3/20
  Time: 下午 07:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>warning</title>

</head>
<body>
    <script type='text/javascript'>
        setTimeout('countdown()', 1000);
        function countdown() {
            var s = document.getElementById('timer');
            s.innerHTML = s.innerHTML - 1;
            if (s.innerHTML == 0)
                window.location = 'http://localhost:8080/CourseHome';
            else
                setTimeout('countdown()', 1000);
        }
    </script>
    <h1 style="text-align: center">
        <br>資料處理錯誤!!!</br>
        系統將於 <span id='timer'>3</span> 秒後，為您自動轉跳首頁
    </h1>
</body>
</html>
