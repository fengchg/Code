package com.maro.manager.maroprint.maroprinter.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 打印机
 * @author onlineGenerator
 * @date 2018-11-14 16:24:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_printer", schema = "")
@SuppressWarnings("serial")
public class MaroPrinterEntity implements java.io.Serializable {
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
	/**IP地址*/
    @Excel(name="IP地址")
	private java.lang.String printerIp;
	/**端口*/
    @Excel(name="端口")
	private java.lang.Integer printerPort;
	/**名称*/
    @Excel(name="名称")
	private java.lang.String printerName;
	/**位置*/
    @Excel(name="位置")
	private java.lang.String printerLocation;
	/**备用*/
	private java.lang.String printerStandby1;
	/**备用*/
	private java.lang.String printerStandby2;
	/**备用*/
	private java.lang.String printerStandby3;
	
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
	 *@return: java.lang.String  IP地址
	 */
	
	@Column(name ="PRINTER_IP",nullable=true,length=32)
	public java.lang.String getPrinterIp(){
		return this.printerIp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  IP地址
	 */
	public void setPrinterIp(java.lang.String printerIp){
		this.printerIp = printerIp;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  端口
	 */
	
	@Column(name ="PRINTER_PORT",nullable=true,length=32)
	public java.lang.Integer getPrinterPort(){
		return this.printerPort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  端口
	 */
	public void setPrinterPort(java.lang.Integer printerPort){
		this.printerPort = printerPort;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	
	@Column(name ="PRINTER_NAME",nullable=true,length=32)
	public java.lang.String getPrinterName(){
		return this.printerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setPrinterName(java.lang.String printerName){
		this.printerName = printerName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  位置
	 */
	
	@Column(name ="PRINTER_LOCATION",nullable=true,length=32)
	public java.lang.String getPrinterLocation(){
		return this.printerLocation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  位置
	 */
	public void setPrinterLocation(java.lang.String printerLocation){
		this.printerLocation = printerLocation;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用
	 */
	
	@Column(name ="PRINTER_STANDBY1",nullable=true,length=32)
	public java.lang.String getPrinterStandby1(){
		return this.printerStandby1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用
	 */
	public void setPrinterStandby1(java.lang.String printerStandby1){
		this.printerStandby1 = printerStandby1;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用
	 */
	
	@Column(name ="PRINTER_STANDBY2",nullable=true,length=32)
	public java.lang.String getPrinterStandby2(){
		return this.printerStandby2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用
	 */
	public void setPrinterStandby2(java.lang.String printerStandby2){
		this.printerStandby2 = printerStandby2;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用
	 */
	
	@Column(name ="PRINTER_STANDBY3",nullable=true,length=32)
	public java.lang.String getPrinterStandby3(){
		return this.printerStandby3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用
	 */
	public void setPrinterStandby3(java.lang.String printerStandby3){
		this.printerStandby3 = printerStandby3;
	}
	
}