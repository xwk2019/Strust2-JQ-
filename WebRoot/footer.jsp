<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'footer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/footer.css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script src="js/script.js"></script>
		<style>
			body{
				padding:0px;
				margin:0px;
				background-color: #009FD9;
				}
            
		</style>
  </head>
  
	 <body>
		
		<!-- footer -->
		<div class="wave-box">
			<div class="marquee-box marquee-up" id="marquee-box">
				<div class="marquee">
					<div class="wave-list-box" id="wave-list-box1">
						<ul>
							<li>
								<img height="60" alt="波浪" src="images/wave_02.png">
							</li>
						</ul>
					</div>
					<div class="wave-list-box" id="wave-list-box2">
						<ul>
							<li>
								<img height="60" alt="波浪" src="images/wave_02.png">
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="marquee-box" id="marquee-box3">
				<div class="marquee">
					<div class="wave-list-box" id="wave-list-box4">
						<ul>
							<li>
								<img height="60" alt="波浪" src="images/wave_01.png">
							</li>
						</ul>
					</div>
					<div class="wave-list-box" id="wave-list-box5">
						<ul>
							<li>
								<img height="60" alt="波浪" src="images/wave_01.png">
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="auto clearfix">
				<!-- footer主要-->
				<div class="footer-floor1">
					<div class="footer-list">
						<ul>
							<li class="flist-title">
								产品与服务
							</li>
							<li>
								<a href="#">
									<strong>
										云虚拟主机
									</strong>
								</a>
							</li>
							<li>
								<a href="#">
									<strong>
										公司管家
									</strong>
								</a>
							</li>
							<li>
								<a href="#">
									<strong>
										公司监控
									</strong>
								</a>
							</li>
						</ul>
						<ul>
							<li class="flist-title">
								云解决方案
							</li>
							<li>
								<a href="#">
									电商解决方案
								</a>
							</li>
							<li>
								<a href="#">
									移动解决方案
								</a>
							</li>
							<li>
								<a href="#">
									网站解决方案
								</a>
							</li>
						</ul>
						<ul>
							<li class="flist-title">
								技术与支持
							</li>

							<!--<li><a href="http://icp.niaoyun.com/">备案中心</a></li>-->
							<li>
								<a href="#">
									意见反馈
								</a>
							</li>
							<li>
								<a href="">
									会员服务
								</a>
							</li>
							<li>
								<a href="#">
									帮助中心
								</a>
							</li>
						</ul>
						<ul class="flist-4">
							<li class="flist-title">
								关于公司
							</li>
							<li>
								<a href="#">
									公司简介
								</a>
							</li>
							<li>
								<a href="#">
									服务协议
								</a>
							</li>
							<li>
								<a href="#">
									友情链接
								</a>
							</li>
						</ul>
						<div class="clear-float">
						</div>
					</div>
					<div class="footer-right">
						<div class="telephone" title="服务热线">
							<span>
							</span>
							<div class="tel-number">
								400-688-3065
							</div>
						</div>
						<div class="official-plat">
							<p class="weixin" style="background-image: ">
								<span id="wx-corner">
								</span>
							</p>
							<p class="weibo" style="background-image: ">
								<span id="wb-corner">
								</span>
							</p>
							<ul>
								<li>
									<a href="#a_null">
										<span class="weixin-logo">
										</span>
										公司官方微信
									</a>
								</li>
								<li title="点击打开官方微博">
									<a href="#" target="_blank">
										<span class="weibo-logo">
										</span>
										公司官方微博
									</a>
								</li>
								<li title="点击打开官方客服">
									<a href="#">
										<span class="qq-logo">
										</span>
										公司官方客服
									</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="clear-float">
					</div>
				</div>
			</div>
			<div class="footer-floor2">
				<p>
					网站信息·1997-2018 版权所有
				</p>
				<p>
					 Copyright(C)web.com, All Rights Reserved.
				</p>
			</div>
		</div>
		<!-- footer end -->
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
			<p>
			</p>
			<p>
			</p>
		</div>
	</body>
</html>
