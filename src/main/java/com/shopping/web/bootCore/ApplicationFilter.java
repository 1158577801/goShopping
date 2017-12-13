package com.shopping.web.bootCore;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.bull.javamelody.MonitoringFilter;
@Configuration
public class ApplicationFilter {
	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registry = new FilterRegistrationBean();
		// 注入过滤器
		registry.setFilter(new MonitoringFilter());
		// 拦截规则
		registry.addUrlPatterns("/monitoring");
		// 过滤器名称
		registry.setName("monitoring");
		// 是否自动注册 false 取消Filter的自动注册
		registry.setEnabled(true);
		// 过滤器顺序
		registry.setOrder(1);
		return registry;
	}
}
