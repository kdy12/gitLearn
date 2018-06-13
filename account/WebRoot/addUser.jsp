<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
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
    function dosubmit() {  
        var th = document.form1;  
        if (th.name.value == "") {  
            alert("用户名不能为空");  
            th.name.focus();  
            return;  
        }  
  
        th.action="<%=path%>/AddUser"  
        th.submit();  
        window.close();
    }  
</script>  
  <body>
  <form action="" name="form1" method="post" >  
        <table  align="center"   border="0" style="margin:auto;margin-top:50px">  
        	<tr>
        		<td>姓名：</td>
        		<td><input type="text" id="name" name="name"  style=" height:30px;" /></td>
        	</tr>
        	<tr>
        		<td>密码：</td>
        		<td><input type="passWord" id="passWord" name="passWord"  style=" height:30px;" /></td>
        	</tr>
        	<tr>
        		<td>电话：</td>
        		<td><input type="text" id="tel" name="tel" style=" height:30px;" /></td>
        	</tr>
          	<tr> 
               <TD height=20 align="center" colspan = "2"><a  
                   href="javascript:dosubmit();">提交 </a>  <a  
                   href="javascript:window.close();">返回 </a>  
               </TD>  
          </tr>                        
        </table>  
    </form>  
  </body>
</html>
