package com.mutistic.jsp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mutistic.utils.ViewUtil;

/**
 * @program 演示返回.JSP文件
 * @description
 * @author mutisitic
 * @date 2018年7月25日
 */
@Controller
public class TestControllerByJSP {
	
	/**
	 * JSP使用：
	 * 1、pom.xml：引入jasper插件：tomcat-embed-jasper
	 * 2、配置jsp视图路径：src/main/webapp
	 * 2.1、配置文件可以通过参数spring.freemarker.template-loader-path配置视图前缀
	 * 3、Controller可以使用@Controller注解，不能使用@RestController注解，不建议使用@RequestMapping注解配置路径前缀
	 * 4、接口方法不能使用 @ResponseBody注解 
	 * 5、接口返回格式：文件路径/文件名.jsp   (字符串)
	 * 5.1、返回格式前缀可以通过：参数：spring.mvc.view.prefix 指定
	 * 5.2、返回格式后缀可以通过：参数：spring.mvc.view.suffix 指定
	 */
	
	/**
	 * @description 演示返回.JSP文件
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@PostMapping(value = "/testControllerByJSP/showJSP", produces = "text/html;charset=UTF-8")
	public String showJSP(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "passWord", required = false) String passWord) {
		StringBuffer val = new StringBuffer("\n1、演示返回.JSP文件");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@PostMapping(value = \"showJSP\")指定方法访问路径，和访问方式POST】");
		val.append("\n【请求方式：RequestMethod.POST】");
		val.append("\n【参数信息： @RequestParam()指定访问参数");
		val.append("\n【参数值： userName = " + userName + ", passWord = " + passWord + "】");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		val.append("\n【PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解】");
		val.append("\n【PS2：pom.xml需要引入jsp相关的组件:tomcat-embed-jasper】");
		val.append("\n【PS3：文件等资源默认路径在src/main/webapp下，需要新建webapp目录】");
		val.append("\n【PS4：spring.mvc.view.prefix 可以执行返回view的前缀】");
		val.append("\n【PS5：spring.mvc.view.suffix 可以指定返回view的后缀】");
		val.append("\n【PS6：pom.xml具体依赖:\\n"
				+ "<!-- 配合：TestControllerByJSP 演示返回jsp文件所需要的jsp组件: 用于编译jsp -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.apache.tomcat.embed</groupId>\r\n" + 
				"			<artifactId>tomcat-embed-jasper</artifactId>\r\n" + 
				"			<scope>provided</scope>\r\n" + 
				"		</dependency>】");
		System.out.println(val.toString());

		if ("root".equals(userName) && "root123".equals(passWord)) {
			return ViewUtil.getViewJsp("ok");
		}
		return ViewUtil.getViewJsp("fault");
	}

	/**
	 * @description 演示JSP界面使用 ${key}引入Model中变量
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@GetMapping(value = "/testControllerByJSP/showMode", produces = "text/html;charset=UTF-8")
	public String showMode(Model mode) {
		StringBuffer val = new StringBuffer("\n2、演示JSP界面使用 ${key}引入Model中变量");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showMode\")】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： org.springframework.ui.Model:可以设置参数返回给页面调用");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		System.out.println(val.toString());

		mode.addAttribute("print", val.toString());
		return  ViewUtil.getViewJsp("index");
	}

	
	/**
	 * @description 演示JSP界面使用 ${key}引入HttpServletRequest中变量
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@GetMapping(value = "/testControllerByJSP/showHttpServletRequest", produces = "text/html;charset=UTF-8")
	public String showHttpServletRequest(HttpServletRequest request) {
		StringBuffer val = new StringBuffer("\n2、演示JSP界面使用 ${key}引入HttpServletRequest中变量");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/testControllerByJSP/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showHttpServletRequest\")】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： javax.servlet.http.HttpServletRequest:可以设置参数返回给页面调用");
		val.append("\n【返回类型：JSP文件name】");
		System.out.println(val.toString());

		request.setAttribute("print", val.toString());
		return  ViewUtil.getViewJsp("index");
	}
}
