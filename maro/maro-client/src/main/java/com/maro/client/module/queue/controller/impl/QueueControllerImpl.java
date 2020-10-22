package com.maro.client.module.queue.controller.impl;

import com.maro.client.module.queue.controller.QueueController;
import com.maro.client.module.queue.service.QueueService;
import com.maro.platform.core.common.model.json.AjaxJson;

import javax.annotation.Resource;

public class QueueControllerImpl implements QueueController {
    @Resource
    private QueueService queueService;
    final static String QUEUE_PHONE_NOTNULL = "手机号码不能为空";
    @Override
    public AjaxJson queue(Integer seatGroupType,Integer seatType, String phone){
        AjaxJson ajaxJson = new AjaxJson();
        if(phone == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(QUEUE_PHONE_NOTNULL);
        }else {
            ajaxJson = queueService.queue(seatGroupType, seatType, phone);
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson callNum(Integer seatGroupType,Integer seatType){
        AjaxJson ajaxJson = queueService.callNum(seatGroupType, seatType);
        return ajaxJson;
    }
}
