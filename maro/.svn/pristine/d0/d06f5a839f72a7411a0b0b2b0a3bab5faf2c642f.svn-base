package com.maro.client.module.reserve.service.impl;

import com.maro.client.common.constant.enumconstant.CommonTypeEnum;
import com.maro.client.common.constant.enumconstant.ReserveStatusEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveSeatDO;
import com.maro.client.module.reserve.service.MaroClientReserveSeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

/**
 * 预定桌位记录操作接口实现类
 * @author 冯成果
 * @date 2018-4-14
 * @since 版本号（必填）
*/
@Service
public class MaroClientReserveSeatServiceImpl implements MaroClientReserveSeatService {


    final String SQL_UPDATE_STATUS = "update maro_client_reserve_seat set type = ? where reserve_id = ?";

    @Resource
    private ClientCommonDao dao;
    @Override
    public MaroClientReserveSeatDO save(ReserveParamsDTO reserveParamsDTO) {
        MaroClientReserveSeatDO maroClientReserveSeatDO = new MaroClientReserveSeatDO();
        maroClientReserveSeatDO.setId(UUID.randomUUID().toString());
        maroClientReserveSeatDO.setDeleteFlag(CommonTypeEnum.DELETE_FLAG_NO.getCode());
        maroClientReserveSeatDO.setReserveId(reserveParamsDTO.getMaroClientReserveDO().getId());
        maroClientReserveSeatDO.setName(ReserveStatusEnum.ORDER.getName());
        maroClientReserveSeatDO.setType(ReserveStatusEnum.ORDER.getCode());
        maroClientReserveSeatDO.setHappenTime(reserveParamsDTO.getDate());
        maroClientReserveSeatDO.setDestSeatCode(reserveParamsDTO.getMaroShopSeatEntity().getId());
        maroClientReserveSeatDO.setDestSeatId(reserveParamsDTO.getMaroShopSeatEntity().getId());
        maroClientReserveSeatDO.setDestSeatName(reserveParamsDTO.getMaroShopSeatEntity().getName());
        Serializable id = dao.save(maroClientReserveSeatDO);
        if(id == null){
            return null;
        }
        return maroClientReserveSeatDO;
    }

    @Override
    public void cancelReserve(String reserveId){
        dao.executeUpdateSql(SQL_UPDATE_STATUS,ReserveStatusEnum.CANCEL.getCode(),reserveId);
    }

    @Override
    public void open(String reserveId) {
        dao.executeUpdateSql(SQL_UPDATE_STATUS,ReserveStatusEnum.OPEN.getCode(),reserveId);
    }
}
