package com.maro.manager.discountdetail.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 详细
 * @author onlineGenerator
 * @date 2018-10-24 11:15:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_dishes_discount_detail", schema = "")
@SuppressWarnings("serial")
public class MaroDishesDiscountDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**主表id*/
    @Excel(name="主表id",width=15)
	private java.lang.String discountId;
	/**菜品id*/
    @Excel(name="菜品id",width=15)
	private java.lang.String dishesId;
	//规格id
	private java.lang.String specificationsId;
    //菜品中文名
	private java.lang.String dishName;
	//规格中文名
	private java.lang.String specificationsName;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表id
	 */
	
	@Column(name ="DISCOUNT_ID",nullable=true,length=36)
	public java.lang.String getDiscountId(){
		return this.discountId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表id
	 */
	public void setDiscountId(java.lang.String discountId){
		this.discountId = discountId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜品id
	 */
	
	@Column(name ="DISHES_ID",nullable=true,length=36)
	public java.lang.String getDishesId(){
		return this.dishesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜品id
	 */
	public void setDishesId(java.lang.String dishesId){
		this.dishesId = dishesId;
	}

	@Transient
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	@Column(name ="SPECIFICATIONS_ID",nullable=true,length=36)
	public String getSpecificationsId() {
		return specificationsId;
	}

	public void setSpecificationsId(String specificationsId) {
		this.specificationsId = specificationsId;
	}

	@Transient
	public String getSpecificationsName() {
		return specificationsName;
	}

	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}
}