package fitnessroom.base.model.dto;

public class ExpectfoodsUserDto {
	private String userid;
	private String realname;
	private String foodid;
	private String foodname;
	private Float foodprice;
	private Integer count;
	private Float totalprice;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getFoodid() {
		return foodid;
	}

	public void setFoodid(String foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}

	public Float getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(Float foodprice) {
		this.foodprice = foodprice;
	}

}
