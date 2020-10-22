
package com.maro.manager.dishes.materialclass.page;
import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;

/**   
 * @Title: Entity
 * @Description: 原料表
 * @author onlineGenerator
 * @date 2018-03-29 16:46:35
 * @version V1.0   
 *
 */
public class MaroMaterialClassPage implements java.io.Serializable {
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
	/**原料名称*/
    @Excel(name="原料名称")
	private java.lang.String materialName;
	/**原料编码*/
    @Excel(name="原料编码")
	private java.lang.String coding;
	/**原料类型*/
    @Excel(name="原料类型")
	private java.lang.String type;
	/**原料分类*/
    @Excel(name="原料分类")
	private java.lang.String classificationId;
	/**计价单位*/
    @Excel(name="计价单位")
	private java.lang.String denominatedUnit;
	/**采购价*/
    @Excel(name="采购价")
	private java.lang.String purchasingPrice;
	/**创建来源*/
    @Excel(name="创建来源")
	private java.lang.String createSource;
	
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
	 *@return: java.lang.String  原料名称
	 */
	public java.lang.String getMaterialName(){
		return this.materialName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料名称
	 */
	public void setMaterialName(java.lang.String materialName){
		this.materialName = materialName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料编码
	 */
	public java.lang.String getCoding(){
		return this.coding;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料编码
	 */
	public void setCoding(java.lang.String coding){
		this.coding = coding;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原料类型
	 */
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原料类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
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
	 *@return: java.lang.String  计价单位
	 */
	public java.lang.String getDenominatedUnit(){
		return this.denominatedUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计价单位
	 */
	public void setDenominatedUnit(java.lang.String denominatedUnit){
		this.denominatedUnit = denominatedUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购价
	 */
	public java.lang.String getPurchasingPrice(){
		return this.purchasingPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购价
	 */
	public void setPurchasingPrice(java.lang.String purchasingPrice){
		this.purchasingPrice = purchasingPrice;
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

	/**保存-规格成本*/
    @ExcelCollection(name="规格成本")
	private List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList = new ArrayList<MaroSpecificationsFoodCostsEntity>();
		public List<MaroSpecificationsFoodCostsEntity> getMaroSpecificationsFoodCostsList() {
		return maroSpecificationsFoodCostsList;
		}
		public void setMaroSpecificationsFoodCostsList(List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList) {
		this.maroSpecificationsFoodCostsList = maroSpecificationsFoodCostsList;
		}
}
