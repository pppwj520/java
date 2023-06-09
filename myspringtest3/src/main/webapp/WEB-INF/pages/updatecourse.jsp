<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updatecourse" method="post">
        <input type="hidden" name="id" value="${course.getId()}"/>
        课程名称：<input type="text" name="name"><br><br><br>
        学习课时：<input type="text" name="hours"><br><br><br>
        开课学院：<input type="text" name="schoolname"><br><br><br>
        <input type="submit" value="提交"/>
    </form>

</div>
</body>
</html>