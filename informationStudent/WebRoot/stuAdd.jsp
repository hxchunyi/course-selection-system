<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stuAdd.jsp' starting page</title>
    
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
        <h2 style="float:left">请添加学生信息</h2>
    </div>
    <form method="post" action="tianjia" enctype="multipart/form-data">
        请上传头像：<input type="file" name="file"><br> 请输入学号： <input type="text" name="id" class="cid">(注：十位学号)<br> 请输入姓名： <input type="text" name="username" class="cname"><br> 请选择性别：
        <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女<br> 请输入生日：
        <input type="text" name="birthday">(格式：1996-02-01)<br> 请输入民族:
        <input type="text" name="native"><br> 请输入政治面貌：
        <input type="text" name="ps"><br>
        <input type="submit" value="确定" class="right" style="color: white; background-color: #4180ec;margin-left: 50px;"><a href="javascript:;" onclick="history.back(-1)">返回</a>
        <p style="color:red">（如未添加信息，请勿提交）</p>
    </form>
    <script type="text/javascript">
    </script>
  </body>
</html>
