package com.mutistic.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program 演示 AOP
 * @description 
 * @author mutisitic
 * @date 2018年7月31日
 */
@RestController
@RequestMapping("/testControllerByAop/")
public class TestControllerByAop {

	@Autowired
	private ITestProxy testProxy;
	
	/**
	 * @description 演示AOP 
	 * @author mutisitic
	 * @date 2018年7月31日
	 */
	@GetMapping(value = "showBuAOP")
	public String showBuAOP() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("1、AOP的使用步骤：");
		val.append("\n[pom.xml：添加AOP依赖，默认开启AOP功能：\n"
				+ "<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-aop</artifactId>\r\n" + 
				"		</dependency>\n"
				+ "实际上是使用aspectjweaver依赖：\r\n" + 
				"<dependency>\r\n" + 
				"  <groupId>org.aspectj</groupId>\r\n" + 
				"  <artifactId>aspectjweaver</artifactId>\r\n" + 
				"  <version>1.8.13</version>\r\n" + 
				"  <scope>compile</scope>\r\n" + 
				"</dependency>]");
		val.append("\n[Class：实现@Aspect注解，同时实现@Component注解将其注册到spring容器中]");
		val.append("\n[方法：实现 定义通知方式 的注解：AOP五种通知方式：@Before、@After、@AfterReturning、@AfterThrowing、@Around]");
		val.append("\n[定义切入点：通过 通知方式的注解value字段execution指定]");
		val.append("\n[execution表达式：execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)]");
		val.append("\n[参数信息：选填参数 org.aspectj.lang.JoinPoint：可以获取]");
		val.append("\n[@Before：前置通知：选填参数org.aspectj.lang.JoinPoint]");
		val.append("\n[@After：后置通知：选填参数org.aspectj.lang.JoinPoint]");
		val.append("\n[@AfterReturning：返回通知：选填参数org.aspectj.lang.JoinPoint，通知方式注解通过 returning 获取返回参数]");
		val.append("\n[@AfterThrowing：异常通知：选填参数org.aspectj.lang.JoinPoint，通知方式注解通过 throwing 获取指定异常]");
		val.append("\n[@Around：环绕通知：参数org.aspectj.lang.ProceedingJoinPoint]");
		val.append("\n[AOP：参考："+ AopAutoConfiguration.class +"，默认启用AOP功能]");
		val.append("\n[属性配置：spring.aop.auto配置是否启用AOP功能，默认true启用，  false为不启用]");
		val.append("\n[属性配置：spring.aop.proxy-target-class配置接口使用的代理模式，默认false=JDK动态代理模式：com.sun.proxy"
				+ "设置为true=CGLIB代理模式：EnhancerBySpringCGLIB，如果不是接口Spring默认使用CGLIB代理模式]");
		val.append("\n[代理接口："+ testProxy.getClass() +"]");

		testProxy.showProxy();
		System.out.println(val.toString());
		return val.toString();
	}
	
	
}
