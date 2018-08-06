package com.mutistic.server;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.AccessLogValve;
import org.apache.catalina.valves.Constants;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @program 通过 WebServerFactoryCustomizer<TomcatServletWebServerFactory> 自定义  server - Tomcat的配置信息
 * @description
 * @author mutisitic
 * @date 2018年7月30日
 */
//@Component
public class TomcatServerCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	/**
	 * @description 
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @param factory
	 * @see org.springframework.boot.web.server.WebServerFactoryCustomizer#customize(org.springframework.boot.web.server.WebServerFactory)
	 */
	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		/**
		 * 异步写入
		 */
		factory.setPort(8888); // 配置默认端口
		factory.setUriEncoding(StandardCharsets.UTF_8);// 设置URL 编码格式
		factory.setContextValves(getAccesslog()); // 配置日志文件信息
		factory.addConnectorCustomizers(new TomcatConnector());
//		factory.setErrorPages(pageSet); //配置错误页
	}

	/**
	 * @description 配置日志文件信息
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @return
	 */
	private List<AccessLogValve> getAccesslog() {
		List<AccessLogValve> logs = new ArrayList<>();

		AccessLogValve log = new AccessLogValve();
		log.setEnabled(true); // 开启日志
		log.setPattern(Constants.AccessLog.COMMON_ALIAS);
		log.setPrefix("springboot-access-log"); // 设置日志文件前缀
		log.setSuffix(".log"); // 设置日志文件后缀
		log.setDirectory("/logs"); // 配置日志所在路径

		logs.add(log);
		return logs;
	}

}
