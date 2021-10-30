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
  .tablelist tbody tr:hover td:nth-child(-n+5) {
    background-color: #4180ec;
}
  </style>
  </head>
  <div class="condition">
     <form action="acount" method="get">
       用户名：<input type="text" name="seaUsername">
        身份： <input type="text" name="seaAdmin">
        手机号：<input type="text" name="seaTel">
        <input class="search" type="submit" value="搜索" style="right:400px"></input>
     </form>
     <button class="add" onclick="window.location.href='acountAdd.jsp'" style="right:316px">新增</button>
  
    <div class="tablelist">
        <table>
            <thead>
                <tr>
                    <td>序号</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>身份</td>
                    <td>手机号</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="acount" items="${LisL}">
		<tr>
		              <td class="acountId" >${acount.id}</td>
		              <td>${acount.username}</td>
		              <td>${acount.password }</td>
		              <td>${acount.admin}</td>
		              <td>${acount.tel }</td>
                      <td><span class="edit"><a href="acountEdit?id=${acount.id}">修改</a></span></td>
                      <td><span ><a href="javascript:;" class="acountDetele detele" Id="${acount.id}">删除</a></span></td>
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
    var acountDetele=document.querySelectorAll('.acountDetele');
  
   
 for(var i=0;i<acountDetele.length;i++){
  acountDetele[i].addEventListener("click", function(){
    var Id =this.getAttribute("Id");
    console.log(Id);
      if(window.confirm("确定要删除吗？")){
     window.location.href="acountDetele?id="+Id;
    }
   });
 }
    
   //
    function go(page){
    window.location.href="acount?pageNo="+page;
    } 
     //跳转指定页面 
    
   
    var toPa =document.querySelector('.toPa');
    toPa.addEventListener('click',function(){
    var inputPa =document.querySelector('.inputPa');
       console.log(toPa);
    if(inputPa.value<=${totalPage}){
    window.location.href="acount?pageNo="+inputPa.value;
    }
    else
    alert("不能大于总页数");
    })
    
    
    </script>
  </body>
</html>
