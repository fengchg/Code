/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * className:org.fengxl.lms.bean.Book.java
 * author:冯成果
 * date:2013-2-26
 * description:
 */
public class Book {
	private int id;
	private String bookName;	//书名
	private String author;	//作者
	private String publishDate_str;	//出版日期——字符串类型
	private Date publishDate_date;	//出版日期——日期类型
	private String code;	//书号
	private String publisher;	//出版社
	private int pageNum;	//书总页数
	private String remark;		//备注说明
	private BookType bookType;
	private int status;
	private int isBorrow;
	private String isBorrowDecp;
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDate_str() {
		publishDate_str = format.format(getPublishDate_date());
		return publishDate_str;
	}
	public void setPublishDate_str(String publishDate_str) {
		this.publishDate_str = publishDate_str;
	}
	public Date getPublishDate_date() {
		return publishDate_date;
	}
	public void setPublishDate_date(Date publishDate_date) {
		this.publishDate_date = publishDate_date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsBorrow() {
		return isBorrow;
	}
	public void setIsBorrow(int isBorrow) {
		this.isBorrow = isBorrow;
	}
	public String getIsBorrowDecp() {
		if(getIsBorrow()==0){
			isBorrowDecp = "未借阅";
		}else{
			isBorrowDecp = "已借阅";
		}
		return isBorrowDecp;
	}
	public void setIsBorrowDecp(String isBorrowDecp) {
		this.isBorrowDecp = isBorrowDecp;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
