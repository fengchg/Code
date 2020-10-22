package com.maro.manager.datasynchronization.dishes.dishesclassification.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesClassificationEntity;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.util.Util;
import com.maro.manager.dishes.dishesclassification.service.MaroDishesClassificationServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller  
 * @Description: 菜肴分类
 * @author onlineGenerator
 * @date 2018-03-31 20:32:07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroSynchronizationDishesClassificationController")
public class MaroSynchronizationDishesClassificationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSynchronizationDishesClassificationController.class);

	@Autowired
	private MaroDishesClassificationServiceI maroDishesClassificationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	
	
	/**
	 * 删除菜肴分类
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroDishesClassificationService.delete((MaroDishesClassificationEntity)Util.jsonToObject(message,0));
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴分类删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	


	/**
	 * 添加菜肴分类
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(String message) {
		AjaxJson j = new AjaxJson();
		try{
			maroDishesClassificationService.save((MaroDishesClassificationEntity)Util.jsonToObject(message,0));
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜肴分类添加失败";
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新菜肴分类
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(String message) {
		AjaxJson j = new AjaxJson();
		try {
			maroDishesClassificationService.saveOrUpdate((MaroDishesClassificationEntity)Util.jsonToObject(message,0));
		} catch (Exception e) {
			e.printStackTrace();
			message = "菜肴分类更新失败";
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	
}
