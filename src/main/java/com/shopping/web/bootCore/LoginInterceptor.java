package com.shopping.web.bootCore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public final static String SESSION_KEY = "sessionKey";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=====URL: "+JSON.toJSONString(request.getRequestURI())+"============ParameterMap: "+JSON.toJSONString(request.getParameterMap()));
		Object sessionId = request.getSession().getAttribute(SESSION_KEY);
		if (null!=sessionId &&StringUtils.isNotBlank(sessionId.toString())) {
			return true;
		}
		response.sendRedirect("/goShoppingWeb/");
		return false;
	}

}
