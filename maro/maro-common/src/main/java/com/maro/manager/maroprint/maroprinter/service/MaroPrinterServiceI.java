package com.maro.manager.maroprint.maroprinter.service;
import java.util.List;
import java.util.Map;

import com.maro.manager.maroprint.maroprinter.entity.MaroPrinterEntity;
import com.maro.manager.maroprint.maroprinterclassification.entity.MaroPrinterClassificationEntity;
import com.maro.platform.core.common.service.CommonService;

public interface MaroPrinterServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 	
	 */
	public void addMain(MaroPrinterEntity maroPrinter,List<MaroPrinterClassificationEntity> maroPrinterClassificationList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MaroPrinterEntity maroPrinter,List<MaroPrinterClassificationEntity> maroPrinterClassificationList);
	
	public void delMain (MaroPrinterEntity maroPrinter);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MaroPrinterEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MaroPrinterEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MaroPrinterEntity t);
 	
 	
 	//查询打印机ip是否存在
 	public Integer examinePrinterIp(String shopId,String ip);
 	
 	//查询此分类是否有匹配打印机
 	public Map examineClassification(String shopId,String classificationId);
}
