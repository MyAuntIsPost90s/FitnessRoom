package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Expectfoods;
import fitnessroom.base.model.dto.ExpectfoodsDto;
import fitnessroom.base.model.dto.ExpectfoodsUserDto;
import fitnessroom.uimodel.EUIPageList;

public interface ExpectfoodsService {

	/**
	 * 获取预约列表
	 * 
	 * @param expectfoods
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUIPageList<ExpectfoodsDto> getList(Expectfoods expectfoods, int page, int rows);

	/**
	 * 获取过期列表
	 * 
	 * @param expectfoods
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUIPageList<ExpectfoodsDto> list4overdue(Expectfoods expectfoods, int page, int rows);

	/**
	 * 获取预约用户集合
	 * 
	 * @param expectid
	 * @return
	 */
	public List<ExpectfoodsUserDto> list4expect(String foodid);

	/**
	 * 添加
	 * 
	 * @param expectfoods
	 */
	public void add(Expectfoods expectfoods);

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	public void delete(List<String> ids);

}
