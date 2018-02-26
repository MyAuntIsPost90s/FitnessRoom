package fitnessroom.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.TeachersMapper;
import fitnessroom.base.model.Teachers;
import fitnessroom.service.TeachersService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class TeachersServiceImpl implements TeachersService {

	@Resource
	private TeachersMapper teachersMapper;

	@Override
	public Teachers getSingle(String teacherid) {
		return teachersMapper.getSingle(teacherid);
	}

	@Override
	public EUIPageList<Teachers> getList(Teachers teachers, int page, int rows) {
		PageList<Teachers> pageList = teachersMapper.getListWithPage(teachers, new PageBounds(page, rows));
		return new EUIPageList<Teachers>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Teachers teachers) {
		teachers.setTeacherid(RandomNum.getUID());
		teachersMapper.insert(teachers);
	}

	@Override
	public void update(Teachers teachers) {
		teachersMapper.update(teachers);
	}

	@Override
	public void delete(List<String> ids, String basePath) {
		for (String id : ids) {
			Teachers teachers = teachersMapper.getSingle(id);
			String path = basePath + teachers.getTeacherheadurl();
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
		}
		teachersMapper.batchDelete(ids);
	}

}
