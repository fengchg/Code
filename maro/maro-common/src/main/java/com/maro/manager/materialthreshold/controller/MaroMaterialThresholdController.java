package com.maro.manager.materialthreshold.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.materialthreshold.entity.MaroMaterialThresholdEntity;
import com.maro.manager.materialthreshold.service.MaroMaterialThresholdServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**   
 * @Title: Controller  
 * @Description: 原料阈值配置
 * @author onlineGenerator
 * @date 2018-09-05 15:11:43
 * @version V1.0   
 *
 */
@Api(value="MaroMaterialThreshold",description="原料阈值配置",tags="maroMaterialThresholdController")
@Controller
@RequestMapping("/maroMaterialThresholdController")
public class MaroMaterialThresholdController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroMaterialThresholdController.class);

	@Autowired
	private MaroMaterialThresholdServiceI maroMaterialThresholdService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;


	/**
	 * 原料阈值配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/materialthreshold/maroMaterialThresholdList");
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
	public void datagrid(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroMaterialThresholdEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroMaterialThreshold, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroMaterialThresholdService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除原料阈值配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroMaterialThreshold = systemService.getEntity(MaroMaterialThresholdEntity.class, maroMaterialThreshold.getId());
		message = "原料阈值配置删除成功";
		try{
			maroMaterialThresholdService.delete(maroMaterialThreshold);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原料阈值配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除原料阈值配置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原料阈值配置删除成功";
		try{
			for(String id:ids.split(",")){
				MaroMaterialThresholdEntity maroMaterialThreshold = systemService.getEntity(MaroMaterialThresholdEntity.class, 
				id
				);
				maroMaterialThresholdService.delete(maroMaterialThreshold);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "原料阈值配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加原料阈值配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原料阈值配置添加成功";
		try{
			String shopId=null;
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			if(!admin){
				String userId = ResourceUtil.getSessionUser().getId();
				shopId=UtilService.getShopIdByUserId(userId);
			}
			maroMaterialThreshold.setShopId(shopId);
			UUIDUtil.setId(maroMaterialThreshold);
			maroMaterialThresholdService.save(maroMaterialThreshold);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(DataIntegrityViolationException e){
			e.printStackTrace();
			message = "已配置此原料信息！";
		}catch(Exception e){
			e.printStackTrace();
			message = "原料阈值配置添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新原料阈值配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原料阈值配置更新成功";
		MaroMaterialThresholdEntity t = maroMaterialThresholdService.get(MaroMaterialThresholdEntity.class, maroMaterialThreshold.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroMaterialThreshold, t);
			maroMaterialThresholdService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch(DataIntegrityViolationException e){
			e.printStackTrace();
			message = "已配置此原料信息！";
		}catch (Exception e) {
			e.printStackTrace();
			message = "原料阈值配置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 原料阈值配置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMaterialThreshold.getId())) {
			maroMaterialThreshold = maroMaterialThresholdService.getEntity(MaroMaterialThresholdEntity.class, maroMaterialThreshold.getId());
			req.setAttribute("maroMaterialThresholdPage", maroMaterialThreshold);
		}
		return new ModelAndView("com/maro/manager/materialthreshold/maroMaterialThreshold-add");
	}
	/**
	 * 原料阈值配置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroMaterialThresholdEntity maroMaterialThreshold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMaterialThreshold.getId())) {
			maroMaterialThreshold = maroMaterialThresholdService.getEntity(MaroMaterialThresholdEntity.class, maroMaterialThreshold.getId());
			MaroMaterialClassEntity m=maroMaterialThresholdService.get(MaroMaterialClassEntity.class, maroMaterialThreshold.getMaterialClassId());
			if(m!=null){
				maroMaterialThreshold.setMaterialClassIdString(m.getMaterialName());
			}
			req.setAttribute("maroMaterialThresholdPage", maroMaterialThreshold);
		}
		return new ModelAndView("com/maro/manager/materialthreshold/maroMaterialThreshold-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroMaterialThresholdController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroMaterialThresholdEntity maroMaterialThreshold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroMaterialThresholdEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroMaterialThreshold, request.getParameterMap());
		List<MaroMaterialThresholdEntity> maroMaterialThresholds = this.maroMaterialThresholdService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"原料阈值配置");
		modelMap.put(NormalExcelConstants.CLASS,MaroMaterialThresholdEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("原料阈值配置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroMaterialThresholds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroMaterialThresholdEntity maroMaterialThreshold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"原料阈值配置");
    	modelMap.put(NormalExcelConstants.CLASS,MaroMaterialThresholdEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("原料阈值配置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroMaterialThresholdEntity> listMaroMaterialThresholdEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroMaterialThresholdEntity.class,params);
				for (MaroMaterialThresholdEntity maroMaterialThreshold : listMaroMaterialThresholdEntitys) {
					maroMaterialThresholdService.save(maroMaterialThreshold);
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
	@ApiOperation(value="原料阈值配置列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroMaterialThresholdEntity>> list() {
		List<MaroMaterialThresholdEntity> listMaroMaterialThresholds=maroMaterialThresholdService.getList(MaroMaterialThresholdEntity.class);
		return Result.success(listMaroMaterialThresholds);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取原料阈值配置信息",notes="根据ID获取原料阈值配置信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroMaterialThresholdEntity task = maroMaterialThresholdService.get(MaroMaterialThresholdEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取原料阈值配置信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建原料阈值配置")
	public ResponseMessage<?> create(@ApiParam(name="原料阈值配置对象")@RequestBody MaroMaterialThresholdEntity maroMaterialThreshold, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMaterialThresholdEntity>> failures = validator.validate(maroMaterialThreshold);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMaterialThresholdService.save(maroMaterialThreshold);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("原料阈值配置信息保存失败");
		}
		return Result.success(maroMaterialThreshold);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新原料阈值配置",notes="更新原料阈值配置")
	public ResponseMessage<?> update(@ApiParam(name="原料阈值配置对象")@RequestBody MaroMaterialThresholdEntity maroMaterialThreshold) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMaterialThresholdEntity>> failures = validator.validate(maroMaterialThreshold);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMaterialThresholdService.saveOrUpdate(maroMaterialThreshold);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新原料阈值配置信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新原料阈值配置信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除原料阈值配置")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroMaterialThresholdService.deleteEntityById(MaroMaterialThresholdEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("原料阈值配置删除失败");
		}

		return Result.success();
	}
}
