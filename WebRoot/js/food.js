  	$(document).ready(function(){
                $("#FoodSellingprice").blur(checkPrice); 
                $("#FoodPicture").blur(checkNull); 
                $("#FoodName").blur(checkNull);  
                $("#FoodNumber").blur(checkNull);  
                $("#FoodPurchasePrice").blur(checkNull);  
                $("#myform").submit(function(){
                	if(checkPrice() && checkNull())
                	return true;
                	else{           
                	window.alert("信息填写有误");
                    return false;
                	}
                });		
  	})
  	
				function checkNull(){
			    var FoodNumber = $("#FoodNumber").val();
			    var FoodPicture = $("#FoodPicture").val();
				var FoodName = $("#FoodName").val();
				var FoodPurchasePrice = $("#FoodPurchasePrice").val();							
				var checkNumber = $("#checkNumber");
				var checkPicture = $("#checkPicture");
				var $divIDcheckName = $("#checkName");
				var AcheckPrice = $("#AcheckPrice");	
				if( FoodPicture==""){
					checkPicture.html("图片不能为空");
					return false;
				}
				 checkNumber.html("");		
				if( FoodNumber==""){
					checkNumber.html("商品编号不能为空");
					return false;
				}
				 checkNumber.html("");				   
				if( FoodName==""){
					$divIDcheckName.html("商品名称不能为空");
					return false;
				}				
				 $divIDcheckName.html("");							    
				if( FoodPurchasePrice==""){
					AcheckPrice.html("进价不能为空");
					return false;
				}				
				  AcheckPrice.html("");
				   return true;	
			}
				
			function checkPrice(){
			    var FoodPurchasePrice = $("#FoodPurchasePrice").val(); 
			    var FoodSellingprice = $("#FoodSellingprice").val();
				var $divID = $("#checkPrice");
				if( (FoodPurchasePrice) > (FoodSellingprice) ){
					$divID.html("进货价不能比售价高");
					return false;
				}
				   $divID.html("");
				    return true;	
			}
			