package com.maro.manager.homepage.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StatementVo {
	
	private String shopName;
	
	//今日营业额
	private String today;
	
	// 本周营业额
	private String this_week;
	
	//本月营业额
	private String this_month;
	
	//饼图
	private Map<String,Double> peiCollectedAmount;
	
	private List<PeiVo> peiList;
	
	//================天======================
	//24小时
	private String hour[];
	//应收金额
	private double receivable_amount[];
	//实收金额
	private double collected_amount[];
	
	/*//================月========================
	//24小时
	private String month[];
	//应收金额
	private double month_receivable_amount[];
	//实收金额
	private double month_collected_amount[];

	//================年========================
	//24小时
	private String year[] = new String[12];
	//应收金额
	private double year_receivable_amount[] = new double[12];
	//实收金额
	private double year_collected_amount[] = new double[12];*/
	
	
	public StatementVo(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int m = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		/*month = new String[m];
		month_receivable_amount = new double[m];
		month_collected_amount = new double[m];*/
	}
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getThis_week() {
		return this_week;
	}
	public void setThis_week(String this_week) {
		this.this_week = this_week;
	}
	public String getThis_month() {
		return this_month;
	}
	public void setThis_month(String this_month) {
		this.this_month = this_month;
	}
	public String[] getHour() {
		return hour;
	}
	public void setHour(String[] hour) {
		this.hour = hour;
	}
	public double[] getReceivable_amount() {
		return receivable_amount;
	}
	public void setReceivable_amount(double[] receivable_amount) {
		this.receivable_amount = receivable_amount;
	}
	public double[] getCollected_amount() {
		return collected_amount;
	}
	public void setCollected_amount(double[] collected_amount) {
		this.collected_amount = collected_amount;
	}
	public Map<String, Double> getPeiCollectedAmount() {
		return peiCollectedAmount;
	}
	public void setPeiCollectedAmount(Map<String, Double> peiCollectedAmount) {
		this.peiCollectedAmount = peiCollectedAmount;
	}
	public List<PeiVo> getPeiList() {
		return peiList;
	}
	public void setPeiList(List<PeiVo> peiList) {
		this.peiList = peiList;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
	
	
}
