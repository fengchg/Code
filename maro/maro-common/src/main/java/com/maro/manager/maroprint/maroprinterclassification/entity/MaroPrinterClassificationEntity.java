package com.maro.manager.maroprint.maroprinterclassification.entity;
import java.math.BigDecimal;
import java.util.Date;
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
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 菜肴分类打印IP
 * @author onlineGenerator
 * @date 2018-11-14 16:24:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "maro_printer_classification", schema = "")
@SuppressWarnings("serial")
public class MaroPrinterClassificationEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**打印机*/
    @Excel(name="打印机")
	private java.lang.String printrtId;
	/**菜肴分类*/
    @Excel(name="菜肴分类")
	private java.lang.String classificationId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	//@GeneratedValue(generator = "paymentableGenerator")
	//@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
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
	 *@return: java.lang.String  打印机
	 */
	
	@Column(name ="PRINTRT_ID",nullable=true,length=32)
	public java.lang.String getPrintrtId(){
		return this.printrtId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  打印机
	 */
	public void setPrintrtId(java.lang.String printrtId){
		this.printrtId = printrtId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜肴分类
	 */
	
	@Column(name ="CLASSIFICATION_ID",nullable=true,length=32)
	public java.lang.String getClassificationId(){
		return this.classificationId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜肴分类
	 */
	public void setClassificationId(java.lang.String classificationId){
		this.classificationId = classificationId;
	}
	
}
