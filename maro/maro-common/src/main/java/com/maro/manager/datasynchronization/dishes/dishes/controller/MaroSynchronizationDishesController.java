package com.maro.manager.datasynchronization.dishes.dishes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.dishes.dishes.page.MaroDishesPage;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.dishes.materialclassification.service.MaroMaterialClassificationServiceI;
import com.maro.manager.dishes.specificationsfoodcosts.service.MaroSpecificationsFoodCostsServiceI;
import com.maro.manager.dishes.specificationsprice.service.MaroSpecificationsPriceServiceI;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.dao.ICommonDao;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 菜肴表
 * @author onlineGenerator
 * @date 2018-03-23 14:28:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroSynchronizationDishesController")
public class MaroSynchronizationDishesController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSynchronizationDishesController.class);

	@Autowired
	private MaroDishesServiceI maroDishesService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private MaroSpecificationsFoodCostsServiceI maroSpecificationsFoodCostsService;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private MaroMaterialClassificationServiceI maroMaterialClassificationService;
	@Autowired
	private MaroSpecificationsPriceServiceI maroSpecificationsPriceService;
	@Autowired
	private MaroShopServiceI maroShopService;
	@Autowired
	private ICommonDao commonDao;
	

	/**
	 * 删除菜肴表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroDishesService.delMain((MaroDishesEntity)Util.jsonToObject(message,0));
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表删除失败";
			throw new BusinessException(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 更新菜肴表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroDishesService.updateMain((MaroDishesEntity)Util.jsonToObject(message,0), (List<MaroDishesSpecificationsEntity>)Util.jsonToObject(message,1));
			systemService.addLog("更新菜肴成功", Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新菜肴表失败";
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	
	/**
	 * 添加菜肴表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroDishesService.addMain((MaroDishesEntity)Util.jsonToObject(message,0),(List<MaroDishesSpecificationsEntity>)Util.jsonToObject(message,1));
		}catch(Exception e){
			e.printStackTrace();
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 批量删除菜肴表
	 * 
	 * @return
	 */
	/*public void doBatchDel(String ids,HttpServletRequest request){
		String message = "菜肴表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroDishesEntity maroDishes = systemService.getEntity(MaroDishesEntity.class,id);
				maroDishesService.delMain(maroDishes);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表删除失败";
			throw new BusinessException(e.getMessage());
		}
	}*/

	/**
	 * 添加菜肴表
	 * 
	 * @param ids
	 * @return
	 *//*
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public void doAdd(MaroDishesEntity maroDishes,MaroDishesPage maroDishesPage) {
		List<MaroDishesSpecificationsEntity> maroDishesSpecificationsList =  maroDishesPage.getMaroDishesSpecificationsList();
		String message = "添加成功";
		try{
			if(maroDishes.getSysCompanyCode()!=null && !"".equals(maroDishes.getSysCompanyCode())){
				
			}else{
				//标识为全部的菜肴
				maroDishes.setSysCompanyCode("0");
			}
			maroDishesService.addMain(maroDishes, maroDishesSpecificationsList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴表添加失败";
			throw new BusinessException(e.getMessage());
		}
	}*/
	

}
