package com.mutistic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.HttpServletUtil;

/**
 * @program 演示 @RestController
 * @description
 * @author mutisitic
 * @date 2018年7月25日
 */
@RestController
@RequestMapping("/testRestController/")
public class TestRestController {

	/**
	 * @description 演示@RestController + @GetMapping：无需方法在添加 @ResponseBody注解
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@GetMapping(value = "getMapping", produces = "text/html;charset=UTF-8")
	public String getMapping() {
		StringBuffer val = new StringBuffer("1、演示@RestController + @GetMapping：无需方法在添加 @ResponseBody注解");
		val.append("\n[Controller：使用@RestController。@RequestMapping(\"testRestController\") 指定默认访问路径]");
		val.append("\n[方法：使用@GetMapping(\\\"getMapping\\\"))指定访问路径和请求方式GET]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息：无参数]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}
	
	/**
	 * @description 演示入参时注入servler的API：HttpServletRequest参数
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@GetMapping(value = "showHttpServletRequest")
	public String showRequest(HttpServletRequest request, HttpServletResponse response) { 
		System.out.println(HttpServletUtil.getIPAddress(request));
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) { }
		
		StringBuffer val = new StringBuffer("2、演示入参时注入servler的API：HttpServletRequest参数");
		val.append("\n[Controller：使用@RestController。@RequestMapping(\"testRestController\") 指定默认访问路径]");
		val.append("\n[方法：使用@GetMapping(\\\"showRequest\\\"))指定访问路径和请求方式GET]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息：javax.servlet.http.HttpServletRequest]");
		val.append("\n[获取客户端IP："+ HttpServletUtil.getIPAddress(request) +"]");
		val.append("\n[参数值："+ request.toString() +"]");
		val.append("\n[HttpServletRequest:remoteHost："+ request.getRemoteHost() +"]");
		val.append("\n[HttpServletRequest:localPort："+ request.getLocalPort() +"]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

}
