<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'courseOfTeacher.jsp' starting page</title>
    
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
            <h2 style="float:left">请添加老师信息</h2>
        </div>
        <form method="post" action="courseOfTeacher">
            请输入老师编号： <input type="text" name="tid"><br> 
            请输入老师姓名    <input type="text" name="tname"><br>
               请输入年级：  <input type="text" name="grade"><br> 
            请选择课程编号：
              <select name="cid">
  <c:forEach items="${LisL}" var="course">
    <option value="${course.id}">${course.name}</option>
  </c:forEach>
   </select>
            <br>
            <c:if test="${flag == 'ok'}"><p style="color: red">添加成功</p></c:if>
            <input type="submit" value="确定" style="color: #fff;
            background-color: #4180ec;margin-left: 35px;margin-right: 35px;margin-top: 35px"><a href="javascript:;" onclick="history.back(-1)">返回</a>
       
        </form>
        <span style="color: red;margin-left: 335px;">(添加后，不可修改)</span>
        
  </body>
</html>
