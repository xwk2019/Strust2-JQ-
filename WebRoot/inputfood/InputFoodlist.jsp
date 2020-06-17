<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <sx:head/>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
	<link rel="stylesheet" href="css/img.css">
    <style type="text/css">
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
     font-size:14px;
     text-align: center;
     }
     #delete{
        float:right;
       margin-top:-32%
     }
     #modify{
      float:left;
     }
#one{
margin-top:10%
}
    </style>
	
     <script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	
<script type="text/javascript">
var msg="${requestScope.tipMessage}";
if(msg!=""){
alert(msg);
}

</script>
  </head>
  
  <body>

  <div id="one"  >
<div id="toptitle">
    <s:form action="searchInputFood.action" method="post"> 
    <s:select list="{'商品编号','商品名称'}" headerKey="-1"        
    headerValue="选择分类" name="search.searchType" theme="simple" /> &nbsp;&nbsp;
    <s:textfield style="width:150px" name="search.inputSearchInfo" value="" theme="simple"/> &nbsp;&nbsp;
    <s:submit value="搜索" theme="simple"/> 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button><a href="addinputFood.action" target="mainFrame">增加</a></button>
    </s:form>
 </div>
 
    <table class="table table-hover" id="table">
	<thead>
		<tr class="active" >
		 <th>入库单号</th>
        <th>商品编号</th>          
        <th>商品名称</th>
        <th>进货价 </th>
        <th>入库数量</th>
        <th>成本</th>          
        <th>供货商</th>
        <th>总量 </th>
        <th>入库时间 </th>   
        <th>操作 </th>
		</tr>
	</thead>
	<tbody>
	  <s:iterator value="userlist">
		<tr id="main">  
	    <td><s:property value="FoodEntryNum"></s:property></td>
        <td><s:property value="FoodNumber"></s:property></td>          
        <td><s:property value="FoodName"></s:property></td>
        <td><s:property value="FoodPurchasePrice"></s:property></td>
        <td><s:property value="InNumber"></s:property></td>
        <td><s:property value="Cost"></s:property></td>          
        <td><s:property value="Supplier"></s:property></td>
        <td><s:property value="AllTotal"></s:property></td>
        <td><s:property value="InDate"></s:property></td>  
        <td><a id="modify" href="modifyInputFood.action?FoodNumber=<s:property value="FoodNumber"/>" target="mainFrame">修改</a>&nbsp;<a id="delete" href="deleteInputFood.action?FoodNumber=<s:property value="FoodNumber"/>" onClick="return confirm('是否删除指定记录?');">删除</a></td> 
    </tr>
		</s:iterator>
	</tbody>
	<thead>
		<tr  class="active">
	<th></th>
	
			   <th colspan="8">
					 共<s:property value="#session.page.rowTotalNum"/>记录        
                                                        共<s:property value="#session.page.pageTotalNum"/>页       
                                                        第<s:property value="#session.page.currentPage"/>页  
                 <a href="searchInputFood.action?pageNo=1&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">首页</a>
                 <s:if test="#session.page.currentPage==1">
                 <a href="searchInputFood.action?pageNo=<s:property value="#session.page.currentPage-1"/>&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">最前一页</a>
                 </s:if>
                 <s:else>
                 <a href="searchInputFood.action?pageNo=<s:property value="#session.page.currentPage-1"/>&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">上一页</a>
                 </s:else>
                 <s:if test="#session.page.currentPage==#session.page.pageTotalNum">
                 <a href="searchInputFood.action?pageNo=<s:property value="#session.page.pageTotalNum"/>&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">最后一页</a>
                 </s:if>
                 <s:else>
                 <a href="searchInputFood.action?pageNo=<s:property value="#session.page.currentPage+1"/>&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">下一页</a>
                 </s:else>
                 <a href="searchInputFood.action?pageNo=<s:property value="#session.page.pageTotalNum"/>&&search.searchType=<s:property value="#session.searchType"/>&&search.inputSearchInfo=<s:property value="#session.inputSearchInfo"/>">末页</a>
				</th>
	   <th></th>

		</tr>
	</thead>
</table>
</div>
    


 
  </body>
</html>
