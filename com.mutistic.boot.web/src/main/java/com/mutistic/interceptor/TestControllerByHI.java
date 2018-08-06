package com.mutistic.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.CommonUtil;

/**
 * @program Controller请求 演示 HandlerInterceptor拦截器
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
@RestController
@RequestMapping("/testControllerByHI/")
public class TestControllerByHI {

	
	/**
	 * HandlerInterceptor使用：
	 * 1、实现 HandlerInterceptor 接口，重写 preHandle()、postHandle()、afterCompletion()方法
	 * 1.1、preHandle方法：在Controller请求之前触发（一般用于登陆验证）
	 * 1.2、postHandle方法：在Controller请求之后，页面未渲染时触发（一般用于业务逻辑等）
	 * 1.3、afterCompletion方法：Controller请求完毕，页面渲染完成触发（一般用于清理资源）
	 * 
	 * 2、继承 WebMvcConfigurationSupport 类，重写addInterceptors()方法，实现@SpringBootConfiguration注解
	 * 2.1、通过 InterceptorRegistry.addInterceptor() 添加 实例化的 HandlerInterceptor实现类
	 * 2.2、通过 InterceptorRegistration.addPathPatterns() 添加需要拦截的请求路径
	 */
	
	
	/**
	 * @description 演示 HandlerInterceptor拦截器
	 * @author mutisitic
	 * @date 2018年7月27日
	 * @return
	 */
	@GetMapping(value = "showHandlerInterceptor", produces = "text/html;charset=UTF-8")
	public String showHandlerInterceptor() {
		return CommonUtil.printTwo("Controller请求 演示 HandlerInterceptor拦截器", "showHandlerInterceptor");
	}

}
