<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerRight.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
         <link rel="stylesheet" href="css/register.css" />
          <style>
        #tip{
            color:red;
          
            padding-top:8%;
         
        }
        </style>
		 <script type="text/javascript" src="js/jquery.js" ></script>	
		<script id="jquery_183" type="text/javascript" class="library" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/register.js"></script>
		<script type="text/javascript" src="js/json2.js"></script>
		<script type="text/javascript" src="js/prototype.js"></script>
		  <script type="text/javascript">
   function validate(){
      var url = "A.action";
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
	
		<div id="top">
			<h1>用户注册</h1></div>

		<div class="form-bak">

			<form method="post" action="register.action" onsubmit="adaptValue();">

				<div class="left">

					<div class="line" id="line_account">

						<div class="info">

							<strong>邮箱</strong>

							<span class="tips">邮箱</span>

						</div>

						<div class="input">

							<input type="text" name="user.email" id="account" onblur="v_account();" onkeyup="v_account();" />

							<div class="none">

								<span></span>

							</div>

						</div>

					</div>

					<div class="line" id="line_name">

						<div class="info">

							<strong>用户名</strong>

							<span class="tips">只能由数字、文字或下划线组成<br />最多32个字符</span>

						</div>

						<div class="input">
<!-- <input type="text" name="name" id="name" onblur="v_name();" onblur="validate();" onkeyup="v_name();" /> -->
							<input type="text" name="user.userId" id="userId" onblur="validate();" onblur="v_name();"  onkeyup="v_name();"  />
							<div id="tip"></div>

							<div class="none">

								<span></span>

							</div>

						</div>

					</div>

					<div class="line" id="line_password">

						<div class="info">

							<strong>密码</strong>

							<span class="tips">6至16个字符</span>

						</div>

						<div class="input">

							<input type="password" name="password" id="password" onblur="v_password();" onkeyup="v_password();" />

							<div class="none">

								<span></span>

							</div>

						</div>

					</div>

					<div class="line" id="line_repeat">

						<div class="info">

							<strong>确认密码</strong>

							<span class="tips">再次输入密码</span>

						</div>

						<div class="input">

							<input type="password" name="user.userPass" id="repeat" onblur="v_repeat();" onkeyup="v_repeat();" />

							<div class="none">

								<span></span>

							</div>

						</div>

					</div>

				</div>

				<div class="right">

					<input type="submit" id="submit" value="完成注册" disabled="disabled" />

					<div class="readagreement-wrap" onclick="onReadAgreementClick();">

						<input type="checkbox" name="agree" id="agree" onchange="v_submitbutton();" /> 同意《

						<a id="readagreement" href="#agreement" onclick="showAgreement();" title="查看用户使用协议">用户使用协议</a>》

					</div>

					<div>已经拥有账号，
						<a href="registerRight.jsp" onClick="window.open('login.jsp');">直接登录</a>
					</div>

					<div>默认身份
					<input type="radio"name="user.role" id="one" value="work" checked="checked"/>用户
					</div>

				</div>

			</form>

		</div>

		<div id="agreement" class="agreement" style="display:none;">

			<h1>用户使用协议</h1>

			<iframe src=""></iframe>

			<input type="button" value="同意" onclick="agree();" />

			<a href="#" class="backtotop">返回顶部</a>

		</div>

	</body>

</html>
