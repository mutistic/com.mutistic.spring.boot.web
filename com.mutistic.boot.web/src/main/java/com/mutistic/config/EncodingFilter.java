package com.mutistic.config;

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
 * @program 定义编码格式过滤器
 * @description
 * @author mutisitic
 * @date 2018年7月27日
 */
//@WebFilter("/*") // 过滤所有请求
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		CommonUtil.printOne("执行：EncodingFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CommonUtil.printOne("执行：EncodingFilter.doFilter()");
		
		request.setCharacterEncoding(CommonUtil.UTF8);
		response.setCharacterEncoding(CommonUtil.UTF8);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		CommonUtil.printOne("执行：EncodingFilter.destroy()");
	}

}
