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
    
    <title>My JSP 'stuAddCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <link rel="stylesheet" type="text/css" href="static/css/index.css">
 <style>
  .tablelist tbody tr:hover td:nth-child(-n+6) {
    background-color: #4180ec;
}
  </style>
  </head>

 <h1 style="text-align: center;margin-top: 35px">${courseName}</h1>
 <form action="stuChangeScore" method="post">
 <input type="hidden" name="cid" value="${cid}">
  <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>分数</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="course" items="${LisL}">
		<tr>
		              <td>${course.id}</td>
		              <td>${course.username}</td>
		              <td>
		              <input style="height:100%;border: 0" type="text" name="score" value="${course.password}">
		              <input type="hidden" name="sid" value="${course.id}">
		              </td> 
         </tr>
         </c:forEach>
        </table>
        <button type="submit" style="margin-left: 350px">提交</button>
        <button type="button" onclick="history.go(-1)">返回 </button>
 </form> 
   
  </body>
</html>
