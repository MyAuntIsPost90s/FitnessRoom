package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Usercourses;

public interface UserCoursesService {

	public Usercourses getSingle(String usercourseid);

	public List<Usercourses> getList(Usercourses usercourses);

	public void update(List<Usercourses> list);
	
	public void deleteByUserId(String userid);
	
	public void batchDelete(List<String> ids);

}
