package com.shopping.web.bootCore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

@Configuration
public class ShoppingConfigurerAdapter extends WebMvcConfigurerAdapter {
	public final static String SESSION_KEY = "sessionKey";

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/").excludePathPatterns("/getLogin")
				.excludePathPatterns("/register").excludePathPatterns("/toRegister").excludePathPatterns("/monitoring")
				.excludePathPatterns("/checkActivation");// 不拦截登录action /界面
		super.addInterceptors(registry);
	}

	/**
	 * 登录拦截
	 * @author Administrator
	 *
	 */
	public class LoginInterceptor extends HandlerInterceptorAdapter {
		
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

}
