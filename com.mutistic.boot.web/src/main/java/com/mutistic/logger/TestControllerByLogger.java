package com.mutistic.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示 slf4j Logger 的使用
 * @description 
 * @author mutisitic
 * @date 2018年8月1日
 */
@RestController
@RequestMapping("/testControllerByLogger/")
public class TestControllerByLogger {
	private static final Logger log = LoggerFactory.getLogger(TestControllerByLogger.class);

	@GetMapping("showByLogger")
	public String showByLogger() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("演示 slf4j Logger 的使用：");
		val.append("\n[1、pom.xml：spring-boot-starter-web的依赖默认 添加 slf4j的依赖：\n"
				+ "<dependency>\r\n" + 
				"      <groupId>org.springframework.boot</groupId>\r\n" + 
				"      <artifactId>spring-boot-starter-logging</artifactId>\r\n" + 
				"      <version>2.0.3.RELEASE</version>\r\n" + 
				"      <scope>compile</scope>\r\n" + 
				"    </dependency>]");
		val.append("\n[1.1、如果使用slf4j具体的依赖配置：需要排除 spring-boot-starter-logging 默认日志依赖\n"
				+ "<dependency>\r\n" + 
				"			<groupId>org.slf4j</groupId>\r\n" + 
				"			<artifactId>slf4j-log4j12</artifactId>\r\n" + 
				"		</dependency>]");
		
		val.append("\n[2、Logger：private static final Logger log = LoggerFactory.getLogger(TestControllerByLog.class);]");
		
		val.append("\n[3、日志级别level：参考org.slf4j.event.Level：OFF（关闭）< DEBUG（调试）< INFO（记录）< WARN（警告）< ERROR（错误） TRACE（跟踪）、FATAL（严重），一般使用：DEBUG、INFO、WARN、ERROR四种]");
		val.append("\n[3.1、默认日志级别：info]");
		val.append("\n[3.2、可以通过属性 logging.level.root 调整日志级别： 配置日志级别：（logging.level.root root表示所有的）（logging.level.* *表示具体包名或类名：logging.level.com.mutistic.utils.CommonUtil）\n" + 
				"logging.level.root=DEBUG]");
		val.append("\n[3.3通过启动参数args调整的日志级别只对spring boot内部的类生效：--debug 或 --debug=true]" );
		
		val.append("\n[4、可用通过配置文件配置：参考org.springframework.boot.logging.logback.LogbackLoggingSystem]");
		val.append("\n[4.1、logging.level：设置日志级别]");
		val.append("\n[4.2、logging.file：设置日志文件文件名及输入路径]");
		val.append("\n[4.3、logging.path：设置日志文件路径：默认日志文件名为：spring.log]");
		val.append("\n[4.4、日志输出格式参考：https://blog.csdn.net/qq496013218/article/details/69220907]");
		val.append("\n[4.4.1、logging.pattern.console：设置控制台日志输出格式：eg：logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss.sss} [%p][%t] [%c:%L] - %m%n]");
		val.append("\n[4.4.1、logging.pattern.file：设置文件日志输出格式]");
		val.append("\n[4.4.3、日志格式参数说明：\n"
				+ "%m 输出代码中指定的消息\n" + 
				"%p	输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL\n" + 
				"%r	输出自应用启动到输出该log信息耗费的毫秒数\n" + 
				"%c	输出所属的类目，通常就是所在类的全名\n" + 
				"%t	输出产生该日志事件的线程名\n" + 
				"%n	输出一个回车换行符，Windows平台为“\\r\\n”，Unix平台为“\\n”\n" + 
				"%d	输出日志时间点的日期或时间，默认格式为ISO-8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss.SSS}，\n" + 
				"%l	输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java:10)]");
		
		val.append("\n[5、spring boot 默认是使用logback.xml或logback-spring.xml文件设置日志信息，默认位置 src/resources，spring 推荐使用：logback-spring.xml]");
		val.append("\n[5.1、logback.xml配置参考：https://logback.qos.ch/manual/configuration.html\n]");
		val.append("\n[5.2、logback.xml或logback-spring.xml简单配置实例：\n"
				+ "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<configuration>\r\n" + 
				"	<!-- 日志输出到文件的配置：使用ch.qos.logback.core.ConsoleAppender 适配器-->\r\n" + 
				"	<appender name=\"fileLog\" class=\"ch.qos.logback.core.FileAppender\">\r\n" + 
				"		<!-- 配置输出文件位置及文件名:默认在项目目录下 -->\r\n" + 
				"		<file>logs/catalina.log</file>\r\n" + 
				"		<!-- 配置输出格式 -->\r\n" + 
				"		<encoder>\r\n" + 
				"			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n\r\n" + 
				"			</pattern>\r\n" + 
				"		</encoder>\r\n" + 
				"	</appender>\r\n" + 
				"\r\n" + 
				"	<!-- 日志输出到控制台的配置 -->\r\n" + 
				"	<appender name=\"consoleLog\"\r\n" + 
				"		class=\"ch.qos.logback.core.ConsoleAppender\">\r\n" + 
				"		<encoder>\r\n" + 
				"			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%p][%t] [%c:%L] - %m%n</pattern>\r\n" + 
				"		</encoder>\r\n" + 
				"	</appender>\r\n" + 
				"\r\n" + 
				"	<root level=\"INFO\">\r\n" + 
				"		<appender-ref ref=\"fileLog\" />\r\n" + 
				"		<appender-ref ref=\"consoleLog\" />\r\n" + 
				"	</root>\r\n" + 
				"</configuration>]");
		val.append("\n[5.3、日志文件默认大小为10M，不可修改]");
		
		val.append("\n[6、选用其他日志组件的配pom.xml配置：需要先排除掉默认logger依赖：以log4j2日志为例:\n"
				+ "<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-web</artifactId>\r\n" + 
				"			<exclusions>\r\n" + 
				"				<exclusion>\r\n" + 
				"					<groupId>org.springframework.boot</groupId>\r\n" + 
				"					<artifactId>spring-boot-starter-logging</artifactId>\r\n" + 
				"				</exclusion>\r\n" + 
				"			</exclusions>\r\n" + 
				"		</dependency>\r\n" + 
				"		<!-- 添加 log4j2 日志依赖：需要排除 spring-boot-starter-logging 默认日志依赖-->\r\n" + 
				"		<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-starter-log4j2</artifactId>\r\n" + 
				"		</dependency>]");
		val.append("\n[6.1、log4j2默认的日志配置文件名是log4j2.xml或log4j2-spring.xml：配置信息参考logback.xml]");
		
		CommonUtil.printOne(val.toString());
		CommonUtil.printOne("以下是打印日志信息");
		log.debug("==== debug log ====");
		log.warn("==== warn log ====");
		log.info("==== info log ====");
		log.error("==== error log ====");
		log.trace("==== trace log ====");
		
		return val.toString();
	}

}
