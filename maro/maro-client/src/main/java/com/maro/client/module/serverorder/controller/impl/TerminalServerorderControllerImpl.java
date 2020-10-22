package com.maro.client.module.serverorder.controller.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.maro.client.module.machinenumber.entity.MaroMachineNumberEntity;
import com.maro.client.module.machinenumber.service.MaroMachineNumberServiceI;
import com.maro.client.module.serverorder.apply.TerminalServerOrderApplyService;
import com.maro.client.module.serverorder.controller.TerminalServerorderController;
import com.maro.client.module.serverorder.pojo.dto.TerminalParamsDTO;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.web.system.pojo.base.TSUser;
import com.maro.platform.web.system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/terminalServerorderController")
public class TerminalServerorderControllerImpl implements TerminalServerorderController {

    @Resource
    private TerminalServerOrderApplyService terminalServerOrderApplyService;
    @Autowired
	private MaroMachineNumberServiceI maroMachineNumberService;
    @Autowired
	private UserService userService;

    @Override
    @RequestMapping(params = "listBaseData")
    @ResponseBody
    public AjaxJson listBaseData() {
        return terminalServerOrderApplyService.listBaseData();
    }

    @Override
    @RequestMapping(params = "open")
    @ResponseBody
    public AjaxJson open(TerminalParamsDTO terminalParamsDTO) {
        return terminalServerOrderApplyService.open(terminalParamsDTO);
    }


    @Override
    @RequestMapping(params = "changeSeat")
    @ResponseBody
    public AjaxJson changeSeat(String srcSeatCode, String srcOrderCode, String destSeatCode, String terminalCode) {
        TerminalParamsDTO terminalParamsDTO = new TerminalParamsDTO();
        terminalParamsDTO.setSrcSeatCode(srcSeatCode);
        terminalParamsDTO.setSrcOrderCode(srcOrderCode);
        terminalParamsDTO.setDestSeatCode(destSeatCode);
        terminalParamsDTO.setTerminalCode(terminalCode);
        if(srcSeatCode==null || srcOrderCode.isEmpty()){

        }
        AjaxJson ajaxJson = terminalServerOrderApplyService.changeSeat(terminalParamsDTO);
        return ajaxJson;
    }
    @Override
    @RequestMapping(params = "mergeListSeat")
    @ResponseBody
    public AjaxJson mergeListSeat(String srcSeatCode, String srcOrderCode, String destSeatCode, String destOrderCode, String terminalCode) {
        TerminalParamsDTO terminalParamsDTO = new TerminalParamsDTO();
        terminalParamsDTO.setDestSeatCode(destSeatCode);
        terminalParamsDTO.setDestOrderCode(destOrderCode);
        terminalParamsDTO.setSrcSeatCode(srcSeatCode);
        terminalParamsDTO.setSrcOrderCode(srcOrderCode);
        terminalParamsDTO.setTerminalCode(terminalCode);
        return terminalServerOrderApplyService.mergeListSeat(terminalParamsDTO);
    }

    @Override
    @RequestMapping(params = "cancel")
    @ResponseBody
    public AjaxJson cancel(String seatCode, String orderCode, String terminalCode) {
        return terminalServerOrderApplyService.cancel(seatCode,orderCode,terminalCode);
    }

    @Override
    @RequestMapping(params = "updateServerorder")
    @ResponseBody
    public AjaxJson updateServerorder(String seatCode, String orderCode, Integer personNumber, String waiterCode, String terminalCode) {
        TerminalParamsDTO terminalParamsDTO = new TerminalParamsDTO();
        terminalParamsDTO.setSeatCode(seatCode);
        terminalParamsDTO.setOrderCode(orderCode);
        terminalParamsDTO.setPersonNumber(personNumber);
        terminalParamsDTO.setTerminalCode(terminalCode);
        terminalParamsDTO.setWaiterCode(waiterCode);
        return terminalServerOrderApplyService.updateServerorder(terminalParamsDTO);
    }

    @Override
    @RequestMapping(params = "orderFood")
    @ResponseBody
    public AjaxJson orderFood(String foodOrderParamsDTOString) {
        return terminalServerOrderApplyService.orderFood(foodOrderParamsDTOString);
    }

    @Override
    @RequestMapping(params = "refundFood")
    @ResponseBody
    public AjaxJson refundFood(String foodOrderParamsDTOJson) {
//        return terminalServerOrderApplyService.refundFood(foodOrderParamsDTOJson);
    	AjaxJson json = new AjaxJson();
    	json.setMsg("无退菜权限，请通过收银台退菜！");
    	json.setSuccess(false);
    	return json;
    	
    }

    @Override
    @RequestMapping(params = "UrgeFood")
    @ResponseBody
    public AjaxJson UrgeFood(String foodOrderParamsDTOJson) {
        return terminalServerOrderApplyService.UrgeFood(foodOrderParamsDTOJson);
    }

    @Override
    @RequestMapping(params = "UrgeAllFood")
    @ResponseBody
    public AjaxJson UrgeAllFood(String foodOrderParamsDTOJson) {
        return terminalServerOrderApplyService.UrgeAllFood(foodOrderParamsDTOJson);
    }
    @Override
    @RequestMapping(params = "finishFood")
    @ResponseBody
    public AjaxJson finishFood(String foodOrderParamsDTOJson) {
        return terminalServerOrderApplyService.finishFood(foodOrderParamsDTOJson);
    }

    @Override
    @RequestMapping(params = "giftFood")
    @ResponseBody
    public AjaxJson giftFood(String foodOrderParamsDTOJson) {
        return terminalServerOrderApplyService.giftFood(foodOrderParamsDTOJson);
    }

    @Override
    @RequestMapping(params = "getFreeSeat")
    @ResponseBody
    public AjaxJson getFreeSeat(String terminalCode) {
        return terminalServerOrderApplyService.getFreeSeat(terminalCode);
    }

    @Override
    @RequestMapping(params = "getFreeSeatBySeatType")
    @ResponseBody
    public AjaxJson getFreeSeatBySeatType(String terminalCode, String seatTypeCode) {
        return terminalServerOrderApplyService.getFreeSeatBySeatType(terminalCode,seatTypeCode);
    }

    @Override
    @RequestMapping(params = "getFreeSeatBySeatCode")
    @ResponseBody
    public AjaxJson getFreeSeatBySeatCode(String terminalCode, String seatCode) {
        return terminalServerOrderApplyService.getFreeSeatBySeatCode(terminalCode,seatCode);
    }

    @Override
    @RequestMapping(params = "UrgeFoodByType")
    @ResponseBody
    public AjaxJson UrgeFoodByType(String foodOrderParamsDTOJson){
        return terminalServerOrderApplyService.UrgeFoodByType(foodOrderParamsDTOJson);
    }

    @Override
    @RequestMapping(params = "billQuery")
    @ResponseBody
	public AjaxJson billQuery(String seatCode_billNumber) {
		return terminalServerOrderApplyService.billQuery(seatCode_billNumber);
	}
    
    @Override
    @RequestMapping(params = "reserveMessage")
    @ResponseBody
	public AjaxJson reserveMessage() {
		return terminalServerOrderApplyService.reserveMessage();
	}

	@Override
	@RequestMapping(params = "reserveMessageSeatCode")
    @ResponseBody
	public AjaxJson reserveMessageSeatCode(String seatCode) {
		return terminalServerOrderApplyService.reserveMessageSeatCode(seatCode);
	}
	
	@Override
	@RequestMapping(params = "machineLogin")
	@ResponseBody
	public AjaxJson machineLogin(String deviceNumber,String jobNumber,String pwd){
		 AjaxJson aj = new AjaxJson();
		 int result = 0;
		 String name = "";
		 try{
			 //根据工号获得用户实体
			 TSUser u = maroMachineNumberService.getByOrgIdEmpNo(jobNumber);
			 if(u != null){
				 //检查用户是否存在 (验证登录)
				 u.setPassword(pwd);
				 TSUser user = userService.checkUserExits(u);
				 if(user != null){
					 
					 Integer count = maroMachineNumberService.ifIsOrderMachine(deviceNumber);
					 if(count>0){
						 //把用户与点菜机绑定在一起
						 maroMachineNumberService.updateMachineNumber(deviceNumber,user.getId());
					 }else{
						 MaroMachineNumberEntity entity = new MaroMachineNumberEntity();
						 entity.setCreateDate(new Date());
						 entity.setDeviceNumber(deviceNumber);
						 entity.setUserid(user.getId());
						 entity.setJobNumber(jobNumber);
						 maroMachineNumberService.save(entity);
					 }
					 
					 result = 1;
					 name = user.getRealName();
				 }else{
					 result = 0;
				 }
			 }else{
				 result = 0;
			 }
			 
			 //String json = "\"result\": "+ result +",\"name\": \""+ name +"\"";
			 Map map = new HashMap();
			 map.put("result", result);
			 map.put("name", name);
			 aj.setObj(map);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return aj;
	}
	
	@Override
	@RequestMapping(params = "changePassword")
	@ResponseBody
	public AjaxJson changePassword(String deviceNumber,String pwd,String pwds){
		 AjaxJson aj = new AjaxJson();
		 try{	
			 if(pwd.equals(pwds)){
				Integer i = maroMachineNumberService.updateUserPwd(deviceNumber,pwd);
				if(i == 1){
					aj.setMsg("1");
				}else{
					aj.setMsg("0");
				}
			 }else{
				 aj.setMsg("0");
			 }
		 }catch(Exception e){
			 aj.setMsg("0");
		 }
		 return aj;
	}
	
	/**
	 * 操作员登录
	 */
	@Override
	@RequestMapping(params = "operatorLogin")
	@ResponseBody
	public AjaxJson operatorLogin(String jobNumber,String pwd){
		 AjaxJson aj = new AjaxJson();
		 try{
			 //根据工号获得用户实体
			 TSUser u = maroMachineNumberService.getByOrgIdEmpNo(jobNumber);
			 if(u != null){
				 //检查用户是否存在 
				 u.setPassword(pwd);
				 TSUser user = userService.checkUserExits(u);
				 if(user != null){
					 //判断是不是操作员
					 Integer n = maroMachineNumberService.ifIsOperator(user.getId());
					 if(n!=0){
						 aj.setMsg("1");
					 }else{
						 aj.setMsg("0"); 
					 }
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
}
