package com.maro.common.shop.pojo.entity;
import java.math.BigDecimal;
import java.util.Date;
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
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 店铺表
 * @author onlineGenerator
 * @date 2018-03-26 09:48:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_shop", schema = "")
@SuppressWarnings("serial")
public class MaroShopEntity implements java.io.Serializable {
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
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**所属店铺id*/
    @Excel(name="所属店铺id",width=15)
	private java.lang.String departId;
	/**设备编号id*/
	@Excel(name="设备编号",width=15)
	private java.lang.String equipmentNumber;
	/**店铺编号*/
    @Excel(name="店铺编号",width=15)
	private java.lang.String number;
	/**店铺类型*/
    @Excel(name="店铺类型",width=15,dicCode="maro_shop_type")
	private java.lang.Integer type;
	/**店铺所属地区*/
    @Excel(name="店铺所属地区",width=15)
	private java.lang.String area;
	/**店铺位置*/
    @Excel(name="店铺位置",width=15)
	private java.lang.String position;
	/**店铺经度*/
    @Excel(name="店铺经度",width=15)
	private java.lang.String la;
	/**店铺维度*/
    @Excel(name="店铺维度",width=15)
	private java.lang.String lo;
	/**店铺名称*/
    @Excel(name="店铺名称",width=15)
	private java.lang.String name;
	/**店铺电话*/
    @Excel(name="店铺电话",width=15)
	private java.lang.String phone;
	/**店铺邮箱*/
    @Excel(name="店铺邮箱",width=15)
	private java.lang.String mail;
	/**开业时间*/
    @Excel(name="开业时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date openTime;
	/**营业时间*/
    @Excel(name="营业时间",width=15)
	private java.lang.String workTime;
	/**店铺介绍*/
    @Excel(name="店铺介绍",width=15)
	private java.lang.String introduce;
	/**店铺图片*/
    @Excel(name="店铺图片",width=15)
	private java.lang.String picture;
	/**营业执照等*/
    @Excel(name="营业执照等",width=15)
	private java.lang.String shopInfo;
	/**人均消费*/
    @Excel(name="人均消费",width=15)
	private java.lang.String perConsume;
	/**删除标志*/
    @Excel(name="删除标志",width=15)
	private java.lang.Integer deleteFlag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
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
	 *@return: java.lang.String  流程状态
	 */
	
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属店铺id
	 */
	
	@Column(name ="DEPART_ID",nullable=true,length=36)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属店铺id
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  设备id
     */

    @Column(name ="EQUIPMENT_NUMBER",nullable=true,length=50)
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  设备id
     */
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    /**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺编号
	 */
	
	@Column(name ="NUMBER",nullable=true,length=36)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺编号
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  店铺类型
	 */
	
	@Column(name ="TYPE",nullable=true,length=1)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  店铺类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺所属地区
	 */
	
	@Column(name ="AREA",nullable=true,length=100)
	public java.lang.String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺所属地区
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺位置
	 */
	
	@Column(name ="POSITION",nullable=true,length=100)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺位置
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺经度
	 */
	
	@Column(name ="LA",nullable=true,length=32)
	public java.lang.String getLa(){
		return this.la;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺经度
	 */
	public void setLa(java.lang.String la){
		this.la = la;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺维度
	 */
	
	@Column(name ="LO",nullable=true,length=32)
	public java.lang.String getLo(){
		return this.lo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺维度
	 */
	public void setLo(java.lang.String lo){
		this.lo = lo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺名称
	 */
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺电话
	 */
	
	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺邮箱
	 */
	
	@Column(name ="MAIL",nullable=true,length=32)
	public java.lang.String getMail(){
		return this.mail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺邮箱
	 */
	public void setMail(java.lang.String mail){
		this.mail = mail;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开业时间
	 */
	
	@Column(name ="OPEN_TIME",nullable=true,length=32)
	public java.util.Date getOpenTime(){
		return this.openTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开业时间
	 */
	public void setOpenTime(java.util.Date openTime){
		this.openTime = openTime;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  营业时间
	 */
	
	@Column(name ="WORK_TIME",nullable=true,length=50)
	public java.lang.String getWorkTime(){
		return this.workTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  营业时间
	 */
	public void setWorkTime(java.lang.String workTime){
		this.workTime = workTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺介绍
	 */
	
	@Column(name ="INTRODUCE",nullable=true,length=100)
	public java.lang.String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺介绍
	 */
	public void setIntroduce(java.lang.String introduce){
		this.introduce = introduce;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺图片
	 */
	
	@Column(name ="PICTURE",nullable=true,length=500)
	public java.lang.String getPicture(){
		return this.picture;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺图片
	 */
	public void setPicture(java.lang.String picture){
		this.picture = picture;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照等
	 */
	
	@Column(name ="SHOP_INFO",nullable=true,length=500)
	public java.lang.String getShopInfo(){
		return this.shopInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照等
	 */
	public void setShopInfo(java.lang.String shopInfo){
		this.shopInfo = shopInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人均消费
	 */
	
	@Column(name ="PER_CONSUME",nullable=true,length=32)
	public java.lang.String getPerConsume(){
		return this.perConsume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人均消费
	 */
	public void setPerConsume(java.lang.String perConsume){
		this.perConsume = perConsume;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	
	@Column(name ="DELETE_FLAG",nullable=true,length=1)
	public java.lang.Integer getDeleteFlag(){
		return this.deleteFlag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setDeleteFlag(java.lang.Integer deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	
}
