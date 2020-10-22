package com.maro.manager.datasynchronization.dishes.materialclass.controller;
import io.swagger.annotations.Api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesclassification.service.MaroDishesClassificationServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.dishesspecifications.service.MaroDishesSpecificationsServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.page.MaroMaterialClassPage;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 原料表
 * @author onlineGenerator
 * @date 2018-03-29 16:46:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroSynchronizationMaterialClassController")
public class MaroSynchronizationMaterialClassController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSynchronizationMaterialClassController.class);

	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private MaroDishesSpecificationsServiceI maroDishesSpecificationsService;
	@Autowired
	private MaroDishesServiceI maroDishesService;
	@Autowired
	private MaroDishesClassificationServiceI maroDishesClassificationService;
	@Autowired
	private MaroShopServiceI maroShopService;
	
	
	/**
	 * 删除原料表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(String message) {
		AjaxJson aj = new AjaxJson();
		//maroMaterialClass = systemService.getEntity(MaroMaterialClassEntity.class, maroMaterialClass.getId());
		//String message = "原料表删除成功";
		try{
			maroMaterialClassService.delMain((MaroMaterialClassEntity)Util.jsonToObject(message,0));
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原料表删除失败";
			aj.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return aj;
	}


	/**
	 * 更新原料表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(String message) {
		AjaxJson aj = new AjaxJson();
		//List<MaroSpecificationsFoodCostsEntity> maroSpecificationsFoodCostsList =  maroMaterialClassPage.getMaroSpecificationsFoodCostsList();
		//String message = "更新成功";
		try{
			maroMaterialClassService.updateMain((MaroMaterialClassEntity)Util.jsonToObject(message,0), (List<MaroSpecificationsFoodCostsEntity>)Util.jsonToObject(message,1));
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新原料表失败";
			aj.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return aj;
	}
	
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroMaterialClassService.addMain((MaroMaterialClassEntity)Util.jsonToObject(message,0), (List<MaroSpecificationsFoodCostsEntity>)Util.jsonToObject(message,1));
		}catch(Exception e){
			e.printStackTrace();
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		
		return j;
	}

	
}
