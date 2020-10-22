package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 外卖单
 * @author Administrator
 *
 */
public class TakeOutSingle extends PrinterIp {
	
	//订餐时间
	private String orderTime;
	//接单时间
	private String receivingTime;
	//平台订单号
	private String orderNumber;
	//备注
	private String remark; 
	//活动
	private String activity;
	//发票
	private String invoice;
	//税号
	private String dutyParagraph;
	//商品集合
	private List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();
	//配送费
	private String deliveryCost;
	//餐盒费
	private String MealsFee;
	//减满优惠
	private String preferentialReduction;
	//新用户优惠
	private String newUserUiscounts;
	//已在线支付
	private String onLinePayment;
	//地址
	private String address;
	//电话
	private String phone;
	//名称
	private String userName;
	
	
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getReceivingTime() {
		return receivingTime;
	}
	public void setReceivingTime(String receivingTime) {
		this.receivingTime = receivingTime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getDutyParagraph() {
		return dutyParagraph;
	}
	public void setDutyParagraph(String dutyParagraph) {
		this.dutyParagraph = dutyParagraph;
	}
	public String getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(String deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public String getMealsFee() {
		return MealsFee;
	}
	public void setMealsFee(String mealsFee) {
		MealsFee = mealsFee;
	}
	public String getPreferentialReduction() {
		return preferentialReduction;
	}
	public void setPreferentialReduction(String preferentialReduction) {
		this.preferentialReduction = preferentialReduction;
	}
	public String getNewUserUiscounts() {
		return newUserUiscounts;
	}
	public void setNewUserUiscounts(String newUserUiscounts) {
		this.newUserUiscounts = newUserUiscounts;
	}
	public String getOnLinePayment() {
		return onLinePayment;
	}
	public void setOnLinePayment(String onLinePayment) {
		this.onLinePayment = onLinePayment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<SettleAccountsDishes> getDishesList() {
		return dishesList;
	}
	public void setDishesList(List<SettleAccountsDishes> dishesList) {
		this.dishesList = dishesList;
	}
	
	
}
