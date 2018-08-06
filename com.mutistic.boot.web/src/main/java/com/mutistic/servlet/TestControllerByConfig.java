package com.mutistic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program 演示通过 ServletRegistrationBean 注册 Servlet bean
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
public class TestControllerByConfig extends HttpServlet {

	private static final long serialVersionUID = 7200867203868579517L;

	/**
	 * @description 演示 HttpServlet - doGet方法
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer val = new StringBuffer("\n1、演示通过 ServletRegistrationBean 注册 Servlet bean");
		val.append("\n【Servlet：继承 HttpServlet】");
		val.append("\n【方法：重写HttpServlet的doGet()，指定访问方式 GET】");
		val.append("\n【请求方式：GET】");
		val.append("\n【参数信息：通过javax.servlet.http.HttpServletRequest 获取参数");
		val.append("\n【返回类型：通过javax.servlet.http.HttpServletResponse 返回数据】");
		val.append("\n【PS1：在实现 @Configuration 类中创建  ServletRegistrationBean<TestHttpServletByConfig> bean】");
		val.append("\n【PS2：通过@Configuration 创建bean：不需要在spring boot main方法添加 @ServletComponentScan 开启servlet自动扫描注解，不需要在HttpServlet类实现@WebServlet注解】");
		val.append("\n【PS3：@Configuration 创建bean代码：\n"
				+ "	@Bean\r\n" + 
				"	public ServletRegistrationBean<TestHttpServletByConfig> createrTestHttpServletByConfig() {\r\n" + 
				"//		ServletRegistrationBean<TestHttpServletByConfig> reg = new ServletRegistrationBean<TestHttpServletByConfig>();\r\n" + 
				"//		reg.setServlet(new TestHttpServletByConfig());\r\n" + 
				"//		reg.addUrlMappings(\"/testHttpServletByConfig.do\");\r\n" + 
				"//		\r\n" + 
				"//		return reg;\r\n" + 
				"		\r\n" + 
				"		return new ServletRegistrationBean<TestHttpServletByConfig>(new TestHttpServletByConfig(), \"/testHttpServletByConfig.do\");\r\n" + 
				"		\r\n" + 
				"	}】");
		resp.getWriter().print(val.toString());
	}
}
