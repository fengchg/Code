package com.maro.manager.dishes.setmealdishes.entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.maro.manager.dishes.specificationsfoodcosts.entity.Specifications;

/**   
 * @Title: Entity
 * @Description: 套餐菜肴
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_setmeal_dishes", schema = "")
@SuppressWarnings("serial")
public class MaroSetmealDishesEntity implements java.io.Serializable {
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
	/**套餐id*/
    @Excel(name="套餐id",width=15)
	private java.lang.String setmealId;
	/**类型名称*/
    @Excel(name="类型名称",width=15)
    private java.lang.String className;
	/**菜肴数量*/
    @Excel(name="菜肴数量",width=15)
	private java.lang.Integer beginNum;
	/**选择数量*/
    @Excel(name="选择数量",width=15)
	private java.lang.Integer selectNum;
    /**是否可重复*/
    @Excel(name="是否可重复",width=15)
    private java.lang.Integer isRepetition;
    
    
    /** ================铺助字段============== */
	//套餐菜
	List<MaroSetmealDishesSelectEntity> setmealDishesSelectList = new ArrayList<MaroSetmealDishesSelectEntity>();
	
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
	 *@return: java.lang.String  套餐id
	 */
	
	@Column(name ="SETMEAL_ID",nullable=true,length=32)
	public java.lang.String getSetmealId(){
		return this.setmealId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套餐id
	 */
	public void setSetmealId(java.lang.String setmealId){
		this.setmealId = setmealId;
	}
	
	
	@Column(name ="CLASS_NAME",nullable=true,length=32)
	public java.lang.String getClassName() {
		return className;
	}

	public void setClassName(java.lang.String className) {
		this.className = className;
	}

	@Column(name ="BEGIN_NUM",nullable=true,length=32)
	public java.lang.Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(java.lang.Integer beginNum) {
		this.beginNum = beginNum;
	}

	@Column(name ="SELECT_NUM",nullable=true,length=32)
	public java.lang.Integer getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(java.lang.Integer selectNum) {
		this.selectNum = selectNum;
	}

	@Column(name ="IS_REPETITION",nullable=true,length=32)
	public java.lang.Integer getIsRepetition() {
		return isRepetition;
	}

	public void setIsRepetition(java.lang.Integer isRepetition) {
		this.isRepetition = isRepetition;
	}
	
	@Transient
	public List<MaroSetmealDishesSelectEntity> getSetmealDishesSelectList() {
		return setmealDishesSelectList;
	}

	public void setSetmealDishesSelectList(
			List<MaroSetmealDishesSelectEntity> setmealDishesSelectList) {
		this.setmealDishesSelectList = setmealDishesSelectList;
	}
	
	
	
	
}
