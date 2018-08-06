package com.mutistic.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示 监控和度量的使用
 * @description 
 * @author mutisitic
 * @date 2018年8月1日
 */
@RestController
@RequestMapping("/testControllerByActuator/")
public class TestControllerByActuator {

	@GetMapping("showByActuator")
	public String showByActuator() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("演示 监控和度量的使用：");
		val.append("\n[1、pom.xml添加actuator依赖：\n"
				+ "<dependency>\r\n" + 
				"			<groupId>org.springframework.boot</groupId>\r\n" + 
				"			<artifactId>spring-boot-actuator</artifactId>\r\n" + 
				"		</dependency>]");
		
		val.append("\n[2、浏览器访问日志打印的actuator开放的端口信息：http://127.0.0.1:8888/actuator 下]");
		
		val.append("\n[3、spring boot 2.x版本默认开放：health和info端口]");
		val.append("\n[3.1、通过management.endpoint.xxxx.enable属性配置端口的开放和关闭eg：\n"
				+ "management.endpoint.shutdown.enabled=true]");
		val.append("\n[3.2、spring boot 2.x版本：属性配置调整到management.endpoint 下]");
		val.append("\n[3.3、spring boot 2.x版本：通过management.endpoints.web.exposure.include=* 设置开放端口，*表示所有，默认为health和info端口（实际上2.0.3以上版本并没有该属性，不生效）]");
		val.append("\n[3.4、spring boot 2.x版本：通过management.endpoints.web.exposure.exclude=shutdown 设置关闭端口（实际上2.0.3以上版本并没有该属性，不生效）]");
		
		val.append("\n[4、端口说明：参考https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html]");
		val.append("\n[4.1、auditevents：公开当前应用程序的审核事件信息。]");
		val.append("\n[4.2、beans：显示应用程序中所有Spring bean的完整列表。]");
		val.append("\n[4.3、conditions：显示在配置和自动配置类上评估的条件以及它们匹配或不匹配的原因。]");
		val.append("\n[4.4、configprops：显示所有的整理列表@ConfigurationProperties。]");
		val.append("\n[4.5、env：露出Spring的属性ConfigurableEnvironment。]");
		val.append("\n[4.6、flyway：显示已应用的任何Flyway数据库迁移。]");
		val.append("\n[4.7、health：显示应用健康信息。]");
		val.append("\n[4.8、httptrace：显示HTTP跟踪信息（默认情况下，最后100个HTTP请求 - 响应交换）。]");
		val.append("\n[4.9、info：显示任意应用信息。]");
		val.append("\n[4.10、loggers：显示和修改应用程序中记录器的配置。]");
		val.append("\n[4.11、liquibase：显示已应用的任何Liquibase数据库迁移。]");
		val.append("\n[4.12、metrics：显示当前应用程序的“指标”信息。]");
		val.append("\n[4.13、mappings：显示所有@RequestMapping路径的整理列表。]");
		val.append("\n[4.14、scheduledtasks：显示应用程序中的计划任务。]");
		val.append("\n[4.15、sessions：允许从Spring Session支持的会话存储中检索和删除用户会话。使用Spring Session对响应式Web应用程序的支持时不可用。]");
		val.append("\n[4.16、shutdown：允许应用程序正常关闭。]");
		val.append("\n[4.17、threaddump：执行线程转储。]");
		
		val.append("\n[PS1、经测试发现spring boot 2.x无法访问actuator信息，具体原因还未知]");
		
		CommonUtil.printOne(val.toString());
		return val.toString();
	}

}
