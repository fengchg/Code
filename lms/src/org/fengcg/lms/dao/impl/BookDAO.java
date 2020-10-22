package org.fengcg.lms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.fengcg.lms.dao.BaseDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.Book;
import org.fengcg.lms.vo.BookType;

/**
 * author:·ë³É¹û
 * date:2013-2-18
 * description:
 */
public class BookDAO{
	private BaseDAO dao = BaseDAO.getInstance();
	
	/**
	 * @param name
	 * @param remark
	 * @param remark2 
	 * @param publisher 
	 * @param code 
	 * @param publishDate_date 
	 * @param author 
	 * @param remark3 
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int addBook(Book book) throws SQLException, ClassNotFoundException {
		String sql = "insert into t_book (bookType,bookName,author,publishDate,code,publisher,pageNum,remark) values('"+book.getBookType().getId()+"','"+book.getBookName()+"','"+book.getAuthor()+"','"+book.getPublishDate_date()+"','"+book.getCode()+"','"+book.getPublisher()+"','"+book.getPageNum()+"','"+book.getRemark()+"')";
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Book viewBook(int id) throws SQLException, ClassNotFoundException {
		Book book = null;
		String sql = "select x.*,y.id typeId,y.name,y.remark typeRemark from t_book x,t_booktype y where x.bookType = y.id and x.id =" + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthor(rs.getString("author"));
			book.setCode(rs.getString("code"));
			book.setPublishDate_date(rs.getDate("publishDate"));
			book.setPageNum(rs.getInt("pageNum"));
			book.setRemark(rs.getString("remark"));
			book.setPublisher(rs.getString("publisher"));
			book.setIsBorrow(rs.getInt("isBorrow"));
			BookType type = new BookType();
			type.setId(rs.getInt("typeId"));
			type.setName(rs.getString("name"));
			type.setRemark(rs.getString("typeRemark"));
			book.setBookType(type);
		}
		dao.endRes();
		return book;
	}

	/**
	 * @param name
	 * @param publisher 
	 * @param code 
	 * @param publishDate_date 
	 * @param author 
	 * @param bookName 
	 * @param page
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Book> findBookAll(Book book,Page page) throws SQLException, ClassNotFoundException {
		List<Book> list = null;
		String sqlForCount = "select count(*) from t_book where status = 0";
		String sqlForList = "select x.*,y.id typeId,y.name,y.remark typeRemark from t_book x,t_booktype y where x.bookType = y.id and x.status = 0";
		String conditions = "";
		dao.beginConnection();
		if(book.getBookType().getId() != 0){
			conditions += " and bookType =" + book.getBookType().getId();
		}
		if(book.getBookName()!=null && !book.getBookName().equals("")){
			conditions += " and bookName like  '%" + book.getBookName() +"%'";
		}
		if(book.getAuthor()!=null && !book.getAuthor().equals("")){
			conditions += " and author like  '%" + book.getAuthor() +"%'";
		}
		if(book.getCode()!=null && !book.getCode().equals("")){
			conditions += " and code like  '%" + book.getCode() +"%'";
		}
		if(book.getPublishDate_date()!=null && !book.getPublishDate_date().equals("")){
			conditions += " and publishDate like  '%" + book.getPublishDate_date() +"%'";
		}
		if(book.getPublisher()!=null && !book.getPublisher().equals("")){
			conditions += " and publisher like  '%" + book.getPublisher() +"%'";
		}
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " order by x.id desc" + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<Book>();
			}
			Book bk = new Book();
			bk.setId(rsForList.getInt("id"));
			bk.setBookName(rsForList.getString("bookName"));
			bk.setAuthor(rsForList.getString("author"));
			bk.setCode(rsForList.getString("code"));
			bk.setPublishDate_date(rsForList.getDate("publishDate"));
			bk.setPageNum(rsForList.getInt("pageNum"));
			bk.setRemark(rsForList.getString("remark"));
			bk.setPublisher(rsForList.getString("publisher"));
			bk.setIsBorrow((rsForList.getInt("isBorrow")));
			BookType type = new BookType();
			type.setId(rsForList.getInt("typeId"));
			type.setName(rsForList.getString("name"));
			type.setRemark(rsForList.getString("typeRemark"));
			bk.setBookType(type);
			list.add(bk);
		}
		dao.endRes();
		return list;
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Book updateBookForInput(int id) throws SQLException, ClassNotFoundException {
		Book book = null;
		String sql = "select x.*,y.id typeId,y.name,y.remark typeRemark from t_book x,t_booktype y where x.bookType = y.id and x.id =" + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthor(rs.getString("author"));
			book.setCode(rs.getString("code"));
			book.setPublishDate_date(rs.getDate("publishDate"));
			book.setPageNum(rs.getInt("pageNum"));
			book.setRemark(rs.getString("remark"));
			book.setPublisher(rs.getString("publisher"));
			BookType type = new BookType();
			type.setId(rs.getInt("typeId"));
			type.setName(rs.getString("name"));
			type.setRemark(rs.getString("typeRemark"));
			book.setBookType(type);
		}
		dao.endRes();
		return book;
	}

	/**
	 * @param id
	 * @param name
	 * @param remark
	 * @param remark2 
	 * @param publisher 
	 * @param code 
	 * @param publishDate_date 
	 * @param remark3 
	 * @param remark4 
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int updateBook(Book book) throws SQLException, ClassNotFoundException {
		String sql = "update t_book set bookType="+book.getBookType().getId()+",bookName='"+book.getBookName()+"',author='"+book.getAuthor()+"',publishDate='"+book.getPublishDate_date()+"',code='"+book.getCode()+"',publisher='"+book.getPublisher()+"',pageNum='"+book.getPageNum()+"',remark='"+book.getRemark()+"' where id=" + book.getId();
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int deleteBookById(int id) throws SQLException, ClassNotFoundException {
		String sql = "update t_book set status = 1 where id=" + id;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<BookType> findAllOfBookType() throws SQLException, ClassNotFoundException {
		List<BookType> list = null;
		String sql = "select * from t_bookType where status = 0";
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		
		while(rs.next()){
			if(list == null){
				list = new ArrayList<BookType>();
			}
			BookType bookType = new BookType();
			bookType.setId(rs.getInt("id"));
			bookType.setName(rs.getString("name"));
			bookType.setRemark(rs.getString("remark"));
			list.add(bookType);
		}
		dao.endRes();
		return list;
	}
}
