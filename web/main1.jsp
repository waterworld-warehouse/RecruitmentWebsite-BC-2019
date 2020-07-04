<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>新华招聘网首页</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

<!--css3动画样式-->
<link href="css/animate.min.css" rel="stylesheet" type="text/css">

<!--默认样式-->
<link href="css/common.css" rel="stylesheet" type="text/css">

<!--主要样式-->
<link href="css/indexSty.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/index_sty.js"></script>

<title>新华招聘网首页</title>
</head>

<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">新华招聘网</a>
        </div>
    </div>
</nav>
<div class="leftBg"></div><div class="rightBg"></div>
<div class="content mr">
<%--<div class="logo"><a href="http://sc.chinaz.com/"><img src="images/logo.png"></a></div>--%>
<!--左边hr-->
<div class="con_lf lf">
    <div class="big_word"><img alt="大企业，大能量" src="images/big_word.png"></div>
    <div class="btnCon"><a href="famousPerson.html">
      <img class="btnbg" src="images/left_btn_bg.png">
      <img class="btn_arow" src="images/left.png">
      <img class="btnWord" src="images/btn_word.png">
    </a></div>
    <div class="house"><img src="images/huose.png"></div>
</div>
<!--右边求职者-->
<div class="con_rf lf">
<div class="peoCon"><a href="famousPerson.html"></a>
	<img class="peo" src="images/peo.png">
	<img class="work" alt="挑工作" src="images/tiao.png">
</div>
<div class="peoBtn"><a href="${pageContext.request.contextPath}/findPersonByPageServlet">
	<img class="btnbg_rf" src="images/rf_bg.png">
    <img class="btnWord_rf" alt="求职者" src="images/qiuzhizhe.png">
    <img class="btn_arow_rf" src="images/rf.png">
</a></div>
<div class="big_word_rf"><img alt="小白领，大作为" src="images/right_word.png"></div>

</div>
</div>
</body>
</html>
