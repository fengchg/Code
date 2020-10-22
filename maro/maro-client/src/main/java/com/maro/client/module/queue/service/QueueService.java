package com.maro.client.module.queue.service;

import com.maro.platform.core.common.model.json.AjaxJson;

public interface QueueService {
    /**
     * 排队
     * @param seatGroupType:座位分组类型
     * @param seatType:座位类型
     * @param phone:手机号码
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 01.00.0001版本 由【冯成果】于【01.00.0001】进行添加
     */
    public AjaxJson queue(Integer seatGroupType,Integer seatType, String phone);
    /**
     * 叫号
     * @param seatGroupType:座位分组类型
     * @param seatType:座位类型
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 01.00.0001版本 由【冯成果】于【01.00.0001】进行添加
     */
    public AjaxJson callNum(Integer seatGroupType,Integer seatType);
}