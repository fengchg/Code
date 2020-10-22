package com.maro.client.module.reserve.controller.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.reserve.apply.MaroClientReserveApplyService;
import com.maro.client.module.reserve.controller.MaroClientReserveController;
import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.dto.ReserveResultDTO;
import com.maro.platform.core.common.model.json.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
/**
 * 预定模块控制器实现类
 * @author 冯成果
 * @date 2018-4-14
 * @since 版本号（必填）
*/
@Controller
@RequestMapping("/maroClientReserveControllerImpl")
public class MaroClientReserveControllerImpl implements MaroClientReserveController {

    @Resource
    private MaroClientReserveApplyService maroClientReserveApplyService;

    @Override
    @RequestMapping(params = "reserve")
    @ResponseBody
    public AjaxJson reserve(ReserveParamsDTO reserveParamsDTO) {
        AjaxJson ajaxJson = maroClientReserveApplyService.reserve(reserveParamsDTO);
        return ajaxJson;
    }

    @Override
    public AjaxJson listReserveBySeatId(String seatId) {
        ReserveResultDTO reserveResultDTO = maroClientReserveApplyService.listReserveBySeatId(seatId);
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setObj(reserveResultDTO);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }
    @Override
    @RequestMapping(params = "cancelReserve")
    @ResponseBody
    public AjaxJson cancelReserve(String reserveId){
        Boolean success = maroClientReserveApplyService.cancelReserve(reserveId);
        AjaxJson ajaxJson = PojoUtil.createAjaxJson(success, null);
        return ajaxJson;
    }
}
