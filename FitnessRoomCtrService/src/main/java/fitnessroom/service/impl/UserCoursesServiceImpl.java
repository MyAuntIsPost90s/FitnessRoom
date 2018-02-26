package fitnessroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.UsercoursesMapper;
import fitnessroom.base.model.Usercourses;
import fitnessroom.service.UserCoursesService;

@Service
public class UserCoursesServiceImpl implements UserCoursesService {

	@Resource
	private UsercoursesMapper usercoursesMapper;

	@Override
	public Usercourses getSingle(String usercourseid) {
		return usercoursesMapper.getSingle(usercourseid);
	}

	@Override
	public List<Usercourses> getList(Usercourses usercourses) {
		return usercoursesMapper.getList(usercourses);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void update(List<Usercourses> list) {
		// 删除原来的
		usercoursesMapper.deleteByUserId(list.get(0).getUserid());		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setUsercourseid(RandomNum.getUID());
		}
		usercoursesMapper.batchInsert(list);
	}

	@Override
	public void deleteByUserId(String userid) {
		usercoursesMapper.deleteByUserId(userid);
	}

	@Override
	public void batchDelete(List<String> ids) {
		usercoursesMapper.batchDelete(ids);
	}
}
