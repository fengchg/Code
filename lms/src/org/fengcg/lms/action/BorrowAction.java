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
 * author:��ɹ�
 * date:2013-2-27
 */
public class BorrowAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	/**
	 * ͼ����ġ��黹������service
	 */
	private BorrowDAO borrowDAO = new BorrowDAO();
	private UserDAO userDAO = new UserDAO();
	private BorrowInfo borrowInfo;
	private String tip;
	private String forward;
	private final String TIPPAGE = "tipPage";
	private Page page;

	/**
	 * �ɽ���ͼ���б�
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
	 * ��ͨ�û��鿴�ɽ���ͼ���б�
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
	 * ���ؿɹ黹���������ͼ���б�
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
	 * ����ͼ��
	 * @return
	 * @throws Exception
	 */
	public String borrow() throws Exception{
		int result = borrowDAO.borrow(borrowInfo.getBook().getId(),borrowInfo.getUser().getId());
		if(result == 1){
			tip = "���ĳɹ�";
		}else{
			tip = "����ʧ��";
		}
		forward = "borrowAction!borrowList.action";
		forward();
		return TIPPAGE;
	}
	/**
	 * �黹ͼ��
	 * @return
	 * @throws Exception
	 */
	public String returnBook() throws Exception{
		int borrowId = borrowInfo.getId();
		int bookId = borrowInfo.getBook().getId();
		int result = borrowDAO.returnBook(borrowId,bookId);
		if(result == 1){
			tip = "�黹�ɹ�";
		}else{
			tip = "�黹ʧ��";
		}
		forward = "borrowAction!retAndReBrwList.action";
		forward();
		return TIPPAGE;
	}
	/**
	 * ͼ������
	 * @return
	 * @throws Exception
	 */
	public String reborrow() throws Exception{
		int borrowId = borrowInfo.getId();
		int result = borrowDAO.reBorrow(borrowId);
		if(result == 1){
			tip = "����ɹ�";
		}else{
			tip = "����ʧ��";
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
