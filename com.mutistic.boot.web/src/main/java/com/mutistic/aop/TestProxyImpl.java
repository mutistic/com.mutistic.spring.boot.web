package com.mutistic.aop;

import org.springframework.stereotype.Component;

@Component
public class TestProxyImpl implements ITestProxy {

	@Override
	public String showProxy() {
		return "";
	}

}
