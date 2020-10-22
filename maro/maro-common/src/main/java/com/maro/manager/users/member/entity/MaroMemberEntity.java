package com.maro.manager.users.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 会员表
 * @author onlineGenerator
 * @date 2018-04-11 15:24:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_member", schema = "")
@SuppressWarnings("serial")
public class MaroMemberEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**所属店铺*/
	@Excel(name="所属店铺",width=15)
	private java.lang.String shopId;
	/**会员姓名*/
	@Excel(name="会员姓名",width=15)
	private java.lang.String name;
	/**会员性别*/
	@Excel(name="会员性别",width=15)
	private java.lang.Integer sex;
	/**会员年纪*/
	@Excel(name="会员年纪",width=15)
	private java.lang.Integer age;
	/**会员电话*/
	@Excel(name="会员电话",width=15)
	private java.lang.String phone;
	/**微信号*/
	@Excel(name="微信号",width=15)
	private java.lang.String weixin;
	/**QQ号*/
	@Excel(name="QQ号",width=15)
	private java.lang.String qq;
	/**入会日期*/
	@Excel(name="入会日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createTime;
	/**会员级别*/
	@Excel(name="会员级别",width=15)
	private java.lang.Integer level;
	/**积分*/
	@Excel(name="积分",width=15)
	private java.lang.String memberPoints;
	/**余额*/
	@Excel(name="余额",width=15)
	private java.lang.String balance;
	/**删除标志*/
	private java.lang.Integer deleteFlag;
	/**头像*/
	@Excel(name="头像",width=15)
	private java.lang.String portrait;
	/**推荐人*/
	@Excel(name="推荐人",width=15)
	private java.lang.String recommendedUser;
	/**状态*/
	@Excel(name="状态",width=15)
	private java.lang.String state;
	/**员工*/
	@Excel(name="员工",width=15)
	private java.lang.String employees;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String idcardnumber;
	/**账户*/
	@Excel(name="账户",width=15)
	private java.lang.String account;
	/**卡号*/
	@Excel(name="卡号",width=15)
	private java.lang.String card;
	/**密码*/
	private java.lang.String password;
	/**邮箱*/
	@Excel(name="邮箱",width=15)
	private java.lang.String email;
	/**签署*/
	@Excel(name="签署",width=15)
	private java.lang.String imsign;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属店铺
	 */

	@Column(name ="SHOP_ID",nullable=true,length=36)
	public java.lang.String getShopId(){
		return this.shopId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属店铺
	 */
	public void setShopId(java.lang.String shopId){
		this.shopId = shopId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员姓名
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  会员性别
	 */

	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.Integer getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  会员性别
	 */
	public void setSex(java.lang.Integer sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  会员年纪
	 */

	@Column(name ="AGE",nullable=true,length=32)
	public java.lang.Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  会员年纪
	 */
	public void setAge(java.lang.Integer age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员电话
	 */

	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信号
	 */

	@Column(name ="WEIXIN",nullable=true,length=32)
	public java.lang.String getWeixin(){
		return this.weixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信号
	 */
	public void setWeixin(java.lang.String weixin){
		this.weixin = weixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ号
	 */

	@Column(name ="QQ",nullable=true,length=32)
	public java.lang.String getQq(){
		return this.qq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ号
	 */
	public void setQq(java.lang.String qq){
		this.qq = qq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入会日期
	 */

	@Column(name ="CREATE_TIME",nullable=true,length=32)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入会日期
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  会员级别
	 */

	@Column(name ="LEVEL",nullable=true,length=32)
	public java.lang.Integer getLevel(){
		return this.level;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  会员级别
	 */
	public void setLevel(java.lang.Integer level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  积分
	 */

	@Column(name ="MEMBER_POINTS",nullable=true,length=32)
	public java.lang.String getMemberPoints(){
		return this.memberPoints;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  积分
	 */
	public void setMemberPoints(java.lang.String memberPoints){
		this.memberPoints = memberPoints;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  余额
	 */

	@Column(name ="BALANCE",nullable=true,length=32)
	public java.lang.String getBalance(){
		return this.balance;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  余额
	 */
	public void setBalance(java.lang.String balance){
		this.balance = balance;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */

	@Column(name ="DELETE_FLAG",nullable=true,length=32)
	public java.lang.Integer getDeleteFlag(){
		return this.deleteFlag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setDeleteFlag(java.lang.Integer deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */

	@Column(name ="PORTRAIT",nullable=true,length=32)
	public java.lang.String getPortrait(){
		return this.portrait;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setPortrait(java.lang.String portrait){
		this.portrait = portrait;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐人
	 */

	@Column(name ="RECOMMENDED_USER",nullable=true,length=32)
	public java.lang.String getRecommendedUser(){
		return this.recommendedUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  推荐人
	 */
	public void setRecommendedUser(java.lang.String recommendedUser){
		this.recommendedUser = recommendedUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="STATE",nullable=true,length=32)
	public java.lang.String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  员工
	 */

	@Column(name ="EMPLOYEES",nullable=true,length=32)
	public java.lang.String getEmployees(){
		return this.employees;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  员工
	 */
	public void setEmployees(java.lang.String employees){
		this.employees = employees;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号码
	 */

	@Column(name ="IDCARDNUMBER",nullable=true,length=32)
	public java.lang.String getIdcardnumber(){
		return this.idcardnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号码
	 */
	public void setIdcardnumber(java.lang.String idcardnumber){
		this.idcardnumber = idcardnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户
	 */

	@Column(name ="ACCOUNT",nullable=true,length=32)
	public java.lang.String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卡号
	 */

	@Column(name ="CARD",nullable=true,length=32)
	public java.lang.String getCard(){
		return this.card;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卡号
	 */
	public void setCard(java.lang.String card){
		this.card = card;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */

	@Column(name ="PASSWORD",nullable=true,length=32)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */

	@Column(name ="EMAIL",nullable=true,length=32)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签署
	 */

	@Column(name ="IMSIGN",nullable=true,length=32)
	public java.lang.String getImsign(){
		return this.imsign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签署
	 */
	public void setImsign(java.lang.String imsign){
		this.imsign = imsign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=255)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
}
