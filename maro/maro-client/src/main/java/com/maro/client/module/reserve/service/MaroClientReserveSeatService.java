package com.maro.client.module.reserve.service;

import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveSeatDO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;

/**
 * 预定桌位记录操作接口
 * @author 冯成果
 * @date 2018-4-14
 * @since 01.00.0001
 */
public interface MaroClientReserveSeatService {

    /**
     * 预定餐桌
     * @param reserveParamsDTO：预定餐桌传输参数，包括预定的餐桌主键、预定人、预定手机号码、预定日期等等
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    public MaroClientReserveSeatDO save(ReserveParamsDTO reserveParamsDTO);

    /**
     * 取消预订
     * @param reserveId：预定记录主键
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    void cancelReserve(String reserveId);
    /**
     * 预定开台
     * @param reserveId：预定记录主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @descriptions 由【冯成果】于【2018-4-14】进行添加
     */
    void open(String reserveId);
}
