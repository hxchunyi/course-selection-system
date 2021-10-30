<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal_info.jsp' starting page</title>
    
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
  body{
  background-color: white;
  }
    h2 {
        margin-left: 260px;
        margin-top: 50px;
    }
    
    a {
        display: inline-block;
        width: 50px;
        height: 25px;
        line-height: 25px;
        margin-left: 35px;
        text-align: center;
        color: white;
        background-color: #4180ec;
        border-radius: 3px;
        text-decoration: none;
    }
    img{
    margin: 0 260px;
    }
    form {
        width: 500px;
        margin: 0 260px;
    }
    
    input {
        margin: 10px 0;
        border-radius: 3px;
    }
</style>

<body>
    <div style="overflow:hidden">
        <h2 style="float:left;margin-left: 320px" >个人基本信息</h2>
    </div>
    <img width="88" src="<%=basePath%>${st.avatar}">
    <form method="post" action="xiugai" enctype="multipart/form-data">
   学号： <input type="text" disabled="disabled" name="id" class="cid" value="${st.id}">(注：十位学号)<br> 姓名： <input type="text" disabled="disabled" name="username" class="cname" value="${st.name}"><br>
         性别：<input  disabled="disabled" type="radio" name="sex"  value="男"<c:if test="${st.sex=='男'}">checked="checked"</c:if> >男
   <input disabled="disabled" type="radio" name="sex"  value="女"  <c:if test="${st.sex=='女'}">checked="checked"</c:if>>女<br> 生日：
        <input type="text" disabled="disabled" name="birthday" value="${st.birthday}">(格式：1996-02-01)<br> 民族:
        <input type="text" disabled="disabled"  name="native" value="${st.nat }"><br> 政治面貌：
        <input type="text" disabled="disabled" name="ps" value="${st.pss }"><br>
        <input type="submit" disabled="disabled" value="修改" class="right" style="color: white; background-color: #4180ec;margin-left: 50px;"><a href="javascript:;" onclick="history.back(-1)">返回</a>
        <p style="color:red">（暂不支持修改，如修改请联系管理员！！）</p>
    </form>
  </body>
</html>
