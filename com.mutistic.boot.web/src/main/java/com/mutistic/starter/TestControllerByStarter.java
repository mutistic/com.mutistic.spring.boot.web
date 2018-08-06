package com.mutistic.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program 创建starter项目并引用
 * @description 
 * @author mutisitic
 * @date 2018年7月31日
 */
@RestController
@RequestMapping("/testControllerByStarter/")
public class TestControllerByStarter {
	
	/**
	 * @description 创建starter项目并引用
	 * @author mutisitic
	 * @date 2018年7月31日
	 */
	@GetMapping(value = "showByStarter")
	public String showByStarter() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------\n");
		val.append("\n[一、创建starter项目并引用的步骤]");
		val.append("\n[1、starter项目pom.xml：建议创建maven项目，此项目演示redis配置，故需要引入jedis依赖：\n"
				+ "<dependency>\r\n" + 
				"			<groupId>redis.clients</groupId>\r\n" + 
				"                <artifactId>jedis</artifactId>\r\n" + 
				"		</dependency>]");
		
		val.append("\n[2、创建properties类（RedisProperties）：可实现@ConfigurationProperties注解，指定prefix，eg:prefix=\"redis\"]，定义属性及get/set方法");
		
		val.append("\n[3、创建configuration类（RedisAutoConfiguration）：1、实现@Configuration或@SpringBootConfiguration注解，\n"
				+ "2、实现@EnableConfigurationProperties注解\n"
				+ "3、@EnableConfigurationProperties注解需要指定@ConfigurationProperties的properties类"
				+ "4、通过 @ConditionalOnClass 配置 Jedis.class 优化configuration配置\n"
				+ "@SpringBootConfiguration\r\n" + 
				"@EnableConfigurationProperties\r\n" + 
				"@ConditionalOnClass(Jedis.class)\r\n" + 
				"public class RedisConfiguration { } ]");
		
		val.append("\n[4、configuration类创建Jedis bean（jedis）：1、入参RedisProperties\n"
				+ "2、创建Jedis实例传入 host和port信息\n"
				+ "3、通过@ConditionalOnMissingBean 配置 Jedis 优化bean的创建\n	"
				+ "@Bean\r\n" + 
				"	@ConditionalOnMissingBean\r\n" + 
				"	public Jedis jedis(RedisProperties properties) {\r\n" + 
				"		return new Jedis(properties.getHost(), properties.getPort());\r\n" + 
				"	}]");
		
		val.append("\n[5、starter项目启动configuration类：\n"
				+ "5.1、通过@Import实现开启configuration类(@EnableRedis)：@Import导入RedisAutoConfiguration类，然后@SpringBootApplication类实现@EnableRedis注解\n"
				+ "@Target(ElementType.TYPE)\r\n" + 
				"@Retention(RetentionPolicy.RUNTIME)\r\n" + 
				"@Documented\r\n" + 
				"@Import(RedisConfiguration.class)\r\n" + 
				"public @interface EnableRedis { }"
				+ "5.2、可以通过resoureces/META-INF/spring.factories配置：\n"
				+ "org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.mutistic.starter.RedisConfiguration]");
		
		val.append("\n[6、引用方pom.xml：引用创建redis-starter的项目：eg：\n"
				+ "<dependency>\r\n" + 
				"			<groupId>com.mutistic</groupId>\r\n" + 
				"			<artifactId>com.mutistic.boot.web.redis</artifactId>\r\n" + 
				"			<version>0.0.1-SNAPSHOT</version>\r\n" + 
				"		</dependency>]");
		
		val.append("\n[7、引用方properties：可以配置redis.host，redis.port的信息，是可以传递给redis-starter的RedisProperties]");
		
		val.append("\n[8、引用方就可以获取Jedis完成redis功能]");
		
		System.out.println(val.toString());
		return val.toString();
	}
	
}
