package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

public class FlyoutMenu  extends PrinterIp{

	//桌名
	private String seatName;
	//账单号
	private String billMark;
	//备注
	private String remark;
	
	//商品集合
	private List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getBillMark() {
		return billMark;
	}

	public void setBillMark(String billMark) {
		this.billMark = billMark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SettleAccountsDishes> getDishesList() {
		return dishesList;
	}

	public void setDishesList(List<SettleAccountsDishes> dishesList) {
		this.dishesList = dishesList;
	}
	
	
}
