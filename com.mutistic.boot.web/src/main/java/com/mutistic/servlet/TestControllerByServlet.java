package com.mutistic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program Servlet3的 @WebServlet 注解 实现 HttpServlet
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
@SuppressWarnings("serial")
@WebServlet("/testHttpServlet.do")
//@WebServlet(urlPatterns="/testHttpServlet.do")
//@WebServlet(name = "myServlet", urlPatterns="/testHttpServlet.do")
public class TestControllerByServlet extends HttpServlet {

	/**
	 * 一、Servlet使用方式1-Servlet3注解方法：
	 * 1、继承HttpServlet类，实现@WebServlet注解
	 * 1.1、urlPatterns：指定访问URL，一般自定义Servlet访问后缀为： .do或 .action
	 * 1.2、根据访问方式重写 doGet(), doPost()等方法
	 * 1.3、请求信息封装在：HttpServletRequest中
	 * 1.4、返回信息封装在：HttpServletResponse中
	 * 1.5、Spring boot run 入口需要开启 Servlet扫描注解： @ServletComponentScan
	 * 
	 * 2、如果需要Filter过滤器， 实现Filter接口，实现@WebFilter接口
	 * 2.1、重写 init()、doFilter()、destroy()接口，重写时要删除super.doGet(req, resp);
	 * 2.1.1、init：过滤器初始化时执行
	 * 2.1.2、doFilter：过滤到配置的请求时执行，重写后要调用 chain.doFilter(request, response);
	 * 2.1.3、destroy：过滤器销毁时执行
	 * 2.2、urlPatterns：设置需要过滤的请求。
	 * 
	 * 3、如果需要ServletContextListener监听器，实现ServletContextListener接口，实现@WebListener注解
	 * 3.1、重写contextInitialized()，contextDestroyed()方法
	 * 3.1.1、contextInitialized：context初始化时执行
	 * 3.1.2、contextDestroyed：context销毁时执行
	 */
	
	/**
	 * 二、Servlet使用方式2-通过Configuration配置类创建bean（建议用注解方式）：
	 * 1、继承HttpServlet类
	 * 1.1、Configuration类：通过 ServletRegistrationBean注册 HttpServlet子类
	 * 1.2、可以通过 ServletRegistrationBean.setServlet： 配置 HttpServlet子类实例
	 * 1.3、可以通过 ServletRegistrationBean.addUrlMappings：配置访问URL
	 * 
	 * 2、如果需要Filter过滤器
	 * 2.1、重写 init()、doFilter()、destroy()接口
	 * 2.2、Configuration类：通过 FilterRegistrationBean注册 Filter实现类
	 * 2.3、可以通过 FilterRegistrationBean.setFilter： 配置 Filter实现类实例
	 * 2.4、可以通过 FilterRegistrationBean.setUrlPatterns：配置过滤URL
	 * 
	 * 3、如果需要ServletContextListener监听器，实现ServletContextListener接口
	 * 3.1、重写contextInitialized()，contextDestroyed()方法
	 * 3.2、Configuration类：通过 ServletListenerRegistrationBean注册 ServletContextListener实现类实例
	 * 3.3、可以通过 ServletListenerRegistrationBean.setListener： 配置 ServletContextListener实现类实例
	 */
	
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
//		super.doGet(req, resp); //  使用 Servlet时 注意要删掉 super.doGet(req, resp);
		
		StringBuffer val = new StringBuffer("\n1、演示 HttpServlet - doGet方法");
		val.append("\n【Servlet：继承 HttpServlet，实现 @WebServlet(\"/testHttpServlet.do\") 注解】");
		val.append("\n【方法：重写HttpServlet的doGet()，指定访问方式 GET】");
		val.append("\n【请求方式：GET】");
		val.append("\n【参数信息：通过javax.servlet.http.HttpServletRequest 获取参数");
		val.append("\n【返回类型：通过javax.servlet.http.HttpServletResponse 返回数据】");
		val.append("\n【PS1：@WebServlet注解中 urlPatterns指定访问URL】");
		val.append("\n【PS2：启动 main方法时，要开启 @ServletComponentScan Servlet扫描注解，在 @SpringBootApplication之上】");
		val.append("\n【PS3：重写HttpServlet的doGet()方法时，要删除 super.doGet(req, resp); 】");
		val.append("\n【PS4：请求方式有 doGet() doPost() doPut() doDelete() 等; 】");
		
		resp.getWriter().print(val.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer val = new StringBuffer("\n1、演示 HttpServlet - doGet方法");
		val.append("\n【Servlet：继承 HttpServlet，实现 @WebServlet(\"/testHttpServlet.do\") 注解】");
		val.append("\n【方法：重写HttpServlet的doPost()，指定访问方式 POST】");
		val.append("\n【请求方式：POST】");
		val.append("\n【参数信息：通过javax.servlet.http.HttpServletRequest 获取参数");
		val.append("\n【返回类型：通过javax.servlet.http.HttpServletResponse 返回数据】");
		val.append("\n【PS1：@WebServlet注解中 urlPatterns指定访问URL】");
		val.append("\n【PS2：启动 main方法时，要开启 @ServletComponentScan Servlet扫描注解，在 @SpringBootApplication之上】");
		val.append("\n【PS3：重写HttpServlet的doPost()方法时，要删除 super.doPost(req, resp); 】");

		resp.getWriter().print(val.toString());
	}

	
	
}
