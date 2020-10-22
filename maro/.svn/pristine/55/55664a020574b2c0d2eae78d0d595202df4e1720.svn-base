package com.maro.common.shop.pojo.entity;
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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 座位信息
 * @author onlineGenerator
 * @date 2018-03-26 09:48:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_shop_seat", schema = "")
@SuppressWarnings("serial")
public class MaroShopSeatEntity implements java.io.Serializable {
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
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**主键id*/
    @Excel(name="主键id",width=15)
	private java.lang.String shopId;
	/**座位名称*/
    @Excel(name="座位名称",width=15)
	private java.lang.String name;
	/**座位类型*/
    @Excel(name="座位类型",width=15,dicCode="maro_seat_type")
	private java.lang.Integer type;
    //座位类型
    private java.lang.String typeString;
	/**座位号*/
    @Excel(name="座位号",width=15)
	private java.lang.String flag;
	/**座位标准人数*/
    @Excel(name="座位标准人数",width=15)
	private java.lang.Integer number;
	/**最近流水id*/
    @Excel(name="最近流水id",width=15)
	private java.lang.String lateOperatinId;
	/**删除标志*/
    @Excel(name="删除标志",width=15)
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
	 *@return: java.lang.String  主键id
	 */
	
	@Column(name ="SHOP_ID",nullable=true,length=36)
	public java.lang.String getShopId(){
		return this.shopId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键id
	 */
	public void setShopId(java.lang.String shopId){
		this.shopId = shopId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座位名称
	 */
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座位名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  座位类型
	 */
	
	@Column(name ="TYPE",nullable=true,length=1)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  座位类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	@Transient
	public java.lang.String getTypeString() {
		return typeString;
	}

	public void setTypeString(java.lang.String typeString) {
		this.typeString = typeString;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座位号
	 */
	
	@Column(name ="FLAG",nullable=true,length=32)
	public java.lang.String getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座位号
	 */
	public void setFlag(java.lang.String flag){
		this.flag = flag;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  座位标准人数
	 */
	
	@Column(name ="NUMBER",nullable=true,length=2)
	public java.lang.Integer getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  座位标准人数
	 */
	public void setNumber(java.lang.Integer number){
		this.number = number==null?0:number;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最近流水id
	 */
	
	@Column(name ="LATE_OPERATIN_ID",nullable=true,length=36)
	public java.lang.String getLateOperatinId(){
		return this.lateOperatinId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最近流水id
	 */
	public void setLateOperatinId(java.lang.String lateOperatinId){
		this.lateOperatinId = lateOperatinId;
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
