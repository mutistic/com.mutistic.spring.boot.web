package com.mutistic.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mutistic.tests.TestsController;

/**
 * @program 使用 MockMvc 测试Controller
 * @description
 * @author mutisitic
 * @date 2018年8月4日
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TestsController.class)
public class ControllerTestsByMockMvc {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testShowTest() throws Exception {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 TestRestTemplate 测试Controller：");
		val.append("\n[1、类：实现@WebMvcTest注解，通过 controllers指定需要测试的Controller类]");
		val.append("\n[2、注入MockMvc(org.springframework.test.web.servlet.MockMvc) bean]");
		val.append("\n[3、MockMvc.perform()：调用接口：入参：MockMvcRequestBuilders]");
		val.append("\n[4、MockMvcRequestBuilders.get()：设置调用URL和请求方式，还有post()等请求方式]");
		val.append("\n[5、MockMvc.perform().andExpect()：设置预测返回结果]");
		val.append("\n[6、MockMvcResultMatchers.status().isOk()：预测接口访问成功：isOk() = HttpStatus.OK = 200]");
		val.append("\n[7、MockMvcResultMatchers.content().string(value)：设置预测返回结果类型为String且值为value]");
		val.append("\n[PS1：	@WebMvcTest不需要运行在Web环境下，但是需要自行执定Controller]");
		val.append("\n[PS2：	@WebMvcTest和@SpringBootTest不能同时使用]");
		val.append("\n[PS3：	@WebMvcTest不会加载整个spring bean，@SpringBootTest可以加载整个spring bean]");
		val.append("\n[PS4：	@SpringBootTest + @AutoConfigureMockMvc 可以注入 MockMvc bean]");
		System.out.println(val.toString());

		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showTest"))
				.andExpect(MockMvcResultMatchers.status().isOk()); // 预测结果是能够访问成功

		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showTest"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("TestsController.showTest")); // 预测接口返回
																								// TestsController.showTest
	}

	@Test
	public void testShowByParams() throws Exception {
		System.out.println("MockMvcRequestBuilders.get().param()：添加参数");
		Long id = 400l;
		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showByParams").param("id", id + ""))
				.andExpect(MockMvcResultMatchers.status().isOk()); // 预测结果是能够访问成功

		// 预测接口调用成功 isOk() = HttpStatus.OK = 200
		mockMvc.perform(MockMvcRequestBuilders.get("/testsController/showByParams").param("id", id + ""))
				.andExpect(MockMvcResultMatchers.content().string("TestsController.showByParams" + id)); // 预测结果是能够访问成功
	}

}
