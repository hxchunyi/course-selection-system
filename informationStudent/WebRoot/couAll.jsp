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
    
    <title>My JSP 'couAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="static/css/index.css">
 <style>
  .tablelist tbody tr:hover td:nth-child(-n+6) {
    background-color: #4180ec;
}
  </style>
  </head>
  <div class="condition">
     <form action="course" method="get">
       课程号：<input type="text" name="seaId">
        课程名： <input type="text" name="seaName">
        开设学期：<input type="text" name="seaSem">
        <input class="search" type="submit" value="搜索" style="right:400px"></input>
     </form>
     <button class="add" onclick="window.location.href='couAdd.jsp'" style="right:316px">新增</button>
  
    <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>课程号</td>
                    <td>课程名</td>
                    <td>介绍</td>
                    <td>学时</td>
                    <td>学分</td>
                    <td>开设学期</td>
                    <td colspan="2">操作</td>
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
                      <td><span class="edit"><a href="courevise?id=${course.id}">修改</a></span></td>
                      <td><span ><a href="javascript:;" Id="${course.id}"   class="detele couDetele">删除</a></span></td>
         </tr>
         </c:forEach>
        </table>
        <table class="page">
            <tr>
                <button type="button" onclick="javascript:go(1)" style="margin-left:279px">首页</button>
                
                <button type="button" onclick="javascript:go(${prePage})" <c:if test="${isFirstPage == true }">disabled</c:if>>上一页</button>
                <button type="button" onclick="javascript:go(${nextPage})" <c:if test="${isLastPage == true }">disabled</c:if>>下一页</button>
                <button type="button" onclick="javascript:go(${totalPage})">尾页</button>
                <input  type="text" class="inputPa">
                <button type="button" class="toPa" >跳转</button>
                总记录条数${totalCount}条，当前${pageNo} / ${totalPage}页 ,每页${pageSize}条数据
            </tr>

        </table>
    </div>
    <script type="text/javascript">
      var couDetele=document.querySelectorAll('.couDetele');
  
   
 for(var i=0;i<couDetele.length;i++){
  couDetele[i].addEventListener("click", function(){
    var Id =this.getAttribute("Id");
    console.log(Id);
      if(window.confirm("确定要删除吗？")){
     window.location.href="coudelete?id="+Id;
    }
   });
 }
    //
    function go(page){
    window.location.href="course?pageNo="+page;
    } 
     //跳转指定页面 
    
   
    var toPa =document.querySelector('.toPa');
    toPa.addEventListener('click',function(){
    var inputPa =document.querySelector('.inputPa');
       console.log(toPa);
    if(inputPa.value<=${totalPage}){
    window.location.href="course?pageNo="+inputPa.value;
    }
    else
    alert("不能大于总页数");
    })
    
    
    </script>
  </body>
</html>
