package org.fengcg.lms.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.fengcg.lms.dao.impl.BorrowDAO;
import org.fengcg.lms.dao.impl.UserDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.Book;
import org.fengcg.lms.vo.BorrowInfo;
import org.fengcg.lms.vo.User;

/**
 * author:冯成果
 * date:2013-2-27
 */
public class BorrowAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 图书借阅、归还、续借service
	 */
	private BorrowDAO borrowDAO = new BorrowDAO();
	private UserDAO userDAO = new UserDAO();
	private BorrowInfo borrowInfo;
	private String tip;
	private String forward;
	private final String TIPPAGE = "tipPage";
	private Page page;

	/**
	 * 可借阅图书列表
	 * @return
	 * @throws Exception
	 */
	public String borrowList() throws Exception{
		borrowInfo = borrowInfo == null ? new BorrowInfo():borrowInfo;
		if(borrowInfo.getBook() == null){
			borrowInfo.setBook(new Book());
		}
		page = page == null?new Page():page;
		List<Book> books = borrowDAO.findBookCanBeBrw(borrowInfo.getBook(),page);
		List<User> users = userDAO.findAllUser();
		request().setAttribute("books",books);
		request().setAttribute("books", books);
		request().setAttribute("users",users);
		return "borrowList";
	}
	/**
	 * 普通用户查看可借阅图书列表
	 * @return
	 * @throws Exception
	 */
	public String canBeBrwBookList() throws Exception{
		borrowInfo = borrowInfo == null ? new BorrowInfo():borrowInfo;
		if(borrowInfo.getBook() == null){
			borrowInfo.setBook(new Book());
		}
		page = page == null?new Page():page;
		List<Book> books = borrowDAO.findBookCanBeBrw(borrowInfo.getBook(),page);
		List<User> users = userDAO.findAllUser();
		request().setAttribute("books",books);
		request().setAttribute("books", books);
		request().setAttribute("users",users);
		return "borrowListForNrmUser";
	}
	/**
	 * 返回可归还、可续借的图书列表
	 * @return
	 * @throws Exception
	 */
	public String retAndReBrwList() throws Exception{		
		borrowInfo = borrowInfo == null ? new BorrowInfo():borrowInfo;	
		if(borrowInfo.getBook() == null){
			borrowInfo.setBook(new Book());
		}
		page = page == null?new Page():page;
		List<BorrowInfo> borrowInfos = borrowDAO.findBookCanBeRetAndBrw(borrowInfo.getBook(),page);
		request().setAttribute("borrowInfos",borrowInfos);
		return "retAndReBrwList";
	}
	/**
	 * 借阅图书
	 * @return
	 * @throws Exception
	 */
	public String borrow() throws Exception{
		int result = borrowDAO.borrow(borrowInfo.getBook().getId(),borrowInfo.getUser().getId());
		if(result == 1){
			tip = "借阅成功";
		}else{
			tip = "借阅失败";
		}
		forward = "borrowAction!borrowList.action";
		forward();
		return TIPPAGE;
	}
	/**
	 * 归还图书
	 * @return
	 * @throws Exception
	 */
	public String returnBook() throws Exception{
		int borrowId = borrowInfo.getId();
		int bookId = borrowInfo.getBook().getId();
		int result = borrowDAO.returnBook(borrowId,bookId);
		if(result == 1){
			tip = "归还成功";
		}else{
			tip = "归还失败";
		}
		forward = "borrowAction!retAndReBrwList.action";
		forward();
		return TIPPAGE;
	}
	/**
	 * 图书续借
	 * @return
	 * @throws Exception
	 */
	public String reborrow() throws Exception{
		int borrowId = borrowInfo.getId();
		int result = borrowDAO.reBorrow(borrowId);
		if(result == 1){
			tip = "续借成功";
		}else{
			tip = "续借失败";
		}
		forward = "borrowAction!retAndReBrwList.action";
		forward();
		return TIPPAGE;
	}
	
	public String limitBookBRWList() throws Exception{	
		borrowInfo = borrowInfo == null ? new BorrowInfo():borrowInfo;		
		if(borrowInfo.getBook() == null){
			borrowInfo.setBook(new Book());
		}
		page = page == null?new Page():page;
		List<BorrowInfo> borrowInfos = borrowDAO.limitBookRrw(borrowInfo.getBook(),page);				
		request().setAttribute("borrowInfos",borrowInfos);
		return "limitBookBRWList";
	}

	public void forward(){
		request().setAttribute("tip", tip);
		request().setAttribute("forward", forward);
	}
	
	public HttpServletRequest request(){
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse response(){
		return ServletActionContext.getResponse();
	}
	
	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}

	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
