package com.maro.manager.datasynchronization.maroprint.printtemplate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.Util;
import com.maro.manager.maroprint.maroprinter.entity.MaroPrinterEntity;
import com.maro.manager.maroprint.printtemplate.entity.MaroPrintTemplateEntity;
import com.maro.manager.maroprint.printtemplate.service.MarpPrintTemplateServiceI;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
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
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;


/**   
 * @Title: Controller  
 * @Description: 打印
 * @author onlineGenerator
 * @date 2018-09-17 20:57:54
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/marpSynchronizationPrintTemplateController")
public class MarpSynchronizationPrintTemplateController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MarpSynchronizationPrintTemplateController.class);

	@Autowired
	private MarpPrintTemplateServiceI marpPrintTemplateService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private MaroShopServiceI maroShopService;
	
	
	/**
	 * 更新打印
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(String message) {
		AjaxJson j = new AjaxJson();
		try {
			marpPrintTemplateService.saveOrUpdate((MaroPrintTemplateEntity)Util.jsonToObject(message,0));
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return j;
	}
	

}