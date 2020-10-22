/**
 * projectName:libraryManagerSystem
 */
package org.fengcg.lms.vo;

/**
 * className:org.fengxl.lms.bean.User.java
 * author:冯成果
 * date:2013-2-26
 * description:
 */
public class User {
	
	/**
	 * 正常状态
	 */
	public static final int STATUS_USER_NORMAL = 0;
	/**
	 * 禁用状态
	 */
	public static final int STATUS_USER_DISENABLE = 1;
	/**
	 * 逻辑已删除状态
	 */
	public static final int STATUS_USER_DELETED = 2;
	
	/**
	 * 用户id
	 */
	private int id;
	
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 是否是管理员
	 */
	private boolean isAdmin;
	
	/**
	 * 用户的扩展信息
	 */
	private UserExp userExp;
	
	/**
	 * 用户状态
	 * 0代表正常
	 * 1代表禁用
	 * 2代表逻辑删除
	 */
	private int status;	
	
	private String statusDescription;
	
	/**
	 * @param userName
	 * @param password
	 * @param isAdmin
	 * @param userExp
	 */
	public User(String userName, String password, boolean isAdmin,
			UserExp userExp,int status) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.userExp = userExp;
		this.status = status;
	}
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param isAdmin
	 */
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	/**
	 * 
	 */
	public User() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public UserExp getUserExp() {
		return userExp;
	}
	public void setUserExp(UserExp userExp) {
		this.userExp = userExp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDescription() {
		switch (getStatus()) {
		case STATUS_USER_NORMAL:
			setStatusDescription("启用");
			break;
		case STATUS_USER_DISENABLE:
			setStatusDescription("禁用");
			break;
		}
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
