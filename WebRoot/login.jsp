<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存后台登录</title>

<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
#tip{
width:100%;
color:red;
}

#radio{
				
	font-size: 20px;
		
}
#radio input{
	width: 30px;
    height: 30px;
    margin-top: 25px;
    padding: 0 15px;
    background: #2d2d2d; /* browsers that don't support rgba */
    background: rgba(45,45,45,.15);
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 0px solid #3d3d3d; /* browsers that don't support rgba */
    border: 0px solid rgba(255,255,255,.15);
    -moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,0) inset;
    -webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,0) inset;
    box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,0);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}
#qq{
		height: 550px;
		width: 500px;
		margin-top: -2.5%;
		margin-left: -4.5%;
		position: absolute;
		
}
</style>
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript">
   function validate(){
      var url = "B.action";
      var params = document.getElementById("userId").value;
      var myAjax = new Ajax.Request(url,{
           method:"post",
           parameters:"userId="+params,
           onComplete:processResponse,
           asynchoronous:true
      });
    }

    function processResponse(request){
     var obj = JSON.parse(request.responseText);
     $("tip").innerHTML= obj.tip;
    }
</script>
</head>
<body>

		<div class="page-container">
			<h1>登陆</h1>
			<form name="form" action="${pageContext.request.contextPath }/login.action" method="post">
			<div id="tip"></div>
				<input type="text" name="user.userId" id="userId" style="border: 0px;"value="" placeholder="账号" autofocus="autofocus" onblur="validate();"/>
				<input type="password" name="user.userPass" class="password" placeholder="密码">
				
				<button type="submit">登陆</button>
				<div id="radio">
					<input type="radio"  name="user.role" id="one" value="work" checked="checked"/>用户
					<input type="radio"  name="user.role" id="two" value="admin" />管理员
				</div>
				<div class="error"><span>+</span></div>
			</form>
			<a href="register.jsp"><button>注册</button></a>
			<div class="connect">
				<p>其他登陆方式:</p>
				<p>
					<a class="facebook" href=""></a>
					<div id="qq"><iframe  border="0" style="display:block;" width="100%" height="100%" frameborder="0" scrolling="no" src="qq.html"  ></iframe></div>
				</p>
			</div>
		</div>
		
	</body>
</html>