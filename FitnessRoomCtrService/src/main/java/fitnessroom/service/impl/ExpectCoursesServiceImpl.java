package fitnessroom.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.ExpectcourseMapper;
import fitnessroom.base.model.Courses;
import fitnessroom.base.model.Expectcourse;
import fitnessroom.base.model.dto.ExpectcourseDto;
import fitnessroom.service.CoursesService;
import fitnessroom.service.ExpectCoursesService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class ExpectCoursesServiceImpl implements ExpectCoursesService {

	@Resource
	private ExpectcourseMapper expectcourseMapper;
	@Resource
	private CoursesService coursesService;

	@Override
	public EUIPageList<ExpectcourseDto> getCourseCount(Expectcourse expectcourse, int page, int rows) {
		PageList<ExpectcourseDto> pageList = expectcourseMapper.getCourseCount(expectcourse,
				new PageBounds(page, rows));
		for (ExpectcourseDto item : pageList) {
			Expectcourse expectcourseQ = new Expectcourse();
			expectcourseQ.setCourseid(item.getCourseid());
			Courses courses = coursesService.getSingle(item.getCourseid());
			item.setCoursename(courses == null ? "" : courses.getCoursename());
		}
		return new EUIPageList<ExpectcourseDto>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	@Transactional(rollbackOn = { Exception.class })
	public void update(List<Expectcourse> list, String userid) {
		// 先删除
		Expectcourse expectcourseQ = new Expectcourse();
		expectcourseQ.setUserid(userid);
		List<Expectcourse> expectcourses = expectcourseMapper.getList(expectcourseQ);
		List<String> ids = new ArrayList<String>();
		for (Expectcourse item : expectcourses) {
			ids.add(item.getExpectcourseid());
		}
		if (!ids.isEmpty()) {
			expectcourseMapper.batchDelete(ids);
		}
		// 再添加
		for (Expectcourse item : list) {
			item.setExpectcourseid(RandomNum.getEID());
			item.setUserid(userid);
			expectcourseMapper.insert(item);
		}
	}

	@Override
	public EUIPageList<ExpectcourseDto> getList(Expectcourse expectcourse, int page, int rows) {
		PageList<Expectcourse> pageList = expectcourseMapper.getListWithPage(expectcourse, new PageBounds(page, rows));
		List<ExpectcourseDto> list = new ArrayList<ExpectcourseDto>();
		for (Expectcourse item : pageList) {
			ExpectcourseDto expectcourseDto = new ExpectcourseDto();
			expectcourseDto.setExpectcourseid(item.getExpectcourseid());
			expectcourseDto.setCourseid(item.getCourseid());
			expectcourseDto.setUserid(item.getUserid());
			Courses courses = coursesService.getSingle(item.getCourseid());
			expectcourseDto.setCoursename(courses == null ? "" : courses.getCoursename());
			list.add(expectcourseDto);
		}
		return new EUIPageList<ExpectcourseDto>(pageList.getPaginator().getTotalCount(), list);
	}

}
