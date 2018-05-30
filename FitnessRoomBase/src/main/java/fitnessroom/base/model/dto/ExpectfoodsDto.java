package fitnessroom.base.model.dto;

import fitnessroom.base.model.Expectfoods;

public class ExpectfoodsDto extends Expectfoods {

	private String foodname;

	private Float foodprice;

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Float getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(Float foodprice) {
		this.foodprice = foodprice;
	}

}
