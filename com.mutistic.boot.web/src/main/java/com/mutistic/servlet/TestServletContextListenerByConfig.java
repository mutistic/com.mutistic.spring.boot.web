package com.mutistic.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mutistic.utils.CommonUtil;

/**
 * @program 自定义  ServletContextListener 监听器
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
public class TestServletContextListenerByConfig implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		StringBuffer val = new StringBuffer("\n1、演示 ServletContextListener - contextInitialized方法");
		val.append("\n【Listener：实现 ServletContextListener 接口】");
		val.append("\n【方法：重写ServletContextListener的contextInitialized()】");
		val.append("\n【PS1：通过Configuration创建bean：可以不实现@WebListener注解 )】");
		val.append("\n【PS2：@Configuration 创建bena代码：\n	"
				+ "@Bean\r\n" + 
				"	public ServletListenerRegistrationBean<TestServletContextListenerByConfig> createrTestServletContextListenerByConfig() {\r\n" + 
				"		return new ServletListenerRegistrationBean<TestServletContextListenerByConfig>(new TestServletContextListenerByConfig());\r\n" + 
				"	}】");
		System.out.println(val.toString());
		
		CommonUtil.printOne("执行：TestServletContextListenerByConfig implements ServletContextListener.contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommonUtil.printOne("执行：TestServletContextListenerByConfig implements ServletContextListener.contextDestroyed()");
	}

}
