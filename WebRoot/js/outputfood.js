  	$(document).ready(function(){                
                $("#OutNumber").blur(Profit);
                $("#OutNumber").blur(Total);            	
  	})
  	            function Profit(){
			    var FoodPurchasePrice = $("#FoodPurchasePrice").val();
			    var FoodSellingprice = $("#FoodSellingprice").val();
			    var OutNumber = $("#OutNumber").val();
			    var Profit = $("#Profit").val();
				var Result =(Number(FoodSellingprice) - Number(FoodPurchasePrice)) * Number(OutNumber) + Number(Profit);  
			    $("#Profit").val(Result);			    
			}
  	            function Total(){
			    var OutNumber = $("#OutNumber").val();
			    var AllTotal = $("#AllTotal").val();
			    var Result = Number(AllTotal) - Number(OutNumber);
			    $("#AllTotal").val(Result);
			    	
			}
  	
				
		
			