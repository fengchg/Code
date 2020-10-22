package com.maro.common.users.tsuser.pojo.vo;

import java.util.Arrays;

import javax.persistence.Column;

import com.maro.platform.core.common.entity.IdEntity;

/**
 * 系统用户父类表
 * @author  张代浩
 */
public class TSBaseUser extends IdEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;// 用户名
	private String realName;// 真实姓名
	private String browser;// 用户使用浏览器类型

	private String userKey;// 用户验证唯一标示
	private String password;//用户密码
	private Short activitiSync;//是否同步工作流引擎
	/*@Excel(name = "状态")*/
	private Short status;// 状态1：在线,2：离线,0：禁用
	
	private Short deleteFlag;// 状态: 0:不删除  1：删除
	
	private byte[] signature;// 签名文件
	private String userNameEn;//英文名
	
	private String departid;

	public void setDepartid(String departid){
		this.departid = departid;
	}
	public String getDepartid(){
		return departid;
	}

    //	private TSDepart TSDepart = new TSDepart();// 部门
    //private List<TSUserOrg> userOrgList = new ArrayList<TSUserOrg>();
	//private TSDepart currentDepart = new TSDepart();// 当前部门


	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	public Short getActivitiSync() {
		return activitiSync;
	}
	public void setActivitiSync(Short activitiSync) {
		this.activitiSync = activitiSync;
	}
	
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//	@JsonIgnore    //getList查询转换为列表时处理json转换异常
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "departid")
//	public TSDepart getTSDepart() {
//		return this.TSDepart;
//	}
//
//	public void setTSDepart(TSDepart TSDepart) {
//		this.TSDepart = TSDepart;
//	}
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Column(name = "delete_flag")
	public Short getDeleteFlag() {
		return deleteFlag;
	}

	
	@Column(name = "user_name_en")
	public String getUserNameEn() {
		return userNameEn;
	}
	
	public void setUserNameEn(String userNameEn) {
		this.userNameEn = userNameEn;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TSBaseUser [userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", browser=");
		builder.append(browser);
		builder.append(", userKey=");
		builder.append(userKey);
		builder.append(", password=");
		builder.append(password);
		builder.append(", activitiSync=");
		builder.append(activitiSync);
		builder.append(", status=");
		builder.append(status);
		builder.append(", deleteFlag=");
		builder.append(deleteFlag);
		builder.append(", signature=");
		builder.append(Arrays.toString(signature));
		builder.append(", userNameEn=");
		builder.append(userNameEn);
		builder.append(", departid=");
		builder.append(departid);
		builder.append(", userOrgList=");
		builder.append(", currentDepart=");
		builder.append("]");
		return builder.toString();
	}
}