package com.maro.manager.maroprint.printtemplate.entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 打印
 * @author onlineGenerator
 * @date 2018-09-17 20:57:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_print_template", schema = "")
@SuppressWarnings("serial")
public class MaroPrintTemplateEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**名称*/
	@Excel(name="名称")
	private java.lang.String name;
	/**code*/
	@Excel(name="code")
	private java.lang.String code;
	/**路径*/
	@Excel(name="路径")
	private java.lang.String url;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  code
	 */
	@Column(name ="CODE",nullable=true,length=32)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  code
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  路径
	 */
	@Column(name ="URL",nullable=true,length=300)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  路径
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
}
