package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Foods;
import fitnessroom.service.FoodsService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("foods")
public class FoodsController {

	@Resource
	private FoodsService foodsService;

	/**
	 * 获取健身餐列表
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Foods foods, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Foods> list = foodsService.getList(foods, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单个健身餐信息
	 * 
	 * @param request
	 * @param response
	 * @param equipmentid
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, String foodid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Foods foods = foodsService.getSingle(foodid);
			requestHolder.success(foods);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加健身餐
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Foods foods) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			foodsService.add(foods);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改健身餐
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Foods foods) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			foodsService.update(foods);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 移除健身餐
	 * 
	 * @param request
	 * @param response
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			foodsService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
