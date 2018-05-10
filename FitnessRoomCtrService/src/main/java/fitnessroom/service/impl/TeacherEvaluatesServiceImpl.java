package fitnessroom.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.TeacherevaluatesMapper;
import fitnessroom.base.model.Teacherevaluates;
import fitnessroom.base.model.dto.TeacherEvaluateDto;
import fitnessroom.service.TeacherEvaluatesService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class TeacherEvaluatesServiceImpl implements TeacherEvaluatesService {

	@Resource
	private TeacherevaluatesMapper teacherEvaluatesMapper;

	@Override
	public EUIPageList<TeacherEvaluateDto> list4count(String userid, int page, int rows) {
		PageList<TeacherEvaluateDto> pageList = teacherEvaluatesMapper.getCountList(userid, new PageBounds(page, rows));
		return new EUIPageList<TeacherEvaluateDto>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Teacherevaluates teacherevaluates, String userid) {
		teacherevaluates.setTeacherevaluateid(RandomNum.getLGID());
		teacherevaluates.setTeacherevaluatetime(new Date());
		teacherevaluates.setUserid(userid);
		teacherEvaluatesMapper.insert(teacherevaluates);
	}

	@Override
	public Teacherevaluates single(String teacherid, String userid) {
		Teacherevaluates teacherevaluateQ = new Teacherevaluates();
		teacherevaluateQ.setTeacherid(teacherid);
		teacherevaluateQ.setUserid(userid);
		List<Teacherevaluates> list = teacherEvaluatesMapper.getList(teacherevaluateQ);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(Teacherevaluates teacherevaluates, String userid) {
		Teacherevaluates old = single(teacherevaluates.getTeacherid(), userid);
		old.setTeacherscore(teacherevaluates.getTeacherscore());
		old.setUserid(userid);
		teacherEvaluatesMapper.update(old);
	}

}
