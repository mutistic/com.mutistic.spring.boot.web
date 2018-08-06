package com.mutistic.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//import com.alibaba.druid.pool.DruidDataSource;

/**
 * @program 使用 @SpringBootConfiguration 自定义DataSource bean
 * @description 
 * @author mutisitic
 * @date 2018年7月30日
 */
//@SpringBootConfiguration
//public class DataSourceConfig {
//  
//	@Autowired
//	private Environment env;
//	
//	@Bean
//	public DruidDataSource createrDruidDataSource() {
//		DruidDataSource db = new DruidDataSource();
//		// 可以直接设置 也可以通过 Environment 获取
//		db.setUrl(env.getProperty("spring.datasource.url"));
//		db.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//		db.setUsername(env.getProperty("spring.datasource.username"));
//		db.setPassword(env.getProperty("spring.datasource.password"));
//		return db;
//	}
//	
//}

public class DataSourceConfig { }
