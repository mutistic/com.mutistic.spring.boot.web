package com.mutistic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program 演示 @Controller
 * @description
 * @author mutisitic
 * @date 2018年7月25日
 */
@Controller
public class TestController {
	/**
	 * @description 演示 @RequestMapping + @ResponseBody 访问接口
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@RequestMapping(value = "/testControlle/testRequestMapping")//, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String testRequestMapping() {
		StringBuffer val = new StringBuffer("\n1、演示 @Controller + @RequestMapping + @ResponseBody 访问接口");
		val.append("\n[Controller:使用@Controller]");
		val.append("\n[方法:使用@RequestMapping(value = \"/testControlle/testRequestMapping\")指定方法访问路径]");
		val.append("\n[方法:使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求类型:@RequestMapping支持多种请求方式如get/post/put]");
		val.append("\n[参数信息:无参数]");
		val.append("\n[返回类型:String]");
		
		return val.toString();
	}

}
