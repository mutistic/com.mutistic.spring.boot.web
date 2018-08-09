package com.mutistic.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.base.ResponseUtil;
import com.mutistic.entity.BookEntity;
import com.mutistic.mapper.BookMapper;

@RestController
@RequestMapping("/bookController/")
public class BookController {

	@Autowired
	private BookMapper bookMapper;

	/**
	 * @description 查询所有book信息 
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @return
	 */
	@GetMapping("queryAllList")
	public Object queryAllList(HttpServletRequest request) { return ResponseUtil.setSuccess(bookMapper.queryAllList()); }

	/**
	 * @description 根据ID查询book信息
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param id
	 * @return
	 */
	@GetMapping("queryById")
	public Object queryById(@RequestParam("id") Long id) { return ResponseUtil.setSuccess(bookMapper.queryById(id)); }

	/**
	 * @description 新增book信息 
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param book
	 * @return
	 */
	@PostMapping("insert")
	public Object insert(@RequestBody BookEntity book) {
		book.setBookId((new Date()).getTime());
		if(null == book.getCreaterTime()) 
			book.setCreaterTime(new Date());
		return ResponseUtil.setSuccess(bookMapper.insert(book));
	}
	
	/**
	 * @description 修改book信息 
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param book
	 * @return
	 */
	@PostMapping("update")
	public Object update(@RequestBody BookEntity book) {
		if(null == book.getCreaterTime()) book.setCreaterTime(new Date());
		return ResponseUtil.setSuccess(bookMapper.update(book));
	}

	/**
	 * @description 根据ID删除book信息 
	 * @author mutisitic
	 * @date 2018年8月6日
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete")
	public Object delete(@RequestParam("id") Long id) { return ResponseUtil.setSuccess(bookMapper.delete(id)); }
}
