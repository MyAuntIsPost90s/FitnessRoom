package fitnessroom.base.model.dto;

import fitnessroom.base.model.Courses;

public class CoursesDto extends Courses {

	private String teachername;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
}
