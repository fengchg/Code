package com.maro.common.dishes.dishes.pojo.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import com.maro.common.dishes.dishes.pojo.vo.MaroCommonDishesSpecificationsEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesEntity;

/**   
 * @Title: Entity
 * @Description: 菜肴表
 * @author onlineGenerator
 * @date 2018-03-23 14:28:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_dishes", schema = "")
@SuppressWarnings("serial")
public class MaroDishesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
    @Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属门店*/
    @Excel(name="所属门店",width=15,dictTable ="t_s_depart",dicCode ="id",dicText ="departname")
	private java.lang.String sysCompanyCode;
	/**编码*/
    @Excel(name="编码",width=15)
	private java.lang.String coding;
	/**菜品名称*/
    @Excel(name="菜品名称",width=15)
	private java.lang.String dishesName;
	/**拼音码*/
    @Excel(name="拼音码",width=15)
	private java.lang.String pinyinCode;
	/**类型*/
    @Excel(name="类型",width=15,dicCode="maro_dis_type")
	private java.lang.String type;
	/**成本价格*/
    @Excel(name="成本价格",width=15)
	private java.lang.Double costPrice;
	/**销售价格*/
    @Excel(name="销售价格",width=15)
	private java.lang.Double salesPrice;
	/**网售*/
	private java.lang.String netSales;
	/**外卖*/
	private java.lang.String takeOut;
	/**预订*/
	private java.lang.String booking;
	/**创建来源*/
    @Excel(name="创建来源",width=15)
	private java.lang.String createSource;
	/**描述*/
    @Excel(name="描述",width=15)
	private java.lang.String describes;
	/**图片*/
    @Excel(name="图片",width=15)
	private java.lang.String picture;
	/**库存*/
    @Excel(name="库存",width=15)
	private java.lang.Integer inventory;
	/**单位*/
    @Excel(name="单位",width=15,dicCode="maro_unit_name")
	private java.lang.String unit;
	/**规格属性*/
    @Excel(name="规格属性",width=15)
	private java.lang.String specificationsId;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String noteId;
	/**原料分类*/
    @Excel(name="原料分类",width=15)
	private java.lang.String classificationId;
	/**菜品分类*/
    @Excel(name="菜品分类",width=15)
	private java.lang.String dishesClassification;
    /** 制作方式 */
    private String makeWay;
    /** 口味分类*/
    private String tasteCassification;
    /** 标签*/
    private String theLabel;
    /** 是否要打荷 */
    private Integer accomplish;
  
    /**套餐类型*/
    @Excel(name="套餐类型",width=15)
	private java.lang.String setmealType;
	/**套餐价*/
    @Excel(name="套餐价",width=15)
	private java.lang.String packagePrice;
	/**会员价*/
    @Excel(name="会员价",width=15)
	private java.lang.String memberPrice;
	/**销售状态*/
    @Excel(name="销售状态",width=15,dicCode="maro_setmeal_type")
	private java.lang.Integer marketType;
    
    
    //=====================补助字段===================================
    // 规格 
	private List<MaroCommonDishesSpecificationsEntity> specificationsList;
	// 单位 
	private String unitName;
	// 制作方式 
    private String makeWayName;
    // 口味分类
    private String tasteCassificationName;
    // 标签
    private String theLabelName;
    // 类型
    private String typeName;
    // 菜品分类
    private String dishesClassificationName;
    
    //用于菜肴是否能编辑，  只能编辑自已的菜肴 t：可编辑  f:不可以编辑
    private String tf;
    
    //套餐类
    private List<MaroSetmealDishesEntity> setmealSishesList;
    
    //======================== 特殊地方需要用到   (原料模块 》》添加规格成本》》选择菜肴时用到) ======================================
    //规格码
    private String specificationsCode;
    //规格名称
    private String specificationsName;
    //规格id
    private String specificationId;
    
    
    
    
    @Transient
    public List<MaroSetmealDishesEntity> getSetmealSishesList() {
		return setmealSishesList;
	}

	public void setSetmealSishesList(List<MaroSetmealDishesEntity> setmealSishesList) {
		this.setmealSishesList = setmealSishesList;
	}

	@Transient
    public String getTf() {
		return tf;
	}

	public void setTf(String tf) {
		this.tf = tf;
	}

	@Transient
    public String getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}

	@Transient
    public String getSpecificationsCode() {
		return specificationsCode;
	}

	public void setSpecificationsCode(String specificationsCode) {
		this.specificationsCode = specificationsCode;
	}

	@Transient
    public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}

	@Transient
    public String getDishesClassificationName() {
		return dishesClassificationName;
	}

	public void setDishesClassificationName(String dishesClassificationName) {
		this.dishesClassificationName = dishesClassificationName;
	}

	@Transient
    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Transient
	public String getMakeWayName() {
		return makeWayName;
	}

	public void setMakeWayName(String makeWayName) {
		this.makeWayName = makeWayName;
	}

	@Transient
	public String getTasteCassificationName() {
		return tasteCassificationName;
	}

	public void setTasteCassificationName(String tasteCassificationName) {
		this.tasteCassificationName = tasteCassificationName;
	}

	@Transient
	public String getTheLabelName() {
		return theLabelName;
	}

	public void setTheLabelName(String theLabelName) {
		this.theLabelName = theLabelName;
	}

	@Transient
	public List<MaroCommonDishesSpecificationsEntity> getSpecificationsList() {
		return specificationsList;
	}

	public void setSpecificationsList(
			List<MaroCommonDishesSpecificationsEntity> specificationsList) {
		this.specificationsList = specificationsList;
	}
	
	@Transient
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	 *@return: java.lang.String  所属门店
	 */
	
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属门店
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编码
	 */
	
	@Column(name ="CODING",nullable=true,length=32)
	public java.lang.String getCoding(){
		return this.coding;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编码
	 */
	public void setCoding(java.lang.String coding){
		this.coding = coding;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜品名称
	 */
	
	@Column(name ="DISHES_NAME",nullable=true,length=32)
	public java.lang.String getDishesName(){
		return this.dishesName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜品名称
	 */
	public void setDishesName(java.lang.String dishesName){
		this.dishesName = dishesName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  拼音码
	 */
	
	@Column(name ="PINYIN_CODE",nullable=true,length=32)
	public java.lang.String getPinyinCode(){
		return this.pinyinCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  拼音码
	 */
	public void setPinyinCode(java.lang.String pinyinCode){
		this.pinyinCode = pinyinCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	
	@Column(name ="TYPE",nullable=true,length=32)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  成本价格
	 */
	
	@Column(name ="COST_PRICE",nullable=true,length=32)
	public java.lang.Double getCostPrice(){
		return this.costPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  成本价格
	 */
	public void setCostPrice(java.lang.Double costPrice){
		this.costPrice = costPrice;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  销售价格
	 */
	
	@Column(name ="SALES_PRICE",nullable=true,length=32)
	public java.lang.Double getSalesPrice(){
		return this.salesPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  销售价格
	 */
	public void setSalesPrice(java.lang.Double salesPrice){
		this.salesPrice = salesPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网售
	 */
	
	@Column(name ="NET_SALES",nullable=true,length=32)
	public java.lang.String getNetSales(){
		return this.netSales;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网售
	 */
	public void setNetSales(java.lang.String netSales){
		this.netSales = netSales;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外卖
	 */
	
	@Column(name ="TAKE_OUT",nullable=true,length=32)
	public java.lang.String getTakeOut(){
		return this.takeOut;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外卖
	 */
	public void setTakeOut(java.lang.String takeOut){
		this.takeOut = takeOut;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预订
	 */
	
	@Column(name ="BOOKING",nullable=true,length=32)
	public java.lang.String getBooking(){
		return this.booking;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预订
	 */
	public void setBooking(java.lang.String booking){
		this.booking = booking;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	
	@Column(name ="DESCRIBES",nullable=true,length=32)
	public java.lang.String getDescribes(){
		return this.describes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescribes(java.lang.String describes){
		this.describes = describes;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	
	@Column(name ="PICTURE",nullable=true,length=32)
	public java.lang.String getPicture(){
		return this.picture;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setPicture(java.lang.String picture){
		this.picture = picture;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  库存
	 */
	
	@Column(name ="INVENTORY",nullable=true,length=10)
	public java.lang.Integer getInventory(){
		return this.inventory;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  库存
	 */
	public void setInventory(java.lang.Integer inventory){
		this.inventory = inventory;
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
	 *@return: java.lang.String  规格属性
	 */
	
	@Column(name ="SPECIFICATIONS_ID",nullable=true,length=32)
	public java.lang.String getSpecificationsId(){
		return this.specificationsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格属性
	 */
	public void setSpecificationsId(java.lang.String specificationsId){
		this.specificationsId = specificationsId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="NOTE_ID",nullable=true,length=32)
	public java.lang.String getNoteId(){
		return this.noteId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNoteId(java.lang.String noteId){
		this.noteId = noteId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料分类
	 */
	
	@Column(name ="CLASSIFICATION_ID",nullable=true,length=32)
	public java.lang.String getClassificationId(){
		return this.classificationId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料分类
	 */
	public void setClassificationId(java.lang.String classificationId){
		this.classificationId = classificationId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜品分类
	 */
	
	@Column(name ="DISHES_CLASSIFICATION",nullable=true,length=32)
	public java.lang.String getDishesClassification(){
		return this.dishesClassification;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜品分类
	 */
	public void setDishesClassification(java.lang.String dishesClassification){
		this.dishesClassification = dishesClassification;
	}

	@Column(name ="MAKE_WAY",nullable=true,length=32)
	public String getMakeWay() {
		return makeWay;
	}

	public void setMakeWay(String makeWay) {
		this.makeWay = makeWay;
	}

	@Column(name ="TASTE_CASSIFICATION",nullable=true,length=32)
	public String getTasteCassification() {
		return tasteCassification;
	}

	public void setTasteCassification(String tasteCassification) {
		this.tasteCassification = tasteCassification;
	}

	@Column(name ="THE_LABEL",nullable=true,length=32)
	public String getTheLabel() {
		return theLabel;
	}

	public void setTheLabel(String theLabel) {
		this.theLabel = theLabel;
	}

	@Column(name ="ACCOMPLISH",nullable=true,length=32)
	public Integer getAccomplish() {
		return accomplish;
	}

	public void setAccomplish(Integer accomplish) {
		this.accomplish = accomplish;
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
	
	
}
