package com.maro.manager.datasynchronization.dishes.setmeal;
import io.swagger.annotations.Api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.maro.manager.dishes.setmeal.entity.MaroSetmealEntity;
import com.maro.manager.dishes.setmeal.page.MaroSetmealPage;
import com.maro.manager.dishes.setmeal.service.MaroSetmealServiceI;
import com.maro.manager.dishes.setmealdishes.entity.MaroAddSetmealSelectVO;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesEntity;
import com.maro.manager.dishes.setmealdishes.entity.MaroSetmealDishesSelectEntity;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPrice;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 套餐
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Api(value="MaroSetmeal",description="套餐",tags="maroSetmealController")
@Controller
@RequestMapping("/maroSynchronizationSetmealController")
public class MaroSynchronizationSetmealController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSynchronizationSetmealController.class);

	@Autowired
	private MaroSetmealServiceI maroSetmealService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	

	
	/**
	 * 删除套餐菜
	 * @param selectId
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doDelSetmealDishesSelect")
	@ResponseBody
	public AjaxJson doDelSetmealDishesSelect(String message) {
		AjaxJson j = new AjaxJson();
		maroSetmealService.doDelSetmealDishesSelect((String)Util.jsonToObject(message,0));
		return j;
	}


	/**
	 * 删除套餐
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroSetmealService.delMain2((MaroDishesEntity)Util.jsonToObject(message,0));
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return j;
	}



	/**
	 * 添加套餐
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroSetmealService.addMain2((MaroDishesEntity)Util.jsonToObject(message,0),(List<MaroSetmealDishesEntity>)Util.jsonToObject(message,1));
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return j;
	}
	
	/**
	 * 添加套餐类中的菜
	 */
	@RequestMapping(params = "doAddDishesSelect")
	@ResponseBody
	public AjaxJson doAddDishesSelect(String message) {
		AjaxJson j = new AjaxJson();
		
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("setmealDishesSelect", MaroSetmealDishesSelectEntity.class);
		//添加之前删除原有的
		maroSetmealService.doAddDishesSelect((MaroAddSetmealSelectVO)Util.jsonToObject(message,0,classMap));

		return j;
	}
	
	/**
	 * 更新套餐
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroSetmealService.updateMain2((MaroDishesEntity)Util.jsonToObject(message,0),(List<MaroSetmealDishesEntity>)Util.jsonToObject(message,1));
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	
}