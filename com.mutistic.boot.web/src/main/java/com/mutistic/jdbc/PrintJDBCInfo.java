package com.mutistic.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mutistic.utils.CommonUtil;

/**
 * @program 配置JDBC信息 
 * @description 
 * @author mutisitic
 * @date 2018年7月30日
 */
public class PrintJDBCInfo {
	
	/**
	 * @description 显示JDBC信息 
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @param context
	 */
	public static void showJDBCInfo(ConfigurableApplicationContext context) {
		CommonUtil.printOne("也可以使用 @SpringBootConfiguration 自定义DataSource bean");
		
		showInfo(context);
		CommonUtil.printTwo("自动装配的：org.springframework.jdbc.core.JdbcTemplate", context.getBean(JdbcTemplate.class));
		CommonUtil.printThree("可以通过 JdbcTemplate 实现操作数据库", null);
	}

	public static void showInfo(ConfigurableApplicationContext context) {
		try {
			DataSource db = context.getBean(DataSource.class);
			if(null == db) {
				return;
			}
			CommonUtil.printTwo("自动装配的：javax.sql.DataSource", db.getClass());
			
			Connection conn = db.getConnection();
			CommonUtil.printThree("创建的JDBC链接：java.sql.Connection", conn);
			StringBuffer val = new StringBuffer("\n显示JDBC信息 ");
			val.append("\n[DB name："+ conn.getCatalog() +"]");
			val.append("\n[pom.xml添加jdbc启动依赖：\n"
					+ "<dependency>\n" + 
					"			<groupId>org.springframework.boot</groupId>\n" + 
					"			<artifactId>spring-boot-starter-jdbc</artifactId>\n" + 
					"		</dependency>]");
			val.append("\n[pom.xml加入M有SQL驱动：\n"
					+ "<dependency>\n" + 
					"			<groupId>mysql</groupId>\n" + 
					"			<artifactId>mysql-connector-java</artifactId>\n" + 
					"		</dependency>]");
			val.append("\n[properties配置jdbc信息：\n"
					+ "#配置jdbc-dataSource信息：参考类：org.springframework.boot.autoconfigure.jdbc.DataSourceProperties\n" + 
					"## 配置jdbc驱动：使用mysql驱动\n" + 
					"spring.datasource.driver-class-name=com.mysql.jdbc.Driver\n" + 
					"## 配置 jdbc url\n" + 
					"spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study\n" + 
					"## 配置 jdbc 用户名\n" + 
					"spring.datasource.username=root\n" + 
					"## 配置 jdbc 密码\n" + 
					"spring.datasource.password=root");
			System.out.println(val.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
