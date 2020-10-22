package com.maro.manager.store.purchase.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.constant.MaterialClassConstant;
import com.maro.common.constant.PurchaseConstant;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.store.purchase.entity.MaroPurchaseEntity;
import com.maro.manager.store.purchase.page.MaroPurchasePage;
import com.maro.manager.store.purchase.service.MaroPurchaseServiceI;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
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
import java.util.*;

/**   
 * @Title: Controller
 * @Description: 采购主表
 * @author onlineGenerator
 * @date 2018-05-03 15:40:38
 * @version V1.0   
 *
 */
@Api(value="MaroPurchase",description="采购主表",tags="maroPurchaseController")
@Controller
@RequestMapping("/maroPurchaseController")
public class MaroPurchaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroPurchaseController.class);

	@Autowired
	private MaroPurchaseServiceI maroPurchaseService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;

	/**
	 * 采购主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/store/purchase/maroPurchaseList");
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
	public void datagrid(MaroPurchaseEntity maroPurchase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroPurchaseEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroPurchase);
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
		this.maroPurchaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除采购主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroPurchaseEntity maroPurchase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroPurchase = systemService.getEntity(MaroPurchaseEntity.class, maroPurchase.getId());
		String message = "采购主表删除成功";
		try{
			maroPurchaseService.delMain(maroPurchase);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除采购主表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "采购主表删除成功";
		try{
			for(String id:ids.split(",")){
				MaroPurchaseEntity maroPurchase = systemService.getEntity(MaroPurchaseEntity.class,
				id
				);
				maroPurchaseService.delMain(maroPurchase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "采购主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加采购主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroPurchaseEntity maroPurchase,MaroPurchasePage maroPurchasePage, HttpServletRequest request) {
		//设置提交状态为保存
		maroPurchase.setSubmitFlag(PurchaseConstant.SAVE);
		List<MaroPurchaseDetailEntity> maroPurchaseDetailList =  maroPurchasePage.getMaroPurchaseDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			//setid
			UUIDUtil.setId(maroPurchase,maroPurchaseDetailList);
			maroPurchaseService.addMain(maroPurchase, maroPurchaseDetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "采购主表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新采购主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroPurchaseEntity maroPurchase,MaroPurchasePage maroPurchasePage, HttpServletRequest request) {
		List<MaroPurchaseDetailEntity> maroPurchaseDetailList =  maroPurchasePage.getMaroPurchaseDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			maroPurchaseService.updateMain(maroPurchase, maroPurchaseDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新采购主表失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 采购主表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroPurchaseEntity maroPurchase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroPurchase.getId())) {
			maroPurchase = maroPurchaseService.getEntity(MaroPurchaseEntity.class, maroPurchase.getId());
			req.setAttribute("maroPurchasePage", maroPurchase);
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
		return new ModelAndView("com/maro/manager/store/purchase/maroPurchase-add");
	}
	
	/**
	 * 采购主表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroPurchaseEntity maroPurchase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroPurchase.getId())) {
			maroPurchase = maroPurchaseService.getEntity(MaroPurchaseEntity.class, maroPurchase.getId());
			req.setAttribute("maroPurchasePage", maroPurchase);
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
		return new ModelAndView("com/maro/manager/store/purchase/maroPurchase-update");
	}
	
	
	/**
	 * 加载明细列表[采购详情表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroPurchaseDetailList")
	public ModelAndView maroPurchaseDetailList(MaroPurchaseEntity maroPurchase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroPurchase.getId();
		//===================================================================================
		//查询-采购详情表
	    String hql0 = "from MaroPurchaseDetailEntity where 1 = 1 AND pURCHASE_ID = ? ";
	    try{
	    	List<MaroPurchaseDetailEntity> maroPurchaseDetailEntityList = systemService.findHql(hql0,id0);
			//获取原料id-name集合
			List<Object[]> listbySql = systemService.findListbySql("SELECT t.id,t.material_name from maro_material_class t");
			req.setAttribute("maroPurchaseDetailList", maroPurchaseDetailEntityList);
			for(MaroPurchaseDetailEntity m:maroPurchaseDetailEntityList){
				String materialClassId=m.getMaterialClassId();
				for(Object[] o:listbySql){
					if(o[0].toString().equals(materialClassId)){
						m.setMaterialName(o[1].toString());
						break;
					}
				}
			}
	    }catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/maro/manager/store/purchasedetail/maroPurchaseDetailList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroPurchaseEntity maroPurchase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroPurchaseEntity.class, dataGrid);
    	//查询条件组装器
    	HqlGenerateUtil.installHql(cq, maroPurchase);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroPurchaseEntity> list=this.maroPurchaseService.getListByCriteriaQuery(cq, false);
    	List<MaroPurchasePage> pageList=new ArrayList<MaroPurchasePage>();
        if(list!=null&&list.size()>0){
        	for(MaroPurchaseEntity entity:list){
        		try{
        		MaroPurchasePage page=new MaroPurchasePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroPurchaseDetailEntity where 1 = 1 AND pURCHASE_ID = ? ";
        	        List<MaroPurchaseDetailEntity> maroPurchaseDetailEntityList = systemService.findHql(hql0,id0);
            		page.setMaroPurchaseDetailList(maroPurchaseDetailEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"采购主表");
        map.put(NormalExcelConstants.CLASS,MaroPurchasePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("采购主表列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<MaroPurchasePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroPurchasePage.class, params);
				MaroPurchaseEntity entity1=null;
				for (MaroPurchasePage page : list) {
					entity1=new MaroPurchaseEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroPurchaseService.addMain(entity1, page.getMaroPurchaseDetailList());
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
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"采购主表");
		map.put(NormalExcelConstants.CLASS,MaroPurchasePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("采购主表列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "maroPurchaseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="采购主表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroPurchasePage>> list() {
		List<MaroPurchaseEntity> list= maroPurchaseService.getList(MaroPurchaseEntity.class);
    	List<MaroPurchasePage> pageList=new ArrayList<MaroPurchasePage>();
        if(list!=null&&list.size()>0){
        	for(MaroPurchaseEntity entity:list){
        		try{
        			MaroPurchasePage page=new MaroPurchasePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MaroPurchaseDetailEntity where 1 = 1 AND pURCHASE_ID = ? ";
	    			List<MaroPurchaseDetailEntity> maroPurchaseDetailOldList = this.maroPurchaseService.findHql(hql0,id0);
            		page.setMaroPurchaseDetailList(maroPurchaseDetailOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取采购主表信息",notes="根据ID获取采购主表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroPurchaseEntity task = maroPurchaseService.get(MaroPurchaseEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取采购主表信息为空");
		}
		MaroPurchasePage page = new MaroPurchasePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MaroPurchaseDetailEntity where 1 = 1 AND pURCHASE_ID = ? ";
			List<MaroPurchaseDetailEntity> maroPurchaseDetailOldList = this.maroPurchaseService.findHql(hql0,id0);
    		page.setMaroPurchaseDetailList(maroPurchaseDetailOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建采购主表")
	public ResponseMessage<?> create(@ApiParam(name="采购主表对象")@RequestBody MaroPurchasePage maroPurchasePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPurchasePage>> failures = validator.validate(maroPurchasePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroPurchaseDetailEntity> maroPurchaseDetailList =  maroPurchasePage.getMaroPurchaseDetailList();
		
		MaroPurchaseEntity maroPurchase = new MaroPurchaseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroPurchasePage,maroPurchase);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存采购主表失败");
        }
		maroPurchaseService.addMain(maroPurchase, maroPurchaseDetailList);

		return Result.success(maroPurchase);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新采购主表",notes="更新采购主表")
	public ResponseMessage<?> update(@RequestBody MaroPurchasePage maroPurchasePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPurchasePage>> failures = validator.validate(maroPurchasePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MaroPurchaseDetailEntity> maroPurchaseDetailList =  maroPurchasePage.getMaroPurchaseDetailList();
		
		MaroPurchaseEntity maroPurchase = new MaroPurchaseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroPurchasePage,maroPurchase);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("采购主表更新失败");
        }
		maroPurchaseService.updateMain(maroPurchase, maroPurchaseDetailList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除采购主表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MaroPurchaseEntity maroPurchase = maroPurchaseService.get(MaroPurchaseEntity.class, id);
			maroPurchaseService.delMain(maroPurchase);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("采购主表删除失败");
		}

		return Result.success();
	}
	/**
	 * 通过原料id获取原料的详细信息并返回
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"getMaterialClassInfoById"})
	@ResponseBody
	public AjaxJson getMaterialClassInfoById(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取原料id
			String materialClassId = request.getParameter("materialClassId");
			//获取原料详细信息
			MaroMaterialClassEntity materialClassInfo=maroMaterialClassService.get(MaroMaterialClassEntity.class, materialClassId);
			//获取计价单位
			String priceUnit = "";
			if(materialClassInfo.getType().equals(MaterialClassConstant.CHENGZHONG)){//称重原料
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_weighing_unit", materialClassInfo.getDenominatedUnit());
			}else{
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", materialClassInfo.getDenominatedUnit());
			}
			materialClassInfo.setDenominatedUnitName(priceUnit);
			j.setObj(materialClassInfo);
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 提交采购申请
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"submitApprove"})
	@ResponseBody
	public AjaxJson submitApprove(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取提交的采购申请id(多个按逗号分隔)
			String ids = request.getParameter("purchaseIds");
			//检查传递过来的申请id是否满足提交状态
			boolean result=maroPurchaseService.check(ids,PurchaseConstant.SAVE);
			if(result){
				result=maroPurchaseService.submitApprove(ids,PurchaseConstant.SUBMIT,PurchaseConstant.APPROVING);
				if(!result){
					j.setMsg(Util.getMessageFromTypeByKey("approveError"));
					j.setSuccess(false);
				}
			}else{
				j.setMsg(Util.getMessageFromTypeByKey("submitError"));
				j.setSuccess(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 审批通过提交的采购申请
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"approvePass"})
	@ResponseBody
	public AjaxJson approvePass(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取提交的采购申请id(多个按逗号分隔)
			String ids = request.getParameter("purchaseIds");
			//检查传递过来的申请id是否满足提交状态
			boolean result=maroPurchaseService.check(ids,PurchaseConstant.SUBMIT);
			if(result){
				result=maroPurchaseService.approvePass(ids,new Date(),PurchaseConstant.WORKING,PurchaseConstant.APPROVE_PASS);
				if(!result){
					j.setMsg(Util.getMessageFromTypeByKey("approveError"));
					j.setSuccess(false);
				}
			}else{
				j.setMsg(Util.getMessageFromTypeByKey("approveError"));
				j.setSuccess(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 审批不通过提交的采购申请
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"approveNotPass"})
	@ResponseBody
	public AjaxJson approveNotPass(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取提交的采购申请id(多个按逗号分隔)
			String ids = request.getParameter("purchaseIds");
			//检查传递过来的申请id是否满足提交状态
			boolean result=maroPurchaseService.check(ids,PurchaseConstant.SUBMIT);
			if(result){
				result=maroPurchaseService.approveNotPass(ids,PurchaseConstant.APPROVE_NOT_PASS);
				if(!result){
					j.setMsg(Util.getMessageFromTypeByKey("approveError"));
					j.setSuccess(false);
				}
			}else{
				j.setMsg(Util.getMessageFromTypeByKey("approveError"));
				j.setSuccess(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 完成采购，需满足审批通过并提交状态为采购中
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"finishPurchase"})
	@ResponseBody
	public AjaxJson finishPurchase(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取提交的采购申请id(多个按逗号分隔)
			String id = request.getParameter("purchaseId");
			//检查传递过来的申请id是否满足完成采购状态，只要审批通过即可
			boolean result=maroPurchaseService.finishPurchase(id,PurchaseConstant.APPROVE_PASS,PurchaseConstant.WORKING,PurchaseConstant.FINISH);
			if(!result){
				j.setMsg(Util.getMessageFromTypeByKey("approveError"));
				j.setSuccess(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}


	/**
	 * 检查是否可以进行入库操作，满足的条件的完成采购状态
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	@RequestMapping(params = {"canPutInStore"})
	@ResponseBody
	public AjaxJson canPutInStore(HttpServletRequest request){
		AjaxJson j=new AjaxJson();
		try {
			//获取提交的采购申请id(多个按逗号分隔)
			String id = request.getParameter("purchaseId");
			//检查传递过来的申请id是否满足完成采购状态，只要审批通过即可
			boolean result=maroPurchaseService.canPutInStore(id,PurchaseConstant.FINISH);
			if(!result){
				j.setMsg(Util.getMessageFromTypeByKey("approveError"));
				j.setSuccess(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			j.setMsg(Util.getMessageFromTypeByKey("error"));
			j.setSuccess(false);
		}
		return j;
	}
}
