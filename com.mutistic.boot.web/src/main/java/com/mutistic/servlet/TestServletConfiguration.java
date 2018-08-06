package com.mutistic.servlet;

import java.util.Arrays;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mutistic.utils.CommonUtil;

@SpringBootConfiguration
public class TestServletConfiguration {
	
	/**
	 * @description 配合 TestHttpServletByConfig 创建  Servlet bean
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<TestControllerByConfig> createrTestHttpServletByConfig() {
		CommonUtil.printOne("执行：创建 ServletRegistrationBean<TestControllerByConfig> bean");
		
//		ServletRegistrationBean<TestHttpServletByConfig> reg = new ServletRegistrationBean<TestHttpServletByConfig>();
//		reg.setServlet(new TestHttpServletByConfig()); // 配置 httpServlet类
//		reg.addUrlMappings("/testHttpServletByConfig.do"); // 配置访问URL
//		
//		return reg;
		return new ServletRegistrationBean<TestControllerByConfig>(new TestControllerByConfig(), "/testHttpServletByConfig.do");
	}
	
	/**
	 * @description 配合 TestFilterByConfig 创建  Filter bean
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<TestFilterByConfig> createrTestFilterByConfig() {
		CommonUtil.printOne("执行：创建 FilterRegistrationBean<TestFilterByConfig> bean");
		
		FilterRegistrationBean<TestFilterByConfig> filter = new FilterRegistrationBean<TestFilterByConfig>();
		filter.setFilter(new TestFilterByConfig()); // 配置 Filter类
//		filter.setServletRegistrationBeans(Arrays.asList(createrTestHttpServletByConfig()));
		filter.setUrlPatterns(Arrays.asList("/testHttpServletByConfig.do")); //配置过滤URL
		return filter;
	}
	
	/**
	 * @description 配合 TestServletContextListenerByConfig 创建  ServletContextListener bean
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<TestServletContextListenerByConfig> createrTestServletContextListenerByConfig() {
		CommonUtil.printOne("执行：创建 ServletListenerRegistrationBean<TestServletContextListenerByConfig> bean");
		
		return new ServletListenerRegistrationBean<TestServletContextListenerByConfig>(new TestServletContextListenerByConfig());
	}
	
}
