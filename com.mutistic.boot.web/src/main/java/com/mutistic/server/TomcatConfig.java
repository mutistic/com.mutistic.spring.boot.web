package com.mutistic.server;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import com.mutistic.utils.CommonUtil;

/**
 * @program 可以通过 AbstractServletWebServerFactory 直接创建
 *          TomcatServletWebServerFactory @Bean 完成Tomcat servlet的配置信息
 * @description
 * @author mutisitic
 * @date 2018年7月30日
 */
//@SpringBootConfiguration
public class TomcatConfig {

	/**
	 * 配置Servlet容器 参考AbstractConfigurableWebServerFactory接口及实现类
	 * 配置Tomcat信息
	 	一、通过properties配置
			#配置server(默认web容器是：Tomcat)信息:参考类org.springframework.boot.autoconfigure.web.ServerProperties
			# 设置端口号
			server.port=8888
			## 配置访问路径
			server.servlet.context-path=/mutistic
			## 配置访问IP
			server.address=192.168.113
			##配置日志：参考 ServerProperties.Tomcat.Accesslog 参考：https://www.cnblogs.com/shamo89/p/8134865.html
			## 开启日志
			server.tomcat.accesslog.enabled=true
			## 配置日志所在路径：默认：C:\Users\xxx\AppData\Local\Temp\tomcat.xxxxxxx.port\logs
			server.tomcat.accesslog.directory=/logs/
		
		二、通过WebServerFactoryCustomizer<TomcatServletWebServerFactory>接口配置：
		2.1、实现 WebServerFactoryCustomizer<TomcatServletWebServerFactory> 接口
		2.2、重写WebServerFactoryCustomizer.customize() 方法
		2.3、通过 TomcatServletWebServerFactory 内部方法配置servlet信息
		2.4、通过TomcatServletWebServerFactory.addConnectorCustomizers()方法配置TomcatConnectorCustomizer信息
		2.4.1、实现TomcatConnectorCustomizer接口
		2.4.2、重写 TomcatConnectorCustomizer.customize()方法
		2.4.3、通过 Connector 内部方法配置链接信息
		2.4.4、将TomcatConnectorCustomizer接口实例对象传入到TomcatServletWebServerFactory中
		2.5、通过TomcatServletWebServerFactory.setErrorPages() 设置错误页信息
		2.6、通过TomcatServletWebServerFactory.addInitializers() 设置ServletContextInitializer信息
		2.6.1、通过ServletContextInitializer 内部方法可以设置 Servlet context信息
		2.7、通过TomcatServletWebServerFactory.setContextValves()方法设置AccessLogValve信息，注意日志是通过异步写入的
		2.8、通过 @Component 将WebServerFactoryCustomizer实现类注册到spring容器中
		
		三、通过@SpringBootConfiguration配置类直接创建 TomcatServletWebServerFactory bean
		3.1、方法可以返回 AbstractServletWebServerFactory抽象接口类
		3.2、实例化 TomcatServletWebServerFactory 对象，配置serlvet信息，返回即可
	 */
	
	
	/**
	 * @description 
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @return
	 */
	@Bean
	public AbstractServletWebServerFactory createrTomcatServer() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setPort(8888); // 配置默认端口
		factory.setUriEncoding(StandardCharsets.UTF_8);// 设置URL 编码格式

		// 配置 ServletContextInitializer Servlert 上下文初始化器
		factory.addInitializers((servletContext) -> {
			CommonUtil.printOne(
					"servletContext ===== 启动可以通过 AbstractServletWebServerFactory 直接创建  TomcatServletWebServerFactory @Bean 完成Tomcat servlet的配置信息");
		});

		Set<ErrorPage> pageSet = new HashSet<ErrorPage>();
		pageSet.add(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html")); // 配置404错误状态码，跳转的界面
		factory.setErrorPages(pageSet); // 配置错误页
		return factory;
	}

}
