package com.mutistic.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutistic.jdbc.MyTestDao;

/**
 * @program 使用 @TestConfiguration 配置测试环境生效的配置信息
 * @description
 * @author mutisitic
 * @date 2018年8月2日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigurationTests.class)
public class ApplicationContextTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void testShowTestBean() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用 @TestConfiguration 配置测试环境生效的配置信息：");
		val.append("\n[1、Configuration类：实现 @TestConfiguration注解，注意不能使用@Configuration或@SpringBootConfiguration注解配置类]");
		val.append("\n[2、@SpringBootTest类：通过classes属性配置Configuration类，否者@TestConfiguration不会生效：\n"
				+ "@SpringBootTest(classes = ConfigurationTests.class)]");

		val.append("========以下是ApplicationContext获取bean信息=========");
		val.append("\n[输出正常测试bean：" + context.getBeansOfType(MyTestDao.class) + "]");
		val.append("\n[输出测试环境bean：" + context.getBeansOfType(Runnable.class) + "]");
		System.out.println(val.toString());

	}

}
