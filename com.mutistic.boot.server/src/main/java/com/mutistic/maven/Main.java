package com.mutistic.maven;

import com.mutistic.utils.CommonUtil;

public class Main {

	public static void main(String[] args) {
		CommonUtil.printTwo("环境配置maven bin：path", "C:\\Work\\Software\\Maven\\apache-maven-3.0.5\\bin;");
		CommonUtil.printTwo("执行命令：打包maven依赖", "mvn clean appassembler:assemble");
		CommonUtil.printTwo("执行命令：打包本项目", "mvn clean package appassembler:assemble");
		CommonUtil.printTwo("pom.xml配置：", "<build>\r\n" + 
				"		<plugins>\r\n" + 
				"			<plugin>\r\n" + 
				"				<!-- appassembler-maven-plugin插件官网:http://www.mojohaus.org/appassembler/appassembler-maven-plugin/index.html\r\n" + 
				"				mvn clean package appassembler:assemble\r\n" + 
				"				mvn clean appassembler:assemble -->\r\n" + 
				"				<groupId>org.codehaus.mojo</groupId>\r\n" + 
				"				<artifactId>appassembler-maven-plugin</artifactId>\r\n" + 
				"				<version>2.0.0</version>\r\n" + 
				"				<configuration>\r\n" + 
				"					<!-- 生成unix、windows平台执行脚本 -->\r\n" + 
				"					<platforms>\r\n" + 
				"						<platform>windows</platform>\r\n" + 
				"						<platform>unix</platform>\r\n" + 
				"					</platforms>\r\n" + 
				"					<!-- 根目录 -->\r\n" + 
				"					<assembleDirectory>${project.build.directory}/server</assembleDirectory>\r\n" + 
				"					<!-- 打包的jar，以及maven依赖的jar放到这个目录 lib -->\r\n" + 
				"					<repositoryName>lib</repositoryName>\r\n" + 
				"					<!-- lib目录中jar存放的规则,默认是 ${groupId}/${artifactId}的目录格式,flat表示直接把jar放到 \r\n" + 
				"						repositoryName声明的目录 -->\r\n" + 
				"					<repositoryLayout>flat</repositoryLayout>\r\n" + 
				"					<!-- 可执行脚本的目录 -->\r\n" + 
				"					<binFolder>bin</binFolder>\r\n" + 
				"					<!-- 配置文件的目标目录 -->\r\n" + 
				"					<configurationDirectory>conf</configurationDirectory>\r\n" + 
				"					<!-- 拷贝配置文件到configurationDirectory配置的目录种 -->\r\n" + 
				"					<copyConfigurationDirectory>true</copyConfigurationDirectory>\r\n" + 
				"					<!-- 执行从项目的目录拷贝配置文件(默认 src.main.config) -->\r\n" + 
				"					<configurationSourceDirectory>src/main/resources</configurationSourceDirectory>\r\n" + 
				"					<!-- 编码格式 -->\r\n" + 
				"					<encoding>UTF-8</encoding>\r\n" + 
				"					<!-- logs目录 -->\r\n" + 
				"					<logsDirectory>logs</logsDirectory>\r\n" + 
				"					<!-- 临时文件目录 -->\r\n" + 
				"					<tempDirectory>tep</tempDirectory>\r\n" + 
				"					<!-- 配置启动类 -->\r\n" + 
				"					<programs>\r\n" + 
				"						<program>\r\n" + 
				"							<id>server </id>\r\n" + 
				"							<mainClass>com.mutistic.Application</mainClass>\r\n" + 
				"							<!-- jvm参数 -->\r\n" + 
				"							<jvmSettings>\r\n" + 
				"								<extraArguments>\r\n" + 
				"									<!-- 指定以server的方式运行 -->\r\n" + 
				"									<extraArgument>-server</extraArgument>\r\n" + 
				"									<!-- 指定最大堆内存 -->\r\n" + 
				"									<extraArgument>-Xmx1G</extraArgument>\r\n" + 
				"									<!-- 指定最小堆内存 -->\r\n" + 
				"									<extraArgument>-Xms1G</extraArgument>\r\n" + 
				"								</extraArguments>\r\n" + 
				"							</jvmSettings>\r\n" + 
				"						</program>\r\n" + 
				"					</programs>\r\n" + 
				"				</configuration>\r\n" + 
				"			</plugin>\r\n" + 
				"		</plugins>\r\n" + 
				"	</build>");
	}
	
}
