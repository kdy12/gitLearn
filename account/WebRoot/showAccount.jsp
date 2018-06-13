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
    
    <title>个人账单</title>
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
  
<body style="overflow:auto">
    <table class="table table-striped">
   <caption><span style="color:red;font-size:25px;">个人账单</span></caption>
   
   <thead>
      <tr>
         <th>序号</th>
         <th>姓名</th>
         <th>消费时间</th>
         <th>消费金额</th>
         <th>充值金额</th>
         <th>上次余额</th>
         <th>余额</th>
      </tr>
   </thead>
   <tbody>
   <%int i = 0;%>
   <c:forEach items="${list}" var="list">
      <INPUT value="${list.USERID}" type="hidden"/>
      <tr>
         <td><%=++i%></td>
         <td>${list.NAME}</td>
         <td>${list.COSTTIME}</td>
         <td>${list.COSTMONEY}</td>
         <td>${list.SAVEMONEY}</td>
         <td>${list.LASTBALANCE}</td>
         <td>${list.BALANCE}</td>
       
      </tr>
     </c:forEach>
   
   </tbody>
</table>
  </body>
</html>
