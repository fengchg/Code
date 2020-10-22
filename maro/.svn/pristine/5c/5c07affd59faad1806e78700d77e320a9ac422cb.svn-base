package com.maro.manager.store.purchasedetail.controller;

import com.alibaba.fastjson.JSONArray;
import com.maro.common.constant.MaterialClassConstant;
import com.maro.common.constant.PurchaseDetailConstant;
import com.maro.common.constant.StoreFlowConstant;
import com.maro.common.util.UUIDUtil;
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.dishes.materialclass.entity.MaroMaterialClassEntity;
import com.maro.manager.dishes.materialclass.service.MaroMaterialClassServiceI;
import com.maro.manager.store.purchasedetail.entity.MaroPurchaseDetailEntity;
import com.maro.manager.store.purchasedetail.service.MaroPurchaseDetailServiceI;
import com.maro.manager.store.storeflow.service.MaroStoreFlowServiceI;
import com.maro.manager.store.storegoods.service.MaroStoreGoodsServiceI;
import com.maro.platform.core.beanvalidator.BeanValidators;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.exception.BusinessException;
import com.maro.platform.core.common.hibernate.qbc.CriteriaQuery;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.model.json.DataGrid;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil;
import com.maro.platform.core.util.ExceptionUtil;
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
 * @Description: maro_purchase_detail
 * @author onlineGenerator
 * @date 2018-05-03 17:23:26
 * @version V1.0   
 *
 */
@Api(value="MaroPurchaseDetail",description="maro_purchase_detail",tags="maroPurchaseDetailController")
@Controller
@RequestMapping("/maroPurchaseDetailController")
public class MaroPurchaseDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroPurchaseDetailController.class);

	@Autowired
	private MaroPurchaseDetailServiceI maroPurchaseDetailService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;
	@Autowired
	private MaroMaterialClassServiceI maroMaterialClassService;
	@Autowired
	private MaroStoreFlowServiceI maroStoreFlowService;
	@Autowired
	private MaroStoreGoodsServiceI maroStoreGoodsService;


	/**
	 * maro_purchase_detail列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String purchaseId=request.getParameter("purchaseId");
		request.setAttribute("purchaseId", purchaseId);
		return new ModelAndView("com/maro/manager/store/purchasedetail/maroPurchaseDetailListTwo");
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
	public void datagrid(MaroPurchaseDetailEntity maroPurchaseDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroPurchaseDetailEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroPurchaseDetail, request.getParameterMap());
		try{
			String purchaseId=request.getParameter("purchaseId");
			if(purchaseId!=null&&!"".equals(purchaseId)){
				cq.eq("purchaseId", purchaseId);
			}
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroPurchaseDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除maro_purchase_detail
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroPurchaseDetailEntity maroPurchaseDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroPurchaseDetail = systemService.getEntity(MaroPurchaseDetailEntity.class, maroPurchaseDetail.getId());
		message = "maro_purchase_detail删除成功";
		try{
			maroPurchaseDetailService.delete(maroPurchaseDetail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_purchase_detail删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除maro_purchase_detail
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_purchase_detail删除成功";
		try{
			for(String id:ids.split(",")){
				MaroPurchaseDetailEntity maroPurchaseDetail = systemService.getEntity(MaroPurchaseDetailEntity.class, 
				id
				);
				maroPurchaseDetailService.delete(maroPurchaseDetail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_purchase_detail删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加maro_purchase_detail
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroPurchaseDetailEntity maroPurchaseDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_purchase_detail添加成功";
		try{
			//setid
			UUIDUtil.setId(maroPurchaseDetail);
			maroPurchaseDetailService.save(maroPurchaseDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_purchase_detail添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新maro_purchase_detail
	 * 
	 * @param ids
	 * @param labelCode 标签码
	 * @param shopId 店铺id
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroPurchaseDetailEntity maroPurchaseDetail, HttpServletRequest request,String labelCode,String shopId) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_purchase_detail更新成功";
		try {
			//查询该原料是否已经入库其他库
			List<Map> haveStores=maroStoreGoodsService.otherStoreHave(maroPurchaseDetail.getMaterialClassId(),maroPurchaseDetail.getStoreId());
			if(haveStores!=null&&haveStores.size()>0){
				StringBuffer s=new StringBuffer();
				for(Map map:haveStores){
					s.append(map.get("storename")+"、");
				}
				message=("该原料已存在["+s.toString().substring(0,s.toString().length()-1)+"]中，请修改入库位置或移动原有原料的仓库位置！");
			}else{
				maroPurchaseDetailService.doUpdate(labelCode,shopId,PurchaseDetailConstant.IN_STORE, StoreFlowConstant.INSTORE,maroPurchaseDetail);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "maro_purchase_detail更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * maro_purchase_detail新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroPurchaseDetailEntity maroPurchaseDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroPurchaseDetail.getId())) {
			maroPurchaseDetail = maroPurchaseDetailService.getEntity(MaroPurchaseDetailEntity.class, maroPurchaseDetail.getId());
			req.setAttribute("maroPurchaseDetailPage", maroPurchaseDetail);
		}
		return new ModelAndView("com/maro/manager/store/purchasedetail/maroPurchaseDetail-add");
	}
	/**
	 * maro_purchase_detail编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroPurchaseDetailEntity maroPurchaseDetail, HttpServletRequest req) {
		//原料对象
		MaroMaterialClassEntity maroMaterialClassEntity=null;
		if (StringUtil.isNotEmpty(maroPurchaseDetail.getId())) {
			maroPurchaseDetail = maroPurchaseDetailService.getEntity(MaroPurchaseDetailEntity.class, maroPurchaseDetail.getId());
			req.setAttribute("maroPurchaseDetailPage", maroPurchaseDetail);
			//通过原料id获取原料对象
			maroMaterialClassEntity=maroMaterialClassService.get(MaroMaterialClassEntity.class, maroPurchaseDetail.getMaterialClassId());
			//获取计价单位
			String priceUnit = "";
			if(maroMaterialClassEntity.getType().equals(MaterialClassConstant.CHENGZHONG)){//称重原料
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_weighing_unit", maroMaterialClassEntity.getDenominatedUnit());
			}else{//其他
				priceUnit = Util.getValueFromTypeByTypeCodeAndKey("maro_ordinary_unit", maroMaterialClassEntity.getDenominatedUnit());
			}
			//获取原料的原料编码
			String coding=maroMaterialClassEntity.getCoding();
			req.setAttribute("coding", coding);
			req.setAttribute("priceType", "/"+priceUnit);
		}
		//获取用户id
		String userId = ResourceUtil.getSessionUser().getId();
		//获取角色编码
		String roleCodes = (String)req.getSession().getAttribute("maroRoleCodes");
		//验证是不是管理员的角色
		boolean admin = Util.ifRoleCode();
		//初始化是否可以修改变量
		boolean canEdit=true;
		if(!admin){//不是管理员
			String shopId = UtilService.getShopIdByUserId(userId);
			//给页面传递的条件参数
			req.setAttribute("storeCondition", "where shop_id='"+shopId+"'");
			req.setAttribute("shopId", shopId);
			if(maroMaterialClassEntity!=null&&maroMaterialClassEntity.getType().equals(MaterialClassConstant.CHENGZHONG)){//原料为称重原料
				if(roleCodes==null||!roleCodes.contains("cgspy")){//不是管理员并且没有cgspy(采购审批员)角色，则无法进行称重入库时的手动更改数量功能
					canEdit=false;
				}
			}
		}
		req.setAttribute("canEdit", false);
		return new ModelAndView("com/maro/manager/store/purchasedetail/maroPurchaseDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroPurchaseDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroPurchaseDetailEntity maroPurchaseDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroPurchaseDetailEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroPurchaseDetail, request.getParameterMap());
		List<MaroPurchaseDetailEntity> maroPurchaseDetails = this.maroPurchaseDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"maro_purchase_detail");
		modelMap.put(NormalExcelConstants.CLASS,MaroPurchaseDetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("maro_purchase_detail列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroPurchaseDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroPurchaseDetailEntity maroPurchaseDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"maro_purchase_detail");
    	modelMap.put(NormalExcelConstants.CLASS,MaroPurchaseDetailEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("maro_purchase_detail列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroPurchaseDetailEntity> listMaroPurchaseDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroPurchaseDetailEntity.class,params);
				for (MaroPurchaseDetailEntity maroPurchaseDetail : listMaroPurchaseDetailEntitys) {
					maroPurchaseDetailService.save(maroPurchaseDetail);
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
	@ApiOperation(value="maro_purchase_detail列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroPurchaseDetailEntity>> list() {
		List<MaroPurchaseDetailEntity> listMaroPurchaseDetails=maroPurchaseDetailService.getList(MaroPurchaseDetailEntity.class);
		return Result.success(listMaroPurchaseDetails);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取maro_purchase_detail信息",notes="根据ID获取maro_purchase_detail信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroPurchaseDetailEntity task = maroPurchaseDetailService.get(MaroPurchaseDetailEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取maro_purchase_detail信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建maro_purchase_detail")
	public ResponseMessage<?> create(@ApiParam(name="maro_purchase_detail对象")@RequestBody MaroPurchaseDetailEntity maroPurchaseDetail, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPurchaseDetailEntity>> failures = validator.validate(maroPurchaseDetail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroPurchaseDetailService.save(maroPurchaseDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("maro_purchase_detail信息保存失败");
		}
		return Result.success(maroPurchaseDetail);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新maro_purchase_detail",notes="更新maro_purchase_detail")
	public ResponseMessage<?> update(@ApiParam(name="maro_purchase_detail对象")@RequestBody MaroPurchaseDetailEntity maroPurchaseDetail) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPurchaseDetailEntity>> failures = validator.validate(maroPurchaseDetail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroPurchaseDetailService.saveOrUpdate(maroPurchaseDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新maro_purchase_detail信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新maro_purchase_detail信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除maro_purchase_detail")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroPurchaseDetailService.deleteEntityById(MaroPurchaseDetailEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("maro_purchase_detail删除失败");
		}

		return Result.success();
	}
	/**
	 * 判断对应记录是否符合入库条件
	 * @param request
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月4日
	 * @version
	 */
	@RequestMapping(params = "canPutInStore")
	@ResponseBody
	public AjaxJson canPutInStore(HttpServletRequest request) {
		String purchaseDetailId=request.getParameter("purchaseDetailId");
		AjaxJson j = new AjaxJson();
		try{
			boolean result=maroPurchaseDetailService.checkIsPutInStore(purchaseDetailId,PurchaseDetailConstant.IN_STORE);
			if(!result){
				j.setSuccess(false);
				j.setMsg("不符合入库条件！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
}
