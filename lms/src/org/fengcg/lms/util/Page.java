package org.fengcg.lms.util;

public class Page {
	private int currentPage = 1;
	private int totalPages;
	private int count;
	private int rowNum = 5;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		totalPages = count % rowNum == 0 ? count / rowNum:count / rowNum + 1;
		this.count = count;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
