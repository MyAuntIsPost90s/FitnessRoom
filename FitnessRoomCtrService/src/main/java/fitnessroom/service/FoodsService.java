package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Foods;
import fitnessroom.uimodel.EUIPageList;

public interface FoodsService {

	/**
	 * 获取单个健身餐信息
	 * 
	 * @param foodid
	 * @return
	 */
	public Foods getSingle(String foodid);

	/**
	 * 获取健身餐集合
	 * 
	 * @param foods
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUIPageList<Foods> getList(Foods foods, int page, int rows);

	/**
	 * 添加健身餐
	 * 
	 * @param foods
	 */
	public void add(Foods foods);

	/**
	 * 修改健身餐
	 * 
	 * @param foods
	 */
	public void update(Foods foods);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void delete(List<String> ids);

}
