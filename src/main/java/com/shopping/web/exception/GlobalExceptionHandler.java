package com.shopping.web.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 开发默认下关闭注解@ControllerAdvice @ExceptionHandler(RuntimeException.class) @ResponseBody系统console会显示异常错误
 * 
 * @author wct
 *
 */
// @ControllerAdvice
public class GlobalExceptionHandler {
	// @ExceptionHandler(RuntimeException.class)
	// @ResponseBody
	public Map<String, String> globalException() {
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("code", "500");
		resMap.put("message", "亲，系统异常");
		return resMap;
	}
}
