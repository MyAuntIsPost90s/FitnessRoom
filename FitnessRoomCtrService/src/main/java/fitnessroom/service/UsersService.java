package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Users;
import fitnessroom.uimodel.EUIPageList;

public interface UsersService {

	public Users doLogin(Users users, StringBuilder stringBuilder);

	public Users getSingle(String userid);

	public EUIPageList<Users> getList(Users user, int page, int rows);

	public void add(Users user);

	public void update(Users user);
	
	public void delete(List<String> ids);

}
