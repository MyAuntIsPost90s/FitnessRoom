package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Expectfoods;
import fitnessroom.base.model.Users;
import fitnessroom.base.model.dto.ExpectfoodsDto;
import fitnessroom.base.model.dto.ExpectfoodsUserDto;
import fitnessroom.service.ExpectfoodsService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("expectFoods")
public class ExpectfoodsController {

	@Resource
	private ExpectfoodsService expectfoodsService;

	/**
	 * 获取用户预约集合
	 * 
	 * @param request
	 * @param response
	 * @param expectfoods
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Expectfoods expectfoods, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			expectfoods.setUserid(users.getUserid());
			EUIPageList<ExpectfoodsDto> list = expectfoodsService.getList(expectfoods, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
	
	/**
	 * 获取用户过期预约
	 * 
	 * @param request
	 * @param response
	 * @param expectfoods
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list4overdue")
	public void list4overdue(HttpServletRequest request, HttpServletResponse response, Expectfoods expectfoods, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			expectfoods.setUserid(users.getUserid());
			EUIPageList<ExpectfoodsDto> list = expectfoodsService.list4overdue(expectfoods, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取预约用户集合
	 * 
	 * @param request
	 * @param response
	 * @param foodid
	 */
	@ResponseBody
	@RequestMapping("list4expect")
	public void list4expect(HttpServletRequest request, HttpServletResponse response, String foodid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			List<ExpectfoodsUserDto> list = expectfoodsService.list4expect(foodid);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加健身餐预约
	 * 
	 * @param request
	 * @param response
	 * @param expectfoods
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Expectfoods expectfoods) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			expectfoods.setUserid(users.getUserid());
			expectfoodsService.add(expectfoods);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 删除预约
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
			expectfoodsService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
