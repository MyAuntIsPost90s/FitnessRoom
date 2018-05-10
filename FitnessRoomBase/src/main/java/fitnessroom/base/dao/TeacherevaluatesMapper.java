package fitnessroom.base.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitnessroom.base.model.Teacherevaluates;
import fitnessroom.base.model.dto.TeacherEvaluateDto;
import lingshi.mybaties.mapperextend.BaseMapper;

public interface TeacherevaluatesMapper extends BaseMapper<Teacherevaluates> {

	PageList<TeacherEvaluateDto> getCountList(@Param("userid") String userid, PageBounds pageBounds);

}