package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 单品崔菜单
 * @author Administrator
 *
 */
public class SingleUrge  extends PrinterIp{
	
	//桌名
	private String seatName;
	//人数
	private String number;
	//催菜时间
	private String urgeDishesTime;
	//账单号
	private String billMark;
	//服务员
	private String waiter;
	//菜品列表
	private List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();
	//备注
	private String remark;
	//整单备注
	private String wholeRemark;
	
	
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getUrgeDishesTime() {
		return urgeDishesTime;
	}
	public void setUrgeDishesTime(String urgeDishesTime) {
		this.urgeDishesTime = urgeDishesTime;
	}
	public String getBillMark() {
		return billMark;
	}
	public void setBillMark(String billMark) {
		this.billMark = billMark;
	}
	public String getWaiter() {
		return waiter;
	}
	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}
	public List<SettleAccountsDishes> getDishesList() {
		return dishesList;
	}
	public void setDishesList(List<SettleAccountsDishes> dishesList) {
		this.dishesList = dishesList;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWholeRemark() {
		return wholeRemark;
	}
	public void setWholeRemark(String wholeRemark) {
		this.wholeRemark = wholeRemark;
	}
	
	
	
}