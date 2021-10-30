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
    
    <title>My JSP 'changePassword.jsp' starting page</title>
    
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
    * {
        margin: 0;
        padding: 0;
    }
    
    body {
        background-color: white;
    }
    
    .box {
        height: 60px;
        background-color: #107bf8;
    }
    
    .headleft {
        float: left;
        margin-left: 150px;
    }
    
    .headleft p {
        font-size: 26px;
    }
    
    .headRight {
        float: right;
        margin-right: 150px;
    }
    
    a {
        color: white;
        text-decoration: none;
    }
    
    p {
        display: inline-block;
        height: 60px;
        line-height: 60px;
        color: white;
    }
    
    .change {
        position: relative;
        height: 800px;
        width: 319px;
        margin: 150px auto;
    }
    
    input {
        display: inline-block;
        margin-top: 15px;
    }
    
    .change input:last-child {
        margin-left: 50px;
    }
    
    .isTel {
        position: absolute;
        top: 14px;
        right: -84px;
    }
    
    .isPassword {
        position: absolute;
        top: 84px;
        right: -42px;
    }
  
</style>

<body>
<c:if test="${flag}">
<script type="text/javascript">
alert("修改成功！你的新密码为: "+${password}+"")
</script>

</c:if>
    <div class="box">
        <div class="headleft">
            <p>信 息 安 全 中 心</p>
        </div>
        <div class="headRight">
            <p> ${acountValue.admin}（${acountValue.username}）</p>
            <p><a href="#">退出</a></p>
        </div>
    </div>
    <div class="change">
        <div class="isTel"></div>
        <div class="isPassword"></div>
        <form action="changePassword" method="POST">
            <input type="text" style="display: none;" value="${acountValue.tel}" class="isTelTure"> 请输入完整手机号：
            <input type="tel" class="tel" name="tel" ><br> 请输入修改的密码：
            <input type="password" class="password" name="password"><br> 请确定密码：
            <input type="password" class="isPaswordTrue"><br>
            <input type="submit" class="changeTrue" value="确定"></input>
        </form>
    </div>
</body>
<script>
    // alert("你正在修改密码,请谨慎操作！！！")
    var isTelTure = document.querySelector('.isTelTure');
    var isTel = document.querySelector('.isTel');
    var tel = document.querySelector('.tel');


    var isPaswordTrue = document.querySelector('.isPaswordTrue');
    var isPassword = document.querySelector('.isPassword');

    var changeTrue = document.querySelector('.changeTrue');
    //判断手机号
    tel.addEventListener('blur', function() {
        if (isTelTure.value == tel.value) {
            isTel.innerHTML = '手机号正确';
            isTel.style.color = 'green';
            changeTrue.disabled = false;
            isPaswordTrue.disabled = false;
        } else {
            isTel.innerHTML = '手机号错误';
            isTel.style.color = 'red';
            changeTrue.disabled = true;
            isPaswordTrue.disabled = true;
        }
    });
    //isPaswordTrue
    isPaswordTrue.addEventListener('blur', function() {
        var password = document.querySelector('.password');
        var isPaswordTrue = document.querySelector('.isPaswordTrue');
        if (password.value == isPaswordTrue.value) {
            isPassword.innerHTML = '密码相同';
            isPassword.style.color = 'green';
            changeTrue.disabled = false;
        } else {
            isPassword.innerHTML = '密码不相同';
            isPassword.style.color = 'red';
            changeTrue.disabled = true;
        }
    })
</script>
  </body>
</html>
