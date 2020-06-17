<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'righmain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/lunbo.css">
<script type="text/javascript" src="js/jquery.js" ></script>
  <style>
  body{
  background-color:   ;
  }
    #slides {
      display: none
    }
    #slides .slidesjs-navigation {
      margin-top:5px;
    }

    a.slidesjs-next,
    a.slidesjs-previous,
    a.slidesjs-play,
    a.slidesjs-stop {
      background-image: url(img/btns-next-prev.png);
      background-repeat: no-repeat;
      display:block;
      width:12px;
      height:18px;
      overflow: hidden;
      text-indent: -9999px;
      float: left;
      margin-right:5px;
    }

    a.slidesjs-next {
      margin-right:10px;
      background-position: -12px 0;
    }

    a:hover.slidesjs-next {
      background-position: -12px -18px;
    }

    a.slidesjs-previous {
      background-position: 0 0;
    }

    a:hover.slidesjs-previous {
      background-position: 0 -18px;
    }

    a.slidesjs-play {
      width:15px;
      background-position: -25px 0;
    }

    a:hover.slidesjs-play {
      background-position: -25px -18px;
    }

    a.slidesjs-stop {
      width:18px;
      background-position: -41px 0;
    }

    a:hover.slidesjs-stop {
      background-position: -41px -18px;
    }

    .slidesjs-pagination {
      margin: 7px 0 0;
      float: right;
      list-style: none;
    }

    .slidesjs-pagination li {
      float: left;
      margin: 0 1px;
    }

    .slidesjs-pagination li a {
      display: block;
      width: 13px;
      height: 0;
      padding-top: 13px;
      background-image: url(img/pagination.png);
      background-position: 0 0;
      float: left;
      overflow: hidden;
    }

    .slidesjs-pagination li a.active,
    .slidesjs-pagination li a:hover.active {
      background-position: 0 -13px
    }

    .slidesjs-pagination li a:hover {
      background-position: 0 -26px
    }

    #slides a:link,
    #slides a:visited {
      color: #333
    }

    #slides a:hover,
    #slides a:active {
      color: #9e2020
    }

    .navbar {
      overflow: hidden
    }
  </style>
  <!-- End SlidesJS Optional-->

  <!-- SlidesJS Required: These styles are required if you'd like a responsive slideshow -->
  <style>
    #slides {
      display: none
    }
   

    .container {
    	padding-top: 5%;
    	
      margin: 0 auto
    }

    /* For tablets & smart phones */
    @media (max-width: 767px) {
      body {
        padding-left: 20px;
        padding-right: 20px;
      }
      .container {
        width: auto
      }
    }

    /* For smartphones */
    @media (max-width: 480px) {
      .container {
        width: auto
      }
    }

    /* For smaller displays like laptops */
    @media (min-width: 768px) and (max-width: 979px) {
      .container {
        width: 724px
      }
    }

    /* For larger displays */
    @media (min-width: 1200px) {
      .container {
        width: 1170px
      }
    }
    
     #toptop{
    	padding-left: 5%;
    }
    #topwenzi{
      font-family:楷体;
    	font-size: 28px;
    }
  </style>
  </head>
  
<body>
	<!--顶部-->
	<div id="toptop">
	 <fieldset style="width: 920px; border-color: #000000; padding-left: 10px">
	 	
     <legend id="topwenzi">公司简介</legend>
   &nbsp; &nbsp; &nbsp; &nbsp;南储仓储管理有限公司系广东广晟有色金属集团有限公司等八家股东组成的股份有限公司，是一家集仓储、运输、期货交割、仓储融资、保税仓等为一体的综合性仓储管理公司。公司成立于1998年4月，注册资金为6000万元，现有员工近两千人，是上海期货交易所和大连商品交易所指定交割仓库，已成为华南地区具竞争力的仓储管理公司。
南储公司以仓储业务为核心，在此基础上开展了一系列的衍生服务，服务品种包括期货交割、仓储管理输出、保税服务、仓储融资、港口接运、货物配送、国际货运代理、代理报关、信息服务等。南储公司通过全体员工的十载奋斗，创下了“服务好、管理严、信息快、品种多、勇于创新”的优秀品牌，在业内外享有极佳的口碑，成为了华南地区的有色金属物流中心、交易中心、信息中心，及国内仓储融资业的龙头企业，为银企合作提供了广阔的舞台。随着仓储业务的快速发展，年吞吐量将达到250万吨以上，在同行业中名列前茅。仓储融资业务截至2008年底，合作的国内外银行共19家，合作企业共380余家，监管的质押物价值达到250亿元。展望未来，南储公司正朝着现代化、信息化、多功能一体化的一流仓储管理公司迈进！
公司为员工提供有竞争力的薪酬和良好的福利待遇（五险一金、培训和旅游的机会等），并为员工提供科学的职业生涯规划和广阔的晋升空间。
     
   </fieldset>
   </div>
  <div class="container">
    <div id="slides">
      <img src="img/lunbo/timg.jpg" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
      <img src="img/lunbo/timg1.jpg" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
      <img src="img/lunbo/timg2.jpg" alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
      <img src="img/lunbo/timg3.jpg" alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
      <img src="img/lunbo/timg.jpg" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
      
    </div>
  </div>
  <script src="js/jquery.js"></script>
  <script src="js/jquery.lunbo.min.js"></script>
  <script>
    $(function() {
      $('#slides').slidesjs({
        width: 640,			//宽度
        height: 220,		//高度
        play: {				// 播放属性
          active: true,		//播放按钮	是否有效
          auto: true,		//是否自动播放
          interval: 4000,  // 自动播放的时间间隔为4s
          swap: true		//是否循环播放
        }
      });
    });
    
var msg="${requestScope.tipMessage}";
if(msg!=""){
alert(msg);
}
  </script>
</body>
</html>
