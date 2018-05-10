package fitnessroom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Teacherevaluates;
import fitnessroom.base.model.Users;
import fitnessroom.base.model.dto.TeacherEvaluateDto;
import fitnessroom.service.TeacherEvaluatesService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("teacherEvaluates")
public class TeacherEvaluatesController {

	@Resource
	private TeacherEvaluatesService teacherEvaluatesService;

	/**
	 * 获取统计列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list4count")
	public void list4count(HttpServletRequest request, HttpServletResponse response, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			EUIPageList<TeacherEvaluateDto> list = teacherEvaluatesService.list4count(users.getUserid(), page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单条数据
	 * 
	 * @param request
	 * @param response
	 * @param teacherevaluateid
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, String teacherid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			Teacherevaluates teacherevaluates = teacherEvaluatesService.single(teacherid, users.getUserid());
			requestHolder.success(teacherevaluates);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加评价
	 * 
	 * @param request
	 * @param response
	 * @param teacherevaluates
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Teacherevaluates teacherevaluates) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			teacherEvaluatesService.add(teacherevaluates, user.getUserid());
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改评价
	 * 
	 * @param request
	 * @param response
	 * @param teacherevaluates
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Teacherevaluates teacherevaluates) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			teacherEvaluatesService.update(teacherevaluates, user.getUserid());
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
