package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Expectcourse;
import fitnessroom.base.model.Users;
import fitnessroom.base.model.dto.ExpectcourseDto;
import fitnessroom.service.ExpectCoursesService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("expectCourses")
public class ExpectCoursesController {

	@Resource
	private ExpectCoursesService expectCoursesService;

	/**
	 * 获取选课列表
	 * 
	 * @param request
	 * @param response
	 * @param expectcourse
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Expectcourse expectcourse, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<ExpectcourseDto> list = expectCoursesService.getList(expectcourse, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取用户选课列表
	 * 
	 * @param request
	 * @param response
	 * @param expectcourse
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list4user")
	public void list4user(HttpServletRequest request, HttpServletResponse response, Expectcourse expectcourse, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			expectcourse.setUserid(users.getUserid());
			EUIPageList<ExpectcourseDto> list = expectCoursesService.getList(expectcourse, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取期望课程统计
	 * 
	 * @param request
	 * @param response
	 * @param expectcourse
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list4count")
	public void list4count(HttpServletRequest request, HttpServletResponse response, Expectcourse expectcourse,
			int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<ExpectcourseDto> list = expectCoursesService.getCourseCount(expectcourse, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改用户期望课程
	 * 
	 * @param request
	 * @param response
	 * @param list
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Expectcourse> list) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			expectCoursesService.update(list, users.getUserid());
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
