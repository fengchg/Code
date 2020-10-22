package com.maro.manager.dishes.setmeal.entity;
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
 * @Description: 套餐
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_setmeal", schema = "")
@SuppressWarnings("serial")
public class MaroSetmealEntity implements java.io.Serializable {
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
	/**套餐名称*/
    @Excel(name="套餐名称",width=15)
	private java.lang.String setmealName;
	/**快捷码*/
    @Excel(name="快捷码",width=15)
	private java.lang.String swiftCode;
	/**套餐类型*/
    @Excel(name="套餐类型",width=15)
	private java.lang.String setmealType;
	/**套餐价*/
    @Excel(name="套餐价",width=15)
	private java.lang.String packagePrice;
	/**会员价*/
    @Excel(name="会员价",width=15)
	private java.lang.String memberPrice;
	/**套餐图片*/
    @Excel(name="套餐图片",width=15)
	private java.lang.String setmealPicture;
	/**销售状态*/
    @Excel(name="销售状态",width=15,dicCode="maro_setmeal_type")
	private java.lang.Integer marketType;
	/**简介*/
    @Excel(name="简介",width=15)
	private java.lang.String synopsis;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	/*@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")*/
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
	 *@return: java.lang.String  套餐名称
	 */
	
	@Column(name ="SETMEAL_NAME",nullable=true,length=32)
	public java.lang.String getSetmealName(){
		return this.setmealName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐名称
	 */
	public void setSetmealName(java.lang.String setmealName){
		this.setmealName = setmealName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快捷码
	 */
	
	@Column(name ="SWIFT_CODE",nullable=true,length=32)
	public java.lang.String getSwiftCode(){
		return this.swiftCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快捷码
	 */
	public void setSwiftCode(java.lang.String swiftCode){
		this.swiftCode = swiftCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套餐类型
	 */
	
	@Column(name ="SETMEAL_TYPE",nullable=true,length=32)
	public java.lang.String getSetmealType(){
		return this.setmealType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐类型
	 */
	public void setSetmealType(java.lang.String setmealType){
		this.setmealType = setmealType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套餐价
	 */
	
	@Column(name ="PACKAGE_PRICE",nullable=true,length=32)
	public java.lang.String getPackagePrice(){
		return this.packagePrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐价
	 */
	public void setPackagePrice(java.lang.String packagePrice){
		this.packagePrice = packagePrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员价
	 */
	
	@Column(name ="MEMBER_PRICE",nullable=true,length=32)
	public java.lang.String getMemberPrice(){
		return this.memberPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员价
	 */
	public void setMemberPrice(java.lang.String memberPrice){
		this.memberPrice = memberPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套餐图片
	 */
	
	@Column(name ="SETMEAL_PICTURE",nullable=true,length=32)
	public java.lang.String getSetmealPicture(){
		return this.setmealPicture;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐图片
	 */
	public void setSetmealPicture(java.lang.String setmealPicture){
		this.setmealPicture = setmealPicture;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  销售状态
	 */
	
	@Column(name ="MARKET_TYPE",nullable=true,length=2)
	public java.lang.Integer getMarketType(){
		return this.marketType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  销售状态
	 */
	public void setMarketType(java.lang.Integer marketType){
		this.marketType = marketType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	
	@Column(name ="SYNOPSIS",nullable=true,length=32)
	public java.lang.String getSynopsis(){
		return this.synopsis;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setSynopsis(java.lang.String synopsis){
		this.synopsis = synopsis;
	}
	
}
