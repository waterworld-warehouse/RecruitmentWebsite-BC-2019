<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改求职信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body style="background:url('img/幻灯片3.PNG');background-size:100% 100% ; background-attachment: fixed">
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改求职信息</h3>
        <form action="${pageContext.request.contextPath}/updatePersonServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${person.id}">

          <div class="form-group">
            <label for="job_name">工作名称：</label>
            <input type="text" class="form-control" id="job_name" name="job_name"  value="${person.job_name}" readonly="readonly" placeholder="请输入工作名称" />
          </div>

          <div class="form-group">
            <label for="job_place">工作地点：</label>
            <input type="text" class="form-control" value="${person.job_place}" id="job_place"  name="job_place" placeholder="请输入工作地点" />
          </div>

          <div class="form-group">
            <label for="job_money">目标薪水：</label>
            <input type="text" id="job_money" class="form-control" value="${person.job_money}" name="job_money" placeholder="请输入目标薪水"/>
          </div>


             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                 <a href="${pageContext.request.contextPath}/findPersonByPageServlet"><input class="btn btn-default" type="button" value="返回"/></a>
             </div>
        </form>
        </div>
    </body>
</html>