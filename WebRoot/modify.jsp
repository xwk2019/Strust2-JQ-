<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% request.removeAttribute("tipMessage"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link href="css/modify.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="css/img.css">
  <link rel="stylesheet" href="css/bootstrap.min.css" />
	
  <style>
   body{
         background-color: #282828;
         background: linear-gradient(to bottom, black, #606060);
        
     }

	table{
      
      background-color:#ADADAD ;
     }
     a{
     text-decoration: none;
	 color:black;
     }
     th{
      font-size:20px;
      text-align: center;
     }
     td{
     font-size:18px;
     text-align: center;
     }
     span{
     color:red;
     }
</style>
<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
  <script type="text/javascript" src="js/jquery.js" ></script>
  <script type="text/javascript" src="js/food.js" ></script>
      <script>
  	$(document).ready(function () {
  	    $("#picture").blur(checkNull);
  	    $("#myform").submit(function(){
                	if(checkNull())
                	return true;
                	else{           
                	window.alert("图片不能为空");
                    return false;
                	}
                });		
  	    function checkNull(){
  	     var Picture = $("#picture").val();
  	     if( Picture==""){
			
			return false;		
		    }
		      return true;	
  	     }
  	})
</script>
  </head>
  <body>

 <div id="one"  >
<div id="toptitle">
   
 </div>
 <form action="saveUser.action?userId=<s:property value="userId"/>" method="post" enctype="multipart/form-data" id="myform">
    <table class="table table-hover" id="table">
	<thead>
		<tr class="active" >
		<th colspan="4">修改信息</th>
		</tr>
	</thead>
	<tbody>
	 <s:iterator value="userlist">
		<tr id="main">  
		      <td>图片</td>
		      <td> <div id="img"><ul> <li class="list"><img src="<s:property value="picture"/>"></li></ul> </div></td>
		      <td><input type="file" name="file" id="picture"/></td>
		      <td></td>
		</tr>
		<tr id="main">  
		      <td>账号</td>		     
		      <td><input type="text" id="userId" name="user.userId" value="<s:property value="userId"/>" /></td>
		      <td><span id="checkNumber"></span></td>
		      <td></td>
		</tr>
		<tr id="main">  
		      <td>密码</td>
		     
		      <td><input type="password" id="userPass" name="user.userPass" value="<s:property value="userPass"/>"/></td>
		      <td><span id="checkName"></span></td>
		       <td></td>
		</tr>
		<tr id="main">  
		      <td>邮箱</td>		      
		      <td><input type="text" id="userPass" name="user.email" value="<s:property value="email"/>"/></td>
		      <td><span id="AcheckPrice"></span></td>
		      <td></td>
		</tr>	
		</s:iterator>
	</tbody>
	<thead>
		<tr  class="active">
	    <th></th>
	     <th colspan="2" align="center">
			<input type="submit" value="提交" style="margin-top: 10px;"/>
						&nbsp;
			<input type="reset" value="重置" style="margin-top: 10px;"/>
						&nbsp;
			<input name="Input" type="button" value="返回"
							onClick="javascript:history.back();">
		</th>	   
	   <th></th>
		</tr>
		
	</thead>
</table>
</form>
</div>
    
  </body>
</html>
