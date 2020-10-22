package com.maro.manager.dishes.dishesspecifications.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;

import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPriceShow;

/**   
 * @Title: Entity
 * @Description: 规格
 * @author onlineGenerator
 * @date 2018-03-23 14:28:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_dishes_specifications", schema = "")
@SuppressWarnings("serial")
public class MaroDishesSpecificationsEntity implements java.io.Serializable {
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
    @Excel(name="菜品id",width=15)
	private java.lang.String maroDishesId;
	/**规格码*/
    @Excel(name="规格码",width=15)
	private java.lang.String specificationsCode;
	/**规格名称*/
    @Excel(name="规格名称",width=15,dicCode="maro_specifications")
	private java.lang.String name;
	/**单价*/
    @Excel(name="单价",width=15)
	private java.lang.Double unitPrice;
	/**排序*/
    @Excel(name="排序",width=15)
	private java.lang.Integer ordershow;
	/**会员折扣方式*/
    @Excel(name="会员折扣方式",width=15,dicCode="maro_member_discoun")
	private java.lang.String memberDiscount;
	/**另设会员价时用*/
    @Excel(name="另设会员价时用",width=15)
	private java.lang.String discountWay;
    /** 菜肴code 与 规格的 code拼接 */
    private String dsCode;
    
    /** ===================铺助字段======================  */
    //规格名称
    private String pageName;
    //会员折扣方式中文
    private String pageMemberDiscount;
    //规格成分
    private List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList;
    //规格价格 页面展示的时候需要
    private List<SpecatinsPriceShow> specatinsPriceShow;
    
    @Transient
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	@Transient
    public String getPageMemberDiscount() {
		return pageMemberDiscount;
	}
	public void setPageMemberDiscount(String pageMemberDiscount) {
		this.pageMemberDiscount = pageMemberDiscount;
	}
	
	@Transient
	public List<MaroSpecificationsFoodCostsEntity> getMaroSpecificationsFoodCostsList() {
		return maroSpecificationsFoodCostsList;
	}
	public void setMaroSpecificationsFoodCostsList(
			List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList) {
		this.maroSpecificationsFoodCostsList = maroSpecificationsFoodCostsList;
	}
	
	@Transient
	public List<SpecatinsPriceShow> getSpecatinsPriceShow() {
		return specatinsPriceShow;
	}
	public void setSpecatinsPriceShow(List<SpecatinsPriceShow> specatinsPriceShow) {
		this.specatinsPriceShow = specatinsPriceShow;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="ID",nullable=false,length=20)
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
	 *@return: java.lang.String  菜品id
	 */
	
	@Column(name ="MARO_DISHES_ID",nullable=true,length=32)
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
	
	@Column(name ="SPECIFICATIONS_CODE",nullable=true,length=32)
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
	
	@Column(name ="NAME",nullable=true,length=32)
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
	
	@Column(name ="UNIT_PRICE",nullable=true,length=32)
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
	
	@Column(name ="ORDERSHOW",nullable=true,length=32)
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
	
	@Column(name ="MEMBER_DISCOUNT",nullable=true,length=32)
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
	
	@Column(name ="DISCOUNT_WAY",nullable=true,length=32)
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
	
	@Column(name ="DS_CODE",nullable=true,length=32)
	public String getDsCode() {
		return dsCode;
	}
	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}
	
	
}
