package com.maro.platform.web.system.controller.core;
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
import com.maro.platform.web.system.pojo.base.MaroMqSynchronousEntity;
import com.maro.platform.web.system.service.MaroMqSynchronousServiceI;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller  
 * @Description: 统统同步表
 * @author onlineGenerator
 * @date 2018-06-21 14:22:35
 * @version V1.0   
 *
 */
@Api(value="MaroMqSynchronous",description="统统同步表",tags="maroMqSynchronousController")
@Controller
@RequestMapping("/maroMqSynchronousController")
public class MaroMqSynchronousController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroMqSynchronousController.class);

	@Autowired
	private MaroMqSynchronousServiceI maroMqSynchronousService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 统统同步表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/synchronous/maroMqSynchronousList");
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
	public void datagrid(MaroMqSynchronousEntity maroMqSynchronous,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroMqSynchronousEntity.class, dataGrid);
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMqSynchronous, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroMqSynchronousService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除统统同步表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroMqSynchronousEntity maroMqSynchronous, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroMqSynchronous = systemService.getEntity(MaroMqSynchronousEntity.class, maroMqSynchronous.getId());
		message = "统统同步表删除成功";
		try{
			maroMqSynchronousService.delete(maroMqSynchronous);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "统统同步表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除统统同步表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统统同步表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroMqSynchronousEntity maroMqSynchronous = systemService.getEntity(MaroMqSynchronousEntity.class, 
				id
				);
				maroMqSynchronousService.delete(maroMqSynchronous);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "统统同步表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加统统同步表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroMqSynchronousEntity maroMqSynchronous, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统统同步表添加成功";
		try{
			maroMqSynchronousService.save(maroMqSynchronous);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "统统同步表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新统统同步表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroMqSynchronousEntity maroMqSynchronous, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "统统同步表更新成功";
		MaroMqSynchronousEntity t = maroMqSynchronousService.get(MaroMqSynchronousEntity.class, maroMqSynchronous.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroMqSynchronous, t);
			maroMqSynchronousService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "统统同步表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 统统同步表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroMqSynchronousEntity maroMqSynchronous, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMqSynchronous.getId())) {
			maroMqSynchronous = maroMqSynchronousService.getEntity(MaroMqSynchronousEntity.class, maroMqSynchronous.getId());
			req.setAttribute("maroMqSynchronousPage", maroMqSynchronous);
		}
		return new ModelAndView("com/maro/manager/synchronous/maroMqSynchronous-add");
	}
	/**
	 * 统统同步表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroMqSynchronousEntity maroMqSynchronous, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMqSynchronous.getId())) {
			maroMqSynchronous = maroMqSynchronousService.getEntity(MaroMqSynchronousEntity.class, maroMqSynchronous.getId());
			req.setAttribute("maroMqSynchronousPage", maroMqSynchronous);
		}
		return new ModelAndView("com/maro/manager/synchronous/maroMqSynchronous-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroMqSynchronousController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroMqSynchronousEntity maroMqSynchronous,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroMqSynchronousEntity.class, dataGrid);
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMqSynchronous, request.getParameterMap());
		List<MaroMqSynchronousEntity> maroMqSynchronouss = this.maroMqSynchronousService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"统统同步表");
		modelMap.put(NormalExcelConstants.CLASS,MaroMqSynchronousEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("统统同步表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroMqSynchronouss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroMqSynchronousEntity maroMqSynchronous,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"统统同步表");
    	modelMap.put(NormalExcelConstants.CLASS,MaroMqSynchronousEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("统统同步表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroMqSynchronousEntity> listMaroMqSynchronousEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroMqSynchronousEntity.class,params);
				for (MaroMqSynchronousEntity maroMqSynchronous : listMaroMqSynchronousEntitys) {
					maroMqSynchronousService.save(maroMqSynchronous);
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
	@ApiOperation(value="统统同步表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroMqSynchronousEntity>> list() {
		List<MaroMqSynchronousEntity> listMaroMqSynchronouss=maroMqSynchronousService.getList(MaroMqSynchronousEntity.class);
		return Result.success(listMaroMqSynchronouss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取统统同步表信息",notes="根据ID获取统统同步表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroMqSynchronousEntity task = maroMqSynchronousService.get(MaroMqSynchronousEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取统统同步表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建统统同步表")
	public ResponseMessage<?> create(@ApiParam(name="统统同步表对象")@RequestBody MaroMqSynchronousEntity maroMqSynchronous, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMqSynchronousEntity>> failures = validator.validate(maroMqSynchronous);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMqSynchronousService.save(maroMqSynchronous);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("统统同步表信息保存失败");
		}
		return Result.success(maroMqSynchronous);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新统统同步表",notes="更新统统同步表")
	public ResponseMessage<?> update(@ApiParam(name="统统同步表对象")@RequestBody MaroMqSynchronousEntity maroMqSynchronous) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMqSynchronousEntity>> failures = validator.validate(maroMqSynchronous);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMqSynchronousService.saveOrUpdate(maroMqSynchronous);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新统统同步表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新统统同步表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除统统同步表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroMqSynchronousService.deleteEntityById(MaroMqSynchronousEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("统统同步表删除失败");
		}

		return Result.success();
	}
}
