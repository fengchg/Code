package com.maro.manager.discount.page;

import com.maro.manager.discountdetail.entity.MaroDishesDiscountDetailEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import java.util.ArrayList;
import java.util.List;


/**   
 * @Title: Entity
 * @Description: 菜品打折
 * @author onlineGenerator
 * @date 2018-10-24 11:15:40
 * @version V1.0   
 *
 */
public class MaroDishesDiscountPage implements java.io.Serializable {
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
    @Excel(name="店铺id")
	private java.lang.String shopId;
	/**打折名称*/
    @Excel(name="打折名称")
	private java.lang.String discountName;
	/**打折详情*/
    @Excel(name="打折详情")
	private java.lang.String discountDetail;
	/**打折方式*/
	@Excel(name="打折方式")
	private java.lang.String discountWay;
	/**打折类型*/
    @Excel(name="打折类型")
	private java.lang.String discountType;
	/**开始日期*/
    @Excel(name="开始日期")
	private java.lang.Integer startWeek;
	/**结束日期*/
    @Excel(name="结束日期")
	private java.lang.Integer endWeek;
	/**开始日期*/
    @Excel(name="开始日期",format = "yyyy-MM-dd")
	private java.util.Date startTime;
	/**结束日期*/
    @Excel(name="结束日期",format = "yyyy-MM-dd")
	private java.util.Date endTime;
	/**打折数*/
    @Excel(name="打折数")
	private java.lang.Integer discountNumber;
	/**是否启用*/
    @Excel(name="是否启用")
	private java.lang.String isEnable;
	
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
	 *@return: java.lang.String  所属公司
	 */
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
	 *@return: java.lang.String  打折名称
	 */
	public java.lang.String getDiscountName(){
		return this.discountName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打折名称
	 */
	public void setDiscountName(java.lang.String discountName){
		this.discountName = discountName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打折详情
	 */
	public java.lang.String getDiscountDetail(){
		return this.discountDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打折详情
	 */
	public void setDiscountDetail(java.lang.String discountDetail){
		this.discountDetail = discountDetail;
	}

	public String getDiscountWay() {
		return discountWay;
	}

	public void setDiscountWay(String discountWay) {
		this.discountWay = discountWay;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  打折类型
	 */
	public java.lang.String getDiscountType(){
		return this.discountType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打折类型
	 */
	public void setDiscountType(java.lang.String discountType){
		this.discountType = discountType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  开始日期
	 */
	public java.lang.Integer getStartWeek(){
		return this.startWeek;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  开始日期
	 */
	public void setStartWeek(java.lang.Integer startWeek){
		this.startWeek = startWeek;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  结束日期
	 */
	public java.lang.Integer getEndWeek(){
		return this.endWeek;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结束日期
	 */
	public void setEndWeek(java.lang.Integer endWeek){
		this.endWeek = endWeek;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期
	 */
	public java.util.Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期
	 */
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期
	 */
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  打折数
	 */
	public java.lang.Integer getDiscountNumber(){
		return this.discountNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  打折数
	 */
	public void setDiscountNumber(java.lang.Integer discountNumber){
		this.discountNumber = discountNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否启用
	 */
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

	/**保存-详细*/
    @ExcelCollection(name="详细")
	private List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList = new ArrayList<MaroDishesDiscountDetailEntity>();
		public List<MaroDishesDiscountDetailEntity> getMaroDishesDiscountDetailList() {
		return maroDishesDiscountDetailList;
		}
		public void setMaroDishesDiscountDetailList(List<MaroDishesDiscountDetailEntity> maroDishesDiscountDetailList) {
		this.maroDishesDiscountDetailList = maroDishesDiscountDetailList;
		}
}
