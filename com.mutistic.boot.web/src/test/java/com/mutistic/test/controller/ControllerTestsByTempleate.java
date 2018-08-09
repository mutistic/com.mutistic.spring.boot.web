package com.mutistic.test.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program 使用 TestRestTemplate 测试Controller
 * @description
 * @author mutisitic
 * @date 2018年8月4日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTestsByTempleate {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testShowTest() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 TestRestTemplate 测试Controller：");
		val.append("\n[1、@SpringBootTest注解类：使用webEnvironment属性配置为WebEnvironment.RANDOM_PORT：随机接口]");
		val.append("\n[2、注入TestRestTemplate(org.springframework.boot.test.web.client.TestRestTemplate) bean]");
		val.append("\n[3、TestRestTemplate.getForObject()：方法模拟请求Controller接口]");
		val.append("\n[4、getForObject()为Controller接口返回值]");
		val.append("\n[PS1、TestRestTemplate 需要在web环境下，才能注入进来]");
		System.out.println(val.toString());

		String context = testRestTemplate.getForObject("/testsController/showTest", String.class);
		Assert.assertEquals("TestsController.showTest", context);
	}

	@Test
	public void testShowByParams() {
		System.out.println("Get请求可以在请求路径上直接传参： url?key=value");
		Long id = 100l;
		String context = testRestTemplate.getForObject("/testsController/showByParams?id=" + id, String.class);
		Assert.assertEquals("TestsController.showByParams" + id, context);
	}

}
