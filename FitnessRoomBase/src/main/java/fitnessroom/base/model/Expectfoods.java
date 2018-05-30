package fitnessroom.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Expectfoods {
	private String expectfoodid;

	private String userid;

	private String foodid;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date expectfoodtime;

	private String note;

	public String getExpectfoodid() {
		return expectfoodid;
	}

	public void setExpectfoodid(String expectfoodid) {
		this.expectfoodid = expectfoodid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFoodid() {
		return foodid;
	}

	public void setFoodid(String foodid) {
		this.foodid = foodid;
	}

	public Date getExpectfoodtime() {
		return expectfoodtime;
	}

	public void setExpectfoodtime(Date expectfoodtime) {
		this.expectfoodtime = expectfoodtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}