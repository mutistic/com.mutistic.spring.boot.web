package com.mutistic.starter;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.Jedis;

/**
 * @program 创建 Jedis bend 配置类
 * @description
 * @author mutisitic
 * @date 2018年7月31日
 */
//@SpringBootConfiguration
//@EnableConfigurationProperties
//@ConditionalOnClass(Jedis.class)
public class RedisConfiguration {

	/**
	 * @description 创建 Jedis bean
	 * @author mutisitic
	 * @date 2018年7月31日
	 * @param properties
	 * @return
	 */
//	@Bean
//	@ConditionalOnMissingBean
//	public Jedis jedis(RedisProperties properties) {
//		return new Jedis(properties.getHost(), properties.getPort());
//	}

}
