package fitnessroom.service;

import fitnessroom.base.model.Teacherevaluates;
import fitnessroom.base.model.dto.TeacherEvaluateDto;
import fitnessroom.uimodel.EUIPageList;

public interface TeacherEvaluatesService {

	EUIPageList<TeacherEvaluateDto> list4count(String userid, int page, int rows);

	Teacherevaluates single(String teacherid, String userid);

	void add(Teacherevaluates teacherevaluates, String userid);

	void update(Teacherevaluates teacherevaluates, String userid);

}
