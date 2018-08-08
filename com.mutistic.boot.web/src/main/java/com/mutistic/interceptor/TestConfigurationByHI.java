package com.mutistic.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mutistic.utils.CommonUtil;

/**
 * @program 实现 WebMvcConfigurer通过 addInterceptors()方法添加 HandlerInterceptor 实例
 * @description
 * @author mutisitic
 * @date 2018年7月26日
 */
@SpringBootConfiguration
//@EnableWebMvc
//public class TestConfigurationByHI extends WebMvcConfigurationSupport { // 屏蔽Spring Boot的@EnableAutoConfiguration中的设置，需要自定义所有的配置
//public class TestConfigurationByHI extends WebMvcConfigurerAdapter { // SpringBoot2.0及Spring 5.0 WebMvcConfigurerAdapter已过期
public class TestConfigurationByHI implements WebMvcConfigurer { // 源接口类 使用 WebMvcConfigurer 代替过期的 WebMvcConfigurerAdapter
	
	/**
	 * 拦截器的使用方式：http://412887952-qq-com.iteye.com/blog/2398639
	 * WebMvcConfigurationSupport：https://www.cnblogs.com/deng720/p/8989388.html
	 * WebMvcConfigurerAdapter：https://blog.csdn.net/u012129558/article/details/79006253
	 * WebMvcConfigurer：http://412887952-qq-com.iteye.com/blog/2398639
	 */
	
	/**
	 * @description 添加拦截器
	 * @author mutisitic
	 * @date 2018年7月27日
	 * @param registry
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		CommonUtil.printOne("执行：TestConfigurationByHI implements WebMvcConfigurer.addInterceptors()");
		registry.addInterceptor(new TestHandlerInterceptor()).addPathPatterns("/testControllerByHI/*");
	}

}
