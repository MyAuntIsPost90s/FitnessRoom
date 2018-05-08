package fitnessroom.base.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitnessroom.base.model.Expectcourse;
import fitnessroom.base.model.dto.ExpectcourseDto;
import lingshi.mybaties.mapperextend.BaseMapper;

public interface ExpectcourseMapper extends BaseMapper<Expectcourse> {
	PageList<ExpectcourseDto> getCourseCount(Expectcourse expectcourse, PageBounds pageBounds);
}