package com.mutistic.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示通过FilterRegistrationBean 注册Filter bean
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
public class TestFilterByConfig implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		CommonUtil.printOne("执行：TestFilterByConfig implements Filter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CommonUtil.printOne("执行：TestFilterByConfig implements Filter.doFilter()");
		
		StringBuffer val = new StringBuffer("\n1、演示通过FilterRegistrationBean 注册Filter bean");
		val.append("\n【Filter：实现 javax.servlet.Filter 接口 注解配置过滤请求】");
		val.append("\n【方法：重写Filter的doFilter()】");
		val.append("\n【PS1：在实现 @Configuration 类中创建  FilterRegistrationBean<TestFilterByConfig> bean】");
		val.append("\n【PS2：通过 @Configuration 创建bean：不需要在 Filter类 实现 @WebFilter 注解 】");
		val.append("\n【PS3：配置过滤器后，要用chain.doFilter(request, response) 防止无法请求的访问】");
		val.append("\n【PS4：@Configuration 创建bean代码：\n	"
				+ "@Bean\r\n" + 
				"	public FilterRegistrationBean<TestFilterByConfig> createrTestFilterByConfig() {\r\n" + 
				"		FilterRegistrationBean<TestFilterByConfig> filter = new FilterRegistrationBean<TestFilterByConfig>();\r\n" + 
				"		filter.setFilter(new TestFilterByConfig());\r\n" + 
				"		filter.setUrlPatterns(Arrays.asList(\"/testHttpServletByConfig.do\"));\r\n" + 
				"		return filter;\r\n" + 
				"	}】");
		System.out.println(val.toString());
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		CommonUtil.printOne("执行：TestFilterByConfig implements Filter.destroy()");
	}

}
