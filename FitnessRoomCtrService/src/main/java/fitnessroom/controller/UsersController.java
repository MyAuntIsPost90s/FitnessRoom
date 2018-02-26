package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Users;
import fitnessroom.service.UsersService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("users")
public class UsersController {

	@Resource
	private UsersService usersService;

	/**
	 * 获取当前用户接口
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("nowuser")
	public void nowUser(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			requestHolder.success(user);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单个用户
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, String userid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = usersService.getSingle(userid);
			requestHolder.success(user);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取用户列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows, Users user) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Users> users = usersService.getList(user, page, rows);
			requestHolder.success(users);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Users user) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			usersService.add(user);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Users user) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users nowuser=(Users) requestHolder.getClientUser();
			usersService.update(user);
			if(user.getUserid().equals(nowuser.getUserid())){
				requestHolder.setClientUser(usersService.getSingle(nowuser.getUserid()));
			}
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 批量删除
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
			usersService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
