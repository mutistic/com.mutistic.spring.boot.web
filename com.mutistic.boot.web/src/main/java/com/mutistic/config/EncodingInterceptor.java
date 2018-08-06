package com.mutistic.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mutistic.interceptor.TestHandlerInterceptor;
import com.mutistic.utils.CommonUtil;

/**
 * @program 定义编码格式拦截器
 * @description
 * @author mutisitic
 * @date 2018年7月27日
 */
@SpringBootConfiguration
public class EncodingInterceptor implements WebMvcConfigurer {

	/**
	 * 拦截器的使用方式：http://412887952-qq-com.iteye.com/blog/2398639
	 * WebMvcConfigurationSupport：https://www.cnblogs.com/deng720/p/8989388.html
	 * WebMvcConfigurerAdapter：https://blog.csdn.net/u012129558/article/details/79006253
	 * WebMvcConfigurer：http://412887952-qq-com.iteye.com/blog/2398639
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		CommonUtil.printOne("执行：EncodingInterceptor.addInterceptors()");
		
		registry.addInterceptor(new TestHandlerInterceptor()).addPathPatterns("/*");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		CommonUtil.printOne("执行：EncodingInterceptor.configureMessageConverters()");
		
		converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
		CommonUtil.printOne("执行：EncodingInterceptor.configureContentNegotiation()");
	}
	
}
