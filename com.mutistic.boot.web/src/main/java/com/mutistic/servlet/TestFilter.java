package com.mutistic.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mutistic.utils.CommonUtil;

/**
 * @program Servlet3的 @WebFilter 注解 实现 Filter
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
//@WebFilter("/*") // 过滤所有请求
@WebFilter("/testHttpServlet.do")
public class TestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		CommonUtil.printOne("执行：TestFilter implements Filter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CommonUtil.printOne("执行：TestFilter implements Filter.doFilter()");
		
		StringBuffer val = new StringBuffer("\n1、演示 javax.servlet.Filter - doFilter方法");
		val.append("\n【Filter：实现 javax.servlet.Filter 接口，实现 @WebFilter(\"/*.do\") 注解配置过滤请求】");
		val.append("\n【方法：重写Filter的doFilter()】");
		val.append("\n【PS1：@WebFilter可以指定具体请求的过滤】");
		val.append("\n【PS2：配置过滤器后，要嗲用chain.doFilter(request, response) 防止无法请求的访问】");
		System.out.println(val.toString());
		
		request.setCharacterEncoding(CommonUtil.UTF8);
		response.setCharacterEncoding(CommonUtil.UTF8);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		CommonUtil.printOne("执行：TestFilter implements Filter.destroy()");
	}

}
