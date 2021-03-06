package com.shopping.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.web.bootCore.ApplicationMelodyListener;

@SpringBootApplication
public class GoShoppingWebApplication {
	/*
	 * 1.启动方式（第一种右键GoShoppingWebApplication.java文件run运行启动，端口号是application.
	 * properties的server.port 第二种，将项目用tomcat部署
	 * 2.可以用JdbcTemplate访问数据库操作，也可用mybatis的xml访问编写
	 * http://briancheng.51vip.biz/goShoppingWeb/
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GoShoppingWebApplication.class); 
        app.addListeners(new ApplicationMelodyListener());//增加javamelody性能监控工具  http://localhost:8080/goShoppingWeb/monitoring
        app.run(args);
	}
}
