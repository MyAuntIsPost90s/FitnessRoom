package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Teachers;
import fitnessroom.service.TeachersService;
import fitnessroom.uimodel.EUIPageList;

import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("teachers")
public class TeachersController {

	@Resource
	private TeachersService teachersService;

	/**
	 * 获取列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param teachers
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Teachers> list = teachersService.getList(teachers, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单个信息
	 * 
	 * @param request
	 * @param response
	 * @param teacherid
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, String teacherid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Teachers teacher = teachersService.getSingle(teacherid);
			requestHolder.success(teacher);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @param teachers
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teachersService.add(teachers);
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
	 * @param teachers
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teachersService.update(teachers);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 删除
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
			teachersService.delete(ids, requestHolder.getRealPathPath(""));
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
