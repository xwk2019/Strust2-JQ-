<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'center1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/material-cards.css">
<link rel="stylesheet" href="css/animate.min.css" />
<style type="text/css">
	html {
		position: relative;
		min-height: 100%;
	}
	body {
		background-color:#52D3AA;
		color: #37474F;
		font-family: 'Raleway', sans-serif;
		font-weight: 300;
		font-size: 16px;
	}
	h1, h2, h3 {
		font-weight: 200;
	}
	#topwenzi{
		color: black;
		font-size: 38px;
		font-family:楷体;
		text-align: center;
	}
	.fa fa-fw fa-facebook{
	    top:10px;
	    line-height: 44px;
	}
	fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid black}
	legend{padding:.5em;border:0;width:auto}
</style>
<script type="text/javascript" src="js/jquery.js" ></script>
<script src="js/jquery.material-cards.min.js"></script>
<script>
	$(function() {
		$('.material-card').materialCard({
			icon_close: 'fa-chevron-left',
			icon_open: 'fa-thumbs-o-up',
			icon_spin: 'fa-spin-fast',
			card_activator: 'click'
		});
//        $('.active-with-click .material-card').materialCard();
		window.setTimeout(function() {
			$('.material-card:eq(1)').materialCard('open');
		}, 2000);
		$('.material-card').on('shown.material-card show.material-card hide.material-card hidden.material-card', function (event) {
			console.log(event.type, event.namespace, $(this));
		});
	});

   
     $(document).ready(function () {
/*     	 $('#all').hide();
		 $('#show').mousemove(function(){
		 	$('#all').show();
     	$('#all').addClass('animated fadeInLeft'); 
            })*/
	})
</script>
  </head>
  
  <body>
   <fieldset id="show">
    <legend id="topwenzi">合作伙伴</legend>
   <div id="all">
<div class="htmleaf-container">
<br>
	<section class="container">
		<div class="row active-with-click">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Red">
					<h2>
						<span>阿里巴巴集团</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							世界500强
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg.jpg"><!-- 图片-->
						</div>
						<div class="mc-description">
							阿里系的电子商务服务、蚂蚁金融服务、菜鸟物流服务、大数据云计算服务、广告服务、跨境贸易服务、前六个电子商务服务以外的互联网服务。
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Pink">
					<h2>
						<span>深圳市腾讯计算机系统有限公司</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							世界品牌500强
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg1.jpg">
						</div>
						<div class="mc-description">
							整合腾讯云、互联网+、智慧零售、教育、医疗、安全和LBS等行业解决方案。
							将对原社交网络事业群（SNG）、原移动互联网事业群（MIG）、原网络媒体事业群（OMG）中，与社交平台、流量平台、数字内容、核心技术等高度关联且具有高融合性的板块，进行拆分和重组。
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Purple">
					<h2>
						<span>网易公司</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							中国互联网企业100强
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg2.jpg">
						</div>
						<div class="mc-description">
							网易网站为互联网用户提供了以内容、社区和电子商务服务为核心的中文在线服务。
							网易内容频道为网民提供新闻，信息和在线娱乐服务。网易同国内外上百家网上内容供应商建立了合作关系，提供全面而精彩的网上内容，推出了多个各具特色、涵盖万千的网上内容频道。
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
		<!--</div>-->
		<!--<div class="row active-with-hover">-->
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Deep-Purple">
					<h2>
						<span>北京京东世纪贸易有限公司</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							世界五百强
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg3.jpg">
						</div>
						<div class="mc-description">
							在线销售：计算机、手机及其它数码产品、家电、汽车配件、服装与鞋类、奢侈品、家居与家庭用品、化妆品与其它个人护理用品、食品与营养品、书籍与其它媒体产品、母婴用品与玩具、体育与健身器材以及虚拟商品等，共13大类3150万种SKU的商品。
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Indigo">
					<h2>
						<span>北京小米科技有限责任公司</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							中国出海品牌 50 强
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg4.jpg">
						</div>
						<div class="mc-description">
							技术开发；货物进出口、技术进出口、代理进出口；销售通讯设备、厨房用品、卫生用品（含个人护理用品）、日用杂货、化妆品、医疗器械I类、II类、避孕器具、玩具、体育用品、文化用品、服装鞋帽、钟表眼镜、针纺织品、家用电器... 
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-12">
				<article class="material-card Blue">
					<h2>
						<span>中兴通讯股份有限公司</span>
						<strong>
							<i class="fa fa-fw fa-star"></i>
							发明专利授权量1028件
						</strong>
					</h2>
					<div class="mc-content">
						<div class="img-container">
							<img class="img-responsive" src="img/timg5.jpg">
						</div>
						<div class="mc-description">
							生产程控交换系统、多媒体通讯系统、通讯传输系统；研制、生产移动通信系统设备、卫星通讯、微波通讯设备、寻呼机，计算机软硬件、闭路电视、微波通信、信号自动控制、计算机信息处理、过程监控系统、防灾报警系统等项目的技... 
						</div>
					</div>
					<a class="mc-btn-action">
						<i class="fa fa-bars"></i>
					</a>
					<div class="mc-footer">
						<h4>
							联系方式
						</h4>
						<a class="fa fa-fw fa-facebook"></a>
						<a class="fa fa-fw fa-twitter"></a>
						<a class="fa fa-fw fa-linkedin"></a>
						<a class="fa fa-fw fa-google-plus"></a>
					</div>
				</article>
			</div>
		</div>
	</section>
</div>

</fieldset>
</body>
</html>
