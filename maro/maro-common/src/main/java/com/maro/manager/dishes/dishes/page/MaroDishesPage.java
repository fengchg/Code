
package com.maro.manager.dishes.dishes.page;
import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;

/**   
 * @Title: Entity
 * @Description: 菜肴表
 * @author onlineGenerator
 * @date 2018-03-23 14:28:45
 * @version V1.0   
 *
 */
public class MaroDishesPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
    @Excel(name="创建日期",format = "yyyy-MM-dd")
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
    @Excel(name="所属门店")
	private java.lang.String sysCompanyCode;
	/**编码*/
    @Excel(name="编码")
	private java.lang.String coding;
	/**菜品名称*/
    @Excel(name="菜品名称")
	private java.lang.String dishesName;
	/**拼音码*/
    @Excel(name="拼音码")
	private java.lang.String pinyinCode;
	/**类型*/
    @Excel(name="类型")
	private java.lang.String type;
	/**成本价格*/
    @Excel(name="成本价格")
	private java.lang.Double costPrice;
	/**销售价格*/
    @Excel(name="销售价格")
	private java.lang.Double salesPrice;
	/**网售*/
	private java.lang.String netSales;
	/**外卖*/
	private java.lang.String takeOut;
	/**预订*/
	private java.lang.String booking;
	/**创建来源*/
    @Excel(name="创建来源")
	private java.lang.String createSource;
	/**描述*/
    @Excel(name="描述")
	private java.lang.String describes;
	/**图片*/
    @Excel(name="图片")
	private java.lang.String picture;
	/**库存*/
    @Excel(name="库存")
	private java.lang.Integer inventory;
	/**单位*/
    @Excel(name="单位")
	private java.lang.String unit;
	/**规格属性*/
    @Excel(name="规格属性")
	private java.lang.String specificationsId;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String noteId;
	/**原料分类*/
    @Excel(name="原料分类")
	private java.lang.String classificationId;
	/**菜品分类*/
    @Excel(name="菜品分类")
	private java.lang.String dishesClassification;
    /** 制作方式 */
    private String makeWay;
    /** 口味分类*/
    private String tasteCassification;
    /** 标签*/
    private String theLabel;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	 *@return: java.lang.String  所属门店
	 */
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
	
	

	public String getMakeWay() {
		return makeWay;
	}

	public void setMakeWay(String makeWay) {
		this.makeWay = makeWay;
	}

	public String getTasteCassification() {
		return tasteCassification;
	}

	public void setTasteCassification(String tasteCassification) {
		this.tasteCassification = tasteCassification;
	}

	public String getTheLabel() {
		return theLabel;
	}

	public void setTheLabel(String theLabel) {
		this.theLabel = theLabel;
	}



	/**保存-规格*/
    @ExcelCollection(name="规格")
	private List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList = new ArrayList<MaroDishesSpecificationsEntity>();
		public List<MaroDishesSpecificationsEntity> getMaroDishesSpecificationsList() {
		return maroDishesSpecificationsList;
		}
		public void setMaroDishesSpecificationsList(List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList) {
		this.maroDishesSpecificationsList = maroDishesSpecificationsList;
		}
}
