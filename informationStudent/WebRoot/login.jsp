<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="static/css/login.css">
   <link rel="stylesheet" type="text/css" href="static/css/slider.css"> 
  </head>
  
  <body>
     <div class="login" id="login">

        <div class="title">登录</div>
        <div class="main">
            <div id="userRight"></div>

            <label for="">用户名：</label>
            <input type="text" value="2019218111"><br>
            <label for="">密码：</label>
            <input type="password" name="pwd" id="pwd" value="110359"><br>
            <div id="loginRight">密码错误</div>

        </div>

        <div class="box">
            <div class="bgColor"></div>
            <div class="tips">滑动验证</div>
            <div class="ball"></div>
        </div>

        <button >登录</button>
        <button>
            <a href="register.jsp">注册</a>
            </button>
    </div>

    <script  charset="gb2312" type="text/javascript" src="static/js/slider.js"></script> 
    <script charset="utf-8" type="text/javascript" src="static/js/login.js"></script>
  </body>
</html>
