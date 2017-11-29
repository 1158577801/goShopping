package com.shopping.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.shopping.web.bootCore.LoginInterceptor;
import com.shopping.web.mapper.UserMapper;
import com.shopping.web.service.UserService;
import com.shopping.web.vo.UserVo;

@Controller
// @RequestMapping("/goShoppingWeb") Rest
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	/**
	 * 去登录页面
	 * @return
	 */
	
	@RequestMapping("/")
	public String toLoginPage(HttpServletRequest httpServletRequest,HttpSession httpSession) {
		return "login";
	}
	@ResponseBody
	@RequestMapping("/getUserInfoById")
	public String getUserInfoById() {
		UserVo userVo = userMapper.getUserInfoById("1");
		return JSON.toJSONString(userVo);
	}
	@ResponseBody
	@RequestMapping("/getUserInfoAll")
	public String getUserInfoAll() {
		return JSON.toJSONString(userService.getUserInfoAllService());
	}
	
	@RequestMapping("/getLogin")
	public String getUserInfoByAPService(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		UserVo userVo=userService.getUserInfoByAPService(
				httpServletRequest.getParameter("accountNumber"),httpServletRequest.getParameter("passWord"));
		if(null!=userVo) {
			httpServletRequest.getSession().setAttribute(LoginInterceptor.SESSION_KEY, userVo);
			return "main";
		}else {
			httpServletRequest.setAttribute("errorMessage", "用户名或者密码错误");
			return "login";
		}
		
	}
}
