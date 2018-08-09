package com.mutistic.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program 演示 JdbcTemplate 和 事务
 * @description
 * @author mutisitic
 * @date 2018年7月25日
 */
@RestController
@RequestMapping("/myTestController/")
@EnableTransactionManagement // 开启事务
public class MyTestController {

	@Autowired
	private MyTestDao myTestDao;

	/**
	 * @description 演示使用 JdbcTemplate 实现数据插入
	 * @author mutisitic
	 * @date 2018年7月25日
	 * @return
	 */
	@PostMapping(value = "insertByTemplate", produces = "text/html;charset=UTF-8")
	public String insertByJdbc(@RequestParam("id") Long id, @RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("\n演示使用 JdbcTemplate 实现数据插入 ");
		val.append("\n[使用 JdbcTemplate通过execute() 方法执行sql语句完成数据插入]");
		val.append("\n[执行sql：" + myTestDao.insert(id, name) + "]");
		System.out.println(val.toString());
		return val.toString();
	}

	/**
	 * @description 演示使用 @EnableTransactionManagement 开启事务
	 * @author mutisitic
	 * @date 2018年7月30日
	 * @param id
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "insertByException", produces = "text/html;charset=UTF-8")
	@Transactional(rollbackFor = Exception.class, noRollbackFor = NullPointerException.class)
	public String insertByException(@RequestParam("id") Long id, @RequestParam("name") String name) {
		StringBuffer val = new StringBuffer("\n演示使用 @EnableTransactionManagement 开启事务 ");
		val.append("\n[Controller类或者@SpringBootApplication类 实现  @EnableTransactionManagement 开启事务]");
		val.append("\n[方法上：实现@Transactional添加事务]");
		val.append("\n[执行sql：" + myTestDao.insert(id, name) + "]");
		val.append("\n[PS1：@EnableTransactionManagement默认对运行时异常即：RuntimeException进行回滚，其他异常不触发回滚]");
		val.append("\n[PS2：方法可以无需抛出 throws Exception]");
		val.append("\n[PS3：@Transactional rollbackFor可以指定那些异常回滚，默认是运行时异常，还有其他参数设置是否回滚的异常信息]");
		val.append("\n[PS4：@Transactional noRollbackFor可以指定那些异常不回滚]");
		val.append("\n[PS5：@Transactional 必须声明在初始调用的public方法上，参考事务的传播机制]");
		val.append("\n[PS6：@Transactional 要保证数据库是支持事务]");
		System.out.println(val.toString());
		
		if("Exception".equals(name)) {
			throw new RuntimeException(val.toString());
		}
		
		return val.toString();
	}
}
