package com.maro.manager.groupdiscount.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.groupdiscount.entity.MaroGroupDiscountEntity;
import com.maro.manager.groupdiscount.service.MaroGroupDiscountServiceI;
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
 * @Description: 团购优惠券
 * @author onlineGenerator
 * @date 2018-11-12 10:06:29
 * @version V1.0   
 *
 */
@Api(value="MaroGroupDiscount",description="团购优惠券",tags="maroGroupDiscountController")
@Controller
@RequestMapping("/maroGroupDiscountController")
public class MaroGroupDiscountController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroGroupDiscountController.class);

	@Autowired
	private MaroGroupDiscountServiceI maroGroupDiscountService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;


	/**
	 * 团购优惠券列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/groupdiscount/maroGroupDiscountList");
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
	public void datagrid(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroGroupDiscountEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroGroupDiscount, request.getParameterMap());
		try{
		//自定义追加查询条件
			//获取用户id
			String userId = ResourceUtil.getSessionUser().getId();
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			if(!admin){
				String shopId = UtilService.getShopIdByUserId(userId);
				cq.eq("shopId", shopId);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroGroupDiscountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除团购优惠券
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroGroupDiscount = systemService.getEntity(MaroGroupDiscountEntity.class, maroGroupDiscount.getId());
		message = "团购优惠券删除成功";
		try{
			maroGroupDiscountService.delete(maroGroupDiscount);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "团购优惠券删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除团购优惠券
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "团购优惠券删除成功";
		try{
			for(String id:ids.split(",")){
				MaroGroupDiscountEntity maroGroupDiscount = systemService.getEntity(MaroGroupDiscountEntity.class, 
				id
				);
				maroGroupDiscountService.delete(maroGroupDiscount);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "团购优惠券删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加团购优惠券
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "团购优惠券添加成功";
		try{
			UUIDUtil.setId(maroGroupDiscount);
			maroGroupDiscountService.save(maroGroupDiscount);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "团购优惠券添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新团购优惠券
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "团购优惠券更新成功";
		MaroGroupDiscountEntity t = maroGroupDiscountService.get(MaroGroupDiscountEntity.class, maroGroupDiscount.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroGroupDiscount, t);
			maroGroupDiscountService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "团购优惠券更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 团购优惠券新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroGroupDiscount.getId())) {
			maroGroupDiscount = maroGroupDiscountService.getEntity(MaroGroupDiscountEntity.class, maroGroupDiscount.getId());
			req.setAttribute("maroGroupDiscountPage", maroGroupDiscount);
		}
		//获取角色编码
		String roleCodes = (String)req.getSession().getAttribute("maroRoleCodes");
		//验证是不是管理员的角色
		boolean admin = Util.ifRoleCode();
		if(!admin){
			//获取用户所属部门id
			String departId=ResourceUtil.getSessionUser().getDepartid();
			//给页面传递的条件参数
			req.setAttribute("dictCondition", "where depart_id='"+departId+"'");
		}
		return new ModelAndView("com/maro/manager/groupdiscount/maroGroupDiscount-add");
	}
	/**
	 * 团购优惠券编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroGroupDiscountEntity maroGroupDiscount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroGroupDiscount.getId())) {
			maroGroupDiscount = maroGroupDiscountService.getEntity(MaroGroupDiscountEntity.class, maroGroupDiscount.getId());
			req.setAttribute("maroGroupDiscountPage", maroGroupDiscount);
		}
		return new ModelAndView("com/maro/manager/groupdiscount/maroGroupDiscount-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroGroupDiscountController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroGroupDiscountEntity maroGroupDiscount,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroGroupDiscountEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroGroupDiscount, request.getParameterMap());
		List<MaroGroupDiscountEntity> maroGroupDiscounts = this.maroGroupDiscountService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"团购优惠券");
		modelMap.put(NormalExcelConstants.CLASS,MaroGroupDiscountEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("团购优惠券列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroGroupDiscounts);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroGroupDiscountEntity maroGroupDiscount,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"团购优惠券");
    	modelMap.put(NormalExcelConstants.CLASS,MaroGroupDiscountEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("团购优惠券列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroGroupDiscountEntity> listMaroGroupDiscountEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroGroupDiscountEntity.class,params);
				for (MaroGroupDiscountEntity maroGroupDiscount : listMaroGroupDiscountEntitys) {
					maroGroupDiscountService.save(maroGroupDiscount);
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
	@ApiOperation(value="团购优惠券列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroGroupDiscountEntity>> list() {
		List<MaroGroupDiscountEntity> listMaroGroupDiscounts=maroGroupDiscountService.getList(MaroGroupDiscountEntity.class);
		return Result.success(listMaroGroupDiscounts);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取团购优惠券信息",notes="根据ID获取团购优惠券信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroGroupDiscountEntity task = maroGroupDiscountService.get(MaroGroupDiscountEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取团购优惠券信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建团购优惠券")
	public ResponseMessage<?> create(@ApiParam(name="团购优惠券对象")@RequestBody MaroGroupDiscountEntity maroGroupDiscount, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroGroupDiscountEntity>> failures = validator.validate(maroGroupDiscount);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroGroupDiscountService.save(maroGroupDiscount);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("团购优惠券信息保存失败");
		}
		return Result.success(maroGroupDiscount);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新团购优惠券",notes="更新团购优惠券")
	public ResponseMessage<?> update(@ApiParam(name="团购优惠券对象")@RequestBody MaroGroupDiscountEntity maroGroupDiscount) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroGroupDiscountEntity>> failures = validator.validate(maroGroupDiscount);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroGroupDiscountService.saveOrUpdate(maroGroupDiscount);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新团购优惠券信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新团购优惠券信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除团购优惠券")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroGroupDiscountService.deleteEntityById(MaroGroupDiscountEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("团购优惠券删除失败");
		}

		return Result.success();
	}
}
