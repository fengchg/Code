/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.vo;

import java.sql.Timestamp;


/**
 * className:org.fengxl.lms.bean.UserExp.java
 * author:·ë³É¹û
 * date:2013-2-27
 * description:
 */
public class BorrowInfo {
	private int id;
	private User user;
	private Book book;
	private Timestamp borrowTime;
	private Timestamp returnTime;
	private Timestamp setReturnTime;
	public Timestamp getSetReturnTime() {
		return setReturnTime;
	}
	public void setSetReturnTime(Timestamp setReturnTime) {
		this.setReturnTime = setReturnTime;
	}
	private int outLimitDays;
	public int getOutLimitDays() {
		return outLimitDays;
	}
	public void setOutLimitDays(int outLimitDays) {
		this.outLimitDays = outLimitDays;
	}
	public BorrowInfo(int id, User user, Book book, Timestamp borrowTime,
			Timestamp returnTime) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
	}
	public BorrowInfo(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Timestamp getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Timestamp borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Timestamp getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}
}
