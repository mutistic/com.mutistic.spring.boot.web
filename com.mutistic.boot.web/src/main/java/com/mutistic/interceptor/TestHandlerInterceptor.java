	 package com.mutistic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mutistic.utils.CommonUtil;

/**
 * @program 实现 HandlerInterceptor 接口 定制拦截器
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
public class TestHandlerInterceptor implements HandlerInterceptor {

	/**
	 * @description 在Controller请求之前触发（一般用于登陆验证）
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.preHandle()[在请求之前触发（一般用于登陆验证）]" + handler);
		return true;
	}

	/**
	 * @description 在Controller请求之后，页面未渲染时触发（一般用于业务逻辑等）
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.postHandle()[在请求之后，页面未渲染时触发（一般用于业务逻辑等）]");
	}

	/**
	 * @description Controller请求完毕，页面渲染完成触发（一般用于清理资源）
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		CommonUtil.printOne("执行：TestHandlerInterceptor implements HandlerInterceptor.afterCompletion()[请求完毕，页面渲染完成触发（一般用于清理资源）]");
	}

}
