package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Courses;
import fitnessroom.uimodel.EUIPageList;

public interface CoursesService {

	public Courses getSingle(String courseid);

	public EUIPageList<Courses> getList(Courses courses, int page, int rows);

	public void add(Courses courses);

	public void update(Courses courses);
	
	public void delete(List<String> ids);

}
