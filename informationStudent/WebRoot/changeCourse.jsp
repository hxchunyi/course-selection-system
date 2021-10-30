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
    
    <title>My JSP 'changeCourse.jsp' starting page</title>
    
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
  <body>
    <marquee style="color: red">选课信息一旦修改不可改变，请谨慎选择！修改后请与老师联系确认是否选上！</marquee>
    <form action="changeCourse" method="post">
          <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>选课情况</td>
                    <td>课程名</td>
                    <td>老师</td>
                    <td>学分</td>
                </tr>
            </thead>
            <tbody>
      
           <c:forEach var="no" items="${NoInfo}">
		<tr>
		              <td>
		              <input type="checkbox"  width="70px" name="courseId" value="${no.id}"
		              <c:forEach var="course" items="${Info}">
	<c:if test="${course.name ==no.name}">checked="checked"</c:if>
         </c:forEach> >
		              </td>
		              <td>${no.name}</td>
		              <td>${no.score }</td>
		              <td>${no.semester}</td>
         </tr>
         </c:forEach>
        </table>
    </form>
   <input type="submit" value="修改" style="width: 44px;margin-left: 350px">
  </body>
  <button type="button" onclick="history.go(-1)">返回</button>
</html>
