<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
       //解决post/get 请求中文乱码的方法
       request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
   %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"  type="text/css" href="static/css/index.css">
	<script charset="gb2312" type="text/javascript"  src="static/js/index.js"></script>
  </head>

  <body>
       <div class="header">
        <div class="logo">河西学生信息管理系统</div>
        <div class="user">
            <p>${admin}</p>
            <ul>
                <li><a href="#">个人信息</a> </li>
                <li><a href="changePassword.jsp">修改密码</a> </li>
                <li><a href="#" class="loginout">退出登录</a> </li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="left">
            <div class="title">系统功能</div>
            <div class="menux">
            <c:if test="${admin == '管理员'}">
               <p>管理员操作</p>
                <ul>
                <li> <a href="javascript:;" url="teacher" title="老师管理">老师管理</a> </li>
                <li> <a href="javascript:;" url="course" title="课程管理">课程管理</a> </li>
                   <li> <a href="javascript:;" url="student" title="学生信息管理">学生信息管理</a> </li>
                    <li> <a href="javascript:;" url="acount" title="账号信息管理">账号信息管理</a> </li>
                </ul>
             </c:if>
             <c:if test="${admin == '老师'}">
                <p>老师操作</p>
                <ul>
                    <li> <a href="javascript:;" url="teaStudentServlet" title="学生信息管理">学生信息管理</a> </li>
                    <li> <a href="javascript:;" url="teacherSearchCourse" title="课程管理">学生成绩查询与录入</a> </li>
                </ul>
                </c:if>
                 <c:if test="${admin == '学生'}">
                <p>学生操作</p>
                <ul>
                         <li> <a href="javascript:;" url="changeCourse"  title="选课"> 选课</a> </li>
                    <li> <a href="javascript:;" url="searchScore" title="成绩查询">成绩查询</a> </li>
                    <li> <a href="javascript:;" url="personal?id=${acountValue.username}" title="个人信息">个人信息</a> </li>
                </ul>
                  </c:if>
            </div>
        </div>
        <div class="right">
            <div class="location">
                <span class="menu_title">用户管理</span>

            </div>
            <iframe src="SystemInfo.jsp" frameborder="0" width="100%" height="90%"></iframe>
        </div>
    </div>
  </body>
</html>
