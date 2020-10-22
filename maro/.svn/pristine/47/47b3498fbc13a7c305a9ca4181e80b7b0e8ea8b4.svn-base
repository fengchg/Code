package com.maro.manager.store.storeflow.entity;

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
 * @Description: 流水表
 * @author onlineGenerator
 * @date 2018-05-04 09:52:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_store_flow", schema = "")
@SuppressWarnings("serial")
public class MaroStoreFlowEntity implements java.io.Serializable {
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
	/**采购详情id*/
	@Excel(name="采购详情id",width=36)
	private java.lang.String purchaseDetailId;
	/**店铺id*/
	@Excel(name="店铺id",width=15)
	private java.lang.String shopId;
	/**原料id*/
	@Excel(name="原料id",width=15)
	private java.lang.String goodsId;
	/**实际数量*/
	@Excel(name="实际数量",width=15)
	private java.lang.String number;
	/**实际价格*/
	@Excel(name="实际价格",width=15)
	private java.lang.String price;
	/**实际总价*/
	@Excel(name="实际总价",width=15)
	private java.lang.String totalPrice;
	/**仓库id*/
	@Excel(name="仓库id",width=15)
	private java.lang.String storeId;
	/**标签码*/
	@Excel(name="标签码",width=15)
	private java.lang.String labelCode;
	/**出入库类型*/
	@Excel(name="出入库类型",width=15)
	private java.lang.Integer type;
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

	@Column(name ="PURCHASE_DETAIL_ID",nullable=true,length=36)
	public String getPurchaseDetailId() {
		return purchaseDetailId;
	}

	public void setPurchaseDetailId(String purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
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
	 *@return: java.lang.String  原料id
	 */

	@Column(name ="GOODS_ID",nullable=true,length=36)
	public java.lang.String getGoodsId(){
		return this.goodsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料id
	 */
	public void setGoodsId(java.lang.String goodsId){
		this.goodsId = goodsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际数量
	 */

	@Column(name ="NUMBER",nullable=true,length=36)
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
	 *@return: java.lang.String  实际价格
	 */

	@Column(name ="PRICE",nullable=true,length=36)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际价格
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际总价
	 */

	@Column(name ="TOTAL_PRICE",nullable=true,length=36)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标签码
	 */

	@Column(name ="LABEL_CODE",nullable=true,length=36)
	public java.lang.String getLabelCode(){
		return this.labelCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标签码
	 */
	public void setLabelCode(java.lang.String labelCode){
		this.labelCode = labelCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  出入库类型
	 */

	@Column(name ="TYPE",nullable=true,length=10)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  出入库类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
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
