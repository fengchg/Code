package com.maro.manager.specialoffer.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Title: Entity
 * @Description: 店铺优惠活动
 * @author onlineGenerator
 * @date 2018-10-18 11:13:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_special_offer", schema = "")
@SuppressWarnings("serial")
public class MaroSpecialOfferEntity implements java.io.Serializable {
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
	/**活动名称*/
	@Excel(name="活动名称",width=15)
	private java.lang.String name;
	/**活动备注*/
	@Excel(name="活动备注",width=15)
	private java.lang.String remark;
	/**买的菜品id*/
	@Excel(name="买的菜品id",width=15)
	private java.lang.String buyDishesId;
	/**买的菜品规格id*/
	@Excel(name="买的菜品id",width=15)
	private java.lang.String buySpecificationsId;
	/**买的数量*/
	@Excel(name="买的数量",width=15)
	private java.lang.Integer buyNumber;
	/**送的菜品id*/
	@Excel(name="送的菜品id",width=15)
	private java.lang.String freeDishesId;
	/**送的菜品规格id*/
	@Excel(name="买的菜品id",width=15)
	private java.lang.String freeSpecificationsId;
	/**送的数量*/
	@Excel(name="送的数量",width=15)
	private java.lang.Integer freeNumber;
	/**是否累加*/
	@Excel(name="是否累加",width=15,dicCode="sf_yn")
	private java.lang.String isAdd;
	/**是否启用*/
	@Excel(name="是否启用",width=15,dicCode="sf_yn")
	private java.lang.String isEnable;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动名称
	 */

	@Column(name ="NAME",nullable=true,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动备注
	 */

	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  买的菜品id
	 */

	@Column(name ="BUY_DISHES_ID",nullable=true,length=36)
	public java.lang.String getBuyDishesId(){
		return this.buyDishesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  买的菜品id
	 */
	public void setBuyDishesId(java.lang.String buyDishesId){
		this.buyDishesId = buyDishesId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  买的数量
	 */

	@Column(name ="BUY_NUMBER",nullable=true,length=2)
	public java.lang.Integer getBuyNumber(){
		return this.buyNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  买的数量
	 */
	public void setBuyNumber(java.lang.Integer buyNumber){
		this.buyNumber = buyNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  送的菜品id
	 */

	@Column(name ="FREE_DISHES_ID",nullable=true,length=36)
	public java.lang.String getFreeDishesId(){
		return this.freeDishesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  送的菜品id
	 */
	public void setFreeDishesId(java.lang.String freeDishesId){
		this.freeDishesId = freeDishesId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  送的数量
	 */

	@Column(name ="FREE_NUMBER",nullable=true,length=2)
	public java.lang.Integer getFreeNumber(){
		return this.freeNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  送的数量
	 */
	public void setFreeNumber(java.lang.Integer freeNumber){
		this.freeNumber = freeNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否累加
	 */

	@Column(name ="IS_ADD",nullable=true,length=1)
	public java.lang.String getIsAdd(){
		return this.isAdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否累加
	 */
	public void setIsAdd(java.lang.String isAdd){
		this.isAdd = isAdd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否启用
	 */

	@Column(name ="IS_ENABLE",nullable=true,length=1)
	public java.lang.String getIsEnable(){
		return this.isEnable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否启用
	 */
	public void setIsEnable(java.lang.String isEnable){
		this.isEnable = isEnable;
	}

	@Column(name ="BUY_SPECIFICATIONS_ID",nullable=true,length=36)
	public String getBuySpecificationsId() {
		return buySpecificationsId;
	}

	public void setBuySpecificationsId(String buySpecificationsId) {
		this.buySpecificationsId = buySpecificationsId;
	}

	@Column(name ="FREE_SPECIFICATIONS_ID",nullable=true,length=36)
	public String getFreeSpecificationsId() {
		return freeSpecificationsId;
	}

	public void setFreeSpecificationsId(String freeSpecificationsId) {
		this.freeSpecificationsId = freeSpecificationsId;
	}
}