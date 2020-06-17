  	$(document).ready(function(){                
                $("#InNumber").blur(Cost);
                $("#InNumber").blur(Total);            	
  	})
  	            function Cost(){
			    var FoodPurchasePrice = $("#FoodPurchasePrice").val();
			    var InNumber = $("#InNumber").val();
			    var Cost = $("#Cost").val();
				var Result =Number(FoodPurchasePrice) * Number(InNumber) + Number(Cost);  
			    $("#Cost").val(Result);			    
			}
  	            function Total(){
			    var InNumber = $("#InNumber").val();
			    var AllTotal = $("#AllTotal").val();
			    var Result = Number(InNumber) + Number(AllTotal);
			    $("#AllTotal").val(Result);
			    	
			}
  	
				
		
			