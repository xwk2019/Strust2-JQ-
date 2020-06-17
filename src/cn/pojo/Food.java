package cn.pojo;

public class Food {
	private String FoodNumber;
	private String FoodName;
	private String FoodPurchasePrice;
	private String FoodSellingprice;
	private String FoodPicture;

	
	public String getFoodPicture() {
		return FoodPicture;
	}

	public void setFoodPicture(String foodPicture) {
		FoodPicture = foodPicture;
	}

	public String getFoodNumber() {
		return FoodNumber;
	}

	public void setFoodNumber(String foodNumber) {
		FoodNumber = foodNumber;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public String getFoodPurchasePrice() {
		return FoodPurchasePrice;
	}

	public void setFoodPurchasePrice(String foodPurchasePrice) {
		FoodPurchasePrice = foodPurchasePrice;
	}

	public String getFoodSellingprice() {
		return FoodSellingprice;
	}

	public void setFoodSellingprice(String foodSellingprice) {
		FoodSellingprice = foodSellingprice;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

}
