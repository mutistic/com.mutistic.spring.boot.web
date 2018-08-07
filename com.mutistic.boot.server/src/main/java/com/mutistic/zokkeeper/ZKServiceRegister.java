package com.mutistic.zokkeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @program ZK注册服务
 * @description
 * @author mutisitic
 * @date 2018年8月6日
 */
@Component
public class ZKServiceRegister implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(ZKServiceRegister.class);

	@Value("${zookeeper.address}")
	private String zkAddress;

	/**
	 * @description
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param args
	 * @throws Exception
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// 注册zk客户端
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(400000));
		client.start(); // 启动zk
		client.blockUntilConnected(); // 链接

		// 注册 127.0.0.1:8888 服务节点：服务节点名称为：controller
		ServiceInstance<Object> instances = ServiceInstance.builder().name("address").address("127.0.0.1").port(8888)
				.build();
		// 注册 book 服务 路径为book
		ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		discovery.registerService(instances);
		discovery.start();
		log.info("zookepper 服务注册成功：127.0.0.1:8888");

		// 注册 192.168.16.113:8888 服务节点：服务节点名称为：controller
		ServiceInstance<Object> instances2 = ServiceInstance.builder().name("address").address("192.168.16.113")
				.port(8888).build();
		// 注册 book 服务 路径为book
		ServiceDiscovery<Object> discovery2 = ServiceDiscoveryBuilder.builder(Object.class).client(client)
				.basePath("/host").build();
		discovery2.registerService(instances2);
		discovery2.start();
		log.info("zookepper 服务注册成功：192.168.16.113:9999");
	}

}
