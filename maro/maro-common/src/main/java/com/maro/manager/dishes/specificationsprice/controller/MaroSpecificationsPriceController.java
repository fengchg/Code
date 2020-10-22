package com.maro.manager.dishes.specificationsprice.controller;
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
import com.maro.common.util.UUIDUtil;
import com.maro.manager.dishes.specificationsfoodcosts.entity.MaroSpecificationsFoodCostsEntity;
import com.maro.manager.dishes.specificationsfoodcosts.page.MaroSpecificationsFoodCostsPage;
import com.maro.manager.dishes.specificationsfoodcosts.service.MaroSpecificationsFoodCostsServiceI;
import com.maro.manager.dishes.specificationsprice.entity.MaroSpecificationsPriceEntity;
import com.maro.manager.dishes.specificationsprice.entity.SpecatinsPrice;
import com.maro.manager.dishes.specificationsprice.service.MaroSpecificationsPriceServiceI;
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
 * @Description: 规格价格
 * @author onlineGenerator
 * @date 2018-04-12 10:46:02
 * @version V1.0   
 *
 */
@Api(value="MaroSpecificationsPrice",description="规格价格",tags="maroSpecificationsPriceController")
@Controller
@RequestMapping("/maroSpecificationsPriceController")
public class MaroSpecificationsPriceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroSpecificationsPriceController.class);

	@Autowired
	private MaroSpecificationsPriceServiceI maroSpecificationsPriceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 规格价格列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/dishes/specificationsprice/maroSpecificationsPriceList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(MaroSpecificationsPriceEntity maroSpecificationsPrice,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroSpecificationsPriceEntity.class, dataGrid);
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroSpecificationsPrice, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroSpecificationsPriceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除规格价格
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroSpecificationsPriceEntity maroSpecificationsPrice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroSpecificationsPrice = systemService.getEntity(MaroSpecificationsPriceEntity.class, maroSpecificationsPrice.getId());
		message = "规格价格删除成功";
		try{
			maroSpecificationsPriceService.delete(maroSpecificationsPrice);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "规格价格删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除规格价格
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规格价格删除成功";
		try{
			for(String id:ids.split(",")){
				MaroSpecificationsPriceEntity maroSpecificationsPrice = systemService.getEntity(MaroSpecificationsPriceEntity.class, 
				id
				);
				maroSpecificationsPriceService.delete(maroSpecificationsPrice);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "规格价格删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加规格价格
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroSpecificationsPriceEntity maroSpecificationsPrice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规格价格添加成功";
		try{
			maroSpecificationsPriceService.save(maroSpecificationsPrice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "规格价格添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 添加规格价格
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd2")
	@ResponseBody
	public AjaxJson doAdd2(SpecatinsPrice specatinsPrice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规格价格添加成功";
		try{
			//先根据规格id 删除原先的规格价格在进行保存
			UUIDUtil.setId(specatinsPrice.getSpecificationsPriceList());
			maroSpecificationsPriceService.updatePrice(specatinsPrice);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "规格价格添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新规格价格
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroSpecificationsPriceEntity maroSpecificationsPrice, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规格价格更新成功";
		MaroSpecificationsPriceEntity t = maroSpecificationsPriceService.get(MaroSpecificationsPriceEntity.class, maroSpecificationsPrice.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroSpecificationsPrice, t);
			maroSpecificationsPriceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "规格价格更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 规格价格新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroSpecificationsPriceEntity maroSpecificationsPrice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroSpecificationsPrice.getId())) {
			maroSpecificationsPrice = maroSpecificationsPriceService.getEntity(MaroSpecificationsPriceEntity.class, maroSpecificationsPrice.getId());
			req.setAttribute("maroSpecificationsPricePage", maroSpecificationsPrice);
		}
		return new ModelAndView("com/maro/manager/dishes/specificationsprice/maroSpecificationsPrice-add");
	}
	/**
	 * 规格价格编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroSpecificationsPriceEntity maroSpecificationsPrice, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroSpecificationsPrice.getId())) {
			maroSpecificationsPrice = maroSpecificationsPriceService.getEntity(MaroSpecificationsPriceEntity.class, maroSpecificationsPrice.getId());
			req.setAttribute("maroSpecificationsPricePage", maroSpecificationsPrice);
		}
		return new ModelAndView("com/maro/manager/dishes/specificationsprice/maroSpecificationsPrice-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroSpecificationsPriceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroSpecificationsPriceEntity maroSpecificationsPrice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroSpecificationsPriceEntity.class, dataGrid);
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroSpecificationsPrice, request.getParameterMap());
		List<MaroSpecificationsPriceEntity> maroSpecificationsPrices = this.maroSpecificationsPriceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"规格价格");
		modelMap.put(NormalExcelConstants.CLASS,MaroSpecificationsPriceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("规格价格列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroSpecificationsPrices);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroSpecificationsPriceEntity maroSpecificationsPrice,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"规格价格");
    	modelMap.put(NormalExcelConstants.CLASS,MaroSpecificationsPriceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("规格价格列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<MaroSpecificationsPriceEntity> listMaroSpecificationsPriceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroSpecificationsPriceEntity.class,params);
				for (MaroSpecificationsPriceEntity maroSpecificationsPrice : listMaroSpecificationsPriceEntitys) {
					maroSpecificationsPriceService.save(maroSpecificationsPrice);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="规格价格列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroSpecificationsPriceEntity>> list() {
		List<MaroSpecificationsPriceEntity> listMaroSpecificationsPrices=maroSpecificationsPriceService.getList(MaroSpecificationsPriceEntity.class);
		return Result.success(listMaroSpecificationsPrices);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取规格价格信息",notes="根据ID获取规格价格信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroSpecificationsPriceEntity task = maroSpecificationsPriceService.get(MaroSpecificationsPriceEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取规格价格信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建规格价格")
	public ResponseMessage<?> create(@ApiParam(name="规格价格对象")@RequestBody MaroSpecificationsPriceEntity maroSpecificationsPrice, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroSpecificationsPriceEntity>> failures = validator.validate(maroSpecificationsPrice);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroSpecificationsPriceService.save(maroSpecificationsPrice);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("规格价格信息保存失败");
		}
		return Result.success(maroSpecificationsPrice);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新规格价格",notes="更新规格价格")
	public ResponseMessage<?> update(@ApiParam(name="规格价格对象")@RequestBody MaroSpecificationsPriceEntity maroSpecificationsPrice) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroSpecificationsPriceEntity>> failures = validator.validate(maroSpecificationsPrice);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroSpecificationsPriceService.saveOrUpdate(maroSpecificationsPrice);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新规格价格信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新规格价格信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除规格价格")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroSpecificationsPriceService.deleteEntityById(MaroSpecificationsPriceEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("规格价格删除失败");
		}

		return Result.success();
	}
}
