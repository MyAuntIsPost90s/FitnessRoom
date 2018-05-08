package fitnessroom.base.model.dto;

import fitnessroom.base.model.Expectcourse;

public class ExpectcourseDto extends Expectcourse {

	private String coursename;

	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}
