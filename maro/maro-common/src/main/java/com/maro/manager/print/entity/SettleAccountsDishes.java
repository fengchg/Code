package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

public class SettleAccountsDishes  extends PrinterIp{

	//组名
	private String className;
	
	//出品名称
	private String dishesName;
	//单价
	private String dishesPrice;
	//会员价
	private String vipPrice;
	//数量
	private String shuLiang;
	//总金额
	private String totalMoney;
	//单位
	private String unit;
	//备注
	private String remark;
	//类型 （表示是套餐 或 普通的 菜 或 其他）
	private String dishesType;
	//是否不曾菜  1增  
	private String isPresentDishes;
	//菜肴分类id
	private String dishesClassification;
	
	private List<SettleAccountsDishes> spsList = new ArrayList<SettleAccountsDishes>();
	
	
	public String getDishesClassification() {
		return dishesClassification;
	}
	public void setDishesClassification(String dishesClassification) {
		this.dishesClassification = dishesClassification;
	}
	public String getDishesName() {
		return dishesName;
	}
	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}
	public String getDishesPrice() {
		return dishesPrice;
	}
	public void setDishesPrice(String dishesPrice) {
		this.dishesPrice = dishesPrice;
	}
	public String getShuLiang() {
		return shuLiang;
	}
	public void setShuLiang(String shuLiang) {
		this.shuLiang = shuLiang;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<SettleAccountsDishes> getSpsList() {
		return spsList;
	}
	public void setSpsList(List<SettleAccountsDishes> spsList) {
		this.spsList = spsList;
	}
	public String getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDishesType() {
		return dishesType;
	}
	public void setDishesType(String dishesType) {
		this.dishesType = dishesType;
	}
	public String getIsPresentDishes() {
		return isPresentDishes;
	}
	public void setIsPresentDishes(String isPresentDishes) {
		this.isPresentDishes = isPresentDishes;
	}
	
	
}
