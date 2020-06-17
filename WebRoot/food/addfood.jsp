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
 	<link href="css/foolist.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/foodimg.css">
	
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
     #one{
        margin-top:5%;
     }
</style>
<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
  <script type="text/javascript" src="js/jquery.js" ></script>
  <script type="text/javascript" src="js/food.js" ></script>
  <script>
  	$(document).ready(function () {
  	    $("#FoodPicture").blur(checkUserId);
  	})
</script>
  </head>
  <body>

 <div id="one"  >
<div id="toptitle">
   
 </div>
 <form action="saveFood.action?FoodNumber=<s:property value="FoodNumber"/>" method="post" id="myform" enctype="multipart/form-data">
    <table class="table table-hover" id="table">
	<thead>
		<tr class="active" >
		<th colspan="4">修改信息</th>
		</tr>
	</thead>
	<tbody>

		<tr id="main">  
		      <td>图片</td>
		      <td><div id="img"><ul> <li class="list"><img src="<s:property value="FoodPicture"/>"></li></ul> </div></td>
		      <td><input type="file" name="file" id="FoodPicture"/></td>
		      <td>  <span id="checkPicture"></span></td>
		</tr>
		<tr id="main">  
		      <td>商品编号</td>		     
		      <td><input type="text" id="FoodNumber" name="food.FoodNumber" value="<s:property value="FoodNumber"/>"  /></td>
		      <td><span id="checkNumber"></span></td>
		      <td></td>
		</tr>
		<tr id="main">  
		      <td>商品名称</td>
		     
		      <td><input type="text" id="FoodName" name="food.FoodName" value="<s:property value="FoodName"/>"/></td>
		      <td><span id="checkName"></span></td>
		       <td></td>
		</tr>
		<tr id="main">  
		      <td>进价</td>
		      
		      <td><input type="text" id="FoodPurchasePrice" name="food.FoodPurchasePrice" value="<s:property value="FoodPurchasePrice"/>" /></td>
		      <td><span id="AcheckPrice"></span></td>
		      <td></td>
		</tr>
		<tr id="main">  
		      <td>售价</td>
		    
		      <td><input type="text" id="FoodSellingprice" name="food.FoodSellingprice" value="<s:property value="FoodSellingprice"/>" /></td>
		      <td><span id="checkPrice"></span></td>
		        <td></td>
		</tr>
		

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
