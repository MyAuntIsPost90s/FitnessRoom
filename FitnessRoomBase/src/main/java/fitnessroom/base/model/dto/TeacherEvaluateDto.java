package fitnessroom.base.model.dto;

import fitnessroom.base.model.Teacherevaluates;

public class TeacherEvaluateDto extends Teacherevaluates {

	private String teachername;

	private Integer evaluated;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Integer getEvaluated() {
		return evaluated;
	}

	public void setEvaluated(Integer evaluated) {
		this.evaluated = evaluated;
	}
}
