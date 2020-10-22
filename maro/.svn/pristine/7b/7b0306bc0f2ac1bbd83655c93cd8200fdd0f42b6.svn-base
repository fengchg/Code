package com.maro.manager.shop.reserve.controller;
import com.maro.client.common.util.PojoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.maro.common.util.Util;
import com.maro.manager.common.service.UtilServiceI;
import com.maro.manager.shop.reserve.dto.MaroClientReserveEntityDTO;
import com.maro.manager.shop.reserve.entity.MaroClientReserveEntity;
import com.maro.manager.shop.reserve.service.MaroClientReserveServiceI;
import com.maro.manager.shop.reserve.vo.MaroClientReserveEntityVO;
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
 * @Description: maro_client_reserve
 * @author onlineGenerator
 * @date 2018-04-16 15:06:30
 * @version V1.0   
 *
 */
@Api(value="MaroClientReserve",description="maro_client_reserve",tags="maroClientReserveController")
@Controller
@RequestMapping("/maroClientReserveController")
public class MaroClientReserveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroClientReserveController.class);

	@Autowired
	private MaroClientReserveServiceI maroClientReserveService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private UtilServiceI UtilService;
	


	/**
	 * maro_client_reserve列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		//获取用户id
		String userId = ResourceUtil.getSessionUser().getId();
		//获取角色编码
		String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
		//验证是不是管理员的角色
		boolean admin = Util.ifRoleCode();
		if(!admin){
			//获取用户所属部门id
			String shopId=UtilService.getShopIdByUserId(userId);
			//给页面传递的条件参数
			String departId=ResourceUtil.getSessionUser().getDepartid();
			request.setAttribute("dictCondition", "where depart_id='"+departId+"'");
		}
		return new ModelAndView("com/maro/manager/shop/reserve/maroClientReserveList");
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
	public void datagrid(MaroClientReserveEntity maroClientReserve,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroClientReserveEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, maroClientReserve, request.getParameterMap());
		try{
			//自定义追加查询条件
			//获取用户id
			String userId = ResourceUtil.getSessionUser().getId();
			//获取角色编码
			String roleCodes = (String)request.getSession().getAttribute("maroRoleCodes");
			//验证是不是管理员的角色
			boolean admin = Util.ifRoleCode();
			if(!admin){
				//获取用户所属部门id
				String shopId=UtilService.getShopIdByUserId(userId);
				cq.eq("restaurantId", shopId);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroClientReserveService.getDataGridReturn(cq, true);
		//获取dataGrid中的List对象
		List<MaroClientReserveEntity> maroClientReserveEntitys = dataGrid.getResults();
		//转化成自己想要的对象
		List<MaroClientReserveEntityVO> maroClientReserveEntityVOs = PojoUtil.convertBatchDO2VO(maroClientReserveEntitys, MaroClientReserveEntityVO.class);
		//重新赋值给dataGrid的List对象
		dataGrid.setResults(maroClientReserveEntityVOs);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除maro_client_reserve
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroClientReserveEntity maroClientReserve, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		maroClientReserve = systemService.getEntity(MaroClientReserveEntity.class, maroClientReserve.getId());
		message = "maro_client_reserve删除成功";
		try{
			maroClientReserveService.delete(maroClientReserve);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_client_reserve删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除maro_client_reserve
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_client_reserve删除成功";
		try{
			for(String id:ids.split(",")){
				MaroClientReserveEntity maroClientReserve = systemService.getEntity(MaroClientReserveEntity.class, 
				id
				);
				maroClientReserveService.delete(maroClientReserve);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_client_reserve删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加maro_client_reserve
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroClientReserveEntityDTO maroClientReserve, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_client_reserve添加成功";
		try{
			MaroClientReserveEntity maroClientReserveEntity = PojoUtil.convertDO2VO(maroClientReserve, MaroClientReserveEntity.class);
			//setid
			UUIDUtil.setId(maroClientReserveEntity);
			maroClientReserveService.save(maroClientReserveEntity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "maro_client_reserve添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新maro_client_reserve
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroClientReserveEntityDTO maroClientReserve, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "maro_client_reserve更新成功";
		MaroClientReserveEntity maroClientReserveEntity = PojoUtil.convertDO2VO(maroClientReserve, MaroClientReserveEntity.class);
		MaroClientReserveEntity t = maroClientReserveService.get(MaroClientReserveEntity.class, maroClientReserve.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(maroClientReserveEntity, t);
			maroClientReserveService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "maro_client_reserve更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * maro_client_reserve新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroClientReserveEntity maroClientReserve, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroClientReserve.getId())) {
			maroClientReserve = maroClientReserveService.getEntity(MaroClientReserveEntity.class, maroClientReserve.getId());
			req.setAttribute("maroClientReservePage", maroClientReserve);
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
		return new ModelAndView("com/maro/manager/shop/reserve/maroClientReserve-add");
	}
	/**
	 * maro_client_reserve编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroClientReserveEntity maroClientReserve, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroClientReserve.getId())) {
			maroClientReserve = maroClientReserveService.getEntity(MaroClientReserveEntity.class, maroClientReserve.getId());
			List<MaroClientReserveEntity> maroClientReserves =new ArrayList();
			maroClientReserves.add(maroClientReserve);
			List<MaroClientReserveEntityVO> maroClientReserveEntityVOs = PojoUtil.convertBatchDO2VO(maroClientReserves, MaroClientReserveEntityVO.class);
			req.setAttribute("maroClientReservePage", maroClientReserveEntityVOs.get(0));
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
		return new ModelAndView("com/maro/manager/shop/reserve/maroClientReserve-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","maroClientReserveController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(MaroClientReserveEntity maroClientReserve,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(MaroClientReserveEntity.class, dataGrid);
		HqlGenerateUtil.installHql(cq, maroClientReserve, request.getParameterMap());
		List<MaroClientReserveEntity> maroClientReserves = this.maroClientReserveService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"maro_client_reserve");
		modelMap.put(NormalExcelConstants.CLASS,MaroClientReserveEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("maro_client_reserve列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,maroClientReserves);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(MaroClientReserveEntity maroClientReserve,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"maro_client_reserve");
    	modelMap.put(NormalExcelConstants.CLASS,MaroClientReserveEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("maro_client_reserve列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<MaroClientReserveEntity> listMaroClientReserveEntitys = ExcelImportUtil.importExcel(file.getInputStream(),MaroClientReserveEntity.class,params);
				for (MaroClientReserveEntity maroClientReserve : listMaroClientReserveEntitys) {
					maroClientReserveService.save(maroClientReserve);
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
	@ApiOperation(value="maro_client_reserve列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MaroClientReserveEntity>> list() {
		List<MaroClientReserveEntity> listMaroClientReserves=maroClientReserveService.getList(MaroClientReserveEntity.class);
		return Result.success(listMaroClientReserves);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取maro_client_reserve信息",notes="根据ID获取maro_client_reserve信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MaroClientReserveEntity task = maroClientReserveService.get(MaroClientReserveEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取maro_client_reserve信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建maro_client_reserve")
	public ResponseMessage<?> create(@ApiParam(name="maro_client_reserve对象")@RequestBody MaroClientReserveEntity maroClientReserve, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroClientReserveEntity>> failures = validator.validate(maroClientReserve);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroClientReserveService.save(maroClientReserve);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("maro_client_reserve信息保存失败");
		}
		return Result.success(maroClientReserve);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新maro_client_reserve",notes="更新maro_client_reserve")
	public ResponseMessage<?> update(@ApiParam(name="maro_client_reserve对象")@RequestBody MaroClientReserveEntity maroClientReserve) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroClientReserveEntity>> failures = validator.validate(maroClientReserve);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			maroClientReserveService.saveOrUpdate(maroClientReserve);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新maro_client_reserve信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新maro_client_reserve信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除maro_client_reserve")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			maroClientReserveService.deleteEntityById(MaroClientReserveEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("maro_client_reserve删除失败");
		}

		return Result.success();
	}
	
	/**
	 * 根据预定时间和预定时段获取满足条件的座位信息
	 * @param request
	 * @param shopId 店铺id
	 * @param reserveTime 预定时间
	 * @param period 时段
	 * @param personNumber 就餐人数
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月17日
	 * @version
	 */
	@RequestMapping(params = "listSeat")
	@ResponseBody
	public Object listSeat(HttpServletRequest request,String shopId,Date reserveTime,String period,Integer personNumber) {
		try {
			if(!"".equals(shopId)&&reserveTime!=null&&!"".equals(period)&&personNumber!=null){
				List<Map> comboboxs = (List<Map>)maroClientReserveService.listSeat(shopId,reserveTime,period,personNumber);
				return comboboxs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
