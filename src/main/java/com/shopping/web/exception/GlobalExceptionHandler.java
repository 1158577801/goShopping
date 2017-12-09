package com.shopping.web.exception;

import com.shopping.web.common.Result;

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
	public Result globalException() {
		return new Result("亲，系统异常");
	}
}
