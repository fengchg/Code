package com.maro.manager.shop.reserve.vo;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.net.ntp.TimeStamp;

import com.maro.platform.core.util.DateUtils;

/**   
 * @Title: Entity
 * @Description: maro_client_reserve
 * @author onlineGenerator
 * @date 2018-04-16 15:06:30
 * @version V1.0   
 *
 */
public class MaroClientReserveEntityVO implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**店铺主键*/
	
	private java.lang.String restaurantId;
	/**店铺名称*/
	
	private java.lang.String restaurantName;
	/**桌位主键*/
	
	private java.lang.String destSeatId;
	/**桌位号*/
	
	private java.lang.String destSeatCode;
	/**桌位名*/
	
	private java.lang.String destSeatName;
	/**顾客姓名*/
	
	private java.lang.String customerName;
	/**手机号码*/
	
	private java.lang.String phone;
	/**就餐人数*/
	
	private java.lang.Integer personNumber;
	/**预定时间*/
	
	private Date reserveTime;
	/**订单类型*/
	
	private java.lang.Integer type;
	/**订金*/
	
	private java.lang.String deposit;
	/**内容*/
	
	private java.lang.String content;
	/**状态*/
	
	private java.lang.Integer status;
	/**时段*/
	
	private java.lang.Integer period;
	/**预计到来时间*/
	
	private Date planComeTime;

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
	 *@return: java.lang.String  店铺主键
	 */

	
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

	
	public Date getReserveTime(){
		//return this.reserveTime;
		if(this.reserveTime!=null){
			return new Timestamp(this.reserveTime.getTime());
		}
		return null;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预定时间
	 */
	public void setReserveTime(Long reserveTime){
		if(reserveTime!=null)
		this.reserveTime = DateUtils.getDate(reserveTime);
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单类型
	 */

	
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

	
	public java.lang.String getDeposit(){
		return this.deposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订金
	 */
	public void setDeposit(java.lang.String deposit){
		this.deposit = deposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */

	
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

	
	public Date getPlanComeTime(){
		if(this.planComeTime!=null){
			return new Timestamp(this.planComeTime.getTime());
		}
		return null;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预计到来时间
	 */
	public void setPlanComeTime(Long planComeTime){
		if(planComeTime!=null)
		this.planComeTime = DateUtils.getDate(planComeTime);
	}
}
