package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 叫起整单
 * @author Administrator
 *
 */
public class EntireBill extends PrinterIp {
	
	//人数
	private String number;
	//账单号
	private String billMark;
	//桌名
	private String seatName;
	
	//菜列表
	private List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();
	
	//备注
	private String remark;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBillMark() {
		return billMark;
	}

	public void setBillMark(String billMark) {
		this.billMark = billMark;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
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
	
	
	
}