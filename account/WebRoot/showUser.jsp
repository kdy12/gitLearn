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
	<link href="jquery-ui-timepicker-addon.css" >
    <script src="jquery-1.12.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="jquery-ui-timepicker-addon.js"></script>
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
  <%--   function dosubmit() {  
        var th = document.form1;  
        if (th.name.value == "") {  
            alert("用户名不能为空");  
            th.name.focus();  
            return;  
        }  
  
        th.action="<%=path%>/AddUser"  
        th.submit();  
        window.close();
    } --%>
    function del(){//批量删除jiangkun
    	var checkedTr='',docOperationButtonIds='';
    	checkedTr=$("input[name='indexed']:checked");
    	if(checkedTr.length==0){
    		alert("请选相应的记录!");return;
    	}
    	checkedTr.each(function(){
    	 	var temp=$(this).val();
    	 	docOperationButtonIds+=temp+",";
    	})
    	docOperationButtonIds=docOperationButtonIds.substring(0,(docOperationButtonIds.length-1));
    	do_del(docOperationButtonIds);
    }
    function do_del(docOperationButtonIds){//执行删除公共方法jiangkun
    	var costMan=$("#costMan").val();
    	var costMany=$("#costMany").val();
    	    $.ajax({
    			type:"post",
    			url:"<%=path%>/CostMany?userIds="+docOperationButtonIds+"&costMan="+costMan+"&costMany="+costMany,
    			data:"",
    			success:function(data){
    				if(data.rt == "1"){
    					alert(data.msg);
    					query_onclick();
    				}else{
    					alert(errorMsg);
    					return;
    				}
    			},
    			error:function(){
    			}
    		});
    	 window.close(); 
    }
    
</script>  


  <body style="overflow:auto">
  <form action="" name="form1" method="post" >  
        <table  align="center"   border="1" style="margin:auto;">  
        <caption>消费管理</caption>
        <tr>
        		<td align="center" >选择</td>
        		<td align="center" >消费人员</td>
        </tr>
         <c:forEach items="${list}" var="list">
        	<tr>
        		<td  align="center" ><input type="checkbox" id="indexed" name="indexed"   value="${list.USERID}" /></td>
        		<td>${list.NAME}</td>
        	</tr>
        </c:forEach>
       		<tr>
        		<td>付费人员：</td>
        		<td><select  id="costMan" name="costMan"  required="true" >
						  <option value="">--请选择--</option>
						   <c:forEach items="${list}" var="list">
							<option value="${list.USERID }">
								${list.NAME}
							</option>
						  </c:forEach>
					</select>
				</td>
        	</tr>
       		<tr>
        		<td>付费金额：</td>
        		<td><input type="text" id="costMany" name="costMany"  style=" height:30px;" value="" /></td>
        	</tr>
        	 <%--<tr>
        		<td  align="center" >消费日期：</td>
        		<td><div id="datetimepicker" class="input-append date">  
    <input type="text"></input>  
    <span class="add-on">  
        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>  
    </span>  
</div>  
  </td>
           </tr>
          	--%><tr> 
               <TD height=20 align="center" colspan = "2"><a  
                   href="javascript:del();" onclik="del()">提交 </a>  <a  
                   href="javascript:window.close();">返回 </a>  
               </TD>  
          </tr>                        
        </table>  
    </form>  
  </body>
</html>