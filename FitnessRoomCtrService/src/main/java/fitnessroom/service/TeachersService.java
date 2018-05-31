package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Teachers;
import fitnessroom.uimodel.EUIPageList;

public interface TeachersService {

	public Teachers getSingle(String teacherid);

	public EUIPageList<Teachers> getList(Teachers teachers, int page, int rows);

	public void add(Teachers teachers) throws Exception;

	public void update(Teachers teachers) throws Exception;

	public void delete(List<String> ids, String basePath);

}
