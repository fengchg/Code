package com.maro.common.dishes.dishes.pojo.vo;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 规格
 * @author onlineGenerator
 * @date 2018-03-23 14:28:43
 * @version V1.0   
 *
 */
public class MaroCommonDishesSpecificationsEntity{
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
	/**菜品id*/
	private java.lang.String maroDishesId;
	/**规格码*/
	private java.lang.String specificationsCode;
	/**规格名称*/
	private java.lang.String name;
	/**单价*/
	private java.lang.Double unitPrice;
	/**排序*/
	private java.lang.Integer ordershow;
	/**会员折扣方式*/
	private java.lang.String memberDiscount;
	/**另设会员价时用*/
	private java.lang.String discountWay;
    
    /** ===================铺助字段======================  */
    //规格名称
    private String pageName;
    //会员折扣方式
    private String pageMemberDiscount;
    
    
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String getPageMemberDiscount() {
		return pageMemberDiscount;
	}
	public void setPageMemberDiscount(String pageMemberDiscount) {
		this.pageMemberDiscount = pageMemberDiscount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
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
	 *@return: java.lang.String  菜品id
	 */
	
	public java.lang.String getMaroDishesId(){
		return this.maroDishesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜品id
	 */
	public void setMaroDishesId(java.lang.String maroDishesId){
		this.maroDishesId = maroDishesId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格码
	 */
	
	public java.lang.String getSpecificationsCode(){
		return this.specificationsCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格码
	 */
	public void setSpecificationsCode(java.lang.String specificationsCode){
		this.specificationsCode = specificationsCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格名称
	 */
	
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */
	
	public java.lang.Double getUnitPrice(){
		return this.unitPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setUnitPrice(java.lang.Double unitPrice){
		this.unitPrice = unitPrice;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	
	public java.lang.Integer getOrdershow(){
		return this.ordershow;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setOrdershow(java.lang.Integer ordershow){
		this.ordershow = ordershow;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会员折扣方式
	 */
	
	public java.lang.String getMemberDiscount(){
		return this.memberDiscount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会员折扣方式
	 */
	public void setMemberDiscount(java.lang.String memberDiscount){
		this.memberDiscount = memberDiscount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  另设会员价时用
	 */
	
	public java.lang.String getDiscountWay(){
		return this.discountWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  另设会员价时用
	 */
	public void setDiscountWay(java.lang.String discountWay){
		this.discountWay = discountWay;
	}
	
}
