package fitnessroom.controller;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitness.base.common.UserType;
import fitnessroom.base.model.Usercourses;
import fitnessroom.base.model.Users;
import fitnessroom.service.UserCoursesService;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("usercourses")
public class UserCoursesController {

	@Resource
	private UserCoursesService userCoursesService;

	/**
	 * 获取课表
	 * 
	 * @param request
	 * @param response
	 * @param usercourses
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Usercourses usercourses) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user =(Users)requestHolder.getClientUser();
			if(user.getUsertype()!=UserType.ADMIN){
				Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
				calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),0,0,0);
				usercourses.setUsercourseendtime(calendar.getTime());
			}
			List<Usercourses> list = userCoursesService.getList(usercourses);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param list
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Usercourses> list) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			userCoursesService.update(list);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 通过用户编号删除
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 */
	@ResponseBody
	@RequestMapping("deleteByUserId")
	public void deleteByUserId(HttpServletRequest request, HttpServletResponse response, String userid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			userCoursesService.deleteByUserId(userid);
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
	@RequestMapping("batchDelete")
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			userCoursesService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
