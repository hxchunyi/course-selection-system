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
    
    <title>My JSP 'searchScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet"  type="text/css" href="static/css/index.css">
  </head>
  
  <body>
         <div class="condition">
     <form action="searchScore" method="post">
        课程名： <input type="text" name="seaName">
        开设学期：<input type="text" name="seaSemester">（注：默认查询所有成绩）
        <input class="search" type="submit" value="查询"></input>
         
     </form>
     <button class="add" onclick="window.location.href='searchScore.jsp'">清空</button>
       
    </div>
     <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>课程名</td>
                    <td>成绩</td>
                    <td>开设学期</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach  items="${Info}" var="sc">
		<tr>
		              <td>${sc.name}</td>
		              <td>${sc.score}</td>
		              <td>${sc.semester}</td>
         </tr>
         </c:forEach>
        </table>
   
  </body>
</html>
