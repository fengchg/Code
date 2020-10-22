package com.maro.manager.users.member.controller;


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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.Util;
import com.maro.manager.users.member.entity.MaroMemberEntity;
import com.maro.manager.users.member.service.MaroMemberServiceI;
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
 * @Description: 会员表
 * @author onlineGenerator
 * @date 2018-04-11 15:24:37
 * @version V1.0   
 *
 */
@Api(value="MaroMember",description="会员表",tags="maroMemberController")
@Controller
@RequestMapping("/maroMemberController")
public class MaroMemberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroMemberController.class);

	@Autowired
	private MaroMemberServiceI maroMemberService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 会员表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/users/member/maroMemberList");
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
	public void datagrid(MaroMemberEntity maroMember,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroMemberEntity.class, dataGrid);
		
		//验证是不是管理员的角色
        boolean maroAdmin = Util.ifRoleCode();
        if(!maroAdmin){
        	MaroShopEntity shop = maroMemberService.findUniqueByProperty(MaroShopEntity.class, "departId", ResourceUtil.getSessionUser().getCurrentDepart().getId());
        	//Criterion c1 = Restrictions.and(Restrictions.eq("shopId", shopId), rhs)
        	cq.eq("shopId", shop.getId());
        }
		
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMember, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroMemberService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除会员表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroMemberEntity maroMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroMember = systemService.getEntity(MaroMemberEntity.class, maroMember.getId());
		message = "会员表删除成功";
		try{
			maroMemberService.delete(maroMember);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除会员表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroMemberEntity maroMember = systemService.getEntity(MaroMemberEntity.class, 
				id
				);
				maroMemberService.delete(maroMember);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加会员表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroMemberEntity maroMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表添加成功";
		try{
			maroMemberService.save(maroMember);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "会员表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新会员表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroMemberEntity maroMember, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "会员表更新成功";
		MaroMemberEntity t = maroMemberService.get(MaroMemberEntity.class, maroMember.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroMember, t);
			maroMemberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会员表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 会员表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroMemberEntity maroMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMember.getId())) {
			maroMember = maroMemberService.getEntity(MaroMemberEntity.class, maroMember.getId());
			req.setAttribute("maroMemberPage", maroMember);
		}
		return new ModelAndView("com/maro/manager/users/member/maroMember-add");
	}
	/**
	 * 会员表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroMemberEntity maroMember, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMember.getId())) {
			maroMember = maroMemberService.getEntity(MaroMemberEntity.class, maroMember.getId());
			req.setAttribute("maroMemberPage", maroMember);
		}
		return new ModelAndView("com/maro/manager/users/member/maroMember-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroMemberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroMemberEntity maroMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroMemberEntity.class, dataGrid);
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMember, request.getParameterMap());
		List<MaroMemberEntity> maroMembers = this.maroMemberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"会员表");
		modelMap.put(NormalExcelConstants.CLASS,MaroMemberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroMembers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroMemberEntity maroMember,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"会员表");
    	modelMap.put(NormalExcelConstants.CLASS,MaroMemberEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("会员表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroMemberEntity> listMaroMemberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroMemberEntity.class,params);
				for (MaroMemberEntity maroMember : listMaroMemberEntitys) {
					maroMemberService.save(maroMember);
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
	@ApiOperation(value="会员表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroMemberEntity>> list() {
		List<MaroMemberEntity> listMaroMembers=maroMemberService.getList(MaroMemberEntity.class);
		return Result.success(listMaroMembers);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取会员表信息",notes="根据ID获取会员表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroMemberEntity task = maroMemberService.get(MaroMemberEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取会员表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建会员表")
	public ResponseMessage<?> create(@ApiParam(name="会员表对象")@RequestBody MaroMemberEntity maroMember, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMemberEntity>> failures = validator.validate(maroMember);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMemberService.save(maroMember);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("会员表信息保存失败");
		}
		return Result.success(maroMember);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新会员表",notes="更新会员表")
	public ResponseMessage<?> update(@ApiParam(name="会员表对象")@RequestBody MaroMemberEntity maroMember) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMemberEntity>> failures = validator.validate(maroMember);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMemberService.saveOrUpdate(maroMember);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新会员表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新会员表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除会员表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroMemberService.deleteEntityById(MaroMemberEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("会员表删除失败");
		}

		return Result.success();
	}
}
