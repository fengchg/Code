package com.maro.manager.store.purchase.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 采购主表
 * @author onlineGenerator
 * @date 2018-05-03 15:40:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_purchase", schema = "")
@SuppressWarnings("serial")
public class MaroPurchaseEntity implements java.io.Serializable {
	/**id*/
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
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**店铺id*/
    @Excel(name="店铺id",width=15)
	private java.lang.String shopId;
	/**采购编号*/
    @Excel(name="采购编号",width=15)
	private java.lang.String code;
	/**采购操作人id*/
	private java.lang.String optionUserId;
	/**审批人id*/
	private java.lang.String approveUserId;
	/**计划采购开始时间*/
    @Excel(name="计划采购开始时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date planStartTime;
	/**实际采购开始时间*/
	private java.util.Date startTime;
	/**计划采购结束时间*/
    @Excel(name="计划采购结束时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date planEndTime;
	/**实际采购结束时间*/
	private java.util.Date endTime;
	/**支付方式*/
    @Excel(name="支付方式",width=15)
	private java.lang.Integer payType;
	/**预算*/
    @Excel(name="预算",width=15)
	private java.lang.String budget;
	/**决算*/
	private java.lang.String actualBudget;
	/**提交状态*/
	private java.lang.Integer submitFlag;
	/**审批状态*/
	private java.lang.Integer approveState;
	/**删除标志*/
	private java.lang.Integer deleteFlag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
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
	
	@Column(name ="CREATE_DATE",nullable=true)
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
	
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  流程状态
	 */
	
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺id
	 */
	
	@Column(name ="SHOP_ID",nullable=true,length=36)
	public java.lang.String getShopId(){
		return this.shopId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺id
	 */
	public void setShopId(java.lang.String shopId){
		this.shopId = shopId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购编号
	 */
	
	@Column(name ="CODE",nullable=true,length=36)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购操作人id
	 */
	
	@Column(name ="OPTION_USER_ID",nullable=true,length=36)
	public java.lang.String getOptionUserId(){
		return this.optionUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购操作人id
	 */
	public void setOptionUserId(java.lang.String optionUserId){
		this.optionUserId = optionUserId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审批人id
	 */
	
	@Column(name ="APPROVE_USER_ID",nullable=true,length=36)
	public java.lang.String getApproveUserId(){
		return this.approveUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审批人id
	 */
	public void setApproveUserId(java.lang.String approveUserId){
		this.approveUserId = approveUserId;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划采购开始时间
	 */
	
	@Column(name ="PLAN_START_TIME",nullable=true)
	public java.util.Date getPlanStartTime(){
		return this.planStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划采购开始时间
	 */
	public void setPlanStartTime(java.util.Date planStartTime){
		this.planStartTime = planStartTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  实际采购开始时间
	 */
	
	@Column(name ="START_TIME",nullable=true)
	public java.util.Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  实际采购开始时间
	 */
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计划采购结束时间
	 */
	
	@Column(name ="PLAN_END_TIME",nullable=true)
	public java.util.Date getPlanEndTime(){
		return this.planEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计划采购结束时间
	 */
	public void setPlanEndTime(java.util.Date planEndTime){
		this.planEndTime = planEndTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  实际采购结束时间
	 */
	
	@Column(name ="END_TIME",nullable=true)
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  实际采购结束时间
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支付方式
	 */
	
	@Column(name ="PAY_TYPE",nullable=true,length=10)
	public java.lang.Integer getPayType(){
		return this.payType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支付方式
	 */
	public void setPayType(java.lang.Integer payType){
		this.payType = payType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预算
	 */
	
	@Column(name ="BUDGET",nullable=true,length=32)
	public java.lang.String getBudget(){
		return this.budget;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预算
	 */
	public void setBudget(java.lang.String budget){
		this.budget = budget;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  决算
	 */
	
	@Column(name ="ACTUAL_BUDGET",nullable=true,length=32)
	public java.lang.String getActualBudget(){
		return this.actualBudget;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  决算
	 */
	public void setActualBudget(java.lang.String actualBudget){
		this.actualBudget = actualBudget;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  提交状态
	 */
	
	@Column(name ="SUBMIT_FLAG",nullable=true,length=10)
	public java.lang.Integer getSubmitFlag(){
		return this.submitFlag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  提交状态
	 */
	public void setSubmitFlag(java.lang.Integer submitFlag){
		this.submitFlag = submitFlag;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  审批状态
	 */
	
	@Column(name ="APPROVE_STATE",nullable=true,length=10)
	public java.lang.Integer getApproveState(){
		return this.approveState;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  审批状态
	 */
	public void setApproveState(java.lang.Integer approveState){
		this.approveState = approveState;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	
	@Column(name ="DELETE_FLAG",nullable=true,length=10)
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
	
}
