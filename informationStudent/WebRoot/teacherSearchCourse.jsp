<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacherSearchCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="static/css/index.css">
  </head>
  <style>
    .tablelist tbody tr:hover td:nth-child(-n+6) {
    background-color: #4180ec;
}
  </style>
<h2 style="text-align: center;margin-top: 55px">您的课程安排，若修改请联系管理员</h2>
  <body>
        <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>课程号</td>
                    <td>课程名</td>
                    <td>所教年级</td>
                    <td>学时</td>
                    <td>学分</td>
                    <td>开设学期</td>
                    <td>评分</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="course" items="${LisL}">
		<tr>
		              <td>${course.id}</td>
		              <td>${course.name}</td>
		              <td>${course.introduce }</td>
		              <td>${course.hour}</td>
		              <td>${course.credit }</td>
		              <td>${course.semester }</td>
		              <td><span class="edit"><a href="stuManage?cid=${course.id}&&coursename=${course.name}">评分</a></span></td>
         </tr>
         </c:forEach>
        </table>
         <button style="margin-left: 661px" type="button" onclick="history.back(-1)">返回 </button>
  </body>
</html>
