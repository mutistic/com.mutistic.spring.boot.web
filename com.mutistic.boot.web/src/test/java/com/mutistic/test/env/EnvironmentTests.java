package com.mutistic.test.env;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program 使用 EnvironmentTestUtils 配置测试环境生效的属性信息
 * @description
 * @author mutisitic
 * @date 2018年8月2日
 */
@RunWith(SpringRunner.class)
// @SpringBootTest
@SpringBootTest(properties = { "app.version=1.0.0" })
public class EnvironmentTests {

	@Autowired
	private ConfigurableEnvironment env;

	@Before
	public void initProperties() {
		EnvironmentTestUtils.addEnvironment(env, "app.name=spring boot web test");
	}

	@Test
	public void testShowValue() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");	
		val.append("使用 EnvironmentTestUtils 配置测试环境生效的属性信息：");
		val.append("\n[1、@SpringBootTest类：注入org.springframework.core.env.Environment]");
		val.append("\n[2、Test默认有限取test下的配置文件，取不到后会取主目录下的配置文件]");
		val.append("\n[3、可以通过@SpringBootTest的properties属性 配置参数]");
		val.append("\n[4、可以通过EnvironmentTestUtils添加配置参数：\n"
				+ "4.1、声明一个方法，实现org.junit.Before注解\n"
				+ "4.2、通过EnvironmentTestUtils.addEnvironment() 方法添加属性：\n"
				+ "EnvironmentTestUtils.addEnvironment(env, \"app.name=spring boot web test\")"
				+ "4.3、env类型为：org.springframework.core.env.ConfigurableEnvironment]");

		val.append("========以下是ConfigurableEnvironment获取properties信息=========");
		val.append("\n[获取配置参数server.port：" + env.getProperty("server.port") + "]");
		val.append("\n[获取@SpringBootTest配置的属性app.version：" + env.getProperty("app.version") + "]");
		val.append("\n[获取EnvironmentTestUtils.addEnvironment()添加的属性app.name：" + env.getProperty("app.name") + "]");
		System.out.println(val.toString());

	}

}
