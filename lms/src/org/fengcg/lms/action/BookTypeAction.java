/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.fengcg.lms.dao.impl.BookTypeDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.BookType;

/**
 * author:冯成果 
 * date:2013-2-27
 * description:
 */
public class BookTypeAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Page page;
	private BookType bookType;
	private String tip;
	private String forward;
	private final String TIPPAGE = "tipPage";
	private BookTypeDAO bookTypeDao = new BookTypeDAO();

	public String add() throws Exception{
		int result = bookTypeDao.addBookType(bookType);
		if(result == 1){
			tip = "图书类型添加成功";
		}else{
			tip = "图书类型添加失败";
		}
		forward = "bookTypeAction!query.action";
		forward();
		return TIPPAGE;
	}
	public String view() throws Exception{
		int id = bookType.getId();
		bookType = bookTypeDao.viewBookType(id);
		return "view";
	}
	public String query() throws Exception{
		bookType = bookType == null ? new BookType():bookType;
		page = page == null?new Page():page;
		List<BookType> bookTypes = bookTypeDao.findBookTypeAll(bookType.getName(), page);
		request().setAttribute("bookTypes", bookTypes);
		return "list";
	}
	public String updateForInput() throws Exception{
		int id = bookType.getId();
		bookType = bookTypeDao.updateBookTypeForInput(id);
		return "updateForInput";
	}
	public String update() throws Exception{
		int result = bookTypeDao.updateBookType(bookType);
		if(result == 1){
			tip = "图书类别修改成功";
		}else {
			tip = "图书类别修改失败";
		}
		forward = "bookTypeAction!query.action";
		forward();
		return TIPPAGE;
	}
	public String delete() throws Exception{
		int id = bookType.getId();
		int bookCount = bookTypeDao.findBookCount(id);
		if(bookCount == 0){
			int result = bookTypeDao.deleteBookTypeById(id);
			if(result == 1){
				tip = "删除成功";
			}else {
				tip = "删除失败";
			}
		}else{
			tip = "该类别不允许删除，请先把该类别下的图书全部删除再尝试!";
		}
		forward = "bookTypeAction!query.action";
		forward();
		return TIPPAGE;
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

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
