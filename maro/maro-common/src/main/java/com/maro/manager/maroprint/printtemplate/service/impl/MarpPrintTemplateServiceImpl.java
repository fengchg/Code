package com.maro.manager.maroprint.printtemplate.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.util.MqUtil;
import com.maro.manager.maroprint.maroprinter.entity.MaroPrinterEntity;
import com.maro.manager.maroprint.printtemplate.entity.MaroPrintTemplateEntity;
import com.maro.manager.maroprint.printtemplate.service.MarpPrintTemplateServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.MyClassLoader;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("marpPrintTemplateService")
@Transactional
public class MarpPrintTemplateServiceImpl extends CommonServiceImpl implements MarpPrintTemplateServiceI {

	
 	public void delete(MaroPrintTemplateEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(MaroPrintTemplateEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}	
 	
 	public void saveOrUpdate(MaroPrintTemplateEntity entity) throws Exception{
 		
 		super.saveOrUpdate(entity);
 		/**=====发送给MQ========*/
 		if(ResourceUtil.getParameter("fromPath")==null||ResourceUtil.getParameter("fromPath").equals("")){
 			String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
 			MqUtil.remoteOpt(orgCode,"marpSynchronizationPrintTemplateController","doUpdate",entity);
 		}
 		
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(MaroPrintTemplateEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(MaroPrintTemplateEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(MaroPrintTemplateEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(MaroPrintTemplateEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("name", t.getName());
		map.put("code", t.getCode());
		map.put("url", t.getUrl());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,MaroPrintTemplateEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{url}",String.valueOf(t.getUrl()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("marp_print_template",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public Map<String, Integer> getPrinterId(String printCode) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//先根据打印机的code获得实体数据
		MaroPrintTemplateEntity printTemplateEntitysuper = super.findUniqueByProperty(MaroPrintTemplateEntity.class, "code", printCode);
		//在根据打印机的id获得IP与port
		if(printTemplateEntitysuper.getUrl()!=null && !"".equals(printTemplateEntitysuper.getUrl())){
			MaroPrinterEntity printerEntitysuper = super.getEntity(MaroPrinterEntity.class, printTemplateEntitysuper.getUrl());
			map.put(printerEntitysuper.getPrinterIp(), printerEntitysuper.getPrinterPort());
		}
		
		return map;
	}
}