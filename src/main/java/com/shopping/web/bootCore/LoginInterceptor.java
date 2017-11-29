package com.shopping.web.bootCore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public final static String SESSION_KEY = "sessionKey";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object sessionId = request.getSession().getAttribute(SESSION_KEY);
		if (null!=sessionId &&StringUtils.isNotBlank(sessionId.toString())) {
			return true;
		}
		response.sendRedirect("/goShoppingWeb/");
		return false;
	}

}
