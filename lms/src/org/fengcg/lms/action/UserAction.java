/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.fengcg.lms.dao.impl.UserDAO;
import org.fengcg.lms.util.Page;
import org.fengcg.lms.vo.BorrowInfo;
import org.fengcg.lms.vo.User;
import org.fengcg.lms.vo.UserExp;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Page page;
	private User user;
	private String tip;
	private String forward;
	private final String TIPPAGE = "tipPage";
	private String bookName;
	private String code;
	private UserDAO userDAO = new UserDAO();
	
	public String execute() throws Exception {
		return super.execute();
	}

	public String register() throws Exception {
		int result = userDAO.register(user);
		if(result == 1){
			tip = "注册成功";
		}else{
			tip = "注册失败";
		}
		forward = "login.jsp";
		forward();
		return TIPPAGE;
	}

	public String login() throws Exception {
		User u = userDAO.login(user);
		/**
		 * 如果数据库中有该用户记录
		 */
		if(u!=null){
			
			/**
			 * 判断该用户的状态
			 */
			if(u.getStatus() == User.STATUS_USER_DISENABLE){//如果是已禁用状态
				tip = "您的账户已被管理员禁用，请联系管理员!";
				request().setAttribute("tip", tip);
				return ERROR;
			}else{//正常状态
				/**
				 * 如果是管理员
				 */
				request().getSession().setAttribute("user", u);
				if(u.isAdmin()){
					return "adminMain";
				}else{//如果不是管理员
					return "userMain";
				}
			}
		}else{
			tip = "用户名或者密码不正确!";
			forward = "error.jsp";
			request().setAttribute("tip", tip);
			request().setAttribute("forward", forward);
//			ServletActionContext.getResponse().getWriter().println("矫丽颖");
			return "error.jsp";
		}
	}

	public String query() throws Exception {
		/**
		 * 第一次进入user为空，userexp为空
		 */
		user = user == null ? new User():user;
		if(user.getUserExp() == null){
			user.setUserExp(new UserExp());
		}
		page = page == null?new Page():page;
		List<User> users = userDAO.findUserAll(user,page);
		request().setAttribute("page",page);
		request().setAttribute("users",users);
		request().setAttribute("userName",user.getUserName());
		request().setAttribute("gender",user.getUserExp().getGender());
		return "userList";
	}

	public String delete() throws Exception {
		int userId = Integer.parseInt(request().getParameter("userId"));
		int result = userDAO.deleteUser(userId);
		if(result == 1){
			tip = "用户删除成功";
		}else{
			tip = "用户删除成功";
		}
		return SUCCESS;
	}

	public String view() throws Exception {
		int id = user.getId();
		user = userDAO.findUserById(id);
		return "viewUser";
	}

	public String enable() throws Exception {
		int userId = user.getId();
		int result = userDAO.enableUser(userId);
		if(result == 1){
			tip = "用户启用成功";
		}else{
			tip = "用户启用失败";
		}
		forward = "userAction!query.action";
		forward();
		return TIPPAGE;
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
			tip = "个人信息修改成功";
		}else{
			tip = "个人信息修改失败";
		}
		forward = "userAction!viewBySelf.action";
		forward();
		return TIPPAGE;
	}
	public String disEnable() throws Exception{
		int userId = user.getId();
		int result = userDAO.disEnableUser(userId);
		if(result == 1){
			tip = "用户禁用成功";
		}else{
			tip = "用户禁用失败";
		}
		forward = "userAction!query.action";
		forward();
		return TIPPAGE;
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
				tip = "密码修改成功";
			}else{
				tip = "密码修改失败";
			}
			forward = "userAction!viewBySelf.action";
		}else{
			tip = "输入的旧密码不正确";
			forward = "user/updatePassword.jsp";
		}
		forward();
		return TIPPAGE;
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
}
