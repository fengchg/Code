
package com.maro.manager.store.purchase.page;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 采购主表
 * @author onlineGenerator
 * @date 2018-05-03 15:40:38
 * @version V1.0   
 *
 */
public class MaroPurchasePage implements java.io.Serializable {
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
    @Excel(name="店铺id")
	private java.lang.String shopId;
	/**采购编号*/
    @Excel(name="采购编号")
	private java.lang.String code;
	/**采购操作人id*/
	private java.lang.String optionUserId;
	/**审批人id*/
	private java.lang.String approveUserId;
	/**计划采购开始时间*/
    @Excel(name="计划采购开始时间",format = "yyyy-MM-dd")
	private java.util.Date planStartTime;
	/**实际采购开始时间*/
	private java.util.Date startTime;
	/**计划采购结束时间*/
    @Excel(name="计划采购结束时间",format = "yyyy-MM-dd")
	private java.util.Date planEndTime;
	/**实际采购结束时间*/
	private java.util.Date endTime;
	/**支付方式*/
    @Excel(name="支付方式")
	private java.lang.Integer payType;
	/**预算*/
    @Excel(name="预算")
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

	/**保存-采购详情表*/
    @ExcelCollection(name="采购详情表")
	private List<MaroPurchaseDetailEntity> maroPurchaseDetailList = new ArrayList<MaroPurchaseDetailEntity>();
		public List<MaroPurchaseDetailEntity> getMaroPurchaseDetailList() {
		return maroPurchaseDetailList;
		}
		public void setMaroPurchaseDetailList(List<MaroPurchaseDetailEntity> maroPurchaseDetailList) {
		this.maroPurchaseDetailList = maroPurchaseDetailList;
		}
}
