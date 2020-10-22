package com.maro.manager.dishes.setmealdishes.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;

import javax.xml.soap.Text;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SequenceGenerator;

import org.jeecgframework.poi.excel.annotation.Excel;

import com.maro.manager.dishes.specificationsfoodcosts.entity.Specifications;

/**   
 * @Title: Entity
 * @Description: 套餐菜肴
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_setmeal_dishes_select", schema = "")
@SuppressWarnings("serial")
public class MaroSetmealDishesSelectEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	//套餐id
	private java.lang.String setmealishesId;
	//规格id
	private java.lang.String specificationsId;
	//数量
	private java.lang.Integer dishesNum;
	private java.lang.Integer defaultSelect;

    
    
    /** ================铺助字段============== */
	//规格码
	private String specificationsCode;
	//规格名称
	private String specificationsName;
	//菜肴ID
	private String dishesId;
	//菜肴名字
	private String dishesName;
	//菜肴Code
	private String dishesUnitCode;
	//菜肴单位
	private String dishesUnit;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	/*@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")*/
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}

	@Column(name ="SETMEAL_DISHES_ID",nullable=false,length=36)
	public java.lang.String getSetmealishesId() {
		return setmealishesId;
	}

	public void setSetmealishesId(java.lang.String setmealishesId) {
		this.setmealishesId = setmealishesId;
	}

	@Column(name ="SPECIFICATIONS_ID",nullable=false,length=36)
	public java.lang.String getSpecificationsId() {
		return specificationsId;
	}

	public void setSpecificationsId(java.lang.String specificationsId) {
		this.specificationsId = specificationsId;
	}

	@Column(name ="DISHES_NUM",nullable=false,length=36)
	public java.lang.Integer getDishesNum() {
		return dishesNum;
	}

	public void setDishesNum(java.lang.Integer dishesNum) {
		this.dishesNum = dishesNum;
	}

	@Column(name ="DEFAULT_SELECT",nullable=false,length=36)
	public java.lang.Integer getDefaultSelect() {
		return defaultSelect;
	}

	public void setDefaultSelect(java.lang.Integer defaultSelect) {
		this.defaultSelect = defaultSelect;
	}

	@Transient
	public String getSpecificationsCode() {
		return specificationsCode;
	}

	public void setSpecificationsCode(String specificationsCode) {
		this.specificationsCode = specificationsCode;
	}

	@Transient
	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}

	@Transient
	public String getDishesName() {
		return dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}

	@Transient
	public String getDishesUnit() {
		return dishesUnit;
	}

	public void setDishesUnit(String dishesUnit) {
		this.dishesUnit = dishesUnit;
	}

	@Transient
	public String getDishesId() {
		return dishesId;
	}

	public void setDishesId(String dishesId) {
		this.dishesId = dishesId;
	}

	@Transient
	public String getDishesUnitCode() {
		return dishesUnitCode;
	}

	public void setDishesUnitCode(String dishesUnitCode) {
		this.dishesUnitCode = dishesUnitCode;
	}
	
	
	
	
	
}