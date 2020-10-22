package com.maro.manager.datasynchronization.dishes.specificationsprice.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maro.common.util.Util;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPrice;
import com.maro.manager.dishes.specificationsprice.service.MaroSpecificationsPriceServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller  
 * @Description: 规格价格
 * @author onlineGenerator
 * @date 2018-04-12 10:46:02
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroSynchronizationSpecificationsPriceController")
public class MaroSynchronizationSpecificationsPriceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSynchronizationSpecificationsPriceController.class);

	@Autowired
	private MaroSpecificationsPriceServiceI maroSpecificationsPriceService;
	@Autowired
	private SystemService systemService;
	
	
	/**
	 * 添加规格价格
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd2")
	@ResponseBody
	public AjaxJson doAdd2(String message) {
		AjaxJson j = new AjaxJson();
		try{
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("specificationsPriceList", MaroSpecificationsPriceEntity.class);
			maroSpecificationsPriceService.updatePrice((SpecatinsPrice)Util.jsonToObject(message,0,classMap));
		}catch(Exception e){
			e.printStackTrace();
			message = "规格价格添加失败";
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	
}
