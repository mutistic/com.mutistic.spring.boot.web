package com.mutistic.zokkeeper;

import java.util.List;

/**
 * @program 轮询算法 
 * @description 
 * @author mutisitic
 * @date 2018年8月6日
 */
public class LoadBalance {

	private int index = 0;
	private List<String> services;

	public LoadBalance(List<String> services) {
		super();
		this.services = services;
	}

	public String choose() {
		String service = services.get(index);
		index++;
		if(index >= services.size()) {
			index = 0;
		}
		
		return service;
	}

}
