<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'acountAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <style>
    body {
        background-color: #fff;
    }
    
    h2 {
        margin-top: 50px;
        margin-left: 260px;
    }
    
    form {
        width: 500px;
        margin: 0 260px;
    }
    
    input {
        margin-bottom: 15px;
        border-radius: 4px;
    }
    
    a {
        display: inline-block;
        width: 65px;
        height: 25px;
        line-height: 25px;
        margin-top: 3px;
        margin-left: 35px;
        text-align: center;
        color: #fff;
        background-color: #4180ec;
        border-radius: 4px;
        text-decoration: none;
    }
    
    .name {
        float: left;
        margin-top: 25px;
        margin-left: 80px;
        font-size: 16px;
        color: red;
    }
</style>

<body>
    <body>
        <div style="overflow:hidden">
            <h2 style="float:left">请添加用户信息</h2>
        </div>
        <form method="post" action="acountAdd">
            请输入用户名： <input type="text" name="username"><br> 
            请输入密码： <input type="text" name="password"><br> 
            请选择身份：<input type="radio" name="admin"  value="学生">学生
   <input type="radio" name="admin"  value="老师">老师
    <input type="radio" name="admin"  value="管理员">管理员<br>
        请输入手机号：    <input type="text" name="tel"><br> 
            <input type="submit" value="确定" style="color: #fff;
            background-color: #4180ec;margin-left: 35px;"><a href="javascript:;" onclick="history.back(-1)">返回</a>
        </form>
  </body>
</html>
