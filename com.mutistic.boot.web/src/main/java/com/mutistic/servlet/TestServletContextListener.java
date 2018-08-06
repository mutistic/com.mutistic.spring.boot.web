package com.mutistic.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mutistic.utils.CommonUtil;

/**
 * @program Servlet3的 @WebListener 注解 实现ServletContextListener 监听器
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
@WebListener
public class TestServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		StringBuffer val = new StringBuffer("\n1、演示 ServletContextListener - contextInitialized方法");
		val.append("\n【Listener：实现 ServletContextListener 接口，实现 @WebListener 注解】");
		val.append("\n【方法：重写ServletContextListener的contextInitialized()】");
		System.out.println(val.toString());
		CommonUtil.printOne("执行：TestServletContextListener implements ServletContextListener.contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommonUtil.printOne("执行：TestServletContextListener implements ServletContextListener.contextDestroyed()");
	}

}
