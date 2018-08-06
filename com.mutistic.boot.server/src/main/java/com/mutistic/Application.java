package com.mutistic;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.entity.BookEntity;
import com.mutistic.mapper.BookMapper;
import com.mutistic.utils.CommonUtil;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		testBookMapper(ctx);
	}

	private static void testBookMapper(ConfigurableApplicationContext ctx) {
		CommonUtil.printOne("获取BookMapper bean："+ ctx.getBean(BookMapper.class));
		
		BookMapper mapper = ctx.getBean(BookMapper.class);
		
		CommonUtil.printOne("测试BookMapper.insert()方法:");
		BookEntity insert = new BookEntity();
		insert.setBookId((new Date()).getTime());
		insert.setTitle("test title");
		insert.setAuthor("test author");
		insert.setRemark("test remark");
		insert.setCreaterTime(new Date());
		CommonUtil.printThree("新增结果：", mapper.insert(insert));
		
		CommonUtil.printOne("测试BookMapper.queryAllList()方法:");
		CommonUtil.printThree("查询结果：", mapper.queryAllList());
		
		CommonUtil.printOne("测试BookMapper.queryById()方法:");
		BookEntity query = mapper.queryById(insert.getBookId());
		CommonUtil.printThree("查询结果：", query == null ? null : query.toString());
		
		
		CommonUtil.printOne("测试BookMapper.update()方法:");
		query.setCreaterTime(new Date());
		CommonUtil.printThree("更新结果：", mapper.update(query));
		
		
		CommonUtil.printOne("测试BookMapper.delete()方法:");
		CommonUtil.printThree("删除结果：", mapper.delete(insert.getBookId()));
	}
	
}
