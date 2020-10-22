package com.maro.manager.homepage.entity;

public class PeiVo {
		
	//菜品名称
	private String dishes_name;
	//规格名称
	private String typename;
	//菜品规格价格
	private Double unit_price;
	//消费笔数
	private Integer frequency_quantity;
	//消费总额
	private Double frequency_amount;
	//
	private Double all_amount;
	//实收占比
	private Double paid_in_proportion;
	
	
	public String getDishes_name() {
		return dishes_name;
	}
	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	public Integer getFrequency_quantity() {
		return frequency_quantity;
	}
	public void setFrequency_quantity(Integer frequency_quantity) {
		this.frequency_quantity = frequency_quantity;
	}
	public Double getFrequency_amount() {
		return frequency_amount;
	}
	public void setFrequency_amount(Double frequency_amount) {
		this.frequency_amount = frequency_amount;
	}
	public Double getAll_amount() {
		return all_amount;
	}
	public void setAll_amount(Double all_amount) {
		this.all_amount = all_amount;
	}
	public Double getPaid_in_proportion() {
		return paid_in_proportion;
	}
	public void setPaid_in_proportion(Double paid_in_proportion) {
		this.paid_in_proportion = paid_in_proportion;
	}
	
	
}
