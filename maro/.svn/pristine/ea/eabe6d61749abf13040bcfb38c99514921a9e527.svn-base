package com.maro.client.module.machinenumber.controller;
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
import com.maro.client.module.machinenumber.entity.MaroMachineNumberEntity;
import com.maro.client.module.machinenumber.service.MaroMachineNumberServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ExceptionUtil;
import com.maro.platform.core.util.MyBeanUtils;
import com.maro.platform.core.util.PasswordUtil;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.core.util.StringUtil;
import com.maro.platform.jwt.util.ResponseMessage;
import com.maro.platform.jwt.util.Result;
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.pojo.base.TSUser;
import com.maro.platform.web.system.service.SystemService;
import com.maro.platform.web.system.service.UserService;

/**   
 * @Title: Controller  
 * @Description: 点机号
 * @author onlineGenerator
 * @date 2018-06-13 10:40:59	
 * @version V1.0   
 *
 */
@Api(value="MaroMachineNumber",description="点机号",tags="maroMachineNumberController")
@Controller
@RequestMapping("/maroMachineNumberController")
public class MaroMachineNumberController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroMachineNumberController.class);

	@Autowired
	private MaroMachineNumberServiceI maroMachineNumberService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UserService userService;
	
	/**
	 * 01 点菜宝登录
	 * @param deviceNumber 设备号
	 * @param jobNumber 工号
	 * @param pwd 密码
	 * @return
	 */
	@RequestMapping(params = "machineLogin")
	@ResponseBody
	public AjaxJson machineLogin(String deviceNumber,String jobNumber,String pwd){
		 AjaxJson aj = new AjaxJson();
		 try{
			 //根据工号获得用户实体
			 TSUser u = maroMachineNumberService.getByOrgIdEmpNo(jobNumber);
			 if(u != null){
				 //检查用户是否存在 
				 u.setPassword(pwd);
				 TSUser user = userService.checkUserExits(u);
				 if(user != null){
					 
					 Integer count = maroMachineNumberService.ifIsOrderMachine(deviceNumber);
					 if(count>0){
						 //把用户与点菜机绑定在一起
						 maroMachineNumberService.updateMachineNumber(deviceNumber,user.getId());
					 }else{
						 MaroMachineNumberEntity entity = new MaroMachineNumberEntity();
						 entity.setDeviceNumber(deviceNumber);
						 entity.setJobNumber(jobNumber);
						 maroMachineNumberService.save(entity);
					 }
					 aj.setMsg("1");
					 aj.setObj(user.getRealName());
				 }else{
					 aj.setMsg("0");
				 }
			 }else{
				 aj.setMsg("0");
			 }
			 
		 }catch(Exception e){
			 
		 }
		 return aj;
	}
	
	/**
	 * 02 通过点菜宝设备修改密码
	 * pwd 密码
	 * pwds 确认密码
	 * userId 用户id
	 * username 用户帐号
	 */
	@RequestMapping(params = "changePassword")
	@ResponseBody
	public AjaxJson changePassword(String pwd,String pwds,String userId,String username){
		 AjaxJson aj = new AjaxJson();
		 try{	
			 if(pwd.equals(pwds)){
				//通过 用户帐号与明文密码加密
				String pString = PasswordUtil.encrypt(username, pwd, PasswordUtil.getStaticSalt());
				maroMachineNumberService.updateUserPwd(userId,pString);
			 }else{
				 aj.setMsg("0");
			 }
		 }catch(Exception e){
			 aj.setMsg("0");
		 }
		 return aj;
	}


	/**
	 * 点机号列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/machinenumber/maroMachineNumberList");
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
	public void datagrid(MaroMachineNumberEntity maroMachineNumber,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroMachineNumberEntity.class, dataGrid);
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMachineNumber, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroMachineNumberService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除点机号
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroMachineNumberEntity maroMachineNumber, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroMachineNumber = systemService.getEntity(MaroMachineNumberEntity.class, maroMachineNumber.getId());
		message = "点机号删除成功";
		try{
			maroMachineNumberService.delete(maroMachineNumber);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "点机号删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除点机号
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "点机号删除成功";
		try{
			for(String id:ids.split(",")){
				MaroMachineNumberEntity maroMachineNumber = systemService.getEntity(MaroMachineNumberEntity.class, 
				id
				);
				maroMachineNumberService.delete(maroMachineNumber);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "点机号删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加点机号
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroMachineNumberEntity maroMachineNumber, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "点机号添加成功";
		try{
			maroMachineNumberService.save(maroMachineNumber);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "点机号添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新点机号
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroMachineNumberEntity maroMachineNumber, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "点机号更新成功";
		MaroMachineNumberEntity t = maroMachineNumberService.get(MaroMachineNumberEntity.class, maroMachineNumber.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroMachineNumber, t);
			maroMachineNumberService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "点机号更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 点机号新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroMachineNumberEntity maroMachineNumber, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMachineNumber.getId())) {
			maroMachineNumber = maroMachineNumberService.getEntity(MaroMachineNumberEntity.class, maroMachineNumber.getId());
			req.setAttribute("maroMachineNumberPage", maroMachineNumber);
		}
		return new ModelAndView("com/maro/manager/machinenumber/maroMachineNumber-add");
	}
	/**
	 * 点机号编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroMachineNumberEntity maroMachineNumber, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroMachineNumber.getId())) {
			maroMachineNumber = maroMachineNumberService.getEntity(MaroMachineNumberEntity.class, maroMachineNumber.getId());
			req.setAttribute("maroMachineNumberPage", maroMachineNumber);
		}
		return new ModelAndView("com/maro/manager/machinenumber/maroMachineNumber-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroMachineNumberController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroMachineNumberEntity maroMachineNumber,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroMachineNumberEntity.class, dataGrid);
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroMachineNumber, request.getParameterMap());
		List<MaroMachineNumberEntity> maroMachineNumbers = this.maroMachineNumberService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"点机号");
		modelMap.put(NormalExcelConstants.CLASS,MaroMachineNumberEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("点机号列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroMachineNumbers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroMachineNumberEntity maroMachineNumber,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"点机号");
    	modelMap.put(NormalExcelConstants.CLASS,MaroMachineNumberEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("点机号列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroMachineNumberEntity> listMaroMachineNumberEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroMachineNumberEntity.class,params);
				for (MaroMachineNumberEntity maroMachineNumber : listMaroMachineNumberEntitys) {
					maroMachineNumberService.save(maroMachineNumber);
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
	@ApiOperation(value="点机号列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroMachineNumberEntity>> list() {
		List<MaroMachineNumberEntity> listMaroMachineNumbers=maroMachineNumberService.getList(MaroMachineNumberEntity.class);
		return Result.success(listMaroMachineNumbers);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取点机号信息",notes="根据ID获取点机号信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroMachineNumberEntity task = maroMachineNumberService.get(MaroMachineNumberEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取点机号信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建点机号")
	public ResponseMessage<?> create(@ApiParam(name="点机号对象")@RequestBody MaroMachineNumberEntity maroMachineNumber, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMachineNumberEntity>> failures = validator.validate(maroMachineNumber);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMachineNumberService.save(maroMachineNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("点机号信息保存失败");
		}
		return Result.success(maroMachineNumber);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新点机号",notes="更新点机号")
	public ResponseMessage<?> update(@ApiParam(name="点机号对象")@RequestBody MaroMachineNumberEntity maroMachineNumber) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroMachineNumberEntity>> failures = validator.validate(maroMachineNumber);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroMachineNumberService.saveOrUpdate(maroMachineNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新点机号信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新点机号信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除点机号")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroMachineNumberService.deleteEntityById(MaroMachineNumberEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("点机号删除失败");
		}

		return Result.success();
	}
}
