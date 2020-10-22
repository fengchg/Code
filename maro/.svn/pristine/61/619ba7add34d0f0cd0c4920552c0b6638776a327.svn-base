package com.maro.manager.store.purchasedetail.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 采购详情表
 * @author onlineGenerator
 * @date 2018-05-03 15:40:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_purchase_detail", schema = "")
@SuppressWarnings("serial")
public class MaroPurchaseDetailEntity implements java.io.Serializable {
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
	/**采购id*/
	private java.lang.String purchaseId;
	/**原料id*/
    @Excel(name="原料id",width=15)
	private java.lang.String materialClassId;
    /**原料名称*/
	private java.lang.String materialName;
	/**计划商品单价*/
    @Excel(name="计划商品单价",width=15)
	private java.lang.String planPrice;
	/**计划商品数量*/
    @Excel(name="计划商品数量",width=15)
	private java.lang.String planNumber;
	/**计划总价*/
    @Excel(name="计划总价",width=15)
	private java.lang.String planTotalPrice;
	/**实际单价*/
    @Excel(name="实际单价",width=15)
	private java.lang.String price;
	/**实际数量*/
    @Excel(name="实际数量",width=15)
	private java.lang.String number;
	/**实际总价*/
    @Excel(name="实际总价",width=15)
	private java.lang.String totalPrice;
	/**是否入库*/
    @Excel(name="是否入库",width=15)
	private java.lang.Integer isInStore;
	/**仓库id*/
    @Excel(name="仓库id",width=15)
	private java.lang.String storeId;
	/**入库时间*/
    @Excel(name="入库时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date inStoreTime;
	/**删除标志*/
    @Excel(name="删除标志",width=15)
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
	 *@return: java.lang.String  采购id
	 */
	
	@Column(name ="PURCHASE_ID",nullable=true,length=36)
	public java.lang.String getPurchaseId(){
		return this.purchaseId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购id
	 */
	public void setPurchaseId(java.lang.String purchaseId){
		this.purchaseId = purchaseId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料id
	 */
	
	@Column(name ="MATERIAL_CLASS_ID",nullable=true,length=36)
	public java.lang.String getMaterialClassId(){
		return this.materialClassId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料id
	 */
	public void setMaterialClassId(java.lang.String materialClassId){
		this.materialClassId = materialClassId;
	}

	@Transient
	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划商品单价
	 */
	
	@Column(name ="PLAN_PRICE",nullable=true,length=32)
	public java.lang.String getPlanPrice(){
		return this.planPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划商品单价
	 */
	public void setPlanPrice(java.lang.String planPrice){
		this.planPrice = planPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划商品数量
	 */
	
	@Column(name ="PLAN_NUMBER",nullable=true,length=32)
	public java.lang.String getPlanNumber(){
		return this.planNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划商品数量
	 */
	public void setPlanNumber(java.lang.String planNumber){
		this.planNumber = planNumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划总价
	 */
	
	@Column(name ="PLAN_TOTAL_PRICE",nullable=true,length=32)
	public java.lang.String getPlanTotalPrice(){
		return this.planTotalPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划总价
	 */
	public void setPlanTotalPrice(java.lang.String planTotalPrice){
		this.planTotalPrice = planTotalPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际单价
	 */
	
	@Column(name ="PRICE",nullable=true,length=32)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际单价
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际数量
	 */
	
	@Column(name ="NUMBER",nullable=true,length=32)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际数量
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际总价
	 */
	
	@Column(name ="TOTAL_PRICE",nullable=true,length=32)
	public java.lang.String getTotalPrice(){
		return this.totalPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际总价
	 */
	public void setTotalPrice(java.lang.String totalPrice){
		this.totalPrice = totalPrice;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否入库
	 */
	
	@Column(name ="IS_IN_STORE",nullable=true,length=10)
	public java.lang.Integer getIsInStore(){
		return this.isInStore;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否入库
	 */
	public void setIsInStore(java.lang.Integer isInStore){
		this.isInStore = isInStore;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库id
	 */
	
	@Column(name ="STORE_ID",nullable=true,length=36)
	public java.lang.String getStoreId(){
		return this.storeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库id
	 */
	public void setStoreId(java.lang.String storeId){
		this.storeId = storeId;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入库时间
	 */
	
	@Column(name ="IN_STORE_TIME",nullable=true)
	public java.util.Date getInStoreTime(){
		return this.inStoreTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入库时间
	 */
	public void setInStoreTime(java.util.Date inStoreTime){
		this.inStoreTime = inStoreTime;
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
