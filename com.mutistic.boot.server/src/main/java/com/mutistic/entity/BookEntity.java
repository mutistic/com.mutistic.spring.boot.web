package com.mutistic.entity;

import java.util.Date;

/**
 * @program book 实体 
 * @description 
 * @author mutisitic
 * @date 2018年8月4日
 */
public class BookEntity {

	private Long bookId;
	private String title;
	private String author;
	private String remark;
	private Date createrTime;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreaterTime() {
		return createrTime;
	}
	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}
	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", title=" + title + ", author=" + author + ", remark=" + remark
				+ ", createrTime=" + createrTime + "]";
	}
}
