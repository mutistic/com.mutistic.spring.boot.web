package com.mutistic.test.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutistic.jdbc.MyTestDao;

/**
 * @program 使用  @SpringBootTest 测试JdbcTemplate
 * @description 
 * @author mutisitic
 * @date 2018年8月2日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTests {
	
	@Autowired
	private MyTestDao myTestDao;
	
	@Test
	public void testInsert() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("使用  @SpringBootTest 测试JdbcTemplate：");
		val.append("\n[1、pom.xml添加test依赖：\n"
				+ "<dependency>\n" + 
				"			<groupId>org.springframework.boot</groupId>\n" + 
				"			<artifactId>spring-boot-starter-test</artifactId>\n" + 
				"			<scope>test</scope>\n" + 
				"		</dependency>]");
		
		val.append("\n[2、Test类：实现 @RunWith(SpringRunner.class) 注解，并且实现@SpringBootTest注解]");
		val.append("\n[3、方法：实现@Test注解]");
		val.append("\n[PS1：test包下的在正式环境是会被忽略掉的]");
		
		val.append("========以下是JdbcTemplate信息=========");
		val.append("\n[使用 JdbcTemplate通过execute() 方法执行sql语句完成数据插入]");
		val.append("\n[执行sql：" + myTestDao.insert(2l, "test") + "]");
		System.out.println(val.toString());
	}

}
