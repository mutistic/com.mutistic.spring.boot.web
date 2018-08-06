package com.mutistic.test.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ConfigurationTests {
	
	@Bean
	public Runnable createrRunnable() {
		return () -> {};
	}
}
