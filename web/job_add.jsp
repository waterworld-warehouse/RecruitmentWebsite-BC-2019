<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background:url('img/5.JPG');background-size:100% 100% ; background-attachment: fixed">
<div class="container">
    <center><h3>添加求职信息页面</h3></center>
    <form action="${pageContext.request.contextPath}/addPersonServlet" method="post">
        <div class="form-group">
            <label for="job_name">工作名称：</label>
            <input type="text" class="form-control" id="job_name" name="job_name" placeholder="请输入工作名称">
        </div>

        <div class="form-group">
            <label for="job_place">工作地点：</label>
            <input type="text" class="form-control" id="job_place" name="job_place" placeholder="请输入工作地点">
        </div>

        <div class="form-group">
            <label for="job_money">目标薪水：</label>
            <input type="text" class="form-control" id="job_money" name="job_money" placeholder="请输入目标薪水"/>
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