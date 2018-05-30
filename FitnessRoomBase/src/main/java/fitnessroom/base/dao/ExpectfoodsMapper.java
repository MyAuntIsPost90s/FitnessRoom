package fitnessroom.base.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitnessroom.base.model.Expectfoods;
import fitnessroom.base.model.dto.ExpectfoodsUserDto;
import lingshi.mybaties.mapperextend.BaseMapper;

public interface ExpectfoodsMapper extends BaseMapper<Expectfoods> {
	
	List<ExpectfoodsUserDto> getExpectUser(String foodid);

	PageList<Expectfoods> getListWithOverdue(Expectfoods expectfoods, PageBounds pageBounds);
	
}