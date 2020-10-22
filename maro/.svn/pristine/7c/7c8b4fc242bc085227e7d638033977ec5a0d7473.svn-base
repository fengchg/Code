package com.maro.common.finance.operatin.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 流水表
 * @author onlineGenerator
 * @date 2018-04-12 14:12:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_operatin", schema = "")
@SuppressWarnings("serial")
public class MaroOperatinEntity implements java.io.Serializable {
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
	/**店铺id*/
	@Excel(name="店铺id",width=15)
	private java.lang.String shopId;
	/**收支*/
	@Excel(name="收支",width=15)
	private java.lang.Integer money;
	/**服务订单id*/
	@Excel(name="服务订单id",width=15)
	private java.lang.String serverOrderId;
	/**采购单id*/
	@Excel(name="采购单id",width=15)
	private java.lang.String purchaseId;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String remark;
	/**是否开具发票*/
	@Excel(name="是否开具发票",width=15,dicCode="sf_yn")
	private java.lang.String isInvoice;
	/**是否入账*/
	@Excel(name="是否入账",width=15,dicCode="sf_yn")
	private java.lang.String isBooked;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date createTime;
	/**删除标志*/
	private java.lang.Integer deleteFlag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  收支
	 */

	@Column(name ="MONEY",nullable=true,length=32)
	public java.lang.Integer getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  收支
	 */
	public void setMoney(java.lang.Integer money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务订单id
	 */

	@Column(name ="SERVER_ORDER_ID",nullable=true,length=32)
	public java.lang.String getServerOrderId(){
		return this.serverOrderId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务订单id
	 */
	public void setServerOrderId(java.lang.String serverOrderId){
		this.serverOrderId = serverOrderId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购单id
	 */

	@Column(name ="PURCHASE_ID",nullable=true,length=36)
	public java.lang.String getPurchaseId(){
		return this.purchaseId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购单id
	 */
	public void setPurchaseId(java.lang.String purchaseId){
		this.purchaseId = purchaseId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否开具发票
	 */

	@Column(name ="IS_INVOICE",nullable=true,length=32)
	public java.lang.String getIsInvoice(){
		return this.isInvoice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否开具发票
	 */
	public void setIsInvoice(java.lang.String isInvoice){
		this.isInvoice = isInvoice;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否入账
	 */

	@Column(name ="IS_BOOKED",nullable=true,length=32)
	public java.lang.String getIsBooked(){
		return this.isBooked;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否入账
	 */
	public void setIsBooked(java.lang.String isBooked){
		this.isBooked = isBooked;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_TIME",nullable=true,length=32)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
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
}
