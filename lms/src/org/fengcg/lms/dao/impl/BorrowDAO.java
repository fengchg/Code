package org.fengcg.lms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fengcg.lms.dao.BaseDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.Book;
import org.fengcg.lms.vo.BookType;
import org.fengcg.lms.vo.BorrowInfo;
import org.fengcg.lms.vo.User;
import org.fengcg.lms.vo.UserExp;

/**
 * author:冯成果
 * date:2013-2-18
 * description:
 */
public class BorrowDAO{
	
	private BaseDAO dao = BaseDAO.getInstance();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//图书借阅期限,以日为单位,31天为期限
	private final int days = 31;
	private Calendar calendar = Calendar.getInstance();

	/**
	 * 列出可被借阅的图书列表
	 * @param code 
	 * @param bookName 
	 * @return 返回未被借阅的图书列表
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Book> findBookCanBeBrw(Book book,Page page) throws SQLException, ClassNotFoundException {
		List<Book> list = null;
		String sqlForCount = "select * from t_book where status = 0 and isBorrow = 0";
		String sqlForList = "select x.*,y.id typeId,y.name,y.remark typeRemark from t_book x,t_booktype y where x.bookType = y.id and x.status = 0 and isBorrow = 0";
		String conditions = "";
		dao.beginConnection();
		if(book.getBookName()!=null && !book.getBookName().equals("")){
			conditions += " and bookName like  '%" + book.getBookName() +"%'";
		}
		if(book.getCode()!=null && !book.getCode().equals("")){
			conditions += " and code like  '%" + book.getCode() +"%'";
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
	 * 列出可被归还和续借的图书列表
	 * @param code 
	 * @param bookName 
	 * @return 返回被归还和续借的图书列表
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<BorrowInfo> findBookCanBeRetAndBrw(Book book,Page page) throws SQLException, ClassNotFoundException {
		List<BorrowInfo> list = null;
		String sqlForCount = "select count(*) from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and borrow.bookId = book.id and u.id=uexp.userId and borrow.returnTime is null";
		String sqlForList = "select borrow.id brId,borrow.borrowTime,uexp.realName,book.id bid,book.bookName,book.code,book.author from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and u.id=uexp.userId and borrow.bookId = book.id and borrow.returnTime is null";
		String conditions = "";
		dao.beginConnection();
		if(book.getBookName()!=null && !book.getBookName().equals("")){
			conditions += " and book.bookName like  '%" + book.getBookName() +"%'";
		}
		if(book.getCode()!=null && !book.getCode().equals("")){
			conditions += " and book.code like  '%" + book.getCode() +"%'";
		}
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " order by borrow.borrowTime desc" + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<BorrowInfo>();
			}
			BorrowInfo borrowInfo = new BorrowInfo();
			Book bk = new Book();
			User user = new User();
			UserExp userExp = new UserExp();

			userExp.setRealName(rsForList.getString("realName"));
			user.setUserExp(userExp);
			
			bk.setId(rsForList.getInt("bId"));
			bk.setBookName(rsForList.getString("bookName"));
			bk.setAuthor(rsForList.getString("author"));
			bk.setCode(rsForList.getString("code"));
			
			borrowInfo.setId(rsForList.getInt("brId"));
			borrowInfo.setBorrowTime(rsForList.getTimestamp("borrowTime"));
			borrowInfo.setBook(bk);
			borrowInfo.setUser(user);
			list.add(borrowInfo);
		}
		dao.endRes();
		return list;
	}

	public int findBookCount(String id) throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "select count(*) ct from t_book where bookType = " + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			count = rs.getInt("ct");
		}
		dao.endRes();
		return count;
	}

	public int borrow(int bookId,int userId) throws SQLException, ClassNotFoundException {
		int result = 0;
		long cutTime = System.currentTimeMillis();
		calendar.setTimeInMillis(cutTime);
		calendar.add(Calendar.DAY_OF_MONTH,days);
		String sql = "insert into t_borrow (userId,bookId,borrowTime,setReturnTime) values('"+userId+"','"+bookId+"','"+format.format(new Date(cutTime))+"','"+format.format(calendar.getTime())+"')";
		String sql1 = "update t_book set isBorrow = 1 where id = " + bookId;
		dao.beginConnection();
		result = dao.doUpdate(sql);
		result = dao.doUpdate(sql1);
		dao.endRes();
		return result;
	}

	public int reBorrow(int borrowId) throws SQLException, ClassNotFoundException {
		int result = 0;
		String sql = "update t_borrow set borrowTime = '"+format.format(new Date(System.currentTimeMillis()))+"' where id = " + borrowId;
		dao.beginConnection();
		result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	public int returnBook(int borrowId, int bookId) throws SQLException, ClassNotFoundException {
		int result = 0;
		String sql = "update t_borrow set returnTime = '"+format.format(new Date(System.currentTimeMillis()))+"' where id = " + borrowId;
		String sql1 = "update t_book set isBorrow = 0 where id = " + bookId;
		dao.beginConnection();
		result = dao.doUpdate(sql);
		result = dao.doUpdate(sql1);
		dao.endRes();
		return result;
	}

	public List<BorrowInfo> limitBookRrw(Book book,Page page) throws SQLException, ClassNotFoundException {
		List<BorrowInfo> list = null;
		String sqlForCount = "select count(*) from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and borrow.bookId = book.id and u.id=uexp.userId";
		String sqlForList = "select borrow.id brId,borrow.borrowTime,borrow.returnTime,borrow.setReturnTime,uexp.realName,book.id bid,book.bookName,book.code,book.author from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and u.id=uexp.userId and borrow.bookId = book.id";
		String conditions = "";
		dao.beginConnection();
		if(book.getBookName()!=null && !book.getBookName().equals("")){
			conditions += " and book.bookName like  '%" + book.getBookName() +"%'";
		}
		if(book.getCode()!=null && !book.getCode().equals("")){
			conditions += " and book.code like  '%" + book.getCode() +"%'";
		}
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " order by borrow.borrowTime desc" + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<BorrowInfo>();
			}
			BorrowInfo borrowInfo = new BorrowInfo();
			Book bk = new Book();
			User user = new User();
			UserExp userExp = new UserExp();

			userExp.setRealName(rsForList.getString("realName"));
			user.setUserExp(userExp);
			
			bk.setId(rsForList.getInt("bId"));
			bk.setBookName(rsForList.getString("bookName"));
			bk.setAuthor(rsForList.getString("author"));
			bk.setCode(rsForList.getString("code"));
			
			borrowInfo.setId(rsForList.getInt("brId"));
			borrowInfo.setBorrowTime(rsForList.getTimestamp("borrowTime"));
			borrowInfo.setReturnTime(rsForList.getTimestamp("returnTime"));
			borrowInfo.setSetReturnTime(rsForList.getTimestamp("setReturnTime"));
			long outLimitDays = 0;
			if(borrowInfo.getReturnTime()!=null){
				long returnTime = borrowInfo.getReturnTime().getTime();
				long setReturnTime = borrowInfo.getSetReturnTime().getTime();
				if(returnTime>setReturnTime){
					outLimitDays = (returnTime - setReturnTime)/(24*60*60*1000L);
				}
			}else{
				long returnTime = System.currentTimeMillis();
				long setReturnTime = borrowInfo.getSetReturnTime().getTime();
				if(returnTime>setReturnTime){
					outLimitDays = (returnTime - setReturnTime)/(24*60*60*1000L);
				}
			}
			borrowInfo.setOutLimitDays((int)outLimitDays);
			borrowInfo.setBook(bk);
			borrowInfo.setUser(user);
			list.add(borrowInfo);
		}
		dao.endRes();
		return list;
	}
}
