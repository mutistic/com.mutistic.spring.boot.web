package com.mutistic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program 演示 @Controller + @RequestMapping
 * @description
 * @author mutisitic
 * @date 2018年7月25日
 */
@Controller
@RequestMapping("/testControllerByMapping/")
public class TestControllerByMapping {

	/**
	 * 请求参数的使用： 1、通过@RequestParam获取请求参数： 1.1、value字：请求URL中参数的绑定值：name
	 * 1.2、method：指定请求方式：参考org.springframework.web.bind.annotation.RequestMethod
	 * 1.3、required：参数是否必填（默认true）：true必填，false非必填。
	 * 1.4、defaultValue：设置默认值。当请求URL无改参数时，生效
	 * 1.5、produces：设置请求格式及编码格式
	 * 
	 * 
	 * 2、通过@PathVariable获取请求URL中的参数 2.1、请求URL参数格式：{key}
	 * 
	 * 3、通过Servlet API:HttpServletRequest获取请求参数：
	 */

	/**
	 * @description 演示 @Controller + @RequestMapping + @ResponseBody访问接口
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@RequestMapping(value = "testRequestMapping", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String testRequestMapping() {
		StringBuffer val = new StringBuffer("1、演示 @Controller + @RequestMapping + @ResponseBody访问接口");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append("\n[方法：使用@RequestMapping(value = \"testRequestMapping\")指定方法访问路径]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：@RequestMapping支持多种请求方式如get/post/put]");
		val.append("\n[参数信息：无参数]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	/**
	 * @description 演示 @RequestMapping 通过 @RequestParam 设置参数(默认参数必填)
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@RequestMapping(value = "getRequestMapping", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getRequestMapping(@RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("2、演示 @RequestMapping 通过 @RequestParam 设置参数(默认参数必填)");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append(
				"\n[方法：@RequestMapping(value = \"getRequestMapping\", method = RequestMethod.GET)指定方法访问路径，和访问方式GET]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append("\n[参数信息： @RequestParam(\"name\") String name)指定访问参数，默认为必填");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	/**
	 * @description 演示 @RequestMapping 通过 required 设置参数非必填
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@RequestMapping(value = "postRequestMapping", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postRequestMapping(@RequestParam(value = "name", required = false) String name) {
		StringBuffer val = new StringBuffer("3、演示 @RequestMapping 通过 required 设置参数非必填");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\"/testControllerByMapping/\")指定默认路径]");
		val.append(
				"\n[方法：@RequestMapping(value = \"postRequestMapping\", method = RequestMethod.POST)指定方法访问路径，和访问方式POST]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.POST]");
		val.append("\n[参数信息： @RequestParam(value = \"name\", required = false) String name指定访问参数，required设置是否必填");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	/**
	 * @description 演示 @GetMapping 通过 defaultValue 指定参数默认值
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@GetMapping(value = "getMapping", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMapping(@RequestParam(value = "name", required = false, defaultValue = "admin") String name) {
		StringBuffer val = new StringBuffer("5、演示 @GetMapping 通过 defaultValue 指定参数默认值");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\\\"/testControllerByMapping/\\\")指定默认路径]");
		val.append("\n[方法：使用@GetMapping(\\\"getMapping\\\"))指定访问路径和请求方式GET]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.GET]");
		val.append(
				"\n[参数信息：@RequestParam(value = \"name\", required = false, defaultValue=\"admin\") String name 指定访问参数，required设置是否必填，defaultValue设置默认值");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		return val.toString();
	}

	/**
	 * @description 演示 @PostMapping 通过 @PathVariable 请求URL绑定参数
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@PostMapping(value = "postMapping/{name}", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postMapping(@PathVariable("name") String name) {
		StringBuffer val = new StringBuffer("6、演示 @PostMapping 通过 @PathVariable 请求URL绑定参数");
		val.append("\n[Controller：使用@Controller。使用@RequestMapping(\\\"/testControllerByMapping/\\\")指定默认路径]");
		val.append("\n[方法：使用@PostMapping(\"postMapping/{key}\")指定访问路径和请求方式POST]");
		val.append("\n[方法：使用@ResponseBody可以直接返回出去]");
		val.append("\n[请求方式：RequestMethod.POST]");
		val.append("\n[参数信息：@PathVariable(\"key\") String name 获取请求URL中绑定的参数key]");
		val.append("\n[参数值： name = " + name + "]");
		val.append("\n[返回类型：String]");
		val.append("\n[PS：spring 4.3的新特性@GetMapping @PostMapping @PutMapping @DeleteMapping 等注解可以直接指定具体的请求方式]");
		return val.toString();
	}

}
