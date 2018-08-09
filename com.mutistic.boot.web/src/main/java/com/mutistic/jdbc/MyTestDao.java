package com.mutistic.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program 演示JdbcTemplate的使用
 * @description 
 * @author mutisitic
 * @date 2018年8月9日
 */
@Repository
public class MyTestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insert(Long id, String name) {
		String sql = "INSERT INTO mytest VALUES ('" + id + "', '" + name + "');";
		jdbcTemplate.execute(sql);
		return sql;
	}
	
}
