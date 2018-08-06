package com.mutistic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mutistic.entity.BookEntity;


@Mapper
public interface BookMapper {

	@Insert("INSERT INTO book (bookId, title, author, remark, createrTime) VALUES (#{bookId}, #{title}, #{author}, #{remark}, #{createrTime}) ")
	Integer insert(BookEntity entity);
	
	@Select("SELECT bookId, title, author, remark, createrTime FROM book")
	List<BookEntity> queryAllList();
	
	@Select("SELECT bookId, title, author, remark, createrTime FROM book WHERE bookId = #{id}")
	BookEntity queryById(Long id);
	
	@Update("UPDATE book SET bookId = #{bookId}, title = #{title}, author = #{author}, remark = #{remark}, createrTime = #{createrTime}  WHERE bookId = #{bookId}")
	Integer update(BookEntity entity);
	
	@Delete("DELETE FROM book WHERE bookId = #{id}")
	Integer delete(Long id);
}
