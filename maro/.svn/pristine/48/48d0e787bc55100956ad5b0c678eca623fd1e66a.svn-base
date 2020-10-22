package com.maro.manager.maroprint.maroprinter.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.util.UUIDUtil;
import com.maro.manager.maroprint.maroprinter.entity.MaroPrinterEntity;
import com.maro.manager.maroprint.maroprinter.page.MaroPrinterPage;
import com.maro.manager.maroprint.maroprinter.service.MaroPrinterServiceI;
import com.maro.manager.maroprint.maroprinterclassification.entity.MaroPrinterClassificationEntity;
import com.maro.manager.shop.shop.service.MaroShopServiceI;
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
import com.maro.platform.tag.core.easyui.TagUtil;
import com.maro.platform.web.system.service.SystemService;

/**   
 * @Title: Controller
 * @Description: 打印机
 * @author onlineGenerator
 * @date 2018-11-14 16:24:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroPrinterController")
public class MaroPrinterController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroPrinterController.class);

	@Autowired
	private MaroPrinterServiceI maroPrinterService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private MaroShopServiceI maroShopService;
	
	//查询打印机ip是否存在
	@RequestMapping(params = "examinePrinterIp")
	@ResponseBody
	public AjaxJson examinePrinterIp(String ip){
		AjaxJson aj = new AjaxJson();
		//机构id
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		//获取店铺的id
		MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
		
		Integer count = maroPrinterService.examinePrinterIp(maroShop.getId(), ip);
		
		aj.setObj(count);
		
		return aj;
	}
	
	//查询此分类是否有匹配打印机
	@RequestMapping(params = "examineClassification")
	@ResponseBody
	public AjaxJson examineClassification(String classificationId){
		AjaxJson aj = new AjaxJson();
		//机构id
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		//获取店铺的id
		MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
		
		Map map = maroPrinterService.examineClassification(maroShop.getId(), classificationId);
		
		aj.setObj(map);
		
		return aj;
	}
	
	
	/**
	 * 打印机列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/maro/manager/maroprint/maroprinter/maroPrinterList");
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
	public void datagrid(MaroPrinterEntity maroPrinter,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MaroPrinterEntity.class, dataGrid);
		//机构id
		String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
		//获取店铺的id
		MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
		cq.eq("sysCompanyCode", maroShop.getId());
		//查询条件组装器
		com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroPrinter);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.maroPrinterService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除打印机
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MaroPrinterEntity maroPrinter, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		maroPrinter = systemService.getEntity(MaroPrinterEntity.class, maroPrinter.getId());
		String message = "打印机删除成功";
		try{
			maroPrinterService.delMain(maroPrinter);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "打印机删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除打印机
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "打印机删除成功";
		try{
			for(String id:ids.split(",")){
				MaroPrinterEntity maroPrinter = systemService.getEntity(MaroPrinterEntity.class,
				id
				);
				maroPrinterService.delMain(maroPrinter);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "打印机删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加打印机
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MaroPrinterEntity maroPrinter,MaroPrinterPage maroPrinterPage, HttpServletRequest request) {
		List<MaroPrinterClassificationEntity> maroPrinterClassificationList =  maroPrinterPage.getMaroPrinterClassificationList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			
			//机构id
			String departId = ResourceUtil.getSessionUser().getCurrentDepart().getId();
			//获取店铺的id
			MaroShopEntity maroShop = maroShopService.getByDepartIdShop(departId);
			maroPrinter.setSysCompanyCode(maroShop.getId());
			UUIDUtil.setId(maroPrinter,maroPrinterClassificationList);
			maroPrinterService.addMain(maroPrinter, maroPrinterClassificationList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "打印机添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新打印机
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MaroPrinterEntity maroPrinter,MaroPrinterPage maroPrinterPage, HttpServletRequest request) {
		List<MaroPrinterClassificationEntity> maroPrinterClassificationList =  maroPrinterPage.getMaroPrinterClassificationList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			maroPrinterService.updateMain(maroPrinter, maroPrinterClassificationList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新打印机失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 打印机新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MaroPrinterEntity maroPrinter, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroPrinter.getId())) {
			maroPrinter = maroPrinterService.getEntity(MaroPrinterEntity.class, maroPrinter.getId());
			req.setAttribute("maroPrinterPage", maroPrinter);
		}
		return new ModelAndView("com/maro/manager/maroprint/maroprinter/maroPrinter-add");
	}
	
	/**
	 * 打印机编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MaroPrinterEntity maroPrinter, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(maroPrinter.getId())) {
			maroPrinter = maroPrinterService.getEntity(MaroPrinterEntity.class, maroPrinter.getId());
			req.setAttribute("maroPrinterPage", maroPrinter);
		}
		return new ModelAndView("com/maro/manager/maroprint/maroprinter/maroPrinter-update");
	}
	
	
	/**
	 * 加载明细列表[菜肴分类打印IP]
	 * 
	 * @return
	 */
	@RequestMapping(params = "maroPrinterClassificationList")
	public ModelAndView maroPrinterClassificationList(MaroPrinterEntity maroPrinter, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = maroPrinter.getId();
		//===================================================================================
		//查询-菜肴分类打印IP
	    String hql0 = "from MaroPrinterClassificationEntity where 1 = 1 AND pRINTRT_ID = ?";
	    try{
	    	List<MaroPrinterClassificationEntity> maroPrinterClassificationEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("maroPrinterClassificationList", maroPrinterClassificationEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/maro/manager/maroprint/maroprinterclassification/maroPrinterClassificationList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MaroPrinterEntity maroPrinter,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MaroPrinterEntity.class, dataGrid);
    	//查询条件组装器
    	com.maro.platform.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, maroPrinter);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MaroPrinterEntity> list=this.maroPrinterService.getListByCriteriaQuery(cq, false);
    	List<MaroPrinterPage> pageList=new ArrayList<MaroPrinterPage>();
        if(list!=null&&list.size()>0){
        	for(MaroPrinterEntity entity:list){
        		try{
        		MaroPrinterPage page=new MaroPrinterPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MaroPrinterClassificationEntity where 1 = 1 AND pRINTRT_ID = ?  AND cLASSIFICATION_ID = ? ";
        	        List<MaroPrinterClassificationEntity> maroPrinterClassificationEntityList = systemService.findHql(hql0,id0,id0);
            		page.setMaroPrinterClassificationList(maroPrinterClassificationEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"打印机");
        map.put(NormalExcelConstants.CLASS,MaroPrinterPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("打印机列表", "导出人:Jeecg",
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
				List<MaroPrinterPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MaroPrinterPage.class, params);
				MaroPrinterEntity entity1=null;
				for (MaroPrinterPage page : list) {
					entity1=new MaroPrinterEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            maroPrinterService.addMain(entity1, page.getMaroPrinterClassificationList());
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
		map.put(NormalExcelConstants.FILE_NAME,"打印机");
		map.put(NormalExcelConstants.CLASS,MaroPrinterPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("打印机列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "maroPrinterController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<MaroPrinterEntity> list() {
		List<MaroPrinterEntity> listMaroPrinters=maroPrinterService.getList(MaroPrinterEntity.class);
		return listMaroPrinters;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		MaroPrinterEntity task = maroPrinterService.get(MaroPrinterEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody MaroPrinterPage maroPrinterPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPrinterPage>> failures = validator.validate(maroPrinterPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<MaroPrinterClassificationEntity> maroPrinterClassificationList =  maroPrinterPage.getMaroPrinterClassificationList();
		
		MaroPrinterEntity maroPrinter = new MaroPrinterEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroPrinter,maroPrinterPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		maroPrinterService.addMain(maroPrinter, maroPrinterClassificationList);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = maroPrinterPage.getId();
		URI uri = uriBuilder.path("/rest/maroPrinterController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody MaroPrinterPage maroPrinterPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MaroPrinterPage>> failures = validator.validate(maroPrinterPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<MaroPrinterClassificationEntity> maroPrinterClassificationList =  maroPrinterPage.getMaroPrinterClassificationList();
		
		MaroPrinterEntity maroPrinter = new MaroPrinterEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(maroPrinter,maroPrinterPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		maroPrinterService.updateMain(maroPrinter, maroPrinterClassificationList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		MaroPrinterEntity maroPrinter = maroPrinterService.get(MaroPrinterEntity.class, id);
		maroPrinterService.delMain(maroPrinter);
	}
}
