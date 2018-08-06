package com.mutistic.error;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testControllerByEH/")
public class TestControllerByEH {
	
	/**
	 * @description 通过 @ExceptionHandler 处理当前Controller异常
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @param e
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public String error(NullPointerException e) {
		return "\n通过 @ExceptionHandler 处理当前Controller异常:" + e.getMessage();
	}
	
	/**
	 * @description 通过 @ExceptionHandler 处理当前Controller异常
	 * @author mutisitic
	 * @throws FileNotFoundException 
	 * @date 2018年7月30日
	 */
	@GetMapping(value = "showExceptionHandler1")
	public void showErrorView() throws Exception {
		StringBuffer val = new StringBuffer("\n1、通过 @ExceptionHandler 处理当前Controller异常");
		val.append("\n[Controller：声明一个方法实现 @ExceptionHandler 注解]");
		val.append("\n[ExceptionHandler.value：拦截指定异常：value = Exception.class]");
		val.append("\n[PS1：@ExceptionHandler 只对当前Controller生效]");
		val.append("\n[PS2： @ExceptionHandler 会导致返回中文是乱码，需要对HttpServletRequest，HttpServletResponse 重新设置 CharacterEncoding 编码]");
		val.append("\n[PS3： @ExceptionHandler 优先级比 ErrorPageRegistrar配置的 低（可以声明多个）]");
		System.out.println(val.toString());
		
		throw new NullPointerException(val.toString());
	}

}
