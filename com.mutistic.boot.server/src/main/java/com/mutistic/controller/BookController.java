package com.mutistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.base.ResponseUtil;
import com.mutistic.mapper.BookMapper;

@RestController
@RequestMapping("/bookController/")
public class BookController {
	
	@Autowired
	private BookMapper bookMapper;

	@GetMapping("queryAllList")
	public Object queryAllList() {
		return ResponseUtil.setSuccess(bookMapper.queryAllList());
	}
	
	@GetMapping("queryById")
	public Object queryById(@RequestParam("id") Long id) {
		return ResponseUtil.setSuccess(bookMapper.queryById(id));
	}
}
