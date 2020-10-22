package com.maro.client.module.serverorder.apply;

import com.maro.client.module.serverorder.pojo.dto.TerminalParamsDTO;
import com.maro.platform.core.common.model.json.AjaxJson;

public interface TerminalServerOrderApplyService {

    public AjaxJson open(TerminalParamsDTO terminalParamsDTO);


    /**
     * 撤台
     * 被撤台号+账单流水号，点菜机号，返回信息提示
     */
    public AjaxJson cancel(String seatCode,String orderCode,String terminalCode) ;

    AjaxJson changeSeat(TerminalParamsDTO terminalParamsDTO);

    AjaxJson updateServerorder(TerminalParamsDTO terminalParamsDTO);

    AjaxJson mergeListSeat(TerminalParamsDTO terminalParamsDTO);

    AjaxJson orderFood(String foodOrderParamsDTOString);

    AjaxJson refundFood(String foodOrderParamsDTOJson);

    AjaxJson UrgeFood(String foodOrderParamsDTOJson);

    AjaxJson UrgeAllFood(String foodOrderParamsDTOJson);

    AjaxJson finishFood(String foodOrderParamsDTOJson);

    AjaxJson UrgeFoodByType(String foodOrderParamsDTOJson);

    AjaxJson giftFood(String foodOrderParamsDTOJson);

    AjaxJson listBaseData();
    
    /**
     * 15.账单查询
     */
    AjaxJson billQuery(String seatCode_billNumber);
    /**
     * 19.预定信息汇总
     */
    AjaxJson reserveMessage();
    /**
     * 19.预定信息汇总
     */
    AjaxJson reserveMessageSeatCode(String seatCode);


    AjaxJson getFreeSeat(String terminalCode);

    AjaxJson getFreeSeatBySeatType(String terminalCode, String seatTypeCode);

    AjaxJson getFreeSeatBySeatCode(String terminalCode, String seatCode);

}
