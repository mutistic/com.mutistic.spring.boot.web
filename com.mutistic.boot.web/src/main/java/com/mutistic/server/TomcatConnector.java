package com.mutistic.server;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;

/**
 * @program 使用TomcatConnectorCustomizer 接口 设置Tomcat链接信息
 * @description 
 * @author mutisitic
 * @date 2018年7月30日
 */
public class TomcatConnector implements TomcatConnectorCustomizer {

	@Override
	public void customize(Connector connector) {
		if(null != connector) {
			if(connector.getProtocolHandler() != null && Http11NioProtocol.class == connector.getProtocolHandler().getClass()) {
				Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
				protocol.setMaxConnections(100); // 设置最大链接数
				protocol.setMaxThreads(50); //设置最大线程数
				// ... 设置链接的其他信息
			}
		}
	}

}
