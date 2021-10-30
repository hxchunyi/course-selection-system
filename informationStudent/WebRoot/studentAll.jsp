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
    
    <title>My JSP 'studentAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="static/css/index.css">
  </head>
  <style>
  .tablelist tbody tr:hover td:nth-child(-n+6) {
    background-color: #4180ec;
}
from{
display: inline-block;
}
.stuDetele{
color: red
}
  </style>
  <body>
     <div class="condition">
     <form action="student" method="get">
       学号：<input type="text" name="seaId">
        姓名： <input type="text" name="seaName">
        政治面貌：<input type="text" name="seaNat">
        <input class="search" type="submit" value="搜索"></input>
         
     </form>
     <button class="add" onclick="window.location.href='stuAdd.jsp'">新增</button>
       
    </div>
    <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>民族</td>
                    <td>政治面貌</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${LisL}" var="stuAll">
         
                <tr>
                    <td>${stuAll.id}</td>
                    <td>${stuAll.name}</td>
                    <td>${stuAll.sex}</td>
                    <td>${stuAll.birthday}</td>
                    <td>${stuAll.nat}</td>
                     <td>${stuAll.pss}</td>
                    <td><span class="edit"><a href="xiugai?id=${stuAll.id}&&avatar=${stuAll.avatar}">修改</a></span></td>
                    <td><span class="detele"><a href="javascript:;" class="stuDetele" Id="${stuAll.id}">删除</a></span></td>
                </tr>
             </c:forEach>
            </tbody>
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
    //确定删除
     var stuDetele=document.querySelectorAll('.stuDetele');
 for(var i=0;i<stuDetele.length;i++){
  stuDetele[i].addEventListener("click", function(){
    var Id =this.getAttribute("Id");
    console.log(Id);
      if(window.confirm("确定要删除吗？")){
     window.location.href="shanchu?id="+Id;
    }
   });
 }
    
    //翻页
 function go(page){
    window.location.href="student?pageNo="+page;
    } 
     //跳转指定页面 
    
   
    var toPa =document.querySelector('.toPa');
    toPa.addEventListener('click',function(){
    var inputPa =document.querySelector('.inputPa');
       console.log(toPa);
    if(inputPa.value<=${totalPage}){
    window.location.href="student?pageNo="+inputPa.value;
    }
    else
    alert("不能大于总页数");
    })
   
  
    
    
    
    
   
    </script>
  </body>
</html>
