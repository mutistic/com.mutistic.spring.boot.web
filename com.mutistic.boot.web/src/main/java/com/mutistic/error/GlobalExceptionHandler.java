package com.mutistic.error;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutistic.utils.CommonUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @description 通过 @ExceptionHandler 声明全局异常处理
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = FileNotFoundException.class)
	@ResponseBody
	public String error(Exception e, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(CommonUtil.UTF8);
			response.setCharacterEncoding(CommonUtil.UTF8);
		} catch (UnsupportedEncodingException e1) { }
		

		StringBuffer val = new StringBuffer("\n通过@ControllerAdvice +  @ExceptionHandler 处理全局异常");
		val.append("\n[Class：声明一个类实现 @ControllerAdvice 注解]");
		val.append("\n[Method：声明一个方法实现 @ExceptionHandler 注解，同时实现 @ResponseBody注解]");
		val.append("\n[ExceptionHandler.value：拦截指定异常：value = FileNotFoundException.class]");
		val.append("\n[PS1： @ExceptionHandler 会导致返回中文是乱码，需要对HttpServletRequest，HttpServletResponse 重新设置 CharacterEncoding 编码]");
		val.append("\n[PS2： 全局的@ExceptionHandler 优先级比 具体Controller的ExceptionHandler 低 （可以声明多个）]");
		val.append("\n[PS3： @ExceptionHandler 优先级比 ErrorPageRegistrar配置的 低]");

		return "通过 @ExceptionHandler 声明全局异常处理:" + e.getMessage();
	}

}
