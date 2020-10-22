package com.maro.manager.shop.reserve.entity;

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
 * @Description: maro_client_reserve
 * @author onlineGenerator
 * @date 2018-04-16 15:06:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_client_reserve", schema = "")
@SuppressWarnings("serial")
public class MaroClientReserveEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**店铺主键*/
	@Excel(name="店铺主键",width=15)
	private java.lang.String restaurantId;
	/**店铺名称*/
	@Excel(name="店铺名称",width=15)
	private java.lang.String restaurantName;
	/**桌位主键*/
	@Excel(name="桌位主键",width=15)
	private java.lang.String destSeatId;
	/**桌位号*/
	@Excel(name="桌位号",width=15)
	private java.lang.String destSeatCode;
	/**桌位名*/
	@Excel(name="桌位名",width=15)
	private java.lang.String destSeatName;
	/**顾客姓名*/
	@Excel(name="顾客姓名",width=15)
	private java.lang.String customerName;
	/**手机号码*/
	@Excel(name="手机号码",width=15)
	private java.lang.String phone;
	/**就餐人数*/
	@Excel(name="就餐人数",width=15)
	private java.lang.Integer personNumber;
	/**预定时间*/
	@Excel(name="预定时间",width=15)
	private java.lang.Long reserveTime;
	/**订单类型*/
	@Excel(name="订单类型",width=15)
	private java.lang.Integer type;
	/**订金*/
	@Excel(name="订金",width=15)
	private java.lang.String deposit;
	/**内容*/
	@Excel(name="内容",width=15)
	private java.lang.String content;
	/**状态*/
	@Excel(name="状态",width=15)
	private java.lang.Integer status;
	/**时段*/
	@Excel(name="时段",width=15)
	private java.lang.Integer period;
	/**预计到来时间*/
	@Excel(name="预计到来时间",width=15)
	private java.lang.Long planComeTime;
	
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
	 *@return: java.lang.String  店铺主键
	 */

	@Column(name ="RESTAURANT_ID",nullable=true,length=36)
	public java.lang.String getRestaurantId(){
		return this.restaurantId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺主键
	 */
	public void setRestaurantId(java.lang.String restaurantId){
		this.restaurantId = restaurantId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店铺名称
	 */

	@Column(name ="RESTAURANT_NAME",nullable=true,length=20)
	public java.lang.String getRestaurantName(){
		return this.restaurantName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店铺名称
	 */
	public void setRestaurantName(java.lang.String restaurantName){
		this.restaurantName = restaurantName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  桌位主键
	 */

	@Column(name ="DEST_SEAT_ID",nullable=true,length=36)
	public java.lang.String getDestSeatId(){
		return this.destSeatId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  桌位主键
	 */
	public void setDestSeatId(java.lang.String destSeatId){
		this.destSeatId = destSeatId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  桌位号
	 */

	@Column(name ="DEST_SEAT_CODE",nullable=true,length=36)
	public java.lang.String getDestSeatCode(){
		return this.destSeatCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  桌位号
	 */
	public void setDestSeatCode(java.lang.String destSeatCode){
		this.destSeatCode = destSeatCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  桌位名
	 */

	@Column(name ="DEST_SEAT_NAME",nullable=true,length=20)
	public java.lang.String getDestSeatName(){
		return this.destSeatName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  桌位名
	 */
	public void setDestSeatName(java.lang.String destSeatName){
		this.destSeatName = destSeatName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客姓名
	 */

	@Column(name ="CUSTOMER_NAME",nullable=true,length=20)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客姓名
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */

	@Column(name ="PHONE",nullable=true,length=11)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  就餐人数
	 */

	@Column(name ="PERSON_NUMBER",nullable=true,length=10)
	public java.lang.Integer getPersonNumber(){
		return this.personNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  就餐人数
	 */
	public void setPersonNumber(java.lang.Integer personNumber){
		this.personNumber = personNumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  预定时间
	 */

	@Column(name ="RESERVE_TIME",nullable=true,length=19)
	public java.lang.Long getReserveTime(){
		return this.reserveTime;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预定时间
	 */
	public void setReserveTime(java.lang.Long reserveTime){
		this.reserveTime = reserveTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单类型
	 */

	@Column(name ="TYPE",nullable=true,length=10)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订金
	 */

	@Column(name ="DEPOSIT",nullable=true,length=6)
	public java.lang.String getDeposit(){
		return this.deposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订金
	 */
	public void setDeposit(java.lang.String deposit){
		if(deposit!=null&&!deposit.equals(""))
		this.deposit = deposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */

	@Column(name ="CONTENT",nullable=true,length=1000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */

	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时段
	 */

	@Column(name ="PERIOD",nullable=true,length=10)
	public java.lang.Integer getPeriod(){
		return this.period;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时段
	 */
	public void setPeriod(java.lang.Integer period){
		this.period = period;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  预计到来时间
	 */

	@Column(name ="PLAN_COME_TIME",nullable=true,length=19)
	public java.lang.Long getPlanComeTime(){
		return this.planComeTime;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预计到来时间
	 */
	public void setPlanComeTime(java.lang.Long planComeTime){
		this.planComeTime = planComeTime;
	}
}
