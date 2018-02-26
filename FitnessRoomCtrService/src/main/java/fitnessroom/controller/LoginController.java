package fitnessroom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitnessroom.base.model.Users;
import fitnessroom.service.UsersService;
import lingshi.web.model.RequestHolder;

@Controller
public class LoginController {

	@Resource
	private UsersService usersService;

	/**
	 * 登陆接口
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("dologin")
	public void doLogin(HttpServletRequest request, HttpServletResponse response, Users user) {
		RequestHolder requestHolder = RequestHolder.get(request, response);

		try {
			StringBuilder stringBuilder = new StringBuilder();
			Users result = usersService.doLogin(user, stringBuilder);
			if (result == null) {
				requestHolder.fail(stringBuilder.toString());
				return;
			}
			requestHolder.setClientUser(result);
			requestHolder.success(stringBuilder.toString(), result);
		} catch (Exception e) {
			requestHolder.err("登陆失败", e);
		}
	}
}
