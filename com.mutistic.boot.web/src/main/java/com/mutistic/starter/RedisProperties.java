package com.mutistic.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program Redis Properties 配置文件类
 * @description 实现 @ConfigurationProperties 可以指定prefix
 * @author mutisitic
 * @date 2018年7月31日
 */
//@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

	private String host;
	private Integer port;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
