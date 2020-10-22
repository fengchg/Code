package com.maro.manager.finance.operatin.controller;
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
import com.maro.common.finance.operatin.pojo.entity.MaroOperatinEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.finance.operatin.service.MaroOperatinServiceI;
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

/**   
 * @Title: Controller  
 * @Description: 流水表
 * @author onlineGenerator
 * @date 2018-04-12 14:12:42
 * @version V1.0   
 *
 */
@Api(value="MaroOperatin",description="流水表",tags="maroOperatinController")
@Controller
@RequestMapping("/maroOperatinController")
public class MaroOperatinController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroOperatinController.class);

	@Autowired
	private MaroOperatinServiceI maroOperatinService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 流水表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/finance/operatin/maroOperatinList");
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
	public void datagrid(MaroOperatinEntity maroOperatin,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroOperatinEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroOperatin, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroOperatinService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除流水表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroOperatinEntity maroOperatin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroOperatin = systemService.getEntity(MaroOperatinEntity.class, maroOperatin.getId());
		message = "流水表删除成功";
		try{
			maroOperatinService.delete(maroOperatin);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "流水表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除流水表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "流水表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroOperatinEntity maroOperatin = systemService.getEntity(MaroOperatinEntity.class, 
				id
				);
				maroOperatinService.delete(maroOperatin);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "流水表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加流水表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroOperatinEntity maroOperatin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "流水表添加成功";
		try{
			//setid
			UUIDUtil.setId(maroOperatin);
			maroOperatinService.save(maroOperatin);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "流水表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新流水表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroOperatinEntity maroOperatin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "流水表更新成功";
		MaroOperatinEntity t = maroOperatinService.get(MaroOperatinEntity.class, maroOperatin.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroOperatin, t);
			maroOperatinService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "流水表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 流水表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroOperatinEntity maroOperatin, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroOperatin.getId())) {
			maroOperatin = maroOperatinService.getEntity(MaroOperatinEntity.class, maroOperatin.getId());
			req.setAttribute("maroOperatinPage", maroOperatin);
		}
		return new ModelAndView("com/maro/manager/finance/operatin/maroOperatin-add");
	}
	/**
	 * 流水表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroOperatinEntity maroOperatin, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroOperatin.getId())) {
			maroOperatin = maroOperatinService.getEntity(MaroOperatinEntity.class, maroOperatin.getId());
			req.setAttribute("maroOperatinPage", maroOperatin);
		}
		return new ModelAndView("com/maro/manager/finance/operatin/maroOperatin-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroOperatinController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroOperatinEntity maroOperatin,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroOperatinEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroOperatin, request.getParameterMap());
		List<MaroOperatinEntity> maroOperatins = this.maroOperatinService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"流水表");
		modelMap.put(NormalExcelConstants.CLASS,MaroOperatinEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("流水表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroOperatins);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroOperatinEntity maroOperatin,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"流水表");
    	modelMap.put(NormalExcelConstants.CLASS,MaroOperatinEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("流水表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroOperatinEntity> listMaroOperatinEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroOperatinEntity.class,params);
				for (MaroOperatinEntity maroOperatin : listMaroOperatinEntitys) {
					maroOperatinService.save(maroOperatin);
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
	@ApiOperation(value="流水表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroOperatinEntity>> list() {
		List<MaroOperatinEntity> listMaroOperatins=maroOperatinService.getList(MaroOperatinEntity.class);
		return Result.success(listMaroOperatins);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取流水表信息",notes="根据ID获取流水表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroOperatinEntity task = maroOperatinService.get(MaroOperatinEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取流水表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建流水表")
	public ResponseMessage<?> create(@ApiParam(name="流水表对象")@RequestBody MaroOperatinEntity maroOperatin, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroOperatinEntity>> failures = validator.validate(maroOperatin);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroOperatinService.save(maroOperatin);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("流水表信息保存失败");
		}
		return Result.success(maroOperatin);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新流水表",notes="更新流水表")
	public ResponseMessage<?> update(@ApiParam(name="流水表对象")@RequestBody MaroOperatinEntity maroOperatin) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroOperatinEntity>> failures = validator.validate(maroOperatin);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroOperatinService.saveOrUpdate(maroOperatin);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新流水表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新流水表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除流水表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroOperatinService.deleteEntityById(MaroOperatinEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("流水表删除失败");
		}

		return Result.success();
	}
}
