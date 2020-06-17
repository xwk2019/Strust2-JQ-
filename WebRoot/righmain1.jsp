<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'righmain1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" href="css/lunbo.css">
  <style>
    #toptop{
    	padding-left: 5%;
    }
    #topwenzi{
      font-family:楷体;
    	font-size: 28px;
    }
    img{ 
    	  opacity: 0.5;
    	    padding-left:6%;
			width: 940px;
			height: 340px;		
			}
	#wenzi{
	  padding-top: 2.5%;
	   text-align: center;
	   font-size:36px;
	}
  </style>
  <script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript">
	$(document).ready(function(){
			 var index=0;	 
		     var imgArr=new Array("img/leng/leng1.png","img/leng/leng2.jpg","img/leng/leng3.jpg","img/leng/leng4.jpg","img/leng/leng5.jpg");
		     function next(){		     
                index++;
                if(index==imgArr.length)
                index=0;
                $("img").prop("src",imgArr[index]);
              }
		     $("#A").bind('click',function(){
					next();
				});				
			});
			
			$(document).ready(function(){
				$("img").mouseover(function(){
					$(this).css("opacity","0.9");
					$(this).css("border","1px solid black");
					$(this).css("width","940px");
					$(this).css("height","340px");
					$(this).css("background-color","#fff");
					$(this).css("box-shadow","5px 5px 15px #000000");
				});
				$("img").mouseout(function(){
				    $(this).css("border", "");
				    $(this).css("box-shadow", "");
					$(this).css("opacity","0.5");
				});
			});
	</script>
  </head>
  
  <body>
	<!--顶部-->
	<div id="toptop">
	 <fieldset style="width: 920px; border-color: #000000; padding-left: 10px">
	 	
     <legend id="topwenzi">冷链物流</legend>
   &nbsp; &nbsp; &nbsp; &nbsp;南储仓储管理有限公司系广东广晟有色金属集团有限公司等八家股东组成的股份有限公司，是一家集仓储、运输、期货交割、仓储融资、保税仓等为一体的综合性仓储管理公司。公司成立于1998年4月，注册资金为6000万元，现有员工近两千人，是上海期货交易所和大连商品交易所指定交割仓库，已成为华南地区具竞争力的仓储管理公司。
南储公司以仓储业务为核心，在此基础上开展了一系列的衍生服务，服务品种包括期货交割、仓储管理输出、保税服务、仓储融资、港口接运、货物配送、国际货运代理、代理报关、信息服务等。南储公司通过全体员工的十载奋斗，创下了“服务好、管理严、信息快、品种多、勇于创新”的优秀品牌，在业内外享有极佳的口碑，成为了华南地区的有色金属物流中心、交易中心、信息中心，及国内仓储融资业的龙头企业，为银企合作提供了广阔的舞台。随着仓储业务的快速发展，年吞吐量将达到250万吨以上，在同行业中名列前茅。仓储融资业务截至2008年底，合作的国内外银行共19家，合作企业共380余家，监管的质押物价值达到250亿元。展望未来，南储公司正朝着现代化、信息化、多功能一体化的一流仓储管理公司迈进！
公司为员工提供有竞争力的薪酬和良好的福利待遇（五险一金、培训和旅游的机会等），并为员工提供科学的职业生涯规划和广阔的晋升空间。
     
   </fieldset>
   </div>
    <div id="wenzi">点击图片了解</div>
  <div id="A">
			<img src="img/leng/leng1.png" />
   </div>

</body>
</html>
