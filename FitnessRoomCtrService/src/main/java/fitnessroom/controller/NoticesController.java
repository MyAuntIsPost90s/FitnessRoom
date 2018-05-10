package fitnessroom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Notices;
import fitnessroom.service.NoticesService;
import fitnessroom.uimodel.EUIPageList;
import lingshi.web.model.RequestHolder;

@Controller
@RequestMapping("notice")
public class NoticesController {

	@Resource
	private NoticesService noticesService;

	/**
	 * 获取设备列表
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Notices notices, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Notices> list = noticesService.getList(notices, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单个设备信息
	 * 
	 * @param request
	 * @param response
	 * @param equipmentid
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, String noticeid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Notices notices = noticesService.getSingle(noticeid);
			requestHolder.success(notices);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加设备
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Notices notices) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			noticesService.add(notices);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改设备
	 * 
	 * @param request
	 * @param response
	 * @param equipments
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Notices notices) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			noticesService.update(notices);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 移除设备
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
			noticesService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
