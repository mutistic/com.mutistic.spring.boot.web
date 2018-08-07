package com.mutistic.zokkeeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.mutistic.utils.CommonUtil;

public class BookZKMain {
	public static void main(String[] args) throws Exception {
		// 注册zk客户端
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryOneTime(1000));
		client.start(); // 启动zk
		client.blockUntilConnected(); // 链接

		ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		Collection<ServiceInstance<Object>> list = discovery.queryForInstances("address");

		List<String> serviceList = new ArrayList<String>();
		list.forEach((instances) -> {
			CommonUtil.printThree("获取zk服务注册信息：", JSON.toJSONString(instances));
			serviceList.add(instances.getAddress() + ":" + instances.getPort());
		});
		
		LoadBalance lb = new LoadBalance(serviceList);
		for (int i = 0; i < 10; i++) {
			// 调用接口
			RestTemplate rt = new RestTemplate();
			String url = "http://" + lb.choose() + "/bookController/queryById?id=1533384516863";
			CommonUtil.printTwo("获取RestTemplate请求的结果：" + url, rt.getForObject(url, String.class));
		}
	}
}
