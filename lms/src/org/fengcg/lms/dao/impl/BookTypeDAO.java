package org.fengcg.lms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.fengcg.lms.dao.BaseDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.BookType;

/**
 * author:·ë³É¹û
 * date:2013-2-18
 * description:
 */
public class BookTypeDAO{
	private BaseDAO dao = BaseDAO.getInstance();
	
	/**
	 * @param name
	 * @param remark
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int addBookType(BookType bookType) throws SQLException, ClassNotFoundException {
		String sql = "insert into t_booktype(name,remark) values('"+bookType.getName()+"','"+bookType.getRemark()+"')";
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
	public BookType viewBookType(int id) throws SQLException, ClassNotFoundException {
		BookType bookType = null;
		String sql = "select * from t_booktype where id = " + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			bookType = new BookType();
			bookType.setName(rs.getString("name"));
			bookType.setRemark(rs.getString("remark"));
		}
		dao.endRes();
		return bookType;
	}

	/**
	 * @param name
	 * @param page
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<BookType> findBookTypeAll(String name, Page page) throws SQLException, ClassNotFoundException {
		List<BookType> list = null;
		String sqlForCount = "select count(*) from t_booktype where status = 0";
		String sqlForList = "select * from t_bookType where status = 0";
		String conditions = "";
		dao.beginConnection();
		
		if(name!=null && !name.equals("")){
			conditions += " and name like  '%" + name +"%'";
		}
		
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " order by id desc" + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<BookType>();
			}
			BookType bookType = new BookType();
			bookType.setId(rsForList.getInt("id"));
			bookType.setName(rsForList.getString("name"));
			bookType.setRemark(rsForList.getString("remark"));
			list.add(bookType);
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
	public BookType updateBookTypeForInput(int id) throws SQLException, ClassNotFoundException {
		BookType bookType = null;
		String sql = "select * from t_booktype where id = " + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			bookType = new BookType();
			bookType.setId(rs.getInt("id"));
			bookType.setName(rs.getString("name"));
			bookType.setRemark(rs.getString("remark"));
		}
		dao.endRes();
		return bookType;
	}

	/**
	 * @param id
	 * @param name
	 * @param remark
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int updateBookType(BookType bookType) throws SQLException, ClassNotFoundException {
		String sql = "update t_booktype set name='"+bookType.getName()+"',remark='"+bookType.getRemark()+"' where id = " + bookType.getId();
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
	public int deleteBookTypeById(int id) throws SQLException, ClassNotFoundException {
		String sql = "update t_booktype set status=1 where id = " + id;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	public int findBookCount(int id) throws SQLException, ClassNotFoundException {
		int count = 0;
		dao.beginConnection();
		String sql = "select count(*) ct from t_book where bookType = " + id;
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			count = rs.getInt("ct");
		}
		dao.endRes();
		return count;
	}

}
