package com.shopping.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.shopping.web.mapper.UserMapper;
import com.shopping.web.service.UserService;
import com.shopping.web.vo.UserVo;

@RestController
// @RequestMapping("/goShoppingWeb")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;

	@RequestMapping("/getUserInfoById")
	public String getUserInfoById() {
		UserVo userVo = userMapper.getUserInfoById("1");
		return JSON.toJSONString(userVo);
	}

	@RequestMapping("/getUserInfoAll")
	public String getUserInfoAll() {
		return JSON.toJSONString(userService.getUserInfoAllService());
	}
	@RequestMapping("/getUserInfoByAPService")
	public String getUserInfoByAPService(HttpServletRequest httpServletRequest) {
		return JSON.toJSONString(userService.getUserInfoByAPService(
				httpServletRequest.getParameter("accountNumber"),httpServletRequest.getParameter("passWord")));
	}
}
