/**
 * projectName:lms
 */
package org.fengcg.lms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.fengcg.lms.dao.BaseDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.Book;
import org.fengcg.lms.vo.BorrowInfo;
import org.fengcg.lms.vo.User;
import org.fengcg.lms.vo.UserExp;

/**
 * className:org.fengxl.lms.dao.impl.UserDAO.java
 * author:冯成果
 * date:2013-2-18
 * description:
 */
public class UserDAO{
	private BaseDAO dao = BaseDAO.getInstance();
	
	/**
	 * @param userId
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int enableUser(int userId) throws SQLException, ClassNotFoundException {
		String sql = "update t_user set status = 0 where id = " + userId;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * @param userId
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int deleteUser(int userId) throws SQLException, ClassNotFoundException {
		String sql = "update t_user set status = 2 where id = " + userId;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * 用户注册
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int register(User user) throws SQLException, ClassNotFoundException{
		String sql = "insert into t_user(userName,passWord) values('"+user.getUserName()+"','"+user.getPassword()+"')";
		dao.beginConnection();
		int result =dao.doUpdate(sql);
		String sqlForUid = "select id from t_user where userName = '" + user.getUserName() +"'";
		ResultSet rs = dao.doQuery(sqlForUid);
		rs.next();
		String sql1 = "insert into t_userexp(userId,age,gender,address,phoneNumber,email,code,remark,realName) values('"+rs.getInt("id")+"','"+user.getUserExp().getAge()+"','"+user.getUserExp().getGender()+"','"+user.getUserExp().getAddress()+"','"+user.getUserExp().getPhoneNumber()+"','"+user.getUserExp().getEmail()+"','"+user.getUserExp().getCode()+"','"+user.getUserExp().getRemark()+"','"+user.getUserExp().getRealName()+"')";
		result = dao.doUpdate(sql1);
		dao.endRes();
		return result;
	}

	/**
	 * 用户登录
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User login(User user) throws SQLException, ClassNotFoundException {
		User u = null;
		String sql = "select x.id uid,x.userName,x.status,x.isAdmin,y.* from t_user x left join t_userexp y on x.id = y.userId where x.userName = '" + user.getUserName() + "' and x.passWord = '" + user.getPassword() + "'";
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			u = new User();
			u.setId(rs.getInt("uid"));
			u.setUserName(rs.getString("userName"));
			u.setStatus(rs.getInt("status"));
			UserExp userExp = new UserExp(rs.getInt("id"),rs.getString("realName"), rs.getString("gender"), rs.getInt("age"), rs.getString("phoneNumber"), rs.getString("address"), rs.getString("email"), rs.getString("code"), rs.getString("remark"));
			u.setUserExp(userExp);
			int isAdmin = rs.getInt("isAdmin");
			if(isAdmin == 1){
				u.setAdmin(true);
			}else{
				u.setAdmin(false);
			}
		}
		dao.endRes();
		return u;
	}

	/**
	 * 用户列表查看
	 * @param page 
	 * @param filter 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<User> findUserAll(User user, Page page) throws SQLException, ClassNotFoundException {
		
		List<User> list = null;
		dao.beginConnection();
		String sqlForCount = "select count(*) from t_user x,t_userexp y where x.isAdmin = 0 and y.userId = x.id";
		String sqlForList = "select x.userName,x.status,y.* from t_user x,t_userexp y where x.id = y.userId and x.isAdmin = 0 and x.status != 2";
		String conditions = "";
		
		if(user.getUserName()!=null && !user.getUserName().equals("")){
			conditions += " and x.userName like  '%" + user.getUserName() +"%'";
		}
		
		if(user.getUserExp().getGender()!=null && !user.getUserExp().getGender().equals("")){
			conditions += " and y.gender like '%" + user.getUserExp().getGender() + "%'";
		}
		
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " order by x.id desc" + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<User>();
			}
			User u = new User();
			u.setId(rsForList.getInt("userId"));
			u.setUserName(rsForList.getString("userName"));
			u.setStatus(rsForList.getInt("status"));
			UserExp userExp = new UserExp(rsForList.getInt("id"),rsForList.getString("realName"), rsForList.getString("gender"), rsForList.getInt("age"), rsForList.getString("phoneNumber"), rsForList.getString("address"), rsForList.getString("email"), rsForList.getString("code"), rsForList.getString("remark"));
			u.setUserExp(userExp);
			list.add(u);
		}
		dao.endRes();
		return list;
	}

	/**
	 * 根据用户标识查找用户
	 * 
	 * @param id
	 *            用户标识
	 * @return 单个用户 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User findUserById(int id) throws SQLException, ClassNotFoundException {
		User user = null;
		String sql = "select x.userName,x.status,y.* from t_user x,t_userexp y where x.id = y.userId and x.id = " + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			user = new User();
			user.setId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setStatus(rs.getInt("x.status"));
			UserExp userExp = new UserExp(rs.getInt("id"),rs.getString("realName"), rs.getString("gender"), rs.getInt("age"), rs.getString("phoneNumber"), rs.getString("address"), rs.getString("email"), rs.getString("code"), rs.getString("remark"));
			user.setUserExp(userExp);
		}
		dao.endRes();
		return user;
	}

	/**
	 * 用户停用
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int disEnableUser(int userId) throws SQLException, ClassNotFoundException {
		String sql = "update t_user set status = 1 where id = " + userId;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}



	public List<User> findAllUser() throws SQLException, ClassNotFoundException {
		List<User> list = null;
		String sql= "select x.userName,x.status,y.* from t_user x,t_userexp y where x.id = y.userId and x.isAdmin = 0 and x.status = 0";
		dao.beginConnection();
		ResultSet rsForList = dao.doQuery(sql);
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<User>();
			}
			User user = new User();
			user.setId(rsForList.getInt("userId"));
			user.setUserName(rsForList.getString("userName"));
			user.setStatus(rsForList.getInt("status"));
			UserExp userExp = new UserExp(rsForList.getInt("id"),rsForList.getString("realName"), rsForList.getString("gender"), rsForList.getInt("age"), rsForList.getString("phoneNumber"), rsForList.getString("address"), rsForList.getString("email"), rsForList.getString("code"), rsForList.getString("remark"));
			user.setUserExp(userExp);
			list.add(user);
		}
		dao.endRes();
		return list;
	}

	public List<BorrowInfo> findMyBookBorrowList(int id,String bookName,String code,Page page) throws SQLException, ClassNotFoundException {
		List<BorrowInfo> list = null;
		dao.beginConnection();
		String sqlForCount = "select count(*) from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and borrow.bookId = book.id and u.id=uexp.userId and u.id = " + id;
		String sqlForList = "select borrow.id brId,borrow.borrowTime,borrow.returnTime,borrow.setReturnTime,uexp.realName,book.id bid,book.bookName,book.code,book.author from t_borrow borrow,t_user u,t_book book,t_userexp uexp where borrow.userId = u.id and u.id=uexp.userId and borrow.bookId = book.id and u.id = " + id;
		String conditions = "";
		if(bookName!=null && !bookName.equals("")){
			conditions += " and book.bookName like  '%" + bookName +"%'";
		}
		if(code!=null && !code.equals("")){
			conditions += " and book.code like  '%" + code +"%'";
		}
		ResultSet rsForCount = dao.doQuery(sqlForCount+conditions);
		if(rsForCount.next()){
			int count = rsForCount.getInt(1);
			page.setCount(count);
		}
		
		ResultSet rsForList = dao.doQuery(sqlForList + conditions + " limit " + (page.getCurrentPage()-1) * page.getRowNum() + "," + page.getRowNum());
		
		while(rsForList.next()){
			if(list == null){
				list = new ArrayList<BorrowInfo>();
			}
			BorrowInfo borrowInfo = new BorrowInfo();
			Book book = new Book();
			User user = new User();
			UserExp userExp = new UserExp();

			userExp.setRealName(rsForList.getString("realName"));
			user.setUserExp(userExp);
			
			book.setId(rsForList.getInt("bId"));
			book.setBookName(rsForList.getString("bookName"));
			book.setAuthor(rsForList.getString("author"));
			book.setCode(rsForList.getString("code"));
			
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
			borrowInfo.setBook(book);
			borrowInfo.setUser(user);
			list.add(borrowInfo);
		}
		dao.endRes();
		return list;
	}

	public int updateUserInfoBySelf(User user) throws SQLException, ClassNotFoundException {
		String sql = "update t_userexp set age='"+user.getUserExp().getAge()+"',address='"+user.getUserExp().getAddress()+"',phoneNumber='"+user.getUserExp().getPhoneNumber()+"',email='"+user.getUserExp().getEmail()+"',remark='"+user.getUserExp().getRemark()+"' where userId = " + user.getId();
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	public String findUserOldPassWord(int id) throws SQLException, ClassNotFoundException {
		String sql = "select passWord from t_user where id = " + id;
		dao.beginConnection();
		ResultSet rs = dao.doQuery(sql);
		rs.next();
		String pass = rs.getString("passWord");
		dao.endRes();
		return pass;
	}

	public int updateUserOldPassWord(int id, String newPassWord) throws SQLException, ClassNotFoundException {
		String sql = "update t_user set passWord='"+newPassWord+"' where id = " + id;
		dao.beginConnection();
		int result = dao.doUpdate(sql);
		dao.endRes();
		return result;
	}

	/**
	 * @param userName
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean checkUserName(String userName) throws SQLException, ClassNotFoundException {
		String sql = "select count(userName) c from t_user where userName = '" + userName + "'";
		dao.beginConnection();
		boolean result = false;
		ResultSet rs = dao.doQuery(sql);
		if(rs.next()){
			int r = rs.getInt("c");
			result = r > 0 ? true : false;
		}
		dao.endRes();
		return result;
	}
	
}
