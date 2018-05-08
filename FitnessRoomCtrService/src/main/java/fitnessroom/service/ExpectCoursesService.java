package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Expectcourse;
import fitnessroom.base.model.dto.ExpectcourseDto;
import fitnessroom.uimodel.EUIPageList;

public interface ExpectCoursesService {
	
	public EUIPageList<ExpectcourseDto> getList(Expectcourse expectcourse, int page, int rows);

	public EUIPageList<ExpectcourseDto> getCourseCount(Expectcourse expectcourse, int page, int rows);

	public void update(List<Expectcourse> list, String userid);

}
