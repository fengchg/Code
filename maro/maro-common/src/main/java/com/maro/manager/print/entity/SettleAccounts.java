package com.maro.manager.print.entity;

import java.util.ArrayList;
import java.util.List;

import com.maro.client.module.serverorder.pojo.vo.MaroClientPayedDetailVO;

/**
 * 结账单 预结单
 * @author Administrator
 *
 */
public class SettleAccounts extends PrinterIp {
	
	//结账单 预结单
	private String titleName;
	//桌名
	private String seatName;
	//人数
	private int renShu;
	//账单号
	private String billNumber;
	//开台时间
	private String beginTime;
	//结账时间
	private String settleTime;
	//服务员
	private String waiter;
	//收银员
	private String cashier;
	//会员姓名
	private String member;
	//原价合计金额
	private String zongJie;
	//服务费
	private String serviceCharge;
	//应收金额
	private String amountDeceivable;
	//会员合计
	private String memberTotal;
	//抹零
	private String smallChange;
	
	// !isPre--> 结账单    
	private boolean isPre;
	
	//支付方式
	List<MaroClientPayedDetailVO> objects = new ArrayList<MaroClientPayedDetailVO>();
	
	//详情列表
	private List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public int getRenShu() {
		return renShu;
	}

	public void setRenShu(int renShu) {
		this.renShu = renShu;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}

	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getZongJie() {
		return zongJie;
	}

	public void setZongJie(String zongJie) {
		this.zongJie = zongJie;
	}


	public List<SettleAccountsDishes> getDishesList() {
		return dishesList;
	}

	public void setDishesList(List<SettleAccountsDishes> dishesList) {
		this.dishesList = dishesList;
	}

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getAmountDeceivable() {
		return amountDeceivable;
	}

	public void setAmountDeceivable(String amountDeceivable) {
		this.amountDeceivable = amountDeceivable;
	}

	public String getMemberTotal() {
		return memberTotal;
	}

	public void setMemberTotal(String memberTotal) {
		this.memberTotal = memberTotal;
	}

	public List<MaroClientPayedDetailVO> getObjects() {
		return objects;
	}

	public void setObjects(List<MaroClientPayedDetailVO> objects) {
		this.objects = objects;
	}

	public String getSmallChange() {
		return smallChange;
	}

	public void setSmallChange(String smallChange) {
		this.smallChange = smallChange;
	}

	public boolean getIsPre() {
		return isPre;
	}

	public void setIsPre(boolean isPre) {
		this.isPre = isPre;
	}




	
	
}
