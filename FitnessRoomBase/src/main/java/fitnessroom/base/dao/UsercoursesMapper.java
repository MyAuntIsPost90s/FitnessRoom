package fitnessroom.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fitnessroom.base.model.Usercourses;
import lingshi.mybaties.mapperextend.BaseMapper;

public interface UsercoursesMapper extends BaseMapper<Usercourses> {
	public void batchInsert(List<Usercourses> list);
	public void deleteByUserId(@Param("userid")String userid);
}