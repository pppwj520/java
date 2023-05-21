<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>课程列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<% String email = session.getAttribute("email").toString(); %>
你好：<%=email%>
<a href="${pageContext.request.contextPath}/logout">注销</a>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>课程列表 —— 显示所有课程</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/toaddcourse">新增</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>课程ID </th>
                    <th>课程图像</th>
                    <th>课程名字</th>
                    <th>课程时间</th>
                    <th>学院名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${requestScope.get('courses')}">
                    <tr>
                        <td>${course.getId()}</td>
                        <td><img src="${pageContext.request.contextPath}${course.imgurl}" alt="无法加载图片" style="width:50px;height:50px"></td>
                        <td>${course.getName()}</td>
                        <td>${course.getHours()}</td>
                        <td>${course.getSchoolname()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toupdatecourse?id=${course.getId()}">更改</a> |
                            <a href="${pageContext.request.contextPath}/del/${course.getId()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>

</div>