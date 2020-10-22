package com.maro.client.module.serverorder.controller;

import com.maro.client.module.serverorder.pojo.dto.TerminalParamsDTO;
import com.maro.platform.core.common.model.json.AjaxJson;

public interface TerminalServerorderController {


    public AjaxJson listBaseData();

    /**
     * @param terminalParamsDTO
     * @return
     */
    public AjaxJson open(TerminalParamsDTO terminalParamsDTO);

    /**
     * 原台号+账单流水号，新台号，点菜机号，返回信息提示，成功或失败
     */
    public AjaxJson changeSeat(String srcSeatCode,String srcOrderCode,String destSeatCode,String terminalCode);


    /**
     * 原台号+账单流水号，新台号+账单流水号，点菜机号，返回信息提示，成功或失败。
     */
    public AjaxJson mergeListSeat(String srcSeatCode,String srcOrderCode,String destSeatCode,String destOrderCode,String terminalCode);

    /**
     * 撤台
     * 被撤台号+账单流水号，点菜机号，返回信息提示
     */
    public AjaxJson cancel(String seatCode,String orderCode,String terminalCode) ;


    /**
     * 修改订单信息
     *参数：台号+账单号，客人数量，员工号，点菜机号，返回信息提示，如"0002号修改台号成功",或其他成功失败提示
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson updateServerorder(String seatCode, String orderCode, Integer personNumber,String waiterCode,String terminalCode);


    /**
     * 点餐下单
     * 参数：台号+账单号，整单备注，
     */
    public AjaxJson orderFood(String foodOrderParamsDTOString);


    /**
     参数：台号+账单号，菜品号，数量，只数，退菜理由，点菜机机号，返回操作是否成功，提示语，退菜理由中文描述。
     */
    public AjaxJson refundFood(String foodOrderParamsDTOJson);


    /**
     * 催菜
     * @param foodOrderParamsDTOJson:菜品接口有关的参数数据传输对象JSON字符串。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson UrgeFood(String foodOrderParamsDTOJson);

    /**
     * 整桌催菜
     * @param foodOrderParamsDTOJson:菜品接口有关的参数数据传输对象JSON字符串。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson UrgeAllFood(String foodOrderParamsDTOJson);

    /**
     * 按类别催菜
     * @param foodOrderParamsDTOJson:菜品接口有关的参数数据传输对象JSON字符串。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson UrgeFoodByType(String foodOrderParamsDTOJson);

    /**
     * 划菜
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson finishFood(String foodOrderParamsDTOJson);

    /**
     * 赠菜
     * @param foodOrderParamsDTOJson:菜品接口有关的参数数据传输对象JSON字符串。服务订单DO、桌位信息DO、点餐记录DO列表、点餐记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson giftFood(String foodOrderParamsDTOJson);
    
    /**
	 * 01 点菜宝登录
	 * @param deviceNumber 设备号
	 * @param jobNumber 工号
	 * @param pwd 密码
     */
    public AjaxJson machineLogin(String deviceNumber,String jobNumber,String pwd);
    
    /**
	 * 02 通过点菜宝设备修改密码
	 * pwd 密码
	 * pwds 确认密码
	 * userId 用户id
	 * username 用户帐号
	 */
    public AjaxJson changePassword(String deviceNumber,String pwd,String pwds);
    
    /**
     *  28 操作员登录
     * @param jobNumber
     * @param pwd
     * @return
     */
    public AjaxJson operatorLogin(String jobNumber,String pwd);

    /**
     * 15.账单查询
     * seatCode 台号
     * billNumber 账单号
     */
    public AjaxJson billQuery(String seatCode_billNumber);
    
    /**
     * 19.预定信息汇总
     */
    public AjaxJson reserveMessage();
    
    /**
     * 20.按台号查询预定
     */
    public AjaxJson reserveMessageSeatCode(String seatCode);

    /**
     * 空闲餐台汇总
     * @param terminalCode:点菜机机号(3 位)
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson getFreeSeat(String terminalCode);

    /**
     * 按类别查空闲餐台
     * @param terminalCode:点菜机机号(3 位)
     * @param seatTypeCode:餐台类别号(2 位)
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson getFreeSeatBySeatType(String terminalCode,String seatTypeCode);

    /**
     * 按台号查空闲
     * @param terminalCode:点菜机机号(3 位)
     * @param seatCode:台号(4 位)
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    public AjaxJson getFreeSeatBySeatCode(String terminalCode,String seatCode);
}
