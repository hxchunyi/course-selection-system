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
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="static/css/register.css">
	
  </head>
  <style>
  .userTip{
  position:absolute;
  top:161px;
  left:557px;
  width:299px;
  height:206px;
  line-height:25px;
  color:white;
  text-align:center;
  background:#48baff; 
  border-radius:5px; 
  }
  </style>
  <body>
   <div class="registerarea w">
        <h3>新用户注册 <i>我有账号，去<a href="login.jsp">登陆</a></i></h3>
        <div class="reg_form">
            <form action="register" method="post">
                <ul>
                    <li>
                        <label for="">用户名：</label><input type="text" class="inpt" name="username"><span> </span>
                    </li>
                    <li>
                        <label for="">登陆密码：</label><input type="password" class="inpt pd1" name="password"><span>
                            </span>
                    </li>
                    <li class="safe">
                        安全程度 <em class="ruo">弱</em><em class="zhong">中</em><em class="qiang ">强</em>
                    </li>
                    <li>
                        <label for="">确认密码：</label><input type="password" class="inpt pd2"><span class="sp2">
                                    
                            </span>
                    </li>
                    <li>
                        <label for="">手机号：</label><input type="tel" class="inpt" name="tel"><span>
                            <button>发送</button></span>
                    </li>
                    <li>
                        <label for="">短信验证码：</label><input type="text" class="inpt"><span>
                          <img src="img" style="vertical-align: middle;" onclick="changeimg(this)"> </span>
                    </li>
                    <li class="agree">
                        <input type="radio" name="userAdmin"  value="学生">学生
                        <input type="radio" name="userAdmin" value="老师">老师<br>
                        <br>
                        <input type="checkbox">同意协议并注册<a href="javascript:;">《师生用户须知》</a>
                    </li>
                    <li class="tijiao">
                        <input type="submit" value="完成注册">
                    </li>
                </ul>
            </form>
        </div>
        <div class="close"> 
    
    <c:if test="${flag!=null}">
     <div class="userTip">
    <c:if test="${username!=null}">
     <p style="margin-top:50px"> 你的账号为:${username}</p>
    <p>密码为:${password}</p>
    </c:if>
  <c:if test="${username==null}">
  <p style="margin-top:50px;color:red">注册失败</p>
  </c:if>
    <button onclick="window.location.href='login.jsp'">去登录</button> <button onclick="location.href='register.jsp'">关闭</button> 
    </div>
    </c:if>
    
   
    <script type="text/javascript"  charset="utf-8" src="static/js/register.js"></script>
   
  </body>
</html>
