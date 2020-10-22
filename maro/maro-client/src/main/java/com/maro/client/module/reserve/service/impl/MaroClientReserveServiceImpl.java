package com.maro.client.module.reserve.service.impl;

import com.maro.client.common.constant.enumconstant.ReserveStatusEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.client.module.reserve.pojo.vo.MaroClientReserveVO;
import com.maro.client.module.reserve.service.MaroClientReserveService;
import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.platform.core.util.ResourceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * 预定接口实现类
 * @author 冯成果
 * @date 2018-4-14
 * @since 版本号（必填）
*/
@Service("maroClientReserveServiceImpl1")
public class MaroClientReserveServiceImpl implements MaroClientReserveService {

    final String HQL_LISTRESERVEBYSEATID = "from MaroClientReserveDO where destSeatId = ? and status = ? order by reserveTime asc";

    final String SQL_UPDATE_STATUS = "update maro_client_reserve set status = ? where id = ?";
    @Resource
    private ClientCommonDao dao;

    @Override
    public MaroClientReserveDO save(ReserveParamsDTO reserveParamsDTO) {


        UserInfoVO sessionUser = (UserInfoVO) ResourceUtil.getSessionUser();

        MaroClientReserveDO maroClientReserveDO = new MaroClientReserveDO();


        maroClientReserveDO.setId(UUID.randomUUID().toString());
        maroClientReserveDO.setContent(reserveParamsDTO.getRemarks());
        maroClientReserveDO.setCustomerName(reserveParamsDTO.getName());
        maroClientReserveDO.setPhone(reserveParamsDTO.getPhone());
        maroClientReserveDO.setDeposit(reserveParamsDTO.getDeposit());
        maroClientReserveDO.setPersonNumber(reserveParamsDTO.getTotal());
        maroClientReserveDO.setReserveTime(reserveParamsDTO.getDate());
        maroClientReserveDO.setRestaurantId(sessionUser.getMaroShopEntity().getId());
        maroClientReserveDO.setRestaurantName(sessionUser.getMaroShopEntity().getName());
        maroClientReserveDO.setDestSeatId(reserveParamsDTO.getMaroShopSeatEntity().getId());
        maroClientReserveDO.setDestSeatCode(reserveParamsDTO.getMaroShopSeatEntity().getId());
        maroClientReserveDO.setDestSeatName(reserveParamsDTO.getMaroShopSeatEntity().getName());
        maroClientReserveDO.setType(reserveParamsDTO.getPurpose());
        maroClientReserveDO.setStatus(ReserveStatusEnum.ORDER.getCode());
        maroClientReserveDO.setPeriod(reserveParamsDTO.getPeriod());
        maroClientReserveDO.setPlanComeTime(reserveParamsDTO.getPlanComeTime());
        Integer deposit = maroClientReserveDO.getDeposit();
        if(deposit == null){
            deposit = Integer.valueOf(0);
        }
        maroClientReserveDO.setDeposit(deposit);

        Serializable maroClientReserveDOId = dao.save(maroClientReserveDO);
        if(maroClientReserveDOId != null){
            return maroClientReserveDO;
        }else{
            return null;
        }


    }

    @Override
    public List<MaroClientReserveDO> listReserveBySeatId(String seatId) {
        List<MaroClientReserveDO> list = dao.list(HQL_LISTRESERVEBYSEATID, seatId, ReserveStatusEnum.ORDER.getCode());
        return list;
    }

    @Override
    public void cancelReserve(String reserveId) {
        dao.executeUpdateSql(SQL_UPDATE_STATUS,ReserveStatusEnum.CANCEL.getCode(),reserveId);
    }

    @Override
    public void open(String reserveId) {
        dao.executeUpdateSql(SQL_UPDATE_STATUS,ReserveStatusEnum.OPEN.getCode(),reserveId);
    }

    @Override
    public String getSeatCurrentReserve(String seatId){
        Integer period = MaroClientReserveVO.getNowPeriod();
        final String SQL_GET_GETSEATCURRENTRESERVE = "select id from maro_client_reserve where dest_seat_id = ? and period = ? and status = ?";
        Object result = dao.getObjectBySql(SQL_GET_GETSEATCURRENTRESERVE,seatId,period,ReserveStatusEnum.ORDER.getCode());
        return (String) result;
    }

}
