package com.shopping.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoShoppingWebApplication {
	/*
	 * 1.启动方式（第一种右键GoShoppingWebApplication.java文件run运行启动，端口号是application.
	 * properties的server.port，访问路径默认不用加项目名称） 第二种，将项目用tomcat部署，但是项目访问路径需要加项目名称
	 * 2.可以用JdbcTemplate访问数据库操作，也可用mybatis的xml访问编写
	 */
	public static void main(String[] args) {
		SpringApplication.run(GoShoppingWebApplication.class, args);
	}
}
