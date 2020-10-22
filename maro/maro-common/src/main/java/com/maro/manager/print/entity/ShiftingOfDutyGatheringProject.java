package com.maro.manager.print.entity;

/**
 * 收款项目
 * @author Administrator
 *
 */
public class ShiftingOfDutyGatheringProject {
	
	//支付方式
	private String projectName;
	
	//笔数
	private String strokeCount;
	
	//金额
	private String money;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStrokeCount() {
		return strokeCount;
	}

	public void setStrokeCount(String strokeCount) {
		this.strokeCount = strokeCount;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
}
