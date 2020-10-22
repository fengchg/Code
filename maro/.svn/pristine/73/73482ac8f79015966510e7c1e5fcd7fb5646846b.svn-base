package com.maro.platform.web.system.pojo.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 统统同步表
 * @author onlineGenerator
 * @date 2018-06-21 14:22:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_mq_synchronous", schema = "")
@SuppressWarnings("serial")
public class MaroMqSynchronousEntity implements java.io.Serializable {
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
	/**公司ID*/
	@Excel(name="公司ID",width=15,dictTable ="t_s_depart",dicCode ="id",dicText ="departname")
	private java.lang.String departId;
	/**公司CODE*/
	@Excel(name="公司CODE",width=15)
	private java.lang.String departCode;
	/**操作类型*/
	@Excel(name="操作类型",width=15)
	private java.lang.String operationType;
	/**操作方法*/
	@Excel(name="操作方法",width=15)
	private java.lang.String operationMethod;
	/**数据表*/
	@Excel(name="数据表",width=15)
	private java.lang.String dataTable;
	/**表ID*/
	private java.lang.String dataTableId;
	/**备用字段*/
	private java.lang.String standbyA;
	/**备用字段*/
	private java.lang.String standbyB;
	/**备用字段*/
	private java.lang.String standbyC;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

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
	 *@return: java.lang.String  公司ID
	 */

	@Column(name ="DEPART_ID",nullable=true,length=32)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司ID
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司CODE
	 */

	@Column(name ="DEPART_CODE",nullable=true,length=32)
	public java.lang.String getDepartCode(){
		return this.departCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司CODE
	 */
	public void setDepartCode(java.lang.String departCode){
		this.departCode = departCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作类型
	 */

	@Column(name ="OPERATION_TYPE",nullable=true,length=32)
	public java.lang.String getOperationType(){
		return this.operationType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作类型
	 */
	public void setOperationType(java.lang.String operationType){
		this.operationType = operationType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作方法
	 */

	@Column(name ="OPERATION_METHOD",nullable=true,length=500)
	public java.lang.String getOperationMethod(){
		return this.operationMethod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作方法
	 */
	public void setOperationMethod(java.lang.String operationMethod){
		this.operationMethod = operationMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据表
	 */

	@Column(name ="DATA_TABLE",nullable=true,length=32)
	public java.lang.String getDataTable(){
		return this.dataTable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据表
	 */
	public void setDataTable(java.lang.String dataTable){
		this.dataTable = dataTable;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表ID
	 */

	@Column(name ="DATA_TABLE_ID",nullable=true,length=32)
	public java.lang.String getDataTableId(){
		return this.dataTableId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表ID
	 */
	public void setDataTableId(java.lang.String dataTableId){
		this.dataTableId = dataTableId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段
	 */

	@Column(name ="STANDBY_A",nullable=true,length=32)
	public java.lang.String getStandbyA(){
		return this.standbyA;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段
	 */
	public void setStandbyA(java.lang.String standbyA){
		this.standbyA = standbyA;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段
	 */

	@Column(name ="STANDBY_B",nullable=true,length=32)
	public java.lang.String getStandbyB(){
		return this.standbyB;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段
	 */
	public void setStandbyB(java.lang.String standbyB){
		this.standbyB = standbyB;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段
	 */

	@Column(name ="STANDBY_C",nullable=true,length=32)
	public java.lang.String getStandbyC(){
		return this.standbyC;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段
	 */
	public void setStandbyC(java.lang.String standbyC){
		this.standbyC = standbyC;
	}
}
