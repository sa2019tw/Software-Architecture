<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Satellite
  Date: 2019/2/27
  Time: 上午 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-success">
    <div class="panel-heading"><span class="glyphicon glyphicon-exclamation-sign">　</span>編輯課程</div>
    <div class="panel-body">
        <form name="insertForm" action="/Edit" method="POST">
            <label for="name" class="col-form-label">課程名稱(必填)</label>
            <input type="text" id="name" name="name" class="form-control" value="${selectCourse.getName()}" required>
            <label for="content" class="col-form-label">課程說明</label>
            <input type="text" id="content" name="content" class="form-control" value="${selectCourse.getContent()}">
            <label for="member" class="col-form-label">適合對象</label>
            <input type="text" id="member" name="member" class="form-control" value="${selectCourse.getMember()}">
            <label for="price" class="col-form-label">定價</label>
            <input type="text" id="price" name="price" class="form-control" value="${selectCourse.getPrice()}">
            <label for="notice" class="col-form-label">注意事項</label>
            <input type="text" id="notice" name="notice" class="form-control" value="${selectCourse.getNotice()}">
            <label for="remark" class="col-form-label">備註</label>
            <input type="text" id="remark" name="remark" class="form-control" value="${selectCourse.getRemark()}">
            <input type="hidden" id="id" name="id" value="${id}">
            <br>
            <input type="submit" class="btn btn-primary" value="修改">
        </form>
    </div>
</div>
