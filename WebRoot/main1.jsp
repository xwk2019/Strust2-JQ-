<%@page import="org.apache.struts2.dispatcher.SessionMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>库存管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="css/top-awesome.min.css" media="screen">
	<link rel="stylesheet" href="css/top.css" media="screen">
	<link rel="stylesheet" href="css/img.css">
	<link rel="stylesheet" href="css/top.menu.css" media="screen">
                <link rel="stylesheet" href="css/animate.min.css" />
		<style>
			body{
				padding:0px;
				margin:0px;	
				background-color: /* #DD6920 */;
				}
		    .iframe{
		       margin-top: 4.3%;
               width: 111%;
               height: 50.5%;
               transform: scale(1.95);
               transform-origin: 0 0;
            }
            .iframefooter{

            }
			#banner{
				height: 40px;
				width: 100%;
				margin: 0 auto;
				
			}
			#left{
				height: 687.5px;
				width: 27.5%;
				
				background-color: #DD6920;
				float: left;
				position: absolute;
			}
			#menu{
				margin-left: 36%;
			}
			#right{		
				height: 687.5px;
				width: 72.5%;
				
			
				float: right;
				position: relative;	
			}
			#center1{
			
				height: 1000px;
				width: 100%;
				margin: 0 auto;
                margin-top:687.5px; 
                position: absolute;
			}
			#buttom{	
			
		        height: 400px;
				width: 100%;
				margin: 0 auto; 
				margin-top:1687.5px; 
				position: absolute;			    
			}
		     a{
		     text-transform: none;
		     }
		</style>
			<link rel="stylesheet" href="css/secondmenu.css"> <!--初始化文件-->
    <link rel="stylesheet" href="css/menu.css"> <!--主样式-->
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script src="js/adapter.js"></script> <!--rem适配js-->
	<script src="js/menu.js"></script>
	<script type="text/javascript" src="js/test.js"></script>
	<script src="js/jquery.top.menu.1.0.min.js"></script>
	<script src="js/jquery.top.menu.1.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/respond.min.js"></script>	
	<script type="text/javascript">
 $(function(){
	 $(".coupletbox").clonefn({
		    cloneto:true,//是否允许克隆
			initial:"top",//初始位置top或down
			closeBtn:".closeBtn",//关闭按钮
			speed:2000,//动画速度
			easing:"easeInOutBack",//扩展动画，是基于jQuery Easing v1.3官方下载地址http://gsgd.co.uk/sandbox/jquery/easing/
			zIndex:10000000000000 //层

		 });

	});
    $(document).ready(function() {
				$('#zlight-nav').zlightMenu();
	});
	
			$(document).ready(function () {
			        $('#center1').hide();
                    $('#buttom').hide();                                                   
                    $(document).scroll(function(){
                      var height = $(document).scrollTop();
                      
                       if(height>10){
                    	 $('#center1').show(); 
                    	 $('#center1').addClass('animated fadeInLeft'); 
                         }
                       
                      if(height>1000){
                    	 $('#buttom').show();
                    	 $('#buttom').addClass('animated fadeInUp');      
                         }
                     })                  
			})
			

</script>
		
	
	</head>
    <body>
       
		<div id="banner">
			<div class="container" id="main">
			<div class="row">
				<div class="col-lg-12">
					<nav id="zlight-nav">
						<ul id="zlight-main-nav">
							<li class="zlight-active">
							<a>菜单</a>
							</li>
							<li class="zlight-dropdown">
							<a>主页 <i class="icon-angle-down"></i></a>
							</li>
							<li>
							<a href="login.jsp">登陆</a>
							</li>
							<li class="zlight-dropdown">
							<a href="register.jsp">注册 <i class="icon-angle-down"></i></a>
							</li>
							<li>
							<a href="destroy.jsp">注销</a>

							</li>
							<li class="zlight-dropdown">
							<a>关于 <i class="icon-angle-down"></i></a>
						    <ul class="zlight-submenu">
							<li>
							<a>合作伙伴</a>
							</li>
							<li>
							<a>加盟</a>
							</li>
							<li>
							<a>友情连接</a>
							</li>
						</ul>
							</li>
							<li>
							<s:iterator value="userlist">
							<a>当前用户:<s:property value="userId"/>&nbsp;					                                                            
							</a>  
							 
							</s:iterator>
							</li>
							<li>
							<s:iterator value="userlist">
						 <div id="img"><ul> <li class="list"><img src="<s:property value="picture"/>"></li></ul> </div>
                             </s:iterator>
							</li>
						</ul>
					</nav>
					<!-- nav close -->

				</div>
			</div>
		</div>
		<!-- main close -->
		</div>
		<!-- container close -->
		</div>

	    <div id="left">
	    	<div id="menu">
			<!--显示菜单-->
			<div id="open">
			 <s:iterator value="userlist" var="o">
				<div class="navH">
					南储仓储管理
					<span><img class="obscure" src="images/obscure.png" alt=""></span>
				</div>
				<div class="navBox">
					<ul>
						<li>
							<h2 class="obtain">公司信息<i></i></h2>
							<div class="secondary">
								<a href="righmain.jsp" target="mainFrame"><h3>公司简介</h3></a>
								<h3>公司业务</h3>
								<h3>招聘职位</h3>															
							</div>
						</li>
						<li>
							<h2 class="obtain">企业文化<i></i></h2>
							<div class="secondary">
								<h3>特色文化</h3>
								

							</div>
						</li>
						<li>
							<h2 class="obtain">业务介绍<i></i></h2>
							<div class="secondary">
								<a href="righmain1.jsp" target="mainFrame"><h3>冷链物流</h3></a>
								
                                
					             <s:if test='#o.role=="admin"'>
					             <a href="searchFood.action?pageNo=1&&search.searchType=商品编号&&search.inputSearchInfo=" target="mainFrame"><h3>食品仓库信息</h3></a>					            
								<a href="searchInputFood.action?pageNo=1&&search.searchType=商品编号&&search.inputSearchInfo=" target="mainFrame"><h3>入库管理</h3></a>											
								<a href="searchOutputFood.action?pageNo=1&&search.searchType=商品编号&&search.inputSearchInfo=" target="mainFrame"><h3>出库管理</h3></a>
							
					             </s:if>
					          
					
							</div>
						</li>
						<li>
							<h2 class="obtain">人力资源<i></i></h2>
							<div class="secondary">
								<h3>在职人员</h3>

							</div>
						</li>
						<li>
							<h2 class="obtain">个人信息<i></i></h2>
							<div class="secondary">
								<s:iterator value="userlist"><a href="usermodify.action?userId=<s:property value="userId"/>" target="mainFrame"><h3>修改个人信息</h3></a></s:iterator>
								<s:if test='#o.role=="admin"'>
							 <a href="search.action?pageNo=1&&search.searchType=账号&&search.inputSearchInfo=" target="mainFrame"><h3>管理员操作</h3></a>
							 </s:if>
							</div>
							 
						</li>
					</ul>
				</div>
				   </s:iterator>
			</div>
			  
		</div>
        	
		
	    </div>
		<div id="right" >
			<iframe name="mainFrame" id="mainFrame"  border="0" style="display:block;" width="100%" height="100%" frameborder="0" scrolling="no" src="righmain.jsp" ></iframe>
		</div>
		
		<div id="center1">
			<iframe  border="0" style="display:block;" width="100%" height="100%" frameborder="0" scrolling="no" src="center1.html" ></iframe>
		</div>
		
		<div id="buttom">
			<iframe  border="0" style="display:block;" width="100%" height="100%" frameborder="0" scrolling="no" src="footer.jsp" ></iframe>
		</div>
<!-- 广告	-->	
  <div class="coupletbox" style="width:10%; height:400px; background:#f00;">
   <img src="img/gz.jpg" />
  <a href="#" class="closeBtn" title="关闭" style="color: black;">&times;关闭</a>
 </div>
<!-- 广告	-->	
	</body>
</html>
