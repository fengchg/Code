package com.maro.manager.dishes.specificationsprice.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 页面展示时补助
 * @author Administrator
 *
 */
public class SpecatinsPriceShow {
	
	//部门id
	private String deprtId;
	//部门名称
	private String deprtName;
	//价格
	private String price;

	
	public String getDeprtId() {
		return deprtId;
	}
	public void setDeprtId(String deprtId) {
		this.deprtId = deprtId;
	}
	public String getDeprtName() {
		return deprtName;
	}
	public void setDeprtName(String deprtName) {
		this.deprtName = deprtName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	
	
}
