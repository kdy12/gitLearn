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
    
    <title>账单</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="jquery-1.12.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  	function addUser(){
  		window.open ('<%=basePath%>/addUser.jsp', '添加用户', 
  				'height=400, width=600, top=200, left=400,')
  		
  	}
  	function costMany(){
  		window.open ('<%=basePath%>/ShowUser', '今日消费', 
  				'height=700, width=600, top=200, left=400,')
  		
  	}
  function findAll() {
  		window.location.href="<%=path%>/FindAll"
  	}
  </script>
  <body style="margin-top:50px;margin-left:250px;margin-right:250px;">
  <div class="btn-group" >
  <button type="button" class="btn btn-default" onclick="addUser()">添加用户</button>
  <button type="button" class="btn btn-default" onclick="costMany()">消费管理</button>
  <button type="button" class="btn btn-default" onclick="findAll()">查询账单</button>

</div>
    <table class="table table-striped">
   <caption><span style="color:red;font-size:25px;">账单明细</span></caption>
   <thead>
      <tr>
         <th>姓名</th>
         <th>最后消费时间</th>
         <th>上次余额</th>
         <th>余额</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach items="${list}" var="list">
      <INPUT value="${list.USERID}" type="hidden"/>
      <tr>
         <td>${list.NAME}</td>
         <td>${list.COSTTIME}</td>
         <td>${list.LASTBALANCE}</td>
         <td>${list.BALANCE}</td>
         <td><a href="<%=path%>/showAccount?userId=${list.USERID}" target="_blank">明细</a></td>
      </tr>
     </c:forEach>
   
   </tbody>
</table>
  </body>
</html>
