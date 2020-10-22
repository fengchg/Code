package com.maro.manager.maroprint.maroprinter.dao;

import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface MaroPrinterDao {

	/* 查询打印机ip是否存在
	 * @param coding
	 * @return
	 */
	@Arguments({"shopId","ip"})
	@Sql("select count(0) from maro_printer where sys_company_code = :shopId and printer_ip = :ip")
	Integer examinePrinterIp(String shopId,String ip);
	
	
	@Arguments({"shopId","classificationId"})
	Map examineClassification(String shopId,String classificationId);
	
}
