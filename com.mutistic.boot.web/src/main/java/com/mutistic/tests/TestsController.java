package com.mutistic.tests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.CommonUtil;

/**
 * @program 配合 com.mutistic.test.controller.ControllerTests 测试 
 * @description 
 * @author mutisitic
 * @date 2018年8月4日
 */
@RestController
@RequestMapping("/testsController/")
public class TestsController {
	
	@GetMapping("showTest")
	public String showTest() {
		CommonUtil.printOne("使用TestRestTemplate.getForObject()调用接口");
		return "TestsController.showTest";
	}
	
	@GetMapping("showByParams")
	public String showByParams(@RequestParam("id") Long id) {
		CommonUtil.printOne("使用TestRestTemplate.getForObject()调用接口");
		return "TestsController.showByParams"+id;
	}
	
}
