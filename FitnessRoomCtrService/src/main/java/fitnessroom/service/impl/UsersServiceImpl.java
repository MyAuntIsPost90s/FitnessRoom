package fitnessroom.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitness.base.common.UserType;
import fitnessroom.base.dao.UsersMapper;
import fitnessroom.base.model.Teachers;
import fitnessroom.base.model.Users;
import fitnessroom.service.TeachersService;
import fitnessroom.service.UsersService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.utilities.ObjectHelper;

@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private TeachersService teachersService;

	@Override
	public Users doLogin(Users users, StringBuilder stringBuilder) {
		String username = users.getUsername();
		String password = users.getPassword();
		ObjectHelper.setObjectNull(users);
		users.setUsername(username);
		List<Users> list = usersMapper.getList(users);
		if (list == null || list.size() != 1) {
			Teachers teachersQ = new Teachers();
			teachersQ.setTeacherphone(username);
			EUIPageList<Teachers> eList = teachersService.getList(teachersQ, 1, 1);
			if (eList.getTotal() < 1) {
				stringBuilder.append("用户不存在");
				return null;
			} else {
				users.setUserid(eList.getRows().get(0).getTeacherid());
				users.setBirthday(eList.getRows().get(0).getTeacherbirthday());
				users.setRealname(eList.getRows().get(0).getTeachername());
				users.setHeadimgurl(eList.getRows().get(0).getTeacherheadurl());
				users.setPassword(eList.getRows().get(0).getTeacherpassword());
				users.setSex(eList.getRows().get(0).getTeachersex());
				users.setUsertype(UserType.VIP + 1);
			}
		}
		if (list.size() > 0) {
			users = list.get(0);
		}
		if (!users.getPassword().equals(password)) {
			stringBuilder.append("用户名或密码错误");
			return null;
		}

		return users;
	}

	@Override
	public Users getSingle(String userid) {
		return usersMapper.getSingle(userid);
	}

	@Override
	public EUIPageList<Users> getList(Users user, int page, int rows) {
		PageList<Users> pageList = usersMapper.getListWithPage(user, new PageBounds(page, rows));
		return new EUIPageList<Users>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Users user) throws Exception {
		Users userQ = new Users();
		userQ.setUsername(user.getUsername());
		if (usersMapper.count(userQ) > 0) {
			throw new Exception("用户名重复");
		}
		user.setUserid(RandomNum.getUID());
		user.setCreatetime(new Date());
		usersMapper.insert(user);
	}

	@Override
	public void update(Users user) {
		usersMapper.update(user);
	}

	@Override
	public void delete(List<String> ids) {
		usersMapper.batchDelete(ids);
	}

}
