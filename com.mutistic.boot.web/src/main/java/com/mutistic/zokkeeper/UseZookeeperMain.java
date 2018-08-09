package com.mutistic.zokkeeper;

import com.mutistic.utils.CommonUtil;

public class UseZookeeperMain {

	public static void main(String[] args) {
		CommonUtil.printOne("Zookeeper的安装和使用：");
		CommonUtil.printThree("ZK官网：", "http://zookeeper.apache.org/");
		CommonUtil.printThree("ZK下载镜像：", "http://mirrors.hust.edu.cn/apache/zookeeper/zookeeper-3.4.13/");
		CommonUtil.printThree("ZK的使用参考：", "https://www.cnblogs.com/shanyou/p/3221990.html");
		CommonUtil.printThree("ZK客戶端命令使用：", "https://www.cnblogs.com/senlinyang/p/7833669.html");
		CommonUtil.printThree("Zookeeper配置：",
				"配置文件在 conf 目录下，这个目录下有 zoo_sample.cfg 和 log4j.properties，你需要做的就是将 zoo_sample.cfg 改名为 zoo.cfg，因为 Zookeeper 在启动时会找这个文件作为默认配置文件Zookeeper 的配置文件在 conf 目录下，这个目录下有 zoo_sample.cfg 和 log4j.properties，你需要做的就是将 zoo_sample.cfg 改名为 zoo.cfg，因为 Zookeeper 在启动时会找这个文件作为默认配置文件");
		CommonUtil.printThree("tickTime：", "这个时间是作为 Zookeeper 服务器之间或客户端与服务器之间维持心跳的时间间隔，也就是每个 tickTime 时间就会发送一个心跳。");
		CommonUtil.printThree("dataDir：", "顾名思义就是 Zookeeper 保存数据的目录，默认情况下，Zookeeper 将写数据的日志文件也保存在这个目录里。");
		CommonUtil.printThree("dataLogDir：", "顾名思义就是 Zookeeper 保存日志文件的目录");
		CommonUtil.printThree("clientPort：", "这个端口就是客户端连接 Zookeeper 服务器的端口，Zookeeper 会监听这个端口，接受客户端的访问请求。");
		CommonUtil.printThree("启动zookeeper:", "/bin/zkServer.cmd");
		CommonUtil.printThree("zookeeper客户端:", "/bin/zkCli.cmd");
		CommonUtil.printThree("zk 与  curator 版本关系：", "curator的版本：2.12.0，对应Zookeeper的版本为：3.4.x");
		CommonUtil.printThree("zk 与  curator 版本关系：", "curator的版本：3.x或4.x，对应Zookeeper的版本为：3.5.x");
	}

}
