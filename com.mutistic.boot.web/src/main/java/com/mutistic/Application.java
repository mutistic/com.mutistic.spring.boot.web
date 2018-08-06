package com.mutistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.jdbc.PrintJDBCInfo;
import com.mutistic.utils.CommonUtil;

@ServletComponentScan
@SpringBootApplication//(exclude = ErrorMvcAutoConfiguration.class)
//@EnableTransactionManagement // 开启事务
//@EnableAspectJAutoProxy // 开启AOP
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
//		args = setLogLevel(args); // 配合 TestControllerByLog 演示 启动参数设置日志级别 
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		PrintJDBCInfo.showJDBCInfo(context);
		
		log.info("\nApplication runing========= ");
	}
	
	/**
	 * @description 配合 TestControllerByLog 演示 启动参数设置日志级别 
	 * @author mutisitic
	 * @date 2018年8月1日
	 * @return
	 */
	private static String[] setLogLevel(String[] args) {
		List<String> argsList = new ArrayList<String>() ;
		if(CommonUtil.isNotEmpty(args)) {
			for (String string : args) {
				argsList.add(string);
			}
		}
		argsList.add("--debug"); // 设置日志级别
//		argsList.add("--debug=true");
		
		return argsList.toArray(args);
	}

}
