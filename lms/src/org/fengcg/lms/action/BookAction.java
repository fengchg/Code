/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.fengcg.lms.dao.impl.BookDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.Book;
import org.fengcg.lms.vo.BookType;

/**
 * className:org.fengxl.lms.action.BookAction.java
 * author:冯成果
 * date:2013-2-27
 * description:
 */
public class BookAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO = new BookDAO();
	private Page page;
	private Book book;
	private String tip;
	private String forward;
	private final String TIPPAGE = "tipPage";

	public String add() throws Exception{
		int result = bookDAO.addBook(book);
		if(result == 1){
			tip = "图书添加成功";
		}else{
			tip = "图书添加失败";
		}
		forward = "bookAction!query.action";
		forward();
		return TIPPAGE;
	}
	public String view() throws Exception{
		int id = book.getId();
		book = bookDAO.viewBook(id);
		return "view";
	}
	public String query() throws Exception{
		book = book == null ? new Book():book;
		if(book.getBookType() == null){
			book.setBookType(new BookType());
		}
		page = page == null?new Page():page;
		List<Book> books = bookDAO.findBookAll(book,page);
		List<BookType> bookTypes = bookDAO.findAllOfBookType();
		request().setAttribute("books", books);
		request().setAttribute("bookTypes", bookTypes);
		return "list";
	}
	public String updateForInput() throws Exception{
		int id = book.getId();
		book = bookDAO.updateBookForInput(id);
		List<BookType> bookTypes = bookDAO.findAllOfBookType();
		request().setAttribute("bookTypes", bookTypes);
		return "updateForInput";
	}
	public String update() throws Exception{
		int result = bookDAO.updateBook(book);
		if(result == 1){
			tip = "图书修改成功";
		}else {
			tip = "图书修改失败";
		}
		forward = "bookAction!query.action";
		forward();
		return TIPPAGE;
	}
	public String delete() throws Exception{
		int id = book.getId();
		int result = bookDAO.deleteBookById(id);
		if(result == 1){
			tip = "图书删除成功";
		}else {
			tip = "图书删除失败";
		}
		forward = "bookAction!query.action";
		forward();
		return TIPPAGE;
	}
	public String addForInput() throws Exception{
		List<BookType> bookTypes = bookDAO.findAllOfBookType();
		request().setAttribute("bookTypes", bookTypes);
		return "addForInput";
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
