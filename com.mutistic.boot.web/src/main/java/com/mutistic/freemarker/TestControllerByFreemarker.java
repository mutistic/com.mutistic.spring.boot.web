package com.mutistic.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program 演示 Freemarker视图文件
 * @description 
 * @author mutisitic
 * @date 2018年7月26日
 */
@Controller
//@RequestMapping("/testControllerByFreemarker/")
public class TestControllerByFreemarker {
	
	/**
	 * Freemarker使用：
	 * 1、pom.xml：引入freemarker插件：spring-boot-starter-freemarker
	 * 2、根目录配置ftl视图：默认路径：src/main/resources/templates 等，参考FreeMarkerProperties.DEFAULT_TEMPLATE_LOADER_PATH
	 * 2.1、配置文件可以通过参数spring.freemarker.template-loader-path配置视图路径
	 * 3、Controller可以使用@Controller注解，不能使用@RestController注解，不建议使用@RequestMapping注解配置路径前缀
	 * 4、接口方法不能使用 @ResponseBody注解 
	 * 5、接口返回格式：文件路径/文件名.ftl   (字符串)
	 */
	
	
	/**
	 * @description 演示返回Freemarker视图
	 * @author mutisitic
	 * @date 2018年7月26日
	 * @return
	 */
	@GetMapping(value = "/testControllerByFreemarker/showFreemarker", produces = "text/html;charset=UTF-8")
	public String showFreemarker(Model mode) {
		StringBuffer val = new StringBuffer("\n1、演示返回Freemarker视图");
		val.append("\n【Controller：使用@Controller。使用@RequestMapping(\"/showFreemarker/\")指定默认路径】");
		val.append("\n【方法：@GetMapping(value = \"showJSP\")指定方法访问路径，和访问方式GET】");
		val.append("\n【请求方式：RequestMethod.GET】");
		val.append("\n【参数信息： @RequestParam()指定访问参数");
		val.append("\n【参数值： 无参数】");
		val.append("\n【返回类型：JSP文件相对地址及文件名】");
		val.append("\n【PS1：返回JSP文件时，类不能使用@RestController，方法不能使用 @ResponseBody注解】");
		val.append("\n【PS2：pom.xml需要引入freemarker相关的组件:spring-boot-starter-freemarker】");
		val.append("\n【PS3：文件等资源默认路径在 classpath:/templates/(即:src/resources/templates下)】");
		val.append("\n【PS4：默认路径:参考类的:org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties.DEFAULT_TEMPLATE_LOADER_PATH】");
		val.append("\n【PS5：默认view前缀:参考FreeMarkerProperties.DEFAULT_PREFIX，默认view后缀:参考FreeMarkerProperties.DEFAULT_SUFFIX】");
		val.append("\n【PS6：pom.xml具体依赖:\n"
				+ "<!-- 配合：TestControllerByFreemarker 演示返回ftl文件所需要的Freemarker组件: 用于编译jsp -->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-freemarker</artifactId>\r\n" + 
				"		</dependency>】");
		
		System.out.println(val.toString());
		
		
		mode.addAttribute("print", val.toString());
		return "freemarker";
	}
}
