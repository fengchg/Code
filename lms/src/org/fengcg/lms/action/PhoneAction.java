/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.fengcg.lms.dao.impl.BookTypeDAO;
import org.fengcg.lms.dao.impl.UserDAO;
import org.fengcg.lms.phone.JsonHelper;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.BookType;
import org.fengcg.lms.vo.BorrowInfo;
import org.fengcg.lms.vo.User;
import org.fengcg.lms.vo.UserExp;

import com.opensymphony.xwork2.ActionSupport;

public class PhoneAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Page page;
	
	private User user;
	private BookType bookType;
	
	private final String TIP = "tip";
	
	private String bookName;
	private String code;
	
	private UserDAO userDAO = new UserDAO();
	private BookTypeDAO bookTypeDao = new BookTypeDAO();
	
	private final String RS_JSON = "json";
	private String json;
	private JsonHelper jsonHelper = new JsonHelper();
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String execute() throws Exception {
		return super.execute();
	}

	public String register() throws Exception {
		int result = userDAO.register(user);
		if(result == 1){
//			tip = "注册成功";
		}else{
//			tip = "注册失败";
		}
		return RS_JSON;
	}

	public String login() throws Exception {
		User u = userDAO.login(user);
		/**
		 * 如果数据库中有该用户记录
		 */
		if(u!=null){

			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"登录成功!"}),true);
			return RS_JSON;
			/**
			 * 判断该用户的状态
			 */
//			if(u.getStatus() == User.STATUS_USER_DISENABLE){//如果是已禁用状态
//				tip = "您的账户已被管理员禁用，请联系管理员!";
//				request().setAttribute("tip", tip);
//				return ERROR;
//			}else{//正常状态
//				/**
//				 * 如果是管理员
//				 */
//				request().getSession().setAttribute("user", u);
//				if(u.isAdmin()){
//					return "adminMain";
//				}else{//如果不是管理员
//					return "userMain";
//				}
//			}
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户名或者密码不正确!"}),false);
			return RS_JSON;
		}
	}
	
	public String deleteUser() throws Exception {
		int userId = Integer.parseInt(request().getParameter("userId"));
		int result = userDAO.deleteUser(userId);
		if(result == 1){
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户删除成功"}), true);
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户删除失败"}), false);
		}
		return RS_JSON;
	}

	public String viewUser() throws Exception {
		int id = user.getId();
		user = userDAO.findUserById(id);
		json = jsonHelper.buildJson(jsonHelper.buildJson(user,new String[]{"id","userName","userExp.realName","userExp.phoneNumber","userExp.code","userExp.address","userExp.email","userExp.age","userExp.gender","userExp.remark","status"},new String[]{"id","userName","realName","phoneNumber","code","address","email","age","gender","remark","status"}), true);
		return RS_JSON;
	}

	public String enableUser() throws Exception {
		int userId = user.getId();
		int result = userDAO.enableUser(userId);
		if(result == 1){
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户启用成功"}), true);
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户启用失败"}), false);
		}
		return RS_JSON;
	}
	
	public String disEnableUser() throws Exception{
		int userId = user.getId();
		int result = userDAO.disEnableUser(userId);
		if(result == 1){
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户禁用成功"}), true);
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"用户禁用失败"}), false);
		}
		return RS_JSON;
	}


	public String query() throws Exception {
		user = user == null ? new User():user;
		if(user.getUserExp() == null){
			user.setUserExp(new UserExp());
		}
		page = new Page();
		page.setRowNum(9999);
		List<User> users = userDAO.findUserAll(user,page);
		json =jsonHelper.buildJson(jsonHelper.buildJSONList(users, "users", new String[]{"id","userName","userExp.realName","userExp.phoneNumber","userExp.code","userExp.address"},new String[]{"id","userName","realName","phoneNumber","code","address"}),true);
		return RS_JSON;
	}
	
	public String queryBookType() throws Exception{
		BookType bookType = new BookType();
		page = page == null?new Page():page;
		page.setRowNum(999);
		List<BookType> bookTypes = bookTypeDao.findBookTypeAll(bookType.getName(), page);
		json = jsonHelper.buildJson(jsonHelper.buildJSONList(bookTypes, "types", new String[]{"id","name","remark"}),true);
		return RS_JSON;
	}
	
	public String viewBookType() throws Exception{
		int id = bookType.getId();
		bookType = bookTypeDao.viewBookType(id);
		json = jsonHelper.buildJson(jsonHelper.buildJson(bookType, new String[]{"id","name","remark"}), true);
		return RS_JSON;
	}
	public String saveBookType() throws Exception{
		int result = bookTypeDao.updateBookType(bookType);
		if(result == 1){
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"图书类别修改成功"}), true);
		}else {
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"图书类别修改失败"}), false);
		}
		return RS_JSON;
	}

	public String deleteBookType() throws Exception{
		int id = bookType.getId();
		int bookCount = bookTypeDao.findBookCount(id);
		if(bookCount == 0){
			int result = bookTypeDao.deleteBookTypeById(id);
			if(result == 1){
				json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"删除成功"}), true);
			}else {
				json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"删除失败"}), false);
			}
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"该类别不允许删除，请先把该类别下的图书全部删除再尝试!"}), false);
		}
		return RS_JSON;
	}
	public String addBookType() throws Exception{
		int result = bookTypeDao.addBookType(bookType);
		if(result == 1){
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"图书类型添加成功"}), true);
		}else{
			json = jsonHelper.buildJson(jsonHelper.buildJson(new String[]{TIP},new Object[]{"图书类型添加失败"}), false);
		}
		return RS_JSON;
	}

	public String exit() throws Exception{
		request().getSession().invalidate();
		return "login";
	}

	public String myBookBorrowInfo() throws Exception{
		/**
		 * 获取分页信息 获取当前页 获取每页条数
		 */
		page = page == null ? new Page():page;
		User user = (User) request().getSession().getAttribute("user");
		List<BorrowInfo> borrowInfos = userDAO.findMyBookBorrowList(user.getId(),bookName,code,page);
		request().setAttribute("borrowInfos", borrowInfos);
		request().setAttribute("page", page);
		request().setAttribute("bookName", bookName);
		request().setAttribute("code", code);
		return "myBookBorrow";
	}
	public String updateUserInfoBySelf() throws Exception{
		int result = userDAO.updateUserInfoBySelf(user);
		if(result == 1){
//			tip = "个人信息修改成功";
		}else{
//			tip = "个人信息修改失败";
		}
		return RS_JSON;
	}


	public String updatePassWDbySelf() throws Exception {
		String newPassWord = request().getParameter("newPass");
		String inputOldPass = request().getParameter("oldPass");
		User user = (User) request().getSession().getAttribute("user");
		int id = user.getId();
		String oldpassword = userDAO.findUserOldPassWord(id);
		if(inputOldPass.equals(oldpassword)){
			int result = userDAO.updateUserOldPassWord(id,newPassWord);
			if(result == 1){
//				tip = "密码修改成功";
			}else{
//				tip = "密码修改失败";
			}
		}else{
//			tip = "输入的旧密码不正确";
		}
		return RS_JSON;
	}

	public String viewBySelf() throws Exception {
		User user = (User) request().getSession().getAttribute("user");
		int id = user.getId();
		user = userDAO.findUserById(id);
		request().setAttribute("user",user);
		return "userViewInfo";
	}

	public void checkUserName() throws Exception {
		String userName = request().getParameter("userName");
		boolean result = userDAO.checkUserName(userName);
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		writer.print(result);
		writer.flush();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
