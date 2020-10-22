package com.maro.manager.dishes.setmealdishes.entity;

import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;

public class MaroAddSetmealSelectVO {
	
	//菜肴数量
	private java.lang.Integer beginNum;
	//选择数量
	private java.lang.Integer selectNum;

	//套餐类id
	private String setmealDishesId;
	
	//套餐菜列表
	private List<MaroSetmealDishesSelectEntity> setmealDishesSelect = new ArrayList<MaroSetmealDishesSelectEntity>();

	public String getSetmealDishesId() {
		return setmealDishesId;
	}

	public void setSetmealDishesId(String setmealDishesId) {
		this.setmealDishesId = setmealDishesId;
	}

	public List<MaroSetmealDishesSelectEntity> getSetmealDishesSelect() {
		return setmealDishesSelect;
	}

	public void setSetmealDishesSelect(
			List<MaroSetmealDishesSelectEntity> setmealDishesSelect) {
		this.setmealDishesSelect = setmealDishesSelect;
	}

	public java.lang.Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(java.lang.Integer beginNum) {
		this.beginNum = beginNum;
	}

	public java.lang.Integer getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(java.lang.Integer selectNum) {
		this.selectNum = selectNum;
	}	
	
	
	
	
}
