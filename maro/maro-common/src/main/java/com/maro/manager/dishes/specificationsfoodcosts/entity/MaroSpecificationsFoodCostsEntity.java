package com.maro.manager.dishes.specificationsfoodcosts.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 规格成本
 * @author onlineGenerator
 * @date 2018-03-22 22:02:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_specifications_food_costs", schema = "")
@SuppressWarnings("serial")
public class MaroSpecificationsFoodCostsEntity implements java.io.Serializable {
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
	/**规格属性id*/
	@Excel(name="规格属性id",width=15)
	private java.lang.String specificationsId;
	/**原料名称*/
	/*@Excel(name="原料名称",width=15)*/
	/*private java.lang.String name;*/
	/**原料分类*/
	@Excel(name="原料分类",width=15,dicCode="maro_material_class")
	private java.lang.String materialClassification;
	/**创建来源*/
	@Excel(name="创建来源",width=15)
	private java.lang.String createSource;
	/**消耗数量*/
	@Excel(name="消耗数量",width=15)
	private java.lang.Integer consumptionQuantity;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String unit;
	/**原料表*/
	@Excel(name="原料表",width=15)
	private java.lang.String materialclassId;
	
	/** ================铺助字段============== */
	//规格码
	private String specificationsCode;
	//规格名称
	private String specificationsName;
	//菜肴id
	private String dishesId;
	//菜肴名字
	private String dishesName;
	//菜肴单位
	private String dishesUnit;
	//原料名称
	private String materialclassName;
	//规格
	private List<Specifications> specificationsList;
	//原料单位
	private String materialUnitName;
	
	
	@Transient
	public String getDishesId() {
		return dishesId;
	}

	public void setDishesId(String dishesId) {
		this.dishesId = dishesId;
	}

	@Transient
	public String getDishesUnit() {
		return dishesUnit;
	}

	public void setDishesUnit(String dishesUnit) {
		this.dishesUnit = dishesUnit;
	}

	@Transient
	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}

	@Transient
	public String getMaterialUnitName() {
		return materialUnitName;
	}

	public void setMaterialUnitName(String materialUnitName) {
		this.materialUnitName = materialUnitName;
	}

	@Transient
	public String getSpecificationsCode() {
		return specificationsCode;
	}

	public void setSpecificationsCode(String specificationsCode) {
		this.specificationsCode = specificationsCode;
	}
	
	@Transient
	public String getDishesName() {
		return dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}

	@Transient
	public String getMaterialclassName() {
		return materialclassName;
	}

	public void setMaterialclassName(String materialclassName) {
		this.materialclassName = materialclassName;
	}
	
	@Transient
	public List<Specifications> getSpecificationsList() {
		return specificationsList;
	}

	public void setSpecificationsList(List<Specifications> specificationsList) {
		this.specificationsList = specificationsList;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	//@GeneratedValue(generator = "paymentableGenerator")
	//@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

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
	 *@return: java.lang.String  规格属性id
	 */

	@Column(name ="SPECIFICATIONS_ID",nullable=true,length=32)
	public java.lang.String getSpecificationsId(){
		return this.specificationsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格属性id
	 */
	public void setSpecificationsId(java.lang.String specificationsId){
		this.specificationsId = specificationsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料名称
	 *//*

	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	*//**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料名称
	 *//*
	public void setName(java.lang.String name){
		this.name = name;
	}*/
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料分类
	 */

	@Column(name ="MATERIAL_CLASSIFICATION",nullable=true,length=32)
	public java.lang.String getMaterialClassification(){
		return this.materialClassification;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料分类
	 */
	public void setMaterialClassification(java.lang.String materialClassification){
		this.materialClassification = materialClassification;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建来源
	 */

	@Column(name ="CREATE_SOURCE",nullable=true,length=32)
	public java.lang.String getCreateSource(){
		return this.createSource;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建来源
	 */
	public void setCreateSource(java.lang.String createSource){
		this.createSource = createSource;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  消耗数量
	 */

	@Column(name ="CONSUMPTION_QUANTITY",nullable=true,length=32)
	public java.lang.Integer getConsumptionQuantity(){
		return this.consumptionQuantity;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  消耗数量
	 */
	public void setConsumptionQuantity(java.lang.Integer consumptionQuantity){
		this.consumptionQuantity = consumptionQuantity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="UNIT",nullable=true,length=32)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料表
	 */

	@Column(name ="MATERIALCLASS_ID",nullable=true,length=32)
	public java.lang.String getMaterialclassId(){
		return this.materialclassId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料表
	 */
	public void setMaterialclassId(java.lang.String materialclassId){
		this.materialclassId = materialclassId;
	}
}
