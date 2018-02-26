package fitnessroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.CoursesMapper;
import fitnessroom.base.model.Courses;
import fitnessroom.service.CoursesService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Resource
	private CoursesMapper coursesMapper;

	@Override
	public Courses getSingle(String courseid) {
		return coursesMapper.getSingle(courseid);
	}

	@Override
	public EUIPageList<Courses> getList(Courses courses, int page, int rows) {
		PageList<Courses> pageList = coursesMapper.getListWithPage(courses, new PageBounds(page,rows));
		return new EUIPageList<Courses>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Courses courses) {
		courses.setCourseid(RandomNum.getCID());
		coursesMapper.insert(courses);
	}

	@Override
	public void update(Courses courses) {
		coursesMapper.update(courses);
	}

	@Override
	public void delete(List<String> ids) {
		coursesMapper.batchDelete(ids); 
	}

	
}
