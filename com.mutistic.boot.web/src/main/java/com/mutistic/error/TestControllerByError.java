package com.mutistic.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testControllerByError/")
public class TestControllerByError {
	
	/**
	 * @description 显示排除 ErrorMvcAutoConfiguration默认错误视图 后抛出异常显示的tomcat错误视图
	 * @author mutisitic
	 * @date 2018年7月30日
	 */
	@GetMapping(value = "showErrorView500")
	public void showErrorView(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) { }
		
		StringBuffer val = new StringBuffer("\n1、显示排除 ErrorMvcAutoConfiguration默认错误视图 后抛出异常显示的tomcat错误视图");
		val.append("\n[@SpringBootApplication:使用exclude排除掉 ErrorMvcAutoConfiguration.class]");
		val.append("\n[@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)]");
		val.append("\n[测试请求不存在的接口返回 404]");
		val.append("\n[测试方法返回异常 500]");
		val.append("\n[PS：ErrorMvcAutoConfiguration忽略加载后，需要重新设置 CharacterEncoding，否者返回的中文会乱码，不能通过 text/html：produces = \"text/html;charset=UTF-8\"设置]");
		System.out.println(val.toString());
		
		throw new RuntimeException(val.toString());
	}
	
	/**
	 * @description 自定义异常IllegalArgumentException返回错误页面的使用
	 * @author mutisitic
	 * @date 2018年7月30日
	 */
	@GetMapping(value = "showErrorArgs")
	public void showErrorArgs(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) { }
		
		
		StringBuffer val = new StringBuffer("\n2、自定义异常IllegalArgumentException返回错误页面的使用：");
		val.append("\n[1、实现 ErrorPageRegistrar 接口]");
		val.append("\n[2、重写 registerErrorPages() 方法：]");
		val.append("\n[3、通过 ErrorPageRegistry.addErrorPages() 方法添加 ErrorPage 错误界面]");
		val.append("\n[3.1、错误界面配置默认路径：src/main/resourece下]");
		val.append("\n[3.2、ErrorPage可以通过 HttpStatus：错误状态码配置错误界面]");
		val.append("\n[3.3、ErrorPage可以通过 Throwable：异常类配置错误界面]");
		System.out.println(val.toString());
		
		throw new IllegalArgumentException(val.toString());
	}

}
